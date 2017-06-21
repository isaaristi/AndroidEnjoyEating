package com.isaaristi.enjoyeating.net;

/**
 * Created by Isabel on 19/06/17.
 */

public class RegistroResponse extends SimpleResponse {

    boolean exists;

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
