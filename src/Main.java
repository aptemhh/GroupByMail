import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.Collector("logCMD.txt").forEach(System.out::println);
    }

    public Stream Collector(String path) {
        List<String> lines = null;
        List<String> comit;
        Divider divider = new Divider();
        List<EmailAndHistory> emailAndHistoryArrayList = new ArrayList<>();
        Merge merge = new Merge();
        lines = reader(path);

        for (; (comit = divider.getComit(lines)) != null; ) {
            merge.merges(divider.getEmailAndFact(comit), emailAndHistoryArrayList);
        }
        emailAndHistoryArrayList.sort((emailAndHistory1, t1) -> emailAndHistory1.getInfoPerson().compare(t1.getInfoPerson()));
        emailAndHistoryArrayList.forEach(s -> s.sort());
        return emailAndHistoryArrayList.stream();
    }

    public List<String> reader(String path) {
        List<String> lines = new ArrayList<>();
        try {

            lines = Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));

        } catch (IOException e) {
            try {
                List<String> lines2 = Files.readAllLines(Paths.get(path), Charset.forName("UTF-16"));
                for (String s:lines2) {
                    lines.add(new String(new String(s.getBytes("IBM866")).getBytes(),"UTF-8"));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return lines;
    }
}
