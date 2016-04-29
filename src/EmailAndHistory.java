import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idony on 29.04.2016.
 */
public class EmailAndHistory {
    InfoPerson infoPerson;
    List<Fact> history;

    public EmailAndHistory(InfoPerson infoPerson) {
        this.infoPerson = infoPerson;
        history=new ArrayList<>();
    }

    public void add(Fact fact)
    {
        history.add(fact);
    }

    public Fact[] getHistory()
    {
        return (Fact[]) history.toArray();
    }
}
