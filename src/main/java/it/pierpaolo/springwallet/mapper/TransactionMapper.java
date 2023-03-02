package it.pierpaolo.springwallet.mapper;

import it.pierpaolo.springwallet.dto.TransactionDTO;
import it.pierpaolo.springwallet.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDTO toDTO(Transaction transaction);

    Transaction toEntity(TransactionDTO dto);
}
