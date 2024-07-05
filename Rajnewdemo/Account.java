public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/open")
    public Account openAccount(@RequestBody Account account) {
        return accountService.openAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PutMapping("/approve/{id}")
    public Account approveAccount(@PathVariable Long id) {
        return accountService.approveAccount(id);
    }
}