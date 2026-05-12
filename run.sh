#!/bin/zsh

echo "Compiling Main.kt"
kotlinc main/src/Main.kt -include-runtime -d build/main.jar

echo "Running main.jar"
java -jar build/main.jar