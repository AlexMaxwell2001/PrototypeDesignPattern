
package cs335_week_05;
import java.util.*; 

public class User {
	
	private String userName;
	private String level;
	private AccessControl accessControl;
	private static List<User>createdUser =new ArrayList<User>();;
	private int count = 0;
	
	public User(String userName,String level, AccessControl accessControl){
		this.userName = userName;
		this.level = level;
		this.accessControl = accessControl;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public AccessControl getAccessControl() {
		return accessControl;
	}
	public void setAccessControl(AccessControl accessControl) {
		this.accessControl = accessControl;
	}
	
	@Override
	public String toString(){
		return "Name: "+userName+", Level: "+level+", Access Control Level:"+accessControl.getControlLevel()+", Access: "+accessControl.getAccess();
	}
	 public boolean checkName(String name)
	 {
		 for(User user : createdUser)
		 {
			 if(user.getUserName().trim().equals(name))
			 {
				 System.out.println("I cannot create " + name + " this user already exists. Pick different name.");
				 return false;
			 }
		 }
		 return true;
	 }
	 public String viewAllUsers()
	 {
		 StringBuffer sb = new StringBuffer();
		 if(! this.accessControl.getControlLevel().contentEquals("SuperUser"))
		 {
			 return sb.append("VIEW DENIED.").toString();
		 }
			 sb.append("VIEW IS ALLOWED: " + createdUser.size() + " USER(s)\n");
			 for(User user : createdUser)
			 {
				 sb.append(user.getUserName() + " : " + user.getLevel() + " \n");
			 }
			 return sb.toString();
		 }
	 
	
	
}
