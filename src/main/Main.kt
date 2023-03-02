import data.Currency.RUB
import data.Currency.UA
import data.Currency.USD
import data.CurrencyModel

fun main(args: Array<String>) {
	println(CurrencyModel(1, "NON", 1.3, 10))
	print("Enter amount: ")
	val amount = readln().toInt()
	USD.performCalcWithMessage(amount)
	UA.performCalcWithMessage(amount)
	RUB.performCalcWithMessage(amount)
}
