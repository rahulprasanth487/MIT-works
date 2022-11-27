
import java.io.*;
import java.net.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaApplication7 {
    MimeMessage mime;
    Session newSession=null;

    public static void main(String[] args) throws MessagingException , AddressException {
        JavaApplication7 sm=new JavaApplication7();
        String from="clgworks2024@gmail.com";
        String pass="lozcqevuxicqgash";
        String To = "clgworks2024@gmail.com";
        sm.Setprop();
        sm.draft(To);
        sm.Send(from, pass);
        
    }
    
    private MimeMessage draft(String to) throws MessagingException
    {
        mime=new MimeMessage(newSession);
        mime.setSubject("Hellio world");
        mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mime.setText("I am rp");
        return mime;
    }
    
    private void Send(String From,String pass) throws MessagingException
    {
        Transport tp=newSession.getTransport();
        String host="smtp.gmail.com";
        tp.connect(host, From, pass);
        tp.sendMessage(mime, mime.getAllRecipients());
        System.out.println("Sent");
        tp.close();
    }
    
    private void Setprop()
    {
        Properties pr=System.getProperties();
        pr.put("mail.smtp.port",587);
        pr.put("mail.smtp.auth", true);
        pr.put("mail.smtp.starttls.enable",true);
        newSession=Session.getDefaultInstance(pr,null);
        
    }
    
}
