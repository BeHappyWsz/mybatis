package cn.wsz.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * Book实体类
 * @author wsz
 * @date 2017年11月3日14:05:49
 */
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Setter
	@Getter
	private long id;
	
	@Setter
	@Getter
	private String name;
	
	@Setter
	@Getter
	private String author;
	
	@Setter
	@Getter
	private float price;
	
	@Setter
	@Getter
	private String des;
	
	@Setter
	@Getter
	private Date date;

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", price=" + price + ", des=" + des + ", date=" + date + "]";
	}
	
}
