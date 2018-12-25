/**
 * Class invariant: This code for a binary tree satisfies the
 * binary search tree storage rule.
 * CSSSKL 143
 *
 * @author Tanvir Tatla
 * @version 12/07/2018
 * /**
 */

public class CharTree {

    /*Inner class Node, 2 references(pointers), one data element
     * The only reason this inner class is static is that it is used in
     * the static methods insertInSubtree , isInSubtree , and
     * showElementsInSubtree. This class should have more methods.
     * This is just a sample of possible methods.
     */
    private static class TreeNode {
        private char data;
        private TreeNode leftLink;
        private TreeNode rightLink;
        // Declare private data type char
        // Declare 2 links, rightLink & leftLink of type TreeNode


        // Parametrized constructor to build a node
        public TreeNode(char newData, TreeNode newLeftLink, TreeNode newRightLink) {
            data = newData;
            leftLink = newLeftLink;
            rightLink = newRightLink;
        }
    }           //End of IntTreeNode inner class

    // The first node of the tree, called root
    private TreeNode root;

    // Default constructor to build the CharTree
    public CharTree() {
        root = null;
    }

    // Utility methods for CharTree:
    public void add(char item) {
        root = insertInSubtree(item, root);
    }


    public boolean contains(char item) {
        return isInSubtree(item, root);
    }

    public void showElements() {
        showElementsInSubtree(root);
    }

    /**
     * Returns the root node of a tree that is the tree with root node
     * subTreeRoot, but with a new node added that contains item.
     */
    private static TreeNode insertInSubtree(char item, TreeNode subTreeRoot) {
        if (subTreeRoot == null)
            return new TreeNode(item, null, null);
        else if (item < subTreeRoot.data) {
            subTreeRoot.leftLink = insertInSubtree(item, subTreeRoot.leftLink);
            return subTreeRoot;
        } else {         //item >= subTreeRoot.data
            subTreeRoot.rightLink = insertInSubtree(item, subTreeRoot.rightLink);
            return subTreeRoot;
        }
    }

    private static boolean isInSubtree(char item, TreeNode subTreeRoot) {
        // base case: is subTreeRoot null?    then return false
        if (subTreeRoot == null) return false;
            // else if subTreeRoot.data == item   what would you return?
        else if (subTreeRoot.data == item) return true;
            // else item < subTreeRoot.data
        else if (item < subTreeRoot.data) {
            // recursive call
            return isInSubtree(item, subTreeRoot.leftLink);
        } else if (item > subTreeRoot.data) {
            return isInSubtree(item, subTreeRoot.rightLink);
        } else return false;
        //else         // item >= link.data
        // recursive call
    }

    private static void showElementsInSubtree(TreeNode subTreeRoot) { //Uses inorder traversal.
        if (subTreeRoot != null) {

            showElementsInSubtree(subTreeRoot.leftLink);
            System.out.print(subTreeRoot.data + " ");
            showElementsInSubtree(subTreeRoot.rightLink);
        }                    //else do nothing. Empty tree has nothing to display.
    }

    public int countNodes() {
        return countTreeNodes(root);
    }

    private static int countTreeNodes(TreeNode subTreeRoot) {
        int node = 0;
        if (subTreeRoot != null) {
            node ++;
            node += countTreeNodes(subTreeRoot.rightLink);
            node += countTreeNodes(subTreeRoot.leftLink);
        }
        return node;
    }

    public int getDepth() {
        return findDepth(root);
    }

    private static int findDepth(TreeNode subTreeRoot) {
        int left = 0;
        int right = 0;

        if(subTreeRoot != null) {
            left++;
            right++;
            left += findDepth(subTreeRoot.leftLink);
            right += findDepth(subTreeRoot.rightLink);
        }

        if(left > right) return left;

        else return right;
    }

    public char getParent(char a) {
        return findParent(a, root);
    }

    private static char findParent(char c, TreeNode subTreeRoot) {
        char parent = subTreeRoot.data;
        TreeNode parentLeft = subTreeRoot.leftLink;
        TreeNode parentRight = subTreeRoot.rightLink;

        if (parent == c) return parent;

        else if(parent != c) {
            if((parentRight != null && parentRight.data == c) || (parentLeft != null && parentLeft.data == c)) return subTreeRoot.data;

            else if (parentLeft != null && parent > c) return findParent(c, subTreeRoot.leftLink);

            else if (parentRight != null && parent < c) return findParent(c, subTreeRoot.rightLink);
        }

        return c;
    }

    public static void main(String[] args) {
        CharTree tree = new CharTree();
        tree.add('c');
        tree.add('a');
        tree.add('t');

        tree.showElements(); //inorder prints a c t
        System.out.println();
        System.out.println(tree.countNodes());
        System.out.println(tree.getDepth());
        System.out.println(tree.contains('c'));
        System.out.println(tree.getParent('a'));  //can be tricky

    }
}
