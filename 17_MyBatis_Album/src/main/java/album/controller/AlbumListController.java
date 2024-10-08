package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;


@Controller
public class AlbumListController {

	private final String command = "/list.ab";
	private final String getPage = "albumLists";

	
	@Autowired
	@Qualifier("myAlbumDao")
	AlbumDao albumDao;

	@RequestMapping(command)
	public ModelAndView list(
			@RequestParam(value="whatColumn", required = false) String whatColumn, 
			@RequestParam(value="keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			HttpServletRequest request) {
		
//		whatColumn, keyword X : http://localhost:8080/ex/list.ab
//		whatColumn, keyword O : albumList.jsphttp://localhost:8080/ex/list.ab?whatColumn=singer&keyword=ss
//		String whatColumn = request.getParameter("whatColumn");
//		String keyword = request.getParameter("keyword");
		
		System.out.println("whatColumn():" + whatColumn); // whatColumn:singer
		System.out.println("keyword():" + keyword); // keyword:    
		System.out.println("pageNumber:" + pageNumber); // null,2,3
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn); // whatColumn:singer, null
		map.put("keyword", "%"+keyword+"%"); // keyword:%    %,null
		
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount:" + totalCount);
		
		String url = request.getContextPath() + this.command; // /ex/list.ab
		System.out.println("url:" + url);
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		
		ModelAndView mav = new ModelAndView();
		List<AlbumBean> albumLists = albumDao.getAlbumList(pageInfo,map); 
		mav.addObject("albumLists", albumLists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage); // /WEB-INF/album/albumList.jsp
		return mav;
	}
}







