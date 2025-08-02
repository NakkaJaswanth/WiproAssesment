package com.example.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

import com.example.hibernate.model.Item;

public class ItemDAO {
	 private SessionFactory factory;

	    public ItemDAO() {
	        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    }

	    
	    public void addItem(Item item) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(item);  // INSERT INTO items VALUES (...)
	        tx.commit();
	        session.close();
	    }

	    
	    public boolean updateItem(Item item) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Item existing = (Item) session.get(Item.class, item.getId());
	        if (existing != null) {
	            existing.setName(item.getName());
	            existing.setPrice(item.getPrice());

	            session.update(existing);  
	            tx.commit();
	            session.close();
	            return true;
	        } else {
	            session.close();
	            return false;
	        }
	    }

	    
	    public boolean deleteItem(int id) {
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        Item item = (Item) session.get(Item.class, id);
	        if (item != null) {
	            session.delete(item); 
	            tx.commit();
	            session.close();
	            return true;
	        } else {
	            session.close();
	            return false;
	        }
	    }

	    
	    public Item getItem(int id) {
	        Session session = factory.openSession();
	        Item item = (Item) session.get(Item.class, id);
	        session.close();
	        return item;
	    }

	    
	    public List<Item> getAllItems() {
	        Session session = factory.openSession();
	        List<Item> list = session.createQuery("from Item").list();
	        session.close();
	        return list;
	    }

}
