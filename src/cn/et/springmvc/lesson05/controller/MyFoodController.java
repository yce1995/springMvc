package cn.et.springmvc.lesson05.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.springmvc.lesson05.dao.MyFoodDaoImpl;

/**
 * 后台验证步骤 
 *   1 javabean添加验证注解 
 *   2 action中使用 @Valid表示javabean 使用 Errors或者BindingResult判断是否验证失败
 *   3 出现jar包冲突  4.3.2
 * @author Administrator
 *
 */
@Controller
public class MyFoodController {
	/**
	 * 查询food
	 */
	@Autowired
	MyFoodDaoImpl mdi;
	@RequestMapping(value="/queryFood",method={RequestMethod.GET})
	public String queryFood(String foodname,OutputStream os) throws Exception{
		List<Map<String, Object>> queryAllFood = mdi.select(foodname);
		JSONArray arry=JSONArray.fromObject(queryAllFood);
		String jsonStr=arry.toString();
		os.write(jsonStr.getBytes("UTF-8"));
		return null;
	}
	
	/**
	 * 直接返回字符数组+@ResponseBody
	 * 	减少流的输出动作代码
	 * 		os.write(jsonStr.getBytes("UTF-8"));
	 * @param foodname
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/queryFoodReturn",method={RequestMethod.GET})
	public byte[] queryFoodReturn(String foodname) throws Exception{
		List<Map<String, Object>> queryAllFood = mdi.select(foodname);
		JSONArray arry=JSONArray.fromObject(queryAllFood);
		String jsonStr=arry.toString();
		return jsonStr.getBytes("UTF-8");
	}
	
	/**
	 * 直接返回对象 srpingmvc自动转换成json
	 * @param foodname
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/queryFoodList",method={RequestMethod.GET})
	public List<Map<String, Object>> queryFoodLits(String foodname) throws Exception{
		List<Map<String, Object>> queryAllFood = mdi.select(foodname);
		return queryAllFood;
	}
	
	
	/**
	 * 删除food
	 * @param foodId 菜品id
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/defood/{foodId}",method=RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodId,OutputStream os) throws Exception{
		try {
			mdi.delete(foodId);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 修改food
	 * @param foodId 菜品id
	 * @param foodName 菜品名
	 * @param price 菜品价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/food/{foodId}",method={RequestMethod.PUT})
	public String udpateFood(@PathVariable String foodId,String foodName,String price,OutputStream os) throws Exception{
		try {
			mdi.update(foodId, foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 现在菜品
	 * @param foodName 菜品名称
	 * @param price 价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public String saveFood(String foodName,String price,OutputStream os) throws Exception{
		try {
			mdi.save(foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	
}
