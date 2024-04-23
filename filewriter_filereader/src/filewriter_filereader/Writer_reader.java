package filewriter_filereader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Writer_reader extends JFrame{
	
	JLabel label;
	JButton write_button;
	JButton read_button;
	
	public Writer_reader() {
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//JLabelの組み込み
		String msg = "<html><h3>Welcome!</h3></html>";
		label = new JLabel(msg);
		label.setSize(200, 30);
		label.setLocation(20, 20);
		this.add(label);
		
		//JButtonの組み込み
		write_button = new JButton("Write");
		read_button = new JButton("Read");
		write_button.setSize(100, 25);
		write_button.setLocation(20, 80);
		read_button.setSize(100, 25);
		read_button.setLocation(200, 80);
		write_button.addActionListener(new ActionAdapter_Write(this));
		read_button.addActionListener(new ActionAdapter_Read(this));
		this.add(write_button);
		this.add(read_button);
		
		
	}
	
	public static void main(String[] args) {
		
		Writer_reader wr = new Writer_reader();
		
		//ウィンドウ自体の題名を設定
		wr.setTitle("FileWriter_Reader_System");
		
		//ウィンドウを表示
		wr.setVisible(true);
	}

}

class ActionAdapter_Write implements ActionListener {
	
	Writer_reader writer_reader;
	
	public ActionAdapter_Write(Writer_reader wr) {
		
		this.writer_reader = wr;
	}
	
	public void actionPerformed(ActionEvent ev) {
		
		BufferedWriter bwriter = null;
		
		try {
			FileWriter writer = new FileWriter("C:\\Users\\rirun\\OneDrive\\デスクトップ\\梨沙・計画、勉強\\開発練習その⑤\\text\\data.txt");
			bwriter = new BufferedWriter(writer);
			bwriter.write("This is Test.");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bwriter.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		writer_reader.label.setText("テキストファイルを更新しました。");
	}
}

class ActionAdapter_Read implements ActionListener {
	
	Writer_reader writer_reader;
	
	public ActionAdapter_Read(Writer_reader wr) {
		
		this.writer_reader = wr;
	}
	
	public void actionPerformed(ActionEvent ev) {
		
		String loaded = "";
		BufferedReader breader = null;
		
		try {
			FileReader reader = new FileReader("C:\\Users\\rirun\\OneDrive\\デスクトップ\\梨沙・計画、勉強\\開発練習その⑤\\text\\data.txt");
			breader = new BufferedReader(reader);
			
			String s = null;
			loaded = "";
			while((s = breader.readLine()) != null) {
				
				loaded += s.trim() + "\r\n";
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				breader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		writer_reader.label.setText("読み込み結果：" + loaded);

	}
	
	
}