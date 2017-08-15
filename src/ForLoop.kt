import java.util.*

fun main(args: Array<String>) {
    val actualDateRange = arrayListOf<MyAnotherDate>()
    iterateOverDateRange(MyAnotherDate(2015,3,15),MyAnotherDate(2015,3,16),{
        myAnotherDate -> actualDateRange.add(myAnotherDate)
    })
    println(actualDateRange.size)
}

class DateForRange(val start: MyAnotherDate, val end: MyAnotherDate) : Iterable<MyAnotherDate> {
    override fun iterator(): Iterator<MyAnotherDate> = DateIterator(this)
}

class DateIterator(val dateRange: DateForRange) : Iterator<MyAnotherDate> {
    var current: MyAnotherDate = dateRange.start
    override fun next(): MyAnotherDate {
        val result = current
        current = current.nextDay()
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.end
}

fun iterateOverDateRange(firstDate: MyAnotherDate, secondDate: MyAnotherDate, handler: (MyAnotherDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}

operator fun MyAnotherDate.rangeTo(other:MyAnotherDate) = DateForRange(this,other)

fun MyAnotherDate.nextDay() = addTimeIntervals(TimeInterval.DAY, 1)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

fun MyAnotherDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyAnotherDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when (timeInterval) {
        TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, number)
        TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
        TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
    }
    return MyAnotherDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}

data class MyAnotherDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyAnotherDate> {
    override fun compareTo(other: MyAnotherDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}