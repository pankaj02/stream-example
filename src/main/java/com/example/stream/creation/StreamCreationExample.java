package com.example.stream.creation;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Examples of Stream creation */
@Slf4j
public class StreamCreationExample {

  public static void main(String[] args) {

    String[] names = new String[] {"Jack", "Jill"};
    // Stream from array
    Stream<String> arrayStream = Stream.of(names);
    log.info("arrayStream {}", arrayStream.collect(Collectors.toList()));

    Stream<String> arrayStream2 = Arrays.stream(names);
    log.info("arrayStream2 {}", arrayStream2.collect(Collectors.toList()));

    // Stream from collection
    List<String> fruitList = List.of("Apple", "Banana", "Pears");
    Stream<String> fruits = fruitList.stream();
    log.info("Fruits {}", fruits.collect(Collectors.toList()));

    // Stream from a builder
    Stream<String> cars = Stream.<String>builder().add("Honda").add("Toyota").build();
    log.info("Cars {}", cars.collect(Collectors.toList()));

    // Stream from a generator
    Stream<Integer> randomNumber = Stream.generate(new Random()::nextInt).limit(100);
    log.info("Random Numbers {}", randomNumber.collect(Collectors.toList()));

    // Stream from an iterator
    Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(100);
    log.info("Even Numbers {}", evenNumbers.collect(Collectors.toList()));
  }
}
