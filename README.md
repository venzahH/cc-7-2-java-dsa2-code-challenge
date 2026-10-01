# CC 6.2 - Creating Search Engine Code Challenge

[Final DSA Code Challenge](https://www.coursera.org/learn/developer-data-structures-and-algorithms/programming/C57Yp/course-project-creating-a-search-engine)

## Introduction

Digital libraries have transformed how we access and explore vast collections of books, making it easy to search, sort, and find exactly what we need with just a few keystrokes. The basic search engine is at the heart of this and many other modern conveniences.

In this lab, you will create a Java search engine. Your application will allow users to search for a file by name, read and populate objects with data, and sort these objects using algorithms. It will also feature a user-friendly menu, log activities, search data, and serialize objects for storage. By the end, you’ll have hands-on experience with data structures, algorithms, and file I/O in Java while building a functional digital library system.

## Scenario

The digital library system you’ll develop manages a collection of books, with all book data stored in a single file named “books.txt”. Each line in this file represents a book, including its title, author, and publication year; for example:

    The Great Gatsby,F. Scott Fitzgerald,1925

    To Kill a Mockingbird,Harper Lee,1960

    1984,George Orwell,1949

Your search engine program will allow users to search for specific books within this file and view their details. Users should be able to sort the list of books based on various criteria, such as title, author, or publication date. And to provide a seamless user experience, you’ll create a text-based menu-driven interface that facilitates easy navigation through these options.

Additionally, to ensure that user data and interactions are preserved across sessions, you will implement serialization to save the current state of the library to a file named “library.ser.” This will allow the program to restore the library's state the next time it is started. User interactions, such as searches and sorts, will also be logged to a file named “user_interactions.log” for auditing and debugging purposes.

## Goal

Develop a basic Java search engine program that allows users to efficiently search, view, sort, and manage data from files.
