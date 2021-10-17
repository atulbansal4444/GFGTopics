/*
Given a Binary Tree, find the In-Order Traversal of it.

Example 1:

Input:
       1
     /  \
    3    2
Output: 3 1 2

Example 2:

Input:
        10
     /      \ 
    20       30 
  /    \    /
 40    60  50
Output: 40 20 60 10 50 30

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrder() that takes root node of the tree as input and returns a list containing the In-Order Traversal of the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
*/

package Trees;

import Trees.ClassesUsedByTree.BinaryTree;
import Trees.ClassesUsedByTree.Node;
import java.util.ArrayList;

public class InorderTraversal
{
    static void inOrderTraverse(Node root, ArrayList<Integer> ls)
    {
        if (root == null)
        {
            return;
        }
        inOrderTraverse(root.left, ls);
        ls.add(root.data);
        inOrderTraverse(root.right, ls);
    }

    static ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> ls = new ArrayList<>();
        inOrderTraverse(root, ls);
        return ls;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(60);
        tree.root.right.left = new Node(50);

        ArrayList<Integer> ls = inOrder(tree.root);
        System.out.println(ls);
    }

}
