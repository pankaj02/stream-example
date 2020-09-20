package com.example.stream.collecting;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.stream.Collectors.joining;

@Slf4j
public class Joining {

  public static void main(String[] args) {
    List<Book> books = Catalog.books();
    log.info("Books {}, ", joiningByName(books));
  }

  private static String joiningByName(List<Book> books) {
    return books.stream().map(Book::getName).collect(joining(", "));
  }
}
