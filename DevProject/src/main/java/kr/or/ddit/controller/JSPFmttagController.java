package kr.or.ddit.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.scenario.effect.Blend.Mode;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/fmttag")
@Slf4j
public class JSPFmttagController {


	/*
	 * 7. 숫자 및 날짜 포매팅 처리 태그 
	 * 	- 숫자 및 날짜의 포맷팅과 관련된 태그입니다.
	 *  - 문자열을 숫자로, 문자열을 날짜로 변형하여 사용합니다 
	 *  
	 *  1) <fnt:formatNumber>
	 *  	- 숫자를 형식화 합니다 
	 *  
	 *  	속성   	|       타입			   |      설명 
	 *  _______________________________________________________________________
	 *   	value	|    String of Number  |  서식에 맞춰 출력할 숫자 
	 *   	type	|    String    		   |  어떤 서식으로 출력할지 결정 
	 *   	pattern	|    String    		   |  직접 숫자를 출력할 서식 지정 
	 *   	var		|    String    		   |  포맷팅한 결과를 지정할 변수 이름 
	 *   
	 *   ** type 속성 : number일 경우 숫자 형식으로, percent일 경우 % 형식으로, currency일 경우 통화 형식으로 출력
	 *   	기본값은 number이다. currency는 속해있는 국가코드에 맞는 통화 형식이 부여된다 
	 *   
	 *   
	 *   2) <fmt:parseNumber>
	 *   - 문자열을 숫자로 변환 
	 *  	속성   	|       타입			   |      설명 
	 *  ________________________________________________________________________
	 *   	value	|    String  		   |  파싱할 문자열 
	 *   	type	|    String    		   |  value 속성의 문자열 타입을 지정  
	 *   	pattern	|    String    		   |  파싱할 때 직접 사용할 서식을 지정 
	 *   	var		|    String    		   |  파싱한 결과를 저장할 변수 이름을 지정 
	 *   
	 *   ** type 속성 : number, currency, percent가 올 수 있다 
	 *   
	 *   
	 *   3) <fmt:formatDate>
	 *   	- Date 객체를 문자열로 변환
	 *  	속성   	|       타입			   |      설명 
	 *  _________________________________________________________________________
	 *   	value	|    java.util.Date    |  포맷팅할 날짜 및 시간 값 
	 *   	type	|    String    		   |  날짜, 시간 또는 둘 다 포맷팅 할지의 여부를 지정 
	 *   dateStyle	|    String    		   |  날짜에 대해 미리 정의된 포맷팅 스타일을 지정 
	 *   timeStyle  |    Stirng 		   |  시간에 대해 미리 정의된 포맷팅 스타일을 지정 
	 *   pattern    |    Stirng 		   |  파싱한 결과를 저장할 변수 이름을 지정 
	 *   
	 *   ** type  속성 : time, date, both 중 한가지 값을 가질 수 있으며 기본값은 date
	 *   dateStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며 기본값은 default
	 *   timeStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며 기본값은 default
	 *   
	 *   
	 *   4) <fmt:parseDate>
	 *    - 문자열을 Date 객체로 변환 
	 *  	속성   	|       타입		  |      설명 
	 *  _______________________________________________________________________
	 *   	value	|    String       |  파싱할 문자열 
	 *   	type	|    String       |  날짜, 시간 또는 둘 다 포맷팅 할지의 여부 지정 
	 *   dateStyle	|    String       |  날짜에 대해 미리 정의된 포맷팅 스타일 지정 
	 *   timeStyle	|    String 	  |  시간에 대해 미리 정의된 포맷팅 스타일 지정 
	 *   pattern	|    String 	  |  파싱할 때 직접 사용할 서식을 지정 
	 *   var		|    String 	  |  파싱한 결과를 저장할 변수 이름을 지정 
	 *   
	 *   ** type  속성 : time, date, both 중 한가지 값을 가질 수 있으며 기본값은 date
	 *   dateStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며 기본값은 default
	 *   timeStyle 속성 : default, short, medium, long, full 중 한가지 값을 가질 수 있으며 기본값은 default
	 *   
	 */
	
	// 1) type 속성을 지정하거나 pattern속성을 지정하여 숫자를 형식화한다
	@RequestMapping(value="/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		int coin = 100;
		model.addAttribute("coin", coin);
		return "home/fmttag/home0101";
	}
	
	//2) type 속성이 지정되지 않으면 기본값은 number이다
	@RequestMapping(value="/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		int coin = 1000;
		model.addAttribute("coin", coin);
		return "home/fmttag/home0201";		
	}
	
	//3) type 속성이 currency 이다 
	// 만약 type 속성이 percent인 경우 넘겨받아야 할 값이 '1000%'과 같이 %의 스타일 형태 값이 넘어가야한다
	// 그래서 type 속성과 일치하여 값을 파싱할 수 있다 
	@RequestMapping(value="/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		String coin = "￦1000";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0202";			
	}
	
	// pattern 속성을 사용하여 직접 사용할 서식을 지정한다 
	@RequestMapping(value="/home0204", method = RequestMethod.GET)
	public String home0204(Model model) {
		String coin = "1,000.25";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0204";	
	}
	
	// 6) type 속성을 date로 지정하여 날짜 포맷팅을 한다
	@RequestMapping(value="/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0301";	 		
	}
	
	//7) type 속성을 time으로 지정해야 시간 포맷팅을 한다 
	@RequestMapping(value="/home0302", method = RequestMethod.GET)
	public String home0302(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0302";	 		
	}
	
	// 8) type 속성을 both로 지정하여 날짜, 시간 둘다 포맷팅한다 
	@RequestMapping(value="/home0303", method = RequestMethod.GET)
	public String home0303(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0303";
	}
	
	// 9) pattern 속성을 지정하여 날짜를 포맷팅한다 
	@RequestMapping(value="/home0304", method = RequestMethod.GET )
	public String home0304(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home/fmttag/home0304";
	}
	
	// 10) dateStyle 속성을 지정하지 않으면 기본값은 default이다 
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		String dateValue = "2020. 10. 20";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0401";
	}
	
	// 11) dateStyle 속성을 short로 지정하여 문자열을 Date 객체로 변환한다 
	@RequestMapping(value = "/home0402", method = RequestMethod.GET )
	public String home0402(Model model) {
		String dateValue = "20. 2. 1";				// style short형태로 지정 
//		String dateValue = "2020. 2. 1";			// style medium형태로 지정 
//		String dateValue = "2019년. 2월. 1일(금)";	// style long형태로 지정 
//		String dateValue = "2019년. 2월. 1일 금요일";	// style full형태로 지정 
		// 각 dateStyle로 지정된 값이 페이지로 넘어가 parsing이 진행될 때, parseDate내에 
		// dateStyle을 각 값과 일치하는 스타일 형태로 지정해주어야 값이 파싱된다
		
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0402";
	}
	
	// 12) pattern 속성을 지정하여 문자열을 Date 객체로 변환한다 
	@RequestMapping(value = "/home0403", method = RequestMethod.GET)
	public String home0403(Model model) {
		String dateValue = "2022-02-01 15:00:24";	// pattern 지정 
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0403";
	}
	
	
}
