fun main(args: Array<String>) {

    println(task1(MyAnotherDate(2015,1,1)))

    println(task2(MyAnotherDate(2015,1,1)))
}

operator fun MyAnotherDate.plus(timeInterval: TimeInterval): MyAnotherDate = addTimeIntervals(timeInterval, 1)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

operator fun MyAnotherDate.plus(timeIntervals: RepeatedTimeInterval) =
        addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

fun task1(today: MyAnotherDate): MyAnotherDate {
    return today + TimeInterval.YEAR + TimeInterval.WEEK
}

fun task2(today: MyAnotherDate): MyAnotherDate {
    return today + TimeInterval.YEAR * 2 + TimeInterval.WEEK * 3 + TimeInterval.DAY * 5
}