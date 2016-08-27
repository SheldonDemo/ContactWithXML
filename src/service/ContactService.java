package service;

import java.util.List;

import entity.Contact;
import exception.AgeInputException;
import exception.EmailInputException;
import exception.GenderNullException;
import exception.NameInputException;
import exception.NameNullException;
import exception.NameRepeatException;
import exception.QqInputException;

public interface ContactService {

	public void addContact(Contact contact) throws NameRepeatException, NameNullException, NameInputException,  EmailInputException, QqInputException, AgeInputException, GenderNullException;
	public void updateContact(Contact contact) throws NameRepeatException, NameNullException, NameInputException,  EmailInputException, QqInputException, AgeInputException, GenderNullException;
	public void deleteContactById(String id);
	public List<Contact> findAllContact();
	public Contact findById(String id);
	
}
