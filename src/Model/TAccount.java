package Model;


/**
 * TAccount entity. @author MyEclipse Persistence Tools
 */

public class TAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer accounttype;
	private Double money;
	private String createtime;
	private String time;
	private Integer pay;
	private String remark;

	// Constructors

	/** default constructor */
	public TAccount() {
	}

	/** minimal constructor */
	public TAccount(Integer userid, Integer accounttype, Double money,
			String createtime, String time, Integer pay) {
		this.userid = userid;
		this.accounttype = accounttype;
		this.money = money;
		this.createtime = createtime;
		this.time = time;
		this.pay = pay;
	}

	/** full constructor */
	public TAccount(Integer userid, Integer accounttype, Double money,
			String createtime, String time, Integer pay, String remark) {
		this.userid = userid;
		this.accounttype = accounttype;
		this.money = money;
		this.createtime = createtime;
		this.time = time;
		this.pay = pay;
		this.remark = remark;
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

}