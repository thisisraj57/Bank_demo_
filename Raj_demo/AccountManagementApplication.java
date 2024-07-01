import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class AccountManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/accounts")
class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        return accountService.updateAccount(accountId, account);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
    }
}

class AccountService {

    public Account createAccount(Account account) {
        // Implement account creation logic
        return account;
    }

    public Account getAccount(Long accountId) {
        // Implement account retrieval logic
        return account;
    }

    public Account updateAccount(Long accountId, Account account) {
        // Implement account update logic
        return account;
    }

    public void deleteAccount(Long accountId) {
        // Implement account deletion logic
    }
}

class Account {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    // Getters and setters
}