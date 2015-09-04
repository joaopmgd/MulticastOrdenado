package multicast;

/**
 * Created by joao on 03/09/15.
 */
public class Message {

    private int clockFromProcess;
    private int pid;
    private String message;

    public Message(String message, int clockFromProcess, int pid){
        this.clockFromProcess = clockFromProcess;
        this.pid = pid;
        this.message = message;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getClockFromProcess() {
        return clockFromProcess;
    }

    public void setClockFromProcess(int clockFromProcess) {
        this.clockFromProcess = clockFromProcess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
