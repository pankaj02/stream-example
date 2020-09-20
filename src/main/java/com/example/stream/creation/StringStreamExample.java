package com.example.stream.creation;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** String stream creation example */
@Slf4j
public class StringStreamExample {

  public static void main(String[] args) {
    log.info("Lines {}", lines().collect(Collectors.toList()));
    log.info("Chars {}", chars().boxed().collect(Collectors.toList()));
  }

  private static Stream<String> lines() {
    return "Line separated by newline.\nAnother line.".lines();
  }

  private static IntStream chars() {
    return "XYZ".chars();
  }
}
