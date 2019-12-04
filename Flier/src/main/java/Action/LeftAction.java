package Action;

import Communicator.TelloComm;
import Message.Left;

public class LeftAction extends Action{
    protected LeftAction(TelloComm tc, double value) {
        super(tc, Left.getKeyWord() + " " + value);
    }


}
