package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {
	private final String command = "update.prd";
	private final String getPage = "productUpdateForm";
	private final String gotoPage = "redirect:/list.prd";
	private final String loginPage = "redirect:/loginForm.mb";
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView updateForm(	
			@RequestParam(value="num", required = true) int num,
			@RequestParam(value="pageNumber", required = true) int pageNumber,
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			HttpSession session, Model model) {

		System.out.println(this.getClass()+"GET");
		System.out.println(num);
		System.out.println(pageNumber);
		System.out.println(whatColumn);
		System.out.println(keyword);
		ModelAndView mav = new ModelAndView();
		//		
		//		
		//		ModelAndView mav = new ModelAndView();
		//		mav.addObject("product", pb);
		//		mav.addObject("pageNumber", pageNumber);
		//		mav.addObject("whatColumn", whatColumn);
		//		mav.addObject("keyword", keyword);
		//		mav.setViewName(getPage); // productUpdateForm

		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/update.prd?num=" + num);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			//model.addAttribute("whatColumn" , whatColumn);
			//model.addAttribute("keyword" , keyword);
			//model.addAttribute("pageNumber" , pageNumber);
					
			mav.setViewName(loginPage);	
			
		}else {
			
			ProductBean pb = productDao.detailProduct(num);
			mav.addObject("product", pb);
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("whatColumn", whatColumn);
			mav.addObject("keyword", keyword);
			mav.setViewName(getPage); // productUpdateForm

			//model.addAttribute("product" , pb);
			//model.addAttribute("pageNumber" , pageNumber);
			//return getPage;
		}
		return mav;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("product") @Valid ProductBean pb, BindingResult result,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			//누락 발생하면 삭제하려던 이미지 이름 챙겨서 다시 돌아가야 함
			if(pb.getImage().equals("")) {
				pb.setImage(pb.getUpload2());
			}
			
			return mav;
		}
		
		String deletePath = servletContext.getRealPath("/resources/uploadImage/");
		
		int cnt = -1;
		cnt = productDao.updateProduct(pb);
		if(cnt != -1) {
			
			//삭제
			File delFile = new File(deletePath+File.separator+pb.getUpload2());
			if(delFile.exists()) {
				delFile.delete();
			}
			
			//입력
			MultipartFile multi = pb.getUpload();
			String uploadPath = servletContext.getRealPath("/resources/uploadImage/");
			File destination = new File(uploadPath+File.separator+multi.getOriginalFilename());
			try {
				multi.transferTo(destination);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		
		mav.setViewName(gotoPage);
		return mav;
	}
}
