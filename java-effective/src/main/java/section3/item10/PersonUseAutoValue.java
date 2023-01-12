package section3.item10;

import com.google.auto.value.AutoValue;

/**
 * 1. equals 또는 hashcode를 google이 만든 autovalue 라이브러리로 만들어보자
 */
@AutoValue
public abstract class PersonUseAutoValue {

    public abstract String name();
    public abstract int age();

    public static PersonUseAutoValue create(String name, int age) {
        return new AutoValue_PersonUseAutoValue(name, age);
    }
}
