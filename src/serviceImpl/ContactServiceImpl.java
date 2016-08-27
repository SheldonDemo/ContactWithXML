package serviceImpl;

import java.util.List;

import dao.ContactDao;
import daoImpl.ContactDaoImpl;
import entity.Contact;
import exception.AgeInputException;
import exception.EmailInputException;
import exception.GenderNullException;
import exception.NameInputException;
import exception.NameNullException;
import exception.NameRepeatException;
import exception.QqInputException;
import service.ContactService;

public  class ContactServiceImpl implements ContactService {

	ContactDao dao = new ContactDaoImpl();
	public void addContact(Contact contact) throws NameRepeatException, NameNullException, NameInputException, AgeInputException, EmailInputException, QqInputException, GenderNullException {

		
				
		if(dao.isExistByName(contact.getName())){
		
				throw new NameRepeatException("联系人已存在");
			
		}
		if(contact.getName().equals("")){
			 throw new NameNullException("姓名不能为空");
		}
		if(!contact.getName().matches("^[\u4e00-\u9fa5]{0,}$")&&!contact.getName().equals("")){
			throw new NameInputException("姓名格式错误");
		}
		if(contact.getGender()==null){
			throw new GenderNullException("性别不能为空");
		}
		if(!contact.getAge().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$")&&!contact.getAge().equals("")){
			throw new AgeInputException("年龄格式错误");
		}
		if(!contact.getEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$")&&!contact.getEmail().equals("")){
			throw new EmailInputException("邮箱格式错误");
		}
		if(!contact.getQq().matches("[1-9][0-9]{4,}")&&!contact.getQq().equals("")){
			throw new QqInputException("QQ格式错误");
		}
		
		dao.addContact(contact);
	}

	@Override
	public void updateContact(Contact contact) throws NameRepeatException, NameNullException, NameInputException, AgeInputException, EmailInputException, QqInputException, GenderNullException {

		
		String id = contact.getId();
		Contact checkContact = dao.findById(id);
		String checkName = checkContact.getName();
				
		if(dao.isExistByName(contact.getName())&&(!contact.getName().equals(checkName))){
		
				throw new NameRepeatException("联系人已存在");
			
		}
		if(contact.getName().equals("")){
			 throw new NameNullException("姓名不能为空");
		}
		if(!contact.getName().matches("^[\u4e00-\u9fa5]{0,}$")&&!contact.getName().equals("")){
			throw new NameInputException("姓名格式错误");
		}
		if(contact.getGender()==null){
			throw new GenderNullException("性别不能为空");
		}
		if(!contact.getAge().matches("^(?:[1-9][0-9]?|1[01][0-9]|120)$")&&!contact.getAge().equals("")){
			throw new AgeInputException("年龄格式错误");
		}
		if(!contact.getEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$")&&!contact.getEmail().equals("")){
			throw new EmailInputException("邮箱格式错误");
		}
		if(!contact.getQq().matches("[1-9][0-9]{4,}")&&!contact.getQq().equals("")){
			throw new QqInputException("QQ格式错误");
		}
			
			dao.updateContact(contact);
		
	}

	@Override
	public void deleteContactById(String id) {
		dao.deleteContactById(id);
	}

	@Override
	public List<Contact> findAllContact() {
		return dao.findAllContact();
	}

	@Override
	public Contact findById(String id) {
		
		return dao.findById(id);
	}


}
