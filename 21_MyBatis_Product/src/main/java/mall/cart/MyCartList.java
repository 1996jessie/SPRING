package mall.cart;

import java.util.*;


public class MyCartList { //장바구니
	
	private Map<Integer, Integer> orderLists = null; // n번 상품 m개 주문(n : key, m : value)

	public MyCartList() {
		orderLists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		//지금 주문한 상품
		if(orderLists.containsKey(pnum) == false) { //기존 장바구니에 없으면
			orderLists.put(pnum, oqty);
		} else { //기존 장바구니에 없으면
			int qty = orderLists.get(pnum);
			orderLists.put(pnum, oqty + qty);
		}

		Set<Integer> key_set = orderLists.keySet();
		System.out.println("key_set : " + key_set); //상품 번호만 출력
		for(int key : key_set) {
			System.out.println(key + ", " + orderLists.get(key));
		}
	}

	public Map<Integer, Integer> getAllOrderLists() {
		// TODO Auto-generated method stub
		return orderLists;
	}



}
