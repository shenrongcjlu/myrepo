package com.shenrong.huawei.bottle.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/1/14 22:30
 */
public class Main {
    // 定义输入长度
    static final int length = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int b = scanner.nextInt();

        // 输入数组
        int i = 0;
        List<Integer> dataList = new ArrayList<>(10);
        while (i < length) {
            dataList.add(scanner.nextInt());
            i++;
        }

        int total = 0;
        final Iterator<Integer> iterator = dataList.iterator();
        while (iterator.hasNext()) {
            int data = iterator.next();
            int result = bytesValue(data) % b;
            if (result <= c) {
                total++;
            }
        }
        System.out.println(total);
    }

    public static int bytesValue(int i) {
        byte[] result = new byte[4];
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return byteToHex(result[0]) + byteToHex(result[1]) + byteToHex(result[2]) + byteToHex(result[3]);
    }


    public static int byteToHex(byte b){
        String hex = Integer.toHexString(b & 0xFF);
        if(hex.length() < 2){
            hex = "0" + hex;
        }
        return Integer.valueOf(hex, 16);
    }
}
