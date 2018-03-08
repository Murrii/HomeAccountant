package homeAcountant;

public class Budget {
    int budget;
    String month;

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Budget(int budget, String month){
        this.budget = budget;
        this.month = month;
        System.out.println("Бюджет в месяце " + month +" составлет " + budget + " рублей.");
    }

    public void debet (String gainNameType, int summ){
        CurrentGain currentGain = new CurrentGain(gainNameType, summ);
        budget += currentGain.summ;
        System.out.println("Внесено " + currentGain.summ + " рублей. Тип дохода: " + currentGain.gainNameType);
    }

    public void credit (int credit) {
        budget -= credit;
        System.out.println("Потрачено " + credit + " рублей.");
    }
    public void getBudget(){
        System.out.println("Текущий бюджет в месяце " + month + " составляет " + budget + " рублей.");
    }
}
