package homeAcountant;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class ReactButtons {

   public static Budget initNewBuddget() throws IOException{
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


    public static void initDebet(Budget currentBugget){
        int summ = initSumm();
        String type = initType();
        currentBugget.budget += summ;
        String text = "Внесено " + summ + " рублей. Тип дохода: " + type + "; " + '\n';

        currentBugget.getBudget();
    }

    public static void initCredit(Budget currentBugget){
        int summ = initSumm();
        String type = initType();
        currentBugget.budget -= summ;
        String text = "Потрачено " + summ + " рублей. Тип расхода: " + type + "; " + '\n';
        System.out.println(text);

        currentBugget.getBudget();
    }

   //     FileWriter saveDebet = new FileWriter(savingFile, true);
    //    saveDebet.write(text);
    //    saveDebet.append('\n');
    //    saveDebet.flush();





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
