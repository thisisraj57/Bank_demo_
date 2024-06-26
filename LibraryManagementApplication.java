public class LibraryManagementApplication {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final CategoryRepository categoryRepository;
	private final ReviewRepository reviewRepository;

	public LibraryManagementApplication(BookRepository bookRepository, AuthorRepository authorRepository,
			CategoryRepository categoryRepository, ReviewRepository reviewRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.categoryRepository = categoryRepository;
		this.reviewRepository = reviewRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return authorRepository.save(author);
	}

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return (List<Category>) categoryRepository.findAll();
	}

	@PostMapping("/categories")
	public Category createCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/reviews")
	public List<Review> getAllReviews() {
		return (List<Review>) reviewRepository.findAll();
	}

	@PostMapping("/reviews")
	public Review createReview(@RequestBody Review review) {
		return reviewRepository.save(review);
	}
}