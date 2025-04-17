# Arrays

## Array Elements
- An array is a programming concept used to group and organize data. When we are writing a program that manages a large amount of information, such as a list of 100 names, it is not practical to declare separate variables for each piece of data. Arrays solve this problem by letting us declare one variable that can hold multiple, individually accessible values.
- An array is a list of values. Each value is stored at a specific, numbered position in the array. 
- In Java, array indexes always begin at zero. Therefore, the value stored at index 5 is actually the sixth value in the array.

## Declaring and Using Arrays
- In Java, arrays are objects. To create an array, the reference to the array must be declared. The array can then be instantiated using the new operator, which allocates memory space to store values.
```java
int[] height = new int[11];
```
- The variable height is declared to be an array of integers whose type is written as int[]. All values stored in an array have the same type (or are at least compatible).
- A value stored in an array is sometimes called an array element, and the type of values that an array holds is called the element type of the array.
```java
public class BasicArray
{
	//-----------------------------------------------------------------
	// Creates an array, fills it with various integer values,
	// modifies one value, then prints them out.
	//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		final int LIMIT = 15, MULTIPLE = 10;
		int[] list = new int[LIMIT];
		// Initialize the array values
		for (int index = 0; index < LIMIT; index++)
		list[index] = index * MULTIPLE;
		list[5] = 999; // change one array value
		// Print the array values
		for (int value : list)
		System.out.print(value + " ");
	}
}
```
- Output: 0 10 20 30 40 999 60 70 80 90 100 110 120 130 140
- The iterator version of the for loop is used to print the values in the array. Recall from Chapter 4 that this version of the for loop extracts each value in the specified iterator. Every Java array is an iterator, so this type of loop can be used whenever we want to process every element stored in an array.
- The square brackets used to indicate the index of an array are treated as an operator in Java. Therefore, just like the + operator or the <= operator, the index operator ([]) has a precedence relative to the other Java operators that determines when it is executed. It has the highest precedence of all Java operators.

### Bounds Checking
- Bounds checking ensures that an index used to refer to an array element is in range
- The index operator performs automatic bounds checking, which ensures that the index is in range for the array being referenced. Whenever a reference to an array element is made, the index must be greater than or equal to zero and less than the size of the array. 
- One way to check for the bounds of an array is to use the length constant,
which is an attribute of the array object and holds the size of the array. It is a public constant and therefore can be referenced directly.

### Alternative Array Syntax
- Syntactically, there are two ways to declare an array reference in Java.  
	1.  Associate the brackets with the type of values stored in the array.
		`int[] grades;`
	2.  Associate the brackets with the name of the array.
		`int grades[];`
- Although there is no difference between these declaration techniques as far as the compiler is concerned, the first is consistent with other types of declarations. The declared type is explicit if the array brackets are associated with the element type, especially if there are multiple variables declared on the same line. 

### Initializer Lists
- An initializer list can be used, instead of the new operator, to instantiate an array object.
- You can use an initializer list to instantiate an array and provide the initial values for the elements of the array. This is essentially the same idea as initializing a variable of a primitive data type in its declaration, except that the initial value for an array contains multiple values.
- The items in an initializer list are separated by commas and delimited by braces `({})`. When an initializer list is used, the new operator is not used. The size of the array is determined by the number of items in the initializer list. 
	- EX: the following declaration instantiates the array scores as an array of eight integers, indexed from 0 to 7 with the specified initial values:
	`int[] scores = {87, 98, 69, 87, 65, 76, 99, 83};`
- An initializer list can be used only when an array is first declared.
```java
//********************************************************************
// Primes.java Java Foundations
//
// Demonstrates the use of an initializer list for an array.
//********************************************************************
public class Primes
{
//-----------------------------------------------------------------
// Stores some prime numbers in an array and prints them.
//-----------------------------------------------------------------
	public static void main(String[] args)
	{
		int[] primeNums = {2, 3, 5, 7, 11, 13, 17, 19};
		System.out.println("Array length: " + primeNums.length);
		System.out.println("The first few prime numbers are:");

		for (int prime : primeNums)
		System.out.print(prime + " ");
	}
}
```
- Output: 
	Array length: 8
	The first few prime numbers are:
	2 3 5 7 11 13 17 19

### Arrays as Parameters
- An entire array can be passed as a parameter, making the formal parameter an alias of the original.
- An entire array can be passed as a parameter to a method. Because an array is an object, when an entire array is passed as a parameter, a copy of the reference to the original array is passed.
- A method that receives an array as a parameter can permanently change an element of the array, because it is referring to the original
element value. However, the method cannot permanently change the reference to the array itself, because a copy of the original reference
is sent to the method. These rules are consistent with the rules that govern any object type.
- An element of an array can be passed to a method as well. If the element type is a primitive type, a copy of the value is passed. If that element is a reference to an object, a copy of the object reference is passed. As always, the impact of changes made to a parameter inside the method depends on the type of the parameter.

## Arrays of Objects
- Instantiating an array of objects reserves room to store references
only. The objects that are stored in each element must be instantiated separately.
- In the previous examples in this chapter, we used arrays to store primitive types such as integers and characters. Arrays can also store references to objects as elements. Fairly complex information management structures can be created using only arrays and other objects.
	- EX: an array could contain objects, and each of those objects could consist of several variables and the methods that use them. Those variables could themselves be arrays, and so on. The design of a program should capitalize on the ability to combine these constructs to create the most appropriate representation for the information. 
	- EX: `String[] words = new String[5];`
	- The array words holds references to String objects. The new operator in the declaration instantiates the array object and reserves space for five String references. But this declaration does not create any String objects; it merely creates an array that holds references to String objects. 
- UML diagram: Figure 7.3 shows a UML class diagram of the Tunes program. Recall that the open diamond indicates aggregation. The cardinality of the relationship is also noted: a CDCollection object contains zero or more CD objects.
- The toString method of the CDCollection class returns an entire report summarizing the collection. The report is created, in part, by using implicit calls to the toString method of each CD object stored in the collection.

## Command Line Arguments
- Command-line arguments are stored in an array of String objects and are passed to the main method.
- The formal parameter to the main method of a Java application is always an array of String objects.
- The Java run-time environment invokes the main method when an application is submitted to the interpreter. The String[] parameter, which we typically call args, represents command-line arguments that are provided when the interpreter is invoked. 
- Any extra information on the command line when the interpreter is invoked is stored in the args array for use by the program. This technique is another way to provide input to a program.
- Remember that the parameter to the main method is always an array of String objects. If you want numeric information to be input as a command-line argument, the program has to convert it from its string representation.

## Variable-Length Parameter Lists
- A Java method can be defined to accept a varying number of parameters.
- Suppose we wanted to design a method that processed a different amount of data from one invocation to the next. For example, let’s design a method called average that accepts a few integer values and returns their average. In one invocation of the method, we might pass in three integers to average and in another invocation of the same method, we might pass in seven integers to average:
	- `mean1 = average(42, 69, 37);`
	- `mean2 = average(35, 43, 93, 23, 40, 21, 75);`
- To accomplish this we could define overloaded versions of the average method
(as we did in the exercises at the end of Chapter 5). But that solution doesn’t scale to an arbitrary set of input values. It would require that we know the maximum number of parameters there might be and create a separate version of the method for each possibility.
- Alternatively, we could define the method to accept an array of integers, which could be of different sizes for each call. But that would require the calling method to package the integers into an array.
Java provides a way to define methods that accept variable-length parameter lists.
- By using some special syntax in the formal parameter list of the method, we can define the method to accept any number of parameters. The parameters are automatically put into an array for easy processing in the method. 
	- EX: 
	```java
	public double average(int ... list)
	{
		double result = 0.0;
		if (list.length != 0)
		{
			int sum = 0;
			for (int num : list)
				sum += num;
			result = (double)sum / list.length;
		}
		return result;
	}
	```
- Note the way the formal parameters are defined. The ellipsis (three periods in a row) indicates that the method accepts a variable number of parameters. In this case, the method accepts any number of int parameters, which it automatically puts into an array called list. In the method, we process the array normally.
- We can now pass any number of int parameters to the average method, including none at all. That’s why we check to see whether the length of the array is zero before we compute the average.
- The type of the multiple parameters can be any primitive or object type:
	- EX: 
	```java
	public void printGrades(Grade ... grades)
	{
		for (Grade letterGrade : grades)
				System.out.println(letterGrade);
	}
	```
- A method that accepts a variable number of parameters can also accept other parameters. For example, the following method accepts an int, a String object, and then a variable number of `double` values that will be stored in an array called`nums`.
	- EX: 
	```java
	public void test(int count, String name, double ... nums)
	{
		//etc
	}
	```
- The varying parameters must come last in the formal arguments. A single method cannot accept two sets of varying parameters.

## Two-Dimensional Arrays
- The arrays we’ve examined so far have all been one-dimensional arrays in the sense that they represent a simple list of values. As the name implies, a two-dimensional array has values in two dimensions, which are often thought of as the rows and columns of a table.
- Brackets are used to represent each dimension in the array. Therefore, the type of a two-dimensional array that stores integers is `int[][]`. Technically, Java represents a two-dimensional array as an array of arrays. Thus a two-dimensional integer array is really a one-dimensional array of references to one-dimensional integer arrays. In most cases, it’s easier to think about a two-dimensional array as a table with rows and columns.
- Nested for loops are used in the TwoDArray program to load the array with values and also to print those values in a table format. Carefully trace the processing of this program to see how the nested loops eventually visit each element in the two-dimensional array. Note that the outer loops are governed by table.length, which represents the number of rows, and the inner loops are governed by table[row].length, which represents the number of columns in that row.
- As with one-dimensional arrays, an initializer list can be used to instantiate a two-dimensional array, where each element is itself an array initializer list.

### Multidimensional Arrays
- Using an array with more than two dimensions is rare in an object- oriented system.
- An array can have one, two, three, or even more dimensions. Any array with more than one dimension is called a multidimensional array.
- It’s fairly easy to picture a two-dimensional array as a table. A three-dimensional array could be drawn as a cube. However, once you are past three dimensions, multidimensional arrays might seem hard to visualize. But consider that each subsequent dimension is simply a subdivision of the previous one. It is often best to think of larger multidimensional arrays in this way.
	- EX: suppose we wanted to store the number of students attending universities across the United States, broken down in a meaningful way. We might represent it as a four-dimensional array of integers. The first dimension represents the state. The second dimension represents the universities in each state. The third dimension represents the colleges in each university. Finally, the fourth dimension represents the departments in each college. The value stored at each location is the number of students in one particular department.
- Java does not directly support multidimensional arrays. Instead, they are represented as arrays of references to array objects. Those arrays could themselves contain references to other arrays. This layering continues for as many dimensions as required.
- Because of this technique for representing each dimension,
the arrays in any one dimension could be of different lengths. These are sometimes called ragged arrays. For example, the numbers of elements in different rows of a two-dimensional array may not be the same. In such situations, care must be taken to make sure the arrays are managed appropriately.

