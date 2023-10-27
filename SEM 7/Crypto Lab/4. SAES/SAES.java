import java.util.*;  
public class SAES {
    static HashMap<String, String> map = new HashMap<>();
    static HashMap<Integer, String> mixColMat = new HashMap<>();
    static HashMap<String, String> invSbox = new HashMap<>();

    
    public static String Rotate(String a){
        String ans=a.substring(4,8)+a.substring(0,4);
        return ans;
    }
    
    public static String SBOX(String a){
        String a1=a.substring(0,4);
        String a2=a.substring(4,8);
        map.put("0000", "1001");
        map.put("0001", "0100");
        map.put("0010", "1010");
        map.put("0011", "1011");
        map.put("0100", "1101");
        map.put("0101", "0001");
        map.put("0110", "1000");
        map.put("0111", "0101");
        map.put("1000", "0110");
        map.put("1001", "0010");
        map.put("1010", "0000");
        map.put("1011", "0011");
        map.put("1100", "1100");
        map.put("1101", "1110");
        map.put("1110", "1111");
        map.put("1111", "0111");
        String ans1=map.get(a1);
        String ans2=map.get(a2);
        
        return ans1+ans2;
        
    }
    public static String invSBOX(String a){
        String a1=a.substring(0,4);
        String a2=a.substring(4,8);
        invSbox.put( "1001","0000");
        invSbox.put("0100","0001");
        invSbox.put("1010","0010");
        invSbox.put("1011","0011");
        invSbox.put("1101","0100");
        invSbox.put("0001","0101");
        invSbox.put("1000","0110");
        invSbox.put("0101","0111");
        invSbox.put("0110","1000");
        invSbox.put( "0010","1001");
        invSbox.put("0000","1010");
        invSbox.put("0011","1011");
        invSbox.put("1100","1100");
        invSbox.put("1110","1101");
        invSbox.put("1111","1110");
        invSbox.put("0111","1111");
        String ans1=map.get(a1);
        String ans2=map.get(a2);
        
        return ans1+ans2;
        
    }

    public static String XOR(String a,String b){
        String ans="";
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(i)){
                ans=ans+'0';
            }
            else{
                ans=ans+'1';
            }
        }
        return ans;
    }

    public static String[] keyGeneration(String key){
        String[] keys=new String[3];
        String w0=key.substring(0,8);
        String w1=key.substring(8,16);
        keys[0]=w0+w1;
     
        String r1="10000000";
        String r2="00110000";
        
        String key1_steps=SBOX(Rotate(w1));
        String w2 = XOR(XOR(w0, r1), key1_steps);
        String w3= XOR(w2, w1);
        
        String key2_steps=SBOX(Rotate(w3));
        String w4=XOR(XOR(w2, r2), key2_steps);
        String w5=XOR(w4, w3);
        
        keys[1]=w2+w3;
        keys[2]=w4+w5;
        
        return keys;
    }
    public static String substitution(String a){
        String w1=a.substring(0,4);
        String w2=a.substring(4,8);
        String w3=a.substring(8,12);
        String w4=a.substring(12,16);


        String ans=map.get(w1)+map.get(w2)+map.get(w3)+map.get(w4);
        System.out.println("Substitution : "+ans);
        
        return ans;
    }
    public static String invsubstitution(String a){
        String w1=a.substring(0,4);
        String w2=a.substring(4,8);
        String w3=a.substring(8,12);
        String w4=a.substring(12,16);

        String ans=invSbox.get(w1)+invSbox.get(w2)+invSbox.get(w3)+invSbox.get(w4);

        System.out.println("Inv Substitution : "+ans);

        return ans;


    }
    public static String shiftRows(String a){
        String w1=a.substring(0,4);
        String w2=a.substring(4,8);
        String w3=a.substring(8,12);
        String w4=a.substring(12,16);
        String ans=w1+w4+w3+w2;

        System.out.println("Shift Rows : "+ans);
        return ans;
    }
    
    public static String Multiply(String a){
        String ans="0000";     
        for(int i=3;i>=0;i--){
            if(a.charAt(3-i)=='1'){
                ans  =XOR(ans,mixColMat.get(i+2));
            }
        }

        return ans;
    }
     public static String mixer_2(String a){
        String ans="0000";     
        for(int i=3;i>=0;i--){
            if(a.charAt(3-i)=='1'){
                ans  =XOR(ans,mixColMat.get(i+1));
            }
        }
        return ans;
    }
     public static String mixer_9(String a){
        String ans="0000";     
        
         for(int i=3;i>=0;i--){
            if(a.charAt(3-i)=='1'){
                ans  =XOR(ans,mixColMat.get(i));
                ans  =XOR(ans,mixColMat.get(i+3));
            }
        }

        return ans;
    }
    public static String mixColumns(String a){
        mixColMat.put(0, "0000");
        mixColMat.put(1, "0001");
        mixColMat.put(2, "0100");
        mixColMat.put(3, "1000");
        mixColMat.put(4, "0011");
        mixColMat.put(5, "0110");
        mixColMat.put(6, "1100");
        String w1=a.substring(0,4);
        String w2=a.substring(4,8);
        String w3=a.substring(8,12);
        String w4=a.substring(12,16);
        
        String ans1=XOR(w1,Multiply(w2));
        String ans2=XOR(Multiply(w1), w2);
        String ans3=XOR(w3,Multiply(w4));
        String ans4=XOR(Multiply(w3), w4);
        
        System.out.println("Mix Column : "+ans1+" "+ans2+" "+ans3+" "+ans4);
        return ans1+ans2+ans3+ans4;
    }
    public static String inv_mixColumns(String a){
        mixColMat.put(0, "0001");
        mixColMat.put(1, "0010");
        mixColMat.put(2, "0100");
        mixColMat.put(3, "1000");
        mixColMat.put(4, "0011");
        mixColMat.put(5, "0110");
        mixColMat.put(6, "1100");
        String w1=a.substring(0,4);
        String w2=a.substring(4,8);
        String w3=a.substring(8,12);
        String w4=a.substring(12,16);
        
        String ans1=XOR(mixer_9(w1),mixer_2(w2));
        String ans2=XOR(mixer_2(w1), mixer_9(w2));
        String ans3=XOR(mixer_9(w3),mixer_2(w4));
        String ans4=XOR(mixer_2(w3), mixer_9(w4));

        System.out.println("Inv Mix Column : "+ans1+" "+ans2+" "+ans3+" "+ans4);
        
        return ans1+ans2+ans3+ans4;
    }
    
    public static String round(String plaintext,String key){
        String val=substitution(plaintext);
        val=shiftRows(val);
        val=mixColumns(val);
        val=XOR(val, key);

        System.out.println("Round : "+val);
        return val;
    }
    public static String finalround(String plaintext,String key){
        String val=substitution(plaintext);
        val=shiftRows(val);
        val=XOR(val, key);

        System.out.println("Final Round : "+val);
        return val;
    }
    private static String roundDec(String text,String key){
        text=shiftRows(text);
        text=invsubstitution(text);
        text=XOR(text,key);
        text=inv_mixColumns(text);

        System.out.println("Round Dec : "+text);
        return text;
    }
    private static String finalroundDec(String text,String key){
        text=shiftRows(text);
        text=invsubstitution(text);
        text=XOR(text,key);

        System.out.println("Final Round Dec : "+text);
        return text;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Plaintext(16 bits): ");
        String plaintext=sc.next();
        System.out.println("Enter the Key(16 bits): ");
        String key=sc.next();
        String temp=invSBOX("11111111");
        
        String[] keys=keyGeneration(key);
        System.out.println("\nKEYS: ");
        int ct=0;
        for(String i:keys){
            System.out.println("key"+ct+": "+i);
            ct++;
        }
        
        //Pre Round TransformixColMation
        plaintext = XOR(plaintext, keys[0]);
        //round 1
        plaintext = round(plaintext, keys[1]);
        //FinalRound
        String ciphertext = finalround(plaintext,keys[2]);
        System.out.println("\nEncryption");
        System.out.println("Ciphertext: "+ciphertext);
        System.out.println("\nDecryption");
        ciphertext=XOR(ciphertext,keys[2]);
        ciphertext=roundDec(ciphertext,keys[1]);
        ciphertext=finalroundDec(ciphertext,keys[0]);
        System.out.println(ciphertext);
    }
}
