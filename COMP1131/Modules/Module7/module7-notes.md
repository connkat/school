# Recursion

## Recursive Thinking
- Recursion is a programming technique in which a method calls itself. A key to being able to program recursively is to be able to think recursively.
- In general, recursion is the process of defining something in terms of itself. EX:  consider the following definition of the word decoration: `decoration: n. any ornament or adornment used to decorate something.` The word decorate is used to define the word decoration. You may recall your grade-school teacher telling you to avoid such recursive definitions when explaining the meaning of a word. However, in many situations, recursion is an appropriate way to express an idea or definition.
	- EX: suppose we want to ­ formally define a list of one or more numbers, separated by commas. Such a list can be defined recursively either as a number or as a number followed by a comma followed by a list: 
	- `List is a : number`
	- `or a: number comma list`
- No matter how long a list is, the recursive definition describes it. A list of one element, such as in the last example, is defined completely by the first (non-recursive) part of the definition. For any list longer than one element, the recursive part of the definition (the part that refers to itself) is used as many times as necessary, until the last element is reached. The last element in the list is always defined by the non-recursive part of this definition.

### Infinite Recursion
- Note that this definition of a list contains one option that is recursive, and one option that is not. The part of the definition that is not recursive is called the base case. If all options had a recursive component, then the recursion would never end.
	- EX: if the definition of a list were simply “a number followed by a comma followed by a list,” then no list could ever end. This problem is called infinite recursion. It is similar to an infinite loop, except that the “loop” occurs in the definition itself.
- As in the infinite loop problem, a programmer must be careful to design algorithms so that they avoid infinite recursion. Any recursive definition must have a base case that does not result in a recursive option. `The base case of the list definition is a single number that is not followed by anything.` In other words, when the last number in the list is reached, the base case option terminates the recursive path.

### Recursion in Math
- Mathematical problems and formulas are often expressed recursively. An example: 
	- The value referred to as N! (which is pronounced N factorial) is defined for any positive integer N as the product of all integers between 1 and N inclusive. Therefore, `3! = 3*2*1 = 6` and `5! = 5*4*3*2*1 = 120` Mathematical formulas are often expressed recursively. 
	- The definition of `N!` can be expressed recursively as: 
		`1! = 1`
		`N! = N * (N-1)! for N > 1`
	- The base case of this definition is 1!, which is defined to be 1. All other values of `N! (for N > 1)` are defined recursively as N times the value `(N-1)!`. The recursion is that the factorial function is defined in terms of the factorial function.
- Common error: A common error made by programmers new to recursion is to provide an incomplete base case. The reason why the base case for the factorial
problem `(N = 1)` works is that factorial is defined only for positive integers. A common error would be to set a base case of `N = 1` when there is some possibility that N could be less than 1. It is important to account for all of the possibilities: `N > 1`, `N = 1`, and `N < 1`.
- Using this definition, `50!` is equal to `50 * 49!`. And `49!` is equal to `49 * 48!`. And `48!` is equal to `48 * 47!`. This process continues until we get to the base case of 1. Because N! is defined only for positive integers, this definition is complete and will always conclude with the base case.

## Recursive Programming
- Each recursive call to a method creates new local variables and parameters.
- Consider the process of summing the values between 1 and N inclusive, where N is any positive integer. The sum of the values from 1 to N can be expressed as N plus the sum of the values from 1 to N-1. (see [Diagram](Modules/Module7/sum-of-nums.png))
	- EX: the sum of the values between 1 and 20 is equal to 20 plus the sum of the values between 1 and 19. Continuing this approach, the sum of the values between 1 and 19 is equal to 19 plus the sum of the values between 1 and 18. This may sound like a strange way to think about this problem, but it is a straightforward example that can be used to demonstrate how recursion is programmed.
	- EX:
	```java
	public int sum(int n) {
    // Base case
    if (n == 1) {
        return 1;
    }
    // Recursive case
    else {
        return n + sum(n - 1);
    }
	}
	```
	- If we call sum(20), here's what happens:
		- Is 20 == 1? No, so we return 20 + sum(19)
		- To calculate sum(19): Is 19 == 1? No, so we return 19 + sum(18)
		- This continues all the way down...
		- Eventually we call sum(1): Is 1 == 1? Yes, so we return 1
		- Then we work our way back up, calculating each sum
		- It looks like this: 
			```
			sum(20) = 20 + sum(19)
        = 20 + (19 + sum(18))
        = 20 + (19 + (18 + sum(17)))
        ...
        = 20 + 19 + 18 + ... + 2 + 1
        = 210
			```
- In Java, as in many other programming languages, a method can call itself. Each call to the method creates a new environment in which to work. That is, all local variables and parameters are newly defined with their own unique data space every time the method is called. Each parameter is given an initial value based on the new call.
- Each time a method terminates, processing returns to the method that called it (which may be an earlier invocation of the same method). These rules are no different from those governing any “regular” method invocation.
- A recursive solution to the summation problem is defined by the following recursive method called `sum`:
	// This method returns the sum of 1 to num
```java
public int sum(int num)
{
	int result;
	if (num == 1)
		result = 1;
	else
		result = num + sum(num-1);
	return result;
}
```
- Note that this method essentially embodies our recursive definition that the sum of the numbers between 1 and N is equal to N plus the sum of the numbers between 1 and N–1. The sum method is recursive because sum calls itself. The parameter passed to sum is decremented each time sum is called, until it reaches the base case of 1.
- Recursive methods usually contain an if-else statement, with one of the branches representing the base case.
	- Calling a method within itself with a different parameter value:
	```java
	public int sum (int num)
	{
		…
		result = num + sum(num-1);
		…
	}
	```
- Suppose the main method calls sum, passing it an initial value of 1, which is stored in the parameter num. Because num is equal to 1, the result of 1 is returned to main, and no recursion occurs.
- Now let’s trace the execution of the `sum` method when it is passed an initial value of `2`. 
	- Because num does not equal `1`, sum is called again with an argument of `num-1`, or `1`. 
	- This is a new call to the method `sum`, with a new parameter `num` and a new local variable result. 
	- Because this `num` is equal to `1` in this invocation, the result of `1` is returned without further recursive calls. 
	- Control returns to the first version of `sum` that was invoked. 
	- The return value of `1` is added to the initial value of `num` in that call to `sum`, which is `2`. 
	- Therefore, result is assigned the value `3`, which is returned to the main method. 
	- The method called from main correctly calculates the sum of the integers from `1` to `2` and returns the result of `3`.
- The base case in the summation example is when num equals 1, at which point no further recursive calls are made. The recursion begins to fold back into the earlier versions of the sum method, returning the appropriate value each time.
- Each return value contributes to the computation of the sum at the higher level. Without the base case, infinite recursion would result. Because each call to a method requires additional memory space, infinite recursion often results in a run-time error indicating that memory has been exhausted.

### Recursion vs Iteration
- Recursion is the most elegant and appropriate way to solve some problems, but for others it is less intuitive than an iterative solution.
- Of course, there is an iterative solution to the summation problem we just explored:
	```java
	sum = 0;
	for (int number = 1; number <= num; number++)
		sum += number;
	```
	- This solution is certainly more straightforward than the recursive version, the sum of the numbers from 1 to N can be computed in a single step: `sum = num * (num + 1) / 2;`
- It is important to know when recursion provides an appropriate solution to a problem. We used the summation problem to demonstrate recursion because it is a simple problem to understand, not because one would use recursion to solve it under normal conditions.

## Direct vs Indirect Recursion
- Direct recursion occurs when a method invokes itself, such as when sum calls sum. 
- Indirect recursion occurs when a method invokes another method, eventually resulting in the original method being invoked again.
- EX: if method `m1` invokes method `m2`, and `m2` invokes method `m1`, we can say that `m1` is indirectly recursive. 
	- The amount of indirection could be several levels deep, as when `m1` invokes `m2`, which invokes `m3`, which invokes `m4`, which invokes `m1`.
- Indirect recursion requires paying just as much same attention to base cases as direct recursion does. Furthermore, indirect recursion can be more difficult to trace because of the intervening method calls. Therefore, extra care is warranted when designing or evaluating indirectly recursive methods. Ensure that the indirection is truly necessary and that it is clearly explained in documentation.

## Using Recursion

### Traversing a Maze
-  We can solve this problem recursively by using the run-time stack to keep track of our progress. See [UML Diagram](Modules/Module7/UML-maze.png)
- `The MazeTester` program shown in creates a Maze object and attempts to traverse it: 
	```java
	import java.util.*;
	import java.io.*;
	/**
	*
	* MazeTester uses recursion to determine if a maze can be traversed.
	* @author Java Foundations
	* @version 4.0
	*/
	public class MazeTester
	{
		/**
		*/
		* Creates a new maze, prints its original form, attempts to
		* solve it, and prints out its final form.
		public static void main(String[] args) throws FileNotFoundException
		{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of the file containing the maze: ");
		String filename = scan.nextLine();

		Maze labyrinth = new Maze(filename);
		System.out.println(labyrinth);
		
		MazeSolver solver = new MazeSolver(labyrinth);
		if (solver.traverse(0, 0))
			System.out.println("The maze was successfully traversed!");
		else
			System.out.println("There is no possible path.");
			System.out.println(labyrinth);
		}
	}
	```
- `The Maze class` uses a two-dimensional array of integers to represent the maze. The maze is loaded from a file. The goal is to move from the top left corner (the entry point) to the bottom right corner (the exit point): 
	```java
	import java.util.*;
	import java.io.*;
	/**
	*
	* Maze represents a maze of characters. The goal is to get from the
	* top left corner to the bottom right, following a path of 1’s. Arbitrary
	* constants are used to represent locations in the maze that have been TRIED
	* and that are part of the solution PATH.
	* @author Java Foundations
	* @version 4.0
	*/
	public class Maze
	{
		private static final int TRIED = 2;
		private static final int PATH = 3;

		private int numberRows, numberColumns;
		private int[][] grid;

		/**
		* Constructor for the Maze class. Loads a maze from the given file.
		* Throws a FileNotFoundException if the given file is not found.
		* @param filename the name of the file to load
		* @throws FileNotFoundException if the given file is not found
		*/
		public Maze(String filename) throws FileNotFoundException
		{
			Scanner scan = new Scanner(new File(filename));
			numberRows = scan.nextInt();
			numberColumns = scan.nextInt();

			grid = new int[numberRows][numberColumns];
			for (int i = 0; i < numberRows; i++)
				for (int j = 0; j < numberColumns; j++)
				grid[i][j] = scan.nextInt();
		}
		/**
		*
		* Marks the specified position in the maze as TRIED
		*
		* @param row the index of the row to try
		* @param col the index of the column to try
		*/

		public void tryPosition(int row, int col)
		{
			grid[row][col] = TRIED;
		}

		/* 
		* Return the number of rows in this maze
		* Return the number of rows in this maze
		*
		* @return the number of rows in this maze
		*/
		public int getRows()
		{
			return grid.length;
		}

		/*
		* Return the number of columns in this maze
		*
		* @return the number of columns in this maze
		*/

		public int getColumns()
		{
			return grid[0].length;
		}

		/**
		*
		* Marks a given position in the maze as part of the PATH
		* @param row the index of the row to mark as part of the PATH
		* @param col the index of the column to mark as part of the PATH
		*/
		public void markPath(int row, int col)
		{
			grid[row][col] = PATH;
		}

		/**
		*
		* Determines if a specific location is valid. A valid location
		* is one that is on the grid, is not blocked, and has not been TRIED.
		* @param row the row to be checked
		* @param column the column to be checked
		* @return true if the location is valid
		*/
		public boolean validPosition(int row, int column)
		{
			boolean result = false;
			// check if cell is in the bounds of the matrix
			if (row >= 0 && row < grid.length &&
				column >= 0 && column < grid[row].length)
			// check if cell is not blocked and not previously tried
			if (grid[row][column] == 1)
				result = true;
			return result;
		}

		/**
		*
		* Returns the maze as a string.
		* @return a string representation of the maze
		*/
		public String toString()
		{
			String result = "\n";
			for (int row=0; row < grid.length; row++)
			{
				for (int column=0; column < grid[row].length; column++)
					result += grid[row][column] + "";
				result += "\n";
			}
			return result;
		}
	}
	```
- Initially, a `1` indicates a clear path, and a `0` indicates a blocked path. As the maze is solved, these array elements are changed to other values to indicate attempted paths and, ultimately, a successful path through the maze if one exists. 
- The only valid moves through the maze are in the four primary directions:
down, right, up, and left. No diagonal moves are allowed.
- Let’s think this through recursively. The maze can be traversed successfully if it can be traversed successfully from position `(0, 0)`. Therefore, the maze can be traversed successfully if it can be traversed successfully from any position adjacent to `(0, 0)`—namely, position `(1, 0)`, position `(0, 1)`, position `(-1, 0)`, or position `(0, -1)`. Picking a potential next step, say `(1, 0)`, we find ourselves in the same type of situation as before.
- To traverse the maze successfully from the new current position, we must successfully traverse it from an adjacent position. At any point, some of the adjacent positions may be invalid, may be blocked, or may represent a possible successful path. We continue this process recursively. If the base case position is reached, the maze has been traversed successfully.
- MazeSolver: 
	```java
	/**
	*
	* MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
	* given starting position to the bottom right, following a path of 1’s. Arbitrary
	* constants are used to represent locations in the maze that have been TRIED
	* and that are part of the solution PATH.
	* @author Java Foundations
	* @version 4.0
	*/
	public class MazeSolver
	{
		private Maze maze;
		/**
		* Constructor for the MazeSolver class.
		*/
		public MazeSolver(Maze maze)
		{
			this.maze = maze;
		}
		/**
		*
		* Attempts to recursively traverse the maze. Inserts special
		* characters indicating locations that have been TRIED and that
		* eventually become part of the solution PATH.
		* @param row row index of current location
		* @param column column index of current location
		* @return true if the maze has been solved
		*/
		public boolean traverse(int row, int column)
		{
			boolean done = false;
			if (maze.validPosition(row, column))
			{
				maze.tryPosition(row, column); // mark this cell as tried
				
				if (row == maze.getRows()-1 && column == maze.getColumns()-1)
					done = true; // the maze is solved
				else
				{
					done = traverse(row+1, column); if (!done) // down
					if (!done)
						done = traverse(row, column+1); // right
					if (!done)
						done = traverse(row-1, column); // up
					if (!done)
						done = traverse(row, column-1); // left
				}

				if (done) // this location is part of the final path
					maze.markPath(row, column);
			}
			return done;
		}
	}
	```
- The recursive method in the MazeSolver class is called `traverse`. 
	- It returns a `boolean` value that indicates whether a solution was found: - First the method determines whether a move to the specified row and column is valid. A move is considered valid if it stays within the grid boundaries and if the grid contains a `1` in that location, indicating that a move in that direction is not blocked. 
	- The initial call to traverse passes in the upper left location `(0, 0)`.
	- If the move is valid, the grid entry is changed from a `1` to a `2`, marking this location as visited so that we don’t later retrace our steps. Then the `traverse` method determines whether the maze has been completed by having reached the bottom right location. 
	- Therefore, there are actually three possibilities of the base case for this problem that will terminate any particular recursive path:
		- An invalid move because the move is out of bounds or blocked
		- An invalid move because the move has been tried before
		- A move that arrives at the final location
	- If the current location is not the bottom right corner, we search for a solution in each of the primary directions, if necessary: 
		- First, we look down by recursively calling the traverse method and passing in the new location. 
		- The logic of the traverse method starts all over again using this new position. 
		- Either a solution is ultimately found by first attempting to move down from the current location, or it is not found. 
		- If it’s not found, we try moving right. If that fails, we try moving up.
		- Finally, if no other direction has yielded a correct path, we try moving left. 
		- If no direction from the current location yields a correct solution, then there is no path from this location, and traverse returns false. 
		- If the very first invocation of the traverse method returns false, then there is no possible path through this maze.
		- If a solution is found from the current location, then the grid entry is changed to a 3. 
			- The first 3 is placed in the bottom right corner. The next 3 is placed in the location that led to the bottom right corner, and so on until the final 3 is placed in the upper left corner. 
			- Therefore, when the final maze is printed: 
				- 0 still indicates a blocked path, 
				- 1 indicates an open path that was never tried, 
				- 2 indicates a path that was tried but failed to yield a correct solution, and 
				- 3 indicates a part of the final solution of the maze.
	- Here are a sample maze input file and its corresponding output:
	```
	5 5
	1 0 0 0 0
	1 1 1 1 0
	0 1 0 0 0
	1 1 1 1 0
	0 1 0 1 1
	3 0 0 0 0
	3 3 1 1 0
	0 3 0 0 0
	1 3 3 3 0
	0 2 0 3 3
	```
	- Note that there are several opportunities for recursion in each call to the
traverse method. Any or all of them might be followed, depending on the maze
configuration. Although there may be many paths through the maze, the recursion
terminates when a path is found. 

### The Towers of Hanoi
- The Towers of Hanoi puzzle was invented in the 1880s by Edouard Lucas, a French mathematician. It has become a favorite among computer scientists be-
cause its solution is an excellent demonstration of recursive elegance.
- The puzzle consists of three upright pegs (towers) and a set of disks with holes in the middle so that they slide onto the pegs. Each disk has a different diameter. Initially, all of the disks are stacked on one peg in order of size such that the largest disk is on the bottom, as shown [here](Modules/Module7/towers-of-hanoi.png) (and the solution [here](Modules/Module7/towers-solution.png))
- These rules imply that we must move smaller disks “out of the way” in order to move a larger disk from one peg to another. To move all three disks from the first peg to the third peg, we first have to get to the point where the smaller two disks are out of the way on the second peg so that the largest disk can be moved from the first peg to the third peg.
- The last three moves put the smaller disks in their final place on top of the largest one. Let’s use this idea to form a general strategy. To move a stack of N disks from the original peg to the destination peg:
	- Move the topmost N–1 disks from the original peg to the extra peg.
	- Move the largest disk from the original peg to the destination peg.
	- Move the N–1 disks from the extra peg to the destination peg.
- This strategy lends itself nicely to a recursive solution. The step to move the N–1 disks out of the way is the same problem all over again: moving a stack of disks. For this subtask, though, there is one less disk, and our destination peg is what we were originally calling the extra peg. An analogous situation occurs after we have moved the largest disk, and we have to move the original N–1 disks again.
```java
	/**
	*
	* SolveTowers uses recursion to solve the Towers of Hanoi puzzle.
	* @author Java Foundations
	* @version 4.0
	*/
	public class SolveTowers
	{
		/**
		* Creates a TowersOfHanoi puzzle and solves it.
		*/
		public static void main(String[] args)
		{
			TowersOfHanoi towers = new TowersOfHanoi(4);
			towers.solve();
		}
	}
```

## Analyzing Recursive Algorithms
- The order of a recursive algorithm can be determined using techniques similar to those used in analyzing iterative processing.
- When analyzing a loop, we determined the order of the body of the loop and multiplied it by the number of times the loop was executed. Analyzing a recursive algorithm uses similar thinking. Determining the order of a recursive algorithm is a matter of determining the order of the recursion (the number of times the recursive definition is fo
- EX: 
```java
	public int sum (int num)
	{
		int result;
		if (num == 1)
			result = 1;
		else
			result = num + sum (num-1);
		return result;
	}
```
- The size of this problem is naturally expressed as the number of values to be summed. Because we are summing the integers from 1 to num, the number of values to be summed is num. The operation of interest is the act of adding two values together. The body of the recursive method performs one addition operation, and therefore is O(1).
- Each time the recursive method is invoked, the value of num is decreased by 1. Therefore, the recursive method is called num times, so the order of the recursion is O(n).
- Thus, because the body is O(1) and the recursion is O(n), the order of the entire algorithm is O(n).
- The Towers of Hanoi solution has exponential complexity, which is very inefficient, yet the code is remarkably short and elegant.
