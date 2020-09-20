package com.example.stream.creation;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/** Random Stream example */
@Slf4j
public class RandomStreamExample {

  public static void main(String[] args) {

    // Infinite Stream
    IntStream randomInts = new Random().ints();
    log.info("Random Ints {}", randomInts.limit(10).boxed().collect(Collectors.toList()));

    // Fixed Size Stream
    IntStream tenRandomInts = new Random().ints(10);
    log.info("Ten Random Ints {}", tenRandomInts.boxed().collect(Collectors.toList()));

    // Infinite Stream
    DoubleStream randomDoubles = new Random().doubles();
    log.info("Random doubles {}", randomDoubles.limit(10).boxed().collect(Collectors.toList()));

    // Fixed Size Stream
    DoubleStream tenRandomDoubles = new Random().doubles(10);
    log.info("Ten Random doubles {}", tenRandomDoubles.boxed().collect(Collectors.toList()));

    // Infinite Stream
    LongStream randomLongs = new Random().longs();
    log.info("Random longs {}", randomLongs.limit(10).boxed().collect(Collectors.toList()));

    // Fixed Size Stream
    LongStream tenRandomLongs = new Random().longs(10);
    log.info("Ten Random longs {}", tenRandomLongs.boxed().collect(Collectors.toList()));
  }
}
