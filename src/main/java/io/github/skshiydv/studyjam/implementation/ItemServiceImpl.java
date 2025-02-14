package io.github.skshiydv.studyjam.implementation;

import io.github.skshiydv.studyjam.dto.ItemEntityDto;
import io.github.skshiydv.studyjam.entities.ItemEntity;
import io.github.skshiydv.studyjam.repositories.ItemRepository;
import io.github.skshiydv.studyjam.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public String addItem(ItemEntityDto item) {
        try {
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setTitle(item.getTitle());
            itemEntity.setList(item.getList());
            itemRepository.save(itemEntity);
            return "Item added successfully";
        } catch (Exception e) {
            return "error";
        }
    }

    @Override
    public String updateItem(ItemEntityDto item) {
        return "";
    }

    @Override
    public String deleteItem(int id) {
        return "";
    }
}
