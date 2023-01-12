package section2.item3.serialize;

import java.io.Serializable;

public class Member implements Serializable {

    //구조가 변경됬을때의 대응 (역직렬화시에)
    private static final long serialVersionUID = 1L;
    private transient String name; //직렬화에 제외시킨다. (transiecnt)
    private String email;
    private int age;

    private String address;

    public Member(String name, String email, int age, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
