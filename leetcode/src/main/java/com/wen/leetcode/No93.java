package com.wen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huwenwen
 * @since 2019/9/10
 */
public class No93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        for (int a = 1; a <= 3; a++)
            for (int b = 1; b <= 3; b++)
                for (int c = 1; c <= 3; c++) {
                    int d = s.length() - a - b - c;
                    if (d > 0 && d <= 3) {
                        int i1 = Integer.parseInt(s.substring(0, a));
                        int i2 = Integer.parseInt(s.substring(a, a + b));
                        int i3 = Integer.parseInt(s.substring(a + b, a + b + c));
                        int i4 = Integer.parseInt(s.substring(a + b + c));
                        if (i1 <= 255 && i2 <= 255 && i3 <= 255 && i4 <= 255) {
                            String ip = i1 + "." + i2 + "." + i3 + "." + i4;
                            if (ip.length() == s.length() + 3) {
                                list.add(ip);
                            }
                        }
                    }
                }
        return list;
    }

}
