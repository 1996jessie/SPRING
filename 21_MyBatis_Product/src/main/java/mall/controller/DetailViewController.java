package mall.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mall.cart.ShoppingInfo;
import member.model.MemberDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;
import product.model.CompositeDao;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class DetailViewController {
	private final String command = "detailView.mall";
	private final String getPage = "shopResult";
	
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	CompositeDao compositeDao;
	
	@RequestMapping(value = command) 
	private ModelAndView detailView(@RequestParam(value="oid") int oid) {
		System.out.println(this.getClass() + " oid : " + oid);
		
		List<ShoppingInfo> detailLists = compositeDao.getOrderDetailByOid(oid);
		System.out.println(detailLists.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("detailLists", detailLists);
		mav.setViewName(getPage);
	
		return mav;
	}
}
