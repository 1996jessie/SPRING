package cafe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utility.Paging;

@Service("myCafeDao")
public class CafeDao {

	private String namespace = "cafe.CafeBean";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public CafeDao() {
		System.out.println("CafeDao »ý¼ºÀÚ");
	}


	public List<CafeBean> getCafeList(Map<String, String> map, Paging pageInfo) {

		List<CafeBean> lists = new ArrayList<CafeBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".getCafeList", map, rowBounds);
		System.out.println("lists.size():" + lists.size());

		return lists;
	}//getCafeList


	public int getTotalCount(Map<String, String> map) {
		int count = -1;
		count = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		return count;
	}// getTotalCount


	public int insertCafe(CafeBean cafe) {
		int cnt = -1;

		cnt = sqlSessionTemplate.insert(namespace + ".insertCafe", cafe);
		System.out.println("insertCafe cnt:" + cnt);
		return cnt;
	}//insertCafe


	public CafeBean detailCafe(int num) {
		CafeBean cb = null;
		cb = sqlSessionTemplate.selectOne(namespace + ".detailCafe", num);
		
		return cb;
	}//detailCafe


	public int deleteCafe(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".deleteCafe", num);
		
		return cnt;
		
	}//deleteCafe


	public void updateCafe(CafeBean cb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".updateCafe", cb);
		System.out.println("updateCafe cnt:" + cnt);
	}//updateCafe


	public int searchMenu(String inputmenu) {
		int count=-1;
		count = sqlSessionTemplate.selectOne(namespace + ".searchMenu", inputmenu); 
		return count;
	}

}
