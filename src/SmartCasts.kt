fun main(args: Array<String>) {
    println(eval(Num(2)))
    println(eval(Sum(Num(2), Num(3))))
}

fun eval(expr: Expr): Int = when (expr) {
    is Num -> expr.value
    is Sum -> eval(expr.left) + eval(expr.right)
    else -> throw IllegalAccessException("Unknown expression")
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr