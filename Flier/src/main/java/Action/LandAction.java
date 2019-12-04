package Action;

import Communicator.TelloComm;

public class LandAction extends Action{
    protected LandAction(TelloComm tc) {
        super(tc, "land");
    }

}
