package mall.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.*;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class CartListController {
	private final String command = "list.mall";
	private final String getPage = "mallList"; // 장바구니 보기
	
	@Autowired
	private ProductDao productDao;
	//detailView.jsp에서 주문 > CartAddController(로그인 성공) > 장바구니 담기(MyCartList addOrder) > list.mall 요청 
	@RequestMapping(command)
	public String list(HttpSession session, Model model) {
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer, Integer> maplists = mycart.getAllOrderLists();
		System.out.println("maplists.size() : " + maplists.size());
		Set<Integer> key_set = maplists.keySet();
		System.out.println("key_set : " + key_set); //상품 번호만 출력
		for(int key : key_set) {
			System.out.println(key + ", " + maplists.get(key));
		}
		
		int totalAmount = 0;
		List<ShoppingInfo> shopLists = new ArrayList<ShoppingInfo>();
		for(Integer pnum : key_set) {
			Integer qty = maplists.get(pnum);
			ProductBean pb = productDao.detailProduct(pnum);
			ShoppingInfo shopInfo = new ShoppingInfo();
			shopInfo.setPnum(pnum);
			shopInfo.setPname(pb.getName());
			shopInfo.setQty(qty);
			shopInfo.setPrice(pb.getPrice());
			int amount = pb.getPrice() * qty;
			totalAmount += amount;
			shopInfo.setAmount(amount);
			shopLists.add(shopInfo);
		}
		session.setAttribute("shopLists", shopLists);
		session.setAttribute("totalAmount", totalAmount);
		return getPage;
	}
}
