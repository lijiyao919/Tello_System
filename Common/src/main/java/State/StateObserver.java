package State;

import Message.Status;

public interface StateObserver {
    public abstract void update(Status sta);
}
