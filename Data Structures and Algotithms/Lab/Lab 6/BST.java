
/**
 * @author Nguyen The Truong
 */

public class BST {
    
    private Node root;

    public BST() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    // Insert a Node to BST
    private Node insert(Node x, Integer key) {
        if(x == null) {
            return new Node(key);
        }
        else {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) {
                x.left = insert(x.left, key);
            }
            else if(cmp > 0) {
                x.right = insert(x.right, key);
            }
            else {
                x.key = key;
            }
            return x;
        }
    }

    public void insert(Integer key) {
        root = insert(root, key);
    }

    // Pre-order 
    public void NLR(Node x) {
        if(x == null) {
            return;
        }
        System.out.print(" " + x.key);
        NLR(x.left);
        NLR(x.right);
    }

    public void NLR() {
        NLR(root);
    }

    // In-order (ascending order)
    public void LNR(Node x) {
        if(x == null) {
            return;
        }
        LNR(x.left);
        System.out.print(" " + x.key);
        LNR(x.right);
    }

    public void LNR() {
        LNR(root);
    }

    // Post-order
    public void LRN(Node x) {
        if(x == null) {
            return;
        }
        LRN(x.left);
        LRN(x.right);
        System.out.print(" " + x.key);
    }

    public void LRN() {
        LRN(root);
    }


    // Descending order
    public void RNL(Node x) {
        if(x == null) {
            return;
        }
        RNL(x.right);
        System.out.print(" " + x.key);
        RNL(x.left);
    }

    public void RNL() {
        RNL(root);
    }

    // Search a key
    private Node search(Node x, Integer key) {
        if(x == null) {
            return null;
        }
        else {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) {
                return search(x.left, key);
            }
            else if(cmp > 0) {
                return search(x.right, key);
            }
            else {
                return x;
            }
        }
    }

    public Node search(Integer key) {
        return search(root, key);
    }

    // Find minimum key 
    private Node min(Node x) {
        if(x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Integer min() {
        return min(root).key;
    }

    // Find maximum key 
    private Node max(Node x) {
        if(x.right == null) {
            return x;
        }
        return max(x.right);
    }

    public Integer max() {
        return max(root).key;
    }

    // Delete the node contain minimum key 
    private Node deleteMin(Node x) {
        if(x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    // Delete the node conatain maximum key
    private Node deleteMax(Node x) {
        if(x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        return x;
        
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    // Delete the Node in BST
    private Node delete(Node x, Integer key) {
        if(x == null) {
            return null;
        }
        else {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) {
                x.left = delete(x.left, key);
            }
            else if(cmp > 0) {
                x.right = delete(x.right, key);
            }
            else {
                if(x.right == null) {
                    return x.left;
                }
                else if(x.left == null) {
                    return x.right;
                }
                else {
                    Node temp = x;
                    x = min(temp.right);
                    x.right = deleteMin(temp.right);
                    x.left = temp.left;
                }
            }
            return x;
        }
    }

    public void delete(Integer key) {
        root = delete(root, key);
    }

    // Create tree
    public void createTree(String strKey) {
        String[] s = strKey.split(" ");
        for (String item : s) {
            insert(Integer.parseInt(item));
        }
    }

    // Contain 
    private boolean contains(Node x, Integer key) {
        if(search(key) == null) {
            return false;
        }
        return true;
    }

    public boolean contains(Integer key) {
        return contains(root, key);
    }

    // Delete node use the predecessor 
    private Node delete_pre(Node x, Integer key) {
        if(x == null) {
            return null;
        }
        else {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) {
                x.left = delete_pre(x.left, key);
            }
            else if(cmp > 0) {
                x.right = delete_pre(x.right, key);
            }
            else {
                Node temp = x;
                x = max(temp.left);
                x.left = deleteMax(temp.left);
                x.right = temp.right;
            }
            return x;
        }
    }

    public void delete_pre(Integer key) {
        root = delete_pre(root, key);
    }


    // Calculate the height 
    private int height(Node x) {
        if(x == null) {
            return -1;
        }
        return Math.max(height(x.left), height(x.right)) + 1;
    }
    private int height() {
        return height(root);
    }

    public int getHeight() {
        return height();
    }

    //  Calculate the sum of all values of the subtree x
    public Integer sum(Node x) {
        if(x == null) {
            return 0;
        }
        return x.key + sum(x.left) + sum(x.right);
    }

    public int sum(Integer key) {
        return sum(search(key));
    }

    // Calculate the sum of all values of BST
    public Integer sum() {
        return sum(root.key);
    }

    // Main 
    public static void main(String[] args) {
        BST tree = new BST();
        tree.createTree("10 60 75 55 37 1 4 5");
        tree.RNL();
        System.out.println();
        tree.delete_pre(10);
        tree.RNL();
        System.out.println();
        //System.out.println(tree.getHeight());
        //System.out.println("BST contains 60? " + tree.contains(60));
        // tree.deleteMax();
        // tree.RNL();
        // System.out.println();
        //System.out.println(tree.sum());
    }
}
