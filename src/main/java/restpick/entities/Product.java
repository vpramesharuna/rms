package restpick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte active;

	private String additional;

	@Column(name="CATEGORY_ID")
	private int categoryId;

	@Column(name="CUISINE_ID")
	private int cuisineId;

	@Column(name="DINING_PRICE")
	private double diningPrice;

	@Column(name="IS_VEG")
	private byte isVeg;

	@Column(name="ONLINE_PACKING_CHARGE")
	private double onlinePackingCharge;

	@Column(name="ONLINE_PRICE")
	private double onlinePrice;

	@Column(name="PRODUCT_IMAGE")
	private String productImage;

	private String quantity;

	private int serve;

	@Column(name="SERVICE_CHARGE")
	private double serviceCharge;

	@Column(name="SUB_MENU_1")
	private String subMenu1;

	@Column(name="SUB_MENU_2")
	private String subMenu2;

	@Column(name="SUB_MENU_3")
	private String subMenu3;

	@Column(name="TAKE_AWAY_PACKING_CHARGE")
	private double takeAwayPackingCharge;

	@Column(name="TAKE_AWAY_PRICE")
	private double takeAwayPrice;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	private Restaurant restaurant;

	public Product() {
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

	public String getAdditional() {
		return this.additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCuisineId() {
		return this.cuisineId;
	}

	public void setCuisineId(int cuisineId) {
		this.cuisineId = cuisineId;
	}

	public double getDiningPrice() {
		return this.diningPrice;
	}

	public void setDiningPrice(double diningPrice) {
		this.diningPrice = diningPrice;
	}

	public byte getIsVeg() {
		return this.isVeg;
	}

	public void setIsVeg(byte isVeg) {
		this.isVeg = isVeg;
	}

	public double getOnlinePackingCharge() {
		return this.onlinePackingCharge;
	}

	public void setOnlinePackingCharge(double onlinePackingCharge) {
		this.onlinePackingCharge = onlinePackingCharge;
	}

	public double getOnlinePrice() {
		return this.onlinePrice;
	}

	public void setOnlinePrice(double onlinePrice) {
		this.onlinePrice = onlinePrice;
	}

	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getServe() {
		return this.serve;
	}

	public void setServe(int serve) {
		this.serve = serve;
	}

	public double getServiceCharge() {
		return this.serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getSubMenu1() {
		return this.subMenu1;
	}

	public void setSubMenu1(String subMenu1) {
		this.subMenu1 = subMenu1;
	}

	public String getSubMenu2() {
		return this.subMenu2;
	}

	public void setSubMenu2(String subMenu2) {
		this.subMenu2 = subMenu2;
	}

	public String getSubMenu3() {
		return this.subMenu3;
	}

	public void setSubMenu3(String subMenu3) {
		this.subMenu3 = subMenu3;
	}

	public double getTakeAwayPackingCharge() {
		return this.takeAwayPackingCharge;
	}

	public void setTakeAwayPackingCharge(double takeAwayPackingCharge) {
		this.takeAwayPackingCharge = takeAwayPackingCharge;
	}

	public double getTakeAwayPrice() {
		return this.takeAwayPrice;
	}

	public void setTakeAwayPrice(double takeAwayPrice) {
		this.takeAwayPrice = takeAwayPrice;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProduct(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProduct(null);

		return orderDetail;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}