package ie.setu.controlflow

import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    println("The max number is: " + maxOf(4, 6));
    printValue(3)
    printRange(5)
    printExpressionResult(12, "12")
    printInferredType(4)
    printAnimal("Guinea pig")
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
    forEachStandard()
    forEachIndices()
    forEachWithIndex()
    whileWithList()
    doWhileExample()
    workingWithStrings()
    workingWithTemplates()
    nullSafety()


}

//if as an expression
fun maxOf(a: Int, b: Int) =
    if (a > b) {
        print("a is greater than b.  ")
        a
    }else {
        print("b is greater than a.  ")
        b
    }

//when construct
fun printValue(value : Int) = when(value) {
    1 -> "The value is One"
    2 -> "The value is Two"
    in 3..5 -> "The value is between Three and Five"
    6, 7, 8 -> "The value is either Six, Seven or Eight"
    else -> "The value is: $value"
}


fun printRange(value: Int){
    when(value){
        in 1..10 -> println ("Between 1..10");
        !in 10..20 -> println ("Outside 10..20")
    }
}
fun printExpressionResult(numberValue: Int, stringValue: String): String {
    return when (numberValue) {
        parseInt(stringValue) -> "stringValue holds the same number as numberValue"
        else -> "stringValue is not the same number as numberValue"
    }
}
fun printInferredType(numberValue: Any){
    when(numberValue){
        is Int -> println ("The inferred type is Int")
        !is Int -> println("The inferred type is NOT Int")
    }
}
fun printAnimal(aString: String) = when {
    aString == "Dog" -> "A dog"
    aString == "Cat" -> "A cat"
    aString.contains("pig") -> "A pig of some sort"
    aString.isEmpty() -> "Empty String..no Animal"
    else -> {
        "No identifiable animal"
    }
}
fun describe(obj: Any) =  when (obj){
    1 -> "One"
    "Hello" -> "A Greeting"
    is Long -> "Long Var"
    !is String -> "Not a String"
    else -> "Unknown"
}
fun forEachStandard(){
    val items = listOf("apple", "banana", "kiwi")
    for (item in items){
        println("Item is: $item")
    }
}
fun forEachIndices(){
    val items = listOf("apple", "banana", "kiwi")
    for (index in items.indices){
        println("Item at " + index + " is: " + items[index])
    }
}
fun forEachWithIndex(){
    val items = listOf("apple", "banana", "kiwi")
    for ((index, value) in items.withIndex()){
        println("The item at " + index + " is: " + value)
    }
}
fun whileWithList(){
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size){
        println ("Item at index: " + index + " is: " +  items[index])
        index++
    }
}
fun doWhileExample(){
    var index = 0
    do {
        println("Do While Index is: " + index)
        index++
    } while (index < 5)
}
fun workingWithStrings(){
    val aString = "An escaped string!\n"
    print(aString)

    val einstein = """
        Learn from yesterday
        Live for today
        Hope for tomorrow
        The important thing
        is not to stop questioning.
        (Albert Einstein)
    """.trimIndent()
    println(einstein)

    val franklin = """
          |Tell me and I forget.
          |Teach me and I remember.
          |Involve me and I learn.
          |  (Benjamin Franklin)
    """.trimMargin()
    println(franklin)
}
fun workingWithTemplates(){
    var firstString = "This is a String"
    var secondString = "and this is another String"

    //using simple names
    println ("Simple names: $firstString $secondString")

    //using arbitrary expressions in {}
    println("Expressions (cases): ${firstString.uppercase()} ${secondString.lowercase()}")
    println("Expressions (string size): first string is ${firstString.length}")
    println("Expressions (substring): ${firstString.substring(0,2)}")
}
fun nullSafety() {
    var aString :String? = "abc"
    val size = aString?.length ?: -1
    aString = null
}