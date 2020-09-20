package com.example.stream.model;

import java.util.List;

import static com.example.stream.model.Category.*;

public class Catalog {

  public static List<Book> books() {
    return List.of(
        Book.builder()
            .name("Effective Java")
            .author("Joshua Bloch")
            .category(JAVA)
            .price(44.93)
            .publisher("Pearson")
            .build(),
        Book.builder()
            .name("Java Concurrency in Practice")
            .author("Brian Goetz")
            .category(JAVA)
            .price(32.73)
            .publisher("Addison-Wesley Professional")
            .build(),
        Book.builder()
            .name("Java Performance: The Definitive Guide")
            .author("Scott Oaks")
            .category(JAVA)
            .price(32.99)
            .publisher("O’Reilly")
            .build(),
        Book.builder()
            .name("Learning Python")
            .author("Mark Lutz")
            .category(PYTHON)
            .price(42.59)
            .publisher("O’Reilly")
            .build(),
        Book.builder()
            .name("Fluent Python")
            .author("Luciano Ramalho")
            .category(PYTHON)
            .price(53.88)
            .publisher("O’Reilly")
            .build(),
        Book.builder()
            .name("C# in Depth")
            .author("Jon Skeet")
            .category(C_SHARP)
            .price(53.88)
            .publisher("MANNING")
            .build());
  }
}
