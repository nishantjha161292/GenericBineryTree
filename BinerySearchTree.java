package datastructure.trees;

public class BinerySearchTree {
	BineryTree<Integer> bt;
	
	BinerySearchTree(){
		bt = new BineryTree<Integer>();
	}
	
	public BineryTree<Integer> add(int value){
		bt = RecurAdd(bt,value);
		return bt;
	}
	
	public BineryTree<Integer> del(int value){
		bt = delete(bt,value);
		return bt;
	}
	private BineryTree<Integer> RecurAdd(BineryTree<Integer> tree, int value){
		
		if(tree == null || tree.root == null){
			return new BineryTree<Integer>(value);
		}
		if(tree.root.value > value)
			tree.root.left = RecurAdd(tree.left(),value);
		else if(tree.root.value < value)
			tree.root.right = RecurAdd(tree.right(),value);
		else
			return tree;
		
		return tree;
	}
	
	private BineryTree<Integer> delete(BineryTree<Integer> tree, int value){
		
		if(tree == null || tree.root == null){
			return null;
		}
		if(tree.root.value > value)
			tree.root.left = delete(tree.left(),value);
		else if(tree.root.value < value)
			tree.root.right = delete(tree.right(),value);
		else{
			if(tree.left() == null)
				return tree.right();
			else if(tree.right() == null)
				return tree.left();
			tree.root.value = minRight(tree.right());
			tree.root.right = delete(tree.right(), tree.root.value);
		}
			
		
		return tree;
	}
	
	protected int minRight(BineryTree<Integer> tree){
		int minv = tree.root.value;
		while(tree.left() != null){
			minv = tree.left().root.value;
			tree = tree.left();
		}
		return minv;
	}

	public static void main(String[] args) {
		
		BinerySearchTree bst = new BinerySearchTree();
		bst.add(5);
		bst.add(9);
		bst.add(3);
		bst.add(12);
		bst.add(6);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		//bst.del(9);
		
		for(BineryTree<Integer> bt: bst.bt){
			System.out.println(bt.root.value);
		}
		
	}
	
	
	
	
}
