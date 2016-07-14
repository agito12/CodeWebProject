package org.audgns.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.audgns.myapp.domain.BoardVO;
import org.audgns.myapp.persistence.BoardDao;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDao dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}
	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}
	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}
	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}
}
