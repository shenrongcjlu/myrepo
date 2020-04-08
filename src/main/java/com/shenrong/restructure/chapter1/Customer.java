package com.shenrong.restructure.chapter1;

import java.util.Enumeration;
import java.util.Vector;

import lombok.Data;

/**
 * TODO
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/8/27 18:58
 */
@Data
public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        double totalAmt = 0;
        int frequentRenderPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental record for" + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenderPoints++;
            frequentRenderPoints += each.getFrequentRenderPoints();

            result += "\t" + each.getMovie()
                .getTitle() + "\t" + each.getCharge() + "\n";
            totalAmt += each.getCharge();
        }
        result += "Amount owed is " + totalAmt + "\n";
        result += "You earned " + frequentRenderPoints + "frequent render points";
        return result;
    }


}
