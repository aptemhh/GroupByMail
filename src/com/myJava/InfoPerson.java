package com.myJava;

/**
 * Created by Idony on 29.04.2016.
 */
public class InfoPerson {
    private String email;
    private String login;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InfoPerson(String email, String login) {
        this.email = email;
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {

        return email.equals(((InfoPerson)o).getEmail());
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  "email='" + email + '\'' +
                ", login='" + login + '\'';
    }

    public int compare(InfoPerson infoPerson)
    {
        return email.compareTo(infoPerson.getEmail());
    }
}
