import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        // ISO format is directly supported by LocalDateTime.parse
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        // Example: "lundi 25 avril 2022"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "EEEE d MMMM yyyy", Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        // Example: "09 heures du soir, 07 minutes et 23 secondes"

        // Extract numbers
        String[] parts = stringDate.split("[^0-9]+");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);

        // Detect "du soir" (= PM)
        boolean isSoir = stringDate.toLowerCase().contains("soir");

        if (isSoir && hour < 12) {
            hour += 12; // convert to 24h format
        }

        return LocalTime.of(hour, minute, second);
    }
}
