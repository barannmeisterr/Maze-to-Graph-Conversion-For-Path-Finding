//-----------------------------------------------------
// Title: Stack class
// Author: Arda Baran
// Description:  
//Stack Data Structure implementation as Array In Order To perform DFS algorithm.
//------------------------------------------------------
public class Stack {
int top,capacity;//the last element of stack and capacity of stack.
Point bag[];//stack array which is type of Point structure.
public Stack(int capacity) {
	this.capacity=capacity;
    this.top=-1;
    this.bag=new Point[this.capacity];
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public Point[] getBag() {
	return bag;
}
public void setBag(Point[] bag) {
	this.bag = bag;
}
public void setTop(int top) {
	this.top = top;
}
public boolean isEmpty() {
	return(top==-1);
}
public boolean isFull() {
	return (top==this.capacity-1);
}
public void addPointToStack(Point p) {
//Adds Point structure instance to Stack		
	if(isFull()) {
		return;
	}
top++;
bag[top]=p;
}
public void deletePointFromStack() {
	if(isEmpty()) {
		return;
	}
top--;
}
public Point getTop() {
	if(!isEmpty()) {
		return bag[top];
	}
	return null;
}
}