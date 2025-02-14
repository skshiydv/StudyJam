package io.github.skshiydv.studyjam.dto;

import io.github.skshiydv.studyjam.entities.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListEntityDto {
    private String title;
    private List<ItemEntity> items;
}
