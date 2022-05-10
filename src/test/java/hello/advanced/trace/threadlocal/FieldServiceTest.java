package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> fieldService.logic("userA");
        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        //sleep(2000); //동시성 문제 발생안함 (만약 100 millis 로주면??)
        sleep(100); //동시성 문제 발생!!!! (해결하려면 ? ThreadLocal)
        /**
         * 23:04:05.031 [thread-A] INFO hello.advanced.trace.threadlocal.code.FieldService - 저장 name = userA -> nameStore = null
         * 23:04:05.135 [thread-B] INFO hello.advanced.trace.threadlocal.code.FieldService - 저장 name = userB -> nameStore = userA
         * 23:04:06.036 [thread-A] INFO hello.advanced.trace.threadlocal.code.FieldService - 조회 nameStore = userB
         * 23:04:06.139 [thread-B] INFO hello.advanced.trace.threadlocal.code.FieldService - 조회 nameStore = userB
         */
        threadB.start();

        sleep(2000);
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
