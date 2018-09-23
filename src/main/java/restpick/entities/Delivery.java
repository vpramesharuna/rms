package restpick.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DELIVERY database table.
 * 
 */
@Entity
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="DELIVERY_USER_ID")
	private int deliveryUserId;

	@Column(name="IS_DELIVERED")
	private byte isDelivered;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	private Restaurant restaurant;

	//bi-directional many-to-one association to Order
	@ManyToOne
	private Order order;

	public Delivery() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeliveryUserId() {
		return this.deliveryUserId;
	}

	public void setDeliveryUserId(int deliveryUserId) {
		this.deliveryUserId = deliveryUserId;
	}

	public byte getIsDelivered() {
		return this.isDelivered;
	}

	public void setIsDelivered(byte isDelivered) {
		this.isDelivered = isDelivered;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}