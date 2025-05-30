# Cashflow Minimizer

This project is a Java-based cashflow minimizer that manages cash inflow and outflow using object-oriented programming (OOP) principles and file operations. Transactions are prioritized and saved to a `.txt` file for record-keeping.

## Features

- Manages cash inflow and outflow
- Prioritizes transactions for optimal cashflow management
- Uses OOP concepts for modular and maintainable code
- Saves all transaction records to a `.txt` file

## How It Works

1. **Transaction Handling:**  
   The system allows you to input both cash inflows and outflows. Each transaction can have a priority assigned to it.

2. **Priority-Based Processing:**  
   Transactions are managed and processed based on priority, ensuring that important transactions are handled first.

3. **File Operations:**  
   All transactions are saved to a `.txt` file. This file serves as a transaction log and can be used for future reference or auditing.

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Deb2003-21/cashflow_minimizer.git
   ```

2. **Compile and Run:**
   Make sure you have Java installed. Then compile and run the main class (update the filename as per your entry point):
   ```bash
   javac cashflow.java
   java cashflow
   ```

3. **Transaction Log File:**
   - All transactions are stored in a `.txt` file (please specify the filename if you want it mentioned explicitly).
   - You can view or analyze past transactions by opening this file.

## Result

Input:
```
Note- 0 is for posetive transactions and (1-10) has been used for priority 1 menas High and 10 means Low

2023-01-01 | 4500.0 | Salary | 0
2023-01-05 | -200.0 | Groceries | 2
2023-01-10 | -3000.0 | Rent | 1
2023-01-15 | -500.0 | Utilities | 4
2023-01-25 | -100.0 | Entertainment | 5
2023-01-28 | -150.0 | Transportation | 6
2023-02-01 | 2100.0 | Salary | 0
2023-02-03 | -100.0 | Dining | 5
2023-02-07 | -250.0 | Groceries | 2
2023-02-10 | -3000.0 | Rent | 1
2023-02-14 | -600.0 | Utilities | 4
2023-02-20 | -120.0 | Entertainment | 5
2023-03-01 | 5000.0 | Salary | 0
2023-03-04 | -180.0 | Groceries | 2
2023-03-10 | -3000.0 | Rent | 1
2023-03-12 | -400.0 | Healthcare | 3
2023-03-18 | -550.0 | Utilities | 4
2023-03-22 | -90.0 | Dining | 5
2023-03-27 | -110.0 | Transportation | 6
2023-03-30 | -250.0 | Shopping | 7
2023-04-01 | 2300.0 | Salary | 0
2023-04-05 | -230.0 | Groceries | 2
2023-04-10 | -3100.0 | Rent | 1
2023-04-15 | -300.0 | Healthcare | 3
2023-04-18 | -600.0 | Utilities | 4
2023-04-21 | -130.0 | Entertainment | 5
2023-04-25 | -160.0 | Transportation | 6
2023-04-29 | -400.0 | Shopping | 7

```
Output:

[File transactions.txt]

-Initial balance: 1000.0
-total balance with initial transactions: 14900.0

Fullfilled tasks: 
- 2023-01-10 -3000.0 Rent
- 2023-02-10 -3000.0 Rent
- 2023-03-10 -3000.0 Rent
- 2023-04-10 -3100.0 Rent
- 2023-01-05 -200.0 Groceries
- 2023-02-07 -250.0 Groceries
- 2023-03-04 -180.0 Groceries
- 2023-04-05 -230.0 Groceries
- 2023-03-12 -400.0 Healthcare
- 2023-04-15 -300.0 Healthcare
- 2023-01-15 -500.0 Utilities
- 2023-02-14 -600.0 Utilities
- 2023-01-25 -100.0 Entertainment

Skipped transactions:
 - 2023-03-18: -550.0 (Utilities)
 - 2023-04-18: -600.0 (Utilities)
 - 2023-02-03: -100.0 (Dining)
 - 2023-02-20: -120.0 (Entertainment)
 - 2023-03-22: -90.0 (Dining)
 - 2023-04-21: -130.0 (Entertainment)
 - 2023-01-28: -150.0 (Transportation)
 - 2023-03-27: -110.0 (Transportation)
 - 2023-04-25: -160.0 (Transportation)
 - 2023-03-30: -250.0 (Shopping)
 - 2023-04-29: -400.0 (Shopping)

- Remaining Balance INR: 40.0
- Take Loan of INR: 2660.0


## Requirements

- Java 8 or above

## License

This project is open-source and available under the [MIT License](LICENSE).

