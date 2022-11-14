import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String inputFilename = getFilenameFromUserFor("input");
        String outputFilename = getFilenameFromUserFor("output");
        try (
                FileInputStream fileInputStream = new FileInputStream(inputFilename);
                FileOutputStream fileOutputStream = new FileOutputStream(outputFilename)
        ) {
            while (fileInputStream.available() > 0) {
                fileOutputStream.write(fileInputStream.read());
            }

        } catch (FileNotFoundException | SecurityException exception) {
            reportError(exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFilenameFromUserFor(String forWhat) {
        String filename;
        System.out.print("Write filename for " + forWhat + ": ");
        filename = scanner.nextLine();
        return filename;
    }

    public static void reportError(String err) {
        System.out.println("ERROR:" + err);
    }
}