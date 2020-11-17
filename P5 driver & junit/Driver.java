
import java.util.*;

public class Driver {
	/*
	 * Trees
	 *   4         20+           __20+__
 		  \       /  \          /       \
	      20     4    26       4         26
                / \           / \       /  \
        	   3   9         3+  9    21    30
                   		    /   / \
                    	   2   7   11

	   2            ___6___               ___5___
	  / \          /       \             /       \
	 1   4        2         9           2         8
		/ \      / \       / \         / \       / \
	   3   5    1   4     8   B       1   3     7   A
           	   / \   /   / \               \   /   / \
          	  3   5 7   A   C               4 6   9   B
                         	 \                         \
                          	  D                         C

	 */
	AVLTree<Integer> make_tree(int[] arr){
		AVLTree<Integer> tree = new AVLTree<>();
		for (int i: arr) {
			tree.add(i);
		}
		return tree;
	}



	AVLTree<Integer> make_tree(int i){
		int[] arr;
		switch (i) {
			case 1:
				arr = new int[]{4,20};
				return make_tree(arr);
			case 2:
				arr = new int[]{20,4,26,3,9};
				return make_tree(arr);
			case 3:
				arr = new int[]{20,4,26,3,9,21,30,7,2,11};
				return make_tree(arr);
			case 4:
				arr = new int[]{2,1,4,3,5};
				return make_tree(arr);
			case 5:
				arr = new int[]{6,2,9,1,4,8,11,3,5,7,10,12,13};
				return make_tree(arr);
			case 6:
				arr = new int[]{5,2,8,1,3,7,10,4,6,9,11,12};
				return make_tree(arr);
		}
		return null;
	}

	//Delete before submit
    public void printForDebug(AVLTree<Integer> t) {
    	Queue<BinaryNode<Integer>> q = new LinkedList<>();
    	q.add(t.getRootNode());
    	while (!q.isEmpty()) {
    		BinaryNode<Integer> tmp = q.remove();
    		System.out.printf("%s ",(tmp == null)?"Null":tmp.toString());

    		if (tmp != null) {
    			if (tmp.hasLeftChild())
    				q.add(tmp.getLeftChild());
    			if (tmp.hasRightChild())
    				q.add(tmp.getRightChild());
    		}

    	}
    }


	public static void main(String[] args) {
		Driver d = new Driver();
		AVLTree<Integer> tree;
		int arg = Integer.parseInt(args[0]);
		switch (arg) {
		case 1: //Tree 3: add 18; 9 4 20 3 7 11 26 2 18 21 30
			tree = d.make_tree(3);
			tree.add(18);
			d.printForDebug(tree);
			System.out.println();
			return;
		case 2: //Tree 6: remove 1; 8 5 10 3 7 9 11 2 4 6 12
			tree = d.make_tree(6);
			tree.remove(1);
			d.printForDebug(tree);
			System.out.println();
			return;
		case 3: //Tree 3: remove 21, 30; 4 3 20 2 9 26 7 11
			tree = d.make_tree(3);
			tree.remove(21);
			tree.remove(30);
			d.printForDebug(tree);
			System.out.println();
			return;
		case 4: //Tree 1: add 10; 10 4 20
			tree = d.make_tree(1);
			tree.add(10);
			d.printForDebug(tree);
			System.out.println();
			return;
		case 5: //Throw EmptyTreeException
			try {
				tree = d.make_tree(1);
				tree.remove(4);
				tree.remove(20);
				tree.remove(6);
			}
			catch (RuntimeException e) {
				System.err.println("Remove from empty tree");
			}
			return;
		}
	}
}
