1. Which of the following are not valid Java identifiers? Why?
- 2ndLevel: can't start with a number
- hook&ladder: can't have a special character

2. Categorize each of the following situations as a compile-time error, run-time error, or logical error.
- multiplying two numbers when you meant to add them: logical error
- dividing by zero: run-time error
- forgetting a semicolon at the end of a programming statement: compile-time error
- spelling a word wrong in the output: logical error
- producing inaccurate results: logical error
- typing a [ when you should have typed (: compile-time error

Enter, compile, and run the following application:
```java
public class Test {
	public static void main (String[ ] args)
	{
    	System.out.println ("An Emergency Broadcast");
	}
}

```
a- change Test to test: no error
b- change Emergency to emergency: no error
remove the first quotation mark in the string: " or ( expected
remove the last quotation mark in the string " or ) expected
change main to man: "error: empty parameter field"
change println to bogus: undeclared method: bogus
remove the semicolon at the end of the println statement: ' expected
remove the last brace in the program: reached end of file without parsing
