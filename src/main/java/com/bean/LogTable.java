package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Logtable")
public class LogTable {
	@Id
	@Column(name = "Log_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "Operation")
	private String operation;
	@Column(name = "Date")
	private String date;
	@Column(name = "Time")
	private String time;

	public LogTable(String operation, String date, String time) {
		super();
		this.operation = operation;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LogTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LogTable [Id=" + Id + ", operation=" + operation + ", date=" + date + ", time=" + time + "]";
	}

}
