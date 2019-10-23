package Model;

/**
 * TAccountType entity. @author MyEclipse Persistence Tools
 */

public class TAccountType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String paytype;

	// Constructors

	/** default constructor */
	public TAccountType() {
	}

	/** full constructor */
	public TAccountType(String paytype) {
		this.paytype = paytype;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

}