package other.hello;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = " ";
        while((s=br.readLine()) != null){
            System.out.println(s.substring(s.lastIndexOf(" ")+1).length());
        }
    }
}