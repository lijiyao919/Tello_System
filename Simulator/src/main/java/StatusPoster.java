public class StatusPoster implements Runnable{
    DroneState ds;

    public StatusPoster(DroneState ds){
        this.ds = ds;
    }

    public void sendStatusMsg() throws Exception {
        Status sta = new Status(ds.getPitch(), ds.getRoll(), ds.getYaw(), ds.getSpeedX(), ds.getSpeedY(), ds.getSpeedZ(),
                ds.getLowTemperature(), ds.getHighTemperature(), ds.getFlightDistance(), ds.getHeight(),
                ds.getBatteryPercentage(), ds.getBarometerMeasurement(), ds.getMotorTime(),
                ds.getAccelerationX(), ds.getAccelerationY(), ds.getAccelerationZ());
        byte[] msg = sta.encode();
        TelloComm tc = new TelloComm( 0);
        tc.sendMsg(msg, "127.0.0.1", 8890);
    }

    @Override
    public void run() {
        while(Boolean.TRUE){
            try {
                sendStatusMsg();
                Thread.sleep(100);
            }
            catch (Exception e){
                //log
            }
        }
    }
}



