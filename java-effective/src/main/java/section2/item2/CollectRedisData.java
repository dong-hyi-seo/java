package section2.item2;

public class CollectRedisData extends RedisData {

    private final int insertCount = 0;
    public final int updateCount = 0;

    public static class Builder extends RedisData.Builder<Builder> {

        public Builder(String targetSource, int totalCount, String jobGroupId) {
            super(targetSource, totalCount, jobGroupId);
        }

        @Override
        CollectRedisData build() {
            return new CollectRedisData(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    private CollectRedisData(Builder builder) {
        super(builder);
    }

    @Override
    public String toString() {
        //부모 class toString도 찍히게 하자
        String parentStr = super.toString();
        return "CollectRedisData{" +
                "insertCount=" + insertCount +
                ", updateCount=" + updateCount +
                '}' + parentStr;
    }
}
