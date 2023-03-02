import data.Currency.RUB
import data.Currency.UA
import data.Currency.USD

fun main(args: Array<String>) {
	print("Enter amount: ")
	val amount = 10//readln().toInt()
	USD.performCalcWithMessage(amount)
	UA.performCalcWithMessage(amount)
	RUB.performCalcWithMessage(amount)
}
