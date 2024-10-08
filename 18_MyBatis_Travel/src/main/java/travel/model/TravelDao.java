package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao")
public class TravelDao {

	private String namespace="travel.TravelBean";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public TravelDao() {
		System.out.println("TravelDao()");
	}

	public List<TravelBean> getTravelList(Map<String,String> map, Paging pageInfo) {
		System.out.println("getTravelList");
		System.out.println(pageInfo.getLimit());
		System.out.println(pageInfo.getOffset());

		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit() );//p3 =>4,2
		List<TravelBean> lists = new ArrayList<TravelBean>();
		lists = sqlSessionTemplate.selectList(namespace + ".getTravelList",map,rowBounds); 

		System.out.println("getAllTravel 사이즈 : " + lists.size());

		return lists;
	}

	public int insertTravel(TravelBean travel) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace + ".insertTravel",travel);
		}catch(DataAccessException e) {
			System.out.println("insert 에러 발생");
		}
		return cnt;
	}//insertTravel

	public int deleteTravel(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".deleteTravel", num);
		System.out.println("deleteTravel cnt:" + cnt);
		return cnt;
	}

	public TravelBean getTravelByNum(int num) {
		TravelBean travel = null;
		travel = sqlSessionTemplate.selectOne(namespace + ".getTravel", num);
		System.out.println(travel.getAge());
		System.out.println(travel.getArea()); 
		return travel;
	}//getTravelByNum

	public int updateTravel(TravelBean travel) {
		System.out.println("dao updateTravel");
		System.out.println(travel.getAge());
		System.out.println(travel.getArea());
		System.out.println(travel.getName()); // 최강창민
		System.out.println(travel.getNum());
		System.out.println(travel.getPrice());
		System.out.println(travel.getStyle());
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace + ".updateTravel", travel);
			System.out.println("updateTravel cnt:" + cnt);
		}catch(DataAccessException e) {
			System.out.println("에러발생");
			System.out.println("e.getMessage():" + e.getMessage());
			System.out.println("cnt:" + cnt);
		}
		return cnt;
	}//updateTravel

	public int getTotalCount(Map<String, String> map) { // wc=null/style/area, kw=null

		int count = -1;
		count = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		System.out.println("totalCount: " + count);
		return count;
	}//getTotalCount
}

