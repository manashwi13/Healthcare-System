/*# Program to accept the names of doctors, the number of surgeries performed by them and print the total salaries.
Display the menu to arrange the salaries in ascending order, 
or arrange the names lexicographically in ascending order, 
or print the names of the doctors having the maximum and the minimum salary, 
or to enter the name of the doctor and find the total salary of that doctor.*/
import java.io.*;
public class MS_Polyclinic	
{//Start of class
    InputStreamReader read=new InputStreamReader (System.in);
    BufferedReader buf=new BufferedReader (read);
    String name[]= new String[5];
    double rev[]= new double[5];
    double sal[]= new double[5];
    int sur[]= new int[5];
    int sr_no[]=new int[5];
    String dept[]=new String[5];
    String phone_no[]=new String[5];
    String quali[]=new String[5];
    String app[]=new String[5];
    int c=0;
    String appoint[]= {"Monday and Wednesday from 1:00 pm to 3:00 pm","Tuesday and Thursday from 4:00pm to 6:00 pm","Friday and Saturday from 7:30 am to 9:30 am"};
    String dpt[]={"Medicine","Obstetrics & Gynaecology","Pediatrics","Anesthesiology","Ophthalmology"};
    String docqual[]={"MBBS, MD in ", "MBBS, Diploma in "};
    double bsal;
    String s="";
    char ch;
    int choice=0;
    
    //Default constructor
    MS_Polyclinic() throws IOException
    {//Start of MS_Polyclinic constructor
        bsal=30000;
        
        sr_no[0]= 1;
        name[0]= "Mamata Kapoor";
        dept[0]= "Cardiology";
        phone_no[0]= "9869004719";
        quali[0]= "MBBS, MD in Cardiology";
        app[0]= "Dr. Mamata Kapoor is available on Monday and Wednesday from 12:30 pm to 3:30pm.";
        sur[0]= 7;
        rev[0]= 3000;
        sal[0]= 33000;
        
        
        sr_no[1]= 2;
        name[1]= "Pravin Singh";
        dept[1]= "Obstetrics & Gynaecology";
        phone_no[1]= "8090911025";
        quali[1]= "MBBS, Diploma in Gynaecology";
        app[1]= "Dr. Pravin Singh is available on Tuesday, Thursday and Friday from 3:00 pm to 4:00 pm.";
        sur[1]= 2;
        rev[1]= 1500;
        sal[1]= 31500;
        
        sr_no[2]= 3;
        name[2]= "Rakesh Kumar";
        dept[2]= "Anesthesiology";
        phone_no[2]= "9954671101";
        quali[2]= "MBBS, MD in Anesthesiology";
        app[2]= "Dr. Rakesh Kumar is available on Saturday and Sunday from 7:00 pm to 8:30 pm.";
        sur[2]= 12;
        rev[2]= 4500;
        sal[2]= 34500;
        
        c=3; //Gives the number of records- number of doctors
        main(); //Calls main method
    }//End of MS_Polyclinic contructor
    
    public void main() throws IOException 
    {//Start of main method
        Welcome(); //Calls Welcome method
        To(); //Calls To method
        Metro(); //Calls Metro method
        Polyclinic(); //Calls Polyclinic method
        time(); //Calls time method
        System.out.println();
        Menu(); //Calls Menu method
    }//End of main method
    
    public void Menu() throws IOException
    {//Start of Menu method
       System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
       while(true)
       {
           do
           {
                try
                {
                    System.out.println("Enter 1 to see the doctor's menu.");
                    System.out.println("Enter 2 to exit.");
                    System.out.println("Enter your choice- (1,2)");
                    choice= Integer.parseInt (buf.readLine());
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Please enter digits only- (1 or 2)");
                }
                break;
           }while(true);
           
           switch(choice)
           {
                case 1:
                Doc_Menu();
                break;
                case 2:
                System.out.println("Thanks for using the Software.");
                System.exit(0);
                break;
                default: System.out.println("Please enter a valid number."); 
           }
       
           for( ;true; )
           {
                System.out.println("Would you like to continue?: (yes or no)");
                String s= buf.readLine();
                if(s.toLowerCase().equals("no"))
                {
                    System.out.print("\u000c");
                    Thanks();
                    time();
                    System.exit(0);
                }
                else if(s.toLowerCase().equals("yes"))  
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid choice.");
                    System.out.println("Please enter again.");
                    continue;
                }
           }
       }
    }//End of Menu method
    
    public void Doc_Menu() throws IOException 
    {//Start of Doc_Menu method
        System.out.println("\u000c");
        System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
        System.out.println("Menu:");
        int x=0;
        doctorMenu:
        do    
         {
            try
            {
            System.out.println("Enter 1 to accept the details of the doctor.");
            System.out.println("Enter 2 to arrange the doctors as per their final salary in ascending order.");
            System.out.println("Enter 3 to arrange the doctors as per their name in lexographical manner.");
            System.out.println("Enter 4 to find the maximum and minimum salary.");
            System.out.println("Enter 5 to find the salary of one particular doctor by searching for his/her name in the doctors' list.");
            System.out.println("Enter 6 to display the details of a doctor.");
            System.out.println("Enter 0 to go back to main menu.");
            System.out.println("Enter your choice-(0,1,2,3,4,5,6)");
            x= Integer.parseInt(buf.readLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter digits only.");
                continue;
            }
            if(x>6 && x<0)
            {
                System.out.println("Enter a valid digit from 0 to 6");;
            }
            
            switch(x)
            {
                case 0: System.out.println("Exiting Doctor Menu...Getting back to Main Menu");
                        return;
                case 1: Accept();
                        break;
                case 2: Salary();
                        break;
                case 3: Names();
                        break;
                case 4: MaxMin();
                        break;
                case 5: Drs_List();
                        break;
                case 6: Display();
                        break;
                default: System.out.println("Please enter digits from 0 to 6 only.");
                         continue doctorMenu;
            }
            while(true)
            {
                    System.out.println("Would you like to see doctor's menu again?: (Y/N)");
                    char a= (char) buf.read();
                    buf.readLine();
                    if(a=='Y' || a=='y')
                    {
                    System.out.println("\u000c");
                    continue doctorMenu;
                    }
                    else if(a=='N' || a=='n')
                    break doctorMenu;
                    else
                    {
                    System.out.println("Enter 'Y' or 'N'.");
                    continue;
                    }
            }
        }while(true);
        System.out.println("\u000c");
    }//End of Doc_Menu method
    
    public void Accept() throws IOException 
    {//Start of Accept method
        System.out.println("\u000c");
        System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
        int x=0;
        //Serial number
        sr_no[c]= c+1;
        
        //Checking for name validity
        name:
        do
        {
            System.out.println("Enter the name of the doctor:");
            name[c] = buf.readLine().trim();
            if(name[c].length()==0) 
            continue;
            for(int i=0;i<name[c].length();i++)
            {
                char ch1= name[c].charAt(i);
                if(Character.isLetter(ch1)|| ch1== ' '|| ch1=='.')
                continue;
                else
                {
                    System.out.println("Please enter a valid name.");
                    continue name;
                }
            }
            break;
        }while(true); 
        
        //Checking for Department
        do
        {
            System.out.println("Enter the department of the doctor:");
            for(int i=0;i<dpt.length;i++)
            {
                System.out.println(i+1+". "+dpt[i]);
            }
            try
            {
                System.out.println("Enter your choice- (1,2,3,4,5)");
                x= Integer.parseInt (buf.readLine());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter digits only.");
                continue;
            }
            if(x>=1 && x<=dpt.length)
            {
                dept[c]= dpt[x-1];
                break;
            }
            System.out.println("Enter a valid digit from 1 to "+ dpt.length);
        }while(true);
        
        //Checking for qualification
        do
        {
            System.out.println("Enter the qualification of the doctor:");
            for(int i=0;i<docqual.length;i++)
            {
                System.out.println(i+1+". "+docqual[i]+ dept[c]);
            }
            try
            {
                System.out.println("Enter Your choice- (1,2)");
                x= Integer.parseInt(buf.readLine());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter digits only.");
                continue;
            }
            if(x>=1 && x<=docqual.length)
            {
                quali[c] = docqual[x-1]+dept[c];
                break;
            }
            System.out.println("Enter a valid digit from 1 to "+ docqual.length);
        }while(true);
        
        //Checking for appointment
        do
        {
            System.out.println("Enter the time when the doctor is available:");
            for(int i=0;i<appoint.length;i++)
            {
                System.out.println(i+1+". "+appoint[i]);
            }
            try
            {
                System.out.println("Enter your choice- (1,2,3)");
                x= Integer.parseInt (buf.readLine());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter digits only.");
                continue;
            }
            if(x>=1 && x<=appoint.length)
            {
                app[c]= appoint[x-1];
                break;
            }
            System.out.println("Enter a valid digit from 1 to "+ appoint.length);
        }while(true);
        
        //Checking for phone number
        phone:
        do
        {
            System.out.println("Please enter the phone number.");
            String p_no= buf.readLine().trim();
            if(p_no.length()!=10)
            {
                System.out.println("Please enter a valid 10 digit phone number.");
                continue;
            }
            else 
            {
                for(int i=0;i<p_no.length();i++)
                {
                    if(!Character.isDigit(p_no.charAt(i)))
                    {
                        System.out.println("Please enter a valid 10 digit phone number- (only digits)");
                        continue phone;
                    }
                }
                phone_no[c]= p_no;
                break;
            }
        }while(true);
        
        //Checking for surgeries
        do
        {
            try
            {
                System.out.println("Enter the number of surgeries performed by "+name[c]);
                sur[c]= Integer.parseInt(buf.readLine());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter digits only.");
                continue;
            }
            if(sur[c]<=0)
            {
                 System.out.println("Please enter a positive number.");
                 continue;
            }
            break;
        }while(true);
        revenue();
        System.out.println("The total salary is: "+sal[c]);
        c++;
    }//End of Accept method
    
    public void revenue() 
    {//Start of revenue method
         if(sur[c]>=1 && sur[c]<=5)
        rev[c]= 0.05*bsal;
        else if(sur[c]>=6 && sur[c]<=10)
        rev[c]= 0.10*bsal;
        else if(sur[c]>=11 && sur[c]<=15)
        rev[c]= 0.15*bsal;
        else if(sur[c]>15)
        rev[c]=0.20*bsal;
        sal[c]= rev[c]+bsal;
    }//End of revenue method
    
    public void time()
    {//Start of time method
        for(double i=0;i<1000000000;i++)
        {
            ;
        }
    }//End of time method
    
    public void Salary()
    {//Start of Salary method
        System.out.println("\u000c");
        System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
        time();
        double t=0;
        String temp="";
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<c-1-i;j++)
            {
                if(sal[j]>sal[j+1])
                {
                    temp= name[j];
                    name[j]= name[j+1];
                    name[j+1]= temp;
                    t= sal[j];
                    sal[j]= sal[j+1];
                    sal[j+1]= t;
                }
            }
        }
        System.out.println("The salary in ascending order is:");
        System.out.println("Sr. No.\t\t\tName\t\t\tTotal Salary");
        for(int i=0;i<c;i++)
        {
            if(name[i]!=null)
            System.out.println(sr_no[i]+"                "+name[i]+"                "+sal[i]);
        }
        System.out.println();
        time();
    }//End of Salary method
    
    public void Names()
    {//Start of Names method
        System.out.println("\u000c");
        System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
        time();
        int m=0;
        String temp= "";
        String temp1= "";
        double t= 0;
        for(int i=0;i<c-1;i++)
        {
            for(int j=0;j<c-1-i;j++)
            {
                m=name[j].compareTo(name[j+1]);
                if(m>0)
                {
                    temp= name[j];
                    name[j]= name[j+1];
                    name[j+1]= temp;
                    t= sal[j];
                    sal[j]= sal[j+1];
                    sal[j+1]= t;
                }
            }
        }
        System.out.println("The names arranged lexicographically in ascending order are: ");
        System.out.println("Sr. No.\t\t\tName\t\t\tTotal Salary ");
        for(int i=0;i<c;i++)
        {
            System.out.println(sr_no[i]+"                "+name[i]+"                "+sal[i]);
        }
        System.out.println();
        time();
    }//End of Names method
    
    public void MaxMin()
    {//Start of MaxMin method
        System.out.println("\u000c");
        System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
        int i,j;
        double max=sal[0],min=sal[0];
        for(i=0;i<c;i++)
        {
            if(sal[i]>max)
            max= sal[i];
            else if(sal[i]<min)
            min= sal[i];
        }
        for(j=0;j<c;j++)
        {
            if(sal[j]==max)
            System.out.println("Dr. "+name[j]+" has the maximum salary of Rs. "+max);
            else if(sal[j]==min)
            System.out.println("Dr. "+name[j]+" has the minimum salary of Rs. "+min);
        }
    }//End of MaxMin method
    
    public void Drs_List() throws IOException 
    {//Start of Drs_List method
        System.out.println("\u000c");
        System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
        boolean flag= false;
        int i=0;
        String n="";
        nameLoop:
        do
        {
            System.out.println("Enter the name of the doctor whose salary you want to search:");
            n= buf.readLine();
            if(n.trim().length()==0)   
            continue;
            for(int k=0;k<n.length();k++)
            {
                char ch1= n.charAt(k);
                if(Character.isLetter(ch1) || ch1 == ' ' || ch1 == '.')
                continue;
                else
                {
                System.out.println("Please enter a valid name....");
                continue nameLoop;
                }
            }
            break;
        }while(true);
        for(i=0;i<c;i++)
        {
            if(name[i].equalsIgnoreCase(n))
            {
                flag=true;
                break;
            }
        }
        Searching();
        time();
        System.out.println();
        if(flag==true)
        {
        System.out.println("Name\t\t\tSalary");
        System.out.println(name[i]+"                "+sal[i]);
        }
        else if(flag==false)
        {
        System.out.println("Name not found.");
        }
        time();
    }//End of Drs_List method
    
    public void Searching()
    {//Start of Searching method
        System.out.print("Searching.");
        time();
        System.out.print(".");
        time();
        System.out.print(".");
        time();
        System.out.print(".");
    }//End of Searching method
    
    public void Display() throws IOException
    { //Start of Display method
        System.out.println("\u000c");
        System.out.println("\t\t\t\t\t**********WELCOME TO METRO POLYCLINIC**********");
        boolean flag= false;
        int i=0;
        String n="";
        nameLoop:
        do
        {
            System.out.println("Enter the name of the doctor whose details you want to be displayed:");
            n= buf.readLine();
            if(n.trim().length()==0)   
            continue;
            for(int k=0;k<n.length();k++)
            {
                char ch1= n.charAt(k);
                if(Character.isLetter(ch1) || ch1 == ' ' || ch1 == '.')
                continue;
                else
                {
                System.out.println("Please enter a valid name....");
                continue nameLoop;
                }
            }
            break;
        }while(true);
        for(i=0;i<c;i++)
        {
            if(name[i].equalsIgnoreCase(n))
            {
                flag=true;
                break;
            }
        }
        Searching();
        time();
        System.out.println();
        if(flag==true)
        {
        System.out.println("Name:\t"+name[i]);
        System.out.println("Department:\t"+dept[i]);
        System.out.println("Qualification:\t"+quali[i]);
        System.out.println("Phone number:\t"+phone_no[i]);
        System.out.println("Availability:\t"+app[i]);
        System.out.println("Number of surgeries performed:\t"+sur[i]);
        System.out.println("Total salary:\t"+sal[i]);
        }
        else if(flag==false)
        {
        System.out.println("Name not found.");
        }
        time();
    }
    
    public void Welcome()
    {//Start of Welcome method  
        System.out.println("\t\t\t\t\t               _ _ _ _ _               _ _ _ _ _   _ _ _ _ _    _ _   _ _    _ _ _ _ _ ");
        System.out.println("\t\t\t\t\t|          |  |           |           |           |         |  |   | |   |  |          ");
        System.out.println("\t\t\t\t\t|          |  |           |           |           |         |  |   | |   |  |          ");
        System.out.println("\t\t\t\t\t|          |  |           |           |           |         |  |   | |   |  |          ");  
        System.out.println("\t\t\t\t\t|          |  |           |           |           |         |  |   | |   |  |          ");  
        System.out.println("\t\t\t\t\t|    _     |  |           |           |           |         |  |   |_|   |  |          ");  
        System.out.println("\t\t\t\t\t|   | |    |  |------     |           |           |         |  |         |  |------    ");  
        System.out.println("\t\t\t\t\t|   | |    |  |           |           |           |         |  |         |  |          ");  
        System.out.println("\t\t\t\t\t|   | |    |  |           |           |           |         |  |         |  |          ");
        System.out.println("\t\t\t\t\t|   | |    |  |           |           |           |         |  |         |  |          ");
        System.out.println("\t\t\t\t\t|_ _| | _ _|  |_ _ _ _ _  |_ _ _ _ _  |_ _ _ _ _  |_ _ _ _ _|  |         |  |_ _ _ _ _ ");
        time();
        System.out.println("\u000c");
    }//End of Welcome method
    
    public void To()
    {//Start of To method
        System.out.println("\t\t\t\t\t\t\t_ _ _ _ _    _ _ _ _ _ ");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |         |");
        System.out.println("\t\t\t\t\t\t\t    |       |_ _ _ _ _|");
        time();
        System.out.println("\u000c");
    }//End of To method
    
    public void Metro()
    {//Start of Metro method
        System.out.println("\t\t\t\t\t _ _   _ _    _ _ _ _ _  _ _ _ _ _   _ _ _ _ _     _ _ _ _ _ ");
        System.out.println("\t\t\t\t\t|   | |   |  |               |      |         |   |         |");
        System.out.println("\t\t\t\t\t|   | |   |  |               |      |         |   |         |");
        System.out.println("\t\t\t\t\t|   | |   |  |               |      |         |   |         |");
        System.out.println("\t\t\t\t\t|   | |   |  |               |      |         |   |         |");
        System.out.println("\t\t\t\t\t|   |_|   |  |-------        |      |_ _ _ _ _|   |         |");
        System.out.println("\t\t\t\t\t|         |  |               |      |\\            |         |");
        System.out.println("\t\t\t\t\t|         |  |               |      |  \\          |         |");
        System.out.println("\t\t\t\t\t|         |  |               |      |    \\        |         |");
        System.out.println("\t\t\t\t\t|         |  |_ _ _ _ _      |      |      \\      |_ _ _ _ _|");
        time();
        System.out.println("\u000c");
    }//End of Metro method
    
    public void Polyclinic()
    {//Start of Polyclinic method
        System.out.println("\t\t\t _ _ _ _ _    _ _ _ _ _                            _ _ _ _ _                  _ _           _ _ _ _ _ ");
        System.out.println("\t\t\t|         |  |         |  |          |         |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|         |  |         |  |          |         |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|         |  |         |  |          |         |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|         |  |         |  |          |         |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|_ _ _ _ _|  |         |  |          |_ _ _ _ _|  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|            |         |  |                    |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|            |         |  |                    |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|            |         |  |                    |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|            |         |  |                    |  |           |           |  |   |   |  |  |          ");
        System.out.println("\t\t\t|            |_ _ _ _ _|  |_ _ _ _ _  _ _ _ _ _|  |_ _ _ _ _  |_ _ _ _ _  |  |   |_ _|  |  |_ _ _ _ _ ");
        time();
        System.out.println("\u000c");
    }//End of Polyclinic method
    
    public void Thanks()
    {//Start of Thanks method
        System.out.println("\t\t\t_ _ _ _ _                _ _ _ _ _    _ _                                    _ _ _ _ _              ");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  |    //        |         |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  |   //         |         |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  |  //          |         |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  | //           |         |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  |//            |_ _ _ _ _|  |         |  |         |");
        System.out.println("\t\t\t    |      |---------|  |---------|  |   |   |  |\\                       |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  | \\                      |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  |  \\                     |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |   |  |   \\                    |  |         |  |         |");
        System.out.println("\t\t\t    |      |         |  |         |  |   |_ _|  |    \\          _ _ _ _ _|  |_ _ _ _ _|  |_ _ _ _ _|");
        time();
        System.out.println("\u000c");
    }//End of Thanks method
}//End of class          
