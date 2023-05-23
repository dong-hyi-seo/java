package section6.item34;

import static section6.item34.PayrollDayGoodCase.PayType.*;
/**
 * PayrollDayBadCase 이 나쁜 예 케이스를 좋게 해보자
 *
 * 이 방식은 잔업수당 계산을 PayType 전략 열거 타입에 위임하여,
 * switch 문이나 상수별 메서드 구현이 필요 없게 된다.
 * 이 패턴은 switch문보다 복잡하지만 더 안전하고 유연하다.
 *
 */
public enum PayrollDayGoodCase {
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY), THURSDAY(WEEKDAY), FRIDAY(WEEKDAY), SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDayGoodCase(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate){
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate){
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int minsWorked, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        public int pay(int minsWorked, int payRate){
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

}
