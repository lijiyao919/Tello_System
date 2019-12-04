package Action;

import Communicator.TelloComm;
import Message.Rotate;

public class RotateAction extends Action{
    protected RotateAction(TelloComm tc, double value) {
        super(tc, Rotate.getKeyWord() + " " + value);
    }


}
