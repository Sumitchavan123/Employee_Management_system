import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Employee extends JFrame 
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;

Employee()
{
Container c;
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);


btnAdd.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{AddEmp a=new AddEmp();
dispose();
}
});

btnView.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{ViewEmp a=new ViewEmp();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{UpdateEmp a=new UpdateEmp();
dispose();
}
});

btnDelete.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{DeleteEmp a=new DeleteEmp();
dispose();
}
});

setTitle("EMPLOYEE MANAGEMENT SYSTEM");
setSize(300,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}}

class EmployeeTest 
{
public static void main(String args[]){
Employee e=new Employee();
}
}

