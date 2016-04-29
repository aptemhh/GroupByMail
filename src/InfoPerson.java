/**
 * Created by Idony on 29.04.2016.
 */
public class InfoPerson {
    String email;
    String login;

    public InfoPerson(String email, String login) {
        this.email = email;
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        return email.equals(o);
    }
}
