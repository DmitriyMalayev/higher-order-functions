import java.util.*

// Higher Order Functions
// Functions can be passed to other functions.
// Functions can be returned from functions


fun printCalculatedValue(value1: Int, value2: Int, calculator: (Int, Int) -> Int) {
    println("Calculated value is ${calculator(value1, value2)}")
}

fun printFormattedName(firstName: String, lastName: String, formatName: (String, String) -> String) {
    println(formatName(firstName, lastName))
}

val fancyFormatter: (String, String) -> String = {firstName, lastName -> "My first name is $firstName and my last " +
        "name is $lastName"}
fun main() {
    printCalculatedValue(2, 2) { value1, value2 -> value1 + value2 }
    printCalculatedValue(2, 2) { value1, value2 -> value1 - value2 }
    printFormattedName("dmitriy", "malayev") { firstName, lastName -> "The first letter of the first name and last " +
            "name are capitalized: \n" +
        firstName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } + "" +
                " " + lastName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    }
    printFormattedName("dmitriy", "malayev") { firstName, lastName ->
        "All of the letters are capitalized: \n" + firstName.uppercase() + " " + lastName.uppercase()
    }
    printFormattedName("dmitriy", "malayev", fancyFormatter)
}