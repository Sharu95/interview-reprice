package main.kotlin

import java.io.File
import kotlin.collections.map

/**
 * Naive approach - iterate each word, and compare all other words
 * Sorted strings for comparison, equality implies anagrams
 */
fun naiveSolution(words: List<String>): Map<String, List<String>> = words.associateWith { current ->
    val currentSorted = current.toCharArray().sorted().joinToString("")
    words.filter {
        val otherSorted = it.toCharArray().sorted()
        currentSorted == otherSorted.joinToString("") && current != it
    }
}.filter { it.value.isNotEmpty() }

fun writeToFile(anagrams: Map<String, List<String>>, file: File) {
    val output = anagrams
        .map { "${it.key} ${it.value.joinToString(" ")}" }
        .joinToString("\n")
    file.writeText(output)
}

fun readFromFile(file: File) = file.readLines().filter(String::isNotEmpty)

fun main() {
    val inputFile = File("eventyr.txt")
    val outputFile = File("anagrams.txt")
    val answerFile = File("answers.txt") // Naive solution for verification

    val words = readFromFile(inputFile)

    /* Native solution*/
    val naiveSolutionAnagrams = naiveSolution(words)
    writeToFile(naiveSolutionAnagrams, answerFile)
}
