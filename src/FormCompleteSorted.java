
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class FormCompleteSorted extends JFrame{
    private final JPanel contentPanel = new JPanel();
    public FormCompleteSorted() {
		setBounds(100, 100, 122, 75);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		{
			JLabel lbComplete = new JLabel("\u0110\u00E3 s\u1EAFp x\u1EBFp xong");
			lbComplete.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lbComplete);
		}
	}
}
