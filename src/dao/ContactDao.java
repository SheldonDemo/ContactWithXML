package dao;

import java.util.List;

import entity.Contact;

public interface ContactDao {

	public void addContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContactById(String id);
	public List<Contact> findAllContact();
	public Contact findById(String id);
	public boolean isExistByName(String name);
	
}
