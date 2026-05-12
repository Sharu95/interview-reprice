# Reprice case
Given a list of words in a file, find all one-word 
anagrams for each word, and output them on the same line for each word 
in a new file

## Structure of repo
Very simple main module, no test folder, and with one `Main.kt` file.

## How to run
* Execute/Run in IntelliJ directly
* Compile + execution script in the root of the repo: `sh run.sh` (requires the `kotlinc` and `java` command on your machine)

## Solution

### Naive approach
The most straightforward approach is to loop each word, and check 
all other words if they are anagrams. The condition for checking an anagram 
is to compare the sorted version of two words. If they are the same, we have an anagram.


