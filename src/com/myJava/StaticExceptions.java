package com.myJava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Idony on 02.05.2016.
 */
public class StaticExceptions {
  static List<String>  ioExceptions=new ArrayList<>();
    public static void add(String e)
    {
        ioExceptions.add(e);
    }
    public Stream<String> getExceptions()
    {
        return ioExceptions.stream();
    }
}
