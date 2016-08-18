package kr.co.kosta.contact.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.co.kosta.contact.model.Contact;
import kr.co.kosta.contact.service.ContactService;
import kr.co.kosta.contact.service.impl.FileContactService;

public class ContactView {

	public void run() throws IOException {
		String choice = "";
		do {
			printMainMenu();
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			
			choice = br.readLine();
			
			if (choice.startsWith("1")) {
				//System.out.println("1번을 눌렀습니다.");
				Contact contact = makeContactFromUserInput();
				//
				ContactService service = new FileContactService();
				service.registContact(contact);
				
			}
			else if (choice.startsWith("2")) {
				System.out.println("2번을 눌렀습니다.");
			}
			else if (choice.trim().toUpperCase().startsWith("Q")) {
				System.out.println("감사합니다. 다음에 또 만나요.");
				break;
			}
			else {
				System.out.println("잘못눌렀습니다. 다시 선택해 주세요.");
			}
			
		} while (true);
		
	}

	private Contact makeContactFromUserInput() throws IOException {
		System.out.print("이름 이메일 나이 주소를 각각 세미콜론(;)으로 구분해서 입력해 주세요>");
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String inputFromUser = br.readLine();
		// 김순곤; soongon@gmail.com;45;서울
		
		String[] spliitedData = inputFromUser.split(";");
		//데이터를 가지고 Contact 객체를 생성
		Contact contact = new Contact();
		contact.setName(spliitedData[0]);
		contact.setEmail(spliitedData[1]);
		contact.setAge(Integer.parseInt(spliitedData[2]));
		contact.setAddr(spliitedData[3]);
		
		return contact;
	}

	private void printMainMenu() {
		System.out.println("=======================");
		System.out.println("1. register contact");
		System.out.println("2. view all contacts");
		System.out.println("Q. quit app");
		System.out.println("=======================");
		System.out.print("choice>");
	}
}
