package cn.wsz.mybatis.dao;

import java.util.List;

import cn.wsz.mybatis.domain.Book;

public interface BookMapper {

	public Book findById(Long id);
	
	public List<Book> findAll();
	
	public List<Book> findByName(String name);
	
	public List<Book> findByAuthor(String author);
	
	public int insertBook(Book book);
	
	public int batchInsert(List<Book> books);
	
	public int updateById(Long id);
	
	public int updateBook(Book book);
	
	public int batchUpdate(String batch);
	
	public int deleteById(Long id);
	
	public int batchDelete(List<Long> id);
}
