package com.example.stream.collecting;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparingDouble;

@Slf4j
public class Max {

  public static void main(String[] args) {
    List<Book> books = Catalog.books();
    log.info("Max Price {}", maxPrice(books).orElse(null));
  }

  static Optional<Book> maxPrice(List<Book> books) {
    Comparator<Book> comparator = comparingDouble(Book::getPrice);
    return books.stream().max(comparator);
  }
}
