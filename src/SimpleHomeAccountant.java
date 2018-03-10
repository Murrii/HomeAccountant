import homeAcountant.Budget;
import homeAcountant.ReactButtons;
import homeAcountant.SavingFile;
import homeAcountant.ShowBudget;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SimpleHomeAccountant {
    public static void main(String[] args) throws IOException {

        initFrame();
    }

    static void initFrame() throws IOException {

        String name = ReactButtons.initName("Задайте имя бюджета");
        int startSumm = 0;
        String pathname = SavingFile.getPathname(name);
        SavingFile saveBudget = new SavingFile(pathname);
        Budget currentBugget = new Budget(startSumm,name, saveBudget);

        JFrame counterGUI = new JFrame();
        counterGUI.setVisible(true);
        counterGUI.setSize(500, 500);
        counterGUI.setLocationRelativeTo(null);
        counterGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton newStartSumm = new JButton("Введите стартовую сумму");
        JButton newDebet = new JButton("Приход");
        JButton newCredit = new JButton("Расход");

        panel.add(newStartSumm);
        panel.add(newDebet);
        panel.add(newCredit);

        ActionListener newStartSummListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReactButtons.initNewStartSumm(currentBugget, saveBudget);
                    ShowBudget.showBudget(panel, saveBudget);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };

        newStartSumm.addActionListener(newStartSummListener);

        ActionListener newDebetListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReactButtons.initDebet(currentBugget, saveBudget);
                    ShowBudget.showBudget(panel, saveBudget);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };

        newDebet.addActionListener(newDebetListener);

        ActionListener newCreditListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReactButtons.initCredit(currentBugget, saveBudget);
                    ShowBudget.showBudget(panel, saveBudget);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
        newCredit.addActionListener(newCreditListener);

        counterGUI.add(panel);
    }
}
