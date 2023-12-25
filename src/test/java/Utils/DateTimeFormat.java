package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormat {
    public static String getCurrentDateTime(){
        LocalDateTime currentDateTime=LocalDateTime.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return currentDateTime.format(formatter);
    }
}
