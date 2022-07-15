/**
 * @author dimitar
 *
 */
package bg.softuni.books.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import bg.softuni.books.model.dto.BookDto;
import bg.softuni.books.service.BookService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class BooksController {

	private BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks() {
		
		return ResponseEntity.ok(bookService.getAllBooks());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long bookId) {
		Optional<BookDto> bookOpt = bookService.getBookById(bookId);

		if (bookOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(bookOpt.get());
		}
	}
	
	@PostMapping
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBook, UriComponentsBuilder uriComponentsBuilder){
		Long newBookId = bookService.createBook(newBook);
		
		return ResponseEntity.created(uriComponentsBuilder.path("/api/books/{id}").build(newBookId))
		.build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BookDto> deleteBookById(@PathVariable("id") Long bookID){
		bookService.deleteBookById(bookID);
		
		return ResponseEntity.noContent().build();
	}
	

}
