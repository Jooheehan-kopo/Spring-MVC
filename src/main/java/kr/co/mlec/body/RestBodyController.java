package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.form.MemberVO;

@RestController  //@ResponseBody 대신에. 이거 하나만 쓰고 인덱스 rest로 바꿔줘
@RequestMapping("/ajax")
public class RestBodyController {

	
	@RequestMapping("/restBody.do")
	public String resStringBody() {
		return "OK, 성공"  //한글 깨짐. message converter? 해야힘
;	}
	
	@RequestMapping("/restBody.json")
	public Map<String,String> resJsonBody(){
		Map<String,String> result = new HashMap<String,String>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		
		return result; //406에러뜸 응답은 하지만 해석을 못함  map을 json으로 바꿔줘야함. spring xml/ 못봐꿈
	}
	
	@RequestMapping("/restVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		return vo; //vo를 알아서 json객체로 바꿔줌. msg converter가.
	}
	
	@RequestMapping("/restStringListBody.json")
	public List<String> resJsonStringListBody(){
		List<String> list = new ArrayList<String>();
		for(int i =1; i<=4; i++) {
			list.add(String.valueOf(i));
		}//1-4f를 문자열로 바꿔서 리스트 저장 한 것을 배열을 리턴함  --?{} -> [] 자바스크립트 배열로 변환
		return list;
	}
	
	@RequestMapping("/restVOListBody.json")
	public List<MemberVO> resVOListBody(){
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i =1; i<=4; i++) {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		list.add(vo);
		}
		return list;
		}
}
