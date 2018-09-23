package restpick.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the OPTIONS_KEY database table.
 * 
 */
@Entity
@Table(name="OPTIONS_KEY")
@NamedQuery(name="OptionsKey.findAll", query="SELECT o FROM OptionsKey o")
public class OptionsKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="KEY_NAME")
	private String keyName;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED")
	private Date lastUpdated;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to OptionsLookup
	@OneToMany(mappedBy="optionsKey")
	private List<OptionsLookup> optionsLookups;

	public OptionsKey() {
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

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<OptionsLookup> getOptionsLookups() {
		return this.optionsLookups;
	}

	public void setOptionsLookups(List<OptionsLookup> optionsLookups) {
		this.optionsLookups = optionsLookups;
	}

	public OptionsLookup addOptionsLookup(OptionsLookup optionsLookup) {
		getOptionsLookups().add(optionsLookup);
		optionsLookup.setOptionsKey(this);

		return optionsLookup;
	}

	public OptionsLookup removeOptionsLookup(OptionsLookup optionsLookup) {
		getOptionsLookups().remove(optionsLookup);
		optionsLookup.setOptionsKey(null);

		return optionsLookup;
	}

}