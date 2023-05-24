package section6.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * EnumSet 클래스는 열거 타입상수의 값으로 구성된 집합을 효과적으로 표현해준다.
 */
public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n",
                Objects.requireNonNull(styles));
    }

    // 사용 예
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
