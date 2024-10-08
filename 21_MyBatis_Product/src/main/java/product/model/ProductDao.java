package product.model;

import java.util.*;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class ProductDao {

	private String namespace = "product.model.Product";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public ProductDao() {
		System.out.println("ProductDao »ý¼ºÀÚ");
	}
	
	public List<ProductBean> getProductList(Map<String, String> map, Paging pageInfo) {
		List<ProductBean> lists = new ArrayList<ProductBean>();
		System.out.println(map.get("whatColumn"));
		System.out.println(map.get("keyword"));
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		System.out.println(pageInfo.getOffset());
		System.out.println(pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".getProductList", map, rowBounds);
	
		System.out.println("lists.size() : " + lists.size());
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int count = -1;
		count = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		System.out.println("count : " + count);
		return count;
	}// getTotalCount

	public int insertProduct(ProductBean pb) {
		// TODO Auto-generated method stub
		int cnt = -1;
		
		cnt = sqlSessionTemplate.insert(namespace + ".insertProduct", pb);
		System.out.println("insertProduct cnt : " + cnt);
		return cnt;
	}

	public ProductBean detailProduct(int num) {
		// TODO Auto-generated method stub
		ProductBean prod = null;
		prod = sqlSessionTemplate.selectOne(namespace +".detailProduct", num);
	
		return prod;
	}

	public int deleteProduct(int num) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".deleteProduct", num);
		
		return cnt;
	}

	public int updateProduct(ProductBean pb) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".updateProduct", pb);
		return cnt;
	}

	public int updateStock(int pnum, int qty) {
		// TODO Auto-generated method stub
		int  cnt = -1;
		ProductBean pb = new ProductBean();
		pb.setNum(pnum);
		pb.setStock(qty);
		cnt = sqlSessionTemplate.update(namespace + ".updateStock", pb);
		return cnt;
	}
	
	
}
