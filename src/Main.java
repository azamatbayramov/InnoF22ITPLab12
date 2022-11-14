import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task2();
    }

    public static void task2() {
        String inputFilename = getFilenameFromUserFor("input");
        String outputFilename = getFilenameFromUserFor("output");
        try (
                FileInputStream fileInputStream = new FileInputStream(inputFilename);
                FileOutputStream fileOutputStream = new FileOutputStream(outputFilename)
        ) {
            Scanner fileScanner = new Scanner(fileInputStream);
            try {
                if (!fileScanner.hasNextInt()) {
                    throw new Exception("There is no number");
                }
                int a = fileScanner.nextInt();
                if (!fileScanner.hasNextInt()) {
                    throw new Exception("There is no number");
                }
                int b = fileScanner.nextInt();
                if (b == 0) {
                    throw new Exception("Division by zero");
                }
                fileOutputStream.write(Integer.toString(a / b).getBytes()[0]);
            } catch (Exception e) {
                reportError(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            reportError(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void task1() {
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
        System.exit(0);
    }
}