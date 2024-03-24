package lab13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class txt {
    private BufferedWriter writer;

    public txt(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeResult(String equationType, double a, double b, double c, String solution) {
        String result = equationType + ", " + a + ", " + b + ", " + c + ", " + solution;
        writeToFile(result);
    }

    private void writeToFile(String result) {
        try {
            writer.write(result);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}