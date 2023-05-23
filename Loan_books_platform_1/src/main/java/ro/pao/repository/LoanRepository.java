package ro.pao.repository;

import ro.pao.model.administration.Loan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoanRepository {
    Optional<Loan> getObjectById(UUID id);
    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Loan newLoan);

    void addNewObject(Loan loan);

    List<Loan> getAll();

    void addAllFromGivenList(List<Loan> loan);
}
