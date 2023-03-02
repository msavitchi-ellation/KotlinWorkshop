package functions

import data.Currency
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun calculateAmount(amount: Int, rate: Double) = amount * rate

fun obtainExchangeRate(currency: Currency): Double {
	val date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
	val url = "https://bnm.md/en/export-official-exchange-rates?date=$date"
	val csv = URL(url).readText().trim()
	val rows = csv.split("\n").map { it.trim() }
	val currencySymbolIndex = rows[2].split(";").indexOf("Abbr")
	val rowIndex = rows.indexOfFirst { it.contains(currency.code, ignoreCase = true) }
	if (rowIndex == -1) throw IllegalArgumentException("Invalid currency codes")

	val currencyRate = rows[2].split(";").indexOf("Rates")
	val currencyMultiplier = rows[2].split(";").indexOf("Rate")
	return rows[rowIndex].split(";")[currencyRate].replace(",", ".").toDouble() / rows[rowIndex].split(";")[currencyMultiplier].toDouble()
}