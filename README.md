# Pseudo-pseudo-primes

In this example, we will work with the `ArrayList` datatype to hold a variable amount of content. We will motivate the use of `ArrayList`s with the problem below. This example also illustrates how to pick a good set of test cases.

Let us define a number *n* to be a 3-pseudopseudoprime or a **probable-prime** if and only if the following conditions are satisfied: There exist two numbers *a* and *b* such that 1 < a < n and 1 < b < n; *a* is not equal to *b*; *a* and *b* are multiples of 3; and

$$a^n~mod~n = a; ~~~~ b^n~mod~n = b.$$

Furthermore, *all prime numbers are definitely probable-primes*, which means that 2 and 5 are probable-primes.

You are given a list of numbers and you need to identify the probable-primes in the list and return another list, *without duplicates*, with the probable-primes sorted in ascending order.

$$a^n ~ mod~n = a$$

means that the remainder of *a* to the power of *n* divided by *n* is *a*. The `%` operator in Java helps in computing remainders.

```clike
int a = 11;
int b = 3;
int x = a%b;
// x holds the remainder when we divide a by b; 
// so x should hold the value 2
```

We can imagine solving this problem using an array to hold the probable-primes. The challenge with using arrays is that we need to know how large the array, which we need to return, needs to be when we create an array. For the given problem, we then have a couple of options.

1. **Create an array that is the size of the original list that we are given**: There cannot be more probable-primes than the size of the original list and so this approach would work, but we may waste memory if the list is large and contains only a few probable-primes.
2. **Solve the problem in two passes**: In the first pass, we count the number of probable-primes in the original list. We then create an array of the appropriate size and perform a second pass wherein we add the probable-primes to this array. This solution is usually not attractive because we need to make two passes over the original list, but we could have solved the problem in a single pass.

What we would really like is a list that grows in size as we add elements to it. And this is a common use-case. Consequently, most modern programming languages support a list datatype that allows us to add, remove and locate elements easily. In Java, one such collection type is called `ArrayList` because it uses arrays to store data but hides such details from the programmer who is simply interested in adding elements (or removing them, or iterating over the list).

Java's `ArrayList` is a type that is made available through the `java.util` package. To use `ArrayList`s, we import the `ArrayList` type using the statement

```clike
import java.util.ArrayList;
```

at the top of the Java source code file that is going to use `ArrayList`s. `ArrayList`s can hold different types of data but each `ArrayList` can hold only the *same type* of data. For the problem at hand, we want an `ArrayList` of integers. We would declare a variable that refers to such an `ArrayList` thus:

```clike
ArrayList<Integer> intList;
```

The statement above informs that compiler that `intList` *refers* to an `ArrayList` that holds `Integer`s. Note that we use `Integer` and not `int` because an `ArrayList` can only hold objects and not primitive types, and `Integer` wraps the primitive type `int` in an object. We **cannot** say:

```clike
ArrayList<int> intList;
```

A declaration is insufficient to create an `ArrayList`. `intList` will initially have the value `null`. We have to ask the JVM to create new `ArrayList` and we do so using an `ArrayList` constructor.

```clike
intList = new ArrayList<Integer>();
```

`intList` is now a reference to an empty `ArrayList`: the list does not contain any elements. We can add elements to the list using the `add` method.

```clike
intList.add(10);
intList.add(7);
intList.add(20);
```

After these add operations, the list has 3 elements, 10, 7, and 20, in that order. 10 is the element at index 0, 7 is the element at index 1 and 20 is the element at index 2.

We can use the method `size()` to find the number of elements in the list. For example:

```clike
System.out.println(intList.size());
```

If we want to remove an element at a specific index, we would use the `remove()` method.

```clike
intList.remove(1);
// will remove the element at index 1
```

We can iterate over all elements in the list using the abbreviated `for` loop construct.

```clike
for (Integer x: intList) {
    System.out.println(x);
}
```

All the documentation for `ArrayList` can be found at the [official Java documentation page](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) maintained by Oracle.

------

To structure your code for readability and extensibility, implement a method that checks if a number is a probable-prime (for example, a function that returns a `boolean` value) and use it in the method that you have been asked to implement:

```clike
PseudoPseudoPrimes.getAllPPPrimes(ArrayList<Integer> inList)
```

Keeping functions/methods short improves code comprehensibility and is an important design principle.

------

$$a^n \textrm{ can be much greater than } a^n~mod~n. \textrm{ You only need to compute the latter. } \\ \textrm{ Note that } a^n~mod~n \textrm{ is the same as } ((a^{n-1}~mod~n) \times a)~mod~n.$$

If you are careful you can avoid working with very large numbers and having to worry about [integer overflow](https://en.wikipedia.org/wiki/Integer_overflow) issues.

------

## Topics Covered

- `ArrayList`s
- Sorting lists
- Exponentiation and modular arithmetic
- Integer overflow
- Primality testing

------

## Asides

- **Importing Packages**
   - In Java, all files that are in the same directory are considered part of the same package. When you need to use code that is in a different package, you will need suitable import statements. The standard Java utilities (such as `java.util.ArrayList`) are part of the Java Development Kit that you downloaded so the compiler knows where to find the relevant code. We will use libraries/code that are not part of the SDK and in these cases we will have to tell the compiler where to find the appropriate files as part of the build/compilation process, and we you will discover how to do so later.
- **Primality Testing**
   - [Checking if a number is prime](https://en.wikipedia.org/wiki/Primality_test) is an important computational task. It is at the heart of several cryptographic schemes and efficient algorithms to determine if a number is prime are valued. Pseudoprimes are a consequence of using [Fermat's Little Theorem](https://en.wikipedia.org/wiki/Fermat's_little_theorem) to help in primality testing.