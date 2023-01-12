package company.thingsflow;

public class TraversalTree {
    Node rootNode;

    Node getRootNode() {
        return rootNode;
    }

    void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    public static Node arrayToTree(String[] array) {
        return arrayToTree(array, 1, array[1]);
    }

    public static Node arrayToTree(String[] array, int index, String morse) {
        if (index >= array.length)
            return null;
        if (array[index] == null)
            return null;

        return new Node(
                array[index],
                morse,
                index,
                arrayToTree(array, index * 2, morse+"-"),
                arrayToTree(array, index * 2 + 1, morse+".")
        );
    }

    /**
     * find node
     */
    public static Node searchNode(Node temp, String data) {
        if (temp == null) {
            return null;
        }
        if (temp.getData().equals(data)) {
            return temp;
        }
        Node foundNode =  searchNode(temp.getLeftNode(), data);;
        if (foundNode == null) {
            foundNode = searchNode(temp.getRightNode(), data);
        }
        return foundNode;
    }

    /**
     * 중위순회 (재귀활용)
     * 왼쪽 -> 루트 -> 오른쪽
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.getLeftNode());
            System.out.println(node.getIndex());
            inorder(node.getRightNode());
        }
    }

    /**
     * 전위순회
     * 루트 -> 왼쪽 -> 오른쪽
     */
    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.getIndex());
            preorder(node.getLeftNode());
            preorder(node.getRightNode());
        }
    }

    /**
     * 후위순회
     * 왼쪽 -> 오른쪾 -> 루트
     */
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.getLeftNode());
            postorder(node.getRightNode());
            System.out.println(node.getIndex());
        }
    }
}
