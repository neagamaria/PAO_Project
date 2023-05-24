package ro.pao.service;

import org.junit.jupiter.api.Test;
import ro.pao.model.products.Book;
import ro.pao.repository.BookRepository;
import ro.pao.repository.impl.BookRepositoryImpl;
import ro.pao.service.impl.BookServiceImpl;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Metodele de test ale serviciului 'BookService'
 *
 * In functie de cate metode serviciu aveti, puteti face mai multe clase de test pe baza a ce clase serviciu aveti.
 *
 * Motivul pentru care exista teste este pentru a vedea daca functionalitatea 'pe bucati' functioneaza cum trebuie.
 *
 * Aceste teste se cheama 'unitare' pentru ca se testeaza 'per unitate'
 */
class BookServiceTest {


    /**
     * Dupa cum puteti vedea, metoda are 'o conventie'
     * Puteti lasa comentarii aici, cum am facut eu, despre ce face metoda
     *
     * Insa, in practica, se foloseste urmatoarea structura de definire a unei metode test:
     *
     * 'when{Descriere}_then{Descriere}
     */
    @Test
    void whenGivenBook_thenElementIsAdd() {
        // given
        // pasul in care efectuam operatiile

        Book book = Book.builder()
                .itemId(UUID.randomUUID())
                .build();
        BookRepository bookRepository = mock(BookRepositoryImpl.class);

        // when
        when(bookRepository.getObjectById(any())).thenReturn(Optional.of(book));

        //mockBookMapper(resultSet);

        // then
        // pasul in care testam comportamentul dupa apelarea functiilor
        // verifica daca cei doi parametri sunt egali, primul parametru fiind cel 'expected' si al doilea 'actual'

        BookService bookService = new BookServiceImpl(bookRepository);

        assertEquals(Optional.of(book), bookService.getById(any()));

        // assertEquals face parte din clasa Assertions si este o metoda statica
        // alte metode mai sunt:
        // asssertTrue -> verifica daca e true
        // assertTrue(true);

        // assertFalse -> verifica daca e false
        // assertFalse(false);
    }
}
