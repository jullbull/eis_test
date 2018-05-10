package lt.pavelvincel.lbapp;

import lt.pavelvincel.lbapp.domains.Currency;
import lt.pavelvincel.lbapp.services.CurrencyDataExtractor;
import lt.pavelvincel.lbapp.services.constants.FileName;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//        String  url = "https://www.lb.lt/lt/currency/exportlist/?csv=1&currency=AUD&ff=1&class=Eu&type=day&date_from_day=2018-05-01&date_to_day=2018-05-08";
//        CurrencyDataReceiver currencyData = new CurrencyDataReceiver();
//        currencyData.getFile(url);

        CurrencyDataExtractor extractor = new CurrencyDataExtractor();
        extractor.getCurrencyData(FileName.XML_FILE_VALUES);



    }
}
