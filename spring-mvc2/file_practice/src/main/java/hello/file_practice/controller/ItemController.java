package hello.file_practice.controller;

import hello.file_practice.domain.Item;
import hello.file_practice.domain.ItemRepository;
import hello.file_practice.domain.UploadFile;
import hello.file_practice.service.FileStore;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final FileStore fileStore ;
    @GetMapping("/items/new")
    public String newForm(@ModelAttribute ItemForm itemForm){
        return "item-form";
    }
    @PostMapping("/items/new")
    public String save(@ModelAttribute ItemForm itemForm, RedirectAttributes redirectAttributes){
        UploadFile uploadFile = fileStore.storeFile(itemForm.getAttachFile());
        List<UploadFile> uploadFiles = fileStore.storeFiles(itemForm.getImageFiles());
        Item item = new Item();
        item.setItemName(itemForm.getItemName());
        item.setAttachFile(uploadFile);
        item.setImageFiles(uploadFiles);

        itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", item.getId());
        return "redirect:/item/{itemId}";
    }
}
