import java.util.*;
public class Lab3PAO {
    public static void main(String[] args){
        List<Aliment> alimente = new ArrayList<>();

        Cereale cereale1 = new Cereale(3052023, 9.70, "ovaz, zahar, ciocolata", "Nesquick");
        Carne carne1 = new Carne(5042023, 23.99, "carne de pui dezosata, condimente");
        Lapte lapte1 = new Lapte(23032023, 9.50, "lapte de vaca");
        Cereale cereale2 = new Cereale(2062023, 10.80, "orz, grau, zahar, fructe", "Muesli");
        alimente.add(cereale1);
        alimente.add(cereale2);
        alimente.add(lapte1);
        alimente.add(carne1);
        Collections.sort(alimente);
    }
}
