package io.github.skshiydv.studyjam.implementation;
import io.github.skshiydv.studyjam.dto.ListEntityDto;
import io.github.skshiydv.studyjam.entities.ListEntity;
import io.github.skshiydv.studyjam.repositories.ListRepository;
import io.github.skshiydv.studyjam.services.ListService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService {
    private final ListRepository listRepository;
    @Override
    public String createList(ListEntityDto listEntity) {
        try{
            ListEntity newEntity = new ListEntity();
            newEntity.setTitle(listEntity.getTitle());
            newEntity.setListItems(listEntity.getItems());
            listRepository.save(newEntity);
            return "List created";
        }catch(Exception e){
            return "Error creating list";
        }
    }

    @Override
    public List<ListEntity> getAllLists() {
        return List.of();
    }
}
