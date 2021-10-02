/*

Suppose we have some input data describing a graph of relationships between parents and children over multiple families and generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4           30
 \ /   /  \           \ 
  3   5    9  15      16
   \ / \    \ / 
    6   7   12  


Sample input/output (pseudodata):

parentChildPairs = [
    (5, 6), (1, 3), (2, 3), (3, 6), (15, 12),
    (5, 7), (4, 5), (4, 9), (9, 12), (30, 16)
]


Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4, 15, 30],   // Individuals with zero parents
  [5, 7, 9, 16]        // Individuals with exactly one parent
]

Complexity Analysis variables:

n: number of pairs in the input

*/

import java.util.*;

public class Question1 {
  public static ArrayList<Integer> getListOfAllNodes(int[][] parentChildPairs) {
    ArrayList<Integer> listOfNodes = new ArrayList<Integer>();
    for (int i = 0; i < parentChildPairs.length; i++) {
      for (int j = 0; j < parentChildPairs[0].length; j++) {
        if (!listOfNodes.contains(parentChildPairs[i][j])) {
          listOfNodes.add(parentChildPairs[i][j]);
        }
      }
    }
    return listOfNodes;
  }

  public static ArrayList<ArrayList<Integer>> getFunc(int[][] parentChildPairs) {
    ArrayList<Integer> listOfNode = getListOfAllNodes(parentChildPairs);
    Map<Integer, Integer> mapOfNodesWithNnumberOfParents = new HashMap<Integer, Integer>();

    for (int j = 0; j < parentChildPairs.length; j++) {
      if (mapOfNodesWithNnumberOfParents.containsKey(parentChildPairs[j][1])) {
        mapOfNodesWithNnumberOfParents.put(parentChildPairs[j][1],
            mapOfNodesWithNnumberOfParents.get(parentChildPairs[j][1]) + 1);
      } else {
        mapOfNodesWithNnumberOfParents.put(parentChildPairs[j][1], 1);
      }
    }

    ArrayList<Integer> listWithoneParent = new ArrayList<Integer>();
    ArrayList<Integer> listWithZeroParent = new ArrayList<Integer>();

    for (int i = 0; i < listOfNode.size(); i++) {
      if (mapOfNodesWithNnumberOfParents.containsKey(listOfNode.get(i))
          && mapOfNodesWithNnumberOfParents.get(listOfNode.get(i)) == 1) {
        listWithoneParent.add(listOfNode.get(i));
      } else if (!mapOfNodesWithNnumberOfParents.containsKey(listOfNode.get(i))) {
        listWithZeroParent.add(listOfNode.get(i));
      }
    }

    ArrayList<ArrayList<Integer>> listNodesWithZeroAndOneParent = new ArrayList<ArrayList<Integer>>();
    listNodesWithZeroAndOneParent.add(listWithZeroParent);
    listNodesWithZeroAndOneParent.add(listWithoneParent);
    return listNodesWithZeroAndOneParent;
  }

  public static void main(String[] argv) {
    int[][] parentChildPairs = new int[][] { { 5, 6 }, { 1, 3 }, { 2, 3 }, { 3, 6 }, { 15, 12 }, { 5, 7 }, { 4, 5 },
        { 4, 9 }, { 9, 12 }, { 30, 16 } };
    ArrayList<ArrayList<Integer>> nodesWithZeroAndOneParent = getFunc(parentChildPairs);
    System.out.println(nodesWithZeroAndOneParent);
  }
}
