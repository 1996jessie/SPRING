package order.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("OrderDao")
public class OrderDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "order.model.Order";

	public int insertData(String id) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".insertData", id);
		System.out.println("insertData cnt : " + cnt);
		return cnt;
	}

	public int findMaxOrderOid() {
		// TODO Auto-generated method stub
		int maxOid = -1;
		maxOid = sqlSessionTemplate.selectOne(namespace + ".findMaxOrderOid");
		System.out.println("findMaxOrderOid() maxOid : " + maxOid);
		return maxOid;
	}

	public List<OrderBean> getAllMyOrders(String id) {
		// TODO Auto-generated method stub
		System.out.println("getAllMyOrders id : " + id);
		List<OrderBean> list = new ArrayList<OrderBean>();
		list = sqlSessionTemplate.selectList(namespace + ".getAllMyOrders", id);
		return list;
	}
}
