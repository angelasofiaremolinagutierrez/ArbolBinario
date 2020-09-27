package co.edu.upb.tree;

public class BinTree {

    public Node root;

    public BinTree() {
        this.root = null;
    }

    public BinTree(Object object) {
        this.root = subBinTree(null, object, null);
    }

    public Node subBinTree(Node left, Object object, Node right) {
        return new Node(left, object, right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean root(Object object) {
        try {
            root = subBinTree(null, object, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertleft(Object object) {
        try {
            if(!isEmpty()) {
                root.left = subBinTree(null, object, null);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertRight(Object object) {
        try {
            if(!isEmpty()) {
                root.right = subBinTree(null, object, null);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void insert(int num, Node root) {

        if(num < (int)root.object){ //va por la izquierda

            if(root.left == null){
                root.left = new Node(num);
            }else{
                insert(num, root.left);
            }

        }else if(num > (int)root.object){ //va por la derecha

            if(root.right == null){
                root.right = new Node(num);
            }else{
                insert(num, root.right);
            }

        }else{ // si son iguales no lo agrega
            System.out.println("Ese elemento ya se encuentra en el árbol");
        }
    }

    public Node search(int num, Node root) {
        Node res = null;
        if(num < (int)root.object){ //va por la izquierda

            search(num, root.left);

        }else if(num > (int)root.object){ //va por la derecha

            search(num, root.right);

        }else{ // si son iguales lo retorna
            res = root; //todo preguntar como hacer para que no lo redefina :(
        }
        return res;
    }

    public String preOrder(Node root) {

        String pre = "";
        Node node = root;
        pre = String.valueOf(node.object);

        if(node.left != null){
            pre += preOrder(node.left);
        }
        if(node.right != null){
            pre += preOrder(node.right);
        }
        return pre;

    }

    public String inOrder(Node root) {
        String in = "";
        Node node = root;
        if(node.left != null){
            in = inOrder(node.left);
        }

        in += String.valueOf(node.object);

        if(node.right != null){
            in += inOrder(node.right);
        }
        return in;
    }

    public String posOrder(Node root) {
        String pos = "";
        Node node = root;
        if(node.left != null){
            pos = posOrder(node.left);
        }
        if(node.right != null){
            pos += posOrder(node.right);
        }
        pos += String.valueOf(node.object);
        return pos;
    }

    @Override
    public String toString() {
        return "BinTree{" +
                "root=" + root +
                '}';
    }
}
