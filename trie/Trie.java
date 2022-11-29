package revisionforinterviews.trie;

import java.util.*;

/*      *** Notes ***

- It is tree based DS, is mainly used to store collection of string.
- All children of a node have a common prefix.
- If two string have same prefix, then they will have same ansestors in this tree.


 ** Delete Operation **
if there are not children:
    then we can remove the node until the node which has children.

if there are children:
    to delete any word just make the terminal variable to false,
    specifying that there is no word in the dict which ends here at this char

    ** TC **
Insert - to insert 'x' no of string each of len N, then tc will be O(X*N)

 */

class Trie {

    // Node with empty character
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            TrieNode newNode = new TrieNode(c);
            if(temp.getChild(c) == null){
                temp.add(c, newNode);
            }
            temp = temp.getChild(c);
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            if(!temp.contains(c)){
                return false;
            }
            temp = temp.getChild(c);
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char c: prefix.toCharArray()){
            if(!temp.contains(c)){
                return false;
            }
            temp = temp.getChild(c);
        }
        return true;
    }

    class TrieNode{
        Character c;
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode(){
            children = new HashMap<>();
        }
        TrieNode(Character c){
            this.c = c;
            children = new HashMap<>();
        }


        // helper methods

        void add(Character c, TrieNode toAdd){
            children.put(c, toAdd);
        }

        TrieNode getChild(Character c){
            return children.get(c);
        }

        boolean contains(Character c){
            if(children.containsKey(c)){
                return true;
            }
            return false;
        }

    }
}