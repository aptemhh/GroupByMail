import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Idony on 29.04.2016.
 */
public class EmailAndHistory {
    private InfoPerson infoPerson;
    private List<Fact> history;

    public EmailAndHistory() {
        history=new ArrayList<>();
    }

    public EmailAndHistory(EmailAndFact emailAndFact) {
        this.infoPerson=emailAndFact.getInfoPerson();
        history=new ArrayList<>();
        history.add(emailAndFact.getFact());
    }

    public InfoPerson getInfoPerson() {
        return infoPerson;
    }

    public void setInfoPerson(InfoPerson infoPerson) {
        this.infoPerson = infoPerson;
    }

    public void add(Fact fact)
    {
        history.add(fact);
    }

    public Fact[] getHistory()
    {
        return (Fact[]) history.toArray();
    }
    String s;
    @Override
    public String toString() {
        s = infoPerson.toString()+"\n";
        for (Fact  fact:history) {
            s+=fact.toString()+"\n";
        }
        return  s;
    }
    public void sort()
    {
        //history.sort((fact, t1) -> fact.getLocalDate().compareTo(t1.getLocalDate()));
    }
}
