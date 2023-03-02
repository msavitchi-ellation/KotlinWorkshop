package data

open abstract class CurrencyProvider {

	protected open val headerOffset: Int = 0
	protected open val exchanges: List<CurrencyModel> = listOf()
	open fun getRate(currency: Currency): Double {
		val currencyItem = exchanges.find { it.code == currency.code }
			?: throw IllegalArgumentException("Invalid currency code: ${currency.code}")
		return currencyItem.rates / currencyItem.rate
	}
}