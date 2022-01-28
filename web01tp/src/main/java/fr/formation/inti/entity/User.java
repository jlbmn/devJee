package fr.formation.inti.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer userId;
	private String login;
	private String password;
	@OneToOne
	@JoinColumn(name = "emp_id", nullable = false) // nullable=false fait un inner join
	private Employee emp;
	@Column(name = "connection_number")
	private Integer connectionNumber;

	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}


	public Integer getConnectionNumber() {
		return connectionNumber;
	}


	public void setConnectionNumber(Integer connectionNumber) {
		this.connectionNumber = connectionNumber;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", login=" + login + "]";
	}
	
	
	
	

}
