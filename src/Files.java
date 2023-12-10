
import java.io.*;
import java.util.Arrays;

public class Files {

    public static void main(String[] args) throws IOException {
        FileInputStream fob = new FileInputStream("text.txt");
        BufferedInputStream bf = new BufferedInputStream(fob) ;
        StringBuilder str = new StringBuilder() ;
        for(byte i : bf.readAllBytes()){
            str.append((char)i);
        }
        String str1 = str.toString();
        StringBuilder str3 = new StringBuilder("hello") ;
        String[] words = str1.split(" ");
        String str2 = String.join("",words);
        System.out.println(Arrays.toString(words));
        System.out.println(str);
        BufferedOutputStream bfo = new BufferedOutputStream(new FileOutputStream("output.txt"));
        bfo.write(str2.getBytes());
        bfo.flush();
    }
}
