package com.girish.node;

public class Node 
{
	private int data;
	public Node left;
	public Node right;
	
	public Node(int num)
	{
		setData(num);
		left = null;
		right = null;
	}

	/**
	 * @return the data
	 */
	public int getData() 
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) 
	{
		this.data = data;
	}	
}
