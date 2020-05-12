import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        IntegerStringConverter a = new IntegerStringConverter();
        try {
            System.out.println(a.fromString("ini sebuah string"));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    public int test() throws IOException{
        int a = 0;
        Scanner input = new Scanner(System.in);
        try{
            a = input.nextInt();
            throw new IOException("Lagi sibuk");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }
}
