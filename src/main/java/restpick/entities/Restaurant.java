package restpick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RESTAURANT database table.
 * 
 */
@Entity
@NamedQuery(name="Restaurant.findAll", query="SELECT r FROM Restaurant r")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int active;

	private String address;

	private String cin;

	private String city;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED")
	private Date lastUpdated;

	@Column(name="MOBILE_NUMBER")
	private int mobileNumber;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	private String postal;

	@Column(name="REST_NAME")
	private String restName;

	private String state;

	@Column(name="TIN_NUM")
	private String tinNum;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="restaurant")
	private List<Customer> customers;

	//bi-directional many-to-one association to Delivery
	@OneToMany(mappedBy="restaurant")
	private List<Delivery> deliveries;

	//bi-directional many-to-one association to DiningTable
	@OneToMany(mappedBy="restaurant")
	private List<DiningTable> diningTables;

	//bi-directional many-to-one association to InputImage
	@OneToMany(mappedBy="restaurant")
	private List<InputImage> inputImages;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="restaurant")
	private List<Order> orders;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="restaurant")
	private List<Payment> payments;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="restaurant")
	private List<Product> products;

	//bi-directional many-to-one association to Property
	@OneToMany(mappedBy="restaurant")
	private List<Property> properties;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="PARENT_REST_ID")
	private Restaurant restaurant;

	//bi-directional many-to-one association to Restaurant
	@OneToMany(mappedBy="restaurant")
	private List<Restaurant> restaurants;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="OWNER_ID")
	private User user;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="restaurant")
	private List<User> users;

	public Restaurant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostal() {
		return this.postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getRestName() {
		return this.restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTinNum() {
		return this.tinNum;
	}

	public void setTinNum(String tinNum) {
		this.tinNum = tinNum;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setRestaurant(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setRestaurant(null);

		return customer;
	}

	public List<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public Delivery addDelivery(Delivery delivery) {
		getDeliveries().add(delivery);
		delivery.setRestaurant(this);

		return delivery;
	}

	public Delivery removeDelivery(Delivery delivery) {
		getDeliveries().remove(delivery);
		delivery.setRestaurant(null);

		return delivery;
	}

	public List<DiningTable> getDiningTables() {
		return this.diningTables;
	}

	public void setDiningTables(List<DiningTable> diningTables) {
		this.diningTables = diningTables;
	}

	public DiningTable addDiningTable(DiningTable diningTable) {
		getDiningTables().add(diningTable);
		diningTable.setRestaurant(this);

		return diningTable;
	}

	public DiningTable removeDiningTable(DiningTable diningTable) {
		getDiningTables().remove(diningTable);
		diningTable.setRestaurant(null);

		return diningTable;
	}

	public List<InputImage> getInputImages() {
		return this.inputImages;
	}

	public void setInputImages(List<InputImage> inputImages) {
		this.inputImages = inputImages;
	}

	public InputImage addInputImage(InputImage inputImage) {
		getInputImages().add(inputImage);
		inputImage.setRestaurant(this);

		return inputImage;
	}

	public InputImage removeInputImage(InputImage inputImage) {
		getInputImages().remove(inputImage);
		inputImage.setRestaurant(null);

		return inputImage;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setRestaurant(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setRestaurant(null);

		return order;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setRestaurant(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setRestaurant(null);

		return payment;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setRestaurant(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setRestaurant(null);

		return product;
	}

	public List<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public Property addProperty(Property property) {
		getProperties().add(property);
		property.setRestaurant(this);

		return property;
	}

	public Property removeProperty(Property property) {
		getProperties().remove(property);
		property.setRestaurant(null);

		return property;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Restaurant> getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		getRestaurants().add(restaurant);
		restaurant.setRestaurant(this);

		return restaurant;
	}

	public Restaurant removeRestaurant(Restaurant restaurant) {
		getRestaurants().remove(restaurant);
		restaurant.setRestaurant(null);

		return restaurant;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRestaurant(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRestaurant(null);

		return user;
	}

}