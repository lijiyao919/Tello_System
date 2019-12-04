package Action;

import Communicator.TelloComm;

public interface ActionFactory {
    public Action create(String cmd, TelloComm tc);
}
