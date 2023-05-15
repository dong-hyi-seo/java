package programmers.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class PhoneNumberListTest {

    private PhoneNumberList phoneNumberList;

    @BeforeEach
    void init() {
        phoneNumberList = new PhoneNumberList();
    }

    @Test
    void phoneNumberList_Test1() {
        //given
        final String[] phoneBook = {"119", "97674223", "1195524421"};

        //when
        boolean answer = phoneNumberList.solution(phoneBook);

        assertThat(answer).isFalse();
    }
//["123", "1005", "1006", "1007"]
    @Test
    void phoneNumberList_Test2() {
        //given
        final String[] phoneBook = {"123","456","789"};

        //when
        boolean answer = phoneNumberList.solution(phoneBook);

        assertThat(answer).isTrue();
    }

    @Test
    void phoneNumberList_Test3() {
        //given
        final String[] phoneBook = {"12","123","1235","567","88"};

        //when
        boolean answer = phoneNumberList.solution(phoneBook);

        assertThat(answer).isFalse();
    }

    @Test
    void phoneNumberList_Test4() {
        //given
        final String[] phoneBook = {"123", "1005", "1006", "1007"};

        //when
        boolean answer = phoneNumberList.solution(phoneBook);

        assertThat(answer).isTrue();
    }
}