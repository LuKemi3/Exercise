package exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class mainprocess {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java","D:\\A_study\\java\\process_exercise\\src\\exercise1\\subprocess.java");
        Process process = pb.start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ( (line = br.readLine()) != null)
            System.out.println(line);
        br.close();
    }
}
