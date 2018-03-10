package homeAcountant;

public class Budget {

    int budget;
    String nameBudget;
    SavingFile savingFile;

    public Budget(int budget, String nameBudget, SavingFile savingFile) {
        this.budget = budget;
        this.nameBudget = nameBudget;
        this.savingFile = savingFile;
        System.out.println("Бюджет в месяце " + nameBudget +" составлет " + budget + " рублей. Информация сохраняется в " + savingFile);
    }

    public void getBudget(){
        System.out.println("Текущий бюджет " + nameBudget + " составляет " + budget + " рублей.");
    }

    public void setSavingFile(SavingFile savingFile){
        this.savingFile = savingFile;
    }


    public void setNameBudget(String nameBudget) {
        this.nameBudget = nameBudget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

}
