package homeAcountant;

public class Gain implements Type {

    String gainNameType;
    
    public Gain(String gainNameType) {
        this.gainNameType = gainNameType;
    }

    @Override
    public String getType() {
        return gainNameType;
    }
}
