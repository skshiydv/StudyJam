package io.github.skshiydv.studyjam.services;

import io.github.skshiydv.studyjam.dto.ListEntityDto;
import io.github.skshiydv.studyjam.entities.ListEntity;

import java.util.List;

public interface ListService {
    String createList(ListEntityDto listEntity);
    List<ListEntity> getAllLists();
}
