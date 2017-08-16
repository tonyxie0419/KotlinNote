fun main(args: Array<String>) {
    println(isLeapDay(MyDate(2016,2,29)))
}

fun isLeapDay(date: MyDate): Boolean {

    val (year, month, dayOfMonth) = date

    // 29 February of a leap year
    return year % 4 == 0 && month == 2 && dayOfMonth == 29
}