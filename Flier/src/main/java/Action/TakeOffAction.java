package Action;

import Communicator.TelloComm;

public class TakeOffAction extends Action{
    protected TakeOffAction(TelloComm tc) {
        super(tc, "takeoff");
    }
}
