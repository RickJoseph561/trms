package dev.granville.beans;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name="department")
public class Department {

    @Id
    @GeneratedValue()
    @Column(name="department_id")
    private Integer departmentId;
    @Column(name="department_name")
    private String departmentName;
    /*
    @OneToMany
    @Transient
    private List<Employee> departmentEmployees;


    public List<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(List<Employee> employees) {
        this.departmentEmployees = employees;
    }

     */
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer id) {
        this.departmentId = id;
    }
}
