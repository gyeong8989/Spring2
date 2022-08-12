package com.korea.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.domain.BoardVO;
import com.korea.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		//mapper.getList().forEach(board->log.info(board));
		
		mapper.getListXML().forEach(board->log.info(board));
		
	}
	
	@Test
	public void insertTest() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로작설글 4");
		board.setContent("새로작성내용4");
		board.setWriter("작성자4");
		
//		mapper.insertXML(board);
//		mapper.insert(board);
//		log.info(board);
		
		long bno = mapper.insertSelectKey(board);
		log.info("bno 값은 : " + board.getBno());
	}
	
//	@Test
//	public void insertTest() {	
//		BoardVO vo = new BoardVO();
//		vo.setTitle("제목1");
//		vo.setContent("내용1");
//		vo.setWriter("댓글1");
//		
//		mapper.insert(vo);
//		log.info("생성하신 값은 : " + vo);
//	}
	
	@Test
	public void readTest() {
		log.info(mapper.read(21L));
		BoardVO board = mapper.readXML(90L);
		log.info(board);
		
		
	}
	
	@Test
	public void DeleteTest() {
		
		
//		int result = mapper.delete(2L);
//        log.info(result);
        
        int result = mapper.deleteXML(4L);
        log.info("result 삭제 : " + result);
	}
	
	@Test
	public void UpdateTest() {
		BoardVO vo = new BoardVO();
		vo.setBno(211L);
		vo.setTitle("re제목1234");
		vo.setContent("re내용1234");
		vo.setWriter("re댓글1234");
		
		mapper.update(vo);
		mapper.updateXML(vo);
	}
	
	@Test
	public void getTotalCountTest() {
		Criteria cri = new Criteria();

        /* 검색조건 */
        cri.setKeyword("테스트");
//
//        /* 검색 리스트 */
//        List list = mapper.getTotalCount(cri);
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println("result......." + i + " : " + list.get(i));
//        }

        /* 게시글 총 갯수 */
        int result = mapper.getTotalCount(cri);
        System.out.println("게시글 총 개수" + result);

	}
	
	
}






