package cn.et.springmvc.lesson01.service;

import java.util.Map;

import cn.et.springmvc.lesson01.utils.PageTools;

public interface FoodService {

	/**
	 * 封装了get方法
	 * @return
	 * @throws Exception
	 */
	 public PageTools getTableListPager(String name,int curPage)
			throws Exception;

	public abstract void saveFood(String foodid,String foodName, String price,
			String imagePath) throws Exception;

	public abstract void updateFood(String foodid, String foodName, String price,String path)
			throws Exception;

	public abstract void deleteFoodType(String foodid) throws Exception;

	public Map<String, Object> findId(String foodid);
}