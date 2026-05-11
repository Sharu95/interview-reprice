package main.kotlin

import java.io.File


fun main() {
    val words = File("eventyr.txt")
        .readLines()
        .filter(String::isNotEmpty)




}
