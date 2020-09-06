package rtu.klokov.labs.lab8;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter file name:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = new FileOutputStream("src/file/" +reader.readLine());
        System.out.println("To stop recording enter: CLOSE");
        while (true)
        {
            String data = reader.readLine();
            if(data.equals("CLOSE")){
                outputStream.write(data.getBytes());
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