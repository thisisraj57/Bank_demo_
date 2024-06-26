public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}/status")
    public AccountStatus getAccountStatus(@PathVariable("accountId") Long accountId) {
        return accountService.getAccountStatus(accountId);
    }
}