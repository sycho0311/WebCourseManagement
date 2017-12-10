package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.model.Seperation;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	/* 상세보기 */
	@RequestMapping(value = "/linkDetail", method = RequestMethod.GET)
	public String showDetail(@RequestParam("year") int year, @RequestParam("semester") int semester, Model model) {
		List<Offer> offers = offerService.getDetails(year, semester);
		model.addAttribute("offers", offers);

		return "linkDetail";
	}

	/* 이수 구분별 학점 조회 */
	@RequestMapping("/seperationInquiry")
	public String showSeperation(Model model) {
		Seperation seperation = new Seperation();
		int s1 = offerService.getSeperation("교필");
		seperation.setS1(s1);

		int s2 = offerService.getSeperation("핵교A");
		seperation.setS2(s2);

		int s3 = offerService.getSeperation("핵교B");
		seperation.setS3(s3);

		int s4 = offerService.getSeperation("전지");
		seperation.setS4(s4);

		int s5 = offerService.getSeperation("전기");
		seperation.setS5(s5);

		int s6 = offerService.getSeperation("전선");
		seperation.setS6(s6);

		int s7 = offerService.getSeperation("자율");
		seperation.setS7(s7);

		int s8 = offerService.getTotalCredit();
		seperation.setS8(s8);

		model.addAttribute("seperation", seperation);

		return "seperationInquiry";
	}

	/* 학기별 학점 조회 */
	@RequestMapping("/semesterInquiry")
	public String showSemester(Model model) {
		List<Offer> offers = new ArrayList();

		Offer offer[] = new Offer[6];

		for (int i = 0; i < 6; i++) {
			offer[i] = new Offer();
		}

		int credit = offerService.getCredit(2012, 1);
		offer[0].setCredit(credit);
		offer[0].setYear(2012);
		offer[0].setSemester(1);

		credit = offerService.getCredit(2014, 2);
		offer[1].setCredit(credit);
		offer[1].setYear(2014);
		offer[1].setSemester(2);

		credit = offerService.getCredit(2016, 1);
		offer[2].setCredit(credit);
		offer[2].setYear(2016);
		offer[2].setSemester(1);

		credit = offerService.getCredit(2016, 2);
		offer[3].setCredit(credit);
		offer[3].setYear(2016);
		offer[3].setSemester(2);

		credit = offerService.getCredit(2017, 1);
		offer[4].setCredit(credit);
		offer[4].setYear(2017);
		offer[4].setSemester(1);

		credit = offerService.getCredit(2017, 2);
		offer[5].setCredit(credit);
		offer[5].setYear(2017);
		offer[5].setSemester(2);

		for (int i = 0; i < 6; i++) {
			offers.add(offer[i]);
		}

		model.addAttribute("offers", offers);

		return "semesterInquiry";
	}

	/* 수강 신청 */
	@RequestMapping("/applicationClass")
	public String applicationClass(Model model) {

		model.addAttribute("offer", new Offer());

		return "applicationClass";
	}

	/* 수강 신청 생성 */
	@RequestMapping("/createClass")
	public String createClass(Model model, @Valid Offer offer, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "applicationClass";
		}

		offerService.insert(offer);

		model.addAttribute("offer", offer);

		return "createClass";
	}

	/* 수강신청 완료 */
	@RequestMapping("/createdClass")
	public String createdClass(Model model, @Valid Offer offer, BindingResult result) {
		List<Offer> offers = offerService.getDetails(2018, 1);
		model.addAttribute("offers", offers);

		return "createdClass";
	}

}
