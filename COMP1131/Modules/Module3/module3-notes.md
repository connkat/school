# Module 3: Classes and Objects

## ////////////// Reading notes //////////////

### Creating Objects

 - In Java, a variable name represents either a primitive value or an object. Like variables that hold primitive types, a variable that refers to an object must be declared. The class used to define an object can be thought of as the type of an object. The declarations of object variables are similar in structure to the declarations of primitive variables.

- Compliers will issue an error if you attempt to use a var before initializing it. 
- An object var can be set to `null`, which specifically indicates that a var does not refer to an object.
- You need to instantiate an object by using the `new` operator: 

``` java
name = new String("Joe Smith"); 
```

- after the `new` operator creates an object, the constructor is invoked to set it up. A constructor is a special method that has the same name as a class. 
- Because an object reference variable holds the address of the object, it can be thought of as a pointer to the location in memory where the object is held. We could show the numeric address, but the actual address value is irrelevant—what’s important is that the variable refers to a particular object.
- After an object has been instantiated, we use the dot operator to access its methods.

- A primitive variable contains the value itself
- An object variable contains the address of the object
- An object reference can be thought of as a pointer to the location of the object
- Rather than dealing with arbitrary addresses, we often depict a reference graphically

- Garbage collection: 
	- When an object no longer has any valid references to it, it can no longer be accessed by the program
	- The object is useless, and therefore is called garbage
	- Java performs automatic garbage collection periodically, returning an object's memory to the system for future use

### String Class
- Once a String object is created, its value cannot be lengthened or shortened, nor can any of its characters change. Thus we say that a String object is immutable. However, several methods in the String class return new String objects that are the result of modifying the original string’s value.
- There are a bunch of built in methods, they are self explanatory and I'm not going to waste notes on them because I am already aware. 

```java
int area;
String name;
```
- area is a primitive variable
- and name is a reference variable.

### Packages
- A class library is a set of classes that supports the development of programs.
- A compiler or development environment often comes with a class library. Class libraries can also be obtained separately through third-party vendors. The classes in a class library contain methods that are valuable to a programmer because of the special functionality they offer. 
- The classes of the Java standard class library are also grouped into packages. Each class is part of a particular package. The String class, for example, is part of the java.lang package. The System class is part of the java.lang package as well. The Scanner class is part of the java.util package.

### Random class
- A bunch of methods to produce random things, only putting this here as an index search. 

### Math class
- contains methods useful for making calculations
- Quadratic equation example on pg 91

### Formatting Output
- The NumberFormat class and the DecimalFormat class are used to format information so that it looks appropriate when printed or displayed. They are both part of the Java standard class library and are defined in the java.text package.
     - The NumberFormat class provides generic formatting capabilities for numbers. We don’t instantiate a NumberFormat object by using the new operator. Instead, we request an object from one of its static methods that we invoke through the class name itself. 
	      - EX: String format (double number) Returns a string containing the specified number formatted according to this object's pattern.
		  - EX: static NumberFormat getCurrencyInstance() Returns a NumberFormat object that represents a currency format for the current locale.
		  - EX: static NumberFormat getPercentInstance(): Returns a NumberFormat object that represents a percentage format for the current locale.
- The format method is invoked through a formatter object and returns a String
that contains the number formatted in the appropriate manner.

- Unlike the NumberFormat class, the DecimalFormat class is instantiated in the traditional way using the new operator. Its constructor takes a String parameter that represents the pattern that will guide the formatting process. We can then use the format method to format a particular value. At a later point, if we want to change the pattern that the formatter object uses. 
     - EX: DecimalFormat (String pattern) Constructor: creates a new DecimalFormat object with the specified pattern.
	 - EX: void applyPattern (String pattern) Applies the specified pattern to this DecimalFormat object.
	 - EX: String format (double number) Returns a string containing the specified number formatted according to the current pattern.

- printf Method: In addition to print and println, the System class has another output method called printf, which allows the user to print a formatted string containing data values. 
     - EX: System.out.printf("ID: %5d\tName: %s", id, name);

### Enumerated types
- An enumerated type establishes all pos- sible values of a variable of that type by listing, or enumerating, them.
- EX: enum Season {winter, spring, summer, fall}
	 time = Season.spring;
- An enumerated type is a special kind of class, and the variables of an enumerated type are object variables. Thus there are a few methods associated with all enumerated types. The ordinal method returns the numeric value associated with a particular enumerated type value. The name method returns the name of the value, which is the same as the identifier that defines the value.
- Because enumerated types are special types of classes, they are not defined within a method. They can be defined either at the class level (within the class but outside a method)

### Wrapper classes
- A wrapper class represents a particular primitive type. For instance, the Integer class represents a simple integer value. An object created from the Integer class stores a single int value. The constructors of the wrapper classes accept the primitive value to store. 
     - Integer ageObj = new Integer(40);
- For each primitive type in Java there exists a corresponding wrapper class in the Java class library. All wrapper classes are defined in the java.lang package (represented by a capitalized version of the same primitive type)
- These wrapper classes have their own methods that are useful for these types
- Note that the wrapper classes also contain static methods that can be invoked independent of any instantiated object. For example, the Integer class contains a static method called parseInt that converts an integer that is stored in a String to its corresponding int value. If the String object str holds the string "987", the following line of code converts the string into the integer value 987 and stores that value in the int variable num:
	- EX: `num = Integer.parseInt(str);`
- The Java wrapper classes often contain static constants that are helpful as well. For example, the Integer class contains two constants, MIN_VALUE and MAX_VALUE, that hold the smallest and largest int values, respectively. The other wrapper classes contain similar constants for their types.
- Autoboxing is the automatic conversion of a primitive value to a corresponding wrapper object: 
``` java
Integer obj;
int num = 42;
obj = num;
```
	- The assignment creates the appropriate Integer object
	- The reverse conversion (called unboxing) also occurs automatically as needed