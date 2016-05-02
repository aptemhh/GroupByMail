
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Idony on 29.04.2016.
 */
public class Divider {
    int i=0,k;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss uuuu Z", Locale.UK);
    public ArrayList<String> getComit(List<String> lines)
    {
        k=0;
        if(i==lines.size())return null;
        ArrayList<String> arrayList=new ArrayList<>();
        for(;i<lines.size();i++)
        {
            if(Pattern.compile("^commit\\s\\S+$").matcher(lines.get(i)).find())
                k++;
            if(k>1)break;
            arrayList.add(lines.get(i));
        }
        return arrayList;
    }

    public EmailAndFact getEmailAndFact(List<String> comit)
    {
        comit.removeIf(s -> {
            return Pattern.compile("^\\s*$").matcher(s).find();
        });
        String nameCommit=comit.remove(3).substring(4);
        String data=comit.remove(2).substring(8);
        String infoPerson=comit.remove(1).substring(8);
        comit.remove(0);
        Matcher m=Pattern.compile("<\\S+[@]\\w+[.]\\w+>$").matcher(infoPerson);
        m.find();
        String[] s=null;
        if(comit.size()>0)
            s=comit.toArray(new String[]{});
        return new EmailAndFact(new InfoPerson(m.group(),infoPerson.substring(0,m.start()-1)),new Fact(LocalDateTime.parse(data, formatter),nameCommit,s));
    }
}