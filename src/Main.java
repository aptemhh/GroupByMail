import sun.text.normalizer.UTF16;
import ua.nio.cs.ext.CP1125;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("qwe.txt"), Charset.forName("UTF-8"));
        List<String> comit;
        Divider divider=new Divider();
        for(;(comit=divider.getComit(lines))!=null;)
        {
            divider.getEmailAndFact(comit);
        }
    }
}
class Divider
{
    int i=0,k;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss uuuu Z",Locale.UK);
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

        return new EmailAndFact("",new Fact(LocalDateTime.parse(comit.get(2).substring(8), formatter),"nameCommit","описание"));
    }
}