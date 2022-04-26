package com.study.java8.java8to11;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 2022-04-26
 * Date와 Time
 */
public class DateTimeStudy {

    /**
     * 옛날 Date..
     *
     * @param args
     */
    /*public static void main(String[] args) {
        Date date = new Date(); //기본적으로 timestamp
        long time = date.getTime();

        //예전 사용하던 java.util.Date 클래스는 mutable(변동성) 하기 때문에 thread safe하지 않다.
        //클래스이름이 명확하지 않다. Date인데 시간까지 다룬다.
        //버그 발생할 여지가 많다 (타입 안정성이 없고, 월이 0부터 시작함..)
            //not type safe
        //날짜 시간 처리가복잡한 어플리케이션에서는 봍오 Joda Time을 쓰곤함

    }*/


    /**
     * Java 8 LocalDate
     */
    public static void main(String[] args) {
        /**
         * 기계용 API (Method 실행시간떄 주로사용)
         */
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC (GMT)

        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime);


        /**
         * java 8 date api
         */

        //해당 값은 서버에 셋팅된 시간을 반환한다.
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //한국시간 체크
        LocalDateTime birthDay = LocalDateTime.of(1990, Month.DECEMBER, 17, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime nowInKorea1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea1 = " + nowInKorea1);

        //기간표현 (방법1)
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthData = LocalDate.of(2022, Month.DECEMBER, 17);
        Period period = Period.between(today, thisYearBirthData);
        System.out.println("period = " + period.getDays());

        //기간표현 (방법2)'
        Period until = today.until(thisYearBirthData);
        System.out.println("until = " + until.get(ChronoUnit.DAYS));

        //기간표현 (방법3) 머신용 기간
        Instant instantNow = Instant.now();
        Instant plus = instantNow.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(instantNow, plus);
        System.out.println("Duration Period between = " + between.getSeconds());

        //LocalDateTime 문자출력 (format)
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        DateTimeFormatter MMddyyyyFormater = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("string value localDatetimeNow = " + now.format(MMddyyyyFormater));

        //LocalDate parsing
        LocalDate parse = LocalDate.parse("12/17/1990", MMddyyyyFormater);
        System.out.println("locadate parsing = " + parse);

    }
}

