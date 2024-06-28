//-------------------------------------------------------------------
// Title: Maze class
//Author:Arda Baran
// Description:this class represents maze which has a grid layout. In the grid,"-"cells are wall,which
//are basically obstacles. You can move among the Empty("E") cells and you cannot pass the boundaries of the grid.
//Starting location is marked with "S" in the grid,Additionally, there is also one cell labeled with F which is the final
//point.So the purpose is to find movements  from the starting location to the finish location. 
//To this end, you can move in 4 directions;up, down, left, right. These 4 directions will be represented by characters
//U, D, L, and R, respectively.
//Approach:
//1)Maze consists of String value,rows and columns . I defined them.
//2)Consider that point is a vertex so each point has index and value as string letter.
//In order to obtain that string letter we must know the exact location of a point in the maze,Additionaly the location of a 
//point is represented with its row and column index.
//3)Convert the maze into undirected graph data structure because we can traverse on undirected graph and move from one point
//to another point on graph.
//If value in maze is "S" or "E" or "F",then we can say that this cell is a point and reachable and we can move on this cell.  
//4)Start from the cell which is labeled with "S" and find a way to reach end cell which is labeled with "F".
//5)Since the purpose is to reach the cell which labeled with "F" from the cell which labeled with "S",we must traverse on
//the undirected graph.In order to traverse on the graph,DFS algorithm can be applied.
//6)Apply dfs algorithm and add the cells which are on the path from starting point to end point into the stack.
//then return the stack when the time all points on the path are visited.
//7)Detect the movement between two points.For example you move point a to point b .
//Let point a row idx =1,point a column idx =2
//Let point b row idx =1,point a column idx =3
//under these conditions it means that that you move DOWN direction.
//8)after obtaining dfs traversal result,print the all movements between two points in orderly.
//-------------------------------------------------------------
public class Maze {
	int numOfRow,numOfColumn;//maze elements
	int numOfPoints;//number of valid points
	Point []point;//Points in the maze
	int[][] adjMatrix;//Undirected graph adj Matrix 2 dimensional array
	String [][]maze;//2 dimension string array to represent maze
public Maze(String[][] maze, int numOfRow, int numOfColumn) {
	  this.numOfRow = numOfRow;
	    this.numOfColumn = numOfColumn;
	    this.maze = maze;
	    //initialize graph with number of non empty cells/points
	    this.adjMatrix = new int[numberOfValidPoints(maze)][numberOfValidPoints(maze)];
	    this.point = new Point[numberOfValidPoints(maze)];
	    int pointIndex = 0; 
//assign the values in maze to points.
	    for (int i = 0; i < numOfRow; i++) {
	        for (int j = 0; j < numOfColumn; j++) {
	            if (maze[i][j].equals("S") || maze[i][j].equals("E") || maze[i][j].equals("F")) {
	                point[pointIndex] = new Point(pointIndex);
	                point[pointIndex].setRowIdx(i);
	                point[pointIndex].setColumnIdx(j);
	                point[pointIndex].setLetter(maze[i][j]);
	                pointIndex++; 
	            }
	        }
	    }
	    this.numOfPoints = pointIndex; 
}
public void printAdjMatrix() {
	for(int i = 0 ; i<numberOfValidPoints(getMaze());i++) {
		for(int j = 0 ; j<numberOfValidPoints(getMaze());j++) {
			 System.out.print(adjMatrix[i][j] + " ");
		}
		System.out.println();
	}
}
public Point getStartPoint() {
	//----------------------------------------------------------------
	//Summary:returns the start point which labeled with "S" in the maze/grid.
	//---------------------------------------------------------------	
	Point[] points=getPoint();
for(Point a :points) {
	if(a.getLetter().equals("S")) {
		return a;
	}
}
   return null;     	  	
        }
public Point getFinalPoint() {
	//----------------------------------------------------------------
	//Summary:returns the end point which labeled with "F" in the maze/grid.
	//---------------------------------------------------------------	
	Point[] points=getPoint();
for(Point a :points) {
	if(a.getLetter().equals("F")) {
		return a;
	}
}
   return null;     	  	
        }
public void removeEdge(Point p1,Point p2) {
	//----------------------------------------------------------------
	//Summary:Removes the connection between two point.
	//---------------------------------------------------------------
	if(p1==null || p2==null) {
		return;
	}
	adjMatrix[p1.getPointIdx()][p2.getPointIdx()]=0;
	adjMatrix[p2.getPointIdx()][p1.getPointIdx()]=0;
}
public void addEdge(Point p1 ,Point p2) {
	//----------------------------------------------------------------
	//Summary:connects two point.
	//---------------------------------------------------------------
	if(p1==null||p2==null) {
		return;
	}	
	adjMatrix[p1.getPointIdx()][p2.getPointIdx()]=1;
	adjMatrix[p2.getPointIdx()][p1.getPointIdx()]=1;
}
public int getNumOfRow() {
	return numOfRow;
}
public void setNumOfRow(int numOfRow) {
	this.numOfRow = numOfRow;
}
public int getNumOfColumn() {
	return numOfColumn;
}
public void setNumOfColumn(int numOfColumn) {
	this.numOfColumn = numOfColumn;
}
public int getNumOfPoints() {
	return numOfPoints;
}
public void setNumOfPoints(int numOfPoints) {
	this.numOfPoints = numOfPoints;
}
public Point[] getPoint() {
	return point;
}
public void setPoint(Point[] point) {
	this.point = point;
}
public int[][] getAdjMatrix() {
	return adjMatrix;
}
public void setAdjMatrix(int[][] adjMatrix) {
	this.adjMatrix = adjMatrix;
}
public String[][] getMaze() {
	return maze;
}
public void setMaze(String[][] maze) {
	this.maze = maze;
}
public int numberOfValidPoints(String[][]maze) {
	//----------------------------------------------------------------
	//Summary:returns the number of total point which points are labeled with "S" or "E" or "F".
	//---------------------------------------------------------------	
	int count=0;
	for(int i =0;i<numOfRow;i++) {
		for(int j = 0 ;j<numOfColumn;j++) {
			if(maze[i][j].equals("S")||maze[i][j].equals("E")||maze[i][j].equals("F")) {
				count++;
			}
		}
	}
	return count;
}
public void convertMazeToGraph() {
	//----------------------------------------------------------------
	//Summary:Converts Maze to Undirected Graph.
	//First step:get all valid points in the maze.
	//Second step:find the points whose row indexes are equal and the difference the column indexes between two points are 1
    //or column indexes are equal and the difference the row indexes between two points are 1
	//Third Step:Connect these two point if they satistify these conditions.
	//---------------------------------------------------------------	
Point[] availablePoints=getPoint();
for(Point a :availablePoints) {
	for(Point b :availablePoints) {
		if(a!=b&&a.getRowIdx()==b.getRowIdx() && b.getColumnIdx()==a.getColumnIdx()+1) {
			addEdge(a,b);
		}
	}
}
for(Point a :availablePoints) {
	for(Point b :availablePoints) {
		if(a!=b&&a.getColumnIdx()==b.getColumnIdx() && b.getRowIdx()==a.getRowIdx()+1) {
			addEdge(a,b);
		}
	}
}
}
public Point[] dfs(Point start) {
	//----------------------------------------------------------------
	//Summary:After Maze is converted to undirected graph,dfs algorithm can be applied.
	//---------------------------------------------------------------	
int numberOfValidPointsInMaze=numberOfValidPoints(getMaze());	
boolean[] visited=new boolean[numberOfValidPointsInMaze];
Stack s = new Stack(numberOfValidPointsInMaze);
s.addPointToStack(start);
visited[start.getPointIdx()]=true;
while(!s.isFull()) {
start=s.getTop();	
for(int i = 0; i<numberOfValidPointsInMaze;i++) {
	if(adjMatrix[start.getPointIdx()][i]==1 && !visited[i]) {
		s.addPointToStack(point[i]);
	     visited[i]=true;
	}
}
}
return s.getBag();
}
public String movement(Point a ,Point b) {
	//----------------------------------------------------------------
	//Summary:Detects the valid movement between two cells.
	//---------------------------------------------------------------	
		if(a.getRowIdx()==b.getRowIdx()) {
			if(a.getColumnIdx()<b.getColumnIdx()) {
				return "R";
			}else {
				return "L";
			}		
		}else if(a.getColumnIdx()==b.getColumnIdx()) {
			if(a.getRowIdx()<b.getRowIdx()) {
				return "D";
			}else {
				return "U";
			}			
		}else {
			return"";
		}
	}
public void printMaze() {
    for (int i = 0; i < getNumOfRow(); i++) {
        for (int j = 0; j < getNumOfColumn(); j++) {
            System.out.print(maze[i][j] + " ");
        }
        System.out.println();
    }
}
public void solvePath() {
	//----------------------------------------------------------------
	//Summary:Prints all legal movements with two variable for loop.
	//---------------------------------------------------------------		
	printMaze();
	convertMazeToGraph();
	Point start=getStartPoint();	
	Point[] dfsResult=dfs(start);
System.out.println("Correct Movements To Reach End Cell Which Labeled With F Letter From The Starting Cell Which Labeled With S Letter:");	
for(int i = 0 ,j=i+1;j<dfsResult.length;i++,j++) {
	System.out.print(movement(dfsResult[i],dfsResult[j])+" ");
}
}
}
