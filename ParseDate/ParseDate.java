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

        // Extract numbers
        String[] parts = stringDate.split("[^0-9]+");
        if (parts.length < 3) {
            return null;
        }

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);

        String lower = stringDate.toLowerCase();

        // French + English PM indicators
        boolean isPM =
                lower.contains("soir") ||
                lower.contains("après-midi") ||
                lower.contains("apres-midi") ||
                lower.contains("evening") ||
                lower.contains("afternoon");

        // French + English AM indicators
        boolean isAM =
                lower.contains("matin") ||
                lower.contains("morning");

        // PM conversion
        if (isPM && hour < 12) {
            hour += 12;
        }

        // AM 12 → 00
        if (isAM && hour == 12) {
            hour = 0;
        }

        return LocalTime.of(hour, minute, second);
    }
}