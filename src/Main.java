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
			System.out.println("1.계좌계설");
			System.out.println("2.잔액조회");
			System.out.println("3.입금하기");
			System.out.println("4.출금하기");
			System.out.println("5.종료");
			option = sc.nextInt();
			switch(option)
			{
			case 1 : 
				System.out.print("이름을 입력하세요 : ");
				String name = sc.next();
				people.add(new Person(name));
				
				String temp=bank.make_account(people.get(people.size()-1));
				if(temp.substring(0, 3).equals("111"))
				{
					gukmin.input_information(temp, name);
					System.out.println("계좌개설 성공");
				}
				else if(temp.substring(0, 3).equals("222"))
				{
					shinhan.input_information(temp, name);
					System.out.println("계좌개설 성공");
				}
				else
				{
					System.out.println("계좌개설 실패");
				}
				break;
				
			case 2 :
				System.out.print("본인의 계좌번호를 입력하세요 : ");
				String account = sc.next();
				System.out.print("이름을 입력하세요 : ");
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
					System.out.println("일치하는 은행이 없습니다");
				}
				break;
				
			case 3 :
				System.out.print("본인의 계좌번호를 입력하세요 : ");
				String account2 = sc.next();
				System.out.print("얼마를 입금하시겠습니까 : ");
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
					System.out.println("잘못된 계좌번호입니다");
				}
				break;
			case 4 :
				System.out.print("본인의 계좌번호를 입력하세요 : ");
				String account3 = sc.next();
				System.out.print("얼마를 출금하시겠습니까 : ");
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
					System.out.println("잘못된 계좌번호입니다");
				}
				break; 
			case 5 : 
				break;
			}
		}while(option!=5);
			
	}

	
}
