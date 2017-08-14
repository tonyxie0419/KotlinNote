fun main(args: Array<String>) {
    println(joinOptions(listOf("yes", "no", "may be")))
}

fun joinOptions(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]",separator = "、")
//方法使用的时候可以创建多个参数的方法，可以给参数设定默认值，在使用方法的时候，不改变参数值的就是默认值