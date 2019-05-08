## Solving the N-queen problem using hill climbing Algorithm ##

### 1. N-queen ###
N-queen problem revolves around placing N number of queens on a NxN chessboard such that no two queens can attack each other.
Problem Formulation:
Goal: N queens are on the board, with no queens attacking each other
States: all arrangements of 0-N queens on the board
Initial state: 0 queens on the board
Successor function: each successor is obtained by adding one queen in an empty square

### 2. Program Structure ###
The programming language used for this project was Java. We’ve divided the program into seven classes. <br> <br>
Queen: Class – handles number of rows and columns and checks for attacks
Functions:
1. checkAttack: checks for any queen attacking another queen
2. getRows: returns number of rows
3. getColumns: returns number of columns
4. Queen(constructor): assigns values for rows and columns
5. goDown: moves downwards row by row Global Variables: r, c (row, column) <br> <br>
Node: Class – creates starting and neighbouring nodes
Functions:
1. createNode: generates and returns neighbour nodes of the starting state
2. getSize: returns size of the chessboard
3. setSize: sets size of the chessboard
4. calculateH: calculates the heuristic value by calculating number of queens that can
attack each other by calling checkAttack Boolean method
5. setStateBoard: creates the current state by placing queens in the current instance
6. toString: prints the current configuration of the chessboard
7. getH: returns the heuristic values
8. compareTo: compares the current heuristic with the next node’s heuristic value
Global Variables:
1. size: Initialize the size of the square board.
2. state: is an array of queen specifying each (row, column) pair
3. nextNode: storing all next nodes in an array list of Node class
4. h: heuristic value stores and checked for zero <br> <br>
SteepestAscent: Class- performs hill climbing using steepest ascent
Functions:
1. initialState: assigning random initial coordinates to the queen on the chessboard
2. climbingAlgo: implements steepest ascent algorithm
3. listToPrint: returns the array list of nodes that are to be printed for path sequence
4. printPath: prints the path for array list of nodes from start node to end node
5. getStartNode: returns start node
6. getSteps: returns step count
Global Variables:
1. startNode: saves first node
2. steps: initialized to zero, stores number of steps
3. printNodes: arraylist of nodes to be printed
4. startState: stores array of Queen, i.e, (row, column) pairs <br><br>
RandomRestart: Class- performs hill climbing using random restart method
Functions:
1. climbingAlgo: implements hill climbing algorithm using random restart method
2. setStartNode: sets the starting nodes
3. getStepCount: returns number of steps
4. getRandomRestartUsed: returns Random Restart used without sideways moves
Global Variables:
1. start: saves first node
2. steps: initialized to zero, stores number of steps
3. randomRestartUsed: stores number of random restart used without sideways moves
4. steepestObject: an object of steepest ascent class referencing methods of SteepestAscent class <br><br>
RandomRestartSideways: Class- performs hill climbing using random restart and limiting the sideways moves
Functions:
1. climbingAlgo: implements hill climbing using random restart and limiting the sideways moves
2. setStart
3. setStartNode: sets the starting nodes
4. getStepCount: returns number of steps
5. getRandomRestartSidewaysUsed: returns moves
Global Variables:
1. start: saves first node
2. steps: initialized to zero, stores number of steps
3. randomRestartUsed: stores number of random restart used with sideways moves
4. sidewaysObject: object of SidewaysMove references methods of SidewaysMoves class <br> <br>
SidewaysMove: Class- performs simple hill climbing limiting the sideways moves
Functions:
1. firstState: assigning random initial coordinates to the queen on the chessboard
2. climbingAlgo: implements simple hill climbing algorithm limiting the sideways moves
3. getStartNode: returns the initial node
4. listNodesToPrint: returns the array list of nodes that are to be printed for path
sequence
5.printPath: prints the path for array list of nodes from start node to end node getSSteps: returns number of steps
Global Variables:
1. initial: saves first node
2. steps: initialized to zero, stores number of steps
3. printNodes: arraylist of nodes to be printed
4. firstState: stores array of Queen, i.e, (row, column) pairs
7. Eight_Queens:
Functions:
1. Main: takes input from the user and generates chessboard and calls other class methods to implement the respective algorithms and prints the path for three initial configuration, success rate, failure rate, average number of steps when succeeds and fails, random restarts used with and without sideways moves.
Global Variables:
1. RUNTEST: runs 500 times
User Input:
The user is expected to give the value of N.

### Functionality ###
The program starts with taking input from the user N and then generates the NxN chessboard. It first calls RandomRestart’s climbingAlgo method where startnode is set as the current node and till heuristic is not equal to zero, it will create a new SteepestAscent object and call its climbingAlgo method. In the climbingAlgo, solution will be checked and if the solution is not found it will create new objects. If heuristic is equal to zero, the algorithm stops and goal state is reached. Next the main methods calls SteepestAscent’s climbingAlgo, where parentNode is set as startNode, successors of current node are generated and stored in an arraylist and for each successor current node is compared. If the successor has lesser heuristic value, currentNode is set as the successor. If not such successor is found, the algorithm returns the currentNode and stops. The main method then calls SidewaysMoves’ climbingAlgo. currentNode is set as startNode and successor nodes are in an arraylist. Another arraylist of selectRandomSuccessor is created to store successor that has heuristic value equal to the currentNode. If successor’s heuristic value is lesser compared to currentNode then currentNode is set as successor and selectRandomSuccessor arraylist is cleared. If heuristic value of successor is equal to that of currentNode, a random node will be selected from selectRandomSuccessor and stored in the currentNode. A counter is incremented for every selection of random node. If the successor count has reached 100, the algorithm stops and returns the currentNode else it will continue to reach the goal state. RandomRestartSideways’ climbingAlgo is then called by the main method where, currentNode is set as startNode. While the heuristic of currentNode is not equal to zero, this algo will create an object of SidewaysMoves and call the respective algorithm and if heuristic is again not equal to zero, SidewaysMoves objects are created and climbingAlgo of SidewaysMoves is called. If the climbingAlgo of SIdewaysMoves returns the solution, then no RandomRestarts are required else RandomRestarts are required.
