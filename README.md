# Range Fun(ctions)

Just a bit of fun with ranges. A small (five-class) library to combine the power of the traditional for loop with the prettiness and simplicity of the for-each.

## Description

We all like enhanced-for (or for-each, if you prefer) loops, right? They're simple, high-level, and do (mostly) what you want. However, we've all been in situations in which they're just not powerful enough. Usually, when you want to maintain an index variable, or iterate backwards. 

When this happens, you are forced to revert to the traditional for loop with its decidedly low-level ```int``` manipulation and comparison. Not to mention the potential for those annoying off-by-one errors.

This library aims to prevent that from happening through the use of simple functions to create an ```Iterable<Integer>``` suited your needs, which then supplies Integers as you need them.

And, yes, I did say ```Iterable```. This entire library is implemented without a single array. This means that you can make the range as large\* as you want, without worrying about an increased impact on memory!

\* _As long as you don't want a range with an endpoint outside the bounds of an ```int```, for now. See the Features section._

Using the library, you can write simple code, maintain a good level of abstraction (clean coders love that sort of thing), and eliminate potential bugs. What could be better?

## Examples

The best demonstration of the library is in the tests. However, for the sake of "readme-completeness", I've compiled some small examples of what's possible.

*_Note:_*
```Range.of()``` returns an Iterable<Integer> that is mostly intended to be used in an enhanced-for loop to supply the desired indices as you need them. Also, all calls to ```Range.of()``` can be substituted with a call to ```Range.range()```, a convenience method to preserve readability when ```Range``` is statically imported.


Basic range from x to y, inclusive:
```java
Range.of(x).to(y)
```
or:
```java
Range.of(x, y)
```
Generates: ```x, x + 1, x + 2, ..., Z```


Range from x to y with a custom step of z:
```java
Range.of(x).to(y).step(z)
```
or:
```java
Range.of(x, y, z)
```
Generates: ```x, x + z, x + 2*z, ...```


Range of all the indices of an array:
```java
Range.of(array)
```
Generates: ```0, 1, 2, ..., array.length - 1```


Range of all the indices of an array, backwards:
```java
Range.of(array).reverse()
```
Generates: ```array.length - 1, array.length - 2, ..., 0```


Range of x to y with a custom step of z, backwards:
```java
Range.of(x).to(y).step(z).reverse()
```
Generates: ```y, y - z, y - 2*z, ...```


And finally, a practical example. Copying over an array.

With the traditional for loop:
```java
for (int i = 0; i < source.length; i++) {
   destination[i] = source[i];
}
```
Familiar, no?

Now, with my Range Fun(ctions):
```java
for (int i : range(source)) {
   destination[i] = source[i];
}
```
Beautiful, just beautiful.

## Features

 - [x] "Fluent" API
 - [x] Ability to iterate backwards
 - [x] Convenience method to generate ranges for arrays
 - [ ] Ability to generate a range of ```long``` values (Coming soon)
 - [ ] Ability to generate a range of ```double``` values (Coming soon)

 ## Feedback

Suggestions, bug reports, and pull requests are all welcome and appreciated. You are also welcome to send me an email at dev (AT) rangefun.xyz if you feel the need to do so.
 
## Licensing

Copyright 2017 Jacques Burns

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.