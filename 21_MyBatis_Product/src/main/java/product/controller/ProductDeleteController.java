package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
	private final String command = "/delete.prd";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;	
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(command)
	public ModelAndView delete(@RequestParam int num,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		
		ProductBean product = productDao.detailProduct(num);
		
		String image = product.getImage();
		System.out.println("delete image : " + image);
		
		ModelAndView mav = new ModelAndView();
		String deletePath = servletContext.getRealPath("/resources/uploadImage/");
		int cnt = -1;
		
		cnt = productDao.deleteProduct(num);
		
		if(cnt != -1) {
			File delFile = new File(deletePath+File.separator+image);
			if(delFile.exists()) {
				delFile.delete();
			}
		}
		
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		mav.setViewName(gotoPage);
		
		return mav;
	}
	
}
