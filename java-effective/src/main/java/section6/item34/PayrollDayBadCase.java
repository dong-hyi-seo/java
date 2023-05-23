package section6.item34;

/**
 * 다음과 같이 시간당 기본 임금과 그날 일한 시간이 주어지면 일당을 계산해주는 메서드를 갖고 있는 열거타입이다.
 * 위 코드는 간결해보이지만, 관리하는데에 있어서는 위험한 코드이다.
 * 새로운 값을 열거타입에 추가하고, 그 값을 처리하는 case문에도 반드시 넣어줘야하는 것이다.
 * 만약 까먹고 case문에 추가를 안한 경우 휴일 수당을 받아야하는데 평일 수당을 받게되는 경우가 발생할 수도 있다.
 */
public enum PayrollDayBadCase {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay;
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                overtimePay = basePay / 2;
                break;
            default:
                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }

        return basePay + overtimePay;
    }

}
