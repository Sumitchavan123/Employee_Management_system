import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class DeleteEmp extends JFrame
{
Container c;
JLabel lblid;
JTextField txtid;
JButton btnSave,btnBack;

DeleteEmp()
{c=getContentPane();
 c.setLayout(new FlowLayout());
lblid=new JLabel("enter id");
txtid=new JTextField(20);
 btnSave=new JButton("Save");
 btnBack=new JButton("Back");

c.add(lblid);
c.add(txtid);
c.add(btnSave);
c.add(btnBack);

btnSave.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent ae)
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact=cfg.buildSessionFactory();

Session session=sfact.openSession();

Transaction t=null;
try
{
t=session.beginTransaction();
int id=Integer.parseInt(txtid.getText());
Emp e1=(Emp)session.get(Emp.class,id);
if(e1!= null)
{session.delete(e1);
  t.commit();
JOptionPane.showMessageDialog(c,"record deleted ");
txtid.setText("");
txtid.requestFocus();
}
else if(id<=0){
JOptionPane.showMessageDialog(c,"id should be greater than zero ");
}
else{
JOptionPane.showMessageDialog(c,"record does not exists");
txtid.setText("");
txtid.requestFocus();
}
}
catch (Exception e)
{
t.rollback();
JOptionPane.showMessageDialog(c,"id should contain only integers");
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

setTitle("Delete Emp");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

