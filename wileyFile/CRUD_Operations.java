package FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CRUD_Operations {
    public static void main(String[] args) throws IOException, InterruptedException {
        File one = new File("src/FileHandling/one.txt");
        one.createNewFile();
        File two = new File("src/FileHandling/two.txt");
        two.createNewFile();

        Files.write(Paths.get(one.getAbsolutePath()), "Name:Abhishek Sharma\nDOb:22.09.1999\n".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        FileWriter fileWritertwo = new FileWriter(two.getAbsoluteFile(), true);

        Scanner s = new Scanner(one);

        while (s.hasNextLine()) {

            Files.write(Paths.get(two.getAbsolutePath()), (s.nextLine()+"\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
//        FileReader fileReaderOne = new FileReader(one.getAbsolutePath());
//        int i = 0;
//        while ((i = fileReaderOne.read()) != -1) {
//            Files.write(Paths.get(two.getAbsolutePath()), ((char)i).getBytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//        }
        FileReader fileReaderTwo = new FileReader(two.getAbsolutePath());
        int i = 0;
        while ((i = fileReaderTwo.read()) != -1) {
            System.out.print((char) i);
        }
        fileReaderTwo.close();
        fileWritertwo.close();
        s.close();
        //close fileReaderOne if exists
        Files.deleteIfExists(Paths.get(two.getAbsolutePath()));
    }
}
