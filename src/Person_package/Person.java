package Person_package;

import Money_package.Money;

public class Person {
		
	Money wallet;
	private String account_number;
	private String name;
	public Person(String name)
	{
		this.wallet=new Money(0);
		this.name=name;
	}
	public Person(Money money,String name)
	{
		this.wallet=money;
		this.name=name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Money getWallet() {
		return wallet;
	}

	public void setWallet(Money wallet) {
		this.wallet = wallet;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
}
