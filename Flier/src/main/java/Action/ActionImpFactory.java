package Action;

import Communicator.TelloComm;

public class ActionImpFactory implements ActionFactory{
    @Override
    public Action create(String cmd, TelloComm tc) {
        String[] dataFields = cmd.split(" ");
        double value;
        Action act;

        if (dataFields[0].equals("command")) {
            act = new CommandAction(tc);
        }
        else if (dataFields[0].equals("takeoff")) {
            act = new TakeOffAction(tc);
        }
        else if (dataFields[0].equals("land")) {
            act = new LandAction(tc);
        }
        else if (dataFields[0].equals("left")) {
            value = Double.parseDouble(dataFields[1]);
            act = new LeftAction(tc, value);
        }
        else if (dataFields[0].equals("right")) {
            value = Double.parseDouble(dataFields[1]);
            act = new RightAction(tc, value);
        }
        else if (dataFields[0].equals("rotate")) {
            value = Double.parseDouble(dataFields[1]);
            act = new RotateAction(tc, value);
        }
        else {
            throw new UnsupportedOperationException();
        }

        return act;
    }
}
