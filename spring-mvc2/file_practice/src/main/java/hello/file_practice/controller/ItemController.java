package hello.file_practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@Slf4j
public class ItemController {

    @GetMapping("items/new")
    public String newForm(@ModelAttribute ItemForm itemForm){
        return "item-form";
    }
}
