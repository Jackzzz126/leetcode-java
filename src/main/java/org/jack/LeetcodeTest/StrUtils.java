package org.jack.LeetcodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * StringUtil
 *
 * @author zhengzhe17
 * @date 2021/2/25
 */
public class StrUtils {
    public static List<Integer> str2IntList(String str) {
        List<Integer> nums = new ArrayList<>();
        if(str == null) {
            return nums;
        }
        int leftIndex = str.indexOf("[");
        int rightIndex = str.indexOf("]");
        if(leftIndex < 0 || rightIndex < 0) {
            return nums;
        }
        String numsStr = str.substring(leftIndex + 1, rightIndex);
        String[] numStrs = numsStr.split(",");
        for (String numStr : numStrs) {
            numsStr = numStr.toLowerCase().trim();
            if("null".equals(numStr)) {
                nums.add(null);
            } else if("".equals(numsStr)){
                continue;
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
