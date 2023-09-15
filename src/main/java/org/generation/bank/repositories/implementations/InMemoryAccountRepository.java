package org.generation.bank;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {
    /*
        Un wrapper intorno all'HahsMap dove sono di fatto i conti correnti
     */

    private Map<Long, Account> accountMap = new HashMap<>();
    private static long idGenerator;

    @Override
    public void addAccount(Account account) {
        idGenerator++;
        account.setId(idGenerator);
        accountMap.put(idGenerator, account);
    }

    @Override
    public Account findById(long id) {
        return accountMap.get(idGenerator);
    }

    @Override
    public Iterable<Account> getAccounts() {
        return accountMap.values();
    }
}
