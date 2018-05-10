package lt.pavelvincel.lbapp.services;

import lt.pavelvincel.lbapp.domains.Currency;
import lt.pavelvincel.lbapp.services.constants.FileName;
import java.util.List;

public class CurrencyService {


    public List<Currency> getAllCodesAndNames(String date) {
        CurrencyDataReceiver receiver = new CurrencyDataReceiver();
        CurrencyDataExtractor extractor = new CurrencyDataExtractor();
        try {

            receiver.getFile(FileName.URL_ALL_CODES_AND_NAMES + date, FileName.CODES_AND_NAMES);

            List<Currency> currencies = extractor.getCurrencyData(FileName.XML_FILE_FULL);

            return currencies;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Currency> getDataFromTo(String code, String dateFrom, String dateTo) {

        CurrencyDataReceiver receiver = new CurrencyDataReceiver();
        CurrencyDataExtractor extractor = new CurrencyDataExtractor();
        String url = receiver.getUrlByFromToAndCode(code, dateFrom, dateTo);
        try {
            receiver.getFile(url, FileName.VALUES);
            List<Currency> currencies = extractor.getCurrencyData(FileName.XML_FILE_VALUES);


            return currencies;
        } catch (Exception e) {
            return null;
        }
    }


}




