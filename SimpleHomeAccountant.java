import homeAcountant.Budget;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleHomeAccountant {
    public static void main(String[] args) {

        initFrame();
    }

    static void initFrame(){

        Budget currentBugget = new Budget(0, null);

        JFrame counterGUI = new JFrame();
        counterGUI.setVisible(true);
        counterGUI.setSize(500, 500);
        counterGUI.setLocationRelativeTo(null);
        counterGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton newBugget = new JButton("Новый бюджет");
        JButton newDebet = new JButton("Приход");
        JButton newCredit = new JButton("Расход");

        panel.add(newBugget);
        panel.add(newDebet);
        panel.add(newCredit);

        ActionListener newBuggetListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String textBugget = JOptionPane.showInputDialog("Введите стартовый бюджет");
                String currentMonth = JOptionPane.showInputDialog("Введите текущий месяц");
                currentBugget.setBudget(Integer.parseInt(textBugget));
                currentBugget.setMonth(currentMonth);
                currentBugget.getBudget();
            }
        };

        newBugget.addActionListener(newBuggetListener);

        ActionListener newDebetListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textDebet = JOptionPane.showInputDialog("Введите сумму дохода в рублях");
                currentBugget.debet(Integer.parseInt(textDebet));
                currentBugget.getBudget();
            }
        };

        newDebet.addActionListener(newDebetListener);

        ActionListener newCreditListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textCredit = JOptionPane.showInputDialog("Введити сумму расходов");
                currentBugget.credit(Integer.parseInt(textCredit));
                currentBugget.getBudget();
            }
        };

        newCredit.addActionListener(newCreditListener);

        counterGUI.add(panel);
    }



}
