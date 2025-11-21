
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }

        DateTimeFormatter time = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.FRENCH);

        return LocalDate.parse(stringDate, time);
    }

    public static LocalTime parseTimeFormat(String s) {
        if (s == null) {
            return null;
        }
        String stringDate = s.replace(" heures du soir, ", ":")
                .replace(" heures du matin, ", ":")
                .replace(" minutes et ", ":")
                .replace(" secondes", "");
        LocalTime d = LocalTime.parse(stringDate);
        if (s.contains("soir")) {
            d = d.plusHours(12);
        }
        return d;
    }

}
