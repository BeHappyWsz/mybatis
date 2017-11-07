package cn.wsz.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.wsz.mybatis.domain.Book;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {

	public Book getById(Long id);

	public Book findOne(Long id);

	public Book findById(Long id);

	public List<Book> findByMap(Map<String,Object> map);

	public List<Book> findByAno(@Param("author")String author,@Param("name")String name);

	public List<Book> findByJavaBean(Book book);

	public List<Book> findAll();

	public int countAllByAuthor(String author);

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
