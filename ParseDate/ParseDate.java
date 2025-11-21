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

        DateTimeFormatter fr = DateTimeFormatter.ofPattern(
                "EEEE d MMMM yyyy", Locale.FRENCH);
        DateTimeFormatter en = DateTimeFormatter.ofPattern(
                "EEEE d MMMM yyyy", Locale.ENGLISH);

        try {
            return LocalDate.parse(stringDate, en);
        } catch (Exception ignored) {}

        try {
            return LocalDate.parse(stringDate, fr);
        } catch (Exception ignored) {}

        return null; // neither EN nor FR worked
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

        // Apply PM conversion
        if (isPM && hour < 12) {
            hour += 12;
        }

        // Apply AM midnight conversion
        if (isAM && hour == 12) {
            hour = 0;
        }

        return LocalTime.of(hour, minute, second);
    }
}
