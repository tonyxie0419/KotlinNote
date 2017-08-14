fun main(args: Array<String>) {
    val person = getPeople()
    println(person)
}

data class Person(var name: String, var age: Int) {//专门用于存放数值的类
}

fun getPeople(): List<Person> {//创建类的实例不用new
    return listOf(Person("小明", 12), Person("小红", 13))
}
