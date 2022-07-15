/**
 * @author dimitar
 *
 */
package bg.softuni.books.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bg.softuni.books.model.BookEntity;
import bg.softuni.books.model.dto.AuthorDto;
import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository; 
	}
	
	public Optional<BookDto> getBookById(Long bookId){
		return bookRepository.findById(bookId).map(this::map);
	}
	
	public List<BookDto> getAllBooks(){
		return bookRepository.findAll().stream()
				.map(this::map)
				.collect(Collectors.toList());
	}
	
	public Long createBook(BookDto bookDto) {
		
		
		return 50L;
	}
	
	private BookDto map(BookEntity bookEntity) {
		
		return new BookDto()
				.setId(bookEntity.getId())
				.setTitle(bookEntity.getTitle())
				.setIsbn(bookEntity.getIsbn())
				.setAuthor(new AuthorDto().setName(bookEntity.getAuthor().getName()));
		
	}
	
	public void deleteBookById(Long bookId) {
		
		bookRepository.deleteById(bookId);
		
	}
	


}
