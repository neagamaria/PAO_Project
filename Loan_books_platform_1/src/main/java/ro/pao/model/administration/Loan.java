package ro.pao.model.administration;

import lombok.*;
import ro.pao.model.abstracts.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Loan extends ArrayList {
    private UUID loanId;
    private UUID readerID;
    private Date startDate;
    private Date returnDate;
    private boolean extended = false; //if the loan is extended for another 2 weeks or not
    private int numberItems = 0;
    private ArrayList<Item> itemsList;

    public void setitemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
        this.numberItems = itemsList.size();
    }
    public void addItemsList(Item item) {
        this.itemsList.add(item);
        this.numberItems++;
    }
    public void removeitemsList(Item item) {
        this.itemsList.remove(item);
        this.numberItems--;
    }

    public void extendLoan() {
        if(this.extended == true)
          returnDate = new Date(returnDate.getTime()+ 86400000 * 30); //86 400 000 ms = 1 Day  : 24*60*60*1000
    }
}
