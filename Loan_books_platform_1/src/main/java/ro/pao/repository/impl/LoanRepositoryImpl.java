package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.LoanMapper;
import ro.pao.model.administration.Loan;
import ro.pao.repository.LoanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoanRepositoryImpl implements LoanRepository {
    private static final LoanMapper loanMapper = LoanMapper.getInstance();

    @Override
    public Optional<Loan> getObjectById(UUID loanId, UUID readerId) {
        String selectSql = "SELECT * FROM Loan WHERE loanId=? AND readerId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, loanId.toString());
            preparedStatement.setString(2, readerId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            return LoanMapper.mapToLoan(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID loanId, UUID readerId) {
        String updateNameSql = "DELETE FROM loan WHERE loanId=? AND readerId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, loanId.toString());
            preparedStatement.setString(2, readerId.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateObjectById(UUID loanId, UUID readerId, Loan newLoan) {
        String updateNameSql = "UPDATE loan SET startDate=? WHERE loanId=? AND readerId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
                java.util.Date utilDate = newLoan.getStartDate();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                preparedStatement.setDate(1, sqlDate);
                preparedStatement.setString(2, loanId.toString());
                preparedStatement.setString(3, readerId.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Loan loan) {
        String insertSql = "INSERT INTO loan (loanId, readerId, startDate) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
             preparedStatement.setString(1, loan.getLoanId().toString());
             preparedStatement.setString(1, loan.getReaderID().toString());
             java.util.Date utilDate = loan.getStartDate();
             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             preparedStatement.setDate(2, sqlDate);
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Loan> getAll() {
        String selectSql = "SELECT * FROM loan";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return loanMapper.mapToLoanList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Loan> loanList) {
        loanList.forEach(this::addNewObject);
    }

}
