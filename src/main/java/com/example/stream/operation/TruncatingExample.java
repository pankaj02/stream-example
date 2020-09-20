package com.example.stream.operation;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Example of truncating a stream
 */
@Slf4j
public class TruncatingExample {

  public static void main(String[] args) {
    List<Book> twoBooks = limit(Catalog.books());
    log.info("Books {}", twoBooks);
  }

  private static List<Book> limit(List<Book> books) {
    return books.stream().skip(2).collect(Collectors.toList());
  }
}
