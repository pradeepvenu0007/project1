package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name="employee")
public class employeeEntity {
@Override
	public String toString() {
		return "employeeEntity [mobile=" + mobile + ", department=" + department + ", designation=" + designation
				+ ", name=" + name + ", email=" + email + ", password=" + password + ", type=" + type + ", address="
				+ address + "]";
	}
//@NaturalId
//@Column(name = "id",unique=true)
//@GeneratedValue(strategy=GenerationType.IDENTITY)
//private int id;

@Id
@Column(name = "email",unique=true)
private String email;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "department")
	private String department;
	@Column(name = "designation")
	private String designation;
	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;
	@Column(name = "type")
	private String type;
	@Column(name="address")
	private String address;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
