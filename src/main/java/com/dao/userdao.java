package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.model.usermodel;
@Repository
@Component
public class userdao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void insertuser(usermodel u) {
		this.hibernateTemplate.saveOrUpdate(u);
	}
	@Transactional
	 public void deleteuser(usermodel u) {
		this.hibernateTemplate.delete(u);
	}
	public usermodel getuserbyid(int id) {
		return hibernateTemplate.get(usermodel.class, id);
	}
	public List<usermodel>getalluser(){
		List<usermodel>list = this.hibernateTemplate.loadAll(usermodel.class);
		return list;
	}
}
