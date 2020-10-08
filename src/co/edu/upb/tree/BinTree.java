package co.edu.upb.tree;

public class BinTree {

    public Node root;

    public BinTree() {
        this.root = null;
    }

    public BinTree(Object object) {
        this.root = new Node(object);
    }

    //Desde aqui el taller de 5 de Octubre

    //A.

    //B. Crear funciones
    //1. Total de nodos
    public int totalNodos(String exp){
        return 0; //todo
    }
    //2. Mayor ID
    public Object mayorID(Node root){
        Object finale = root.object;
        if(root.right != null){
            finale = mayorID(root.right);
        }
        return finale;
    }
    //3. Menor ID
    public Object menorID(Node root){
        Object finale = root.object;
        if(root.left != null){
            finale = mayorID(root.left);
        }
        return finale;
    }
    //4. Imprimir las hojas
    public void printLeafs(){

    }
    //5. Imprimir los niveles (n)


    public void insertNum(int num, Node root) {

        if(num < (int)root.object){ //va por la izquierda

            if(root.left == null){
                root.left = new Node(num);
            }else{
                insertNum(num, root.left);
            }

        }else if(num > (int)root.object){ //va por la derecha

            if(root.right == null){
                root.right = new Node(num);
            }else{
                insertNum(num, root.right);
            }

        }else{ // si son iguales no lo agrega
            System.out.println("Ese elemento ya se encuentra en el árbol");
        }
    }


    public Node searchNum(int num, Node root) {
        Node res = null;
        if(root==null){
            return null;
        }
        if(num < (int)root.object){ //va por la izquierda

            res = searchNum(num, root.left);

        }else if(num > (int)root.object){ //va por la derecha

            res = searchNum(num, root.right);

        }else{ // si son iguales lo retorna
            res = root; 
        }
        return res;
    }

    public Node search(Node root, Object object) {
        Node result = null;
        if (root != null) {
            //result = (root.object.toString().equals(object.toString())) ? root : null;
            if(root.object.toString().equals(object.toString())){
                result= root;
            }else{
                result = null;
            }
            if (result == null) {
                result = search(root.left, object);
                if (result == null) {
                    result = search(root.right, object);
                }
            }
        }
        return result;
    }

    Node anterior = null;
    boolean lor; //true izq; false der
    public boolean remove(int num,Node root) {
        if(root == null){
            anterior = this.root;
            return false;
        }else{
            if(num < (int)root.object){ //va por la izquierda

                anterior = root;
                lor = true;
                return remove(num, root.left);

            }else if(num > (int)root.object){ //va por la derecha

                anterior = root;
                lor = false;
                return remove(num, root.right);

            }else{ // si son iguales encontró el nodo a eliminar
                if((num == (int)this.root.object) && (this.root.toString().equals(root.toString()))){//si se va a eliminar la raiz
                    Node temp = new Node('x');
                    temp.right = root;
                    anterior = temp;
                    lor = false;
                }

                int cont = countLeafs(root);

                if(cont == 2){//si tiene dos descendientes
                    //TODO si tiene dos descendientes

                    if(root.right.left != null){//nodo izquierdo del subarbol derecho
                        if(lor){
                            anterior.left.setObject(root.right.left.object);
                        }else{
                            anterior.right.setObject(root.right.left.object);
                        }
                        remove((int)root.right.left.object,root.right);
                    }else{ //nodo derecho del subarbol izquierdo
                        if(lor){
                            anterior.left.setObject(root.left.right.object);
                        }else{
                            anterior.right.setObject(root.left.right.object);
                        }
                        remove((int)root.left.right.object,root.left);
                    }
                }else if(cont == 1){//si tiene un solo descendiente
                    if(lor){
                        if(root.right != null){//si el descendiente esta a la izquierda
                            anterior.left = root.right;
                        }else{
                            anterior.left = root.left;
                        }
                    }else{
                        if(root.right != null){//si el descendiente esta a la izquierda
                            anterior.right = root.right;
                        }else{
                            anterior.right = root.left;
                        }
                    }

                }else {//cont == 2 si es una hoja
                    if(lor){
                        anterior.left = null;
                    }else{
                        anterior.right = null;
                    }
                }
                anterior = this.root;
                return true;
            }

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
