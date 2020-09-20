package com.example.stream.creation;

import com.example.stream.model.Book;
import com.example.stream.model.Catalog;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.stream.*;

/** Examples of specialized primitive stream */
@Slf4j
public class PrimitiveStreamExample {

  public static void main(String[] args) {
    IntStream intOne = IntStream.of(1);
    log.info("intOne {}", intOne.boxed().collect(Collectors.toList()));

    IntStream intOneTwo = IntStream.of(1, 2);
    log.info("intOneTwo {}", intOneTwo.boxed().collect(Collectors.toList()));

    DoubleStream doubleOne = DoubleStream.of(1);
    log.info("doubleOne {}", doubleOne.boxed().collect(Collectors.toList()));

    LongStream longOneTwo = LongStream.of(1, 2);
    log.info("longOneTwo {}", longOneTwo.boxed().collect(Collectors.toList()));

    IntStream oneToNine = IntStream.range(1, 10);
    log.info("oneToNine {}", oneToNine.boxed().collect(Collectors.toList()));

    IntStream oneToTen = IntStream.range(1, 10);
    log.info("oneToTen {}", oneToTen.boxed().collect(Collectors.toList()));

    IntStream tenOnes = IntStream.generate(() -> 1).limit(10);
    log.info("tenOnes {}", tenOnes.boxed().collect(Collectors.toList()));

    DoubleStream tenRandomDouble = DoubleStream.generate(() -> new Random().nextDouble()).limit(10);
    log.info("tenRandomDouble {}", tenRandomDouble.boxed().collect(Collectors.toList()));

    IntStream evenNumbers = IntStream.iterate(0, n -> n + 2).limit(10);
    log.info("evenNumbers {}", evenNumbers.boxed().collect(Collectors.toList()));

    IntStream oneTwo = IntStream.builder().add(1).add(2).build();
    log.info("oneTwo {}", oneTwo.boxed().collect(Collectors.toList()));

    Stream<Integer> primeNo = Stream.concat(Stream.of(2, 3), Stream.of(5, 7, 11));
    log.info("primeNo {}", primeNo.collect(Collectors.toList()));

    long count = evenNumbers.count();
    log.info("Count {}", count);

    List<Book> books = Catalog.books();
    log.info("Price of all books of catalog {}", priceOfAllBooksBoxed(books));
    log.info("Price of all books of catalog {}", priceOfAllBooks(books));
  }

  private static double priceOfAllBooksBoxed(List<Book> books) {
    return books.stream().map(Book::getPrice).reduce(0d, Double::sum);
  }

  private static double priceOfAllBooks(List<Book> books) {
    return books.stream().mapToDouble(Book::getPrice).sum();
  }
}
