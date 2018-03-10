package homeAcountant;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ShowBudget {

    public static void showBudget(JPanel panel, SavingFile saveBudget) throws IOException {
        FileReader readBudget = new FileReader(saveBudget);
        Scanner scanRead = new Scanner(readBudget);
        while (scanRead.hasNextLine()){
            System.out.println (scanRead.nextLine());
        }
        readBudget.close();
    }



}
