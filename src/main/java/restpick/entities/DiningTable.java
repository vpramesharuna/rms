package restpick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DINING_TABLE database table.
 * 
 */
@Entity
@Table(name="DINING_TABLE")
@NamedQuery(name="DiningTable.findAll", query="SELECT d FROM DiningTable d")
public class DiningTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte active;

	@Column(name="TABLE_ID")
	private int tableId;

	@Column(name="TABLE_NAME_VAL")
	private String tableNameVal;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	private Restaurant restaurant;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="diningTable")
	private List<OrderDetail> orderDetails;

	public DiningTable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableNameVal() {
		return this.tableNameVal;
	}

	public void setTableNameVal(String tableNameVal) {
		this.tableNameVal = tableNameVal;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setDiningTable(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setDiningTable(null);

		return orderDetail;
	}

}