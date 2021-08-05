package kr.co.mlec.form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")  //공통적은 경로를 위로 뺌.
public class MemberController {
		
	@RequestMapping("/joinForm.do")
	public String joinForm() {
	return "form/joinForm"; 
	}
	
	@RequestMapping("/join.do")
	public String join(MemberVO member, Model model) { //vo객체로 값을 받아옴.맵핑함. 
		
		model.addAttribute("member", member);
		return "form/memberInfo";
	
	//원래 객체값을 가져오려면 selrve request영역에 등록햇음. model이 포워드해주기에, 여기에 공유영영ㄱ객체 저장
		//http 객체 대신에 model 객체가져옴
	
	
	/* 4번
	//modelandview 를 통해서, foward/ 공유영역 객체 등록.
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO member) { //vo객체로 값을 받아옴.맵핑함. 
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form/memberInfo");
		mav.addObject("member",member);
		
		return mav;
	*/	
		
		
	/*3번
	 * @RequestMapping("/join.do")
	public String join(@ModelAttribute("member") MemberVO member) { //vo객체로 값을 받아옴.맵핑함. 
		
		//맵핑시키면, dispatch가 request.setAttribute("memverVO"라는잉름으로,memeber를 등록시킴)
		
		//1memberinfo에서 memberVO.으로 바꿔줘여함.
		//2 @ModelAttribute  membervo 이름이 아니라, member라는 이름으로
		//내가 원하는 이름으로 request영역에 이름을 저장. model이 그런 역할 --> info에 vo 지워줘야함

		return "form/memberInfo";
		*/
		
		
	/*2번
	 * @RequestMapping("/join.do")
	public String join(HttpServletRequest request, @RequestParam("id")String id, @RequestParam String password, @RequestParam String name) {
		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
	request.setAttribute("member", member); //꼭 모델엔뷰로 안해ㅐ도됨
		
		System.out.println(member);
		return "form/memberInfo";
		*/
		
		
		/* 1번
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
