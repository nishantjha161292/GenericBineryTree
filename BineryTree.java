package datastructure.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BineryTree<T> implements Iterable<BineryTree<T>>{
	Node<T> root;
	
	BineryTree(){
		root = null;
	}
	
	BineryTree(T r){
		root = new Node<T>(r);
		root.height = 1;
	}
	
	void setLeftTree(BineryTree<T> l){
		root.left = l;

	}
	void setRightTree(BineryTree<T> r){
		root.right = r;
	}
	BineryTree<T> left(){
		return root.left;
	}
	BineryTree<T> right(){
		return root.right;
	}

	@Override
	public Iterator<BineryTree<T>> iterator() {
		return new PreOrderTreeTravel(this);
		//return new InOrderTreeTravel(this);
		//return new LevelOrderTreeTravel(this);
	}
	
	private class PreOrderTreeTravel implements Iterator<BineryTree<T>>{
		Stack<BineryTree<T>> s = new Stack<BineryTree<T>>();
		
		PreOrderTreeTravel(BineryTree<T> tree){
			s.push(tree);
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !s.isEmpty();
		}

		@Override
		public BineryTree<T> next() {
			// TODO Auto-generated method stub
			BineryTree<T> t = s.pop();
			if(t.right() != null){
				s.push(t.right());
			}
			if(t.left() != null){
				s.push(t.left());
			}
			return t;
		}

	}
	
	private class InOrderTreeTravel implements Iterator<BineryTree<T>>{
		Stack<BineryTree<T>> s = new Stack<BineryTree<T>>();
		BineryTree<T> next;
		
		InOrderTreeTravel(BineryTree<T> tree){
			next = tree;
			while(next.left() != null){
				s.push(next);
				next = next.left();
			}
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next != null;
		}

		@Override
		public BineryTree<T> next() {
			// TODO Auto-generated method stub
			BineryTree<T> r = next;
			if(next.right() != null){
				next = next.right();
				while(next.left() !=null){
					s.push(next);
					next = next.left();
				}
				return r;
			}
			if(s.isEmpty())
				next = null;
			else
				next = s.pop();
			return r;
		}
	}
	

	private class LevelOrderTreeTravel implements Iterator<BineryTree<T>>{
		Queue<BineryTree<T>> s = new LinkedList<BineryTree<T>>();
		BineryTree<T> next;
		
		LevelOrderTreeTravel(BineryTree<T> tree){
			next = tree;
			s.add(next.left());
			s.add(next.right());
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next != null;
		}

		@Override
		public BineryTree<T> next() {
			// TODO Auto-generated method stub
			BineryTree<T> r = next;
			if(s.isEmpty()){
				next = null;
				return r;
			}
			else
				next = s.remove();
			if(next.left() != null)
				s.add(next.left());
			if(next.right() != null)
				s.add(next.right());
			
			return r;
		}
	}
	

	private class PostOrderTreeTravel implements Iterator<BineryTree<T>>{
		Queue<BineryTree<T>> s = new LinkedList<BineryTree<T>>();
		BineryTree<T> next;
		
		PostOrderTreeTravel(BineryTree<T> tree){
			next = tree;
			s.add(next.left());
			s.add(next.right());
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return next != null;
		}

		@Override
		public BineryTree<T> next() {
			// TODO Auto-generated method stub
			BineryTree<T> r = next;
			if(s.isEmpty()){
				next = null;
				return r;
			}
			else
				next = s.remove();
			if(next.left() != null)
				s.add(next.left());
			if(next.right() != null)
				s.add(next.right());
			
			return r;
		}
	}


	
}
