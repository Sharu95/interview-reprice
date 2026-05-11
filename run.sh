#!/bin/zsh

echo "Compiling Main.kt"
kotlinc main/src/Main.kt -include-runtime -d main.jar

echo "Running main.jar"
java -jar main.jar