public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    private String accountNumber;
    private String accountType;
    private String status;

    // getters and setters
}