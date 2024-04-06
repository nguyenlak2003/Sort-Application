
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class FormInput extends JFrame{
    
    private JPanel contentPanel;
    private JSpinner spNum;
    private int num;
    private int[] array;
    private JLabel[] Array;
    private JSpinner[] textArray;
    JButton doneButton;
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                setLockAndFeel();
                try {
                    FormInput formInput = new FormInput();
                    formInput.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    formInput.setVisible(true);
                } catch(Exception e){
                    
                }
            }

            private void setLockAndFeel() {
                try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    System.out.println("Cannot set Lock and Feel! Errors!");
		}
            }
            
        });
    }

    public FormInput() {
        setTitle("Nhập mảng");
        setBounds(100, 100, 504, 312);
        contentPanel = new JPanel();
        contentPanel.setBackground(SystemColor.menu);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPanel);
        contentPanel.setLayout(null);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        JLabel label = new JLabel("Số phần tử của mảng (tối đa 15)");
        label.setBounds(10, 8, 200, 25);
        contentPanel.add(label);
        
        SpinnerModel sm = new SpinnerNumberModel(2, 2, 15, 1);
        spNum = new JSpinner(sm);
        JFormattedTextField txt = ((JSpinner.NumberEditor) spNum.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
        spNum.setBounds(217, 8, 100, 25);
        contentPanel.add(spNum);	
        
        JButton createArrayButton = new JButton("Tạo mảng");
        createArrayButton.setBackground(SystemColor.activeCaption);
        createArrayButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                createArray();
            }

            private void createArray() {
                deleteArrays();
		num = (Integer)spNum.getValue();
		array = new int[num];
		Array = new JLabel[num];
		textArray = new JSpinner[num];
		
		for (int i = 0; i < num; i++) {
			Array[i] = new JLabel("A[" + i + "]:");
			SpinnerModel smValue = new SpinnerNumberModel(0, 0, 100, 1);
			textArray[i] = new JSpinner(smValue);
			JFormattedTextField txt = ((JSpinner.NumberEditor) textArray[i].getEditor()).getTextField();
			((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
			contentPanel.add(Array[i]);
			contentPanel.add(textArray[i]);
			Array[i].setSize(40,30);
			if (i == 0 || i == 5 || i == 10) 
                            Array[i].setLocation(150 * (i + 1)/5  , 40);
			else
                            Array[i].setLocation(Array[i-1].getX(), Array[i-1].getY() + 40);
			textArray[i].setSize(50,30);
			textArray[i].setLocation(Array[i].getX() + 40, Array[i].getY());
		}
		contentPanel.setVisible(true);
		contentPanel.validate();
		contentPanel.repaint();
            }

            private void deleteArrays() {
                for (int i = 0; i < num; i++) {
			Array[i].setVisible(false);
			textArray[i].setVisible(false);
			contentPanel.remove(Array[i]);
			contentPanel.remove(textArray[i]);
		}
            }
        });
        createArrayButton.setBounds(337, 8, 120, 25);
        contentPanel.add(createArrayButton);
        
        doneButton = new JButton("Xác nhận");
        doneButton.setBounds(185, 237, 120, 25);
        doneButton.setBackground(SystemColor.activeCaption);
        doneButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                isAccepted();
            }   
        });
        contentPanel.add(doneButton);
    }
    
    public void isAccepted() {
        for(int i = 0; i < num; i++)
        {
            array[i] = (int) textArray[i].getValue();
        }
        
        Frame[] listFrames = Frame.getFrames();
        ((Main) listFrames[0]).setArray(array);
        JOptionPane.showMessageDialog(this, "Đã tạo dữ liệu mảng thành công!\nChuẩn bị thoát!");
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
