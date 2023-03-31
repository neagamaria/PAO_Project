package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.pao.model.administration.Loan;
import ro.pao.service.LoanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class LoanServiceImpl implements LoanService
{
    private static List<Loan> loanList = new ArrayList<>();

    @Override
    public Optional<Loan> getById(UUID id)
    {
        return loanList.stream().filter(obj -> id.equals(obj.getLoanId())).findAny();
    }

    @Override
    public Optional<Loan> getBySomeFieldOfClass(Object someFieldFromExampleClass)
    {
        return Optional.empty();
    }

    @Override
    public List<Loan> getAll()
    {
        return loanList;
    }

    @Override
    public void addAll(List<Loan> loanList)
    {
        LoanServiceImpl.loanList.addAll(loanList);
    }

    @Override
    public void addOne(Loan loan)
    {
        loanList.add(loan);
    }

    @Override
    public void removeById(UUID id)
    {
        loanList = loanList.stream().filter(element -> !id.equals(element.getLoanId())).collect(Collectors.toList());
    }

    @Override
    public void modifyById(UUID id, Loan newLoan)
    {
        removeById(id);
        addOne(newLoan);
    }
}
