package javier.gonzalez.prueba.modelos;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String password;
    private String gmail;

    public Usuario(String password, String gmail) {
        this.password = password;
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "password='" + password + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}
