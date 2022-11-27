import java.net.*;
import java.io.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.Store;
import javax.mail.Message;
import javax.mail.Folder;

public class Pop {
    
    public void display(String host,String user,String Pass) throws MessagingException , IOException
    {
        Properties pr=new Properties();
        pr.put("mail.pop3.host", host);
        pr.put("mail.pop3.auth", true);
        pr.put("mail.pop3.port",987);
        pr.put("mail.pop3.starttls.enable",true);
        Session newSession=Session.getDefaultInstance(pr,null);
        
        Store store=newSession.getStore("pop3s");
        store.connect(host,user,Pass);
        
        Folder folder=store.getFolder("INBOX");
        folder.open(folder.READ_ONLY);
        
        Message msg[]=folder.getMessages();
        int latest=msg.length-1;
        
        Message l=msg[latest];
        
        l.writeTo(System.out);
        
    }

    public static void main(String[] args) throws MessagingException , IOException {
        new Pop().display("pop.gmail.com","clgworks2024@gmail.com","ypfzqwjvowehdltr");
    }
}
