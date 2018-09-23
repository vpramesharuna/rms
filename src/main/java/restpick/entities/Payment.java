package restpick.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PAYMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="BILL_AMOUNT")
	private double billAmount;

	private double cgst;

	@Column(name="IS_PAYED")
	private byte isPayed;

	@Column(name="PAYMENT_MODE")
	private String paymentMode;

	@Column(name="ROUND_OFF")
	private double roundOff;

	private double sgst;

	@Column(name="TOTAL_AMOUNT")
	private double totalAmount;

	//bi-directional many-to-one association to Order
	@ManyToOne
	private Order order;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	private Restaurant restaurant;

	public Payment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBillAmount() {
		return this.billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getCgst() {
		return this.cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public byte getIsPayed() {
		return this.isPayed;
	}

	public void setIsPayed(byte isPayed) {
		this.isPayed = isPayed;
	}

	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getRoundOff() {
		return this.roundOff;
	}

	public void setRoundOff(double roundOff) {
		this.roundOff = roundOff;
	}

	public double getSgst() {
		return this.sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}