# Polymorphism

## Binding

- Consider the following method invocation: `obj.doIt();`
- At some point, this invocation is `bound` to the definition of the method that it invokes
- If this binding occurred at compile time, then that line of code would call the same method every time
- But Java defers method binding until run time; this is called dynamic binding or late binding
- The term `polymorphism` literally means “having many forms”
- A `polymorphic reference` is a variable that can refer to different types of objects at different points in time
- The method invoked through a `polymorphic reference` can change from one invocation to the next
- All object references in Java are potentially polymorphic

### Example:

- Suppose we create the following reference variable:
  `Occupation job;`
- Java allows this reference to point to an `Occupation` object, or to any object of any compatible type
- This compatibility can be established using `inheritance` or using `interfaces`
- Careful use of polymorphic references can lead to elegant, robust software designs

## References and Inheritance

- An object reference can refer to an object of its class, or to an object of any class related to it by
  inheritance
  • EX: if the `Holiday class` is the parent of `Christmas`, then a `Holiday` reference could be used to point to a `Christmas object`:

```java
Holiday special = new Christmas();
```

- Assigning a child object to a parent reference is considered to be a widening conversion, and can be performed by simple assignment
- Assigning an parent object to a child reference can be done also, but it is considered a narrowing conversion and must be done with a cast
- The widening conversion is the most useful

## Polymorphism via Inheritance

- It is the type of the object being referenced, not the reference type, that determines which
  method is invoked
- Suppose the `Mammal` class has a method called `move`, and the `Horse` class overrides it
- Now consider the following invocation

```java
pet.move();
```

- If `pet` refers to a `Mammal` object, it invokes the `Mammal` version of move; if it refers to a `Horse` object, it invokes the `Horse` version
- EX: Set of Employees: See [Employees](COMP1231/Modules/Module2/Employees.png)

## Interfaces

- A Java interface is a collection of abstract methods and constants
- An abstract method is a method header without a method body
- An abstract method can be declared using the modifier `abstract`, but because all methods in an interface are abstract, usually it is left off
- An interface is used to establish a set of methods that a class will implement

```java
public interface Doable
{
public void doThis();
public int doThat();
public void doThis2(float value, char ch);
public boolean doTheOther(int num);
}
```

- `Interface` is a reserved word
- An interface cannot be instantiated
- Methods in an interface have public visibility by default
- A class formally implements an interface by:
  – stating so in the class header
  – providing implementations for each abstract method in the interface
- If a class states that it implements an interface, it must define all methods in the interface

-EX: CanDo:

```java
public class CanDo implements Doable
{
public void doThis ()
{
// whatever
}
public void doThat ()
{
// whatever
}
// etc.
}
```

- `implements` is a reserved word
- Each method listed in Doable is given a definition
- A class that implements an interface can implement other methods as well
- In addition to (or instead of) abstract methods, an interface can contain constants
- When a class implements an interface, it gains access to all its constants

### UML

- In UML, a dotted arrow is used to show that a class implements an interface
- The designation `<<interface>>` is used to indicate an interface

### Classes

- A class can implement multiple interfaces
- The interfaces are listed in the `implements` clause
- The class must implement all methods in all interfaces listed in the header

```java
class ManyThings implements Interface1, Interface2
{
// all methods of both interfaces
}
```

### Java Interfaces

- The Java API contains many helpful interfaces
- The Comparable interface contains one `abstract` method called `compareTo`, which is used to
  compare two objects
- We discussed the `compareTo` method of the String class in Chapter 4
- The`String class` implements `Comparable`, giving us the ability to put strings in lexicographic order

## The Comparable Interface

- Any class can implement `Comparable` to provide a mechanism for comparing objects of that type
- EX:

```java
if (obj1.compareTo(obj2) < 0)
System.out.println("obj1 is less than obj2");
```

- The value returned from compareTo should be negative is `obj1` is less that `obj2`, `0` if they are equal, and `positive` if `obj1` is greater than `obj2`
- When you design a class that implements the `Comparable` interface, it should follow this intent
- It’s up to the programmer to determine what makes one object less than another
- For example, you may define the `compareTo` method of an Employee class to order employees by name (alphabetically) or by employee number
- The implementation of the method can be as straightforward or as complex as needed for the situation

## The Iterator Interface

- As we discussed in Chapter 4, an `iterator` is an object that provides a means of processing a collection of objects one at a time
- An `iterator` is created formally by implementing the Iterator interface, which contains three
  methods
- The `hasNext` method returns a `boolean` result – true if there are items left to process
- The `next` method returns the next object in the iteration
- The `remove` method removes the object most recently returned by the next method
- By implementing the `Iterator` interface, a class formally establishes that objects of that type are iterators
- The programmer must decide how best to implement the iterator functions
- Once established, the for-each version of the `for loop` can be used to process the items in the iterator

## Interfaces

- You could write a class that implements certain methods (such as compareTo) without formally implementing the interface (Comparable)
- However, formally establishing the relationship between a class and an interface allows Java to deal with an object in certain ways

## Example:

```java
public interface Speaker
{
public void speak();
public void announce(String str);
}
```

- The interface name can now be used as the type of a reference variable: `Speaker current;`
- The variable `current` can now point to any object of any class that implements `Speaker`

## Polymorphism via Interfaces

- The version of speak that the following line invokes depends on the type of object that current is referencing: `current.speak();`
- This is analogous to the technique for polymorphism using inheritance

## Polymorphism via Interfaces

- Suppose two classes, `Philosopher` and `Dog`, both implement the `Speaker` interface, providing distinct versions of the speak method
- In the following code, the first call to speak invokes one version and the second invokes another:

```java
Speaker guest = new Philospher();
guest.speak();
guest = new Dog();
guest.speak();
```
