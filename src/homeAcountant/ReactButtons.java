package homeAcountant;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class ReactButtons {

   public static Budget initNewBuddget(Budget currentBugget, SavingFile saveBudget) throws IOException{
       String name = initName("ведите название для нового бюджета");
       int summ = initSumm();
       String pathname = SavingFile.getPathname(name);

       SavingFile savingFile = new SavingFile(pathname);
       Budget currentBudget = new Budget(summ, name, savingFile);
       currentBudget.getBudget();
       return currentBudget;
   }

   public static Budget setBudget(Budget budget){
       return budget;
   }

   public static void initNewStartSumm(Budget currentBudget, SavingFile saveBudget) throws IOException {
       int startSumm = initSumm();
       currentBudget.setBudget(startSumm);
       String text = "%" + startSumm + "%" + '\n' + '\r';
       saving(text, saveBudget);
       System.out.println("Установлена стартовая сумма " + startSumm);
   }

    public static void initDebet(Budget currentBugget, SavingFile saveBudget) throws IOException {
        int summ = initSumm();
        String type = initType();
        currentBugget.budget += summ;
        String text = "$" + summ + "$" + "&" + type + "&" + '\n' + '\r';
        System.out.println("Внесено" + summ + " рублей. Тип дохода: " + type + "; ");
        saving(text, saveBudget);
        currentBugget.getBudget();
    }

    public static void initCredit(Budget currentBugget, SavingFile saveBudget) throws IOException {
        int summ = initSumm();
        String type = initType();
        currentBugget.budget -= summ;
        String text = "$" + "-" + summ + "$" + "&" + type + "&" + '\n' + '\r';
        System.out.println("Потрачено \" + summ + \" рублей. Тип расхода: \" + type + \"; \"");
        saving(text, saveBudget);
        currentBugget.getBudget();
    }

    public static void saving(String text, SavingFile savingFile) throws IOException {
        FileWriter saveDebet = new FileWriter(savingFile, true);
        saveDebet.write(text);
        saveDebet.flush();
        saveDebet.close();
        System.out.println("данные сохранены");
    }

    public static int initSumm() {
        String textSumm = JOptionPane.showInputDialog("Введите сумму в рублях");
        int newSumm = Integer.parseInt(textSumm);
        System.out.println("принята сумма: " + newSumm);
        return newSumm;
    }

    public static String initType() {
        String type = JOptionPane.showInputDialog("Введите тип операции");
        System.out.println("Принят тип: " + type);
        return type;
    }

    public static String initName(String name) {
        String type = JOptionPane.showInputDialog(name);
        System.out.println("Принято: " + name);
        return type;
    }
}
