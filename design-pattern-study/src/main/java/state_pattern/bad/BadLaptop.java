package state_pattern.bad;

public class BadLaptop {

    public static String ON = "on";
    public static String OFF = "off";
    public static String SAVING = "saving";
    private String powerState = "";

    public BadLaptop(){
        setPowerState(BadLaptop.OFF);
    }

    public void setPowerState(String powerState){
        this.powerState = powerState;
    }

    /**
     * 조건분 상태가 많을경우 분기하는 코드가 굉장히 길엊진다.
     * 상태에 따라 하고자 하는 행위를 파악하기가 쉽지 않을 것이다.
     * 이런경우 상태에 따라 행위를 달리해야 하는 경우에 사용하는 패턴이 스테이트패턴이다.
     * good package에서 참조!
     */
    public void powerPush(){
        if ("on".equals(this.powerState)) {
            System.out.println("전원 off");
        }
        else if ("saving".equals(this.powerState)){
            System.out.println("전원 on");
        }
        else {
            System.out.println("절전 모드");
        }
    }
}
