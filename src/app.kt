fun main(args: Array<String>) {

    println(text)

    val b: String? = null//可以为null
    val c: String = "abc"//不可以为null
    val l = b?.length ?: -1//b?是可以为空的变量，如果没有?就有可能出现NPE异常
    val n = c.length
    println(l)
    println(n)

    val s = mutableListOf(1, 2, 3)
    println(s)
    s.swap(0, 1) // 'this' inside 'swap()' will hold the value of 'l'
    println(s)
}

val text = """
    >Tell me and I forget.
    >Teach me and I remember.
    >Involve me and I learn.
    >(Benjamin Franklin)
    """.trimMargin(">")//前缀是">"的是这一行的开头，默认"|"是前缀

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    this.removeAt(index1)
    this.removeAt(index2)
}



