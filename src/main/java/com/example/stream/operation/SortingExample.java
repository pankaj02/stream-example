package com.example.stream.operation;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Example of sorting of a stream */
@Slf4j
public class SortingExample {

  public static void main(String[] args) {
    List<Book> sortedBooksByPrice = sort();
    log.info("Books sorted by price {}", sortedBooksByPrice);

    List<Book> lowestTwo = limit(sortedBooksByPrice);
    log.info("Lowest two books sorted by price {}", lowestTwo);
  }

  private static List<Book> limit(List<Book> sortedBooks) {
    return sortedBooks.stream().limit(2).collect(Collectors.toList());
  }

  private static List<Book> sort() {
    List<Book> books = Catalog.books();
    return books.stream().sorted(Comparator.comparing(Book::getPrice)).collect(Collectors.toList());
  }
}
