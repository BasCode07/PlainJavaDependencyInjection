package com.bascode;

import java.util.Scanner;

class User{
	private String name;
	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}


interface UserInterfaceRepo{
	public User getUser(String name, int age);
	//public User getByAge(String age);
}

class UserRepoImpl implements UserInterfaceRepo{
	
	@Override
	public User getUser(String name, int age) {
		return new User(name, age);
	}
	
}

class UserService{
	private UserInterfaceRepo userRepo;
	
	public UserService(UserInterfaceRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public String getUserInfo(String name, int age) {
		User user = userRepo.getUser(name, age);
		return "User name: "+user.getName()+ " User age: "+user.getAge();  
	}
	
	
	
}



public class Application {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		
		UserInterfaceRepo userRepo= new UserRepoImpl();
		UserService userService = new UserService(userRepo);
		
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("Enter age: ");
		int age = input.nextInt();		
		
		
		String info =userService.getUserInfo(name, age);
	    System.out.println("You have provide us the following Info: "+info);
	   
	    input.close();

	}

}
