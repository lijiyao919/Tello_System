package Action;

import Communicator.TelloComm;

public class RotateAction extends Action{
    protected RotateAction(TelloComm tc, double value) {
        super(tc, "cw "+value);
    }


}
