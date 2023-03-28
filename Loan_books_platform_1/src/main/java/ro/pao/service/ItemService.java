package ro.pao.service;
import ro.pao.model.abstracts.Item;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface ItemService
{
    Optional<Item> getItemById(UUID id);
    List getAllItems(List<Item> itemList);
    void addOneItem(Item item);
    void addAllItems(List<Item> itemList);
    void removeItemById(UUID id);
    void modifyItemById(UUID id, Item newItem);
}
