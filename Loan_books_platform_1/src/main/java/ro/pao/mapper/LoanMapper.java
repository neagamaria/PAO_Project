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


    public static Optional<Loan> mapToLoan(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Loan.builder()
                            .loanId(UUID.fromString(resultSet.getString(1)))
                            .readerID(UUID.fromString(resultSet.getString(2)))
                            .startDate(resultSet.getDate(3))
                            .returnDate(resultSet.getDate(4))
                            .extended(resultSet.getBoolean(5))
                            .numberItems(resultSet.getInt(6))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Loan> mapToLoanList(ResultSet resultSet) throws SQLException {
        List<Loan> loanList = new ArrayList<>();
        while (resultSet.next()) {
            loanList.add(
                    Loan.builder()
                            .loanId(UUID.fromString(resultSet.getString(1)))
                            .readerID(UUID.fromString(resultSet.getString(2)))
                            .startDate(resultSet.getDate(3))
                            .returnDate(resultSet.getDate(4))
                            .extended(resultSet.getBoolean(5))
                            .numberItems(resultSet.getInt(6))
                            .build()
            );
        }

        return loanList;
    }
}
