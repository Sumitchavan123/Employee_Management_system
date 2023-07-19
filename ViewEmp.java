import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import java.util.List;


class ViewEmp extends JFrame
{
Container c;
TextArea ta;
JButton btnBack;

ViewEmp()
{c=getContentPane();
 c.setLayout(new FlowLayout());
ta=new TextArea(5,30);
 btnBack=new JButton("Back");

c.add(ta);
c.add(btnBack);

btnBack.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{Employee a=new  Employee();
dispose();
}
});


setTitle("View Emp");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();
Session session=sfact.openSession();

try
{
List<Emp> emp=new ArrayList<>();
emp = session.createQuery("from Emp").list();
for(Emp e1:emp)
	ta.append("id:" +e1.getid() +" " +" name:"+ e1.getName()+ " salary:" + ""+e1.getSalary() +"\n");
}
catch (Exception e)
{
JOptionPane.showMessageDialog(c,e);
}
finally
{session.close();
}

}}
