package company.thingsflow;

public class Node {

    private String data;
    private String morse;
    private Integer index;
    private Node rightNode;
    private Node leftNode;

    public Node(String data, Integer index) {
        this.data = data;
        this.index = index;
    }

    public Node(String data, String morse, Integer index, Node leftNode, Node rightNode) {
        this.data = data;
        this.morse = morse;
        this.index = index;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }

    @Override
    public String toString() {
        return "[ data : " + data + ", index : " + index + ", morse : " + morse + "]";
    }
}