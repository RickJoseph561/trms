package dev.granville.beans;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee implements Comparable<Employee> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Integer employeeId;

	@ManyToOne
	@JoinColumn(name="employee_rank")
	private EmployeeRank rank;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_reportsto")
	private Employee reportsTo;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	@Column(name="address")
	private String address;

	@Column(name="username")
	private String username;

	@Column(name="userpassword")
	private String password;

	@ManyToOne
	@JoinColumn(name="employee_department_id")
	private Department department;

	@Column(name="employee_funds")
	private Double aid = 0.0;

	public void addAid(Double aid) {
		double newAid = this.aid + aid;
		if (newAid > 1000.0) {
			newAid = 1000.0;
		} else if (newAid < this.aid) {
			newAid = this.aid;
		} else if (newAid < 0.0) {
			newAid = 0.0;
		}
		this.aid = newAid;
	}

	public Double getAid() {
		return aid;
	}
	public Department getDepartment() {
		return department;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public EmployeeRank getRank() {
		return rank;
	}
	public Employee getReportsTo() {
		return reportsTo;
	}
	public void setAid (Double aid) {
		this.aid = aid;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public void setRank(EmployeeRank rank) {
		this.rank = rank;
	}
	public void setReportsTo(Employee reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passWord) {
		this.password = passWord;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getAddress() {
		return address;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	@Override
	public int compareTo(@org.jetbrains.annotations.NotNull Employee e) {
		if (this.getEmployeeId() < e.getEmployeeId()) {
			return -1;
		} else {
			return 1;
		}
	}
}
