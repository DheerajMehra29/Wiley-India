package Aug_25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileTask {
    static final String[] methods = new String[] { "File_io", "buffer", "nio" };

    public static void main(String[] args) {
        CRUD obj = new CRUD();
        try {
            File f1 = obj.createFile("Aug_25/f1.txt");
            File f2 = obj.createFile("Aug_25/f2.txt");
            obj.appendFile(f1, "Hi, I am a file.\nI am of type txt.", methods[1]);
            obj.copyData(f1, f2, methods[1]);
            obj.readFile(f2, methods[1]);
            // obj.deleteFile(f2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CRUD {
    File createFile(String name) throws IOException {
        File file = new File(name);
        if (!file.createNewFile()) {
            System.out.println("File already created");
        }
        return file;
    }

    void appendFile(File file, String textToBeAdded, String method) throws IOException {
        switch (method) {
            case "File_io":
                try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), true);) {
                    fileWriter.write(textToBeAdded);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "buffer":
                try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(file.getAbsolutePath(), true));) {
                    bufferedWriter.write(textToBeAdded);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "nio":
                textToBeAdded = textToBeAdded + System.getProperty("line.separator");
                Files.write(Paths.get(file.getAbsolutePath()), textToBeAdded.getBytes(), StandardOpenOption.APPEND);
                break;
        }
    }

    void readFile(File file, String method) {
        switch (method) {
            case "File_io":
                try (FileReader fileReader = new FileReader(file.getAbsolutePath());) {
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "buffer":
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null)
                        System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "nio":
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));) {
                    String line;
                    while ((line = reader.readLine()) != null)
                        System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    void copyData(File f1, File f2, String method) {
        switch (method) {
            case "File_io":
                try (FileReader fileReader = new FileReader(f1.getAbsolutePath());) {
                    int i;
                    while ((i = fileReader.read()) != -1)
                        appendFile(f2, String.valueOf((char) i), method);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "buffer":
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null)
                        appendFile(f2, line, method);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "nio":
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(f1.getAbsolutePath()));) {
                    String line;
                    while ((line = reader.readLine()) != null)
                        appendFile(f2, line, method);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    void deleteFile(File file) throws IOException {
        Files.deleteIfExists(Paths.get(file.getAbsolutePath()));
    }
}
