import data.Currency.MY_CURRENCY
import data.Currency.UA
import data.Currency.USD

fun main(args: Array<String>) {
	print("Enter amount: ")
	val amount = readln().toInt()
	USD.performCalcWithMessage(amount)
	UA.performCalcWithMessage(amount)
	MY_CURRENCY.performCalcWithMessage(amount)
}
