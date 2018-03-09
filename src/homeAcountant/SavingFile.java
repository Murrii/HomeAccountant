package homeAcountant;

import java.io.File;
import java.io.IOException;

public class SavingFile extends File {

    static String savePath = "C:\\HomeAccountant";

    public static String getPathname(String filename) {
        String pathname = savePath + "\\" + filename + ".txt";
        return pathname;
    }

    public static String getPathname(SavingFile savingFile){
        return savingFile.getAbsolutePath();
    }

    public SavingFile(String pathname) throws IOException {
        super(pathname);
        getParentFile().mkdir();
        createNewFile();
        System.out.println("создан файл сохранения" + pathname);
    }
}
