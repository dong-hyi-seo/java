package leetcode.leetcode75_1.day2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix;

    @BeforeEach
    void init() {
        longestCommonPrefix = new LongestCommonPrefix();
    }

    @Test
    void longestCommonPrefix_Test() {
        //given
        String[] question1 = new String[]{"flower","flow","flight"};
        String[] question2 = new String[]{"dog","racecar","car"};
        String[] question3 = new String[]{"dog", "do", "it"};
        String[] question4 = new String[]{"a", "b", "c"};

        //when
        String answer1 = longestCommonPrefix.longestCommonPrefix(question1);
        String answer2 = longestCommonPrefix.longestCommonPrefix(question2);
        String answer3 = longestCommonPrefix.longestCommonPrefix(question3);
        String answer4 = longestCommonPrefix.longestCommonPrefix(question4);
        System.out.println("answer3 = " + answer3);

        //then
        assertThat(answer1).isEqualTo("fl");
        assertThat(answer2).isEqualTo("");
        assertThat(answer3).isEqualTo("");
        assertThat(answer4).isEqualTo("");
    }

}