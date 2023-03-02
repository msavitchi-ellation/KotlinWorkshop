package data

import java.io.File

class CurrencyLocalProvider : CurrencyProvider() {

	override val headerOffset = 2
	override var exchanges = returnExchanges()
	private fun returnExchanges(): List<CurrencyModel> {
		val csvFile = File("src/main/resources/LocalCurrency.csv")
		val csvLines = csvFile.readLines().drop(1)
		return csvLines.map { line ->
			val parts = line.split(";")
			CurrencyModel(parts[0].toShort(), parts[1], parts[2].toDouble(), 1)
		}
	}
}