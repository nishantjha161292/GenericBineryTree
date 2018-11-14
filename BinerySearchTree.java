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
		
		for(BineryTree<Integer> bt: bst.bt){
			System.out.println(bt.root.value);
		}
		
	}
	
	
	
	
}
