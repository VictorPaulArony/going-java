import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null || stringDate.isBlank()) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null || stringDate.isBlank()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "EEEE d MMMM yyyy", Locale.FRENCH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null || stringDate.isBlank()) {
            return null;
        }

        // Example input:
        // "09 heures du soir, 07 minutes et 23 secondes"

        // Extract numbers
        String[] parts = stringDate.split("[^0-9]+");
        if (parts.length < 3) {
            return null; // invalid format
        }

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);

        String lower = stringDate.toLowerCase();

        // Handle French AM/PM
        if (lower.contains("soir") || lower.contains("après-midi") || lower.contains("apres-midi")) {
            if (hour < 12) hour += 12;
        }
        if (lower.contains("matin")) {
            if (hour == 12) hour = 0;
        }

        return LocalTime.of(hour, minute, second);
    }
}
