public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found with id :" + id));
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        Review existingReview = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found with id :" + id));
        existingReview.setReviewText(review.getReviewText());
        existingReview.setRating(review.getRating());
        existingReview.setBookId(review.getBookId());
        return reviewRepository.save(existingReview);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
    }
}