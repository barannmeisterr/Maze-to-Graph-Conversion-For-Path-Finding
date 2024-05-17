# Maze to Graph Conversion For Path Finding
 This project converts a maze into a graph representation and performs various graph-related  operations on it.The maze is represented as a 2D array of characters where: "S" indicates the start point, "F" indicates the final (end) point,"E" indicates an empty point, and "-" indicates a wall.
You can move among the white cells and you cannot pass the boundaries of the grid. In each path, the starting location will be the square of [0,0]. Additionally, there is also one white cell labeled with F. This label shows the finish square of the path. So, your aim is to find the correct movements from the starting location to the finish location. To this end, you can move in 4 directions; up, down, left, right. These 4 directions will be represented by characters U, D, L, and R, respectively. The grid consists of walls (obstacles) and walkable cells, with specific start and finish points. The program outputs the sequence of movements needed to navigate from the start to the finish.
## Author
- Arda Baran
## Features
- The maze represented as two dimensional matrix string array.
- The points in the maze are initialized with respect to the location of the points in the maze.
- In order to find the correct movements , two dimensional string array is converted to Undirected Graph Data Structure
- In order to traverse on the maze which converted to Undirected Graph Data Structure , DFS algorithm is applied.
- Stack data structure is implemented as array.
- Finds the correct movements between Start and End point.
## Technologies And Data Structures Used
- Java
- Undirected Graph
- Array
- Two Dimensional Array For Adjacency Matrix
- Two Dimensional Array For Maze representation
- Stack Array Implementation
- DFS Algorithm
- Object Oriented Programming
- switch-case
  ## File Structure
- src/: Contains the Java source code
