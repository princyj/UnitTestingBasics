fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

class Sample() {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}

fun isVowelOrConsonant(letter: String): String {
    return when(letter) {
        "a", "e", "i", "o", "u" -> "$letter is a vowel"
        else -> "$letter is a consonant"
    }
}