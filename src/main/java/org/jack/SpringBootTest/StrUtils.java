package org.jack.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * StringUtil
 *
 * @author zhengzhe17
 * @date 2021/2/25
 */
public class StrUtils {
    public static List<Integer> str2IntList(String string) {
        List<Integer> nums = new ArrayList<>();
        if(string == null) {
            return nums;
        }
        String numsStr = string.substring(1, string.length() - 1);
        String[] numStrs = numsStr.split(",");
        for (String numStr : numStrs) {
            if("null".equals(numStr.toLowerCase())) {
                nums.add(null);
            } else {
                nums.add(Integer.valueOf(numStr));
            }
        }
        return nums;
    }

    public static String intList2Str(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);

            if(num == null) {
                sb.append("null");
            } else {
                sb.append(num.toString());
            }

            if(i != (nums.size() - 1)) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
