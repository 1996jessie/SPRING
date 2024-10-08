package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("MemberDao")
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "member.model.Member";
	public List<MemberBean> getMemberList(Map<String,String> map, Paging pageInfo) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		list = sqlSessionTemplate.selectList(namespace+".getMemberList", map, rowbounds);
		return list;
	}//getMemberList
	
	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount", map);
		return cnt;
	}//getTotalCount

	public int insertMember(MemberBean member) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.insert(namespace+".insertMember",member);
		} catch (DuplicateKeyException e) {
			System.out.println("아이디 중복");
			cnt = -3; //삽입 안됐다는 것을 보여주기 위함
		}
		return cnt;
	}//insertMember

	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(namespace + ".deleteMember", id);
	}

	public MemberBean detailMember(String id) {
		// TODO Auto-generated method stub
		MemberBean member = null;
		member = sqlSessionTemplate.selectOne(namespace + ".detailMember", id);
		
		return member;
	}

	public int updateMember(MemberBean mb) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".updateMember", mb);
		return cnt;
	}

	public void searchMember(String id, String password) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace + ".searchMember", id);
	}

	public int updateMpoint(String id, int mpoint) {
		// TODO Auto-generated method stub
		int cnt = -1;
		MemberBean mb = new MemberBean();
		mb.setId(id);
		mb.setMpoint(mpoint);
		cnt = sqlSessionTemplate.update(namespace + ".updateMpoint", mb);
		return cnt;
	}


	
}