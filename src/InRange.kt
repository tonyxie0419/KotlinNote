fun main(args: Array<String>) {
    println(checkInRange(MyDate(2015, 3, 15),
            MyDate(2015, 1, 1),
            MyDate(2015, 12, 31)))
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(item: MyDate): Boolean = start <= item && item <= endInclusive
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in DateRange(first, last)
}