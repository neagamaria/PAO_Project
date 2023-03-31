package ro.pao.service;

import ro.pao.model.abstracts.Reader;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReaderService
{
    Optional<Reader> getById(UUID id);
    Optional<Reader> getByName(String name);
    List<Reader> getAll();
    void addAll(List<Reader> readerList);
    void addOne(Reader reader);
    void removeById(UUID id);
    void modifyById(UUID id, Reader newReader);
}
