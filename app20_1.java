package app999;

//app23_7, JList���m�ߡ]�G�^
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.util.Vector;         // ���Jutil���O�w�̪�Vector���O
import java.io.*;
public class app20_1
{
static JFrame frm=new JFrame("�\�I�H����ܾ�");
static Dialog dlg=new Dialog(frm);                    // �إ�Dialog����dlg
static Dialog dlg_end=new Dialog(frm);                    // �إ�Dialog����dlg

static JButton btn=new JButton("�ü��I�\");
static JButton Cancel_btn=new JButton("Cancel");
static JButton end_btn=new JButton("���\");
static JComboBox cb=new JComboBox();
static Container cp=frm.getContentPane();
static JList<String> lst1=new JList<String>();  // �إ�lst1����
static JList<String> lst2=new JList<String>();  // �إ�lst2����
static JMenuBar mb=new JMenuBar();             // �إ�MenuBar����
static JMenu menu1=new JMenu("USER");   //�إ߿��
static JMenu menu3 =new JMenu("����");
static JMenu menu2=new JMenu("Exit");   //�إ߿��
static JMenuItem mi4=new JMenuItem("����");  //���̫إ߿ﶵ
static JMenuItem mi6=new JMenuItem("�e�X");  //�e�X���
static JMenuItem mi5=new JMenuItem("close");  //���̫إ߿ﶵ
static JLabel end_lab = new JLabel();
static TextArea lab=new TextArea("",2,5,TextArea.SCROLLBARS_NONE);          // �إ�TextArea,�h���u�ʱ�
static Random Rom=new Random();
//static String str3=new String();
static Vector<String> v=new Vector<String>(); // �إ�Vector���O������v
static Vector<String> s_vector=new Vector<String>();

public static void main(String args[])throws IOException
{
    Font fnt=new Font("Serif",Font.ITALIC+Font.BOLD,24+Font.CENTER_BASELINE);

 FileReader fr=new FileReader("D:\\food.csv");
 BufferedReader bfr=new BufferedReader(fr);


 String str="";
 int a=1;
  while((str=bfr.readLine())!=null)   // �C��Ū���@��A�����ɮ׵���
     {
   String str1[]=str.split(",");
   String str2=Integer.toString(a)+" "+str1[0]+str1[1];
   s_vector.add(str2);
   a++;
     }
  String cc[]=new String[10];
  for(int i=0;i<10;i++){
   cc[i]=Integer.toString(i+1);
  }
   cb=new JComboBox(cc);
   cp.setLayout(new GridLayout(2,2));
   cp.add(new JScrollPane(lst1));   // �NJScrollPane�[�Jcp��
   cp.add(new JScrollPane(lst2));   // �NJScrollPane�[�Jcp��
   cp.add(btn);
   cp.add(cb);
   cb.setFont(fnt);
   btn.setFont(fnt);
   int r1=0;
   int g1=0;
   int b1=0;
   r1=(int)(Rom.nextInt(255));
   g1=(int)(Rom.nextInt(255));
   b1=(int)(Rom.nextInt(255));
   btn.setBackground(new Color(r1,g1,b1));
   cb.setBackground(new Color(r1,g1,b1));
   btn.setForeground(Color.white);
   cb.setForeground(Color.white);


   
   lab.setText("�I�\�ɽХ��I��z�ݭn�\�I"+"\n"+"�p�G�I���b������U"+"\n"+"���~���\�I�N�i����"+"\n"+"�̫��I�粒���̪��Ы��e�X");          // �b���Ҥ��[�W��r
   lab.setBackground(Color.white);     // �]�w���ҩ��⬰�զ�
   lab.setFont(fnt);                // �]�w�r�����˦�
   lab.setBounds(150,200,350,200);  //�]�w������m
   dlg.add(lab);     //�NTextArea�[�J�s������

   end_lab.setText("�I�\���\");          // �b���Ҥ��[�W��r
   end_lab.setBackground(Color.white);     // �]�w���ҩ��⬰�զ�
   end_lab.setForeground(Color.blue);      // �]�w���Ҥ�r���Ŧ�
   end_lab.setFont(fnt);                // �]�w�r�����˦�
   end_lab.setBounds(150,150,120,50);  //�]�w������m
   dlg_end.add(end_lab);     //�NTextArea�[�J�s������
   
   menu1.add(mi4);       //�Nmi4�[�J
   menu3.add(mi6);
   menu2.add(mi5);       //�Nmi5�[�J
   mb.add(menu1);   //�Nmenu�[�J
   mb.add(menu3);
   mb.add(menu2);   //�Nmenu�[�J
   
   dlg.setTitle("����"); // �]�w��ܤ�������D
   dlg.setSize(600,600);   // �]�w��ܤ�����j�p
   dlg.setLayout(null);
   Cancel_btn.setBounds(270,500,100,40);   //�]�w���s����m
   dlg.add(Cancel_btn);
   Cancel_btn.addActionListener(new ActLis());  // �]�wCancel_btn����ť��
   
   dlg_end.setTitle("�I�\���G"); // �]�w��ܤ�������D
   dlg_end.setLayout(null);
   dlg_end.setBackground(Color.green);       //�]�w�����C��
   dlg_end.setSize(400,400);   // �]�w��ܤ�����j�p
   end_btn.setBounds(160,310,100,40);   //�]�w���s����m
   dlg_end.add(end_btn);
   end_btn.addActionListener(new ActLis());  // �]�wCancel_btn����ť��
   
   int r=0;
   int g=0;
   int b=0;
   r=(int)(Rom.nextInt(255));
   g=(int)(Rom.nextInt(255));
   b=(int)(Rom.nextInt(255));
   lst1.setBackground(new Color(r,g,b));	
   lst2.setBackground(new Color(r,g,b));
   lst1.setForeground(Color.white);
   lst2.setForeground(Color.white);

   
   lst1.setListData(s_vector); 
   lst1.setFont(fnt);                // �]�w�r�����˦�
   lst2.setFont(fnt);                // �]�w�r�����˦�
   lst1.addMouseListener(new MouseLis());    // �]�wlst1���󪺶�ť��
   lst2.addMouseListener(new MouseLis()); 
   btn.addActionListener(new ActLis());
   
   mi5.addActionListener(new ActLis());   // �]�wfrm��mi5���ƥ��ť��
   mi6.addActionListener(new ActLis());
   mi4.addActionListener(new ActLis());   // �]�wfrm��mi4���ƥ��ť��
   frm.setJMenuBar(mb);    //�]�wmenubar
   frm.setSize(1200,500);
   frm.setVisible(true);
}
static class MouseLis extends MouseAdapter
{
   public void mouseClicked(MouseEvent e)
   {
      if(e.getSource()==lst1) {         // �Y�Olst1����Q���U
         if(e.getClickCount()==2)         // �p�G�s��Q���F��U
         {
            int index=lst1.getSelectedIndex();
            v.add(s_vector.get(index));                   // �N�r��str�[�J�V�qv
//            s_vector.remove(index);
            lst1.setListData(s_vector);
            lst2.setListData(v);    // �]�w�V�qv��lst2���󪺿��    
                     
         }
      }
      if(e.getSource()==lst2) {         // �Y�Olst1����Q���U
          if(e.getClickCount()==2)         // �p�G�s��Q���F��U
          {
             int index=lst2.getSelectedIndex();
             s_vector.add(v.get(index));                   // �N�r��str�[�J�V�qv
             v.remove(index);
             lst2.setListData(v);
             lst1.setListData(s_vector);    // �]�w�V�qv��lst2���󪺿��    
                      
          }
       }
   }
}
static class ActLis implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    Random r=new Random();
    Object mi=(Object) e.getSource();     // ���oĲ�o�ƥ󪺪���

    if(mi==btn) {
      for(int i=1;i<=Integer.parseInt((String)cb.getSelectedItem());i++){
       int p=r.nextInt(s_vector.size());
       v.add(s_vector.get(p));                   // �N�r��str�[�J�V�qv
//          s_vector.remove(p);
       	  lst1.setListData(s_vector);
          lst2.setListData(v);
      }
    }
      
		if(mi==mi6){						  //��btn�QĲ�o
			 dlg_end.setLocation(300,300);               // �]�w��ܤ������m
			 dlg_end.setVisible(true);                  // ��ܹ�ܤ��
			    BufferedWriter fw = null;
			    try {
			      File file = new File("D://food.txt");
			      fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // ���I�s�X�榡�A�H�KŪ���ɤ���r�Ų��`  
			      
			      for(int i1=0;i1<v.size();i1++) {
			       String num = v.get(i1);
			       fw.write(num);
			      }
			      fw.close();
			    }
			    catch (Exception e1) {
			      e1.printStackTrace();
			    } 
		}
		else if(mi==end_btn) {                  // �p�G�OCancel�s�Q��
			dlg_end.setVisible(false);                 // ���ù�ܤ��
	   }
		
	if(mi==mi5)                 // mi5Ĳ�o�ƥ�
		frm.dispose();                // ��������
    
    if(mi==mi4)                       // ���Umi4�s
    {
       dlg.setLocation(300,300);               // �]�w��ܤ������m
		 int r1=0;
		 int g1=0;
		 int b1=0;
		 r1=(int)(Rom.nextInt(255));
		 g1=(int)(Rom.nextInt(255));
		 b1=(int)(Rom.nextInt(255));
		 dlg.setBackground(new Color(r1,g1,b1));   //�]�w�����ܦ⾹
		 
		   int r2=0;
		   int g2=0;
		   int b2=0;
		   r2=(int)(Rom.nextInt(255));
		   g2=(int)(Rom.nextInt(255));
		   b2=(int)(Rom.nextInt(255));
		 lab.setForeground(new Color(r2,g2,b2));      // �]�w���Ҥ�r�ܦ⾹

       dlg.setVisible(true);                  // ��ܹ�ܤ��
    }
    else if(mi==Cancel_btn)             // �p�G�OCancel�s�Q��
       dlg.setVisible(false);                 // ���ù�ܤ��
           // ���ù�ܤ��

   }
}
}