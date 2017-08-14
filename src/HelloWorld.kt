fun main(args: Array<String>) {

    println("Hello World")

    println(start("Hello ", "World"))

    printString("Hello ", "World")
}

fun start(a: String, b: String) = a + b //带返回值的方法

fun printString(a: String, b: String) { //不带返回值的方法
    println("a is $a and b is $b, mix is ${a + b}")
}
