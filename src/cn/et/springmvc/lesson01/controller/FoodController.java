package cn.et.springmvc.lesson01.controller;

import java.io.File;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.et.springmvc.lesson01.service.FoodService;
import cn.et.springmvc.lesson01.utils.PageTools;

@Controller
public class FoodController {
	@Autowired
	FoodService service;
	
	@RequestMapping(value="/showFood",method=RequestMethod.GET)
	public String queryFood(String dname,Integer curPage,Model model) throws Exception{
		if(curPage==null){
			curPage=1;
		}
		PageTools tableListPager = service.getTableListPager(dname,curPage);
		model.addAttribute("foodList", tableListPager);
		return "/detail/foodList.jsp";
	}
	
	@RequestMapping(value="/food/{foodId}",method=RequestMethod.GET)
	public String queryFoodId(@PathVariable String foodId,Model model) throws Exception{
		model.addAttribute("myFood", service.findId(foodId));
		return "/detail/detailFood.ftl"; 
	}
	

	@RequestMapping(value="/food/{foodId}",method=RequestMethod.POST)
	public String updateFood(@PathVariable String foodId,String foodName,String price,MultipartFile s,Model model) throws Exception{
		String fileName = s.getOriginalFilename();
		String absPath="D:\\apache-tomcat-6.0.45\\webapps\\s\\images";
		s.transferTo(new File(absPath+"\\"+fileName));
		service.updateFood(foodId, foodName, price, fileName);
		return queryFood(null,1, model); 
	}
	
	@RequestMapping(value="/addFood",method=RequestMethod.POST)
	public String addFood(String foodId,String foodName,String price,MultipartFile myImage,Model model) throws Exception{
		String fileName = myImage.getOriginalFilename();
		String absPath="D:\\apache-tomcat-6.0.45\\webapps\\s\\images";
		myImage.transferTo(new File(absPath+"\\"+fileName));
		service.saveFood(foodId, foodName, price, fileName);
		return queryFood(null,1, model);
	}
	
	@RequestMapping(value="/deletefood/{foodId}",method=RequestMethod.GET)
	public String deleteFood(@PathVariable String foodId,Model model) throws Exception{
		service.deleteFoodType(foodId);
		return queryFood(null,1, model); 
	}
	
   @RequestMapping(value="/dowload",method=RequestMethod.GET)
   public ResponseEntity<byte[]> fileDowload(String imagePath) throws Exception{
	   String absPath="D:\\apache-tomcat-6.0.45\\webapps\\s\\images\\"+imagePath;
       String fileName=imagePath;
       //需要下载的目标文件
       File file=new File(absPath);
       //设置响应头
       HttpHeaders hh=new HttpHeaders();
       //设置下载的文件的名称
       hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
       //读取目标文件为二进制数组
       byte[] fileByte=FileCopyUtils.copyToByteArray(file);
       //构建ResponseEntity对象
       ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte, hh, HttpStatus.CREATED);
       return re;
   }  
}
