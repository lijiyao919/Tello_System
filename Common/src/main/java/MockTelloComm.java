import java.net.InetAddress;
import java.net.UnknownHostException;

public class MockTelloComm extends TelloComm{
    private Message msg;
    private InetAddress addr;

    public MockTelloComm(Message msg) throws Exception{
        this.msg = msg;
        addr = InetAddress.getByName("127.0.0.1");
    }


    @Override
    public void sendMsg(byte[] bytesToSent, String sendAddress, int sendPort){

    }

    @Override
    public byte[] receiveMsg() {
        byte[] msgByte = msg.encode();
        return msgByte;
    }

    @Override
    public InetAddress getSrcAddress()  {
        return addr;
    }

    @Override
    public int getSrcPort(){
        return 1;
    }
}
