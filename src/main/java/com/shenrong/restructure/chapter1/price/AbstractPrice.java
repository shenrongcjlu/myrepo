package com.shenrong.restructure.chapter1.price;

import com.shenrong.restructure.chapter1.Movie;

/**
 * TODO
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/8/27 20:50
 */
public abstract class AbstractPrice {
    public abstract int getPriceCode();

    public abstract double getCharge(int dayRended);

    public int getFrequentRenderPoints(int dayRended) {
        return 1;
    }
}
