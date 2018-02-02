package acmicpc;

import java.util.Scanner;

class Tree
{
	int value;
	Tree leftChild;
	Tree rightChild;
	public Tree(int data) {
		value = data;
		leftChild = null;
		rightChild = null;
	}
	public Tree find(Tree tree, int node)
	{
		if(tree == null)
			return null;
		if(tree.value == node)
			return tree;
		Tree findTree =	find(tree.leftChild, node);
		if(findTree == null)
			findTree = find(tree.rightChild, node);
		return findTree;
	}
	public void Insert(int node, Tree c)
	{
		Tree findTree = find(this, node);
		if(findTree == null) return;
		if(findTree.leftChild == null) findTree.leftChild = c;
		else
			findTree.rightChild = c;
	}
	public Tree findParent(Tree tree, int node)
	{
		if(tree == null)
			return null;
		if(tree.leftChild != null && tree.leftChild.value == node)
			return tree;
		if(tree.rightChild != null && tree.rightChild.value == node)
			return tree;
		Tree findTree =	findParent(tree.leftChild, node);
		if(findTree == null)
			findTree = findParent(tree.rightChild, node);
		return findTree;
	}
}
public class TreeTravel
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		Tree root = new Tree(1);
		for(int i = 0; i < N-1; i++)
		{
			int l = sc.nextInt();
			int r = sc.nextInt();
			Tree findNode = null;
			findNode = root.find(root, l);
			if(findNode == null)
				root.Insert(r, new Tree(l));
			else
				root.Insert(l, new Tree(r));
		}
		for(int i = 2; i <= N; i++)
			System.out.println((root.findParent(root, i)).value);
	}
}