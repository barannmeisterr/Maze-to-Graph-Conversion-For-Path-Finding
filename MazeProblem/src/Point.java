//-----------------------------------------------------
// Title: Point class
// Author: Arda Baran
// Description:  
//Point structure.Each point in maze has a row location and a column location.Point idx is for converting the maze to 
//undirected graph.In the undirected graph,Points are vertices so each vertex has index in undirected graph.
//------------------------------------------------------
public class Point {		
int pointIdx,rowIdx,ColumnIdx;
String letter;
public Point(int pointIdx) {
	this.rowIdx=0;
	this.ColumnIdx=0;
    this.letter="";
    this.pointIdx=pointIdx;
}
public int getPointIdx() {
	return pointIdx;
}
public void setPointIdx(int pointIdx) {
	this.pointIdx = pointIdx;
}
public int getRowIdx() {
	return rowIdx;
}
public void setRowIdx(int rowIdx) {
	this.rowIdx = rowIdx;
}
public int getColumnIdx() {
	return ColumnIdx;
}
public void setColumnIdx(int columnIdx) {
	ColumnIdx = columnIdx;
}
public String getLetter() {
	return letter;
}
public void setLetter(String letter) {
	this.letter = letter;
}
}
