package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {

	private final String command = "calculate.mall";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	//mallList.jsp > 결제하기 클릭
	@RequestMapping(command)
	public String calculate(HttpSession session) {
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		
		/* MyCartList mycart = new MyCartList(); : 새로운 장바구니 객체 만듦 */
		
		//CartAddController에서 session 설정
		MyCartList mycart = (MyCartList)session.getAttribute("mycart"); //새로운 장바구니를 만들지 않음
		Map<Integer, Integer> orderLists = mycart.getAllOrderLists();
		
		System.out.println("주문 정보 : " + orderLists.size());
		
		//주문
		orderDao.insertData(mb.getId());
		int maxOid = orderDao.findMaxOrderOid();
		
		//주문 재고수량 감소, 세부 주문 
		Set<Integer> key_set = orderLists.keySet();
		for(int pnum : key_set) {
			int qty = orderLists.get(pnum);
			System.out.println("pnum : " + pnum + " / qty : " + qty);
			productDao.updateStock(pnum, qty);
			
			OrderDetailBean odb = new OrderDetailBean();
			odb.setOid(maxOid);
			odb.setPnum(pnum);
			odb.setQty(qty);
			orderDetailDao.insertData(odb);
		}
		
		//회원 포인트 점수 추가
		memberDao.updateMpoint(mb.getId(), 100);
		
		session.removeAttribute("mycart");
		return gotoPage;
	}
}
