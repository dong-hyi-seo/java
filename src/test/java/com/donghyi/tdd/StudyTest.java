package com.donghyi.tdd;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit 5 부터는 public, private 할필요없음
 * reflection을 사용하기때문에 없음 ..
 */
class StudyTest {


    @Test
    @DisplayName("첫테스트 !")
    void create() {
        Study study = new Study(-10);

        /**
         * assertAll 이값이 없을경우 이전 assertions 함수에서 실패하면 그다음까지 안감
         * 하지만 assertAll을 사용하여 하면 전체다를 볼수있다.
         */
        assertAll(
            () ->assertNotNull(study),

            //값을 일치하는지 비교함!
            //첫번째 인자 : 검증하고자하는 값 / 두번째 : 비교대상 / 세버째: 메시지내용
            () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),


            /**
             * Supplier를 어쩔때 사용 ?
             * 아래와 같이 에러메시지에 대해서 복잡한 문자열 조합이 있을경우 좋다.
             * 그냥 위와같이 메시지를 작성해버리면 성공하든 실패하든 문자열 조합은 이루어지며,
             * 아래와 같이 사용하면 에러날경우에만 조합.. (성능적으로 약간의 이점이 있다)
             */
            //ssertEquals suppliyer
            () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
                @Override
                public String get() {
                    return "스터디를 처음 만들면 상태값이 DRAFT여야 한다.";
                }
            }),

            //assertEquals Supplier lamda
            () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 DRAFT여야 한다."),

            () -> assertTrue(study.getLimit() < 0, "스터디 최대 참석 가능인원은 0명이다 .")

        );
    }

    @Test
    @DisplayName("두번째 테스트")
    void testAssertThrows() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals(message, "limit 0보다 커야한다!");
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    /**
     * @BeforeAll 은 위 테스트 함수 실해전 한번만 실행하며
     * 반드시 static으로 생성해야한다.
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    /**
     * @AfterAll 도 마찬가지로 static으로 생성해야함.
     */
    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    /**
     * @BeforeEach 테스트 함수가 호출되기전에 매번 호출된다..!
     * static일 필요 없다.
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    /**
     * @AfterEach 테스트 함수가 호출된후 배먼 실행한다 ..
     * static일 필요 없다,
     */
    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }



}