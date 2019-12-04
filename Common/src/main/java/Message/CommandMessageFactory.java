package Message;

public class CommandMessageFactory extends MessageFactory {
    @Override
    protected Message createMsg(String data)  {
        Message msg=null;
        String[] dataFields = data.split(" ");;
        double value;

        if (dataFields[0].equals(Command.getKeyWord())) {
            msg = new Command();
        }
        else if (dataFields[0].equals(TakeOff.getKeyWord())) {
            msg = new TakeOff();
        }
        else if (dataFields[0].equals(Land.getKeyWord())) {
            msg = new Land();
        }
        else if (dataFields[0].equals(Left.getKeyWord())) {
            value = Double.parseDouble(dataFields[1]);
            msg = new Left(value);
        }
        else if (dataFields[0].equals(Right.getKeyWord())) {
            value = Double.parseDouble(dataFields[1]);
            msg = new Right(value);
        }
        else if (dataFields[0].equals(Rotate.getKeyWord())) {
            value = Double.parseDouble(dataFields[1]);
            msg = new Rotate(value);
        }
        else {
            throw new UnsupportedOperationException();
        }

        return msg;
    }
}
