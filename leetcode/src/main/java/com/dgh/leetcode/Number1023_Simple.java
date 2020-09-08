package com.dgh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/camelcase-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/8
 */
public class Number1023_Simple {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ret = new ArrayList<>();
        char[] patternChars = pattern.toCharArray();
        for (String query : queries) {
            char[] chars = query.toCharArray();
            int start = 0;
            for (char patternChar : patternChars) {
                boolean replace = false;
                for (int i = start; i < chars.length; i++) {
                    if (chars[i] == patternChar) {
                        chars[i] = '1';
                        replace = true;
                        start = i + 1;
                        break;
                    }
                }
                if (!replace) {
                    chars = null;
                    break;
                }
            }

            if (null == chars) {
                ret.add(false);
                continue;
            }

            boolean r = true;
            for (char a : chars) {
                if (a == '1' || (a >= 'a' && a <= 'z')) {
                    continue;
                }
                r = false;
            }
            ret.add(r);
        }
        return ret;
    }
}
