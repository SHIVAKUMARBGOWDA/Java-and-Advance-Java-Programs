package student.edu;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDriver 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Student> al=new ArrayList<Student>();
		boolean flag=false;
		while(!flag)
		{	
			System.out.println("1.Add Student");
			System.out.println("2.Remove Student");
			System.out.println("3.Show Details");
			System.out.println("4.Modify Details");
			System.out.println("5.Exit");
			System.out.println("Enter the choice");
			int choice=sc.nextInt();
			switch(choice)
			{	
			case 1: 
			{
				System.out.println("Enter the name of Student");
				String name=sc.next();
				System.out.println("Enter the roll_no of Student");
				int roll_no=sc.nextInt();
				System.out.println("Enter the gender of Student");
				String gender=sc.next();
				System.out.println("Enter the phone number of Student");
				long ph_no=sc.nextLong();
				System.out.println("Enter the CGPA of Student");
				double cgpa=sc.nextDouble();
				boolean search=true;
				for(int i=0;i<al.size();i++)
				{
					if(new Student(name,roll_no,gender,ph_no,cgpa).equals(al.get(i)))
					{
						search=false;
						break;
					}
				}
				if(search)
				{
					al.add(new Student(name,roll_no,gender,ph_no,cgpa));
					System.out.println("Student details added successfully");
				}
				else
				{
					System.out.println("Student already found!..");
				}
			}
			break;
			case 2:
			{
				if(al.isEmpty())
				{
					System.out.println("No Students added yet");
				}
				else
				{
					for(int i=0;i<al.size();i++)
					{
						System.out.println((i+1)+" "+al.get(i).getName());
					}
					System.out.println("Which Student you want to remove");
					int choice1=sc.nextInt();
					al.remove(choice1-1);
					System.out.println(choice1+ " Student removed from database");
				}
			}
			break;
			case 3:
			{
				if(al.isEmpty())
				{
					System.out.println("No Student added yet");
				}
				else
				{
					for(int i=0;i<al.size();i++)
					{
						System.out.println((i+1)+" "+al.get(i).getName());
					}
					System.out.println("For which Student you want the details");
					int choice1=sc.nextInt();
					System.out.println(al.get(choice1-1));
				}
			}
			break;
			case 4:
			{
				if(al.isEmpty())
				{
					System.out.println("No Student added yet");
				}
				else
				{
					System.out.println("Enter the name of the Student");
					String s=sc.next();
					boolean name_flag=false;
					int index=0;
					for(int i=0;i<al.size();i++)
					{
						if(al.get(i).getName().equalsIgnoreCase(s))
						{
							name_flag=true;
							index=i;
						}
					}
					if(name_flag)
					{
						System.out.println("Student found with details");
						System.out.println();
						System.out.println("1.Name : "+al.get(index).getName());
						System.out.println("2.Roll_No : "+al.get(index).getRoll_no());
						System.out.println("3.Gender : "+al.get(index).getGender());
						System.out.println("4.Phone_No : "+al.get(index).getPh_no());
						System.out.println("5.CGPA : "+al.get(index).getCgpa());
						System.out.println();
						System.out.println("Which feild you want to modify");
						int feild_choice=sc.nextInt();
						switch(feild_choice)
						{
							case 1:
							{
								System.out.println("Enter the new Name");
								al.get(index).setName(sc.nextLine());
								System.out.println("Data Modified Successfully");
							}
							break;
							case 2:
							{
								System.out.println("Enter the new Roll_No");
								al.get(index).setRoll_no(sc.nextInt());
								System.out.println("Data Modified Successfully");
							}
							break;
							case 3:
							{
								System.out.println("Gender can't modify");
							}
							break;
							case 4:
							{
								System.out.println("Enter the new Phone Number");
								al.get(index).setPh_no(sc.nextLong());
								System.out.println("Data Modified Successfully");
							}
							break;
							
							default:
								System.out.println("Invalid Choice");
						}
					}
					else
					{
						System.out.println("No Student found with the name "+s);
					}
				}
			}
			
			case 5:
			{
				flag=true;
			}
			break;
			default:
				System.out.println("Invalid choice");
			}
		}
		
	}
}
