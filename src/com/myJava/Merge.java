package com.myJava;


import java.util.List;

/**
 * Created by Idony on 29.04.2016.
 */
public class Merge {
    boolean bool;
    public void merges(EmailAndFact emailAndFact, List<EmailAndHistory> emailAndHistory) {
        bool=false;
        emailAndHistory.forEach(s->
        {
            if(s.getInfoPerson().equals(emailAndFact.getInfoPerson()))
            {
                s.add(emailAndFact.getFact());
                bool=true;
            }
        }
        );
        if(!bool)emailAndHistory.add(new EmailAndHistory(emailAndFact));
    }
}
