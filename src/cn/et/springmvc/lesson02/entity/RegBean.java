package cn.et.springmvc.lesson02.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegBean {
	/**
	 * NotNull 属性名 !=null
	 * NotNull 属性名 !=null && !属性名.equals("")
	 */
	@NotEmpty(message="用户名不能为空")
	private String userName;
	
	@NotEmpty(message="密码不能为空")
	private String password;
	
	@NotEmpty(message="确认密码不能为空")
	private String repassword;
	
	// *@qq.com  .+@.+\..+
	@Pattern(message="邮箱格式错误",regexp=".+@.+\\..+")
	private String email;
	
	private String age;
	
	@Size(max=11,min=11,message="手机号码格式错误")
	private String phone;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
