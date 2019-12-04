package Action;

import Communicator.TelloComm;
import Message.Command;
import Message.Land;
import Message.Left;
import Message.Right;
import Message.Rotate;
import Message.TakeOff;

public class ActionImpFactory implements ActionFactory{
    @Override
    public Action create(String cmd, TelloComm tc) {
        String[] dataFields = cmd.split(" ");
        double value;
        Action act;

        if (dataFields[0].equals(Command.getKeyWord())) {
            act = new CommandAction(tc);
        }
        else if (dataFields[0].equals(TakeOff.getKeyWord())) {
            act = new TakeOffAction(tc);
        }
        else if (dataFields[0].equals(Land.getKeyWord())) {
            act = new LandAction(tc);
        }
        else if (dataFields[0].equals(Left.getKeyWord())) {
            value = Double.parseDouble(dataFields[1]);
            act = new LeftAction(tc, value);
        }
        else if (dataFields[0].equals(Right.getKeyWord())) {
            value = Double.parseDouble(dataFields[1]);
            act = new RightAction(tc, value);
        }
        else if (dataFields[0].equals(Rotate.getKeyWord())) {
            value = Double.parseDouble(dataFields[1]);
            act = new RotateAction(tc, value);
        }
        else {
            throw new UnsupportedOperationException();
        }

        return act;
    }
}
