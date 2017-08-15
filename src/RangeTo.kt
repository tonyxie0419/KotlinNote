fun main(args: Array<String>) {
    println(checkInToRange(MyDate(2015, 3, 15),
            MyDate(2015, 1, 1),
            MyDate(2015, 3, 15)))
}

operator fun MyDate.rangeTo(other: MyDate): DateToRange = DateToRange(this, other)

class DateToRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>

fun checkInToRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last
}