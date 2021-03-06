package dev.granville.beans;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement_status")
public class RequestStatus {

	@Id
	@Column(name = "status_id")
	private int statusId;
	@Column(name = "status_name")
	private String statusName;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
