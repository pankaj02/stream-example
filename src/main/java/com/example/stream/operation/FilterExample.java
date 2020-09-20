package com.example.stream.operation;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.example.stream.model.Category.JAVA;

/** Stream filtering example */
@Slf4j
public class FilterExample {
  public static void main(String[] args) {
    filterByCategory();
    filterLambda();
    lessThan();
    unique();
  }

  private static void filterLambda() {
    List<Book> javaBook = filter(book -> book.getCategory().equals(JAVA));
    log.info("Java Books {}", javaBook);
    List<Book> joshuaBlochBook = filter(book -> book.getAuthor().equals("Joshua Bloch"));
    log.info("Books by Joshua Bloch {}", joshuaBlochBook);
  }

  private static void filterByCategory() {
    List<Book> books = Catalog.books();
    List<String> javaAuthors =
        books.stream()
            .filter(book -> book.getCategory().equals(JAVA))
            .map(Book::getAuthor)
            .collect(Collectors.toList());
    log.info("Java Books Catalog {}", javaAuthors);
  }

  public static List<Book> filter(Predicate<Book> where) {
    List<Book> books = Catalog.books();
    return books.stream().filter(where).collect(Collectors.toList());
  }

  private static void unique() {
    List<Book> books = Catalog.books();
    List<String> uniquePublisher =
        books.stream().map(Book::getPublisher).distinct().collect(Collectors.toList());
    log.info("Unique Publisher {}", uniquePublisher);
  }

  private static void lessThan() {
    List<Book> books = Catalog.books();
    List<Book> lessThan42 =
        books.stream().filter(book -> book.getPrice() < 42).collect(Collectors.toList());

    log.info("Books {}", lessThan42);

    List<Book> priceLessThan42 =
        books.stream().takeWhile(book -> book.getPrice() < 42).collect(Collectors.toList());
    log.info("Books {}", priceLessThan42);
  }
}
