package dev.granville.beans;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="reimbursement_request")
public class ReimbursementRequest implements Comparable<ReimbursementRequest> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reimbursement_Id")
	private Integer reimbursementId;

	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name="reviewer_id")
	private Employee reviewer;

	@ManyToOne
	@JoinColumn(name="request_status")
	private RequestStatus reimbursementStatus;

	@ManyToOne
	@JoinColumn(name="request_eventid")
	private ReimbursementEventType reimbursementEventType;

	@Column(name="request_cost")
	private Double reimbursementCost;

	@Column(name="request_date")
	private LocalDate reimbursementDate;

	@Column(name="request_location")
	private String reimbursementLocation;

	@Column(name="request_timestamp")
	private Timestamp reimbursementTimeStamp;

	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	@Column(name="timeoff")
	private LocalDateTime timeoffStart;

	@Column(name="timeoff_ends")
	private LocalDateTime timeoffEnd;

	@ManyToOne
	@JoinColumn(name="urgencyId")
	private Urgency urgency;

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	@Column(name="attachment")
	private File attachment;

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name="notes")
	private String notes;

	public Urgency getUrgency() {
		return urgency;
	}

	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}

	public void setReimbursementTimeStamp(Timestamp reimbursementTimeStamp) {
		this.reimbursementTimeStamp = reimbursementTimeStamp;
	}

	public double coveredCost() {
		double pending = 0.0;
		switch (reimbursementEventType.getEventId()) {
			case 1:
				pending = (reimbursementCost) * .8;
				break;
			case 2:
				pending = (reimbursementCost) * .6;
				break;
			case 3:
				pending = (reimbursementCost) * .75;
				break;
			case 4:
				pending = (reimbursementCost) * 1.0;
				break;
			case 5:
				pending = (reimbursementCost) * .9;
				break;
			default:
				pending = (reimbursementCost) * .3;
				break;
		}
		if (pending < 0.0) {
			pending = 0.0;
		} else if (pending > 1000.0) {
			pending = 1000.0;
		}
		return pending;
	}

	public Department getDepartment() {
		return department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Double getReimbursementCost() {
		return reimbursementCost;
	}

	public LocalDate getReimbursementDate() {
		return reimbursementDate;
	}

	public ReimbursementEventType getReimbursementEventType() {
		return reimbursementEventType;
	}

	public Integer getReimbursementId() {
		return reimbursementId;
	}

	public String getReimbursementLocation() {
		return reimbursementLocation;
	}

	public RequestStatus getReimbursementStatus() {
		return reimbursementStatus;
	}

	public Timestamp getReimbursementTimeStamp() {
		return reimbursementTimeStamp;
	}

	public LocalDateTime getTimeoffEnd() {
		return timeoffEnd;
	}

	public LocalDateTime getTimeoffStart() {
		return timeoffStart;
	}

	public void setDepartment(Department departmentName) {
		this.department = departmentName;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setReimbursementCost(Double reimbursementCost) {
		this.reimbursementCost = reimbursementCost;
	}

	public void setReimbursementDate(LocalDate reimbursementDate) {
		this.reimbursementDate = reimbursementDate;
	}

	public void setReimbursementEventType(ReimbursementEventType reimbursementEventType) {
		this.reimbursementEventType = reimbursementEventType;
	}

	public void setReimbursementId(Integer id) {
		this.reimbursementId = id;
	}

	public void setReimbursementLocation(String reimbursementLocation) {
		this.reimbursementLocation = reimbursementLocation;
	}

	public void setReimbursementStatus(RequestStatus reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public void setTimeoffEnd(LocalDateTime timeoffEnd) {
		this.timeoffEnd = timeoffEnd;
	}

	public void setTimeoffStart(LocalDateTime timeoffStart) {
		this.timeoffStart = timeoffStart;
	}

	public boolean updateStatus(Integer approval) {
		switch (approval) {
			case 0:
				//Rejected
				if (reimbursementStatus.getStatusId() == 0) {
					return false;
				}
				reimbursementStatus.setStatusId(0);
				return true;
			case 1:
				//Supervisor Approval
				if (reimbursementStatus.getStatusId() == 1) {
					return false;
				}
				reimbursementStatus.setStatusId(1);
				return true;
			case 2:
				//Department Head Approval
				if (reimbursementStatus.getStatusId() == 2) {
					return false;
				}
				reimbursementStatus.setStatusId(2);
				return true;
			case 3:
				//BenCo Approval
				if (reimbursementStatus.getStatusId() == 3) {
					return false;
				}
				reimbursementStatus.setStatusId(3);
				return true;
			case 4:
				//Accepted
				if (reimbursementStatus.getStatusId() == 4) {
					return false;
				}
				reimbursementStatus.setStatusId(4);
				return true;
			default:
				reimbursementStatus.setStatusId(0);
				return false;
		}
	}

	public Employee getReviewer() {
		return reviewer;
	}

	public void setReviewer(Employee reviewer) {
		this.reviewer = reviewer;
	}

	@Override
	public int compareTo(@NotNull ReimbursementRequest o) {
		if (this.urgency.getUrgencyId() > o.urgency.getUrgencyId()) {
			return -1;
		} else {
			if (this.employee.getEmployeeId() < o.employee.getEmployeeId()) {
				return -1;
			}
			return 1;
		}
	}
}
