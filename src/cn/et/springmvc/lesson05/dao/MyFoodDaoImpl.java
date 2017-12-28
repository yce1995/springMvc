package cn.et.springmvc.lesson05.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyFoodDaoImpl {
	@Autowired
	JdbcTemplate jdbc;
	public List<Map<String, Object>> select(String foodname){
		return jdbc.queryForList("select * from foods where foodname like '%"+foodname+"%'");
	}
	public void delete(String foodId){
		 jdbc.execute("delete from foods where foodId = "+foodId);
	}
	public void save(String foodName,String price){
		 jdbc.execute("insert into foods(foodname,price) values('"+foodName+"','"+price+"')");
	}
	public void update(String foodId,String foodName,String price){
		 jdbc.execute("update foods set foodname='"+foodName+"',price='"+price+"' where foodid="+foodId);
	}
}
