package Action;

import Communicator.TelloComm;
import Message.Right;

public class RightAction extends Action{
    protected RightAction(TelloComm tc, double value) {
        super(tc, Right.getKeyWord() + " "+value);
    }


}
