public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setEmail("john.doe@email.com");
        account.setAccountNumber("1234567890");
        account.setAccountType("SAVINGS");
        account.setStatus("APPROVED");

        Account createdAccount = accountService.createAccount(account);

        assertThat(createdAccount.getId()).isNotNull();
        assertThat(createdAccount.getFirstName()).isEqualTo("John");
        assertThat(createdAccount.getLastName()).isEqualTo("Doe");
        assertThat(createdAccount.getEmail()).isEqualTo("john.doe@email.com");
        assertThat(createdAccount.getAccountNumber()).isEqualTo("1234567890");
        assertThat(createdAccount.getAccountType()).isEqualTo("SAVINGS");
        assertThat(createdAccount.getStatus()).isEqualTo("APPROVED");
    }

    @Test
    public void testGetAllAccounts() {
        Account account1 = new Account();
        account1.setFirstName("John");
        account1.setLastName("Doe");
        account1.setEmail("john.doe@email.com");
        account1.setAccountNumber("1234567890");
        account1.setAccountType("SAVINGS");
        account1.setStatus("APPROVED");
        accountRepository.save(account1);

        Account account2 = new Account();
        account2.setFirstName("Jane");
        account2.setLastName("Doe");
        account2.setEmail("jane.doe@email.com");
        account2.setAccountNumber("0987654321");
        account2.setAccountType("CURRENT");
        account2.setStatus("PENDING");
        accountRepository.save(account2);

        List<Account> accounts = accountService.getAllAccounts();

        assertThat(accounts).hasSize(2);
        assertThat(accounts.get(0)).isEqualTo(account1);
        assertThat(accounts.get(1)).isEqualTo(account2);
    }

    @Test
    public void testGetAccountById() {
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setEmail("john.doe@email.com");
        account.setAccountNumber("1234567890");
        account.setAccountType("SAVINGS");
        account.setStatus("APPROVED");
        accountRepository.save(account);

        Account fetchedAccount = accountService.getAccountById(account.getId());

        assertThat(fetchedAccount).isEqualTo(account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setEmail("john.doe@email.com");
        account.setAccountNumber("1234567890");
        account.setAccountType("SAVINGS");
        account.setStatus("APPROVED");
        accountRepository.save(account);

        Account updatedAccount = new Account();
        updatedAccount.setId(account.getId());
        updatedAccount.setFirstName("John");
        updatedAccount.setLastName("Doe");
        updatedAccount.setEmail("john.doe@email.com");
        updatedAccount.setAccountNumber("0987654321");
        updatedAccount.setAccountType("CURRENT");
        updatedAccount.setStatus("PENDING");

        Account savedAccount = accountService.updateAccount(account.getId(), updatedAccount);

        assertThat(savedAccount).isEqualTo(updatedAccount);
    }

    @Test
    public void testDeleteAccount() {
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setEmail("john.doe@email.com");
        account.setAccountNumber("1234567890");
        account.setAccountType("SAVINGS");
        account.setStatus("APPROVED");
        accountRepository.save(account);

        accountService.deleteAccount(account.getId());

        Optional<Account> deletedAccount = accountRepository.findById(account.getId());
        
        assertThat(deletedAccount.isPresent()).isFalse();
    }
}