package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberInsertController {
	final String command = "/insert.mb";
	final String getPage = "memberInsertForm";
	final String gotoPage = "redirect:/memberList.mb";

	@Autowired
	MemberDao memberDao;

	@RequestMapping(value=command,method=RequestMethod.GET)
	public String registForm() {
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public String register(@ModelAttribute("member") @Valid MemberBean member, BindingResult result, Model model, HttpServletResponse response) throws IOException {
		
		PrintWriter out;
		out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		if(result.hasErrors()) {
			return getPage;
		}
		Integer cnt = -1;
		cnt = memberDao.insertMember(member);
		System.out.println("insertMember cnt : " + cnt);
		if(cnt == -3) {
			out.print("<script>alert('아이디 중복');</script>");
			out.flush();
			
			return getPage;
		}
		return gotoPage;
	}
}