import data.Currency.UA
import data.Currency.USD
import data.Currency.WEIRD

fun main(args: Array<String>) {
	print("Enter amount: ")
	val amount = readln().toInt()
	USD.performCalcWithMessage(amount)
	UA.performCalcWithMessage(amount)
	WEIRD.performCalcWithMessage(amount)
}


/*
fun main() {
	val exchangeRates = fetchExchangeRates()

	print("Enter amount: ")
	val amount = readLine()?.toBigDecimalOrNull()

	if (amount == null) {
		println("Invalid input")
		return
	}

	print("Enter source currency code (${Currency.values().joinToString { it.code }}): ")
	val sourceCurrency = readLine()?.toUpperCase()

	val sourceExchangeRate = exchangeRates[sourceCurrency]

	if (sourceExchangeRate == null) {
		println("Invalid currency code")
		return
	}

	print("Enter target currency code (${Currency.values().joinToString { it.code }}): ")
	val targetCurrency = readLine()?.toUpperCase()

	val targetExchangeRate = exchangeRates[targetCurrency]

	if (targetExchangeRate == null) {
		println("Invalid currency code")
		return
	}

	val targetAmount = (amount / sourceExchangeRate) * targetExchangeRate

	println("Converted amount: ${targetAmount.setScale(2, RoundingMode.HALF_EVEN)} $targetCurrency")
}

fun fetchExchangeRates(): Map<String, BigDecimal> {
	val url = URL("https://bnm.md/export_open.php?cmd=currxml&date=01.03.2023&lang=en")
	val exchangeRates = mutableMapOf<String, BigDecimal>()

	url.openStream().use { stream ->
		stream.bufferedReader().useLines { lines ->
			lines.drop(1).forEach { line ->
				val fields = line.split(",")

				if (fields.size == 5 && fields[2] == "USD") {
					val currency = fields[1]
					val rate = fields[3].toBigDecimalOrNull()

					if (rate != null) {
						exchangeRates[currency] = rate
					}
				}
			}
		}
	}

	exchangeRates["USD"] = BigDecimal.ONE

	return exchangeRates
}
 */


//	val eurToUsdRate = getExchangeRate(Currency.EUR, USD)
//	println("1 EUR = $eurToUsdRate USD")
//
//	val usdToRonRate = getExchangeRate(USD, Currency.RON)
//	println("1 USD = $usdToRonRate RON")
//
//	val ronToRubRate = getExchangeRate(Currency.RON, Currency.RUB)
//	println("1 RON = $ronToRubRate RUB")