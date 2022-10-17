import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import order.Faco;
import order.Quesadilla;
import order.Taco;
import order.Transaction;

public class Database {
	private Connect connect = Connect.getConnection();
	private Random rand = new Random();
	
	//-------------------------GetFood---------------------------------------
	public void getFood(ArrayList<Faco> listFaco) {
		listFaco.clear();
		String queryTaco = "SELECT * FROM taco";
		String queryQuesadilla = "SELECT * FROM quesadilla";
		
		ResultSet rsTaco = connect.executeQuery(queryTaco);
		try {
			while(rsTaco.next()) {
				Integer id = rsTaco.getInt("FoodId");
				String name = rsTaco.getString("FoodName");
				String type = rsTaco.getString("FoodType");
				Integer price = rsTaco.getInt("FoodPrice");
				String shellType = rsTaco.getString("ShellType");
				
				listFaco.add(new Taco(id, name, type, price, shellType));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rsQuesadilla = connect.executeQuery(queryQuesadilla);
		try {
			while(rsQuesadilla.next()) {
				Integer id = rsQuesadilla.getInt("FoodId");
				String name = rsQuesadilla.getString("FoodName");
				String type = rsQuesadilla.getString("FoodType");
				Integer price = rsQuesadilla.getInt("FoodPrice");
				String dippingSauce = rsQuesadilla.getString("DippingSauce");
				
				listFaco.add(new Quesadilla(id, name, type, price, dippingSauce));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//-------------------------GetFood---------------------------------------
	//-----------------------InsertTransaction-------------------------------
	public void insertTransaction(String trId, int id, int qty){
		String query = String.format("INSERT INTO transaction VALUES ('%s','%d','%d')",trId, id, qty);
		connect.executeUpdate(query);
	}
	
	public String generateId() {
		String Idnum;
		Idnum = "TR" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		return Idnum;
	}
	
	public void getTransaction(ArrayList<Transaction> listTransaction) {
		listTransaction.clear();
		String query = "SELECT * FROM transaction";
		
		ResultSet rs = connect.executeQuery(query);
		try {
			while(rs.next()) {
				String trId = rs.getString("TransactionId");
				int foodId = rs.getInt("FoodId");
				int qty = rs.getInt("Qty");
				
				listTransaction.add(new Transaction(trId, foodId, qty));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//----------------DELETED--------------------
	public void deleteTransaction(String deletedId) {
		String query = String.format("DELETE FROM transaction WHERE TransactionId = '%s'", deletedId);
		connect.executeUpdate(query);
	}
	
	



}
