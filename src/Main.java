import co.edu.upb.tree.BinTree;
import co.edu.upb.tree.Node;

public class Main {

    public static void main(String[] args) {
        BinTree tree= new BinTree();

        tree.root=new Node(new Node(new Node(null, "-", new Node("a")),
                "+", new Node(new Node("x"), "+", new Node("y"))),
                "/", new Node(new Node(null, "+", new Node("b")),
                "*", new Node(new Node("c"), "*", new Node("a"))));

        System.out.println(tree.preOrder(tree.root));
        System.out.println(tree.inOrder(tree.root));
        System.out.println(tree.posOrder(tree.root));

        BinTree treeNum = new BinTree();
        treeNum.root=new Node(new Node(new Node(new Node(22),43,
                new Node(new Node(56),65,null)),87,
                new Node(new Node(93),99,null)),120,
                new Node(new Node(null,130,new Node(135)),140,null));

        System.out.println(treeNum.searchNum(135, treeNum.root));

    }
}
