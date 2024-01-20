// Customised Database Management System

class node
{
    private static int counter=1;

    public int Rno;
    public String Name;
    public String City;
    public int Marks;

    public node next;

    public node(String B, String C, int D)
    {
        Rno = counter;
        counter++;

        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    private node first;

    public DBMS()
    {
        first = null;
        System.out.println("DBMS initailised succesfully...");
        System.out.println("Student Table gets created succesfully...");
    }

    // InsertLast
    // insert into table student values(1,'Amit','Pune',89);
    public void InsertIntoTable(String Name, String City, int Marks)
    {
        node newn = new node(Name,City,Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }
        System.out.println("One record gets inserted succesfully...");
    }

  
    // select * from student;
    public void SelectStarFrom()
    {
        System.out.println("Data from the student table is : ");

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }


    
    // select * from studentn where city='----';
    public void SelectStarFromWhereCity(String str)
    {
        System.out.println("Data from the student table where city is : "+str);

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            if(str.equals(temp.City))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
                temp = temp.next;
            
        }
        System.out.println("--------------------------------------------------------------");
    }
// select Count(Marks) from student;
    public void selectcount()
    {
        node temp = first;
        int iCnt=0;

        while(temp!=null)
        {
            temp=temp.next;
            iCnt++;
        }

        System.out.println("Number of records in the table : "+iCnt);

    }

    // select sum(Marks) from student;
    public void selectsum()
    {
        node temp = first;
        int Sum=0;

        while(temp!=null)
        {
            Sum=Sum+temp.Marks;
            temp=temp.next;
        }

        System.out.println("Sum of Marks is : "+Sum);

    }

    // select Average(Marks) from student;
    public void selectAverage()
    {
        node temp = first;
        float Avg=0;
        float Sum=0;
        float iCnt=0;

        while(temp!=null)
        {
            Sum=Sum+temp.Marks;
            iCnt++;
            temp=temp.next;
        }
        Avg=Sum/iCnt;

        System.out.println("Average of Marks is : "+Avg);

    }

     // select Max(Marks) from student;
    public void selectmax()
    {
        node temp = first;
        
        int Max=0;

        if(temp!=null)
        {
            Max=temp.Marks;
        }

        while(temp!=null)
        {
            if(Max<temp.Marks)
            {
                Max=temp.Marks;
            }
            temp=temp.next;
            
        }
       

        System.out.println("Maximum of Marks is : "+Max);

    }

    // select Min(Marks) from student;
    public void selectmin()
    {
        node temp = first;
        
        int Min=0;

        if(temp!=null)
        {
            Min=temp.Marks;
        }

        while(temp!=null)
        {
            if(Min>temp.Marks)
            {
                Min=temp.Marks;
            }
            temp=temp.next;
            
        }
       

        System.out.println("Minimum of Marks is : "+Min);

    }

    //select * from student where Name='';

    public void SelectStarFromWhereName(String str)
    {
        System.out.println("--------------------------------------------------------------");

        System.out.println("Data from the student table where Name is : "+str);

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            if(str.equals(temp.Name))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
                temp = temp.next;
            
        }
        System.out.println("--------------------------------------------------------------");
    }


    // update student set city=" " where Rno="---";
    public void updateCity(int no, String str)
    {
                
        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            if(no==temp.Rno)
            {
                temp.City=str;            
                break;         
            }
                temp = temp.next;
        }
        System.out.println("Records Gets Updated Succesfully");

        System.out.println("--------------------------------------------------------------");

    }

    // update student set Name=" " where Rno="---";
    public void updateName(int no, String str)
    {
                
        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            if(no==temp.Rno)
            {
                temp.Name=str;            
                break;         
            }
                temp = temp.next;
        }
        System.out.println("Records Gets Updated Succesfully");

        System.out.println("--------------------------------------------------------------");

    }

    //delete from student where Rno=___;

    public void deletefrom(int no)
    {
        node temp=first;

        if(temp==null)
        {
            return;
        }

        //if first node is targeted node
        if(temp.Rno==no)
        {
            first=first.next;
            return;
        }

        while(temp.next!=null)
        {
            if(temp.next.Rno==no)
            {
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
    }

}

class Main
{
    public static void main(String Arg[])
    {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit","Pune",89);
        obj.InsertIntoTable("Pooja","Mumbai",95);
        obj.InsertIntoTable("Rahul","Satara",80);
        obj.InsertIntoTable("Neha","Pune",78);
        obj.InsertIntoTable("Gauri","Pune",85);
        obj.InsertIntoTable("Amit","Nagar",87);

        obj.SelectStarFrom();

        obj.SelectStarFromWhereCity("Pune");

        obj.selectcount();

        obj.selectsum();

        obj.selectAverage();

        obj.selectmax();

        obj.selectmin();

        obj.SelectStarFromWhereName("Amit");

        obj.updateCity(6,"Latur");

        obj.SelectStarFrom();

        obj.updateName(6,"Vishal");

        obj.SelectStarFrom();

        obj.deletefrom(5);

        obj.SelectStarFrom();

        obj.InsertIntoTable("Rukmini","Kolhapur",88);

        obj.SelectStarFrom();
    }
}



/* Supported Queries

1. insert into student values('Amit','Pune',70);

2.select * from student;

3.select * from student where city=""Pune"";

4.selectCount(Marks) from student;

5.selectsum(Marks) from student;

6. selectAverage(Marks) from student;

7.selectmax(Marks) from student;

8.selectmin(Marks) from student;

9.select * from student where Name="";

10. update student set city=" " where Rno="___";

11. update student set Name=" " where Rno="___";

12. delete from student where Rno=___;

*/