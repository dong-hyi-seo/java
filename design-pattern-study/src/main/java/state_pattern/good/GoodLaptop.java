package state_pattern.good;

public class GoodLaptop {
    private PowerState powerState;

    public GoodLaptop(){
        this.powerState = new Off();
    }

    public void setPowerState(PowerState powerState){
        this.powerState = powerState;
    }

    public void powerPush(){
        powerState.powerPush();
    }
}
