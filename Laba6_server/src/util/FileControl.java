package util;

import java.io.*;
import java.util.SortedMap;

/**
 * performs work with file
 */
public class FileControl {

    public String st = "";

    /**
     * read file
     * @param s file address
     * @throws FileNotFoundException if file not found
     */
    public void readln(String s) throws FileNotFoundException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(s))) {
            int ch = bufferedInputStream.read();
            while (ch != -1) {
                st = st + (char) ch;
                ch = bufferedInputStream.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл для чтения не найден");
            throw new FileNotFoundException();
        } catch (IOException e) {
            System.out.println("кринж");
        }
        st = st.replaceAll("\n", ",");
    }

    /**
     * write in file
     * @param address file address
     * @param s collection in string type
     */
    public void writeln(String address, String s) {
        try {
            PrintWriter writer = new PrintWriter(address);
            writer.write(s);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл для записи не найден");
        }
    }

}
