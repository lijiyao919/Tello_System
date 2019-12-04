package Action;

import Communicator.TelloComm;

public class LeftAction extends Action{
    protected LeftAction(TelloComm tc, double value) {
        super(tc, "left " + value);
    }


}
