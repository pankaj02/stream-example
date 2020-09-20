package com.example.stream.creation;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Nullable Stream Example
 */
@Slf4j
public class NullableStreamExample {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    List<Integer> numbersNull = null;

    log.info("Stream Nullable example {}", toStreamNullable(numbers).collect(Collectors.toList()));
    log.info("Stream Nullable example {}", toStreamNullable(numbersNull).collect(Collectors.toList()));

    log.info("Stream Optional Example {}", toStreamOptional(numbers).collect(Collectors.toList()));
    log.info("Stream Optional Example {}", toStreamOptional(numbersNull).collect(Collectors.toList()));
  }

  private static Stream<Integer> toStreamOptional(Collection<Integer> numbers) {
    return Optional.ofNullable(numbers).stream().flatMap(Collection::stream);
  }

  private static Stream<Integer> toStreamNullable(Collection<Integer> numbers) {
    return Stream.ofNullable(numbers).flatMap(Collection::stream);
  }
}
