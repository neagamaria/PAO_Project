package ro.pao.service.impl;
import model.administration.Loan;
import model.abstracts.Item;
import model.abstracts.Reader;
import ro.pao.service.LoanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class LoanServiceImpl implements LoanService
{
    private static List<Loan> loanList = new ArrayList<>();

    @Override
    public Optional<Loan> getLoanById(UUID id)
    {
        return loanList.stream().filter(obj -> id.equals(obj.getLoanId())).findAny();
    }

    @Override
    public Optional<Loan> getBySomeFieldOfClass(Object someFieldFromExampleClass)
    {
        return Optional.empty();
    }

    @Override
    public List<Loan> getAllLoans()
    {
        return loanList;
    }

    @Override
    public void addAllLoans(List<Loan> loanList)
    {
        LoanServiceImpl.loanList.addAll(loanList);
    }

    @Override
    public void addOneLoan(Loan loan)
    {
        loanList.add(loan);
    }

    @Override
    public void removeLoanById(UUID id)
    {
        loanList = loanList.stream().filter(element -> !id.equals(element.getLoanId())).collect(Collectors.toList());
    }

    @Override
    public void modifyLoanById(UUID id, Loan newLoan)
    {
        removeLoanById(id);
        addOneLoan(newLoan);
    }
}
