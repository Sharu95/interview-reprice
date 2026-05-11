package main.kotlin

import java.io.File

/**
 * Naive approach - iterate each word, and compare all other words
 * Sorted strings for comparison, equality implies anagrams
 */
fun solution1(words: List<String>): List<String> = words.map { current ->
    val currentSorted = current.toCharArray().sorted().joinToString("")
    words.filter {
        currentSorted == it.toCharArray().sorted().joinToString("")
    }.joinToString(" ")
}


fun main() {
    val inputFile = File("eventyr.txt")
    val outputFile = File("anagrams.txt")

    val words = inputFile.readLines().filter(String::isNotEmpty)
    val anagrams = solution1(words)

    outputFile.writeText(anagrams.joinToString("\n"))


}
