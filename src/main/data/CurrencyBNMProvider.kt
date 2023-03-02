package data

import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CurrencyBNMProvider(date: LocalDate) {

	private val headerOffset = 2
	private var excanges = returnExchanges(date)
	private val currencySymbolIndex = excanges!![headerOffset].split(";").indexOf("Abbr")
	private val currencyRateIndex = excanges[headerOffset].split(";").indexOf("Rates")
	private val currencyMultiplierIndex = excanges[headerOffset].split(";").indexOf("Rate")
	fun getRate(currency: Currency): Double {
		val rowIndex = excanges.indexOfFirst { it.contains(currency.code, ignoreCase = true) }
		if (rowIndex == -1) throw IllegalArgumentException("Invalid currency codes")
		return excanges[rowIndex].split(";")[currencyRateIndex].replace(",", ".").toDouble() * excanges[rowIndex].split(";")[currencyMultiplierIndex].toDouble()
	}
	private fun returnExchanges(date: LocalDate): List<String>{
		val date = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
		val url = "https://bnm.md/en/export-official-exchange-rates?date=$date"
		val csv = URL(url).readText().trim()
		return csv.split("\n").map { it.trim() }
	}
}