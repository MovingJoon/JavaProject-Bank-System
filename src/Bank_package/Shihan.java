package Bank_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Money_package.Money;
import Person_package.Person;

public class Shihan extends Bank{

	
	public Map<String, Map<String,Object>> map= new HashMap<String, Map<String,Object>>();
	String Bank_code="111";
	Money money = new Money(500000000);
	
	public Shihan(Money money) {
		super(money);
	}
	
	
	public void input_information(String account_number,String name)
	{
		Map<String, Object> map_1= new HashMap<String , Object>();
		map_1.put("name", name);
		map_1.put("money", new Money(0));
		map.put(account_number, map_1);
	}
	
	
	
	
}
