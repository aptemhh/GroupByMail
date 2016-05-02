package com.myJava;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    StaticExceptions staticExceptions=new StaticExceptions();
    public static void main(String[] args)  {
        Main main = new Main();
        main.Collector("logPS.txt").forEach(System.out::println);
        main.staticExceptions.getExceptions().forEach(System.out::println);
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
            staticExceptions.add("Файл не в кодировке UTF-8");
            try {
                List<String> lines2 = Files.readAllLines(Paths.get(path), Charset.forName("UTF-16"));
                for (String s : lines2) {
                    lines.add(new String(new String(s.getBytes("IBM866")).getBytes(), "UTF-8"));
                }
            } catch (UnsupportedEncodingException e1) {
                staticExceptions.add("Файл не в кодировке UTF-16");
            } catch (IOException e1) {
                staticExceptions.add("Проблемы с файлом! Проверьте существование и доступ к файлу");
            }
        }
        return lines;
    }
}
