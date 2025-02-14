package io.github.skshiydv.studyjam.services;

import io.github.skshiydv.studyjam.dto.ItemEntityDto;

public interface ItemService {
    String addItem(ItemEntityDto item);

    String updateItem(ItemEntityDto item);

    String deleteItem(int id);
}
