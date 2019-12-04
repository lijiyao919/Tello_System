package Action;

import Communicator.TelloComm;
import Message.Land;

public class LandAction extends Action{
    protected LandAction(TelloComm tc) {
        super(tc, Land.getKeyWord());
    }

}
