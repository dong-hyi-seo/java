package com.donghyi.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit 5 부터는 public, private 할필요없음
 * reflection을 사용하기때문에 없음 ..
 */
class StudyTest {


    @Test
    @DisplayName("두번째 테스트")
    void testAssertThrows() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals(message, "limit 0보다 커야한다!");
    }

    @Test
    @DisplayName("첫테스트 !")
    void create() {
        Study study = new Study(10);

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

                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능인원은 0명 이상이다! .")

        );
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    /**
     * intellij 에서 테스트 실행할때 Tag에 fast만 수정하게 할수있고
     * gradle 안에서도 할당된 tag만 수행하게 할 수있음 !!
     *
     */
    @Test
    @DisplayName("TAG Fast TEST")
    @Tag("fast")
    void tagFastTest() {
        System.out.println("tagFastTest!");
    }

    @Test
    @DisplayName("TAG Slow TEST")
    @Tag("slow")
    void tagSlowTest() {
        System.out.println("tagSlowTest!");
    }

    /**
     * Meta Annotation 사용해보기 custom
     */
    @FastTest
    @DisplayName("Meta Annotation 사용하여 fast test!")
    void metaFastTest() {
        System.out.println("metaFastTest!");
    }

    @SlowTest
    @DisplayName("Meta Annotation 사용하여 slow test!")
    void metaSloawTest() {
        System.out.println("metaSlowTest!");
    }


    /**
     * 테스트 반복!
     * @RepeatedTest
     * - 어노테이션 안의 숫자는 반복횟수
     * - 몇번째 테스트인지 값을 뽑으려면 함수 인자값을 RepetitionInfo 사용 (아래와같이 log가 찍힌다!)
     * [ repeatTest count = DefaultRepetitionInfo [currentRepetition = 6, totalRepetitions = 10]]
     */
    @DisplayName("반복 테스트 (RepeatedTest)")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("repeatTest count = " + repetitionInfo);
    }

    /**
     * junit5 제공
     * @ParameterizeTest
     * 반복적인 테스트를 할때마다 난 다른값으로 사용하고싶을때 ?
     * @ValueSource 에 반복할 값을 주면 된다. 이때 인자값을 받을수있음!!
     *
     **/
    @DisplayName("반복 테스트 (ParameterizedTest)")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void parameterizeTest(String message) {
        System.out.println("parameterizeTest = " + message);
    }

    /**
     * Study converter를 사용하여 반복 테스트를 진행해보자
     * @param study
     */
    @DisplayName("반복 테스트 (ParameterizedTest)")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10, 20, 40})
    void parameterizeStudyTest(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println("parameterizeStudyTest = " + study);
        //output
        //parameterizeStudyTest = Study{status=DRAFT, limit=10, name='null'}
        //parameterizeStudyTest = Study{status=DRAFT, limit=20, name='null'}
        //parameterizeStudyTest = Study{status=DRAFT, limit=40, name='null'}
    }

    /**
     * 반복 테스트에서 CsvSource 사용!s
     * output
     * - study = Study{status=DRAFT, limit=10, name='자바 스터디'}
     * - study = Study{status=DRAFT, limit=20, name='스프링'}
     */
    @DisplayName("반복 테스트 ()")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterCsvStudyTest(Integer limit, String name) {
        Study study = new Study(limit, name);
        System.out.println("study = " + study);
    }

    /**
     * 위 인자값을 두개받는데 두개를 study로 하나로 받아주게끔 바꿔보자
     */
    @DisplayName("반복 테스트 (parameterCsvAggregateStudyTest)")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterCsvAggregateStudyTest(ArgumentsAccessor argumentsAccessor) {
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println("study = " + study);
    }

    /**
     * 위와 같이 ArgumentsAccessor 로 몇번째 index에서 값을 꺼내 Study 객체를 만들수있지만
     * converter 방법을 쓰는 것도 있다.
     */
    @DisplayName("반복 테스트 (parameterCsvAggregateConverterStudyTest)")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterCsvAggregateConverterStudyTest(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println("study = " + study);
    }

    /**
     * aggregator 같은 경우 대상 Study class가 public이여야 하고
     * 아래 converter가 static이어야함,
     */
    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Study(accessor.getInteger(0), accessor.getString(1));
        }
    }

    static class StudyConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
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