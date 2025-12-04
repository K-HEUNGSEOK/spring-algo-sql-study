package hello.file_practice.domain;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    private static Map<Long,Item> store = new HashMap<>();
    private static Long sequence = 0L;
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }
    public Item findById(Long itemId){
        return store.get(itemId);
    }
}
