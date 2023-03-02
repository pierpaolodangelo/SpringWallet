package it.pierpaolo.springwallet.service;

import it.pierpaolo.springwallet.dto.TransactionDTO;
import it.pierpaolo.springwallet.mapper.TransactionMapper;
import it.pierpaolo.springwallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public Optional<TransactionDTO> getTransaction(long id) {
        return transactionRepository.findById(id)
                .map(transactionMapper::toDTO);
    }

    public long createTransaction(TransactionDTO transactionDTO) {
        return transactionRepository.save(transactionMapper.toEntity(transactionDTO)).getId();
    }

    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }
}
