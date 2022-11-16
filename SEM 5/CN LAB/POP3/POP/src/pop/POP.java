import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
public class POP {

    public static void displaymail(String host,String StartType,String user,String password) throws MessagingException,IOException
    {
        Properties prop=new Properties();
        prop.put("mail.pop3.host", host);
        prop.put("mail.pop3.port","995");
        prop.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(prop);
        
        Store store = emailSession.getStore("pop3s");
        store.connect(host,user,password);
        
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);
        
        Message messages[] = emailFolder.getMessages();
        int latestmessage = (messages.length-1);
        
        Message recentMessage = messages[latestmessage];
        
        recentMessage.writeTo(System.out);
        
        emailFolder.close(true);
        store.close();
    }
    public static void main(String args[]) throws MessagingException, IOException {
		
		//declaring all the function parameters 
		String host = "pop.gmail.com";
		String mailStoreType = "pop3";
		String username = "clgworks2024@gmail.com";
		String password = "ypfzqwjvowehdltr";
		displaymail(host,mailStoreType,username,password);
	}
    
}
