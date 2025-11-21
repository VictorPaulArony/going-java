import java.util.ArrayList;
import java.util.List;

public class HexaBaseObserver implements NumericBaseObserver {
    private List<String> events;

    public HexaBaseObserver() {
        events = new ArrayList<>();
    }

    public void updateState(int state) {
        events.add(Integer.toHexString(state));
    }

    public List<String> getEvents() {
        return events;
    }
}