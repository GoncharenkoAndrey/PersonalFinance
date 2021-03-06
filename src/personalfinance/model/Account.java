package personalfinance.model;

import java.util.List;

import personalfinance.exception.ModelException;

public class Account extends Common {
	private String title;
	private Currency currency;
	private double startAmount;
	private double amount;
	
	public Account() {}
	
	public Account(String title, Currency currency, double startAmount, double amount) throws ModelException {
		if(title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
		if(currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);
		this.title = title;
		this.currency = currency;
		this.startAmount = startAmount;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public double getStartAmount() {
		return startAmount;
	}
	
	public void setStartAmount(double startAmount) {
		this.startAmount = startAmount;
	}
	
	public double getAmount() {
		return amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String getValueForComboBox() {
		return title;
	}
	
	public void setAmountFromTransactionsAndTransfers(List<Transaction> transactions, List<Transfer> transfers) {
		this.amount = startAmount;
		for(Transaction transaction : transactions) {
			if(transaction.getAccount().equals(this)) {
				this.amount += transaction.getAmount();
			}
		}
		for(Transfer transfer : transfers) {
			if(transfer.getFromAccount().equals(this)) {
				this.amount -= transfer.getFromAmount();
			}
			if(transfer.getToAccount().equals(this)) {
				this.amount += transfer.getToAmount();
			}
		}
	}
}
