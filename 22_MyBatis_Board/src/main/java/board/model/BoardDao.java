package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;
@Component("BoardDao")
public class BoardDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "board.model.Board";
	
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount", map);
		return cnt;
	}

	public List<BoardBean> getArticleList(Map<String, String> map, Paging pageInfo) {
		List<BoardBean> list = new ArrayList<BoardBean>();
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		list = sqlSessionTemplate.selectList(namespace+".getArticleList", map, rowbounds);
		return list;
	}

	public int insertArticle(BoardBean bb) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".insertArticle", bb);
		System.out.println("dao insertArticle cnt : " + cnt);
		return cnt;
	}

	public BoardBean detailArticle(int num) {
		// TODO Auto-generated method stub
		BoardBean bb = null;
		bb = sqlSessionTemplate.selectOne(namespace +".detailArticle", num);
		return bb;
	}

	public int deleteArticle(int num) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".deleteArticle", num);
		System.out.println("boardDao deleteArticle cnt : " + cnt);
		return cnt;
	}

	public String searchPasswd(int num) {
		// TODO Auto-generated method stub
		String passwd = sqlSessionTemplate.selectOne(namespace + ".searchPasswd", num);
		System.out.println("boardDao searchPasswd passwd :" + passwd);
		return passwd;
	}

	public int updateArticle(BoardBean bb) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".updateArticle", bb);
		System.out.println("boardDao updateArticle cnt : " + cnt);
		return cnt;
	}

	public int updateReadcount(int num) {
		// TODO Auto-generated method stub
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".updateReadcount", num);
		return cnt;
	}

	public int insertReplyArticle(BoardBean bb) {
		// TODO Auto-generated method stub
		int cnt = -1;
		System.out.println("bb.getRef() " + bb.getRef());
		System.out.println("bb.getRe_step() " + bb.getRe_step());
		System.out.println(bb.getWriter());
		System.out.println(bb.getEmail());
		System.out.println(bb.getSubject());
		System.out.println(bb.getContent());
		System.out.println(bb.getIp());
		
		cnt = sqlSessionTemplate.insert(namespace + ".insertReplyArticle", bb);
		System.out.println("dao insertReplyArticle cnt : " + cnt);
		return cnt;
	}

	public int updateReplyArticle(BoardBean bb) {
		// TODO Auto-generated method stub
		int cnt = -1;
		System.out.println("bb.getRef() " + bb.getRef());
		System.out.println("bb.getRe_step() " + bb.getRe_step());
		cnt = sqlSessionTemplate.update(namespace + ".updateReplyArticle", bb);
		return cnt;
	}
	

}
