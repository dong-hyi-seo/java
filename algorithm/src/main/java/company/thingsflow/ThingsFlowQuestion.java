package company.thingsflow;


import java.util.Arrays;

/**
 * thinsflow 회사 코딩테스트
 * 모스부호 '-' 와 '.'로 이루어진 문자열이고, 각 글자는 띄어쓰기로 구분됩니다.
 *
 * 해결방법
 * 1. 주어진 STR_ARR 값을 이진 tree 구조로 만든다
 * 인덱스 순차별로 만들며 만들때 왼쪽은 '-'를 붙여나가고 오른쪽 노드는 '.'을 붙여나가서 같이 생성
 *
 * 2. question값 입력받은 텍스트 값을 찾는다.
 *
 */
public class ThingsFlowQuestion {

    private final static String[] STR_ARR = {"", "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O", "P" ,"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "[", "\\", "]", "^"
    };

    public String thingsFlowSolution(String question) {

        //이진트리 구조 생성
        Node rootNode = TraversalTree.arrayToTree(STR_ARR);

        System.out.println("================ Root node ====================");
        System.out.println("rootNode = " + rootNode.toString());
        System.out.println("rootNode left = " + rootNode.getLeftNode().toString());
        System.out.println("rootNode right = " + rootNode.getRightNode().toString());

        //root A
        System.out.println("================ A node ====================");
        Node aNode = rootNode.getLeftNode();
        System.out.println("aNode = " + aNode.toString());
        System.out.println("aNode left = " + aNode.getLeftNode().toString());
        System.out.println("aNode right = " + aNode.getRightNode().toString());

        //root B
        System.out.println("================ B node ====================");
        Node bNode = rootNode.getRightNode();
        System.out.println("bNode = " + bNode.toString());
        System.out.println("bNode left = " + bNode.getLeftNode().toString());
        System.out.println("bNode right = " + bNode.getRightNode().toString());

        //root B
        System.out.println("================ C node ====================");
        Node cNode = aNode.getLeftNode();
        System.out.println("cNode = " + cNode.toString());
        System.out.println("cNode left = " + cNode.getLeftNode().toString());
        System.out.println("cNode right = " + cNode.getRightNode().toString());

        System.out.println("============= Search ==================");
        Node searchNode = TraversalTree.searchNode(rootNode, "D");
        System.out.println("searchNode = " + searchNode.toString());

        return Arrays.stream(question.split(""))
                .map(s -> {
                    Node findNode = TraversalTree.searchNode(rootNode, s);
                    if (findNode == null) {
                        return " ";
                    }
                    return findNode.getMorse();
                }).reduce((a, b) -> a + b).get();
    }
}
