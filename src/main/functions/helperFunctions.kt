package functions

import data.Currency
import data.CurrencyBNMProvider
import data.CurrencyLocalProvider
import java.time.LocalDate.now

private val currencyProvider = CurrencyBNMProvider(now())
private val localCurrencyProvider = CurrencyLocalProvider()

fun calculateAmount(amount: Int, rate: Double) = amount * rate

fun obtainExchangeRate(currency: Currency): Double {
	val rate =
		try {
			currencyProvider.getRate(currency)
		} catch (e: IllegalArgumentException) {
			localCurrencyProvider.getRate(currency)
		}
	return rate
}