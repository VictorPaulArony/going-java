import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class ValuePublisher {
    public List<NumericBaseObserver> observers;

    public ValuePublisher() {
        observers = new ArrayList<>();
    }

    public void updateState(int value) {
        for (NumericBaseObserver n : observers) {
            n.updateState(value);
        }
    }

    public void subscribe(NumericBaseObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(NumericBaseObserver observer) {
        observers.remove(observer);
    }
}