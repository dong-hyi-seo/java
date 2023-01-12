package section3.item11;

public class PhoneNumber {
    protected int firstNumber;
    protected int secondNumber;
    protected int thirdNumber;

    private PhoneNumber() {}

    public PhoneNumber(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }

        PhoneNumber p = (PhoneNumber) obj;
        return this.firstNumber == p.firstNumber &&
                this.secondNumber == p.secondNumber &&
                this.thirdNumber == p.thirdNumber;
    }
}
