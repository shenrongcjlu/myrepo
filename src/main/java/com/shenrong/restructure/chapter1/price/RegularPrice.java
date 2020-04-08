package com.shenrong.restructure.chapter1.price;

import com.shenrong.restructure.chapter1.Movie;

/**
 * TODO
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/8/27 20:50
 */
public class RegularPrice extends AbstractPrice {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int dayRended) {
        double result = 0;
        result += 2;
        if (dayRended > 2) {
            result += (dayRended - 2) * 1.5;
        }
        return result;
    }
}
