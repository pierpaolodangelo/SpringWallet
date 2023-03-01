package it.pierpaolo.springwallet.service;

import it.pierpaolo.springwallet.dto.CategoryDTO;
import it.pierpaolo.springwallet.mapper.CategoryMapper;
import it.pierpaolo.springwallet.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Optional<CategoryDTO> getCategory(long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO);
    }

    public long createCategory(CategoryDTO dto) {
        return categoryRepository.save(categoryMapper.toEntity(dto)).getId();
    }

    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }
}
