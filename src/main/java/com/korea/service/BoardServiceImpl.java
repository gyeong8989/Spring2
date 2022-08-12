package com.korea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.domain.BoardVO;
import com.korea.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		mapper.insertXML(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.readXML(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		int result = mapper.updateXML(board);
		if(result > 1) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean remove(Long bno) {
		int result = mapper.deleteXML(bno);
		if(result > 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<BoardVO> getLIst() {
		
		return mapper.getList();
	}
}
