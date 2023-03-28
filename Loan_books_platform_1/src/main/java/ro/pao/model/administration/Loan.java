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
public class Loan extends ArrayList
{
    private UUID loanId;
    private UUID readerID;
    private Date start_date;
    private Date return_date;
    private boolean extended = false; //if the loan is extended for another 2 weeks or not
    private int number_items = 0;
    private ArrayList<Item> items_list;

    public UUID getLoanId()
    {
        return loanId;
    }

    public ArrayList<Item> getItems_list()
    {
        return items_list;
    }

    public void setItems_list(ArrayList<Item> items_list)
    {
        this.items_list = items_list;
        this.number_items = items_list.size();
    }
    public void addItems_List(Item item)
    {
        this.items_list.add(item);
        this.number_items++;
    }
    public void removeItems_List(Item item)
    {
        this.items_list.remove(item);
        this.number_items--;
    }
}
