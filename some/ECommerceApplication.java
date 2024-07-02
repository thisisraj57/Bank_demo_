public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    // ... other business logic
}