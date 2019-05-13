package com.girish.binaryTree;

import com.girish.node.Node;

public class BinarySearchTree 
{
	public Node root;
	
	public BinarySearchTree()
	{
		this.root = null;
	}
	
	public void insert(int num)
	{
		Node parent = null;
		Node cur = root;
		Node p = new Node(num);
		
		if(root == null)
		{
			root = p;
		}
		else
		{
			while(cur != null)
			{
				if(p.getData() == cur.getData())
				{
					return;
				}
				else if(p.getData() < cur.getData())
				{
					parent = cur;
					cur = cur.left;
				}
				else
				{
					parent = cur;
					cur = cur.right;
				}
			}
			
			if(p.getData() < parent.getData())
			{
				parent.left = p;
			}
			else
			{
				parent.right = p;
			}
		}
		
	}
	
	public void display(Node root)
	{
		if(root != null)
		{
			display(root.left);
			System.out.println(root.getData());
			display(root.right);
		}
	}
	
}
