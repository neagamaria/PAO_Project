package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.BookMapper;
import ro.pao.model.products.Book;
import ro.pao.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookRepositoryImpl implements BookRepository {

    private static final BookMapper bookMapper = BookMapper.getInstance();

    @Override
    public Optional<Book> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM book WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return bookMapper.mapToBook(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM book WHERE itemid=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Book newBook) {
        String updateNameSql = "UPDATE book SET title=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Book book) {
        String insertSql = "INSERT INTO book (itemid, title) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, book.getItemId().toString());
            preparedStatement.setString(2, book.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() {
        String selectSql = "SELECT * FROM book";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return bookMapper.mapToBookList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Book> bookList) {
        bookList.forEach(this::addNewObject);
    }
}