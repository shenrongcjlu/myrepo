package com.shenrong.restructure.chapter1;

import lombok.Data;

/**
 * TODO
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/8/27 17:46
 */
@Data
public class Rental {
    private Movie movie;
    private int dayRented;

    public double getCharge() {
        return movie.getCharge(dayRented);
    }

    public int getFrequentRenderPoints() {
        return movie.getFrequentRenderPoints(dayRented);
    }

}
