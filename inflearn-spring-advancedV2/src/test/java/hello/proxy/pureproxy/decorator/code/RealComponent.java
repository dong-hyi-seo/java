package hello.proxy.pureproxy.decorator.code;

public class RealComponent implements Component {


    @Override
    public String operation() {
        return "data";
    }
}
