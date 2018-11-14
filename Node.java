package datastructure.trees;

public class Node<T> {
	T value;
	BineryTree<T> left, right;
	int height;
	
	Node(T t){
		value = t;
		left = right = null;
	}
}
