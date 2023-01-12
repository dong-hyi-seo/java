package section2.item2;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 현재 내가 개발하고 있는 api에서 redis에 상태값을 저장하는데 각 도메인별로 반이상은 공통 매개변수, 나머지는 각 도메인의 필수 배개변수이다.
 * 공통 매개변수중
 * 필수 final 한 값은 (targetSource, totalCount, successCount, failCount, completedCount, errorMessage, startDatetime, endDatetime, jobGroupId)
 * 수집 도메인 선택 매개변수는 (insertCount, updateCount) - collect 도메인
 * 결합 도메인 선택 매개변수는 (findStandard(enum), mappingSuccessCount, rawDataCount, identifiedCount)
 *
 */
public abstract class RedisData {

    public enum ProgressStatus { RUNNING, STOPPED, FAILED, COMPLETED, BLOCKED, RETRY}
    private String targetSource; //필수 매개변수
    private int totalCount; //필수 매개변수
    private final int successCount = 0;
    private final int failCount = 0;
    private final int completedCount = 0;
    private final String errorMessage = "";
    private final LocalDateTime startDateTime = LocalDateTime.now();
    private LocalDateTime endDateTime;
    private String jobGroupId;

    abstract static class Builder<T extends Builder<T>> {

        private ProgressStatus progressStatus;
        private String targetSource;
        private int totalCount;
        private String jobGroupId;

        //필수로 받아야 될것들!
        //해당 Builder 생성자의 필수 매개변수는 하위 자식클래스로부터 받는다.
        public Builder(String targetSource, int totalCount, String jobGroupId) {
            this.targetSource = Objects.requireNonNull(targetSource); //null이면 null exception 발생
            this.totalCount = totalCount;
            this.jobGroupId = Objects.requireNonNull(jobGroupId);
        }

        //하위 클래스에서 공통으로 사용할 progress status!
        public T setProgressStatus(ProgressStatus status) {
            this.progressStatus = status;
            return self();
        }

        abstract RedisData build();

        //하위 클래스는 이 메서드를 재정의하고 this를 반환하도록 해야한다.
        protected abstract T self();
    }

    /**
     * 저장된 토핑이 build()를 호출할 때 각각 생성자에서 super(builder)를 호출하고
     * super는 RedisData의 생성자이므로 아래의 RedisData가 호출 되면서 저장
     */
    RedisData(Builder<?> builder) {
        targetSource = builder.targetSource;
        totalCount = builder.totalCount;
        jobGroupId = builder.jobGroupId;
    }

    /**
     * toString 오버라이드
     */
    @Override
    public String toString() {
        return "AbsParentRedisData{" +
                "targetSource='" + targetSource + '\'' +
                ", totalCount=" + totalCount +
                ", successCount=" + successCount +
                ", failCount=" + failCount +
                ", completedCount=" + completedCount +
                ", errorMessage='" + errorMessage + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", jobGroupId='" + jobGroupId + '\'' +
                '}';
    }
}
