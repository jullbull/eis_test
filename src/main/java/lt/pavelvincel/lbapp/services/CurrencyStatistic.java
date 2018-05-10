package lt.pavelvincel.lbapp.services;

import lt.pavelvincel.lbapp.domains.Currency;

import java.text.DecimalFormat;
import java.util.List;

public class CurrencyStatistic {


    public double getChangesFromTo(List<Currency> currencies){
        int lastItem = currencies.size()-1;
        double counter = (currencies.get(0).getVolume() - currencies.get(lastItem).getVolume());
        DecimalFormat df = new DecimalFormat("#.####");

        double result = Double.valueOf(df.format(counter));
        return result;

    }






}
