# Annotation and reflection in Java

### Author: Molebna Maria

## Description

This project implements a set of operations (Create, Read, Update, Delete) for arbitrary annotated objects using Java. It demonstrates the functionality of these operations using reflection and non-reflection-based approaches.

## Features

- Reflection-based CRUD operations for dynamic object-to-database field mappings.
- Manual CRUD implementation for comparison of reflection performance.
- Time measurement for CRUD operations with and without reflection.

## Requirements

- **JDK 11+**
- **Gradle/Maven** (optional)

## How to Build and Run

### Using Command Line

1. Clone the repository:
    ```bash
    git clone https://github.com/molebna/Labs_java.git
    cd Labs_java/Lab2
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
    cd Labs_java/Lab2
    ```

2. Build and run:
    ```bash
    ./gradlew run
    ```
