package lt.pavelvincel.lbapp.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CurrencyDataReceiver {

    private static final String URL = "https://www.lb.lt/lt/currency/exportlist/?xml=1&currency=";
    private static final String EXTEND_URL = "&ff=1&class=Eu&type=day&";
    private static final String DATE_FROM_DAY = "date_from_day=";
    private static final String DATE_TO_DAY = "&date_to_day=";

//https://www.lb.lt/lt/currency/exportlist/?xml=1&currency=AUD&ff=1&class=Eu&type=day&date_from_day=2018-04-09&date_to_day=2018-05-09

    public void getFile(String url, String file) throws IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        HttpResponse response = httpClient.execute(get);

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream inputStream = entity.getContent();


            FileOutputStream fileOutputStream = new FileOutputStream(new File(file));
            int inByte;

            while ((inByte = inputStream.read()) != -1)
                fileOutputStream.write(inByte);

            inputStream.close();
            fileOutputStream.close();


        }

    }

    public String getUrlByFromToAndCode(String code, String dateFrom, String dateTo) {

        StringBuilder sb = new StringBuilder();
        sb.append(URL).append(code).append(EXTEND_URL).append(DATE_FROM_DAY)
                .append(dateFrom).append(DATE_TO_DAY).append(dateTo);

        String url = sb.toString();

        return url;
    }
}
