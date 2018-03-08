package homeAcountant;

public class Costs implements Type{

    String costsNametype;

    public Costs(String costsNameType) {
        this.costsNametype = costsNameType;
    }

    @Override
    public String getType() {
        return costsNametype;
    }
}
