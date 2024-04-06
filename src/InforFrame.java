
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class InforFrame extends JFrame{
    private JPanel inforPanel;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InforFrame frame = new InforFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public InforFrame() {
        setBounds(100, 100, 322, 257);
        inforPanel = new JPanel();
        inforPanel.setBackground(ColorManager.CANVAS_BACKGROUND);
        inforPanel.setBorder(new TitledBorder(null, "THÔNG TIN",
                            TitledBorder.CENTER, TitledBorder.TOP, null, ColorManager.TEXT));
        this.add(inforPanel);
        
        
        JTextArea infor = new JTextArea();
        infor.setEditable(false);
        infor.setFont(new Font("Arial", Font.PLAIN, 14));
        infor.setBackground(ColorManager.CANVAS_BACKGROUND);
        infor.setForeground(ColorManager.TEXT);
        infor.setText("Phần mềm: Mô phỏng thuật toán sắp xếp\r\n" +
                        "Môn: Cấu trúc dữ liệu và giải thuật\r\n" +
                        "Trung Đội: B10D53\r\n" +
                        "Nhóm: 01\r\n" +
                        "\r\n" +
                        "1. Nguyễn Phùng Trung Nguyên\r\n" +
                        "2. Đàm Ngọc San\r\n" +
                        "3. Phạm Hải Nam\r\n" +
                        "4. Lưu Nhật Duy\r\n" +
                        "Email: nguyenlak1404@gmail.com");
        inforPanel.add(infor);
    }

    
}
