package ro.pao.mapper;

import ro.pao.model.administration.Loan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoanMapper {
    private static final LoanMapper INSTANCE = new LoanMapper();

    private LoanMapper() {
    }

    public static LoanMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Loan> mapToLoan(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Loan.builder()
                            .loanId(UUID.fromString(resultSet.getString(1)))
                            .publishing(resultSet.getString(2))
                            .category(LoanCategory.valueOf(resultSet.getString(3)).getTypeString())
                            .publishingYear(resultSet.getInt(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Loan> mapToLoanList(ResultSet resultSet) throws SQLException {
        List<Loan> LoanList = new ArrayList<>();
        while (resultSet.next()) {
            LoanList.add(
                    Loan.builder()
                            .itemId(UUID.fromString(resultSet.getString(1)))
                            .publishing(resultSet.getString(2))
                            .category(LoanCategory.valueOf(resultSet.getString(3)).getTypeString())
                            .publishingYear(resultSet.getInt(4))
                            .build()
            );
        }

        return LoanList;
    }
}
