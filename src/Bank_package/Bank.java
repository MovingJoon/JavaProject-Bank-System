package Bank_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import Money_package.Money;
import Person_package.Person;

public class Bank {
		
	Money money;
	Scanner sc = new Scanner(System.in);
	
	public Bank()
	{
		
	}
	public Bank(Money money)
	{
		this.money=money;
	}
	
	public String make_account(Person person)
	{
		System.out.print("개설할 은행의 이름을 입력하세오 : ");
		String name = sc.next();
		String result;
		if(name.equalsIgnoreCase("국민은행"))
		{
			person.setAccount_number("111-"+Integer.toString((int) (Math.random()*1000000))+'-'+Integer.toString((int)(Math.random()*1000)));
			System.out.println("생성된 계좌번호 : " +person.getAccount_number());
			result= person.getAccount_number();
		}
		else if(name.equalsIgnoreCase("신한은행"))
		{
			person.setAccount_number("222-"+Integer.toString((int) (Math.random()*1000000))+'-'+Integer.toString((int)(Math.random()*1000)));
			System.out.println("생성된 계좌번호 : " +person.getAccount_number());
			result= person.getAccount_number();
		}
		else 
		{
			System.out.println("일치하는 은행이 없습니다.");
			result="계좌번호가 없습니다.";
		}
		return result;
	}
	

	public void find_account_value(String account_number, String name, Map<String, Map<String,Object>> map)
	{
		if(map.containsKey(account_number))
		{
				if(map.get(account_number).get("name").equals(name))
				{
					Money money = (Money) map.get(account_number).get("money");
					System.out.println("잔액은" +" "+ String.valueOf(money.getAmount())+"입니다");
				}	
				else
				{
					System.out.println("계좌번호와 이름이 일치하지 않습니다");
				}
		}
		else
		{
			System.out.println("정보가 없습니다");
		}
	}
	
	public void deposit(Money money, String account_number,ArrayList<Person> people,Map<String, Map<String,Object>> map)
	{
		
		if(map.containsKey(account_number))//은행이 계좌를 가지고 잇는가
		{
			Iterator<String> ir = map.keySet().iterator();
			while(ir.hasNext())
			{
				String key = ir.next();//키값을 하나씩 받아온다.
				if(key.equals(account_number))
				{
					for(int i=0;i<people.size();i++)
					{
						if(people.get(i).getAccount_number().equals(key))//그 사람의 정보와 계좌번호가 일치하는지 확인한다.
						{
							int temp1= people.get(i).getWallet().getAmount()-money.getAmount();
							people.get(i).setWallet(new Money(temp1));//그 사람의 지갑에 남은 돈 
							Money money1= (Money)map.get(account_number).get("money");//map에서 계좌에 저장되어있는 돈을 가져온다.
							int temp2 = money.getAmount()+money1.getAmount();//내가 넣을돈+계좌에 있는돈
							//계좌에 입금된 돈
							update(account_number, people.get(i).getName(), new Money(temp2),map);//hashmap의 내용을 업데이트한다.
							System.out.println(money.getAmount()+"원이 입금완료 되었습니다");
							
						}
						else
						{
							System.out.println("정보와 계좌번호가 일치하지 않습니다");
						}
						
					}
				}
				else
				{
					System.out.println("등록되지 않은 계좌번호입니다");
				}
				
			}
		}
		else
		{
			System.out.println("등록되지 않은 계좌번호입니다");
		}
	}
	
	public void update(String account_number,String name, Money money, Map<String, Map<String,Object>> map)
	{
		String name2 = (String) map.get(account_number).get(name);
		Map<String,Object> map_2 = new HashMap<String,Object>();
		map_2.put("name",name);
		map_2.put("money", money);
		map.put(account_number, map_2);
	}
	
	public void withdraw(Money money, String account_number, ArrayList<Person> people, Map<String, Map<String,Object>> map)
	{
		if(map.containsKey(account_number))
		{
			Iterator<String> ir = map.keySet().iterator();
			while(ir.hasNext())
			{
				String key = ir.next();
				if(key.equals(account_number))
				{
					for(int i=0; i<people.size();i++)
					{
						if(people.get(i).getAccount_number().equals(key))
						{	Money money1=(Money) map.get(account_number).get("money");//통장잔고
							if(money1.getAmount()<money.getAmount())//통잔잔고<인출할 돈
							{
								System.out.println("통장잔액이 부족합니다");
							}
							else
							{
								int temp1 =people.get(i).getWallet().getAmount()+money.getAmount();//내가 지갑에 가지고있는돈 + 빼는돈
								people.get(i).setWallet(new Money(temp1));//지갑의 돈을 설정(업데이트)
								int temp2 = money1.getAmount()-money.getAmount();//통장잔고 -인출된 돈
								update(account_number, people.get(i).getName(), new Money(temp2),map);
								System.out.println("출금이 완료되었습니다");
								System.out.println("잔고는 : "+temp2+"원 입니다");
							}
						}
					}
				}
			}
		}
	}
	
}
	
	
