package com.info.worker;

import com.info.model.Account;

    //thread --> implements runnable
    public class AccountHolder implements Runnable {
        private Account account;

        public AccountHolder(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 4; i++) {
                makeWithdrawal(2000);
                if (account.getBalance() < 0) {
                    System.out.println("account is overdrawn!");
                }
            }
        }

        //method is synchronised, only one thread can execute it at a time
        // draw-back : performance dec, waiting time. 
        private synchronized void makeWithdrawal(int withdrawAmout) {
            if (account.getBalance() >= withdrawAmout) {
                System.out.println(Thread.currentThread().getName() + " is getting to withdraw $" + withdrawAmout);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                }
                account.withdraw(withdrawAmout);
                System.out.println(Thread.currentThread().getName()+" completes the withdrawal of $"+withdrawAmout);
            }
            else {
                System.out.println("Not enough in account for " + Thread.currentThread().getName()+" to withdraw -"+account.getBalance());
            }
        }
    }
