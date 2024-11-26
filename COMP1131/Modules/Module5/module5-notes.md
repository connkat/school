# Writing Classes

## Classes and Objects
- A class is a blueprint of an object, the class represents the concept of an object. Any object created from that class is a realization of that concept. 
	- EX: class student represents a student at a university, and every object created fro, that class represents and actual student attending the school. We'd end up with one class and multiple Student objects. 
- State is defined by the values of the attributes associated with that object. 
	- EX: Student attributes might include `name`, `address`, `major`, etc. 
- In Java, an objects attributes are defined by variables declared within a class. 
- The object also has behaviours, which are defined by operations associated with that object. 
	- EX: How GPA is calculated, how to update the address
- These operations can be executed by or on a particular student object. In Java, an object's operations are defined by methods within a class. 

### Identifying Classes and Objects
- Objects are generally nouns (but not 100% of the time). WHen you are talking about nouns (plural), you should consider creating a class. 
- Another key decision is whether to represent something as an object or as a primitive attribute of another object. 
	- EX: Salary might be represented as an `int`, but there are scenarios where a salary falls within a range depending on things like performance and title. This could be better represented as a separate class if it is more complex. 

### Assigning Responsibilities
- Each class represents an object with certain behaviors that are defined by the methods of the class. Any activity that the program must
accomplish must be represented somewhere in the behaviors of the classes. That is, each class is responsible for carrying out certain activities, and those responsibilities must be assigned as part of designing a program.
- It’s not necessary in the early stages of a design to identify all the methods that a class will contain. It is often sufficient to assign primary responsibilities and then consider how those responsibilities translate into particular methods.

## Anatomy of a Class
- A class can contain data declarations and method declarations:
	- The data declarations represent the data that will be stored in each object of the class. 
	- The method declarations define the services that those objects will provide. Collectively, the data and methods of a class are called the members of a class.
- True object-oriented programming comes from defining classes that represent objects with well-defined state and behavior. 
// does a class have to have main or not? Die example does not have one
- Java allows multiple classes to be stored in one file. But if a file contains multiple classes, only one of those classes can be declared using the reserved word public.
	- The name of the public class must correspond to the name of the file.

	### Instance Data
- The location at which a variable is declared defines its scope, which is the area within a program in which that variable can be referenced. 
- Instance Data: If variables and constants have been declared at the class level (not within a method), these variables and constants can be referenced in any method of the class.
- In this case, new memory space is reserved for that variable every time an instance of the class is created. 
- Java automatically initializes any variables declared at the class level. However, despite the fact that the language performs this automatic initialization, it is good practice to initialize variables explicitly (usually in a constructor) so that anyone reading the code will clearly understand the intent.

### UML Class Diagrams
- [See UML Diagram example](./UML-diagram-ex.png)
- UML stands for the Unified Modeling Language, which has become the most popular notation for representing the design of an object-oriented program.
	- Several types of UML diagrams exist, each designed to show specific aspects of object-oriented programs. In this text, we focus primarily on UML class diagrams to show the contents of classes and the relationships among them. 
- In a UML diagram, each class is represented as a rectangle, possibly containing three sections to show the class name, its attributes (data), and its operations (methods).
	- UML is not designed specifically for Java programmers. It is intended to be language independent. Therefore, the syntax used in a UML diagram is not necessarily the same as that used in Java. 

## Encapsulation
- An object should be self-governing: the instance data of an object should be modified only by that object. 
	- EX: The methods of Die should be solely responsible for changing the value of `faceValue`.
- We should make it difficult, if not impossible, for code outside of a class to “reach in” and change the value of a variable that is declared inside that class.
- An object should be encapsulated from the rest of the system. It should interact with other parts of a program only through the specific set of methods that define the services that that object provides. These methods define the interface between that object and other objects that use it.
- The code that uses an object, which is sometimes called the client of an object, should not be allowed to access variables directly. The client should call an object’s methods, and those methods then interact with the data encapsulated within the object. [See encapsulation img](./enapsulation.png).
- Modifiers: In Java, we accomplish object encapsulation using `modifiers`. A modifier is a
Java reserved word that is used to specify particular characteristics of a program-
ming language construct.
	- EX: `final`, which is used to declare a constant. 
- Java has several modifiers that can be used in various
ways. Some modifiers can be used together, but some combinations are invalid.

### Visibility Modifiers
-  Visibility modifiers: control access to the members of a class. 
-`public` and `private` are visibility modifiers that can be applied to the variables and methods of a class. 
	- If a member of a class has public visibility, it can be directly referenced from outside of the object. If a member of a class has private visibility, it can be used anywhere inside the class definition but cannot be referenced externally. 
- `protected` is relevant only in the context of inheritance (discussed later)
- Public variables violate encapsulation. They allow code external to the class in which the data are defined to reach in and access or modify the value of the data. 
- `Instance data should be defined with private visibility.` Data declared as private can be accessed only by the methods of the class.
- `Service Methods`: Methods that provide services to the client must be declared with public visibility so that they can be invoked by the client.
- The reason why giving constants public visibility is generally considered acceptable is that even though their values can be accessed directly, their values cannot be changed because they were declared using the final modifier. 
- Constants, by definition, cannot be changed, the encapsulation issue is largely moot.
- `Accessor Method`: provides read-only access to a particular value. 
	- Generally, accessor method names have the form `getX`, where `X` is the value to which the method provides access. 
- `Mutator Method`: changes a particular value. 
	- Mutator method names have the form `setX`, where `X` is the value the method is setting.
- These are generally referred to as `getters` and `setters`
	- EX: If a class contains the instance variable `height`, it should also probably contain the methods `getHeight` and `setHeight`. Note that this naming convention capitalizes the first letter of the variable when it is used in the method names, which is consistent with how method names are written in general.

## The Anatomy of a Method
- A method is a group of programming language statements that is given a name.
- A method declaration specifies the code that is executed when the method is invoked. Every method in a Java program is part of a particular class.
- The header of a method declaration includes the type of the return value, the method name, and a list of parameters that the method accepts. 
- The statements that make up the body of the method are defined in a block delimited by braces.
- When a method is called, control transfers to that method. One by one, the statements of that method are executed. When that method is done, control returns to the location where the call was made, and execution continues.
- The `called method` (the one that is invoked) might be part of the same class as the calling method that invoked it. If the called method is part of the same class, only the method name is needed to invoke it.
	- If it is part of a different class, it is invoked through a reference to an object of that other class.
- A constructor of a class can instantiate an object within itself, in addition to other methods that act on the class. EX: 

```java

public class Account
{
private final double RATE = 0.035; // interest rate of 3.5%
private String name;
private long acctNumber;
private double balance;
//------------------------------------------------------------------
// Sets up this account with the specified owner, account number,
// and initial balance.
//------------------------------------------------------------------
public Account(String owner, long account, double initial)
{
	name = owner;
	acctNumber = account;
	balance = initial;
}
```

### The return statements
- The return type specified in the method header can be a primitive type, a class name, or the reserved word void. 
- When a method does not return any value, `void` is used as the return type, as is always done with the main method of a program. 
- A method that returns a value must have a `return statement`. When a return statement is executed, control is immediately returned to the statement in the calling method, and processing continues there.


### Parameters
- A value that is passed into a method when the method is invoked.
- Parameters provide data to a method that allow the method to do its job. 
- `Formal parameters`: The names of the parameters in the header of the method declaration
- `Actual parameters`, or `argument`: The values passed into a method when it is invoked
- When a method is called, the value in each actual parameter is copied and stored in the corresponding formal parameter. Actual parameters can be literals, variables, or full expressions.
- The parameter lists in the invocation and the method declaration must match up. 

### Local Data
- The scope of a variable or constant is the part of a program in which a valid reference to that variable can be made.
- A `local variable` simply does not exist outside the method in which it is declared.
- `Instance data`, declared at the class level, have a
scope of the entire class; any method of the class can refer to instance data.
- Because local data and instance data operate at different levels of scope, it’s possible to declare a local variable inside a method with the same name as an instance variable declared at the class level.
- Referring to that name in the method will reference the local version of the variable. This naming practice obviously has the potential to confuse anyone reading the code, so it should be avoided.
- The formal parameter names in a method header serve as local data for that method. They don’t exist until the method is called, and they cease to exist when the method is exited.
	- EX: For example, the formal parameter owner in the Account constructor comes into existence when the constructor is called and goes out of existence when it finishes executing. To store these values in the object, the val ues of the parameters are copied into the instance variables of the newly created Account object.

### Constructors Revisited
- When we define a class, we usually define a constructor to help us set up the class. In particular, we often use a constructor to initialize the variables associated with each object.
- A constructor differs from a regular method in two ways:
	- First, the name of a constructor is the same as the name of the class. Therefore, the name of the constructor in the Die class is Die, and the name of
the constructor in the Account class is Account. 
	- `A constructor cannot return a value and does not have a return type specified in the method header.`
- Generally, a constructor is used to initialize the newly instantiated object.
- A mistake commonly made by programmers is to put a void return type on a constructor. As far as the compiler is concerned, putting any return type on a constructor, even void, turns it into a regular method that happens to have the same name as the class. As such, it cannot be invoked as a constructor. This leads to error messages that are sometimes difficult to decipher.
- If we don’t provide a constructor for a class, a default constructor that takes no parameters is automatically created and used. The default constructor generally has no effect on the newly created object. If the programmer provides a constructor, with or without parameters, the default constructor is not defined.

## Static Class Members
- A static method is one that is invoked through its class name, instead of through an object of that class.
- Not only can methods be static, but variables can be static as well. We declare
static class members using the `static` modifier
- EX: all the methods of the `Math` class are static.

### Status Variables
- So far, we’ve seen two categories of variables: local variables that are
declared inside a method, and instance variables that are declared in a class but not inside a method.
- The term `instance variable` is used because each instance of the class has its own version of the variable. That is, each object has distinct memory space for each variable so that each object can have a distinct value for that variable.
- A `static variable`, which is sometimes called a `class variable`, is shared among all instances of a class. There is only one copy of a static variable for all objects of the class. Therefore, changing the value of a static variable in one object changes it for all of the others. 
- Memory space for a static variable is established when the class that contains it is referenced for the first time in a program. A local variable declared within a method cannot be static.
- Constants, which are declared using the `final` modifier, are often declared
using the static modifier. Because the value of constants cannot be changed, there might as well be only one copy of the value across all objects of the class.

### Static Methods
- `Static methods` (aka `class methods`) can be invoked through the class name. We don’t have to instantiate an object of the class in order to invoke the method.
	- EX: 
	```java
	System.out.println("Square root of 27:" + Math.sqrt(27));
	```
	- The methods in the Math class perform basic computations based on values passed as parameters. There is no object state to maintain in these situations, so there is no good reason to force us to create an object in order to request these services. 
- A method is made static by using the `static` modifier in the method declaration. As we’ve seen many times, the `main` method of a Java program is declared with the `static modifier`; this is done so that main can be executed by the interpreter without instantiating an object from the class that contains `main`.
- Because static methods do not operate in the context of a particular object, they cannot reference instance variables, which exist only in an instance of a class.
	- The compiler will issue an error if a static method attempts to use a non- static variable. A static method can, however, reference static variables, because static variables exist independent of specific objects. Therefore, all static methods, including the `main` method, can access only static or local variables.
	- EX: confused? Go to pg. 203: The getCount method could have been declared without the static modifier, but then its invocation in the main method would have had to be done through an instance of the Slogan class instead of the class itself.

## Class Relationships
- The classes in a software system have various types of relationships to each other. Three of the more common relationships are dependency, aggregation, and inheritance.
	- `Dependency relationship`: one class “uses” another or one class depends on itself. 
	- `Aggregation relationship`: the objects of one class contain objects of another, creating a “has-a” relationship.
	`Inheritance relationship`: TBD

### Dependency
- One class relies on another in some sense. Often the methods of one class invoke the methods of the other class. This establishes a “uses” relationship.
- Generally, if class A uses class B, then one or more methods of class A invoke
one or more methods of class B. If an invoked method is static, then A merely references B by name. If the invoked method is not static, then A must have access to a specific instance of class B in order to invoke the method. That is, A must have a reference to an object of class B.
- The way in which one object gains access to an object of another class is an
important design decision. It occurs when one class instantiates the objects of another, but the access can also be accomplished by passing one object to another as a method parameter.
- In general, we want to minimize the number of dependencies among classes. The less dependent our classes are on each other, the less impact changes and errors will have on the system.

### Dependencies among Objects of the Same Class
- In some cases, a class depends on itself. That is, an object of one class interacts with another object of the same class. To accomplish this, a method of the class may accept as a parameter an object of the same class.
- The `concat` method of the String class is an example of this situation. The
method is executed through one String object and is passed another String object as a parameter. EX: 
	```java
	str3 = str1.concat(str2);
	```
	- The String object executing the method (str1) appends its characters to those of the String passed as a parameter (str2). A new String object is returned as a result and stored as str3.

### Aggregation
- Some objects are made up of other objects. A car, for instance, is made up of its engine, its chassis, its wheels, and several other parts. 
	- Therefore, we can say that a car is an aggregation—it is	composed, at least in part, of other objects. Aggregation is sometimes described as a `has-a relationship`. For instance, a car “has-a”	chassis.
- In the software world, we define an aggregate object as any object that contains references to other objects as instance data
- Aggregation is a special type of dependency. That is, a class that is defined in part by another class is dependent on that class. The methods of the aggregate object generally invoke the methods of the objects of which it is composed.
- The more complex an object, the more likely it is that it will need to be represented as an aggregate object. [See aggregate UML design](./aggregate.png)

### this
- It allows an object to refer to itself. As we have discussed, a nonstatic method is invoked through (or by) a particular object or class. Inside that method, the this reference can be used to refer to the currently executing object.
- EX: in a class called `ChessPiece` there could be a method called `move`,
which could contain: 

```java
if (this.position == piece2.position)
	result = false;
	```
	- In this situation, the `this` reference is being used to clarify which position is being referenced. The this reference refers to the object through which the method was invoked. 
- When the following line is used to invoke the method, the this reference refers to `bishop1`: 

	```java
	bishop1.move();
	```
	- However, when another object is used to invoke the method, the this reference refers to it. Therefore, when the following invocation is used, the this reference in the move method refers to bishop2:
	```java
	bishop2.move();
	```

- Often, the `this` reference is used to distinguish the parameters of a constructor from their corresponding instance variables with the same names.

## Method Design
- Once you have identified classes and assigned basic responsibilities, the design of each method will determine how exactly the class will define its behaviors. Some methods are straightforward and require little thought. Others are more interesting and require careful planning.
- An `algorithm` is a step-by-step process for solving a problem. A recipe is an example of an algorithm. Travel directions are another example of an algorithm. Every method implements an algorithm that determines how that method accomplishes its goals.

## Method Decomposition
- The best way to make use of a complex service provided by an object may be to decompose the method and use several private support methods to help with the task.
- Occasionally, a service that an object provides is so complex that it cannot reasonably be implemented using one method. Therefore, we sometimes need to decompose a method into multiple methods to create a more understandable design. 

### Method Params Revisited
- Another important issue related to method design involves the way parameters are passed into a method. In Java, all parameters are passed by value, AKA the current value of the actual parameter (in the invocation) is copied into the formal parameter in the method header. 
- Essentially, parameter passing is like an assignment statement, assigning to the formal parameter a copy of the value stored in the actual parameter. This issue must be considered when making changes to a formal parameter inside a method. The formal parameter is a separate copy of the value that is passed in, so any changes made to it have no effect on the actual parameter. After control returns to the calling method, the actual parameter will have the same value it had before the method was called.
- `However, when we pass an object to a method, we are actually passing a reference to that object.` The value that gets copied is the address of the object.
	- Therefore, the formal parameter and the actual parameter become aliases of each other.
- If we change the state of the object through the formal parameter reference inside the method, we are changing the object referenced by the actual parameter, because they refer to the same object.
	- On the other hand, if we change the formal parameter reference itself (to make it point to a new object, for instance), we have not changed the fact that the actual parameter still refers to the original object.

## Method Overloading
- When a method is invoked, control transfers to the code that defines the method. After the method has been executed, control returns to the location of the call, and processing continues.
- `Method Overloading`: when you can use the same method name with different parameter lists for multiple methods.
- It is useful when you need to perform similar methods on different types of data.
- The compiler must still be able to associate each invocation with a specific method declaration. If the method name for two or more methods is the same, additional information is used to uniquely identify the version that is being invoked. 
	- In Java, a method name
can be used for multiple methods as long as the number of parameters, the types of those parameters, and/or the order of the types of parameters is distinct. 
- EX: we could declare a method called sum and then  declare another method called sum, within the same class, as follows:

```java
public int sum(int num1, int num2)
{
	return num1 + num2;
}
public int sum(int num1, int num2, int num3)
{
	return num1 + num2 + num3;
}
```

- Now, when an invocation is made, the compiler looks at the number of parameters to determine which version of the sum method to call. For instance, the following invocation will call the second version of the sum method:

```java
sum(25, 69, 13);
```

- A method’s name, along with the number, type, and order of its parameters, is called the method’s signature. The compiler uses the complete method signature to bind a method invocation to the appropriate definition.
- The compiler must be able to examine a method invocation to determine which specific method is being invoked. If you attempt to specify two method names with the same signature, the compiler will issue an appropriate error message and will not create an executable program. There can be no ambiguity.
- Note that the return type of a method is not part of the method signature. That
is, two overloaded methods cannot differ only by their return type. 
	- This is because the value returned by a method can be ignored by the invocation. The compiler would not be able to tell which version of an overloaded method was being referenced in such situations.
- Constructors can be overloaded, and they often are. By providing multiple versions of a constructor, we provide multiple ways to set up an object.

## Testing
- As our programs become larger and more complex, it becomes more difficult to ensure their accuracy and reliability. 
- Testing certainly includes its traditional definition: the act of running a completed program with various inputs to discover problems. But it also includes any evaluation that is performed by human or machine to assess the quality of the evolving system. These evaluations should occur long before a single line of code is written.
- The goal of testing is to find errors. By finding errors and fixing them, we improve the quality of our program. It’s likely that later on, someone else will find any errors that remain hidden during development. The earlier the errors are
found, the easier and cheaper they are to fix. Taking the time to uncover problems as early as possible is almost always worth the effort.
- It is possible to prove that a program is correct, but that technique is enormously complex for large systems, and errors can be made in the proof itself.
Therefore, we generally rely on testing to determine the quality of a program.
- After determining that an error exists, we determine the cause of the error and fix it. After a problem is fixed, we should run the previously administered tests again to make sure that while fixing the problem, we didn’t create another. This
technique is called `regression testing`.

### Reviews
- One technique used to evaluate design or code is called a review, which is a meeting in which several people carefully examine a design document or section of
code. 
- A design review should determine whether the requirements are addressed. It
should also assess the way the system is decomposed into classes and objects. 
- A code review should determine how faithfully the design satisfies the requirements and how faithfully the implementation represents the design. It should identify any specific problems that would cause the design or the implementation to fail in its responsibilities.

### Defect Testing
- Because the goal of testing is to find errors, it is often referred to as `defect testing`.
- With that goal in mind, a good test is one that uncovers any deficiencies in a program. This might seem strange, because we ultimately don’t want to have problems in our system. But keep in mind that errors almost certainly exist.
- A test case is a set of inputs, user actions, or other initial conditions, and the expected output. A test case should be appropriately documented so that it can be repeated later as needed. Developers often create a complete test suite, which is a set of test cases that covers various aspects of the system.
- `black-box testing`: test cases are developed without regard to the internal workings. Black-box tests are based on inputs and outputs. An entire program can be tested using a black-box technique, in which case the inputs are the user-provided information and user actions such as button pushes.
- `Equivalence category`:  a collection of inputs that are expected to produce similar outputs. The input data for a black-box test case are often selected by defining equivalence categories. 
	- Equivalence categories have defined boundaries. Because all values of an equivalence category essentially test the same features of a program, only one test case
	inside the equivalence boundary is needed. 
-  For an integer boundary, a good test suite would include at least the exact value of the boundary, the boundary minus 1, and the boundary plus 1. Test cases that use these cases, plus at least one from within the general field of the category, should be defined.
- `White-box testing`: exercises the internal structure and implementation of a method. A white-box test case is based on the logic of the code. 
	-  A white-box test maps the possible paths through the code and ensures that the test cases cause every path to be executed. This type of testing is often called statement coverage.
- `Unit testing`: creates a test case for each module of code (method) that has been authored. The goal of unit testing is to ensure correctness of the methods (units), one method at a time.

### Integration Testing
- During integration testing, modules that were individually tested during unit testing are now tested as a collection. 
- Typically, the goal of integration testing is to examine the correctness of large components of a system.

### System Testing
- System testing seeks to test the entire software system and how its implementation adheres to its requirements. 
- You may be familiar with public alpha or beta testing of applications or operating systems. Alpha and beta tests are system tests applied before the formal release and availability of a software product.

### Test-Driven Development
- Ideally, developers should be writing test cases concurrently with the development
of the source code that their applications use.
- The test-driven approach requires that developers periodically (during development and implementation) test their code using the implemented test cases. 
- The steps include: 
1. Create a test case that tests a specific method that has yet to be completed.
2. Execute all of the test cases present, and verify that all test cases pass except for the most recently implemented test case.
3. Develop the method that the test case targets so that the test case will pass without errors.
4. Re-execute all of the test cases, and verify that every test case passes, including the most recently implemented test case.
5. Clean up the code to eliminate any redundant portions introduced by the development of the most recent method. This step is known as refactoring the code.
6. Repeat the process starting with Step 1.

## Debugging
-  Debugging is the act of locating and correcting run-time and logic errors in your programs.
-  A debugger is a software application that allows us to observe these inner workings as the program executes. 
- One of the most simplistic approaches to debugging involves the use of print-
ing. That is, scattered throughout a program can be `print` and `println` statements that output various information either to the screen or to an output file.

### Debugging Concepts
- Debugging through printing can take us only so far. Most of the time, this style of debugging can be effectively used to identify what is happening during execution, or the value of a variable at a certain point in the program. 

- A debugger allows us to do the following:
	-Set one or more breakpoints in our program. In the debugger, we can examine the source code and set special flags or triggers on one or more lines of code. When execution of the program comes across a statement that has been flagged, execution stops.
	- Print the value of a variable or object. Once we have reached a breakpoint and execution has stopped, the debugger allows us to display the value of a variable or examine the state of an object. Generally, these types of displays are to the screen and only within the confines of the debugger application.
	- Step into or over a method. If we set a breakpoint at a statement that is a call to a method, when execution reaches this breakpoint and the program stops, the developer can choose to enter into the method and continue debugging or to step over the method, bypassing the display of the execution of the statements contained in the method. In stepping over the method, we should note that the method is still executed, but we have chosen not to delve into the method. Consider the call to the printing of a string of output to the screen. We probably don’t need to step into the `println` method of the System.out object. It’s likely to have been fully debugged already (and we can’t change its behavior anyway).
	- Execute the next single statement. After reaching a breakpoint, the developer can choose to execute the next single statement (also known as a step). By executing a single step, we can literally control the execution of our program one statement at a time. Developers often perform stepping to be sure they understand the flow of execution and to give themselves an opportunity to display the value of a variable following each step, if desired.
	- Continue execution. Once a program has stopped due to a breakpoint, or is waiting for the developers to decide whether they will step into, step over, or single step, the developers can also continue execution. Continuing execution will result in the program running each statement without pausing until the program ends, it encounters another breakpoint, or a run-time error occurs.


