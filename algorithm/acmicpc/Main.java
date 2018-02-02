package acmicpc;
import java.util.*;

class Tree
{
	char value;
	Tree leftChild;
	Tree rightChild;
	public Tree(char data) {
		value = data;
		leftChild = null;
		rightChild = null;
	}
	public Tree find(Tree tree, char node)
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
	public void Insert(char node, Tree lc, Tree rc)
	{
		Tree findTree = find(this, node);
		findTree.leftChild = lc;
		findTree.rightChild = rc;
	}
	public void PreOrder(Tree root)
	{
		if(root.value != '.')
			System.out.print(root.value);
		else
			return;
		PreOrder(root.leftChild);
		PreOrder(root.rightChild);
	}
	public void InOrder(Tree root)
	{
		if(root.value == '.')
			return;
		InOrder(root.leftChild);
		System.out.print(root.value);
		InOrder(root.rightChild);
	}
	public void PostOrder(Tree root)
	{
		if(root.value == '.') return;
		PostOrder(root.leftChild);
		PostOrder(root.rightChild);
		System.out.print(root.value);
	}
}
class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		Tree root = new Tree('A');
		for(int i = 0; i < N; i++)
		{
			String line = sc.nextLine();
			char parent = line.charAt(0);
			char lc = line.charAt(2);
			char rc = line.charAt(4);
			
			root.Insert(parent, new Tree(lc), new Tree(rc));
		}
		root.PreOrder(root);
		System.out.println();
		root.InOrder(root);
		System.out.println();
		root.PostOrder(root);
	}
}