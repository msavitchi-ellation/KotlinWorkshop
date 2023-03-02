package functions

import data.Currency
import data.CurrencyBNMProvider
import java.time.LocalDate.now

private val currencyProvider = CurrencyBNMProvider(now())

fun calculateAmount(amount: Int, rate: Double) = amount * rate

fun obtainExchangeRate(currency: Currency): Double {
	return currencyProvider.getRate(currency)
}