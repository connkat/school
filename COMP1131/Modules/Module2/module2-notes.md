# Module 2

## ////////////// Reading notes //////////////

### Methods and strings
``` java
System.out.println("Hello");
```

`System.out` = object
`println` = method
`Hello` = parameter

The difference between print and println is small but important. The println method prints the information sent to it and then moves to the beginning of the next line. The print method is similar to println, but it does not advance to the next line when completed.

### String Concat
``` java
public static void main(String[] args)
   {
      System.out.println("24 and 45 concatenated: " + 24 + 45);
      System.out.println("24 and 45 added: " + (24 + 45));
   }
```
Prints: 
	- 2445
	- 69

### Java Escape sequences
- \b: backspace
- \t: tab
- \n: newline
- \r: return
- \": double quote
- \': single quote
- \\: backslash

ex: 
```java
public class Roses
  {
     //-----------------------------------------------------------------
     // Prints a poem (of sorts) on multiple lines.
     //-----------------------------------------------------------------
     public static void main (String[] args)
     {
        System.out.println("Roses are red,\n\tViolets are blue,\n" +
         "Sugar is sweet,\n\tBut I have \"commitment issues\",\n\t" +
         "So I’d rather just be friends\n\tAt this point in our " +
         "relationship.");
} }
```

### Variables and assignments
A variable is a name for a location in memory used to hold a data value. A variable declaration instructs the compiler to reserve a portion of main memory space large enough to hold a particular type of value, and it indicates the name by which we refer to that location.

Examples: 
- int total;
- double num1, num2 = 4.356, num3;
- char letter = 'A', digit = '7';
- final int MAX = 45;


Assigning a value to a variable: 
A variable can store only one value of its declared type. A new value overwrites the old one. In this case, when the value 10 is assigned to sides, the original value 7 is overwritten and lost forever, 

``` java
   {
      int sides = 7; // declaration with initialization
      System.out.println("A heptagon has " + sides + " sides.");
      sides = 10; // assignment statement
      System.out.println("A decagon has " + sides + " sides.");
sides = 12;
      System.out.println("A dodecagon has " + sides + " sides.");
   }
```

### Constants
Constants are identifiers and are similar to variables except that they hold a particular value for the duration of their existence. Constants are, to use the English meaning of the word, not variable. Their value doesn’t change.

### Primitive Data Types
There are eight primitive data types in Java: four subsets of integers, two subsets of floating point numbers, a character data type, and a boolean data type. Everything else is represented using objects.

Java has two basic kinds of numeric values: 
- integers: which have no fractional part
- floating points: which do have fractional parts 

Integer Data Types: 
- byte
- short
- int
- long 

Floating Point Data Types: 
- Float
- Double

[img](COMP1131/Moduel2/numeric-primitive-types.png)

- Note that even though a float value supports very large (and very small) num- bers, it has only seven significant digits. Therefore, if it is important to maintain a value such as 50341.2077 accurately, we need to use a double.
- As we’ve already discussed, a literal is an explicit data value used in a pro- gram. The various numbers used in programs such as Facts and Addition and PianoKeys are all integer literals. Java assumes that all integer literals are of type int, unless an L or l is appended to the end of the value to indicate that it should be considered a literal of type long, such as 45L.
- Likewise, Java assumes that all floating point literals are of type double. If we need to treat a floating point literal as a float, we append an F or f to the end of the value, as in 2.718F or 123.45f. Numeric literals of type double can be fol- lowed by a D or d if desired.

- An integer literal is composed of a series of digits followed by an op- tional suffix to indicate that it should be considered a long integer. Negation of a literal is considered a separate operation.
Examples:
       5
       2594
       4920328L

### Booleans
You know this

### Expressions
- An expression is a combination of one or more operators and operands that usually performs a calculation. The value calculated does not have to be a number, but often it is.

-Arithmetic Operators: 
The usual arithmetic operations are defined for both integer and floating point numeric types, including addition (+), subtraction (–), multiplication (*), and di- vision (/). Java also has another arithmetic operation: The remainder operator (%) returns the remainder after dividing the second operand into the first. The remainder operator is sometimes called the modulus operator. 

- As you might expect, if either or both operands to any numeric operator are floating point values, the result is a floating point value. However, the division operator (/) produces results that are less intuitive, depending on the types of the operands. If both operands are integers, the / operator performs integer division, meaning that any fractional part of the result is discarded.
If one or the other or both operands are floating point values, the / operator performs floating point division, and the fractional part of the result is kept. 

### Data Conversions
- Because Java is a strongly typed language, each data value is associated with a particular type. It is sometimes helpful or necessary to convert a data value of one type to another type, but we must be careful that we don’t lose important information in the process. 
In Java, conversions can occur in three ways:
	- assignment conversion: Assignment conversion occurs when a value of one type is assigned to a variable of another type, during which the value is converted to the new type.
	- promotion: Conversion via promotion occurs automatically when certain operators need to modify their operands in order to perform the operation. 
	- casting: Casting is the most general form of conversion in Java. If a conversion can be accomplished at all in a Java program, it can be accomplished using a cast. A cast is a Java operator that is specified by a type name in parentheses. It is placed in front of the value to be converted. 

### Reading Input Data
- The Scanner Class: The Scanner class, which is part of the standard Java class library, provides convenient methods for reading input values of various types. The input could come from various sources, including data typed interactively by the user or data stored in a file.
- We must first create a Scanner object in order to invoke its methods. Objects in Java are created using the new operator. The following declaration creates a Scanner object that reads input from the keyboard:

``` java
import java.util.Scanner;

public class Echo
{
   //------------------------------------------------------------------
   // Reads a character string from the user and prints it.
   //------------------------------------------------------------------
   public static void main(String[] args)
   {
      String message;
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter a line of text:");
      message = scan.nextLine();
      System.out.println("You entered: \"" + message + "\"");
   }
}
```


## ////////////// Class notes //////////////