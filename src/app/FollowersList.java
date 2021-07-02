package app;

import java.util.ArrayList;

public class FollowersList {
    private String task;
    private boolean error;
    private String Result;
    ArrayList<UserHolder> connections;

    public ArrayList<UserHolder> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<UserHolder> connections) {
        this.connections = connections;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}
