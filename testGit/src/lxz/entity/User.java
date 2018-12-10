package lxz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User {

	/**
	 * 用户id
	 */
	@Id
	@GenericGenerator(name = "user_id", strategy = "uuid")
	@GeneratedValue(generator = "user_id")
	@Column(name = "user_id", unique = true, nullable = false, length = 32, updatable = true)

	/*
	 * @GeneratedValue(generator = "user_id") columnDefinition="char(2)"
	 * 
	 * @GenericGenerator(name = "user_id", strategy = "native")
	 */
	private String user_id;
	/**
	 * 用户昵称
	 */
	@Column(name = "user_name", length = 50, unique = true, nullable = false, updatable = true)
	private String user_name;
	/**
	 * 用户性别
	 */
	@Column(name = "user_gender", length = 2, updatable = true)
	private String user_gender;
	/**
	 * 用户手机号码
	 */
	@Column(name = "user_phone", unique = true, nullable = false, length = 11, updatable = true)
	private String user_phone;
	/**
	 * 用户出生年月日
	 */
	@Column(name = "user_birthday", length = 10, updatable = true)
	private String user_birthday;
	/**
	 * 用户身份(0,1) 0:用户 1:管理员（可访问两个）2:超级管理员（人员管理）
	 */
	@Column(name = "user_type", length = 1, nullable = false, updatable = true)
	private String user_type;
	/**
	 * 用户密码
	 */
	@Column(name = "user_password", length = 18, nullable = false, updatable = true)
	private String user_password;
	/**
	 * 用户个性签名
	 */
	@Column(name = "user_description", length = 50, updatable = true)
	private String user_description;
	/**
	 * 用户头像路径
	 */
	@Column(name = "user_picpath", length = 50, updatable = true)
	private String user_picpath;
	/**
	 * 用户状态(0,1) 0:已删除 1:正常状态
	 */
	@Column(name = "user_state", length = 1, nullable = false, updatable = true)
	private String user_state;
	/**
	 * 用户邮箱
	 */
	@Column(name = "user_email", unique = true, nullable = false, length = 50, updatable = true)
	private String user_email;
	/**
	 * 重复密码
	 */
	private String repassword;

	/*
	 * @OneToMany(mappedBy = "User") OneToMany指定了一对多的关系，mappedBy=
	 * "room"指定了由多的那一方来维护关联关系， mappedBy指的是多的一方对1的这一方的依赖的属性，(注意：
	 * 如果没有指定由谁来维护关联关系，则系统会给我们创建一张中间表)
	 * 
	 * @LazyCollection(LazyCollectionOption.EXTRA)
	 * LazyCollection属性设置成EXTRA指定了当如果查询数据的个数时候 ，只会发出一条 count(*)的语句，提高性能
	 * 
	 * private Set<Works> works;
	 */

	/*
	 * public Set<Works> getWorks() { return works;
	 * 
	 * }
	 */
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_description() {
		return user_description;
	}

	public void setUser_description(String user_description) {
		this.user_description = user_description;
	}

	public String getUser_picpath() {
		return user_picpath;
	}

	public void setUser_picpath(String user_picpath) {
		this.user_picpath = user_picpath;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_gender=" + user_gender
				+ ", user_phone=" + user_phone + ", user_birthday=" + user_birthday + ", user_type=" + user_type
				+ ", user_password=" + user_password + ", user_description=" + user_description + ", user_picpath="
				+ user_picpath + ", user_state=" + user_state + ", user_email=" + user_email + "]";
	}

}
