import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idony on 29.04.2016.
 */
public class EmailAndHistory {
    String email;
    List<Fact> history;

    public EmailAndHistory(String email) {
        this.email = email;
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
