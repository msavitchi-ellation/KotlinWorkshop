package data

import functions.calculateAmount
import functions.obtainExchangeRate

enum class Currency(val code: String, val callingName: String = "Undefined"){
	EUR("EUR", "Euro"),
	USD( "USD", "US Dollar"),
	UA( "UA", "Grivna"),
	RON( "RON", "Romanian Leu"),
	RUB( "RUB", "Russian Ruble");

	fun performCalcWithMessage(amount: Int){
		println("$amount of ${this.callingName} in lei is ${calculateAmount(amount, obtainExchangeRate(this))}")
	}
}