package kr.co.kosta.contact.service.impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import kr.co.kosta.contact.model.Contact;
import kr.co.kosta.contact.service.ContactService;

public class FileContactService implements ContactService {

	@Override
	public void registContact(Contact contact) {
		
		String name  = contact.getName();
		String email = contact.getEmail();
		int age      = contact.getAge();
		String addr  = contact.getAddr();
		
		try (BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("contact.txt"), "UTF-8"))) {
			
			bw.write(name + " " + email + " " + age + " " + addr);
			bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("contact regist ok..");
	}

	@Override
	public List<Contact> listContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact detailContact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContact(String name) {
		// TODO Auto-generated method stub
		
	}
}
