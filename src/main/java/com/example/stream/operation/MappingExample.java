package com.example.stream.operation;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Example of mapping operation of Stream
 */
@Slf4j
public class MappingExample {

  public static void main(String[] args) {
    List<Book> books = Catalog.books();

    log.info("All Authors {}", authors(books));
    log.info("Total Price {}", prices(books).sum());

    List<Double> prices = box(prices(books)).collect(Collectors.toList());
    log.info("All Price {}", prices);
  }

  /** A stream of type T can be transformed to stream of type R by applying a function T -> R */
  private static List<String> authors(List<Book> books) {
    return books.stream().map(Book::getAuthor).collect(Collectors.toList());
  }

  /**
   * A Stream can be mapped to primitive specialization by calling mapTo** (mapToDouble, mapToInt,
   * mapToLong) function
   */
  private static DoubleStream prices(List<Book> books) {
    return books.stream().mapToDouble(Book::getPrice);
  }

  /**
   * Stream of primitive type can be boxed to object type by calling function.
   */

  private static Stream<Double> box(DoubleStream doubleStream) {
    return doubleStream.boxed();
  }
}
