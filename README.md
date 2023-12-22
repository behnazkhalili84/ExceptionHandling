
1.	Create the following Exception classes:

•	BankAccountException
•	InvalidAmountException extends BankAccountException
•	NotEnoughBalanceException extends BankAccountException
•	WithdrawLimitException extends BankAccountException
•	DepositLimitException extends BankAccountException

2.	Implement the deposit(double depositAmount) method which:

•	Throws InvalidAmountException if amount is non positive
•	Throws DepositLimitException if the amount is greater than the deposit limit
•	Otherwise, deposit the amount

3.	Implement the withdraw(double withdrawAmount)method which:

•	Throws InvalidAmountException if amount is non positive
•	Throws WithdrawLimitException if the amount is greater than the withdraw limit
•	Throws NotEnoughBalanceException if the amount is greater than the current balance
•	Otherwise, withdraw the amount
