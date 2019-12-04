package Action;

import Communicator.TelloComm;

public class RightAction extends Action{
    protected RightAction(TelloComm tc, double value) {
        super(tc, "right "+value);
    }


}
