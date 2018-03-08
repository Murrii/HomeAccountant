package homeAcountant;

public class CurrentGain extends Gain {

    int summ;

    public CurrentGain(String gainNameType, int summ) {
        super(gainNameType);
        this.summ = summ;
    }
}
