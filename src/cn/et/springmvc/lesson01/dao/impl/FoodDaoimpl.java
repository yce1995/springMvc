package cn.et.springmvc.lesson01.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson01.dao.FoodDao;



@Repository
public class FoodDaoimpl implements FoodDao  {
	@Autowired
	JdbcTemplate jdbc;
	
	 public Integer getTableListCount(String name) throws Exception{
        if(name==null){
            name="";
        }
        String sql="select count(*) as cr from foods where foodname like '%"+name+"%'";
        List<Map<String, Object>> result=jdbc.queryForList(sql);
        return Integer.parseInt(result.get(0).get("cr").toString());
	 }
	
	
    /* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.FoodDao#getTableListPager(java.lang.String)
	 */
   public List<Map<String, Object>> getTableListPager(String name,int startIndex,int length) throws Exception{

       String sql="select * from foods t where t.foodname like '%"+name+"%' limit "+startIndex+","+length;
       List<Map<String, Object>> result=jdbc.queryForList(sql);
       return result;
   }
   
   
   /* (non-Javadoc)
 * @see cn.et.springmvc.lesson01.dao.FoodDao#saveFood(java.lang.String, java.lang.String, java.lang.String)
 */
	public void saveFood(String foodid,String foodName,String price,String imagePath) throws Exception{
	       String sql="insert into foods values ('"+foodid+"','"+foodName+"','"+price+"','"+imagePath+"')";
	       jdbc.execute(sql);
	   }
	    
	   
	   /* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.FoodDao#updateFood(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateFood(String foodid,String foodName,String price,String path) throws Exception{
	       String sql="update foods set foodname='"+foodName+"',price='"+price+"',imagepath='"+path+"' where foodid="+foodid;
	       jdbc.execute(sql);
	   }
	   /* (non-Javadoc)
	 * @see cn.et.springmvc.lesson01.dao.FoodDao#deleteFoodType(java.lang.String)
	 */
	public void deleteFoodType(String foodid) throws Exception{
	       String sql="delete from foods where foodid= '"+foodid+"'";
	       jdbc.execute(sql);
	   }
	
	
	public Map<String, Object> findId(String foodid) {
		String sql="select * from foods t where t.foodid ="+foodid;
       List<Map<String, Object>> result=jdbc.queryForList(sql);
       return result.get(0);
	}
}
