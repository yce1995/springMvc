package cn.et.springmvc.lesson03.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegBean {
	/**
	 * NotNull 属性名 !=null
	 * NotNull 属性名 !=null && !属性名.equals("")
	 */
	@NotEmpty(message="{userError}")
	private String userName;
	
	@NotEmpty(message="{passwordError}")
	private String password;
	
	@NotEmpty(message="{repasswordError}")
	private String repassword;
	
	// *@qq.com  .+@.+\..+
	@Pattern(message="{emailError}",regexp=".+@.+\\..+")
	private String email;
	
	@NotEmpty(message="{ageError1}")
	@Min(value=1,message="{ageError}")
	@Max(value=100,message="{ageError}")
	private String age;
	
	@Size(max=11,min=11,message="{phoneError}")
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
