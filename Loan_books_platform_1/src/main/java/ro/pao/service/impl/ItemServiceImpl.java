package ro.pao.service.impl;
import model.abstracts.Item;
import ro.pao.service.ItemService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService
{
    private static List<Item> itemList = new ArrayList<>();
    @Override
    public Optional<Item> getItemById(UUID id)
    {
        return itemList.stream().filter(obj -> id.equals(obj.getItemId())).findAny();
    }
    @Override
    public List getAllItems(List<Item> itemList)
    {
        return itemList;
    }
    @Override
    public void addOneItem(Item item)
    {
        itemList.add(item);
    }
    @Override
    public void addAllItems(List<Item> itemList)
    {
        ItemServiceImpl.itemList.addAll(itemList);
    }
    @Override
    public void removeItemById(UUID id)
    {
        itemList = itemList.stream().filter(element -> !id.equals(element.getItemId()))
                .collect(Collectors.toList());
    }
    @Override
    public void modifyItemById(UUID id, Item newItem)
    {
        removeItemById(id);
        addOneItem(newItem);
    }
}
