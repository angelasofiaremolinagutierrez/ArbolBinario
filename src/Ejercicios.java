import co.edu.upb.tree.BinTree;
import co.edu.upb.tree.Node;

public class Ejercicios {
    public static void main(String[] args) {
        BinTree arbolVacio = new BinTree();

        String exp = "(a+b)-((c-d)+e)";
        arbolVacio.totalNodos(exp);

        BinTree treeNum = new BinTree();
        treeNum.root=new Node(new Node(new Node(new Node(22),43,
                new Node(new Node(56),65,null)),87,
                new Node(new Node(93),99,null)),120,
                new Node(new Node(null,130,new Node(135)),140,null));
        System.out.println(treeNum.mayorID(treeNum.root));
    }
}
