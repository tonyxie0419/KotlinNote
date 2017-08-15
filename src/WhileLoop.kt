fun main(args: Array<String>) {
    println(toJSON(listOf(1, 2, 3, 42, 555)))
}

fun toJSON(collection: Collection<Int>): String {//循环的基本用法
    val sb = StringBuilder()
    sb.append("[")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(",")
        }
    }
    sb.append("]")
    return sb.toString()
}

