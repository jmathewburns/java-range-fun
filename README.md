[![Javadocs](http://javadoc.io/badge/xyz.jmburns/rangefun.svg?color=green)](http://javadoc.io/doc/xyz.jmburns/rangefun)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](./LICENSE)
![JDK](https://img.shields.io/badge/jdk-9-yellowgreen.svg)


# Java Range Fun(ctions)

A lightweight Java implementation of Python's `range` function, but with better naming.

## Usage

You can find source, javadoc, and binary jars at Maven Central, under the groupId "xyz.jmburns", and the artifactId 
"rangefun". The latest version is 2.0.1. Using that, you can add the dependency to you project, just like any other.

For example, with Gradle:
```
repositories {
   mavenCentral()
}

dependencies {
   compile 'xyz.jmburns:rangefun:2.0.1'
}
```

Also, feel free to copy the source code and include it in your own project, under the terms of the [License](./LICENSE).

## Description

This library provides a lightweight, iterable Progression class, representing a series of integers.
The class's main purpose is in for-each loops, but can also be used to build an array of integers, or check if an
integer is within a certain range, among other things.

All methods of the `Progression` class (and its `Iterator`) are lazily-evaluated, so all `Progression` instances --
large and small -- are guaranteed to have the same (small) memory footprint, and a similar performance impact.

Also, the class has well-behaved `hashCode`, `equals`, `compareTo` implementations, so instances can be safely stored 
in `Collection` and `Map` instances.

## Examples

The best demonstration of the library is in the tests. However, for the sake of "readme-completeness", I've compiled 
some small examples of what's possible.

### Progression Creation
*Note:*
All creation of `xyz.jmburns.rangefun.Progression` instances is done via static factory methods in the 
`xyz.jmburns.rangefun.Progressions` "API" class. Those static methods are intended to be statically imported for enhanced 
readability.

<br>

Basic range of x to y, inclusive:
```java
range(x, y)
```
Generates: `x, x + 1, x + 2, ..., y`

<br>

Progression of x to no further than y, with a custom step of z:
```java
progression(x, y, z)
```
Generates: `x, x + z, x + 2*z, ...`

<br>

Range of all the indices of an array:
```java
indices(array)
```
Generates: `0, 1, 2, ..., array.length - 1`

<br>

Range of all the indices of an array, backwards:
```java
indices(array).reverse()
```
Generates: `array.length - 1, array.length - 2, ..., 0`

<br>

Progression of x to y with a custom step of z, backwards:
```java
progression(x, y, z).reverse()
```
Or, simply:
```java
progression(y, x, z) //y can be higher than x, and z does not have to be negative
```
Generates: `y, y - z, y - 2*z, ...`

<br>

A simple count from 0 to y, exclusive:
```java
count(y)
```
Generates: `0, 1, 2, ..., y - 1`

### Progression Usage

Checking if a integer is within a range:
```java
range(1, 5).contains(3)
```
Will evaluate to `true`.

<br>

Generating an array of integers:
```java
progression(1, 25, 5).toArray()
```
Will evaluate to an array of `1, 6, 11, 16, 21`.

<br>

Finding the length of a progression:
```java
progression(1, 25, 5).length()
```
Will evaluate to `5`.

<br>

Finding the integer in a progression at a specific index, counting from zero:
```java
progression(1, 25, 5).get(2)
```
Will evaluate to `11`.

<br>

And finally, a practical example. Copying over an array.

```java
for (int i : indices(source)) {
   destination[i] = source[i];
}
```
Beautiful, no?

## Features

 - [x] Lazy evaluation
 - [x] Well-behaved `hashCode`, `equals`, `compareTo` implementations, for storage in maps and collections
 - [x] Ability to easily iterate backwards
 - [x] Convenience method to generate ranges for arrays
 - [ ] Ability to generate a range of `long` values (Possibly coming soon)
 - [ ] Ability to generate a range of `double` values (Possibly coming soon)

## Feedback

Suggestions, bug reports, and pull requests are all welcome and appreciated. You are also welcome to send me an email 
at dev (AT) rangefun.xyz if you feel the need to do so.
 
## Licensing

Copyright 2017 Jacques Burns

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the 
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit 
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR 
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
