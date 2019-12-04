package Action;

import Communicator.TelloComm;
import Message.Command;

public class CommandAction extends Action{
    protected CommandAction(TelloComm tc) {
        super(tc, Command.getKeyWord());
    }
}
