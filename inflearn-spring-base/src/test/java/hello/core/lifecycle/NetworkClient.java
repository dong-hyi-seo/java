package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("message = " + message + " //call : " + url);
    }

    public void disconnect() {
        System.out.println("close = " + url);
    }

    /**
     * 의존관계 주입이 끝날경우 실행
     * @throws Exception
     */
    public void init() throws Exception {
        System.out.println("NetworkClient INIT");
        connect();
        call("초기화 연결 메시지!");
    }

    /**
     * 종료시 실행!
     * @throws Exception
     */
    public void close() throws Exception {
        System.out.println("NetworkClient destroy");
        disconnect();
    }
}
