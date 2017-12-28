package cn.et.springmvc.lesson04.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyDaoImpl {
	@Autowired
	JdbcTemplate jdbc;
	public void insert(int money){
		String sql = "update mymoney set money=money-"+money+" where id=1";
		jdbc.execute(sql);
	}
	
	public Integer select(){
		String sql = "select money from mymoney where id=1";
		Integer m = jdbc.queryForObject(sql, Integer.class);
		return m;
	}
}
