package rtu.klokov.labs.lab8;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter file name:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = new FileOutputStream("src/rtu/klokov/labs/lab8/" + reader.readLine() + ".txt");
        System.out.println("To stop recording enter: CLOSE");
        while (true)
        {
            String data = reader.readLine();
            if(data.equals("CLOSE")){
                break;
            }
            else {
                outputStream.write((data +"\r\n").getBytes());
            }
        }
        outputStream.close();
        reader.close();
    }
}