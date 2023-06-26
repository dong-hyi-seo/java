package programmers.dfs_bfs;

/**
 * 단어변환 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/43163
 *
 * 하나씩 한글짝식 변할수있는 단어를 찾아 가서 결국 target 단어가 나오는 과정을 몇번의 단계를
 * 거쳤는지 최소 값을 구하는것
 */
public class WordChange {

    /**
     *  String begin = "hit";
     *  String target = "cog";
     *  String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
     *  "hit" -> "hot" -> "dot" -> "dog" -> "cog" 총 4단계
     */
    public int solution(String begin, String target, String[] words) {
        //words 배열에 방문했는지 기록하는 배열 변수
        boolean[] visited = new boolean[words.length];
        return DFS(visited, words, begin, target, 0, 0);
    }

    /**
     *
     * @param visited
     * @param words
     * @param begin
     * @param target
     * @param cnt (찾는 횟수 세는 변수)
     * @param answer
     * @return
     */
    public static int DFS(boolean[] visited, String[] words, String begin, String target, int cnt, int answer) {
        if (begin.equals(target)) {
            answer = cnt;
            return answer;
        }
        for (int i=0; i< words.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (compare(begin, words[i])) {
                visited[i] = true;
                answer = DFS(visited, words, words[i], target, cnt+1, answer);
                visited[i] = false;
            }
        }
        return answer;
    }

    public static boolean compare(String begin, String word) {
        if (begin.length() != word.length()) {
            return false;
        }
        int compare = 0;
        for (int i=0; i<begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                compare++;
            }
        }
        return compare == 1;
    }
}
