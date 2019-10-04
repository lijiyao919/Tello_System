package Mock;

import State.DisplayElement;
import State.StateObserver;
import Message.Status;

public class MockObserver implements StateObserver, DisplayElement {
    @Override
    public void update(Status sta) {
         display();
    }

    @Override
    public void display() {

    }
}
