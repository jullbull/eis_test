package lt.pavelvincel.lbapp.services;

import lt.pavelvincel.lbapp.domains.Currency;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrencyDataExtractor {


    public List<Currency> getCurrencyData(File file) {

        List<Currency> result = new ArrayList<>();

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList nodes = document.getElementsByTagName("item");


            for (int i = 1; i < nodes.getLength(); i++) {
                Currency currency = new Currency();


                Element element = (Element) nodes.item(i);

                NodeList title = element.getElementsByTagName("pavadinimas");
                Element line = (Element) title.item(0);
                String name = getString(line);
                currency.setName(name);


                NodeList code = element.getElementsByTagName("valiutos_kodas");
                line = (Element) code.item(0);
                String cod = getString(line);
                currency.setCode(cod);

                NodeList volume = element.getElementsByTagName("santykis");
                line = (Element) volume.item(0);
                String stVolume = getString(line);
                double dblVolume = parseStringToFloat(stVolume);
                currency.setVolume(dblVolume);


                NodeList date = element.getElementsByTagName("data");
                line = (Element) date.item(0);
                getString(line);

                Date newDate = stringToDate(getString(line));
                currency.setDate(newDate);

                result.add(currency);

            }


            return result;


        } catch (Exception e) {

            return null;
        }

    }

    private static String getString(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }


    private double parseStringToFloat(String st) {

        double fl = Double.parseDouble(st.replaceAll(",", "."));


        return fl;

    }


    private Date stringToDate(String date) throws ParseException {


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = df.parse(date);


        return newDate;


    }


}
