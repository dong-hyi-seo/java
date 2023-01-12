package section2.item3.serialize;

import java.io.*;
import java.util.Base64;

public class SerializeExample {

    //ObjectOutputStream을 사용하여 직렬화를 진행하자
    public static void main(String[] args) {
        Member member = new Member("서동휘", "seee@ddddd", 33, "서울");

        //직렬화 값
        String serializedStr = memberSerialized(member);
        System.out.println("MEMBER 직렬화 : " + serializedStr);
        Member deserializedMember = memberDeserialized(serializedStr);
        System.out.println("MEMBER 역직렬화 : " + deserializedMember);
    }

    /**
     * 직렬화
     */
    private static String memberSerialized(Member member) {
        byte[] serializedMember;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(member);
                // serializedMember -> 직렬화된 member 객체
                serializedMember = baos.toByteArray();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(serializedMember);
    }

    /**
     * 역직렬화
     */
    private static Member memberDeserialized(String base64Member) {
        Member member = null;
        byte[] serializedMember = Base64.getDecoder().decode(base64Member);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                // 역직렬화된 Member 객체를 읽어온다.
                Object objectMember = ois.readObject();
                member = (Member) objectMember;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return member;
    }
}
