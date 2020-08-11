import java.util.ArrayList;
import java.util.Scanner;

import Bank_package.Bank;
import Bank_package.Gukmin;
import Bank_package.Shihan;
import Money_package.Money;
import Person_package.Person;

public class Main {
	public static void main(String[] args)
	{	int option;
		
		Bank bank= new Bank();
		ArrayList<Person> people = new ArrayList<Person>();
		Gukmin gukmin =  new Gukmin(new Money(50000));
		Shihan shinhan =  new Shihan(new Money(50000));
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("--------------------");
			System.out.println("1.���°輳");
			System.out.println("2.�ܾ���ȸ");
			System.out.println("3.�Ա��ϱ�");
			System.out.println("4.����ϱ�");
			System.out.println("5.����");
			option = sc.nextInt();
			switch(option)
			{
			case 1 : 
				System.out.print("�̸��� �Է��ϼ��� : ");
				String name = sc.next();
				people.add(new Person(name));
				
				String temp=bank.make_account(people.get(people.size()-1));
				if(temp.substring(0, 3).equals("111"))
				{
					gukmin.input_information(temp, name);
					System.out.println("���°��� ����");
				}
				else if(temp.substring(0, 3).equals("222"))
				{
					shinhan.input_information(temp, name);
					System.out.println("���°��� ����");
				}
				else
				{
					System.out.println("���°��� ����");
				}
				break;
				
			case 2 :
				System.out.print("������ ���¹�ȣ�� �Է��ϼ��� : ");
				String account = sc.next();
				System.out.print("�̸��� �Է��ϼ��� : ");
				String name1= sc.next();
				if(account.substring(0, 3).equals("111"))
				{
					gukmin.find_account_value(account, name1,gukmin.map);
				}
				else if (account.substring(0, 3).equals("222"))
				{
					shinhan.find_account_value(account, name1,shinhan.map);
				}
				else
				{
					System.out.println("��ġ�ϴ� ������ �����ϴ�");
				}
				break;
				
			case 3 :
				System.out.print("������ ���¹�ȣ�� �Է��ϼ��� : ");
				String account2 = sc.next();
				System.out.print("�󸶸� �Ա��Ͻðڽ��ϱ� : ");
				int value = sc.nextInt();
				if(account2.substring(0, 3).equals("111"))
				{
					gukmin.deposit(new Money(value), account2, people,gukmin.map);
				}
				else if(account2.substring(0, 3).equals("222"))
				{
					gukmin.deposit(new Money(value), account2, people,gukmin.map);
				}
				else
				{
					System.out.println("�߸��� ���¹�ȣ�Դϴ�");
				}
				break;
			case 4 :
				System.out.print("������ ���¹�ȣ�� �Է��ϼ��� : ");
				String account3 = sc.next();
				System.out.print("�󸶸� ����Ͻðڽ��ϱ� : ");
				int value2 = sc.nextInt();
				if(account3.substring(0, 3).equals("111"))
				{
					gukmin.withdraw(new Money(value2), account3, people, gukmin.map);
				}
				else if(account3.substring(0, 3).equals("222"))
				{
					shinhan.withdraw(new Money(value2), account3, people, shinhan.map);
				}
				else
				{
					System.out.println("�߸��� ���¹�ȣ�Դϴ�");
				}
				break; 
			case 5 : 
				break;
			}
		}while(option!=5);
			
	}

	
}
