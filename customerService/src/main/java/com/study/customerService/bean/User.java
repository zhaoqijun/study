package com.study.customerService.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name = "t_user")
public class User extends BaseEntity{

    @Column(name = "name")
    protected String name;
    
    @Column(name = "createtime")
    protected Timestamp createTime;

    public String getName() {
        return name;
    }
    
	public void setName(String name) {
        this.name = name;
    }
 
    public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
    
	@Override
	public String toString() {
		return "User [name=" + name + ", createTime=" + createTime + ", id=" + id + "]";
	}
}