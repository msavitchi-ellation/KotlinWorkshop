package data

import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CurrencyBNMProvider(private val date: LocalDate) : CurrencyProvider() {

	override val headerOffset = 2
	override var exchanges = returnExchanges(date)

	private fun returnExchanges(date: LocalDate): List<CurrencyModel> {
		val date = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
		val url = "https://bnm.md/en/export-official-exchange-rates?date=$date"
		val rows = URL(url).readText().trim().split("\n")

		val currencySymbolIndex = rows[headerOffset].split(";").indexOf("Abbr")
		val currencyRateIndex = rows[headerOffset].split(";").map { it.trim() }.indexOf("Rates")
		val currencyMultiplierIndex = rows[headerOffset].split(";").indexOf("Rate")
		val internalCodeIndex = rows[headerOffset].split(";").indexOf("Code")

		val csv = mutableListOf<CurrencyModel>()
		for (i in (headerOffset + 1) until rows.size) {
			val parts = rows[i].trim().split(";")
			if (parts.size <= currencySymbolIndex) {
				break // stop processing if line does not have code
			}
			csv.add(CurrencyModel(parts[internalCodeIndex].toShort(), parts[currencySymbolIndex], parts[currencyRateIndex].replace(",", ".").toDouble(), parts[currencyMultiplierIndex].toInt()))
		}
		return csv
	}
}