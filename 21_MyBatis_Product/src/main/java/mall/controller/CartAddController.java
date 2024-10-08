package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;
import product.model.ProductBean;

@Controller
public class CartAddController {
	private final String command = "add.mall";
	private final String gotoPage = "redirect:/list.mall";
	
	//productDetailView.jsp에서 주문하기 클릭하면 num, pageNumber, orderqty 가지고 넘어옴
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String add(ProductBean pb, @RequestParam(value="pageNumber", required = false) int pageNumber, HttpSession session) {
		
		System.out.println(this.getClass() + "Post : " + pb.getNum()+" / "+ pb.getOrderqty() + " / " + pageNumber);
		
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/detail.prd?num=" + pb.getNum() + "&pageNumber=" + pageNumber);
			return "redirect:/loginForm.mb";
		} else { //로그인 성공
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart"); //장바구니 세션 이름 : mycart
			System.out.println("mycart : " + mycart);
			
			if(mycart == null) { //아직 장바구니 안 만들어짐
				mycart = new MyCartList(); //장바구니 만드는 중
			}
			
			System.out.println("mycart2 : " + mycart); //이제 null 아님
			mycart.addOrder(pb.getNum(), pb.getOrderqty());
			session.setAttribute("mycart", mycart); //또 다른 장바구니 만들어지지 않도록
			return gotoPage;
		}
	}
}
