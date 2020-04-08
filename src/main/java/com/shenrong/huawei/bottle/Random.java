package com.shenrong.huawei.bottle;

import java.util.*;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/1/14 18:31
 */
public class Random {
    public static void main(String[] args) {
        int i = 1257897979;
        byte[] result = new byte[4];
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);

        System.out.println(result[0] + result[1] + result[2] + result[3]) ;



    }
}
