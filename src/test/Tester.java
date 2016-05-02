package test;

import com.myJava.EmailAndFact;
import com.myJava.Fact;
import com.myJava.InfoPerson;
import com.myJava.Merge;
import org.junit.Assert;
import org.junit.Test;


import com.myJava.EmailAndHistory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idony on 02.05.2016.
 */
public class Tester  {

    @Test
    public void TestMerge1()
    {
        EmailAndFact emailAndFact1=new EmailAndFact(new InfoPerson("<m@mail.ru>","as"),new Fact(LocalDateTime.MAX,"asd",null));
        EmailAndFact emailAndFact2=new EmailAndFact(new InfoPerson("<m@mail.ru>","as"),new Fact(LocalDateTime.MIN,"asd",null));

        List<EmailAndHistory> historyList1=new ArrayList<>();
        historyList1.add(new EmailAndHistory(emailAndFact1));

        List<EmailAndHistory> historyList2=new ArrayList<>();
        EmailAndHistory emailAndHistory=new EmailAndHistory();
        emailAndHistory.setInfoPerson(new InfoPerson("<m@mail.ru>","as"));
        emailAndHistory.add(new Fact(LocalDateTime.MAX,"asd",null));
        emailAndHistory.add(new Fact(LocalDateTime.MIN,"asd",null));
        historyList2.add(emailAndHistory);

        Merge merge=new Merge();
        merge.merges(emailAndFact2,historyList1);

        Assert.assertEquals(historyList1,historyList2);
    }
    @Test
    public void TestMerge2()
    {
        EmailAndFact emailAndFact1=new EmailAndFact(new InfoPerson("<m@mail.ru>","as"),new Fact(LocalDateTime.MAX,"asd",null));
        EmailAndFact emailAndFact2=new EmailAndFact(new InfoPerson("<m@mail2.ru>","as2"),new Fact(LocalDateTime.MIN,"asd",null));

        List<EmailAndHistory> historyList1=new ArrayList<>();
        historyList1.add(new EmailAndHistory(emailAndFact1));

        List<EmailAndHistory> historyList2=new ArrayList<>();
        historyList2.add(new EmailAndHistory(emailAndFact1));
        historyList2.add(new EmailAndHistory(emailAndFact2));

        Merge merge=new Merge();
        merge.merges(emailAndFact2,historyList1);

        Assert.assertEquals(historyList1,historyList2);
    }

}
