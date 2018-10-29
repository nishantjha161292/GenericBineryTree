package datastructure.trees;

public class Node<T> {
	T value;
	BineryTree<T> left, right;
	
	Node(T t){
		value = t;
		left = right = null;
	}
}
