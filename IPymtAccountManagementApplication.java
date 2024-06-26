public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with id :" + id));
    }

    public Account updateAccount(Long id, Account account) {
        Account existingAccount = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with id :" + id));
        existingAccount.setAccountNumber(account.getAccountNumber());
        existingAccount.setCustomerName(account.getCustomerName());
        // Set other account details
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}