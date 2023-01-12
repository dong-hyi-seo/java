package programmers.ingang;

/**
 * 문제 : 자연수 N이 입력되면 N!을 구하는 프로그램을 작성
 * 예를들어 5! = 5*4*3*2*1 = 120
 */
public class FactorialTraining {

    public int factorialMySolution(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*factorialMySolution(n-1);
        }
    }
}
