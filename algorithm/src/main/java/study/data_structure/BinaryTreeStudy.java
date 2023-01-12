package study.data_structure;

/*
           A(1)
   B(2)           C(3)
D(4)  E(5)     F(6)  G(7)
배열로전환시 :['',A, B, C, D, E, F, G]
표현 글자 숫자 : ag -> 17 / question : fe -> ?
중위순회(inorder) left -> root -> right : 4 2 5 1 3
전위순회(preorder) root -> left -> right : 1 2 4 5 3
후위순회(postorder) left -> right -> root : 4 5 2 3 1
 */
public class BinaryTreeStudy {

    public static void main(String[] args) {
        TraversalTree t = new TraversalTree();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);
        t.setRootNode(n1);
        System.out.println("======== 중위순회 ==========");
        t.inorder(t.getRootNode());
        System.out.println("======== 전위순회 ==========");
        t.preorder(t.getRootNode());
        System.out.println("======== 후위순회 ==========");
        t.postorder(t.getRootNode());
    }
}


class Node {
    int data;
    Node rightNode;
    Node leftNode;

}

class TraversalTree {
    Node rootNode;

    Node getRootNode() {
        return rootNode;
    }

    void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.leftNode = left;
        node.rightNode = right;
        return node;
    }

    /**
     * 중위순회 (재귀활용)
     * 왼쪽 -> 루트 -> 오른쪽
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.leftNode);
            System.out.println(node.data);
            inorder(node.rightNode);
        }
    }

    /**
     * 전위순회
     * 루트 -> 왼쪽 -> 오른쪽
     */
    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preorder(node.leftNode);
            preorder(node.rightNode);
        }
    }

    /**
     * 후위순회
     * 왼쪽 -> 오른쪾 -> 루트
     */
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.leftNode);
            postorder(node.rightNode);
            System.out.println(node.data);
        }
    }
}
