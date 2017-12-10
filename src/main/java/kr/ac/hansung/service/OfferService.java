package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	private OfferDAO offerDAO;
	
	/* 상세보기 */
	public List<Offer> getDetails(int year, int semester) {
		return offerDAO.getDetails(year, semester);
	}
	
	/* 학기별 학점 */
	public int getCredit(int year, int semester) {
		return offerDAO.getCredit(year, semester);
	}
	
	/* 이수별 학점 */
	public int getSeperation(String seperation) {
		return offerDAO.getSeperation(seperation);
	}
	
	/* 총학점 */
	public int getTotalCredit() {
		return offerDAO.getTotalCredit();
	}
	
	/* 수강 신청 */
	public void insert(Offer offer) {
		offerDAO.insert(offer);
	}

}
