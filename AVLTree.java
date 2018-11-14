package datastructure.trees;

public class AVLTree{
	BineryTree<Integer> bt;
	
	AVLTree(){
		bt = new BineryTree<Integer>();
	}
	
	public BineryTree<Integer> add(int value){
		bt = RecurAdd(bt,value);
		return bt;
	}
	
	private BineryTree<Integer> rightRotate(BineryTree<Integer> tree){
		
		BineryTree<Integer> tl = tree.left();
		BineryTree<Integer> tr = tl.right();
		
		tl.root.right = tree;
		tree.root.left = tr;
		
		tl.root.height = 1+ Math.max(height(tl.left()), height(tl.right()));
		tree.root.height = 1+ Math.max(height(tree.left()), height(tree.right()));
		
		return tl;
	}
	
	private BineryTree<Integer> leftRotate(BineryTree<Integer> tree){
		
		BineryTree<Integer> tr = tree.right();
		BineryTree<Integer> tl = tr.left();
		
		tr.root.left = tree;
		tree.root.right = tl;
		
		tr.root.height = 1+ Math.max(height(tr.left()), height(tr.right()));
		tree.root.height = 1+ Math.max(height(tree.left()), height(tree.right()));
		
		return tr;
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
		
		tree.root.height = 1 + Math.max(height(tree.root.left),
								height(tree.root.right));
		int bal = getBalance(tree);
		

	    // Left Left Case 
	    if (bal > 1 && value < tree.left().root.value) 
	        return rightRotate(tree); 
	  
	    // Right Right Case 
	    if (bal < -1 && value > tree.right().root.value) 
	        return leftRotate(tree); 
	  
	    // Left Right Case 
	    if (bal > 1 && value > tree.left().root.value) 
	    { 
	        tree.root.left =  leftRotate(tree.left()); 
	        return rightRotate(tree); 
	    } 
	  
	    // Right Left Case 
	    if (bal < -1 && value < tree.right().root.value) 
	    { 
	        tree.root.right = rightRotate(tree.right()); 
	        return leftRotate(tree); 
	    }
		
		return tree;
	}
	
	
	private int height(BineryTree<Integer> tree){
		if(tree== null || tree.root == null)
			return 0;
		return tree.root.height;
	}
	
	private int getBalance(BineryTree<Integer> tree){
		if(tree== null || tree.root == null)
			return 0;
		System.out.println(height(tree.root.left) - height(tree.root.right));
		return height(tree.root.left) - height(tree.root.right);
	}
	
	
	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.add(40);
		tree.add(50);
		tree.add(25);
		
		
		for(BineryTree<Integer> bt: tree.bt){
			System.out.println(bt.root.value);
		}
	}
}
