# Java Memory Architecture Guide

This guide provides a comprehensive overview of Java's memory architecture, explaining how the Java Virtual Machine (JVM) manages memory. Understanding these concepts is crucial for writing efficient Java applications and troubleshooting memory-related issues.

## Table of Contents

- [Introduction](#introduction)
- [Core Memory Areas](#core-memory-areas)
  - [Heap Memory](#heap-memory)
  - [Stack Memory](#stack-memory)
  - [Method Area (Metaspace)](#method-area-metaspace)
  - [Native Method Stack](#native-method-stack)
  - [Program Counter Register](#program-counter-register)
- [Garbage Collection](#garbage-collection)
- [Common Memory Issues](#common-memory-issues)
- [Memory Tuning](#memory-tuning)
- [Best Practices](#best-practices)
- [Resources](#resources)

## Introduction

Java memory management is handled by the Java Virtual Machine (JVM), which automatically allocates and deallocates memory. Unlike languages like C and C++, Java developers don't need to explicitly allocate and free memory, but understanding how memory works "under the hood" is essential for writing optimized code.

## Core Memory Areas

### Heap Memory

The heap is where all objects are stored during the runtime of a Java application.

```
┌─────────────────────────────────────────┐
│                  HEAP                   │
│                                         │
│  ┌─────────────┐  ┌──────────────────┐  │
│  │  Young Gen  │  │    Old Gen       │  │
│  │ ┌─────────┐ │  │                  │  │
│  │ │  Eden   │ │  │                  │  │
│  │ │ Space   │ │  │                  │  │
│  │ └─────────┘ │  │                  │  │
│  │ ┌─────────┐ │  │                  │  │
│  │ │Survivor │ │  │                  │  │
│  │ │Spaces   │ │  │                  │  │
│  │ └─────────┘ │  │                  │  │
│  └─────────────┘  └──────────────────┘  │
└─────────────────────────────────────────┘
```


**Key Characteristics:**
- Shared across all application threads
- Home to all objects and arrays
- Primary target of garbage collection
- Size can be controlled with `-Xms` and `-Xmx` JVM parameters

**Divisions:**
- **Young Generation**: Where new objects are allocated
  - **Eden Space**: Initial allocation area
  - **Survivor Spaces (S0, S1)**: For objects that survive garbage collection
- **Old Generation (Tenured)**: Long-lived objects that survived multiple GC cycles

**Example:**
```java
// This object is stored in the heap
Person person = new Person("John", 30);

// basics.JArrays are also stored in the heap
int[] numbers = new int[1000];
```


### Stack Memory

Stack memory is organized as thread-specific LIFO (Last-In-First-Out) stacks.

```
┌───────────────────────┐
│  Thread 1 Stack       │
│  ┌─────────────────┐  │
│  │ Method Frame 1  │  │
│  │ - Local Vars    │  │
│  │ - Operand Stack │  │
│  └─────────────────┘  │
│  ┌─────────────────┐  │
│  │ Method Frame 2  │  │
│  └─────────────────┘  │
└───────────────────────┘
```


**Key Characteristics:**
- Each thread has its own stack
- Contains method frames (activation records)
- Stores local variables, partial results, and method call data
- Fixed size (configurable via `-Xss` parameter)
- Not garbage collected

**Example:**
```java
public void calculateSum() {
    // Local primitive variables are stored on the stack
    int a = 5;
    int b = 10;
    int sum = a + b;
    
    // The reference 'text' is on the stack, 
    // but the String object is on the heap
    String text = "The sum is: " + sum;
}
```


### Method Area (Metaspace)

The Method Area stores class structures, methods, and constant pool information.

**Key Characteristics:**
- Shared across all threads
- In Java 8+, implemented as Metaspace (native memory)
- Previously known as PermGen (Permanent Generation) in Java 7 and earlier
- Stores class metadata, method code, static variables, and constants
- Size can be configured with `-XX:MaxMetaspaceSize`

**Example:**
```java
public class Example {
    // Static variables are stored in the Method Area
    static int counter = 0;
    
    // Class constants are stored in the Method Area
    static final String APPLICATION_NAME = "JavaMemoryDemo";
}
```


### Native Method Stack

Supports native methods (methods implemented in languages other than Java).

**Key Characteristics:**
- JVM implementation-dependent
- Used for executing native code via JNI (Java Native Interface)
- Each thread has its own native method stack

### Program Counter Register

Holds the address of the current instruction being executed by the thread.

**Key Characteristics:**
- Each thread has its own PC register
- Contains the address of the current JVM instruction
- For native methods, the value is undefined

## Garbage Collection

Garbage collection is Java's automatic memory management process.

**Key Aspects:**
- **Identification**: Finding objects that are no longer reachable
- **Reclamation**: Freeing memory occupied by unreachable objects
- **Compaction**: Rearranging memory to reduce fragmentation

**Garbage Collector Types:**
- **Serial**: Single-threaded, simple collector
- **Parallel**: Multi-threaded collection, focuses on throughput
- **CMS (Concurrent Mark Sweep)**: Low pause times, concurrent operation
- **G1 (Garbage First)**: Server-style collector, default in Java 9+
- **ZGC/Shenandoah**: Low-latency collectors for very large heaps

**Example of Object Eligibility for GC:**
```java
public void createEligibleObject() {
    // This object becomes eligible for GC when method returns
    StringBuilder builder = new StringBuilder("Temporary");
    builder.append(" String");
    
    // The result is not referenced and immediately eligible for GC
    builder.toString();
}
```


## Common Memory Issues

**OutOfMemoryError: Java heap space**
- Cause: Heap is full, no space for new objects
- Solution: Increase heap size, identify/fix memory leaks

**OutOfMemoryError: Metaspace**
- Cause: Too many classes or class metadata
- Solution: Increase metaspace size, reduce class loading

**StackOverflowError**
- Cause: Stack memory exhaustion, typically from infinite recursion
- Solution: Fix recursive algorithm, increase stack size

**Memory Leaks**
- Cause: Objects remain referenced but unused
- Common sources: Unclosed resources, improper collection handling, static collections
- Detection: Memory profilers, heap dumps

## Memory Tuning

**Common JVM Parameters:**
- `-Xms<size>`: Initial heap size
- `-Xmx<size>`: Maximum heap size
- `-Xss<size>`: Thread stack size
- `-XX:NewRatio=<n>`: Ratio between young and old generations
- `-XX:SurvivorRatio=<n>`: Ratio between eden and survivor spaces
- `-XX:MaxMetaspaceSize=<size>`: Maximum metaspace size
- `-XX:+UseG1GC`: Enable G1 garbage collector
- `-XX:+UseZGC`: Enable Z garbage collector
- `-XX:+UseShenandoahGC`: Enable Shenandoah garbage collector

**Example Configuration:**
```
java -Xms2g -Xmx4g -XX:+UseG1GC -XX:MaxMetaspaceSize=512m MyApplication
```


## Best Practices

1. **Avoid creating unnecessary objects**
```java
// Inefficient - creates many temporary String objects
   String result = "";
   for (int i = 0; i < 100; i++) {
       result += i;
   }
   
   // Better - uses StringBuilder
   StringBuilder result = new StringBuilder();
   for (int i = 0; i < 100; i++) {
       result.append(i);
   }
```


2. **Be careful with static fields**
```java
// Potential memory leak - static collection holding references
   public class CacheManager {
       private static final Map<String, Object> CACHE = new HashMap<>();
       
       public static void add(String key, Object value) {
           CACHE.put(key, value);
       }
       
       // Without a removal method, objects stay in memory forever
   }
```


3. **Close resources properly**
```java
// Good practice - using try-with-resources
   try (FileInputStream fis = new FileInputStream("file.txt")) {
       // Use the resource
   } catch (IOException e) {
       e.printStackTrace();
   }
```


4. **Consider weak references for caches**
```java
Map<Key, Value> cache = new WeakHashMap<>();
```


5. **Avoid finalizers and use try-with-resources instead**

6. **Size your collections appropriately**
```java
// Pre-size collections when the size is known
   List<String> names = new ArrayList<>(1000);
```


## Resources

- [JVM Specification](https://docs.oracle.com/javase/specs/jvms/se17/html/index.html)
- [Java Garbage Collection Handbook](https://plumbr.io/java-garbage-collection-handbook)
- [VisualVM](https://visualvm.github.io/) - Profiling tool
- [JConsole](https://docs.oracle.com/javase/8/docs/technotes/guides/management/jconsole.html) - Monitoring tool
- [Java Flight Recorder](https://docs.oracle.com/javacomponents/jmc-5-4/jfr-runtime-guide/about.htm#JFRUH170) - Diagnostics

---

This README provides a foundational understanding of Java's memory architecture. For application-specific memory optimization, profile your application using tools like VisualVM, JConsole, or Java Flight Recorder to identify bottlenecks and optimize accordingly.