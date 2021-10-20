//Java implementation for converting the binary search tree into a right skewed tree
package com.greatlearning.dsmain;
import java.io.*;

// Class of the node
class Node
{
	int data;
	Node left, right;
	
	//  allocates a new node 
	Node(int item)
	{
		data = item;
		left = right = null;
	}
}
public class DriverBstToRightSkewTree
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	// Function to convert binary search tree into a right skewed tree 
	static void convertBstToRightSkewed(Node root)
	{
	
		// Base Case
		if(root == null)
		{
			return;
		}
		//To traverse tree in right direction
		convertBstToRightSkewed(root.left);
		
		Node rightNode = root.right;
		Node leftNode = root.left;
	
		//Check if the root Node of the skewed tree is not defined
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
	
		convertBstToRightSkewed(rightNode);
		
	}

	// Function to traverse the right skewed tree using recursion
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);	
	}

	// Driver Code
	public static void main (String[] args)
	{
    // Example of complete BST.
	//     50
	//    / \
	//   30 60
    //  / \
	// 10 40
		DriverBstToRightSkewTree tree = new DriverBstToRightSkewTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.left.right= new Node(40);
		//tree.node.right.left= new Node(40); 
		//In the assignment question it is mentioned that BST is complete bst but given example is not a complete BST.
	
		convertBstToRightSkewed(node);
		traverseRightSkewed(headNode);
	}	
}

