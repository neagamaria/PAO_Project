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
    public Optional<List<Book>> getObjectByCategory(String category) {
        String selectSql = "SELECT * FROM book WHERE category=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, category.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(bookMapper.mapToBookList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<List<Book>> getObjectByTitle(String title) {
        String selectSql = "SELECT * FROM book WHERE title=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, title.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(bookMapper.mapToBookList(resultSet));
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
        String insertSql = "INSERT INTO book (itemid, title, publishing, publishingYear, category) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, book.getItemId().toString());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getPublishing());
            preparedStatement.setInt(4, book.getPublishingYear());
            preparedStatement.setString(5, book.getCategory());
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
