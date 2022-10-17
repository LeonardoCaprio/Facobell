package order;

public class Transaction {
	private String trId;
	private int id;
	private int qty;
	
	public Transaction(String trId, int id, int qty) {
		super();
		this.trId = trId;
		this.id = id;
		this.qty = qty;
	}

	public String getTrId() {
		return trId;
	}

	public void setTrId(String trId) {
		this.trId = trId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
