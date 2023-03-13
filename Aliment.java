public class Aliment implements Comparable<Aliment>{
    public long dataExpirare;
    public double pret;
    public double calorii;
    public String ingrediente;

    public Aliment(){

    }
    public Aliment(long d, double p, String i, double c){
        this.dataExpirare = d;
        this.ingrediente = i;
        this.pret = p;
        this.calorii = c;
    }

    public double getCalorii(){
        return this.calorii;
    }

    @Override
    public int compareTo(Aliment a) {
        if(getCalorii() < a.getCalorii())
            return 1;
        return 0;
    }
}
