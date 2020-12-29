public class AVL {
	private Node root;

	public Node getRoot() {
		return root;
	}

	public AVL() {
		root = null;
	}

	// Get height
	private int height(Node node) {
		if(node == null) {
			return -1;
		}
		return node.height;
	}

	public int getHeight(Node node) {
		return height(node);
	}

	// Check balance
	private int checkBalance(Node x) {
		return height(x.left) - height(x.right);
	}

	public int doCheckBalance(Node x) {
		return checkBalance(x);
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

	// Rotation

	// Left rotation
	private Node rotationLeft(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		x.height = 1 + Math.max(height(x.left), height(x.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));
		return y;
	}

	public void doRotationLeft(Integer key) {
		Node node = search(key);
		node = rotationLeft(node);
	}

	// Right rotation
	private Node rotationRight(Node x) {
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		x.height = 1 + Math.max(height(x.left), height(x.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));
		return y;
	}

	public void doRotationRight(Integer key) {
		Node node = search(key);
		node = rotationRight(node);
	}

	// Balance
	private Node balance(Node x) {
		if(checkBalance(x) < -1) {
			if(checkBalance(x.right) > 0) {
				x.right = rotationRight(x.right);
			}
			x = rotationLeft(x);
			return x;
		}
		else {
			if(checkBalance(x) > 1) {
				if(checkBalance(x.left) < 0) {
					x.left = rotationLeft(x.left);
				}
				x = rotationRight(x);
			}
			return x;
		}
	}

	public Node balance(Integer x) {
		Node t = search(x);
		return balance(t);
	}

	// Insert 
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
            balance(key);
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
            balance(key);
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

    public static void main(String[] args) {
    	AVL tree = new AVL();
    	tree.createTree("10 60 75 55 37 1 4 5");
    	tree.NLR();
    	System.out.println();
    	tree.balance(10);
    	tree.NLR();
    	System.out.println();
    }
}