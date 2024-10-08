package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {

	private final String command = "update.ab";  
	private final String getPage = "albumUpdateForm";  
	private final String gotoPage = "redirect:/list.ab";
	
	@Autowired
	@Qualifier("myAlbumDao")
	AlbumDao albumDao;

	//albumList.jsp에서 수정하기 버튼 클릭시 num 가지고 넘어옴
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String update(@RequestParam(value="num",required = true) int num, Model model) {

		AlbumBean album = albumDao.getAlbum(num);
		model.addAttribute("album", album);

		return getPage;
	}
	
	//albumUpdateForm.jsp에서 수정하기 버튼 클릭시
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("album") @Valid AlbumBean album, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		albumDao.updateAlbum(album);
		mav.setViewName(gotoPage);
		return mav;
		
	}
}
