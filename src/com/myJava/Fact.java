package com.myJava;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by Idony on 29.04.2016.
 */
public class Fact {
    LocalDateTime localDateTime;
    String nameComit;
    String[] description;

    public Fact(LocalDateTime localDateTime, String nameComit, String[] description) {
        this.localDateTime = localDateTime;
        this.nameComit = nameComit;
        this.description = description;
    }



    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String getNameComit() {
        return nameComit;
    }

    public void setNameComit(String nameComit) {
        this.nameComit = nameComit;
    }

    public LocalDateTime getLocalDate() {
        return localDateTime;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDateTime = localDate;
    }

    String s;

    @Override
    public String toString() {
        s =  localDateTime.getDayOfMonth()+"/"+localDateTime.getMonth()+"/" +
                localDateTime.getYear()+" "+localDateTime.getHour()+":"+localDateTime.getMinute()+":" +
                localDateTime.getSecond()+
                ", nameComit='" + nameComit + '\'' +
                ", description='";
        if(description!=null)
        Arrays.stream(description).forEach(e -> s += e);
        else
        s+="null";
        s+="'";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fact fact = (Fact) o;

        if (!localDateTime.equals(fact.localDateTime)) return false;
        if (!nameComit.equals(fact.nameComit)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(description, fact.description);

    }

    @Override
    public int hashCode() {
        int result = localDateTime.hashCode();
        result = 31 * result + nameComit.hashCode();
        result = 31 * result + Arrays.hashCode(description);
        return result;
    }
}
