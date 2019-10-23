package Model;


/**
 * VAccount entity. @author MyEclipse Persistence Tools
 */

public class VAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer accounttype;
	private Double money;
	private String createtime;
	private String time;
	private Integer pay;
	private String remark;
	private String paytype;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public VAccount() {
	}

	/** minimal constructor */
	public VAccount(Integer id, Integer userid, Integer accounttype,
			Double money, String createtime, String time, Integer pay,
			String paytype, String username, String password) {
		this.id = id;
		this.userid = userid;
		this.accounttype = accounttype;
		this.money = money;
		this.createtime = createtime;
		this.time = time;
		this.pay = pay;
		this.paytype = paytype;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public VAccount(Integer id, Integer userid, Integer accounttype,
			Double money, String createtime, String time, Integer pay,
			String remark, String paytype, String username, String password) {
		this.id = id;
		this.userid = userid;
		this.accounttype = accounttype;
		this.money = money;
		this.createtime = createtime;
		this.time = time;
		this.pay = pay;
		this.remark = remark;
		this.paytype = paytype;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(Integer accounttype) {
		this.accounttype = accounttype;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getPay() {
		return this.pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}