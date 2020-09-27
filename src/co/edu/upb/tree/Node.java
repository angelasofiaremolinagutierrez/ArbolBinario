package co.edu.upb.tree;

public class Node {

    public Node left;
    public Node right;
    public Object object;

    public Node(Object object) {
        this.left = null;
        this.right = null;
        this.object = object;
    }

    public Node(Node left, Object object, Node right) {
        this.left = left;
        this.right = right;
        this.object = object;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", object=" + object +
                '}';
    }
}
