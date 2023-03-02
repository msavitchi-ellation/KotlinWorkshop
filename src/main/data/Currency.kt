package data

import functions.calculateAmount
import functions.obtainExchangeRate

enum class Currency(private val rate: Double, val code: String, val callingName: String = "Undefined"){
	EUR(20.0, "EUR", "Euro"),
	USD(18.75, "USD", "US Dollar"),
	UA(0.41, "UA", "Grivna"),
	RON(4.5, "RON", "Romanian Leu"),
	RUB(.24, "RUB", "Russian Ruble"),
	AUD(18.0, "AUD", "Australian Dollar"),
	CAD(21.0, "CAD", "Canadian Dollar"),
	GBP(24.0, "GBP", "British Pound Sterling"),
	TUT(.000021, "another"),
	WEIRD(1.23e3, "NAN");


	fun performCalcWithMessage(amount: Int){
		println("$amount of ${this.callingName} in lei is ${calculateAmount(amount, obtainExchangeRate(this))}")
	}
}