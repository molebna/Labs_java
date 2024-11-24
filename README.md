# Car Price Analysis

### Author: Molebna Maria

## Description

This project analyzes car prices to identify outliers based on the interquartile range (IQR). It groups car prices into "data" (normal values) and "outliers" (extreme values).

## Features

- Calculates Q1, Q3, and IQR for car prices.
- Identifies outliers using the formula: `Outliers = Prices < Q1 - 1.5 * IQR` or `Prices > Q3 + 1.5 * IQR`.
- Outputs the count of normal prices and outliers.

## Requirements

- **JDK 22+**
- **Gradle/Maven** (optional)

## How to Build and Run

### Using Command Line

1. Clone the repository:
    ```bash
    git clone https://github.com/molebna/Labs_java.git
    cd Labs_java/Lab1
    ```

2. Compile:
    ```bash
    javac -d bin src/App.java
    ```

3. Run:
    ```bash
    java -cp bin App
    ```

### Using Gradle

1. Clone the repository:
    ```bash
    git clone https://github.com/molebna/Labs_java.git
    cd Labs_java/Lab1
    ```

2. Build and run:
    ```bash
    ./gradlew run
    ```

