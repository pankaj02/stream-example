package com.example.stream.collecting;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import com.example.stream.model.Category;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Slf4j
public class Grouping {
  public static void main(String[] args) {
    List<Book> books = Catalog.books();
    log.info("Grouped by category {}, ", groupByCategory(books));
  }

  private static Map<Category, List<String>> groupByCategory(List<Book> books) {
    return books.stream().collect(groupingBy(Book::getCategory, mapping(Book::getName, toList())));
  }
}
