package com.sping.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample") //공통 요청명 묶기
public class SampleController {
	@RequestMapping("/view")
	public String view() {
		return "sample/view"; //여기에는 주소 다 써줘야 함
	}
	@RequestMapping("list")
	public String list() {
		return "sample/list";
	}
}
