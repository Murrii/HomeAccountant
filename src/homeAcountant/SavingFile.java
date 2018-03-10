package homeAcountant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SavingFile extends File {

    private static File dir = new File("C:\\HomeAccountant");

    public static String getPathname(String filename) { ;
        String pathname = dir.toString() + "\\" + filename + ".txt";
        return pathname;
    }

    public static String getPathname(SavingFile savingFile){
        return savingFile.getAbsolutePath();
    }

    public SavingFile(String pathname) throws IOException {
        super(pathname);
        getParentFile().mkdir();
        createNewFile();
        System.out.println("создан файл сохранения " + pathname);
        showAllBudgets(dir);
    }

    public static void showAllBudgets(File dir) {
        File[] allBudgets = dir.listFiles();
        List<File> budgetList = Arrays.asList(allBudgets);
        System.out.println("Все доступные бюджеты: " + budgetList);
    }
}
