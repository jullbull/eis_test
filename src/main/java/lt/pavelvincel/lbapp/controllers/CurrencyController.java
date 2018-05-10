package lt.pavelvincel.lbapp.controllers;

import lt.pavelvincel.lbapp.domains.Currency;
import lt.pavelvincel.lbapp.services.CurrencyService;
import lt.pavelvincel.lbapp.services.CurrencyStatistic;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080" )

@RestController
@RequestMapping("/api")
public class CurrencyController {
    private List<Currency> currencies = new ArrayList<>();


    @RequestMapping("/getall")
    public List<Currency> getAllValues(@RequestParam(name = "date") String date) {
        CurrencyService service = new CurrencyService();


        return service.getAllCodesAndNames(date);

    }

    @RequestMapping("/from/to")
    public List<Currency> getFromTo(@RequestParam(name = "code") String code,
                                    @RequestParam(name = "from") String dateFrom,
                                    @RequestParam(name = "to") String dateTo) {
        CurrencyService service = new CurrencyService();

        currencies = service.getDataFromTo(code, dateFrom, dateTo);


        return currencies;
    }

    @RequestMapping("/getdifference")
    public double getDifference(@RequestParam(name = "code") String code,
                                @RequestParam(name = "from") String dateFrom,
                                @RequestParam(name = "to") String dateTo) {

        CurrencyStatistic statistic = new CurrencyStatistic();

        return statistic.getChangesFromTo(getFromTo(code, dateFrom, dateTo));

    }


}
