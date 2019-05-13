package com.girish.BST_Tester;
import com.girish.binaryTree.*;
public class BST_Tester 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		BinarySearchTree b = new BinarySearchTree();
		int [] arr = {100, 50, 150, 25, 75, 125, 175};
		
		for(int i = 0; i < arr.length; i++)
		{
			b.insert(arr[i]);
		}
		
		b.display(b.root);

	}

}
