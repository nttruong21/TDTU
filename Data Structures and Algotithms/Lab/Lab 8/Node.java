public class Node {
    Integer key;
    Node left, right;
    int height;

    public Node(Integer key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}