package rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import rest.dao.ContactDAO;
import rest.dao.ContactDAOImpl;
import rest.model.Contact;

public class ContactServiceImpl implements ContactService{

    ContactDAO dao = new ContactDAOImpl(getDataSource());    
    
    public List<Contact> getContactList() {
        
    	List<Contact> listContact = new ArrayList<Contact>();

    	listContact = dao.list();
        
        return listContact;
    }

	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/starterlab");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
    
}
