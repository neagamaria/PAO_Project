package model.administration;
import java.util.ArrayList;
import model.abstracts.Item;

public class Loan extends ArrayList
{
    private int loanId;
    private int readerID;
    private final String start_date;
    private String return_date;
    private boolean extended = false; //if the loan is extended for another 2 weeks or not
    static int count = 0;
    private int number_items = 0;
    private ArrayList<Item> items_list;

    public Loan(int readerId, String start_date, String return_date, boolean extended)
    {
        items_list = new ArrayList<Item>();
        this.loanId = ++count;
        this.readerID = readerID;
        this.start_date = start_date;
        this.return_date =return_date;
        this.extended = extended;
    }

    public ArrayList<Item> getItems_list() {
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
