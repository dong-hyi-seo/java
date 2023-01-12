package state_pattern.good;

public class On implements PowerState {

    @Override
    public void powerPush(){
        System.out.println("전원 off");
    }
}
