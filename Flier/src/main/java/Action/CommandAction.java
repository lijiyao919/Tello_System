package Action;

import Communicator.TelloComm;

public class CommandAction extends Action{
    protected CommandAction(TelloComm tc) {
        super(tc, "command");
    }
}
