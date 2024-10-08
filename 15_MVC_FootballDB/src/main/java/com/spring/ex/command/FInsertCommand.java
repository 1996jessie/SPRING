package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FInsertCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		/* Map  */
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("req"); //키를 쓰면 그에 해당하는 값을 가져올 수 있음
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String win = request.getParameter("win");
		String[] rarr = request.getParameterValues("round16"); 
		String round16 = "";
		if(rarr == null) {
			round16 = "16강 예상 국가 선택 안함";
		} else {
			for(int i=0; i<rarr.length; i++){
				round16 += rarr[i];
				if(i != rarr.length-1) {
					round16 += ", ";
				}
			}
		}		
		FDto fdto = new FDto();
		fdto.setId(id);
		fdto.setPw(pw);
		fdto.setWin(win);
		fdto.setRound16(round16);
		
		FDao fdao = FDao.getInstance();
		fdao.insert(fdto);
		

	}

}
