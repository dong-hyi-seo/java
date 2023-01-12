package section2.item2;

import java.math.BigDecimal;

public class item2Test {
    public static void main(String[] args) throws Exception {
        //builder
        Item2SolutionCar item2SolutionCar = new Item2SolutionCar.Builder("동휘차")
                .brand("현대").price(new BigDecimal(48000000)).build();

        //심화
        CollectRedisData collectRedisData = new CollectRedisData
                .Builder("test", 20, "a")
                .setProgressStatus(RedisData.ProgressStatus.RETRY)
                .build();

        System.out.println(collectRedisData.toString());
    }
}

