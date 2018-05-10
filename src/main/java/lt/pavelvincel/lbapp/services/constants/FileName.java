package lt.pavelvincel.lbapp.services.constants;

import java.io.File;

public class FileName {

    public static final String VALUES = "values.xml";
    public static final String CODES_AND_NAMES = "codesandnames.xml";
    public static final String URL_ALL_CODES_AND_NAMES = "https://www.lb.lt/lt/currency/daylyexport" +
            "/?xml=1&class=Eu&type=day&date_day=";

    public static final File XML_FILE_FULL = new File(CODES_AND_NAMES);
    public static final File XML_FILE_VALUES = new File(VALUES);







}
