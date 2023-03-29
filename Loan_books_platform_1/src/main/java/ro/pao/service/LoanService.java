package ro.pao.service;

import ro.pao.model.administration.Loan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface LoanService
{
    Optional<Loan> getById(UUID id);
    Optional<Loan> getBySomeFieldOfClass(Object someFieldFromExampleClass);
    List<Loan> getAll();
    void addAll(List<Loan> loanList);
    void addOne(Loan loan);
    void removeById(UUID id);
    void modifyById(UUID id, Loan newLoan);
    //void assignToReader(Reader reader);

}
