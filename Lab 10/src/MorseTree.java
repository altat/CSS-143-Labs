import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

/*
 * MorseTree.java
 * CSSSKL 143 Binary Search Tree Lab
 * Author: Rob Nash
 * 
 * This class reads in data from a text file ("data.txt") and populates a binary tree with an 
 * ordering constraint.  See the lab instructions for more information, but in general, dots go right 
 * and dashes go left when constructing or traversing a Morse code tree.  Search for //TODO
 * in the code to see what code you have to implement.
 * 
 * Start with the constructor. In your constructor read each line in from the textfile first, 
 * calling add() for each {letter, morseCodeStr} pair.
 * 
 */

public class MorseTree {
    private TreeNode root;

    public MorseTree() {
		//first, open data.txt, add each line to the tree
		Scanner fin;
		try {
		    fin = new Scanner(new File("data.txt"));
			//for each line in the file,
            while (fin.hasNextLine()) {
                //  get the letter(char) and the Morse string
                char letter = fin.next().charAt(0);
                String morse = fin.next();
                //  call add() with this data
                add(morse, letter);
                //  print out the letter and Morse string here for debugging
                System.out.println(letter + "  " + morse);
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

    
    
    public void add(String morseStr, char letter) {
        root = insertInSubtree(morseStr, letter, root);
    }

	private TreeNode<Character> insertInSubtree(String morseStr, char letter, TreeNode subtree) {
		//base case 1 : subtree is null
        if (subtree == null) subtree = new TreeNode(letter, null, null);
		//base case 2 : morseStr is of length 0
        if (morseStr.length() == 0) {
            subtree.data = letter;
            return subtree;
        }
		//recursive case 1: the first char in morseStr is a '.', so recursively traverse tree
        else if (morseStr.charAt(0) == '.') {
            subtree.right = insertInSubtree(morseStr.substring(1), letter,
                    subtree.right);
            return subtree;
        }
		//recursive case 2: the first char in the morseStr is a '-', so recurse accordingly
        else if (morseStr.charAt(0) == '-') {
            subtree.left = insertInSubtree(morseStr.substring(1), letter,
                    subtree.left);
            return subtree;
        }
		
		return subtree;  //always the last line, always return the node you
        // are working on
	}
    
    public Character translate(String morseStr) {
        return findInSubtree(morseStr, root);
    }

	private Character findInSubtree(String morseStr, TreeNode subtree) {
		//base case 1 : subtree is null
        if (subtree == null) return null;
		//base case 2 : morseStr is of length 0
        else if (morseStr.length() == 0) return (char) subtree.data;
		//recursive case 1: the first char in morseStr is a '.', so recursively traverse tree
        else if (morseStr.charAt(0) == '.') return findInSubtree(morseStr.substring(1),
                subtree.right);
		//recursive case 2: the first char in the morseStr is a '-', so re-curse accordingly
		else if (morseStr.charAt(0) == '-') return findInSubtree(morseStr.substring(1),
                subtree.left);

		return (char) subtree.data;
	}

	public String translateString(String tokens) {
		String retVal = "";
		//build a scanner here using tokens as input
        Scanner sc = new Scanner(tokens);
		//iterate over the tokens calling translate on each token (substring separated by a space)
        while (sc.hasNext()) {
            //concat these characters and return them
            retVal += translate(sc.next());
        }
		
		return retVal;
	}
	
    public String toMorseCode(Character c) {
        return toMorse(c, root);
    }

    // This method doesn't work for certain characters like 'O' but it does
    // work for 'S'
    private String toMorse(Character c, TreeNode subtree) {
        String retVal = "";
        char target;

        if (subtree != null && subtree.data != c) {
            target = (char)subtree.data;
            target = (char)subtree.left.data;
            target = (char)subtree.right.data;
        }

        return retVal;
    }

    public String encodeString(String message) {
        String retVal = "";

        if (message.length() > 0) {
            retVal += toMorseCode(message.charAt(0));

            for (int i = 1; i < message.length(); i++) {
                retVal += " " + toMorseCode(message.charAt(i));
            }
        }

        return retVal;
    }


    public String toString() {
        return inorderWalk(root);
    }

    private String inorderWalk(TreeNode subtree) {
        String retVal = "";
        if (subtree != null) {
            retVal += inorderWalk(subtree.left);
            retVal += subtree.data + " ";
            retVal += inorderWalk(subtree.right);
        }

        return retVal;
    }

    public String preOrderWalk(TreeNode subtree) {
        String retVal = "";
        if (subtree != null) {
            retVal += subtree.data + " ";
            retVal += inorderWalk(subtree.left);
            retVal += inorderWalk(subtree.right);
        }

        return retVal;
    }

    public static void main(String[] args) {
        MorseTree mt = new MorseTree();  //builds our tree using data from a file

        System.out.println(mt.translate("..."));  //prints out S
        System.out.println(mt.translate("---"));  //prints out O
        System.out.println(mt.translate(".......-"));  //prints out null

        System.out.println(mt.translateString("... --- ..."));  //SOS
        System.out.println(mt.toMorseCode('S'));  //find where we are in the
        // tree, remember path to root

        System.out.println(mt.preOrderWalk(mt.root));
    }

    // Inner class to create the linked structure
    private class TreeNode<Character> {
        
        Object data;     // holds a given node’s data
        TreeNode right;
        TreeNode left;
        
        public TreeNode() {
            this.data = null;
            this.right = null;
            this.left = null;
        }

        public TreeNode(Object newData, TreeNode newRight, TreeNode newLeft) {
            data = newData;
            right = newRight;
            left = newLeft;
        }
        
        public void setRight(TreeNode rightNode) {
            this.right = rightNode;
        }
        
         public void setLeft(TreeNode leftNode) {
            this.left = leftNode;
        }
            
    }
}
