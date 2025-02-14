package io.github.skshiydv.studyjam.controller;

import io.github.skshiydv.studyjam.dto.ListEntityDto;
import io.github.skshiydv.studyjam.services.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;
    @PostMapping("/create-list")
    public String createList(ListEntityDto listEntityDto) {
        listService.createList(listEntityDto);
        return "ok";
    }
}
