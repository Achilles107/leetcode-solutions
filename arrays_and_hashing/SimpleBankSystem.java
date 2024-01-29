package arrays_and_hashing;

public class SimpleBankSystem {
    class Bank {

        private long[] balance;
        private int noOfAccounts;

        public Bank(long[] balance) {
            this.balance = balance;
            this.noOfAccounts = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 <= 0 || account1 > noOfAccounts)
                return false;
            if (account2 <= 0 || account2 > noOfAccounts)
                return false;
            long currBalance = balance[account1 - 1];
            if (currBalance < money)
                return false;

            balance[account2 - 1] += money;
            balance[account1 - 1] -= money;
            return true;

        }

        public boolean deposit(int account, long money) {
            if (account <= 0 || account > noOfAccounts)
                return false;
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account <= 0 || account > noOfAccounts)
                return false;
            long currBalance = balance[account - 1];
            if (currBalance < money)
                return false;
            balance[account - 1] -= money;
            return true;
        }
    }
}
