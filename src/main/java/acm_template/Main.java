package acm_template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = "";
        // 读取一行
        s = br.readLine();
        // 一直读
        while ((s = br.readLine()) != null) {
            System.out.println(s.substring(s.lastIndexOf(" ") + 1).length());
        }
        cal();
    }

    public static void cal() {
        return;
    }
}

