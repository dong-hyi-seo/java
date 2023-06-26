package programmers.dfs_bfs;

import java.util.*;

/**
 * 여행경로 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/43164
 *
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다.
 * 항상 "ICN" 공항에서 출발합니다.
 *
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때,
 * 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */
public class TravelRoute {

    boolean[] visited;
    ArrayList<String> allRoute;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            allRoute.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}
