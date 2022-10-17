package order;

public class Taco extends Faco {

	private String shellType;
	
	public Taco(int number, String name, String type, int price, String shellType) {
		super(number, name, type, price);
		this.shellType = shellType;
	}

	public String getShellType() {
		return shellType;
	}

	public void setShellType(String shellType) {
		this.shellType = shellType;
	}

	@Override
	public void printAttribute() {
		System.out.printf("| %-5d | %-18s | %-10s | %-10d | %-10s | %-15s |\n", number, name, "Taco", price, shellType,  "-");
	}
	
}
