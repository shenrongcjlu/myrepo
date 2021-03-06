package com.shenrong.restructure.chapter1.price;

import com.shenrong.restructure.chapter1.Movie;

/**
 * TODO
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/8/27 20:50
 */
public class NewReleasePrice extends AbstractPrice {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int dayRended) {
        double result = 0;
        result += dayRended * 3;
        return result;
    }

    @Override
    public int getFrequentRenderPoints(int dayRended) {
        return (dayRended > 1) ? 2 : 1;
    }
}
