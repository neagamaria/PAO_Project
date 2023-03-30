package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.abstracts.Reader;
import ro.pao.service.ReaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class ReaderServiceImpl implements ReaderService
{
    private static List<Reader> readerList = new ArrayList<>();
    @Override
    public Optional<Reader> getById(UUID id)
    {
        return readerList.stream().filter(obj -> id.equals(obj.getReaderID())).findAny();
    }
    @Override
    public Optional<Reader> getBySomeFieldOfClass(Object someFieldFromClass)
    {
        return Optional.empty();
    }
    @Override
    public List<Reader> getAll()
    {
        return readerList;
    }
    @Override
    public void addAll(List<Reader> readerList)
    {
        ReaderServiceImpl.readerList.addAll(readerList);
    }
    @Override
    public void addOne(Reader reader)
    {
        readerList.add(reader);
    }

    @Override
    public void removeById(UUID id)
    {
        readerList = readerList.stream().filter(element -> !id.equals(element.getReaderID())).collect(Collectors.toList());
    }

    @Override
    public void modifyById(UUID id, Reader newReader)
    {
        removeById(id);
        addOne(newReader);
    }

}
