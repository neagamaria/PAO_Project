package ro.pao.repository;

import ro.pao.model.administration.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository {
    Optional<Company> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Company newObject);

    void addNewObject(Company company);

    List<Company> getAll();

    void addAllFromGivenList(List<Company> companyList);
}
