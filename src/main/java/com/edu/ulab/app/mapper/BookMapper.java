package com.edu.ulab.app.mapper;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.web.request.BookRequest;
import com.edu.ulab.app.web.request.Update.BookRequestUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto bookRequestToBookDto(BookRequest bookRequest);

    BookRequest bookDtoToBookRequest(BookDto bookDto);

    Book bookDtoToBook(BookDto bookDto);

    BookDto bookToBookDto(Book book);

    BookDto bookRequestUpdateToBookDto(BookRequestUpdate bookRequestUpdate);
}
