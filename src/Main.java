import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args)  {
        Main main=new Main();
        main.Collector("logCMD.txt").forEach(System.out::println);
    }
    public Stream Collector(String path)
    {
        List<String> lines = null;
        List<String> comit;
        Divider divider=new Divider();
        List<EmailAndHistory> emailAndHistoryArrayList=new ArrayList<>();
        Merge merge=new Merge();

        try {
            lines = Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(;(comit=divider.getComit(lines))!=null;)
        {
            merge.merges(divider.getEmailAndFact(comit),emailAndHistoryArrayList);
        }
        emailAndHistoryArrayList.sort((emailAndHistory1, t1) -> emailAndHistory1.getInfoPerson().compare(t1.getInfoPerson()));
        emailAndHistoryArrayList.forEach(s->s.sort());
        return emailAndHistoryArrayList.stream();
    }
}

