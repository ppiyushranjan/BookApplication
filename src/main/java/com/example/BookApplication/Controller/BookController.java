package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {

	private final BookService bookService;
	@Autowired
	public BookController(BookService bookservice) {
		this.bookService = bookservice;
	}
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedBook = bookService.addBook(book);
		return ResponseEntity.ok(savedBook);
	}
	
	
	@GetMapping("/getBook/{bookName}")
	public ResponseEntity<Book> getBookByName(@PathVariable("bookName")String name){
		final Book bookByName = bookService.getBookByName(name);
		return ResponseEntity.ok(bookByName);
	}
	
	@PutMapping("/updateBook/{bookName}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookName")String name) {
		Book updatedBook = bookService.updateBook(book,name);
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id")Integer id){
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
}
