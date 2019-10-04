package State;

import Message.Status;

public interface StateSubject {

    public abstract void registerObserver(StateObserver o);

    public abstract void removeObserver(StateObserver o);

    public abstract void notifyObserver(Status sta);
}
