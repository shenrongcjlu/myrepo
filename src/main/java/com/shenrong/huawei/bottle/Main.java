package com.shenrong.huawei.bottle;

import java.util.Scanner;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/1/14 13:36
 */
public class Main {

    int dividend = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        while (sc.hasNext()) {
            System.out.println(main.calculate(sc.nextInt()));
        }
    }

    private int calculate(int arg) {
        Total total = new Total(0);
        plus(total, arg);
        return total.number;
    }

    public void plus(Total total, int num) {
        int yushu = num % dividend;
        int shang = num / dividend;
        int sum = yushu + shang;
        total.number += shang;
        if (sum >= dividend) {
            plus(total, sum);
        } else if (sum + 1 == 3) {
            total.number += 1;
        }
    }

    class Total {
        int number = 0;
        public Total(int number) {
            this.number = number;
        }
    }
}
