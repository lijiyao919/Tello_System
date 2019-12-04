package Mission;

import Communicator.TelloComm;
import Action.Action;
import Action.ActionFactory;
import Action.ActionImpFactory;
import State.DroneState;

public abstract class Mission {
    private ActionFactory actFactory;
    private TelloComm tc;
    protected DroneState ds;

    public Mission(TelloComm tc) {
        this.actFactory = new ActionImpFactory();
        this.tc = tc;
        this.ds = DroneState.getInstance();
    }

    protected Boolean doAction(String cmd) throws Exception {
        Action act = actFactory.create(cmd, tc);
        return act.execute();
    }

    protected abstract Boolean doCustomizedActions(TelloComm tc) throws Exception;

    public Boolean executeMission() throws Exception{
        if(doAction("command") == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doAction("takeoff") == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doCustomizedActions(tc) == Boolean.FALSE){
            return Boolean.FALSE;
        }

        if(doAction("land") == Boolean.FALSE){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
