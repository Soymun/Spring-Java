package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.exception.NotFoundException;
import com.edu.ulab.app.mapper.dto.BookDtoMapper;
import com.edu.ulab.app.service.BookService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class BookServiceImpl implements BookService {


    private final Storage storage;

    private final BookDtoMapper bookDtoMapper;

    public BookServiceImpl(Storage storage, BookDtoMapper bookDtoMapper) {
        this.storage = storage;
        this.bookDtoMapper = bookDtoMapper;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookDtoMapper.bookDtoToBook(bookDto);
        log.info("Create book: {}", book);
        return bookDtoMapper.bookToBookDto(storage.saveBook(book));
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        if (bookDto == null){
            throw new NotFoundException("Book not found");
        }
        Book book = bookDtoMapper.bookDtoToBook(bookDto);
        if (book.getId() == null){
            return bookDtoMapper.bookToBookDto(storage.saveBook(book));
        }
        log.info("Update book: {}", book);
        return bookDtoMapper.bookToBookDto(storage.updateBook(book));
    }

    @Override
    public List<BookDto> getBooksByUserId(Long id) {
        User user = storage.getUser(id);
        if (user == null){
            throw new NotFoundException(String.format("User with id:%d not found", id));
        }
        log.info("Get books by user id: {}", id);
        return user.getBookList().stream().filter(Objects::nonNull).map(storage::getBookById).map(bookDtoMapper::bookToBookDto).toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = storage.getBookById(id);
        if (book == null) {
            throw new NotFoundException(String.format("Book with id:%d not found", id));
        }
        log.info("Get book: {}", book);
        return bookDtoMapper.bookToBookDto(book);
    }

    @Override
    public void deleteBookById(Long id) {
        log.info("Delete book by id: {}", id);
        storage.deleteBook(id);
    }
}
