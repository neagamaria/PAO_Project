package ro.pao.mapper;

import ro.pao.model.administration.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CompanyMapper {
    private static final CompanyMapper INSTANCE = new CompanyMapper();
    private CompanyMapper() {
    }

    public static CompanyMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Company> mapToCompany(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Company.builder()
                            .readerID(UUID.fromString(resultSet.getString(1)))
                            .link(resultSet.getString(2))
                            .numberReaders(resultSet.getInt(3))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Company> mapToCompanyList(ResultSet resultSet) throws SQLException {
        List<Company> CompanyList = new ArrayList<>();
        while (resultSet.next()) {
            CompanyList.add(
                    Company.builder()
                            .readerID(UUID.fromString(resultSet.getString(1)))
                            .link(resultSet.getString(2))
                            .numberReaders(resultSet.getInt(3))
                            .build()
            );
        }

        return CompanyList;
    }

}
