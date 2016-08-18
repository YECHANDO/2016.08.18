/**
 * licecse.. etc
 */
package kr.co.kosta.contact.service;

import java.util.List;

import kr.co.kosta.contact.model.Contact;

/**
 *
 * @author kim
 * @version
 *
 */
public interface ContactService {

	/**
	 * 연락처 등록하기
	 * @param contact 서버에서 수정했어요
	 */
	void registContact(Contact contact);
	
	/**
	 * 연락처 전체보기
	 * @return
	 */
	List<Contact> listContact();
	
	/**
	 * 연락처 상세보기
	 * @param name
	 * @return
	 */
	Contact detailContact(String name);
	
	/**
	 * 연락처 삭제
	 * @param name
	 */
	void removeContact(String name);
}
