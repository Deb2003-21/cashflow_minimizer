import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.time.LocalDate;

class Trans {
    /**
     * This class represents a transaction with a date, amount, description, and
     * priority.
     * It is used to store both positive and negative transactions.
     */
    public String date;
    public double amount;
    public String des;
    public int priority;

    public Trans(String date, double amount, String des, int priority) {
        this.date = LocalDate.parse(date).toString();
        this.amount = amount;
        this.des = des;
        this.priority = priority;
    }
}

class TotalResult {
    public double positiveBalance;
    public double remaining;
    public List<Trans> skippedTransactions;

    public TotalResult(double positiveBalance, double remaining, List<Trans> skippedTransactions) {
        this.positiveBalance = positiveBalance;
        this.remaining = remaining;
        this.skippedTransactions = skippedTransactions;
    }
}

class Transactions {
    // List to hold positive and negative transactions

    public List<Trans> p_transactions = new ArrayList<>();
    public List<Trans> n_transactions = new ArrayList<>();

    public void addTransaction(String date, double amount, String des, int priority) {
        if (amount < 0) {
            n_transactions.add(new Trans(date, amount, des, priority));
        } else {
            p_transactions.add(new Trans(date, amount, des, priority));
        }

    }

    public List<Trans> getSorted(List<Trans> transactions) {
        // Sort transactions by priority and then by date
        transactions.sort((t1, t2) -> {
            if (t1.priority == t2.priority) {
                return t1.date.compareTo(t2.date);
            } else {
                return Integer.compare(t1.priority, t2.priority);
            }
        });
        return transactions;
    }

}

class fileW {
    /**
     * This class is used to write the transactions to a file.
     * It appends the transactions to a file named "transactions.txt".
     */
    public BufferedWriter file1() throws IOException {
        // Create a BufferedWriter to write to the file
        return new BufferedWriter(new FileWriter("transactions.txt", true));

    }
}

class Cash_minimizer {
    /**
     * This method calculates the total balance after processing all transactions.
     * It skips transactions that would result in a negative balance and returns
     * the remaining balance and the skipped transactions.
     *
     * @param inital       The initial balance.
     * @param transactions The list of transactions to process.
     * @return A TotalResult object containing the final balance, remaining amount,
     *         and skipped transactions.
     */

    public TotalResult getTotal(double inital, Transactions transactions) {
        List<Trans> skip = new ArrayList<>();
        double posetive_bal = inital;
        double remaining = 0.0;
        List<Trans> n_transactions = transactions.getSorted(transactions.n_transactions);

        try {
            // BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt",
            // true));
            fileW f = new fileW();
            BufferedWriter writer = f.file1();

            // Write the initial balance and total balance with initial transactions
            for (Trans t : transactions.p_transactions) {
                posetive_bal += t.amount;
            }
            writer.write("Initial balance: " + inital + "\n");
            writer.write("total balance with initial transactions: " + posetive_bal + "\n\n");
            writer.write("Fullfilled tasks: \n");

            for (Trans t : n_transactions) {

                if (posetive_bal + t.amount < 0) {
                    skip.add(t);
                    remaining = remaining - t.amount;
                    continue;
                }
                posetive_bal = posetive_bal + t.amount;
                // Write the transaction to the file
                writer.write(t.date + " " + t.amount + " " + t.des + "\n");
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new TotalResult(posetive_bal, remaining, skip);
    }
}

class Cashflow {
    public static void main(String[] args) {
        Cash_minimizer cashMinimizer = new Cash_minimizer();
        Transactions transactions = new Transactions();

        // Example transactions
        transactions.addTransaction("2023-01-01", 4500, "Salary", 0);
        transactions.addTransaction("2023-01-05", -200, "Groceries", 2);
        transactions.addTransaction("2023-01-10", -3000, "Rent", 1);
        transactions.addTransaction("2023-01-15", -500, "Utilities", 4);
        transactions.addTransaction("2023-01-25", -100, "Entertainment", 5);
        transactions.addTransaction("2023-01-28", -150, "Transportation", 6);
        transactions.addTransaction("2023-02-01", 2100, "Salary", 0);
        transactions.addTransaction("2023-02-03", -100, "Dining", 5);
        transactions.addTransaction("2023-02-07", -250, "Groceries", 2);
        transactions.addTransaction("2023-02-10", -3000, "Rent", 1);
        transactions.addTransaction("2023-02-14", -600, "Utilities", 4);
        transactions.addTransaction("2023-02-20", -120, "Entertainment", 5);

        // Adding more transactions to test the cash minimizer
        transactions.addTransaction("2023-03-01", 5000, "Salary", 0);
        transactions.addTransaction("2023-03-04", -180, "Groceries", 2);
        transactions.addTransaction("2023-03-10", -3000, "Rent", 1);
        transactions.addTransaction("2023-03-12", -400, "Healthcare", 3);
        transactions.addTransaction("2023-03-18", -550, "Utilities", 4);
        transactions.addTransaction("2023-03-22", -90, "Dining", 5);
        transactions.addTransaction("2023-03-27", -110, "Transportation", 6);
        transactions.addTransaction("2023-03-30", -250, "Shopping", 7);
        transactions.addTransaction("2023-04-01", 2300, "Salary", 0);
        transactions.addTransaction("2023-04-05", -230, "Groceries", 2);
        transactions.addTransaction("2023-04-10", -3100, "Rent", 1);
        transactions.addTransaction("2023-04-15", -300, "Healthcare", 3);
        transactions.addTransaction("2023-04-18", -600, "Utilities", 4);
        transactions.addTransaction("2023-04-21", -130, "Entertainment", 5);
        transactions.addTransaction("2023-04-25", -160, "Transportation", 6);
        transactions.addTransaction("2023-04-29", -400, "Shopping", 7);

        // previous bank balance
        TotalResult result = cashMinimizer.getTotal(1000, transactions);

        System.out.println("Remaining Balance: " + result.positiveBalance);
        System.out.println(" More balance needed: " + result.remaining);

        // Print skipped transactions
        try {
            fileW f = new fileW();
            BufferedWriter writer = f.file1();
            writer.write("\nSkipped transactions:\n");
            for (Trans t : result.skippedTransactions) {
                writer.write(" - " + t.date + ": " + t.amount + " (" + t.des + ")\n");
            }
            writer.write("\n Remaining Balance INR: " + result.positiveBalance + "\n");
            writer.write("Take Loan of INR: " + result.remaining + "\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
