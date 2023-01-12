package state_pattern.good;

public class Saving implements PowerState {

    @Override
    public void powerPush(){
        System.out.println("전원 on");
    }
}
