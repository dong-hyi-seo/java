package programmers.hash;

import java.util.*;
/**
 * 베스트앨범 - Level3
 * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class BestAlbum {

    /**
     * 1. 속한 노래가 많이 재생된 장르를 먼저 수록
     * 2. 장르 내에서 많이 재생된 노래를 먼저 수록
     * 3. 장르 내에서 재생 횟수가 같은 노래중에서는 고유 번호가 낮은 노래를 먼저 수록
     */
    public int[] solution(String[] genres, int[] plays) {

        List<String> typeList = Arrays.asList(genres);

        // 주어진 입력에서 장르별로 노래들을 Map에 저장
        HashMap<String, List<Song>> map = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            if(map.get(genres[i]) == null) {
                map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new Song(i, plays[i]));
        }


        //장르별 전체 플레이 횟수를 저장할 List
        // 장르 별 전체 플레이 횟수를 저장할 List
        List<Genre> list = new ArrayList<>();
        // 장르 별 전체 플레이 횟수 저장
        for(String s : map.keySet()) {
            int sum = 0;
            for(int i = 0; i < map.get(s).size(); i++) {
                sum += map.get(s).get(i).play;
            }
            list.add(new Genre(s, sum));
        }

        // 장르 별 전체 플레이 횟수 내림차 순으로 정렬
        Collections.sort(list, Collections.reverseOrder());

        System.out.println("map = " + map);
        System.out.println("list = " + list);

        // 내림차순으로 정렬된 장르 리스트에서 장르 이름을 key값으로 사용하여
        // 장르멸 노래 저장한 Map의 장르별 노래 리스트에서 2곡씩 뽑기
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            String key = list.get(i).name;
            int size = map.get(key).size();
            Collections.sort(map.get(key), Collections.reverseOrder()); //노래들 플레이 횟수로 내림차순!
            for (int j=0; j<size; j++) {
                if (j == 2) { //2개 넘어가면 안뽑기
                    break;
                }
                result.add(map.get(key).get(j).id);
            }
        }

        // 결과 List를 배열에 복사
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
    // 장르 정보 저장 클래스
    class Genre implements Comparable<Genre> {
        String name;
        int totalPlay;
        public Genre(String name, int totalPlay) {
            this.name = name;
            this.totalPlay = totalPlay;
        }

        // 장르 총 플레이 수로 정렬
        @Override
        public int compareTo(Genre other) {
            return totalPlay - other.totalPlay;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "name=" + name +
                    ", totalPlay=" + totalPlay +
                    '}';
        }
    }

    // 노래 정보 저장 클래스
    class Song implements Comparable<Song> {
        int id, play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            return play - o.play;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "id=" + id +
                    ", play=" + play +
                    '}';
        }
    }

}
