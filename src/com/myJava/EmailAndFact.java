package com.myJava;

/**
 * Created by Idony on 29.04.2016.
 */
public class EmailAndFact {
    private InfoPerson infoPerson;
    private Fact fact;

    public EmailAndFact(InfoPerson infoPerson, Fact fact) {
        this.infoPerson = infoPerson;
        this.fact = fact;
    }

    public InfoPerson getInfoPerson() {
        return infoPerson;
    }

    public void setInfoPerson(InfoPerson infoPerson) {
        this.infoPerson = infoPerson;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    @Override
    public String toString() {
        return "EmailAndFact{" +
                "infoPerson=" + infoPerson.toString() +
                ", fact=" + fact.toString() +
                '}';
    }
}
