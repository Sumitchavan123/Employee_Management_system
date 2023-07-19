import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.regex.Pattern;


class AddEmp extends JFrame
{
Container c;
JLabel lblid,lblName,lblSalary;
JTextField txtid,txtName,txtSalary;
JButton btnSave,btnBack;

AddEmp()
{c=getContentPane();
 c.setLayout(new FlowLayout());
lblid=new JLabel("enter id");
lblName=new JLabel("enter name");
txtid=new JTextField(20);
txtName=new JTextField(20);
lblSalary=new JLabel("enter Salary");
txtSalary=new JTextField(20);
 btnSave=new JButton("Save");
 btnBack=new JButton("Back");

c.add(lblid);
c.add(txtid);
c.add(lblName);
c.add(txtName);
c.add(lblSalary);
c.add(txtSalary);
c.add(btnSave);
c.add(btnBack);


btnSave.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();

Session session=sfact.openSession();

Transaction t=null;
try
{
t=session.beginTransaction();
Emp e1=new Emp();

int id=0;
double salary=0.0;
String name="";

try{
id=Integer.parseInt(txtid.getText());
e1.setid(id);
Emp e=(Emp)session.get(Emp.class,id);
if(e!=null)
{JOptionPane.showMessageDialog(c,"record already exists");
txtid.setText("");
txtName.setText("");
txtSalary.setText("");
txtid.requestFocus();
}
if(id<=0){
JOptionPane.showMessageDialog(c,"id should be greater than zero");
txtid.setText("");
txtid.requestFocus();
}


name=txtName.getText();
e1.setName(name);
if(name.length()<2){
JOptionPane.showMessageDialog(c,"name should have atleast 2 characters");
txtName.setText("");
txtName.requestFocus();
}

else if(Pattern.matches("[a-zA-Z]+",name) ){
}
else{
JOptionPane.showMessageDialog(c,"name should contain alphabets only");
txtName.setText("");
txtName.requestFocus();
}


try{
salary=Double.parseDouble(txtSalary.getText());
e1.setSalary(salary);
if(salary>=8000){
}
else{
JOptionPane.showMessageDialog(c,"salary should be atleast 8000");
txtSalary.setText("");
txtSalary.requestFocus();
}


if(id>=0 && (Pattern.matches("[a-zA-Z]+",name)) && salary>=8000 && (name.length()>=2)){
session.save(e1);        t.commit();
JOptionPane.showMessageDialog(c,"record added");
txtid.setText("");
txtName.setText("");
txtSalary.setText("");
txtid.requestFocus();
}


}
catch (NumberFormatException e3)
{t.rollback();
JOptionPane.showMessageDialog(c,"Salary should contain only integers");
txtSalary.setText("");
txtSalary.requestFocus();
}

}
catch (NumberFormatException e3)
{t.rollback();
JOptionPane.showMessageDialog(c,"id should contain only integers");
txtid.setText("");
txtid.requestFocus();
}

}
catch(Exception e4)
{t.rollback();

}
finally
{session.close();
}


}
});

btnBack.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{Employee a=new Employee();
dispose();
}
});

setTitle("Add Emp");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}}


