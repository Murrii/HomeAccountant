import homeAcountant.Budget;
import homeAcountant.ReactButtons;
import homeAcountant.SavingFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

public class SimpleHomeAccountant {
    public static void main(String[] args) throws IOException {

        initFrame();
    }

    static void initFrame() throws IOException {

        Budget currentBugget = new Budget(0,null, null);

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
                try {
                    ReactButtons.initNewBuddget();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };

        newBugget.addActionListener(newBuggetListener);

        ActionListener newDebetListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReactButtons.initDebet(currentBugget);
            }
        };

        newDebet.addActionListener(newDebetListener);

        ActionListener newCreditListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReactButtons.initCredit(currentBugget);
            }
        };

        newCredit.addActionListener(newCreditListener);

        counterGUI.add(panel);
    }
}
