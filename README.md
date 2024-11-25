# Annotation and Code Generation in Java

### Author: Molebna Maria

## Description

This project implements a framework for generating SQL queries (Create, Read, Update, Delete) for arbitrary objects in Java, utilizing a mapping of object fields to database columns. It avoids reflection to maintain high performance and provides a type-safe and extensible solution for SQL generation.

## Features

- Field-to-Column Mapping: Allows manual mapping of object fields to database table columns.
- Type-Safe SQL Generation: Supports automatic handling of text and numeric fields for proper SQL formatting.
- Customizable Generators: Easily extendable for different domain classes (e.g., User, Cat, Product).
- Manual Implementation: Avoids reflection for better performance and clarity.
- Demonstration Classes: Includes three distinct example classes to showcase CRUD operations.

## Requirements

- **JDK 11+**
- **Gradle/Maven** (optional)

## How to Build and Run

### Using Command Line

1. Clone the repository:
    ```bash
    git clone https://github.com/molebna/Labs_java.git
    cd Labs_java/Lab3
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
    cd Labs_java/Lab3
    ```

2. Build and run:
    ```bash
    ./gradlew run
    ```
