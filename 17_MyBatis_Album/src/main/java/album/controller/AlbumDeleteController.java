package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {

	private final String command = "delete.ab";
	private final String gotoPage = "redirect:/list.ab";
	
	@Autowired
	AlbumDao albumDao;
	
	// albumList.jsp 에서 삭제 버튼 클릭시
	@RequestMapping(command)
	public String delete(@RequestParam("num") int num) {
		
		int cnt = -1;
		cnt = albumDao.deleteAlbum(num);
		
		return gotoPage;
	}
	
}