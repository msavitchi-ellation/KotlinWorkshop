package functions

import data.Currency
import data.CurrencyProvider
import java.time.LocalDate.now

private val currencyProvider = CurrencyProvider(now())

fun calculateAmount(amount: Int, rate: Double) = amount * rate

fun obtainExchangeRate(currency: Currency): Double {
	return currencyProvider.getRate(currency)
}