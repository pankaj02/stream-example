package com.example.stream.operation;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import com.example.stream.model.Category;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class FindingExample {

  public static void main(String[] args) {
    List<Book> books = Catalog.books();
    log.info("Has any Java book {}", hasAnyJavaBook(books));
    log.info("Has all Java book {}", hasAllJavaBook(books));
    log.info("Has no Java book {}", hasNoJavaBook(books));
    log.info("Any Java book {}", findAnyJavaBook(books).orElse(null));
    log.info("Find first Java book {}", findFirstJavaBook(books).orElse(null));
  }

  private static boolean hasAnyJavaBook(List<Book> books) {
    return books.stream().anyMatch(book -> book.getCategory().equals(Category.JAVA));
  }

  private static boolean hasAllJavaBook(List<Book> books) {
    return books.stream().allMatch(book -> book.getCategory().equals(Category.JAVA));
  }

  private static boolean hasNoJavaBook(List<Book> books) {
    return books.stream().noneMatch(book -> book.getCategory().equals(Category.JAVA));
  }

  private static Optional<Book> findAnyJavaBook(List<Book> books) {
    return books.stream().filter(book -> book.getCategory().equals(Category.JAVA)).findAny();
  }

  private static Optional<Book> findFirstJavaBook(List<Book> books) {
    return books.stream().filter(book -> book.getCategory().equals(Category.JAVA)).findFirst();
  }
}
