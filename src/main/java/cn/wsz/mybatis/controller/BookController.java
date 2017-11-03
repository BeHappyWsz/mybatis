package cn.wsz.mybatis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.wsz.mybatis.dao.BookMapper;
import cn.wsz.mybatis.domain.Book;

public class BookController {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = ssf.openSession();
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			List<Book> findAll = mapper.findAll();
			System.out.println(findAll.size());
			
			Book findById = mapper.findById(1L);
			if(null != findById){
				System.out.println(findById.toString());
			}else{
				System.out.println("not find");
			}
			
			List<Book> findByName = mapper.findByName("a");
			System.out.println(findByName.size());
			
			List<Book> findByAuthor = mapper.findByAuthor("b");
			System.out.println(findByAuthor.size());
			
			//单一新增
			Book book = new Book();
			book.setName("a");
			book.setAuthor("a");
			book.setPrice(10.0F);
			book.setDes("aaaaa");
//		  	book.setDate(new Date());//类型错误暂时无法保存
			int insertBook = mapper.insertBook(book);
			session.commit();//不提交，无法保存到数据库
			System.out.println(insertBook);
			//批量新增
			List<Book> books = new ArrayList<Book>();
			for(int i = 90 ; i > 85 ; i--){
				Book b = new Book();
				b.setName(String.valueOf(i));
				b.setAuthor(String.valueOf(i));
				b.setPrice(5F);
				b.setDes(String.valueOf(i));
				books.add(b);
			}
			int batchInsert = mapper.batchInsert(books);
			session.commit();
			System.out.println(batchInsert);
			//单一删除
			int deleteById = mapper.deleteById(2L);
			session.commit();
			System.out.println(deleteById);
			//批量删除
			List<Long> ids = new ArrayList<Long>();
			ids.add(1L);
			ids.add(2L);
			ids.add(3L);
			int batchDelete = mapper.batchDelete(ids);
			session.commit();
			System.out.println(batchDelete);
			//单一更新
			int updateById = mapper.updateById(16L);
			session.commit();
			System.out.println(updateById);
			//对象更新
			Book find = mapper.findById(16L);
			find.setName("qqqq");
			find.setPrice(80F);
			find.setAuthor("qqqq");
			find.setDes("qqqqqqqqq");
			int updateBook = mapper.updateBook(find);
			session.commit();
			System.out.println(updateBook);
			
		}finally{
			session.close();
		}
	}
}
