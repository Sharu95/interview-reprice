# Prompts
This file contains the prompts that were used, in the case where LLMs were used.

## Prompt 1
```
Give me a skeleton Main.kt file that reads a text file, splits lines and gives me a list of strings. Structure the project as a Kotlin project, and put a mock data.txt file in the project to be used. Show me your plan before execution
```

## Prompt 2
```
This naive solution for finding anagrams is building a map: fun naiveSolution(words: List<String>): Map<String, List<String>> = words.associateWith { current ->
    val currentSorted = current.toCharArray().sorted().joinToString("")
    words.filter {
        val otherSorted = it.toCharArray().sorted()
        currentSorted == otherSorted.joinToString("") && current != it
    }
}.filter { it.value.isNotEmpty() } - this is the naive solution, and currently, words that are anagrams of each other, 
will come up twice, because we iterate the whole list and do not track anything. Lets look at how we can improve the naive solution, 
by utilizing reduce for the Map result, because that ensures uniqueness, so that we do not get both cases like "denne enden" and "enden denne" 
in the same file, which are technically the same
```