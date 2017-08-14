fun main(args: Array<String>) {
    val first = MyDate(2015, 3, 15)
    val second = MyDate(2015, 3, 15)
    println(first < second)
}

/**
 * 方法继承自接口Comparable
 * 重写其中比较的方法，使其可以比较日期的大小
 * 如果日期前者大于后者，则返回正数
 */
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}