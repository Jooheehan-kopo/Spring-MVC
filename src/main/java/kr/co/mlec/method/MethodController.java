package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/method/method.do") //method C의 모든 메소드는 다 method.do만 들어온다. 클래스에도 가능
@Controller
public class MethodController {

	@RequestMapping(method=RequestMethod.GET)
	public String callGet() {
		return "method/methodForm";
	}

	@RequestMapping(/* value="/method/method.do", */ method=RequestMethod.POST)
	public String callPost() {
		return "method/methodProcess";
	}
	
}
