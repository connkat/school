# Module 1 Notes

## ////////////// Reading notes //////////////

### 1.1 Java intro
- A computer system consists of hardware and software that work in concert to help us solve problems.
- Java is a relatively new programming language compared to many others. It was developed in the early 1990s by James Gosling at Sun Microsystems. Java was introduced to the public in 1995 and has gained tremendous popularity since.
- The Java language is accompanied by a library of extra software that we can use when developing programs. This software is referred to as the Java API, which stands for Application Programmer Interfaces, or simply the standard class library. 
- All Java applications have a main method, which is where processing begins. Each programming statement in the main method is executed, one at a time in order, until the end of the method is reached. Then the program ends, or terminates. The main method definition in a Java program is always preceded by the words public, static, and void, which we examine later in the text. The use of String and args does not come into play in this particular program. We describe these later also.
- An identifier is a letter followed by zero or more letters and digits. Java letters include the 26 English alphabetic characters in both uppercase and lowercase, the $ and _ (underscore) characters, as well as alphabetic characters from other languages. Java digits include the digits 0 through 9.

### 1.2 Program Development
- Programming languages can be categorized into the following four groups. These groups basically reflect the historical development of computer languages.
	• machine language: In order for a program to run on a computer, it must be expressed in that computer’s machine language.Machine language code is expressed as a series of binary digits and is extremely difficult for humans to read and write.
	• assembly language: assembly language replaced binary digits with mnemonics, short English-like words that represent commands or data. It is much easier for programmers to deal with words than with binary digits. However, an assembly language program cannot be executed directly on a computer. It must first be translated into machine language.
	• high-level languages: Today, most programmers use a high-level language to write software. A high-level language is expressed in English-like phrases and thus is easier for programmers to read and write. 
	• fourth-generation languages: Some programming languages are considered to operate at an even higher level than high-level languages. They might include special facilities for automatic report generation or interaction with a database. These languages are called fourth-generation languages, or simply 4GLs, because they followed the first three generations of computer programming: machine, assembly, and high-level languages.
- The translation of source code into (ultimately) machine language for a particular type of CPU can occur in a variety of ways. A compiler is a program that translates code in one language into equivalent code in another language. The original code is called source code, and the language into which it is translated is called the target language. 
- An interpreter is similar to a compiler but has an important difference. An interpreter interweaves the translation and execution activities. A small part of the source code, such as one statement, is translated and executed. Then another statement is translated and executed, and so on. One advantage of this technique is that it eliminates the need for a separate compilation phase. However, the program generally runs more slowly because the translation process occurs during each execution.
- The Java compiler translates Java source code into Java bytecode, which is a representation of the program in a low-level form similar to machine language code. The Java interpreter reads Java bytecode and executes it on a specific machine. Another compiler could translate the bytecode into a particular machine language for efficient execution on that machine.
	- The difference between Java bytecode and true machine language code is that Java bytecode is not tied to any particular processor type. This approach has the distinct advantage of making Java architecture-neutral
- You will encounter three kinds of errors as you develop programs:
	• compile-time error: Any error identified by the compiler is called a compile-time error. When a compile-time error occurs, an executable version of the program is not created.
	• runtime error: The second kind of problem occurs during program execution. It is called a runtime error and causes the program to terminate abnormally.
	• logical error:  In this case, the software compiles and executes without complaint, but it produces incorrect results.

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

### 1.5 OOP
- One of the most attractive characteristics of the object-oriented approach is the fact that objects can be used quite effectively to represent real-world entities. 
Object-oriented programming ultimately requires a solid understanding of the following terms:
	• object: An object is a fundamental element in a program. A software object often represents a real object in our problem domain, such as a bank account.
	• attribute: An object’s attributes are the values it stores internally, which may be represented as primitive data or as other objects. For example, a bank account object may store a floating point number (a primitive value) that represents the balance of the account. It may contain other attributes, such as the name of the account owner. Collectively, the values of an object’s attributes define its current state.
	• method: a method is a group of programming statements that is given a name. When a method is invoked, its statements are executed. A set of methods is associated with an object. The methods of an object define its potential behaviors.
	• class: An object is defined by a class. A class is the model or blueprint from which an object is created. 
	• encapsulation: An object should be encapsulated, which means it protects and manages its own information. That is, an object should be self-governing. The only changes made to the state of the object should be accomplished by that object’s methods. We should design an object so that other objects cannot “reach in” and change its state.
	• inheritance: Classes can be created from other classes by using inheritance. That is, the definition of one class can be based on another class that already exists. Inheritance is a form of software reuse, capitalizing on the similarities among various kinds of classes that we may want to create. 
	• polymorphism: Polymorphism is the idea that we can refer to multiple types of related objects over time in consistent ways. It gives us the ability to design powerful and elegant solutions to problems that deal with multiple objects.

Other important terms: 
	• State: Every object has a state and a set of behaviors. By “state” we mean state of being—fundamental characteristics that currently define the object. For example, part of a bank account’s state is its current balance. 
	• Behaviors: The behaviors of an object are the activities associated with the object. Behaviors associated with a bank account probably include the ability to make deposits and withdrawals.
	• Primitive Data: In addition to objects, a Java program also manages primitive data. Primitive data include fundamental values such as numbers and characters. Objects usually represent more interesting or complex entities.

## ////////////// Course Notes //////////////

## Compilation
Each type of CPU executes only a particular machine language
• A program must be translated into machine language before it can be executed
• A compiler is a software tool which translates source code into a specific target language
• Often, that target language is the machine language for a particular CPU type
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

## Development Activities
- Software requirements specify what a program must accomplish
- Requirements are expressed in a document called a functional specification
- A software design indicates how a program will accomplish its requirements
- Implementation is the process of writing the source code that will solve the problem
- Testing is the act of ensuring that a program will solve the intended problem given all of the constraints under which it must perform
