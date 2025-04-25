# Module 3: Classes and Objects

## ////////////// Reading notes //////////////

## Conditionals and Loops

### Boolean Expressions
- The order in which statements are executed in a running program is called the flow of control. Unless otherwise specified, the basic execution of a program proceeds in a linear fashion. 
- A Java application begins executing with the first line of the main method and proceeds step by step until it gets to the end of the main method.
- A conditional statement is sometimes called a selection statement because it allows us to choose which statement will be executed next. The conditional statements in Java are the if statement, the `if-else` statement, and the `switch ` statement. 
	- EX: 
	```java
	if (count > 20)
      System.out.println("Count exceeded");
	  ```
- A loop, or repetition statement, allows us to execute a programming statement over and over again. Like a conditional, a loop is based on a boolean expression that determines how many times the statement is executed.
- Java has three types of loop statements: the `while` statement, the `do` statement, and the `for` statement. Each type of loop statement has unique characteristics that distinguish it from the others.
- All conditionals and loops are based on boolean expressions, which use equality operators, relational operators, and logical operators to make decisions. Before we discuss the details of conditional and loop statements, let’s explore these operators.
- Equality and Relational Operators: 
	- The `==` and `!=` operators are called equality operators.
	- EX: 
	```java
	  if (total == sum)
      System.out.println("total equals sum");

	  if (total != sum)
      System.out.println("total does NOT equal sum");
	  ```
- Logical Operators: 
	- In addition to the equality and relational operators, Java has three logical operators that produce boolean results. They also take boolean operands.
		- `!`: logical NOT
		- `&&`: logical AND
		- `||`: logical OR 
	- An important characteristic of the && and || operators is that they are “short-circuited” in Java. That is, if their left operand is sufficient to decide the boolean result of the operation, the right operand is not evaluated. 
	- You should consider carefully whether or not to rely on these kinds of subtle programming language characteristics. Not all programming languages short-circuit these operations, and such code would produce a divide-by-zero error in those languages. 

### The `if` Statement 
- An `if` statement consists of the reserved word if followed by a boolean expression, followed by a statement. The condition is enclosed in parentheses and must evaluate to true or false. 
- The if-else statement: Sometimes we want to do one thing `if` a condition is true and another thing if that condition is false. To handle this kind of situation, we can add an else clause to an if statement, making it an `if-else` statement. 
- Block Statements: We may want to do more than one thing as the result of evaluating a boolean condition. In Java, we can replace any single statement with a block statement. A block statement is a collection of statements enclosed in braces. 
	- Note that if the block braces were not used, the sentence stating that the answer is incorrect would be printed if the answer was wrong, but the sentence revealing the correct answer would be printed in all cases. That is, only the first statement would be considered part of the else clause.
- Conditional Operator: The Java conditional operator is similar to an if-else statement in some ways. It is a ternary operator because it requires three operands.
	- EX: 
```java
	(total > MAX) ? total + 1 : total * 2;
```
	 - As we’ve seen, the conditional operator is occasionally helpful. However, it is not a replacement for an if-else statement because the operands to the ?: operator are expressions, not necessarily full statements. 
- Nested `if` statements: The statement executed as the result of an if statement could be another if statement. This situation is called a nested if. 

### Comparing data

#### Comparing floats
- Two floating point values are equal, according to the == operator, only if all the binary digits of their underlying representations match. If the compared values are the results of computation, it may be unlikely that they are exactly equal, even if they are close enough for the specific situation. Therefore, you should rarely use the equality operator (==) when comparing floating point values.
- A better way to check for floating point equality is to compute the absolute value of the difference between the two values and compare the result to some tolerance level. For example, we may choose a tolerance level of 0.00001. If the two floating point values are so close that their difference is less than the tolerance, then we are willing to consider them equal. Comparing two floating point values, f1 and f2, could be accomplished as follows:
	```java
  		if (Math.abs(f1 - f2) < TOLERANCE)
     System.out.println("Essentially equal.");
	```
#### Comparing Characters
- Characters in Java are based on the Unicode character set, which defines an ordering of all possible characters that can be used. Because the character 'a' comes before the character 'b' in the character set, we can say that 'a' is less than 'b'.
- EX: 
```java
  if (ch1 > ch2)
     System.out.println(ch1 + " is greater than " + ch2);
  else
     System.out.println(ch1 + " is NOT greater than " + ch2);
```
- The Unicode character set is structured so that all lowercase alphabetic characters ('a' through 'z') are contiguous and in alphabetical order. The same is true of uppercase alphabetic characters ('A' through 'Z') and of characters that represent digits ('0' through '9'). The digits precede the uppercase alphabetic characters, which precede the lowercase alphabetic characters. Before, after, and in between these groups are other characters. 

#### Comparing Objects
The String class contains a method called equals that returns a boolean value that is true if the two strings being compared contain exactly the same characters, and is false otherwise. Here is an example:
  ```java
  if (name1.equals(name2))
     System.out.println("The names are the same.");
  else
     System.out.println("The names are not the same.");
```
- It is valid to test the condition (name1 == name2), but that actually tests to see whether both reference variables refer to the same String object. For any object, the == operator tests whether two reference variables are aliases of each other (whether they contain the same address). That’s different from testing to see whether two different String objects contain the same characters.
- EX: The first time the string literal "software" is used, a String object is created to represent it, and the reference variable str is set to its address. Each subsequent time the literal is used, the original object is referenced.
```java
 String str = "software";
  if (str == "software")
     System.out.println("References are the same");
  if (str.equals("software"))
     System.out.println("Characters are the same");
 ```
 -  `Common error`: For reasons described in this section, it’s valid to use the == operator to compare two string objects. However, usually a programmer is interested in seeing whether two different objects contain the same characters, which is not what the == operator determines. Remember to use the equals method when comparing the content of strings.
 - To determine the relative ordering of two strings, use the `compareTo` method of the String class. 
 	- The `compareTo` method is more versatile than the equals method. Instead of returning a boolean value, the `compareTo` method returns an integer. The return value is negative if the String object through which the method is invoked precedes (is less than) the string that is passed in as a parameter.
 - When comparing two strings, such as "able" and "Baker", the `compareTo` method will conclude that "Baker" comes first because all of the uppercase letters come before all of the lowercase letters in the Unicode character set. If a string is the prefix of a longer string, it is considered to precede the longer string. For example, when comparing two strings such as "horse" and "horsefly", the `compareTo` method will conclude that "horse" comes first.

### The Switch Statement
- Another conditional statement in Java, called the switch statement, causes the executing program to follow one of several paths based on a single value.
- The switch statement evaluates an expression to determine a value and then matches that value with one of several possible cases. Each case has statements associated with it. After evaluating the expression, control jumps to the statement associated with the first case that matches the value. 
	- EX: 
```java
switch (idChar)
  {
     case 'A':
        aCount = aCount + 1;
        break;
     case 'B':
        bCount = bCount + 1;
        break;
     case 'C':
        cCount = cCount + 1;
        break;
default:
System.out.println("Error in Identification Character.");
}
```
	- First, the expression is evaluated. In this example, the expression is a simple char variable. Execution then transfers to the first statement identified by the case value that matches the result of the expression. Therefore, if idChar contains an 'A', the variable aCount is incremented. If it contains a 'B', the case for 'A' is skipped, and processing continues where bCount is incremented.
	- If no case value matches that of the expression, execution continues with the optional default case, indicated by the reserved word default. If no default case exists, no statements in the switch statement are executed, and processing continues with the statement after the switch statement. It is often a good idea to include a default case, even if you don’t expect it to be executed.
	- When a break statement is encountered, processing jumps to the statement following the switch statement. A break statement is usually used to break out of each case of a switch statement. 
- `Common Error`: Forgetting a break statement at the end of a switch case is a common error. Usually you want each case to be mutually exclusive, so you’ll want to include a break statement at the end of each case. It’s unfortunate that the usual case requires the extra line of code, but occasionally it is convenient to omit it.

### The `while` Statement
- A while statement is a loop that evaluates a boolean condition just as an if statement does and executes a statement (called the body of the loop) if the condition is true. 
- However, unlike the if statement, after the body is executed, the condition is evaluated again. If it is still true, the body is executed again. This repetition continues until the condition becomes false; then processing continues with the statement after the body of the while loop.

- Infinite Loops: It is the programmer’s responsibility to ensure that the condition of a loop will eventually become false. If it doesn’t, the loop body will execute forever, or at least until the program is interrupted. This situation, which is referred to as an infinite loop, is a common mistake.
	- EX: 
```java
 int count = 1;
  while (count <= 25) // Warning: this is an infinite loop!
  {
     System.out.println(count);
     count = count - 1;
  }
```
- Nested Loops: The body of a loop can contain another loop. This situation is called a nested loop. Keep in mind that for each iteration of the outer loop, the inner loop executes completely. 

#### Other loop controls: 
- The break statement can also be placed in the body of any loop, even though this is usually inappropriate. Its effect on a loop is similar to its effect on a switch statement. The execution of the loop is stopped, and the statement following the loop is executed.
- A continue statement has a similar effect on loop processing. The continue statement is similar to a break, but the loop condition is evaluated again, and the loop body is executed again if it is still true. Like the break statement, the continue statement can always be avoided in a loop—and for the same reasons, it should be.

### Iterators
- An iterator is an object that has methods that allow you to process a collection of items one at a time. That is, an iterator lets you step through each item and interact with it as needed.
- Technically, an iterator object in Java is defined using the Iterator interface. For now, it is helpful simply to know that such objects exist and that they can make the processing of a collection of items easier.
- Every iterator object has a method called `hasNext` that returns a boolean value indicating whether there is at least one more item to process. Therefore, the `hasNext` method can be used as a condition of a loop to control the processing of each item. An iterator also has a method called `next` to retrieve the `next` item in the collection to process.

### The `do` statement
- The do statement is similar to the while statement in that it executes the loop body until a condition becomes false. However, unlike the while loop, whose condition is evaluated before the body is executed, the condition of a do loop is evaluated after the loop body executes. 
- Syntactically, the condition in a `do` loop is written after the loop body to reflect this processing. The body of a do loop is always executed at least once, whereas with a while loop, the body might not be executed at all (if the condition is initially false). 
	- EX: 
	```java
	do 
	{
		System.out.print("Enter a word:");
		word = scan.next();
		System.out.println(word);
	}
	while (!word.equals("quit"));
	```
- A do loop begins simply with the reserved word do. The body of the do loop continues until the while clause that contains the boolean condition that determines whether the loop body will be executed again. Sometimes it is difficult to determine whether a line of code that begins with the reserved word while is the beginning of a while loop or the end of a do loop.
- If you know you want to perform the body of a loop at least once, then you probably want to use a do statement. A do loop has many of the same properties as a while statement, so it must also be checked for termination conditions to avoid infinite loops.

### The `for` Statement
- The while statement and the do statement are good to use when you don’t initially know how many times you want to execute the loop body. The for statement is another repetition statement that is particularly well suited for executing the body of a loop a specific number of times that can be determined before the loop is executed.
	- EX: 
	```java
	for (int count=1; count <= 5; count++)
     	System.out.println(count);
	 ```
	 - The header of a for loop contains three parts separated by semicolons. Before the loop begins, the first part of the header, called the initialization, is executed. 
	 - The second part of the header is the boolean condition, which is evaluated before the loop body (like the while loop). 
	 - If true, the body of the loop is executed, followed by the execution of the third part of the header, which is called the increment. 
#### Iterators and `for` loops
- Some objects are considered to be iterators, which have hasNext and next methods to process each item from a group. If an object has implemented the Iterable interface, then we can use a variation of the for loop to process items using a simplified syntax. 
- For example, if bookList is an Iterable object that contains Book objects, we can use a for loop to process each Book object as follows:
	```java
  for (Book myBook : bookList)
     System.out.println (myBook);
	 ```
	 - This version of the for loop is referred to as a for–each statement. It processes each object in the iterator in turn. It is equivalent to the following:
	 ```java
		Book myBook;
		while (bookList.hasNext())
		{
			myBook = bookList.next();
			System.out.println(myBook);
		}
	```
#### Comparing Loops
- The three loop statements (while, do, and for) are functionally equivalent. Any particular loop written using one type of loop can be written using either of the other two loop types. Which type of loop we use depends on the situation.
- The primary difference between a while loop and a do loop is when the condition is evaluated. 
	- If you know you want to execute the loop body at least once, a do loop is usually the better choice. 
	- The body of a while loop, on the other hand, might not be executed at all if the condition is initially false. Therefore, we say that the body of a while loop is executed zero or more times, but the body of a do loop is executed one or more times.
- A for loop is like a while loop in that the condition is evaluated before the loop body is executed. We generally use a for loop when the number of times we want to iterate through a loop is fixed or can be easily calculated. In many situations, it is simply more convenient to separate the code that sets up and controls the loop iterations inside the for loop header from the body of the loop.