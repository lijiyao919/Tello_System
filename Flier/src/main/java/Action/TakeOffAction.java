package Action;

import Communicator.TelloComm;
import Message.TakeOff;

public class TakeOffAction extends Action{
    protected TakeOffAction(TelloComm tc) {
        super(tc, TakeOff.getKeyWord());
    }
}
