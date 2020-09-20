## Java Stream Example
Java 8 introduced concept of **Lambda** and **Streams** to bring functional programming flavor in Java.
### Lambda
A lambda expression can be thought as a concise representation of an _anonymous_ function that can be assigned to a variable and passed to a method, which accepts functional interface as an argument. 
It doesn’t have a name, but it has a list of parameters, a body, a return type. 

`(parameters) -> expression`
### Stream
Streams let us do computation on the collection of data in a declarative way, (rather than specifying how to do, we specify what to do). 
To perform a computation, stream operations are composed into a stream pipeline. 
A stream pipeline consists of a source,  zero or more intermediate operations, and a terminal operation. Streams are lazy; computation on the source data is only performed when the terminal operation is initiated.


```
List<String> javaAuthors =                               
    books.stream()                                       
        .filter(book -> book.getCategory().equals(JAVA)) 
        .map(Book::getAuthor)                            
        .collect(Collectors.toList());
```

### Stream Pipeline
- **_Source_**: 
In Java source of the stream could be an array, a collection, a generator function, an I/O channel, value range, etc. In the above example Stream is created by calling stream() method of the Collection Class, which in turn returns a sequential stream.
- **_Intermediate Operation_**: 
An intermediate operation transform a stream into another stream. The intermediate operation are always lazy; executing an intermediate operation such as filter() does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the initial stream that match the given predicate. Here, we have used filter(Predicate) to filter out books by category and map(Function) to transform stream of Books to stream of Authors.
- **_Terminal Operation_**: 
A terminal operation produces a result or side-effect. After the terminal operation is performed, the stream pipeline is considered consumed, and can no longer be used. Here, collect performs a mutable reduction operation, which accumulates input elements into a mutable result container,  on the elements of this stream using a Collectors.

### More Information
More information on streams can be found at the blog posts:
- [Java Streams: A Comprehensive Guide to Stream Creation with Examples](https://reactivestream.io/2020/java-streams-a-comprehensive-guide-to-stream-creation-with-examples/)
- [Java Streams: A Comprehensive Guide to Stream Operation with Examples](https://reactivestream.io/2020/java-streams-a-comprehensive-guide-to-stream-operation-with-examples/)

