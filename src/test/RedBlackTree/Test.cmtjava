package test.RedBlackTree;

import stm.*;
import java.io.*;
import java.util.Random;
import java.util.*;
import java.util.Collections;

class Test{

	public static void main (String args[])throws Exception {

		int repetitions = Integer.parseInt(args[0]);
		int nthreads = Integer.parseInt(args[1]);
		int nops = Integer.parseInt(args[2]);
    
		while(repetitions-->0){

			RedBlackTree rbt = new RedBlackTree();
			InsertOperation[] addOps = new InsertOperation[nthreads];
			RemoveOperation[] remOps = new RemoveOperation[nthreads];
			int commits = 0;
		  
			List<Integer> addList = new ArrayList<Integer>();
			List<Integer> removeList = new ArrayList<Integer>();

			for(int i=0;i<nops;i++){
				addList.add(i);
				removeList.add(i);
			}

			Collections.shuffle(addList);
			Collections.shuffle(removeList);

			assert(nops%nthreads==0);
			int size = nops/nthreads;

			for(int i=0;i<nthreads;i++){
				addOps[i] =  new InsertOperation(rbt, addList.subList(i*size, (i+1)*size));
				remOps[i] =  new RemoveOperation(rbt, removeList.subList(i*size, (i+1)*size));		
			}

			for(int i=0;i<nthreads;i++){    
				addOps[i].start();
			}

			for(int i=0;i<nthreads;i++){    
				addOps[i].join();          
			}

		  assert( STMRTS.atomic(rbt.length()).equals(nops) );
		
			for(int i=0;i<nthreads;i++){    
				remOps[i].start();
			}

			for(int i=0;i<nthreads;i++){    
				remOps[i].join();          
			}

		  assert( STMRTS.atomic(rbt.length()).equals(0) );		
    }
	}

	public static void printTree(TreeNode root){

		System.out.println(Thread.currentThread().getId()+" "+"-------------------------");
		preOrder(root);
		System.out.println(Thread.currentThread().getId()+" "+"-------------------------");
	}

	public static void preOrder(TreeNode root){
		
		if(STMRTS.atomic(root.getValue())!=null){

			Integer v = STMRTS.atomic(root.getValue());
			Color c = STMRTS.atomic(root.getColor());
			int color = (c == Color.RED) ? 0 : 1;
			TreeNode p = STMRTS.atomic(root.getParent());
			if(v!=null)	{
        TreeNode l = STMRTS.atomic(root.getLeft());
        String left =  (l!=null)?STMRTS.atomic(l.getValue())+"":"";
        TreeNode r = STMRTS.atomic(root.getRight());
        String right =  (r!=null)?STMRTS.atomic(r.getValue())+"":"";

				System.out.println(Thread.currentThread().getId()+" "+v+" "+c+" "+STMRTS.atomic(p.getValue())+" "+
         left+" "+right);
				preOrder(STMRTS.atomic(root.getLeft()));
				preOrder(STMRTS.atomic(root.getRight()));
			}
			
		}

	}
}

class InsertOperation extends Thread {

	private RedBlackTree tree;
	private List<Integer> addList;

	InsertOperation(RedBlackTree rbt, List<Integer> addList) {

		this.tree = rbt;
		this.addList = addList;
	}

	public void run() {

	//System.out.println(Thread.currentThread().getId() + " " + addList);

		for(Integer i : addList){
			if(!STMRTS.atomic(tree.insert(i))){
				System.out.println(Thread.currentThread().getId() +"error inserting " + i);
			}
		}  
	}
}

class RemoveOperation extends Thread {

	private RedBlackTree tree;
	private List<Integer> addList;

	RemoveOperation(RedBlackTree rbt, List<Integer> addList) {
		this.tree = rbt;
		this.addList = addList;
	}

	public void run() {

	//System.out.println(Thread.currentThread().getId() + " " + addList);

		for(Integer i : addList){
	//    System.out.println(Thread.currentThread().getId() +" removing " + i);
	// Test.printTree(STMRTS.atomic(tree.getRoot()));

			if(!STMRTS.atomic(tree.remove(i))){
				System.out.println(Thread.currentThread().getId() +" error removing " + i);
			}

	/*  TreeNode root = STMRTS.atomic(tree.getRoot());
	System.out.println(Thread.currentThread().getId() +" removed " + i + " "+STMRTS.atomic(root.getValue()));
	Test.printTree(root);*/
		}      
	}
}
