import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty())
			setRootNode(new BinaryNode<T>(newEntry));
		else
			result = addEntryHelperNonRecursive(newEntry);
		return result;
	}

	// THIS METHOD CANNOT BE RECURSIVE.
	private T addEntryHelperNonRecursive(T newEntry) {
		T result = null;
		boolean done = false;
		BinaryNode<T> rootNode = getRootNode();
		
		// need to write as a loop to find the position		
		while (!done) {
			int comparison = newEntry.compareTo(rootNode.getData());
			if (comparison <= 0) {
				if (comparison == 0) {
					result = rootNode.getData();
				}
				//left subtree for equals and lower
				if (rootNode.hasLeftChild()) {
					//keep going, there are more
					rootNode = rootNode.getLeftChild();
				} else {
					rootNode.setLeftChild(new BinaryNode<>(newEntry));
					done = true;
				}
				
			} else { //greater than
				
				if (rootNode.hasRightChild()) {
					rootNode = rootNode.getRightChild();
				} else {
					rootNode.setRightChild(new BinaryNode<>(newEntry));
					done = true;

				}
			}
		}
		

		
		return result; 
	}

	
	// THIS METHOD CANNOT BE RECURSIVE.
	// Make sure to take advantage of the sorted nature of the BST!
	public int countEntriesNonRecursive(T target) {
		// YOUR CODE HERE! 
		
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		boolean done = false;
		BinaryNode<T> currentNode = getRootNode();
		while (!done) {
			int comparison = target.compareTo(currentNode.getData());
			if (comparison <= 0) {
				if (comparison == 0) {
					count++;
				}
				//left subtree for equals and lower
				if (currentNode.hasLeftChild()) {
					//keep going, there are more
					currentNode = currentNode.getLeftChild();
				} else {
					done = true;
				}
				
			} else { //greater than
				
				if (currentNode.hasRightChild()) {
					currentNode = currentNode.getRightChild();
				} else {
					done = true;

				}
			}
			
			
		}
	
		return count; 
	}
	
	
	// THIS METHOD MUST BE RECURSIVE! 
	// You are allowed to create a private helper.
	// Make sure to take advantage of the sorted nature of the BST!
	public int countGreaterRecursive(T target) {
		// YOUR CODE HERE! 
		
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
			
		// consider a helper method!
			
		return count;
	}
		
	
	// THIS METHOD CANNOT BE RECURSIVE.
	// Hint: use a stack!
	// Make sure to take advantage of the sorted nature of the BST!
	public int countGreaterIterative(T target) {
		// YOUR CODE HERE! 
		
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		nodeStack.push(rootNode);

		// consider a loop based on the stack!

		return count;
	}
		
	
	// For full credit, the method should be O(n).
	// You are allowed to use a helper method.
	// The method can be iterative or recursive.
	// If you make the method recursive, you might need to comment out the call to the method in Part B.
	public int countUniqueValues() {
		// YOUR EXTRA CREDIT CODE HERE! 
		return 0; // placeholder: replace with your own code
	}
		
	
	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
	

}