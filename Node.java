package datastructure.trees;

public class Node<T,Q> {
	Q value;
	Node<T,Q> left, right;
	int height;
	
	Node(Q t){
		value = t;
		left = right = null;
	}
	Node(){
		
	}
	
}
