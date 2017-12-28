package cn.et.springmvc.lesson01.dao;

import java.util.List;
import java.util.Map;


public interface FoodDao {
	public Integer getTableListCount(String name) throws Exception;
	/**
	 * 封装了get方法
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getTableListPager(String name,int startIndex,int length)
			throws Exception;

	public abstract void saveFood(String foodid,String foodName, String price,
			String imagePath) throws Exception;

	public abstract void updateFood(String foodid, String foodName, String price,String path)
			throws Exception;

	public abstract void deleteFoodType(String foodid) throws Exception;

	public Map<String, Object> findId(String foodid);
}