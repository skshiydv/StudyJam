package io.github.skshiydv.studyjam.dto;

import io.github.skshiydv.studyjam.entities.ListEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntityDto {
    private String title;
    private boolean completed;
    private ListEntity list;
}
