package com.example.stream.creation;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Example of Fibonacci Series using Stream.generate() */
@Slf4j
public class Fibonacci {
  private int prev = 0;
  private int curr = 1;

  private int next() {
    int temp = prev + curr;
    prev = curr;
    curr = temp;
    return curr;
  }

  public IntStream stream() {
    return IntStream.generate(this::next);
  }

  public static void main(String[] args) {
    IntStream fibonacci = new Fibonacci().stream().limit(10);

    log.info("Fibonacci Series {} ", fibonacci.boxed().collect(Collectors.toList()));
  }
}
