import java.util.ArrayList;
import java.util.Scanner;

import order.Faco;
import order.Quesadilla;
import order.Taco;
import order.Transaction;

public class Main {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Faco> listFaco = new ArrayList<>();
	private ArrayList<Transaction> listTransaction = new ArrayList<>();
	private Database db = new Database();
	
	public void cls() {
		for(int i = 0 ; i < 40 ; i++) {
			System.out.println();
		}
	}
			
	public void pressEnter() {
		System.out.println("Press Enter..!!!");
		scan.nextLine();
		menu();
	}
	
	public void menu() {
		int opt = 0;
		System.out.println("Facobell");
		System.out.println("===============");
		System.out.println("1. View All Transaction");
		System.out.println("2. Buy Food");
		System.out.println("3. Delete Transaction");
		System.out.println("4. Exit");
		System.out.print(">> ");
		opt = scan.nextInt();
		scan.nextLine();
		
		switch(opt) {
		case 1:
			cls();
			viewTransaction();
			break;
		case 2:
			cls();
			buyFood();
			break;
		case 3:
			cls();
			deleteTransaction();
			break;
		case 4:
			System.out.println("Thank you for choosing this program...!!!");
			pressEnter();
			break;
		}
		
	}
	
	private void viewTr() {
		db.getTransaction(listTransaction);
		System.out.println("=============================================");
		System.out.printf("| %-15s | %-10s | %-10s |\n", "TransactionId", "FoodId", "Qty");
		System.out.println("=============================================");
		for(Transaction t : listTransaction) {
			System.out.printf("| %-15s | %-10s | %-10s |\n", t.getTrId(), t.getId(), t.getQty());
		}	
		System.out.println("=============================================");
	}
	
	private void viewTransaction() {
		viewTr();
		pressEnter();
		cls();
	}

	private void buyFood() {
		viewFood();
		
		int id;
		int quantity;
		int totalPrice = 0;
		int totalTax = 0;
		
		do {
			System.out.print("Choose Food to Buy[1-10]: ");
			id = scan.nextInt();
			scan.nextLine();
		} while (!validateId(id));
		
		do {
			System.out.print("Input Quantity to Buy[More Than 0]: ");
			quantity = scan.nextInt();
			scan.nextLine();
		} while (!(quantity > 0));
		
		db.insertTransaction(db.generateId(), id, quantity);
		cls();
		if(id > 0 || id <= 5) {
			for(Faco f : listFaco) {
				if(f instanceof Quesadilla) {
					totalPrice = quantity * getPriceFood(id);
					totalTax = totalPrice + 3000;
				}
			}
			System.out.println("=====================================");
			System.out.println("         Transaction Detail          ");
			System.out.println("=====================================");
			System.out.printf("Transaction ID: %s\n", db.generateId());
			System.out.printf("Food Name: %s\n", getFoodName(id));
			System.out.printf("Qty: %d\n", quantity);
			System.out.printf("Food Price: %d\n", totalPrice);
			System.out.printf("Total After Tax: %d\n", totalTax);
			System.out.println("=====================================");
			System.out.println("Successfully Bought Food..!!!");
			pressEnter();
			cls();
		}
		
		if(id > 5 || id <= 10) {
			for(Faco f : listFaco) {
				if(f instanceof Taco) {
					totalPrice = quantity * getPriceFood(id);
					totalTax = totalPrice + 5000;
				}
			}
			System.out.println("=====================================");
			System.out.println("         Transaction Detail          ");
			System.out.println("=====================================");
			System.out.printf("Transaction ID: %s\n", db.generateId());
			System.out.printf("Food Name: %s\n", getFoodName(id));
			System.out.printf("Qty: %d\n", quantity);
			System.out.printf("Food Price: %d\n", totalPrice);
			System.out.printf("Total After Tax: %d\n", totalTax);
			System.out.println("=====================================");
			System.out.println("Successfully Bought Food..!!!");
			pressEnter();
			cls();
		}	
	}
	
	public int getPriceFood(int id) {
		for(Faco f : listFaco) {
			if(f.getNumber() == id) {
				return f.getPrice();
			}
		}
		return 0;
	}
	
	public String getFoodName(int id) {
		for(Faco f : listFaco) {
			if(f.getNumber() == id) {
				return f.getName();
			}
		}
		return null;
	}
	
	public boolean validateId(int id) {
		for(Faco f : listFaco) {
			if(f.getNumber() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void viewFood() {
		db.getFood(listFaco);
		System.out.println("List Item Facobell");
		System.out.println("=======================================================================================");
		System.out.printf("| %-5s | %-18s | %-10s | %-10s | %-10s | %-15s |\n", "Id", "Name", "Type", "Price", "Shell Type", "Dipping Sauce");
		System.out.println("=======================================================================================");
		for(Faco f : listFaco) {
			if(f instanceof Quesadilla) {
				f.printAttribute();
			}		
		}
		for(Faco f : listFaco) {
			if(f instanceof Taco) {
				f.printAttribute();
			}		
		}
		System.out.println("=======================================================================================");
	}

	private void deleteTransaction() {
		viewTr();
		
		String deletedId;
		do {
			System.out.print("Input Transaction's Id want to be deleted: ");
			deletedId = scan.nextLine();
		} while (!validateTrId(deletedId));
		db.deleteTransaction(deletedId);
		System.out.println("Successfully Deleted " + deletedId + " in Transaction");
		pressEnter();
		cls();
	}
	
	public boolean validateTrId(String deletedId){
		for(Transaction t : listTransaction) {
			if(t.getTrId().equals(deletedId)) {
				return true;
			}
		}
		return false;
	}

	public Main() {
		menu();
	}

	public static void main(String[] args) {
		new Main();

	}

}
