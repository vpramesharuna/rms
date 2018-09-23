package restpick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the OPTIONS_LOOKUP database table.
 * 
 */
@Entity
@Table(name="OPTIONS_LOOKUP")
@NamedQuery(name="OptionsLookup.findAll", query="SELECT o FROM OptionsLookup o")
public class OptionsLookup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="ITEM_VAL")
	private String itemVal;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED")
	private Date lastUpdated;

	@Column(name="OPTIONS_IMAGE")
	private String optionsImage;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to OptionsKey
	@ManyToOne
	@JoinColumn(name="OPTIONS_KEY_ID")
	private OptionsKey optionsKey;

	public OptionsLookup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getItemVal() {
		return this.itemVal;
	}

	public void setItemVal(String itemVal) {
		this.itemVal = itemVal;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getOptionsImage() {
		return this.optionsImage;
	}

	public void setOptionsImage(String optionsImage) {
		this.optionsImage = optionsImage;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public OptionsKey getOptionsKey() {
		return this.optionsKey;
	}

	public void setOptionsKey(OptionsKey optionsKey) {
		this.optionsKey = optionsKey;
	}

}