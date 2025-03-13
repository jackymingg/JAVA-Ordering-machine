package app999;

//app23_7, JList的練習（二）
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.util.Vector;         // 載入util類別庫裡的Vector類別
import java.io.*;
public class app20_1
{
static JFrame frm=new JFrame("餐點隨機選擇器");
static Dialog dlg=new Dialog(frm);                    // 建立Dialog物件dlg
static Dialog dlg_end=new Dialog(frm);                    // 建立Dialog物件dlg

static JButton btn=new JButton("亂數點餐");
static JButton Cancel_btn=new JButton("Cancel");
static JButton end_btn=new JButton("成功");
static JComboBox cb=new JComboBox();
static Container cp=frm.getContentPane();
static JList<String> lst1=new JList<String>();  // 建立lst1物件
static JList<String> lst2=new JList<String>();  // 建立lst2物件
static JMenuBar mb=new JMenuBar();             // 建立MenuBar物件
static JMenu menu1=new JMenu("USER");   //建立選單
static JMenu menu3 =new JMenu("完成");
static JMenu menu2=new JMenu("Exit");   //建立選單
static JMenuItem mi4=new JMenuItem("說明");  //選單裡建立選項
static JMenuItem mi6=new JMenuItem("送出");  //送出菜單
static JMenuItem mi5=new JMenuItem("close");  //選單裡建立選項
static JLabel end_lab = new JLabel();
static TextArea lab=new TextArea("",2,5,TextArea.SCROLLBARS_NONE);          // 建立TextArea,去掉滾動條
static Random Rom=new Random();
//static String str3=new String();
static Vector<String> v=new Vector<String>(); // 建立Vector類別的物件v
static Vector<String> s_vector=new Vector<String>();

public static void main(String args[])throws IOException
{
    Font fnt=new Font("Serif",Font.ITALIC+Font.BOLD,24+Font.CENTER_BASELINE);

 FileReader fr=new FileReader("D:\\food.csv");
 BufferedReader bfr=new BufferedReader(fr);


 String str="";
 int a=1;
  while((str=bfr.readLine())!=null)   // 每次讀取一行，直到檔案結束
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
   cp.add(new JScrollPane(lst1));   // 將JScrollPane加入cp中
   cp.add(new JScrollPane(lst2));   // 將JScrollPane加入cp中
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


   
   lab.setText("點餐時請先點選您需要餐點"+"\n"+"如果點錯在雙擊兩下"+"\n"+"錯誤的餐點就可取消"+"\n"+"最後點選完成裡的請按送出");          // 在標籤內加上文字
   lab.setBackground(Color.white);     // 設定標籤底色為白色
   lab.setFont(fnt);                // 設定字型的樣式
   lab.setBounds(150,200,350,200);  //設定它的位置
   dlg.add(lab);     //將TextArea加入新視窗裡

   end_lab.setText("點餐成功");          // 在標籤內加上文字
   end_lab.setBackground(Color.white);     // 設定標籤底色為白色
   end_lab.setForeground(Color.blue);      // 設定標籤文字為藍色
   end_lab.setFont(fnt);                // 設定字型的樣式
   end_lab.setBounds(150,150,120,50);  //設定它的位置
   dlg_end.add(end_lab);     //將TextArea加入新視窗裡
   
   menu1.add(mi4);       //將mi4加入
   menu3.add(mi6);
   menu2.add(mi5);       //將mi5加入
   mb.add(menu1);   //將menu加入
   mb.add(menu3);
   mb.add(menu2);   //將menu加入
   
   dlg.setTitle("說明"); // 設定對話方塊的標題
   dlg.setSize(600,600);   // 設定對話方塊的大小
   dlg.setLayout(null);
   Cancel_btn.setBounds(270,500,100,40);   //設定按鈕的位置
   dlg.add(Cancel_btn);
   Cancel_btn.addActionListener(new ActLis());  // 設定Cancel_btn的傾聽者
   
   dlg_end.setTitle("點餐結果"); // 設定對話方塊的標題
   dlg_end.setLayout(null);
   dlg_end.setBackground(Color.green);       //設定視窗顏色
   dlg_end.setSize(400,400);   // 設定對話方塊的大小
   end_btn.setBounds(160,310,100,40);   //設定按鈕的位置
   dlg_end.add(end_btn);
   end_btn.addActionListener(new ActLis());  // 設定Cancel_btn的傾聽者
   
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
   lst1.setFont(fnt);                // 設定字型的樣式
   lst2.setFont(fnt);                // 設定字型的樣式
   lst1.addMouseListener(new MouseLis());    // 設定lst1物件的傾聽者
   lst2.addMouseListener(new MouseLis()); 
   btn.addActionListener(new ActLis());
   
   mi5.addActionListener(new ActLis());   // 設定frm為mi5的事件傾聽者
   mi6.addActionListener(new ActLis());
   mi4.addActionListener(new ActLis());   // 設定frm為mi4的事件傾聽者
   frm.setJMenuBar(mb);    //設定menubar
   frm.setSize(1200,500);
   frm.setVisible(true);
}
static class MouseLis extends MouseAdapter
{
   public void mouseClicked(MouseEvent e)
   {
      if(e.getSource()==lst1) {         // 若是lst1物件被按下
         if(e.getClickCount()==2)         // 如果連續被按了兩下
         {
            int index=lst1.getSelectedIndex();
            v.add(s_vector.get(index));                   // 將字串str加入向量v
//            s_vector.remove(index);
            lst1.setListData(s_vector);
            lst2.setListData(v);    // 設定向量v為lst2物件的選單    
                     
         }
      }
      if(e.getSource()==lst2) {         // 若是lst1物件被按下
          if(e.getClickCount()==2)         // 如果連續被按了兩下
          {
             int index=lst2.getSelectedIndex();
             s_vector.add(v.get(index));                   // 將字串str加入向量v
             v.remove(index);
             lst2.setListData(v);
             lst1.setListData(s_vector);    // 設定向量v為lst2物件的選單    
                      
          }
       }
   }
}
static class ActLis implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    Random r=new Random();
    Object mi=(Object) e.getSource();     // 取得觸發事件的物件

    if(mi==btn) {
      for(int i=1;i<=Integer.parseInt((String)cb.getSelectedItem());i++){
       int p=r.nextInt(s_vector.size());
       v.add(s_vector.get(p));                   // 將字串str加入向量v
//          s_vector.remove(p);
       	  lst1.setListData(s_vector);
          lst2.setListData(v);
      }
    }
      
		if(mi==mi6){						  //當btn被觸發
			 dlg_end.setLocation(300,300);               // 設定對話方塊的位置
			 dlg_end.setVisible(true);                  // 顯示對話方塊
			    BufferedWriter fw = null;
			    try {
			      File file = new File("D://food.txt");
			      fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常  
			      
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
		else if(mi==end_btn) {                  // 如果是Cancel鈕被按
			dlg_end.setVisible(false);                 // 隱藏對話方塊
	   }
		
	if(mi==mi5)                 // mi5觸發事件
		frm.dispose();                // 關閉視窗
    
    if(mi==mi4)                       // 按下mi4鈕
    {
       dlg.setLocation(300,300);               // 設定對話方塊的位置
		 int r1=0;
		 int g1=0;
		 int b1=0;
		 r1=(int)(Rom.nextInt(255));
		 g1=(int)(Rom.nextInt(255));
		 b1=(int)(Rom.nextInt(255));
		 dlg.setBackground(new Color(r1,g1,b1));   //設定視窗變色器
		 
		   int r2=0;
		   int g2=0;
		   int b2=0;
		   r2=(int)(Rom.nextInt(255));
		   g2=(int)(Rom.nextInt(255));
		   b2=(int)(Rom.nextInt(255));
		 lab.setForeground(new Color(r2,g2,b2));      // 設定標籤文字變色器

       dlg.setVisible(true);                  // 顯示對話方塊
    }
    else if(mi==Cancel_btn)             // 如果是Cancel鈕被按
       dlg.setVisible(false);                 // 隱藏對話方塊
           // 隱藏對話方塊

   }
}
}