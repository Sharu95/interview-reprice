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


/**
 * Improvement on sorting/naive approach - group words by sorted characters, then fold into a map
 * This ensures each anagram group appears only once
 */
fun findAnagrams(words: List<String>): Map<String, List<String>> = words
    .groupBy { it.toCharArray().sorted().joinToString("") }
    .filter { it.value.size > 1 }
    .values
    .fold(mutableMapOf()) { acc, group ->
        acc[group.first()] = group.drop(1)
        acc
    }

fun writeToFile(anagrams: Map<String, List<String>>, file: File) {
    val output = anagrams
        .map { "${it.key} ${it.value.joinToString(" ")}" }
        .joinToString("\n")
    file.writeText(output)
}

fun readFromFile(file: File) = file.readLines().filter(String::isNotEmpty)

fun main() {
    val words = readFromFile(File("data/eventyr.txt"))

    /* Naive solution*/
    // val naiveSolutionAnagrams = naiveSolution(words)
    // writeToFile(naiveSolutionAnagrams, File("anagrams.txt"))

    val anagrams = findAnagrams(words)
    writeToFile(anagrams, File("data/anagrams.txt"))
}
