import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import Branch.Branch;
import Customer.Buyer;
import Customer.Seller;
import Property.Property;
import Property.PropertyType;
import Property.SaleProperty;

public class Manager {

	static Seller s;
	static ArrayList<SaleProperty> properties = new ArrayList<SaleProperty>();
	


	public static void main(String[] args) {
		s = new Seller(1, "Mohammed", "admin@gmail.com");
		for(int i = 0; i < 10; i++) {
			properties.add(new SaleProperty("000 Collins St", "Docklands", 1, 1, 0, PropertyType.unit, (double) 3500, s));
		}
		Scanner in = new Scanner(System.in);
		System.out.print("<1> for customer login\n");
		System.out.print("<2> for employee login\n");
		int input = in.nextInt();
		while(true) {
			if (input == 1) {
				customerLogin();
			}else if(input ==2) {
				employeeLogin();
			}else if(input == -1) {
				break;
			}else {
				input =in.nextInt();
			}
		}
	}
	
	public static void customerLogin() {
		Scanner in = new Scanner(System.in);
		System.out.print("<1> Buyer\n");
		System.out.print("<2> Seller\n");
		System.out.print("<3> Go Back\n");
		int input = in.nextInt();
		
		while(true) {

			if (input == 1) {
				System.out.print("username: ");
				String username = in.next();
				System.out.print("password: ");
				int password = in.nextInt();

				if(username != "Mohammed" && password != 123) {
					continue;
				}
				buyerLogedin();
				
			}else if(input ==2) {
				System.out.print("username: ");
				String username = in.next();
				System.out.print("password: ");
				int password = in.nextInt();

				if(username != "emp1" && password != 123) {
					continue;
				}
				break;
				
			}else if(input == 3) {
				return;
			}else {
				input =in.nextInt();
				
			}

		}
	}
	
	public static void buyerLogedin() {
		Scanner in = new Scanner(System.in);
		System.out.print("<1> Listings by suburbs\n");
		System.out.print("<2> Go Back\n");
		int input = in.nextInt();
		while(true) {
			if (input == 1) {
				System.out.print("suburb: ");
				String s = in.next();
				for(Property p: properties) {
					if(p.getSuburb() == s) {
						System.out.println(p);
					}
				}
				listedProperties();
			}else if(input ==2) {
				break;
			}else {
				input =in.nextInt();
			}
		}
	}
	
	public static void listedProperties(){
		Scanner in = new Scanner(System.in);
		System.out.print("<1> Make Offer\n");
		System.out.print("<2> Go Back\n");
		int input = in.nextInt();
	}
	
	
	
	public static void sellerLogedin() {
		
	}
	
	public static void employeeLogin() {
		
	}

}
