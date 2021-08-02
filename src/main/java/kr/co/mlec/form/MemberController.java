package kr.co.mlec.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")  //공통적은 경로를 위로 뺌.
public class MemberController {
		
	@RequestMapping("/joinForm.do")
	public String joinForm() {
	return "form/joinForm"; 
	}
	
	@RequestMapping("/join.do")
	public String join(HttpServletRequest request, @RequestParam("id")String id, @RequestParam String password, @RequestParam String name) {
		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
	request.setAttribute("member", member); //꼭 모델엔뷰로 안해ㅐ도됨
		
		System.out.println(member);
		return "form/memberInfo";
		
		/*
		@RequestMapping("/join.do")
		public String join(HttpServletRequest request) {
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPassword(password);
			member.setName(name);
			
			request.setAttribute("member", member); //꼭 모델엔뷰로 안해ㅐ도됨
			
			System.out.println(member);
			return "form/memberInfo";
			*/
	}
	
	
}
