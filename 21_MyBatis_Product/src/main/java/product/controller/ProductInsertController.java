package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	private final String command = "insert.prd";
	private final String getPage = "productInsertForm"; 
	private final String gotoPage = "redirect:/list.prd";

	@Autowired 
	private ProductDao productDao;

	@Autowired
	ServletContext servletContext;
	
	//상품 리스트에서 추가하기 클릭하면 로그인 여부부터 확인해야 함
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insert(HttpSession session) { //자동으로 만들어진 객체가 session에 들어옴
		//로그인 성공하면 loginInfo 세션 설정
		//자바에서는 ServletContext, HttpSession 사용
		System.out.println("loginInfo : " + session.getAttribute("loginInfo")); //아직 설정 안함 : null
		
		if(session.getAttribute("loginInfo") == null) { //로그인 못함
			session.setAttribute("destination", "redirect:/insert.prd");
			return "redirect:/loginForm.mb";
		} else { //로그인 성공			
			return getPage;
		}
	}
	 
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView insertForm(@ModelAttribute("product") @Valid ProductBean pb, BindingResult result) {
		
		System.out.println("PIC post");
		System.out.println("prod.getImage():"+pb.getImage()); // null, 남자시계.jpg
		System.out.println("prod.getUpload():"+pb.getUpload());
		MultipartFile multi = pb.getUpload();
		
		String uploadPath = servletContext.getRealPath("/resources/uploadImage/");
		System.out.println("uploadPath:" + uploadPath);
		//uploadPath:C:\Spring_test\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\21_MyBatis_Product\resources/uploadImage/
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav; 
		}
		
		int cnt = -1;
		cnt = productDao.insertProduct(pb);
		if(cnt != -1) {
			mav.setViewName(gotoPage);
			
			File destination = new File(uploadPath+File.separator+multi.getOriginalFilename());
			// C:\Spring_test\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\20_MyBatis_Product\resources/uploadImage/남자시계.jpg
			try {
				multi.transferTo(destination);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			mav.setViewName(getPage);
		}
		
		return mav;
	}
}
