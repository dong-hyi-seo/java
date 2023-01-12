package hello.advanced.trace;

import lombok.Getter;
import lombok.Setter;

/**
 * 로그의 상태정보를 나타냄
 * 로그를 시작하면 끝이 있어야한다.
 */
@Getter
@Setter
public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
}
