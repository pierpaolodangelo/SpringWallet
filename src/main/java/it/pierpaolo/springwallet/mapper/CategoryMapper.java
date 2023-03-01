package it.pierpaolo.springwallet.mapper;

import it.pierpaolo.springwallet.dto.CategoryDTO;
import it.pierpaolo.springwallet.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);

    Category toEntity(CategoryDTO dto);
}
