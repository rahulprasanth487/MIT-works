import java.io.*;
import java.util.*;

public class shiftCipher {
    public static String encrypt(String text, int s) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch))
            {
                if (Character.isUpperCase(ch)) {
                ch = (char) (((int) ch + s - 65) % 26 + 65);
                } else {
                    ch = (char) (((int) ch + s - 97) % 26 + 97);
                }
                encryptedText.append(ch);
            }
            else{
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    public static String Decryption(String s,int shift){
        String ans="";
        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c)){
                int t1=(c-'A'-shift)%26;
                char t2=(char)(t1+'A');
                ans+=t2;
            }
            else if(Character.isLowerCase(c)){
                int t1=(c-'a'-shift)%26;
                char t2=(char)(t1+'a');
                ans+=t2;
            }
            else return("");
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the plain text = ");
        String plain=inp.nextLine();
        System.out.print("Enter the cipher text = ");
        String cip=inp.nextLine();

        for(int i=0;i<26;i++){
            String ans=Decryption(cip,i);
            if(ans.equals(plain))
            {
                System.out.println("Plain text = "+plain);
                System.out.println("Cipher text = "+cip);
                System.out.println("Key = "+i);
                break;
            }
        }
    }
}
