package datastructure.trees;

public class AVLTree extends BinerySearchTree{
	BineryTree<Integer> bt;
	
	AVLTree(){
		bt = new BineryTree<Integer>();
	}
	
	public BineryTree<Integer> add(int value){
		bt = RecurAdd(bt,value);
		return bt;
	}
	
	public  BineryTree<Integer> del(int value){
		bt = delete(bt,value);
		return bt;
	}
	
	private BineryTree<Integer> rightRotate(BineryTree<Integer> tree){
		
		BineryTree<Integer> tl = tree.left();
		BineryTree<Integer> tr = tl.right();
		
		tl.setRightTree(tree);
		tree.setLeftTree(tr);
		
		tl.root.height = 1+ Math.max(height(tl.left()), height(tl.right()));
		tree.root.height = 1+ Math.max(height(tree.left()), height(tree.right()));
		
		return tl;
	}
	
	private BineryTree<Integer> leftRotate(BineryTree<Integer> tree){
		
		BineryTree<Integer> tr = tree.right();
		BineryTree<Integer> tl = tr.left();
		
		tr.setLeftTree(tree);
		tree.setRightTree(tl);
		
		tr.root.height = 1+ Math.max(height(tr.left()), height(tr.right()));
		tree.root.height = 1+ Math.max(height(tree.left()), height(tree.right()));
		
		return tr;
	}
	
	private BineryTree<Integer> RecurAdd(BineryTree<Integer> tree, int value){
		
		if(tree == null || tree.root == null){
			return new BineryTree<Integer>(value);
		}
		if(tree.root.value > value)
			tree.setLeftTree(RecurAdd(tree.left(),value));
		else if(tree.root.value < value)
			tree.setRightTree(RecurAdd(tree.right(),value));
		else
			return tree;
		
		tree.root.height = 1 + Math.max(height(tree.left()),
								height(tree.right()));
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
	        tree.setLeftTree(leftRotate(tree.left())); 
	        return rightRotate(tree); 
	    } 
	  
	    // Right Left Case 
	    if (bal < -1 && value < tree.right().root.value) 
	    { 
	        tree.setRightTree(rightRotate(tree.right())); 
	        return leftRotate(tree); 
	    }
		
		return tree;
	}
	
	private BineryTree<Integer> delete(BineryTree<Integer> tree, int value){
		if(tree == null || tree.root == null){
			return null;
		}
		if(tree.root.value > value)
			tree.setLeftTree(delete(tree.left(),value));
		else if(tree.root.value < value)
			tree.setRightTree(delete(tree.right(),value));
		else{
			if(tree.left() == null)
				return tree.right();
			else if(tree.right() == null)
				return tree.left();
			tree.root.value = minRight(tree.right());
			tree.setRightTree(delete(tree.right(), tree.root.value));
		}

		tree.root.height = 1 + Math.max(height(tree.left()),
								height(tree.right()));
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
	        tree.setLeftTree(leftRotate(tree.left())); 
	        return rightRotate(tree); 
	    } 
	  
	    // Right Left Case 
	    if (bal < -1 && value < tree.right().root.value) 
	    { 
	        tree.setRightTree(rightRotate(tree.right())); 
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
		//System.out.println(height(tree.left()) - height(tree.right()));
		return height(tree.left()) - height(tree.right());
	}
	
	
	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();
		tree.add(10);
		tree.add(20);
		tree.add(30);
		tree.add(40);
		tree.add(50);
		tree.add(55);
		tree.add(60);
		tree.add(25);
		//tree.del(60);
		
		for(BineryTree<Integer> bt: tree.bt){
			System.out.println(bt.root.value);
		}
	}
}
