package order;

public abstract class Faco {
	protected int number;
	protected String name;
	protected String type;
	protected int price;

	public abstract void printAttribute();
	
	public Faco(int number, String name, String type, int price) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
