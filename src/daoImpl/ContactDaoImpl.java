package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.Element;


import dao.ContactDao;
import entity.Contact;
import util.XMLUtil;

public class ContactDaoImpl implements ContactDao {

	@Override
	public void addContact(Contact contact) {

		try {
			Document doc = XMLUtil.read();
			Element rootElement = doc.getRootElement();
			Element contactElement = rootElement.addElement("contact");
			String uuid = UUID.randomUUID().toString().replace("-","");
			contactElement.addAttribute("id", uuid);
			contactElement.addElement("name").setText(contact.getName());
			contactElement.addElement("age").setText(contact.getAge());
			contactElement.addElement("gender").setText(contact.getGender());
			contactElement.addElement("email").setText(contact.getEmail());
			contactElement.addElement("qq").setText(contact.getQq());

			XMLUtil.write(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateContact(Contact contact) {

		try {
			Document doc = XMLUtil.read();
			Element contactElement = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			contactElement.element("name").setText(contact.getName());
			contactElement.element("age").setText(contact.getAge());
			contactElement.element("gender").setText(contact.getGender());
			contactElement.element("email").setText(contact.getEmail());
			contactElement.element("qq").setText(contact.getQq());

			XMLUtil.write(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteContactById(String id) {

		try {
			Document doc = XMLUtil.read();
			Element contactElement = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
			contactElement.detach();
			XMLUtil.write(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Contact> findAllContact() {
		try {
			Document doc = XMLUtil.read();
			@SuppressWarnings("unchecked")
			List<Element> contactListElement = (List<Element>)doc.selectNodes("//contact");
			List<Contact> list = new ArrayList<Contact>();
			for (Element element : contactListElement) {
				Contact contact = new Contact();
				contact.setAge(element.elementText("age"));
				contact.setName(element.elementText("name"));
				contact.setQq(element.elementText("qq"));
				contact.setGender(element.elementText("gender"));
				contact.setEmail(element.elementText("email"));
				contact.setId(element.attributeValue("id"));
				list.add(contact);		
				}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isExistByName(String name) {
		
		try {
			Document doc = XMLUtil.read();
			Element contactElement = (Element)doc.selectSingleNode("//name[text()='"+name+"']");

			if(contactElement!=null){
				return true;
			}else{
			return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Contact findById(String id) {

		try {
			Document doc = XMLUtil.read();
			Element contactElement = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");

			Contact contact = new Contact();
			contact.setId(contactElement.attributeValue("id"));
			contact.setAge(contactElement.elementText("age"));
			contact.setName(contactElement.elementText("name"));
			contact.setQq(contactElement.elementText("qq"));
			contact.setEmail(contactElement.elementText("email"));
			contact.setGender(contactElement.elementText("gender"));
				
			return contact;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
