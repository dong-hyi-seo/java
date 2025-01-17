package programmers.sort;

/**
 * 작은 것들, 큰 것들을 나눠서 합친다.
 * 3, 1, 5, 2, 4
 *
 * - 위 5개 숫자중 pivot을 선정한다. 일단 아무거나 하나 골라 !
 * pivot = 5
 * 3, 1, 2, 4, [5]
 * pivot 5 보다 작은값을 왼쪽 큰값을 오른쪽
 *
 * - 여기서 pivot 5 제외한 3, 1, 2, 4 에서 Pivot값 선정
 * pivot 2
 * 1, [2], 3, 4, [5]
 *
 * - 여기서 pivot 기준으로 나머지 범위에서 아무거나 pivot 선정
 * 왼쪽 그룹 1은 하나니까 자리가 고정됨
 * 나머지 3, 4 pivot = 4
 * pivot보다 작은값 왼쪽 큰값 오른쪽 (작은 그룹 + pivot + 큰그룹)
 * 1, 2, 3, 4, 5
 *
 * O(nlogn) 시간복잡도를 가진다.
 *
 * pivot으로 작은그룹 큰그룹을 나누는데 비교대상이 절반씩 줄어드는거나 마찬가지
 * 회를 거듭할수록 범위가 절반씩 점점 줄어듬
 *
 */
public class Quick정렬 {
}
