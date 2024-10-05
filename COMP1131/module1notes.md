There are four programming language levels
- machine language
	IE:
	1101 0111 0101 00111
– assembly language
	IE: 
	1d [%fp-20], %o0
	1d [%fp-24], %o1
	add %o0, %01
– high-level language
	IE: <a+b>
– fourth-generation language

## Compilation
Each type of CPU executes only a particular machine
language
• A program must be translated into machine
language before it can be executed
• A compiler is a software tool which translates source
code into a specific target language
• Often, that target language is the machine language
for a particular CPU type
• The Java approach is somewhat different: 
	• The Java compiler translates Java source code into a special representation called bytecode
	• Java bytecode is not the machine language for any traditional CPU
	• Another software tool, called an interpreter, translates bytecode into machine language and executes it
	• Therefore the Java compiler is not tied to any particular machine
	• Java is considered to be architecture-neutral

## Syntax and Semantics
	• The syntax rules of a language define how we can put together symbols, reserved words, and identifiers to make a valid program
	• The semantics of a program statement define
	what that statement means (its purpose or role in a program)
	• A program that is syntactically correct is not necessarily logically (semantically) correct
	• A program will always do what we tell it to do, not what we meant to tell it to do

## Errors
• A program can have three types of errors:
	– compile-time errors: The compiler will find syntax errors and other basic problems
	– run-time errors: A problem can occur during program execution, such as trying to divide by zero, which causes a program to terminate abnormally 
	–logical errors:  A program may run, but produce incorrect results, perhaps using an incorrect formula 

## Objects
	• An object has
		– state - descriptive characteristics
		– behaviors - what it can do (or what can be done to it)
	• The state of a bank account includes its account number and its current balance
	• The behaviors associated with a bank account include the ability to make deposits and withdrawals
	• Note that the behavior of an object might change its state

## Classes
	• An object is defined by a class
	• A class is the blueprint of an object
	• The class uses methods to define the behaviors of the object
	• The class that contains the main method of a Java program represents the entire program
	• A class represents a concept, and an object represents the embodiment of that concept
	• Multiple objects can be created from the same class