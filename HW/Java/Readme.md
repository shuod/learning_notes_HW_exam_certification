# Exercise in JAVA
##  hw1 & hw2 Comparable and Comparator

Both are interfaces,

The “compare to” method compare the host and the one in the () .

1. comparable is in the java.lang package; comparator is in the java.util package;

2. sorting sequence: comparable has Multiple ways of sorting; comparator is single way, and would need multiple class to sort multiple sequence;

3. methods name: comparable has compareto, comparator is sort;

4. comparable/compareto, 1 parameter; comparator/sort 2 parameters;

5. compareable need to modify the custom class; comparator don’t need to modify the custom class but will implement a new class;

##  hw3 Immutable Object

### Wiki definition:

In?object-oriented?and?functional?programming, an?immutable object?(unchangeable[1]?object) is an?object?whose state cannot be modified after it is created.[2]?This is in contrast to a?mutable object?(changeable object) , which can be modified after it is created. In some cases, an object is considered immutable even if some internally used attributes change but the object's state appears to be unchanging from an external point of view. For example, an object that uses?memoization?to cache the results of expensive computations could still be considered an immutable object.

### Explanation:

Immutable object refers to those objects that once being created, can never be changed. 

### Example:

String is an example of immutable object.

```java
String s="ABC";
s.toLowerCase();
```


The method toLowerCase() will not change the content of s, but rather create a new string object and initilize it with the value "abc" and return  the reference of this new object.

The fact that no method in String will change its value makes String an immutable object. However, to make a specific declaration for an immutable object, we can use the "final" keyword.

### Advantages:

- thread safe