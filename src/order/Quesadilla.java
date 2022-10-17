package order;

public class Quesadilla extends Faco{
	
	private String dippingSauce;
	
	public Quesadilla(int number, String name, String type, int price, String dippingSauce) {
		super(number, name, type, price);
		this.dippingSauce = dippingSauce;
	}

	public String getDippingSauce() {
		return dippingSauce;
	}

	public void setDippingSauce(String dippingSauce) {
		this.dippingSauce = dippingSauce;
	}

	@Override
	public void printAttribute() {
		System.out.printf("| %-5d | %-18s | %-10s | %-10d | %-10s | %-15s |\n", number, name, "Quesadilla", price, "-", dippingSauce);
	}
	
}
