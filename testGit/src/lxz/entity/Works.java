package lxz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "works")
public class Works {
	/**
	 * 作品id
	 */
	@Id
	@GenericGenerator(name = "works_id", strategy = "uuid")
	@GeneratedValue(generator = "works_id")
	@Column(name = "works_id", unique = true, nullable = false, length = 32, updatable = true)
	private String works_id;

	/**
	 * 作品发布者user_id
	 */
	@ManyToOne(fetch = FetchType.LAZY) /*
										 * ManyToOne指定了多对一的关系，fetch=FetchType.
										 * LAZY属性表示在多的那一方通过延迟加载的方式加载对象(默认不是延迟加载)
										 */
	@JoinColumn(name = "user_id") /*
									 * 通过 JoinColumn 的name属性指定了外键的名称 user_id
									 * (注意：如果我们不通过JoinColum来指定外键的名称，
									 * 系统会给我们声明一个名称)
									 */
	private User user;
	/**
	 * 作品创建时间
	 */
	@Column(name = "works_createtime", nullable = false, length = 10, updatable = true)
	private String works_createtime;
	/**
	 * 作品是否被审核 0:未被审核； 1：已审核
	 */
	@Column(name = "works_is_audit", length = 1, nullable = false, updatable = true)
	private String works_is_audit;
	/**
	 * 作品状态 0：未通过（还需审核）； 1：已通过；2：已删除
	 */
	@Column(name = "works_state", length = 1, nullable = false, updatable = true)
	private String works_state;
	/**
	 * 作品内容
	 */
	@Column(name = "works_content", columnDefinition = "text", nullable = false, updatable = true)
	private String works_content;
	/**
	 * 作品标图路径
	 */
	@Column(name = "works_picpath", length = 50, nullable = false, updatable = true)
	private String works_picpath;
	/**
	 * 作品标签
	 */
	@Column(name = "works_label", length = 50, nullable = false, updatable = true)
	private String works_label;
	/**
	 * 作品点赞数量
	 */
	@Column(name = "works_praisenumber", nullable = false, updatable = true)
	private int works_praisenumber;

	public String getWorks_id() {
		return works_id;
	}

	public void setWorks_id(String works_id) {
		this.works_id = works_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getWorks_createtime() {
		return works_createtime;
	}

	public void setWorks_createtime(String works_createtime) {
		this.works_createtime = works_createtime;
	}

	public String getWorks_is_audit() {
		return works_is_audit;
	}

	public void setWorks_is_audit(String works_is_audit) {
		this.works_is_audit = works_is_audit;
	}

	public String getWorks_state() {
		return works_state;
	}

	public void setWorks_state(String works_state) {
		this.works_state = works_state;
	}

	public String getWorks_content() {
		return works_content;
	}

	public void setWorks_content(String works_content) {
		this.works_content = works_content;
	}

	public String getWorks_picpath() {
		return works_picpath;
	}

	public void setWorks_picpath(String works_picpath) {
		this.works_picpath = works_picpath;
	}

	public String getWorks_label() {
		return works_label;
	}

	public void setWorks_label(String works_label) {
		this.works_label = works_label;
	}

	public int getWorks_praisenumber() {
		return works_praisenumber;
	}

	public void setWorks_praisenumber(int works_praisenumber) {
		this.works_praisenumber = works_praisenumber;
	}

}
