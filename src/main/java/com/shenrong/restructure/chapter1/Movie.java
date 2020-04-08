package com.shenrong.restructure.chapter1;

import com.shenrong.restructure.chapter1.price.AbstractPrice;
import com.shenrong.restructure.chapter1.price.ChildrenPrice;
import com.shenrong.restructure.chapter1.price.NewReleasePrice;
import com.shenrong.restructure.chapter1.price.RegularPrice;
import com.sun.org.apache.regexp.internal.RE;

/**
 * TODO
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/8/27 17:15
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    private AbstractPrice price;

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public String getTitle() {
        return title;
    }

    public void setPriceCode (int arg) {
        switch (arg) {
            case CHILDRENS:
                price = new ChildrenPrice();
                return;
            case REGULAR:
                price = new RegularPrice();
                return;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                return;
            default:
                break;
        }
    }

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public double getCharge(int dayRended) {
        return price.getCharge(dayRended);
    }

    public int getFrequentRenderPoints(int dayRended) {
        return price.getFrequentRenderPoints(dayRended);
    }
}
