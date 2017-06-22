package com.isaaristi.enjoyeating.modelos;

public class Users {
    String username, correo, password;

    public Users(String username, String correo, String password) {
        this.username = username;
        this.correo = correo;
        this.password = password;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
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
