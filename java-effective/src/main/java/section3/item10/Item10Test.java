package section3.item10;

/**
 * @author donghyi.seo
 * @since 2022-09-05
 * item10. equals는 일반 규약을 지켜 재정의하라
 */
public class Item10Test {

    public static void main(String[] args) {

        //person 객체를 동일한 name, age를 가지는 두개의 객체를 만들어
        //Object class에서 제공하는 equals 함수로 비교해보자
        Person person1 = Person.createPerson("서동휘", 33);
        Person person2 = Person.createPerson("서동휘", 33);

        System.out.println("person1 is person2 ? : " + person1.equals(person2)); //false

        /**
         * autovalue libary 적용
         */
        PersonUseAutoValue personUseAutoValue1 = PersonUseAutoValue.create("서동휘", 33);
        PersonUseAutoValue personUseAutoValue2 = PersonUseAutoValue.create("서동휘", 33);

        System.out.println("personUseAutoValue1 is personUseAutoValue2 ? : " + personUseAutoValue1.equals(personUseAutoValue2)); //false
    }
}
