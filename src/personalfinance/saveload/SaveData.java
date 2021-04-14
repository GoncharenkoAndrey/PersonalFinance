package personalfinance.saveload;

import java.util.List;
import java.util.ArrayList;
import personalfinance.model.*;

public class SaveData {
	private static SaveData instance;
	private List<Article> articles = new ArrayList<Article>();
	private List<Currency> currencies = new ArrayList<Currency>();
	private List<Account> accounts = new ArrayList<Account>();
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private List<Transfer> transfers = new ArrayList<Transfer>();
	
	private SaveData() {
		
	}
	public static SaveData getInstance() {
		if(instance == null)
			instance = new SaveData();
		return instance;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public List<Currency> getCurrencies() {
		return currencies;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public List<Transfer> getTransfers() {
		return transfers;
	}
	public Currency getBaseCurrency() {
		for(Currency c : currencies) {
			if(c.isBase())
				return c;
		}
		return new Currency();
	}
}
