package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.MDao;
import com.spring.ex.dto.MartBean;


public class MUpdateFormCommand implements MCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		MDao mdao = MDao.getInstance();
		MartBean mb =  mdao.selectMartByNum(num);
		
		request.setAttribute("mb", mb);
	}
}
