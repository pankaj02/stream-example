package com.example.stream.operation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/** Example of reducing operation of Stream */
@Slf4j
public class ReducingExample {

  public static void main(String[] args) {
    log.info("Total Price {}", sum());
    minMax();
  }

  private static double sum() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    return numbers.stream().reduce(0, Integer::sum);
  }

  private static void minMax() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    Optional<Integer> min = numbers.stream().reduce(Integer::min);
    Optional<Integer> max = numbers.stream().reduce(Integer::max);

    log.info("Min {}, Max {}", min.get(), max.get());
  }
}
