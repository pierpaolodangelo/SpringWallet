package it.pierpaolo.springwallet.controller;

import it.pierpaolo.springwallet.dto.CategoryDTO;
import it.pierpaolo.springwallet.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "{id}")
    public CategoryDTO getCategory(@PathVariable long id) {
        return categoryService.getCategory(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public long createCategory(@RequestBody CategoryDTO dto) {
        return categoryService.createCategory(dto);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }
}
