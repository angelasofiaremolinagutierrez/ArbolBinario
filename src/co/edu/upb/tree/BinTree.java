package co.edu.upb.tree;

public class BinTree {

    public Node root;

    public BinTree() {
        this.root = null;
    }

    public BinTree(Object object) {
        this.root = new Node(object);
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

    private Node res = null;
    public Node search(int num, Node root) {

        if(root==null){
            return null;
        }

        if(num < (int)root.object){ //va por la izquierda

            search(num, root.left);

        }else if(num > (int)root.object){ //va por la derecha

            search(num, root.right);

        }else{ // si son iguales lo retorna
            res = root; 
        }
        return res;
    }

    public boolean remove(Object num) {
        Node toRemove = search((int)num, this.root);
        //todo obtener el nodo que apunta a toRemove para reasignarlo
        if(toRemove == null){
            return false;
        }else{
            int cont = countLeafs(toRemove);

            if(cont == 2){//si tiene dos descendientes
                if(toRemove.right.left != null){//nodo izquierdo del subarbol derecho
                    toRemove = toRemove.right.left;
                    //todo cambiar demás punteros
                }else{
                    toRemove = toRemove.left.right;
                    //todo cambiar demás punteros
                }
            }else if(cont == 1){//si tiene un solo descendiente
                if(toRemove.right != null){//si el descendiente esta a la izquierda
                    toRemove = toRemove.right;
                }else{
                    toRemove = toRemove.left;
                }
            }else {//cont == 2 si es una hoja
                toRemove = null;
            }
            return true;
        }
    }

    public int countLeafs(Node root){
        int cont = 0;
        if(root.right != null){
            cont++;
        }
        if(root.left != null){
            cont++;
        }
        return cont;
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
