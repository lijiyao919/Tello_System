public class CommandMessageFactory implements MessageFactory{
    @Override
    public Message createMsg(String data) {
        Message msg=null;
        if (data.startsWith(Command.getKeyWord()))
            msg = new Command();
        else if (data.startsWith(TakeOff.getKeyWord()))
            msg = new TakeOff();
        else if (data.startsWith(Land.getKeyWord()))
            msg = new Land();
        else if (data.startsWith(Left.getKeyWord()))
            msg = new Left(data);
        else if (data.startsWith(Right.getKeyWord()))
            msg = new Right(data);
        else if (data.startsWith(Rotate.getKeyWord()))
            msg = new Rotate(data);

        return msg;
    }
}
