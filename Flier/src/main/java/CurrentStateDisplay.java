import javax.swing.*;
import java.awt.*;

public class CurrentStateDisplay implements StateObserver, DisplayElement {
    private DroneState ds;
    private JFrame frame = new JFrame("Tello Flier");
    private JPanel panel1 = new JPanel();
    private FrontView panel2 = new FrontView();
    private SideView panel3 = new SideView();
    private JTextArea text1 = new JTextArea(10,20);
    private Status sta;

    public CurrentStateDisplay(StateSubject subject){
        subject.registerObserver(this);
        ds = (DroneState)subject;
    }

    @Override
    public void update(Status sta) {
        this.sta = sta;
        display();
    }

    @Override
    public void display() {
        String info = String.format("pitch:%s;roll:%s;yaw:%s;"+ "vgx:%s;vgy:%s;vgz:%s;"+ "templ:%s;temph:%s;"+  "tof:%s;h:%s;"+
                                    "bat:%s;baro:%s;"+ "time:%s;"+ "agx:%s;agy:%s;agz:%s",
                StringUtils.formatInteger(sta.getPitch()), StringUtils.formatInteger(sta.getRoll()), StringUtils.formatInteger(sta.getYaw()),
                StringUtils.formatInteger(sta.getSpeedX()), StringUtils.formatInteger(sta.getSpeedY()), StringUtils.formatInteger(sta.getSpeedZ()),
                StringUtils.formatInteger(sta.getLowTemperature()), StringUtils.formatInteger(sta.getHighTemperature()),
                StringUtils.formatInteger(sta.getFlightDistance()), StringUtils.formatInteger(sta.getHeight()),
                StringUtils.formatInteger(sta.getBatteryPercentage()), StringUtils.formatDouble(sta.getBarometerMeasurement()),
                StringUtils.formatInteger(sta.getMotorTime()),
                StringUtils.formatDouble(sta.getAccelerationX()), StringUtils.formatDouble(sta.getAccelerationY()), StringUtils.formatDouble(sta.getAccelerationZ()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showCurrentStatus(info);

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(panel3);
        frame.setLayout(new GridLayout(1, 3));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        showPositionView(info);
    }

    private void showCurrentStatus(String info){
        text1.setText("");
        text1.setLineWrap(true);
        text1.append(info);
        text1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(text1);
    }

    private void showPositionView(String info){
        panel2.repaint();
        panel3.repaint();
    }


    class FrontView extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            g.setColor(Color.BLACK);
            g.fillOval(ds.getPositionX().intValue(),ds.getPositionY().intValue(),20,20);
        }
    }

    class SideView extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            g.setColor(Color.BLACK);
            g.fillOval(ds.getPositionZ().intValue(),ds.getPositionY().intValue(),20,20);
        }
    }



}
