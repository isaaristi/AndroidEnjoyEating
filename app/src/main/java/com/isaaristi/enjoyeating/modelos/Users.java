package com.isaaristi.enjoyeating.modelos;

/**
 * Created by Isabel on 13/06/17.
 */

public class Users {
    String username, correo, password;

    public Users(String username, String correo, String password) {
    }

    public Users(String username, String password) {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
