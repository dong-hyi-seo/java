package programmers.ingang;

import java.util.*;


public class MapTraining {

    /**
     * 당신은 폰켓몬을 잡기 위한 오랜 여행 끝에, 홍 박사님의 연구실에 도착했습니다.
     * 홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
     * 홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다. 따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다.
     * 예를 들어 연구실에 총 4마리의 폰켓몬이 있고,
     * 각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면 이는 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다.
     * 이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.
     *
     * 첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
     * 첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
     * 첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
     * 두 번째(1번), 세 번째(2번) 폰켓몬을 선택
     * 두 번째(1번), 네 번째(3번) 폰켓몬을 선택
     * 세 번째(2번), 네 번째(3번) 폰켓몬을 선택
     * 이때, 첫 번째(3번) 폰켓몬과 네 번째(3번) 폰켓몬을 선택하는 방법은 한 종류(3번 폰켓몬 두 마리)의 폰켓몬만 가질 수 있지만,
     * 다른 방법들은 모두 두 종류의 폰켓몬을 가질 수 있습니다. 따라서 위 예시에서 가질 수 있는 폰켓몬 종류 수의 최댓값은 2가 됩니다.
     * 당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
     * N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중,
     * 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
     * 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
     * nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
     * 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
     * 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
     */
    public int pocketMonMySolution(int[] nums) {
        System.out.println("=======================================");
        System.out.println("오박사님이 가지고있는 포켓몬들 = " + Arrays.toString(nums));
        int answer = 0;
        int numsLength = nums.length / 2;

        //선택이 가능한 종류의 최댓값, hash set을 사용하여 중복
        HashSet<Integer> pocketMonHashSet = new HashSet<>();
        for (int n : nums) {
            pocketMonHashSet.add(n);
        }
        System.out.println("중복제거한 포켓몬 HashSet = " + pocketMonHashSet);
        for (Integer pocketMonNum : pocketMonHashSet) {
            if (answer == numsLength) {
                break;
            }
            answer ++;
        }
        System.out.println("내가 최대로 선택 할 수 있는 경우의 수 : " + answer);
        return answer;
    }

    public int pocketMonTeacherSolution(int[] nums) {
        int answer = 0;
        return answer;
    }


    /**
     * 문제 설명
     * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
     *
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
     * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
     * completion의 길이는 participant의 길이보다 1 작습니다.
     * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
     * 참가자 중에는 동명이인이 있을 수 있습니다.
     */
    public String marathonMySolution(String[] participant, String[] completion) {
        String answer = "";
        //미완주 : 1
        //완주 : 0
        //동명이인은 : 2 셋팅 (같은키 즉 동명이인 둘 또는 그 수만큼 완주하면 -1을 해주므로 0이되어야 그 수만큼 완주했다는것을 알 수 있음)
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String participantName : participant) {
            resultMap.put(participantName, resultMap.getOrDefault(participantName, 0) + 1);
        }
        for (String completionName : completion) {
            //완주한 사람은 0으로 바꿔준다.
            resultMap.put(completionName, resultMap.get(completionName) - 1);
        }

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        System.out.println("my solution answer = " + answer);
        return answer;
    }

    public String marathonAnotherSolution(String[] participant, String[] completion) {
        // 1. 두 배열을 정렬한다 (1중 loop를 돌도록 하기 위해 정렬하는것!)
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. 두 배열이 다를 때까지 찾는다
        int i = 0;
        for(i=0; i<completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                break;
            }
        }

        // 3. 여기까지 왔다는 것은 마지막 주자가 완주하지 못했다는 의미이다.
        System.out.println("another solution answer = " + participant[i]);
        return participant[i];
    }


    /**
     * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
     *
     * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경,
     * 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신
     * 검정 선글라스를 착용하거나 해야 합니다.
     *
     * 종류	이름
     * 얼굴	동그란 안경, 검정 선글라스
     * 상의	파란색 티셔츠
     * 하의	청바지
     * 겉옷	긴 코트
     * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
     * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
     * 같은 이름을 가진 의상은 존재하지 않습니다.
     * clothes의 모든 원소는 문자열로 이루어져 있습니다.
     * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
     * 스파이는 하루에 최소 한 개의 의상은 입습니다.
     */
    public int camouflageMySolution(String[][] clothes) {
        /**
         * 이 문제는 경우의 수 공식 사용
         * 예를들어 상의의 수를 A 하의의 수를 B 라고 하면
         * 상의와 하의의 조합하는 경우의 수는 A*B 이다.
         *
         * 만약 상의만 선택하고 하의는 선택하지 않고의 경우의 수 공식은
         * (A+1) * (B+1)의 경우의 수가 나옴
         *
         * 위 경우의 수를 구한다음 아무것도 안입을경우의 1가지를 뺀것이
         * 이번 문제의 답이다.
         *
         * 먼저 의상 종류 별로 개수가 몇개인지 map에 담는다.
         * 그런다음 키값만큼 뽑아서 위 공식대로 곱해준다 +1 씩하여
         * 그다음은 둘다 안입은 경우를 제외하고자 -1을 빼주는것
         */
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for (String[] clothe : clothes) {
            hm.put(clothe[1], hm.getOrDefault(clothe[1], 0) + 1);
        }
        System.out.println("map = " + hm);
        for (String key: hm.keySet()) {
            answer = answer * (hm.get(key) + 1);
        }

        //-1 을 하는 경우는 아무것도 안입었을 경우의 수를 하나 제거하는것!
        //문제상에서는 무조건 하나는 입어야한다고 했다.
        answer -= 1;

        return answer;
    }
}
