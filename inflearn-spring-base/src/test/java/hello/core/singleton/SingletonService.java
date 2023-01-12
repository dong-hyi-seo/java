package hello.core.singleton;

public class SingletonService {

    //static class 레벨로 하나 가지고있다 ..
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private로 생성하여 생성을 막아버리자!!
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출!!");
    }

}
