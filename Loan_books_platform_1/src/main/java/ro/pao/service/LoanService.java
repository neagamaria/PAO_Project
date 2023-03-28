package ro.pao.service;

import ro.pao.model.administration.Loan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface LoanService
{
    Optional<Loan> getLoanById(UUID id);
    Optional<Loan> getBySomeFieldOfClass(Object someFieldFromExampleClass);
    List<Loan> getAllLoans();
    void addAllLoans(List<Loan> loanList);
    void addOneLoan(Loan loan);
    //void removeItemById(UUID id);
    //void addOneItem(Item item);
    //void addAllItems(List<Item> items);
    void removeLoanById(UUID id);
    void modifyLoanById(UUID id, Loan newLoan);
    //void assignToReader(Reader reader);

}
