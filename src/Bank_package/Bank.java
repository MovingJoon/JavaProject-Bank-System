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
		System.out.print("������ ������ �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		String result;
		if(name.equalsIgnoreCase("��������"))
		{
			person.setAccount_number("111-"+Integer.toString((int) (Math.random()*1000000))+'-'+Integer.toString((int)(Math.random()*1000)));
			System.out.println("������ ���¹�ȣ : " +person.getAccount_number());
			result= person.getAccount_number();
		}
		else if(name.equalsIgnoreCase("��������"))
		{
			person.setAccount_number("222-"+Integer.toString((int) (Math.random()*1000000))+'-'+Integer.toString((int)(Math.random()*1000)));
			System.out.println("������ ���¹�ȣ : " +person.getAccount_number());
			result= person.getAccount_number();
		}
		else 
		{
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
			result="���¹�ȣ�� �����ϴ�.";
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
					System.out.println("�ܾ���" +" "+ String.valueOf(money.getAmount())+"�Դϴ�");
				}	
				else
				{
					System.out.println("���¹�ȣ�� �̸��� ��ġ���� �ʽ��ϴ�");
				}
		}
		else
		{
			System.out.println("������ �����ϴ�");
		}
	}
	
	public void deposit(Money money, String account_number,ArrayList<Person> people,Map<String, Map<String,Object>> map)
	{
		
		if(map.containsKey(account_number))//������ ���¸� ������ �մ°�
		{
			Iterator<String> ir = map.keySet().iterator();
			while(ir.hasNext())
			{
				String key = ir.next();//Ű���� �ϳ��� �޾ƿ´�.
				if(key.equals(account_number))
				{
					for(int i=0;i<people.size();i++)
					{
						if(people.get(i).getAccount_number().equals(key))//�� ����� ������ ���¹�ȣ�� ��ġ�ϴ��� Ȯ���Ѵ�.
						{
							int temp1= people.get(i).getWallet().getAmount()-money.getAmount();
							people.get(i).setWallet(new Money(temp1));//�� ����� ������ ���� �� 
							Money money1= (Money)map.get(account_number).get("money");//map���� ���¿� ����Ǿ��ִ� ���� �����´�.
							int temp2 = money.getAmount()+money1.getAmount();//���� ������+���¿� �ִµ�
							//���¿� �Աݵ� ��
							update(account_number, people.get(i).getName(), new Money(temp2),map);//hashmap�� ������ ������Ʈ�Ѵ�.
							System.out.println(money.getAmount()+"���� �ԱݿϷ� �Ǿ����ϴ�");
							
						}
						else
						{
							System.out.println("������ ���¹�ȣ�� ��ġ���� �ʽ��ϴ�");
						}
						
					}
				}
				else
				{
					System.out.println("��ϵ��� ���� ���¹�ȣ�Դϴ�");
				}
				
			}
		}
		else
		{
			System.out.println("��ϵ��� ���� ���¹�ȣ�Դϴ�");
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
						{	Money money1=(Money) map.get(account_number).get("money");//�����ܰ�
							if(money1.getAmount()<money.getAmount())//�����ܰ�<������ ��
							{
								System.out.println("�����ܾ��� �����մϴ�");
							}
							else
							{
								int temp1 =people.get(i).getWallet().getAmount()+money.getAmount();//���� ������ �������ִµ� + ���µ�
								people.get(i).setWallet(new Money(temp1));//������ ���� ����(������Ʈ)
								int temp2 = money1.getAmount()-money.getAmount();//�����ܰ� -����� ��
								update(account_number, people.get(i).getName(), new Money(temp2),map);
								System.out.println("����� �Ϸ�Ǿ����ϴ�");
								System.out.println("�ܰ�� : "+temp2+"�� �Դϴ�");
							}
						}
					}
				}
			}
		}
	}
	
}
	
	
