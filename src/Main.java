
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Highlighter;
import javax.swing.text.NumberFormatter;

public class Main extends JFrame {

    private static final int N = 100000;
    private JPanel contentPanel;
    private JLabel labelTitle;
    private JPanel panelTool;
    private JPanel panelArray;
    private JPanel panelCode;
    private JPanel panelAlgorithm;
    private JPanel panelControl;
    private JSlider sliderSpeed;
    private JButton startButton;
    private JButton stopButton;
    private JRadioButton buttonBubbleSort, buttonSelectionSort, buttonInsertionSort, buttonQuickSort, buttonMergeSort, buttonHeapSort;
    private JSlider sliderSize;
    private JScrollPane scrollPane;
    private DefaultListModel<String> model;
    private JList<String> listCode;
    private JPanel createArrayPanel;
    private JPanel setValueArrayPanel;
    private JButton randomButton;
    private JButton byHandButton;
    private JButton openFileButton;
    private JButton readFileButton;
    private JLabel numLabel, maxNumLabel;
    private JSpinner numSpinner;
    private JButton createArrayButton, deleteArrayButton, setZeroButton;
    private JPanel initiatePanel;
    private ButtonGroup groupSort;
    private ActionListener actionSelectionSort, actionBubbleSortSort, actionInsertionSort, actionQuickSort, actionHeapSort, actionMergeSort;
    private JButton inforButton;
    private ChangeListener actionSize, actionSpeed;
    private int time = 50, num;
    private JLabel labelPoint1 = new JLabel();
    private JLabel labelPoint2 = new JLabel();
    private JLabel labelPointM = new JLabel();
    private JLabel[] Array;
    private int[] array;
    private int curT;
    private Thread[] threads = new Thread[N];
    private File file = new File("src//array.txt");
    private int[] oriLocation = new int[15];

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                setLockAndFeel();
                try {
                    Main frame = new Main();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } catch (Exception e) {
                }
            }

        });
    }

    /*
    * Create the Main Frame
     */
    public Main() {
        setTitle("Mô phỏng thuật toán sắp xếp");
        setBounds(290, 100, 1375, 770);

        contentPanel = new JPanel();
        contentPanel.setBackground(ColorManager.BACKGROUND);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.add(contentPanel);
        contentPanel.setLayout(null);

        labelTitle = new JLabel("MÔ PHỎNG THUẬT TOÁN SẮP XẾP");
        labelTitle.setBounds(5, 5, 1286, 28);
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setFont(new Font("Lăk", Font.BOLD, 23));
        labelTitle.setForeground(ColorManager.TEXT);
        contentPanel.add(labelTitle);

        panelTool = new JPanel();
        panelTool.setBounds(5, 415, 1350, 290);
        panelTool.setBackground(ColorManager.BACKGROUND);
        contentPanel.add(panelTool);

        panelArray = new JPanel();
        panelArray.setBackground(ColorManager.BACKGROUND);
        panelArray.setBorder(new TitledBorder(null, "Dữ liệu", TitledBorder.LEADING, TitledBorder.TOP, null, ColorManager.TEXT));

        panelCode = new JPanel();
        panelCode.setBackground(ColorManager.BACKGROUND);
        panelCode.setBorder(new TitledBorder(null, "Code Java", TitledBorder.LEADING, TitledBorder.TOP, null, ColorManager.TEXT));

        panelAlgorithm = new JPanel();
        panelAlgorithm.setBackground(ColorManager.BACKGROUND);
        panelAlgorithm.setBorder(new TitledBorder(null, "Thuật toán", TitledBorder.LEADING, TitledBorder.TOP, null, ColorManager.TEXT));

        panelControl = new JPanel();
        panelControl.setBackground(ColorManager.BACKGROUND);
        panelControl.setBorder(new TitledBorder(null, "Điều khiển", TitledBorder.LEADING, TitledBorder.TOP, null, ColorManager.TEXT));

        GroupLayout groupLayoutPanelTool = new GroupLayout(this.panelTool);
        groupLayoutPanelTool.setHorizontalGroup(
                groupLayoutPanelTool.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayoutPanelTool.createSequentialGroup()
                                .addComponent(panelArray, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panelCode, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panelAlgorithm, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
        );
        groupLayoutPanelTool.setVerticalGroup(
                groupLayoutPanelTool.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(panelArray, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addComponent(panelCode, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addComponent(panelAlgorithm, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addComponent(panelControl, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        panelTool.setLayout(groupLayoutPanelTool);

        /*
        * Control Panel
         */
        panelControl.setLayout(null);

        sliderSpeed = new JSlider(JSlider.HORIZONTAL, 10, 90, time);
        sliderSpeed.setMajorTickSpacing(10);
        sliderSpeed.setMinorTickSpacing(5);
        sliderSpeed.setPaintTicks(true);
        sliderSpeed.setPaintTrack(true);
        sliderSpeed.setBounds(35, 30, 244, 32);
        panelControl.add(sliderSpeed);

        actionSpeed = new  ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                time = 100 - sliderSpeed.getValue();
            }
        };
        sliderSpeed.addChangeListener(actionSpeed);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!isSorted())
                {
                    setState(3);
                    for(int i = 0; i < num; i++)
                        Array[i].setForeground(ColorManager.BEFORE_SORT);

                    if(buttonBubbleSort.isSelected()){
                        BubbleSort();
                    }
                    if(buttonSelectionSort.isSelected()){
                        SelectionSort();
                    }
                    if(buttonInsertionSort.isSelected()){
                        InsertionSort();
                    }
                    if(buttonMergeSort.isSelected()){
                        MergeSort();
                    }
                    if(buttonHeapSort.isSelected()){
                        HeapSort();
                    }
                    if(buttonQuickSort.isSelected()){
                        QuickSort();
                    }
                    wasSorted();
                }
            }
        });
        startButton.setBounds(95, 140, 120, 30);
        panelControl.add(startButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteArray();
                setState(0);
            }

        });
        stopButton.setBounds(95, 182, 120, 30);
        panelControl.add(stopButton);

        inforButton = new JButton("Info");
        inforButton.setBounds(95, 220, 120, 30);
        panelControl.add(inforButton);

        inforButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                InforFrame frame = new InforFrame();
                frame.setVisible(true);
            }     
        });

        /*
        * Algorithm Panel
         */

        panelAlgorithm.setLayout(null);

        buttonBubbleSort = new JRadioButton("Bubble Sort");
        buttonBubbleSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonBubbleSort.setBounds(24, 44, 149, 23);
        buttonBubbleSort.setForeground(ColorManager.TEXT);
        panelAlgorithm.add(buttonBubbleSort);

        buttonSelectionSort = new JRadioButton("Selection Sort");
        buttonSelectionSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonSelectionSort.setBounds(24, 75, 149, 23);
        buttonSelectionSort.setForeground(ColorManager.TEXT);
        panelAlgorithm.add(buttonSelectionSort);

        buttonInsertionSort = new JRadioButton("Insertion Sort");
        buttonInsertionSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonInsertionSort.setBounds(24, 106, 149, 23);
        buttonInsertionSort.setForeground(ColorManager.TEXT);
        panelAlgorithm.add(buttonInsertionSort);

        buttonMergeSort = new JRadioButton("Merge Sort");
        buttonMergeSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonMergeSort.setBounds(24, 137, 149, 23);
        buttonMergeSort.setForeground(ColorManager.TEXT);
        panelAlgorithm.add(buttonMergeSort);

        buttonHeapSort = new JRadioButton("Heap Sort");
        buttonHeapSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonHeapSort.setBounds(24, 168, 149, 23);
        buttonHeapSort.setForeground(ColorManager.TEXT);
        panelAlgorithm.add(buttonHeapSort);

        buttonQuickSort = new JRadioButton("Quick Sort");
        buttonQuickSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
        buttonQuickSort.setBounds(24, 199, 149, 23);
        buttonQuickSort.setForeground(ColorManager.TEXT);
        panelAlgorithm.add(buttonQuickSort);

        groupSort = new ButtonGroup();
        groupSort.add(buttonBubbleSort);
        groupSort.add(buttonInsertionSort);
        groupSort.add(buttonSelectionSort);
        groupSort.add(buttonHeapSort);
        groupSort.add(buttonMergeSort);
        groupSort.add(buttonQuickSort);

        /*
        * Code Panel
         */

        panelCode.setLayout(null);

        sliderSize = new JSlider();
        sliderSize.setMaximum(25);
        sliderSize.setMinimum(10);
        sliderSize.setValue(14);
        sliderSize.setBounds(20, 21, 466, 26);
        panelCode.add(sliderSize);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(15, 53, 476, 223);
        panelCode.add(scrollPane);

        model = new DefaultListModel<>();
        listCode = new JList<String>(model);
        listCode.setBorder(new LineBorder(ColorManager.TEXT));
        listCode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listCode.setFont(new Font("Arial", Font.BOLD, 14));
        listCode.setSelectedIndex(0);
        listCode.ensureIndexIsVisible(listCode.getSelectedIndex());
        scrollPane.setViewportView(listCode);

        actionSelectionSort = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeAllElements();
                addSelectionSort();
                listCode.setSelectedIndex(0);
            }

            public void addSelectionSort() {
                model.addElement("void SelectionSort(int a[], int n) {");
                model.addElement("     for (int i = 0; i < n - 1; i++) {");
                model.addElement("          int pos = i;");
                model.addElement("          for(j = i + 1; j < N; j++)");
                model.addElement("               if (a[j] < a[pos])");
                model.addElement("                    pos = j;");
                model.addElement("               Swap(a[pos], a[i]);");
                model.addElement("     }");
                model.addElement("}");
            }
        };

        actionBubbleSortSort = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeAllElements();
                addBubbleSort();
                listCode.setSelectedIndex(0);
            }

            private void addBubbleSort() {
                model.addElement("void BubbleSort(int a[],int n) {");
                model.addElement("     int i, j;");
                model.addElement("     for (i = 0; i < n - 1; i++)");
                model.addElement("          for (j = n - 1; j > i; j --)");
                model.addElement("               if(a[j] < a[j-1])");
                model.addElement("                    Swap(a[j], a[j-1]");
                model.addElement("}");
            }
        };

        actionInsertionSort = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeAllElements();
                addInsertionSort();
                listCode.setSelectedIndex(0);
            }

            private void addInsertionSort() {
                model.addElement("void InsertionSort(int a[], int n ) {");
                model.addElement("     int pos, i;");
                model.addElement("     int x;");
                model.addElement("     for(i = 1; i < n; i++) {"); 
                model.addElement("          x = a[i];");
                model.addElement("          pos = i - 1;");
                model.addElement("          while ((pos >= 0) && (a[pos] > x)) {");
                model.addElement("               a[pos+1] = a[pos];");
                model.addElement("               pos--;");
                model.addElement("          }");
                model.addElement("     a[pos+1] = x];");
                model.addElement("     }");
                model.addElement("}");
        }
        };

        actionMergeSort = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeAllElements();
                addMergeSort();
                listCode.setSelectedIndex(0);
            }

            private void addMergeSort() {
               model.addElement("public static void merge(int[] arr, int low, int mid, int high) {");
                model.addElement("     int[] left = new int[mid - low + 1];");
                model.addElement("     int[] right = new int[high - mid];");
                model.addElement("     for(int i = 0; i < left.length; i++);");
                model.addElement("          left[i] = arr[low + i];");
                model.addElement("     for(int i = 0; i < right.length; i++)");
                model.addElement("          right[i] = arr[mid + 1 + i];");
                model.addElement("     int i = 0, j = 0;");
                model.addElement("     for(int k = low; k <= high; k++){");
                model.addElement("         if(i < left.length && j < right.length){");
                model.addElement("              if(left[i] < right[j]){");
                model.addElement("                  arr[k] = left[i];");
                model.addElement("                  i++;");
                model.addElement("          } else {");
                model.addElement("              arr[k] = right[j];");
                model.addElement("              j++;");
                model.addElement("          }");
                model.addElement("          } else if(i < left.length){");
                model.addElement("              arr[k] = left[i];");
                model.addElement("              i++;");
                model.addElement("              k++");
                model.addElement("          } else{");
                model.addElement("              arr[k] = right[j];");
                model.addElement("              j++;");
                model.addElement("              k++;");
                model.addElement("          }");
                model.addElement("      }");
                model.addElement("      public static void sort(int[] arr, int low, int high){");
                model.addElement("          if(low < high){");
                model.addElement("              int mid = (low + high) / 2;");
                model.addElement("              sort(arr, low, mid);");
                model.addElement("              sort(arr, mid + 1, high);");
                model.addElement("              merge(arr, low, mid, high);");
                model.addElement("          }");
                model.addElement("      }");
                model.addElement("}");
            }
        };

        actionHeapSort = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeAllElements();
                addHeapSort();
                listCode.setSelectedIndex(0);
            }

            private void addHeapSort() {
                model.addElement("public class HeapSort{");
                model.addElement("      public static void heapSort(int[] arr){");
                model.addElement("          int n = arr.length;");
                model.addElement("          for(int i = n / 2 - 1; i >= 0; i--)");
                model.addElement("              heapify(arr, n, i);");
                model.addElement("          for(int i = n - 1; i >= 0; i--){");
                model.addElement("              int tmp = arr[0];");
                model.addElement("              arr[0] = arr[i];");
                model.addElement("              arr[i] = tmp;");
                model.addElement("              heapify(arr, i, 0);");
                model.addElement("          }");
                model.addElement("      }");
                model.addElement("      private static void heapify(int[] arr, int n, int i){");
                model.addElement("          int max = i;");
                model.addElement("          int left = 2 * i + 1;");
                model.addElement("          int right = 2 * i + 2;");
                model.addElement("          if(left < n && arr[left] > arr[max])");
                model.addElement("              max = left;");
                model.addElement("          if(right < n && arr[right] > arr[max])");
                model.addElement("              max = right;");
                model.addElement("          if(max != i){");
                model.addElement("              int tmp = arr[i];");
                model.addElement("              arr[i] = arr[max];");
                model.addElement("              arr[max] = tmp;");
                model.addElement("              heapify(arr, n, max);");
                model.addElement("          }");
                model.addElement("      }");
                model.addElement("}");
            }
        };

        actionQuickSort = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeAllElements();
                addQuickSort();
                listCode.setSelectedIndex(0);
            }

            private void addQuickSort() {
                model.addElement("public class QuickSort{");
                model.addElement("     public static void sort(int[] arr, int d, int c){");
                model.addElement("         if(d < c){");
                model.addElement("              int key = arr[c];");
                model.addElement("              int i = d;");
                model.addElement("              int j = c - 1;");
                model.addElement("          }");
                model.addElement("          while(i < j){");
                model.addElement("              while(i < c && arr[i] <= key)");
                model.addElement("                  i++;");
                model.addElement("              while(j >= d && arr[j] > key");
                model.addElement("                  j++;");
                model.addElement("              if(i < j)");
                model.addElement("                  swap(arr, i, j);");
                model.addElement("          }");
                model.addElement("          swap(arr, i, c);");
                model.addElement("          sort(arr, d, i);");
                model.addElement("          sort(arr, i + 1, c);");
                model.addElement("      }");
                model.addElement("      public static void swap(int[] arr, int x, int y){");
                model.addElement("          int tmp = arr[i];");
                model.addElement("          arr[i] = arr[j];");
                model.addElement("          arr[j] = tmp;");
                model.addElement("      }");
            }
        };

        actionSize = (ChangeEvent e) -> {
            listCode.setFont(new Font("Arial", Font.BOLD, sliderSize.getValue()));
            listCode.repaint();   
        };
        sliderSize.addChangeListener(actionSize);

        buttonBubbleSort.addActionListener(actionBubbleSortSort);
        buttonSelectionSort.addActionListener(actionSelectionSort);
        buttonInsertionSort.addActionListener(actionInsertionSort);
        buttonMergeSort.addActionListener(actionMergeSort);
        buttonHeapSort.addActionListener(actionHeapSort);
        buttonQuickSort.addActionListener(actionQuickSort);

        /*
        * Create Array Panel
         */

        createArrayPanel = new JPanel();
        createArrayPanel.setBackground(ColorManager.BACKGROUND);
        createArrayPanel.setBorder(new TitledBorder(null, "Khởi tạo mảng", TitledBorder.LEADING, TitledBorder.TOP, null, ColorManager.TEXT));

        setValueArrayPanel = new JPanel();
        setValueArrayPanel.setBackground(ColorManager.BACKGROUND);
        setValueArrayPanel.setBorder(new TitledBorder(null, "Tạo dữ liệu mạng", TitledBorder.LEADING, TitledBorder.TOP, null, ColorManager.TEXT));
        GroupLayout GLPanelArray = new GroupLayout(panelArray);
        GLPanelArray.setHorizontalGroup(
                GLPanelArray.createParallelGroup(Alignment.LEADING)
                        .addComponent(setValueArrayPanel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                        .addComponent(createArrayPanel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );
        GLPanelArray.setVerticalGroup(
                GLPanelArray.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.LEADING, GLPanelArray.createSequentialGroup()
                                .addComponent(createArrayPanel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(setValueArrayPanel, GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE))
        );
        panelArray.setLayout(GLPanelArray);

        randomButton = new JButton("Ngẫu nhiên");
        //randomButton.setBackground(SystemColor.activeCaption);
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomArray();
            }
        });
        randomButton.setBounds(15, 27, 120, 25);

        byHandButton = new JButton("Bằng tay");
        byHandButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormInput formInput = new FormInput();
                formInput.setVisible(true);
                setState(3);
            }
        });
        //byHandButton.setBackground(SystemColor.activeCaption);
        byHandButton.setBounds(160, 27, 120, 25);

        openFileButton = new JButton("Mở bằng file");
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop desktop = null;
                    if(Desktop.isDesktopSupported()){
                        desktop = Desktop.getDesktop();
                    }
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //openFileButton.setBackground(SystemColor.activeCaption);
        openFileButton.setBounds(15, 61, 120, 25);

        readFileButton = new JButton("Đọc file");
        readFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteArray();
                try {
                    Scanner input = new Scanner(file);
                    num = Integer.parseInt(input.nextLine());
                    array = new int[num];
                    Array = new JLabel[num];

                    int pos = 0;
                    while(input.hasNextLine()){
                        array[pos++] = Integer.parseInt(input.nextLine());
                    }
                    input.close();


                    for(int i = 0; i < num; i++)
                    {
                        Array[i] = new JLabel(String.valueOf(array[i]));
                        initiatePanel.add(Array[i]);

                        Array[i].setSize(50, 50);
                        Array[i].setOpaque(true);
                        Array[i].setForeground(ColorManager.CREATE_TEXT);
                        Array[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
                        Array[i].setBackground(ColorManager.SORT_BACKGROUND);
                        Array[i].setHorizontalAlignment(SwingConstants.CENTER);
                        Array[i].setVerticalAlignment(SwingConstants.CENTER);

                        if(i == 0){
                            Array[i].setLocation((int) ((18 - num) * 0.5 * 70) + 100, 150);
                        }
                        else{
                            Array[i].setLocation(Array[i - 1].getX() + 70, Array[i - 1].getY());
                        }       
                    }

                    initiatePanel.setVisible(true);
                    initiatePanel.validate();
                    initiatePanel.repaint();
                    setState(2);

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();                
                }
            }
        });
        //readFileButton.setBackground(SystemColor.activeCaption);
        readFileButton.setBounds(160, 61, 120, 25);

        setValueArrayPanel.setLayout(null);
        setValueArrayPanel.add(openFileButton);
        setValueArrayPanel.add(randomButton);
        setValueArrayPanel.add(readFileButton);
        setValueArrayPanel.add(byHandButton);

        numLabel = new JLabel("Số phần tử mảng");
        numLabel.setForeground(ColorManager.TEXT);
        numLabel.setBounds(16, 27, 139, 20);

        maxNumLabel = new JLabel("Tối đa 15");
        maxNumLabel.setForeground(ColorManager.TEXT);
        maxNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        maxNumLabel.setBounds(10, 47, 109, 14);

        SpinnerModel sm = new SpinnerNumberModel(8, 2, 15, 1);
        numSpinner = new JSpinner(sm);
        numSpinner.setBounds(160, 25, 120, 25);
        JFormattedTextField txt = ((JSpinner.NumberEditor) numSpinner.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);

        createArrayButton = new JButton("Tạo mảng");
        //createArrayButton.setBackground(SystemColor.activeCaption);
        createArrayButton.addActionListener((ActionEvent e) -> {
            createArray();
        });
        createArrayButton.setBounds(160, 59, 120, 25);

        deleteArrayButton = new JButton("Xóa mảng");
        //deleteArrayButton.setBackground(SystemColor.activeCaption);
        deleteArrayButton.addActionListener((ActionEvent e) -> {
            deleteArray();
        });
        deleteArrayButton.setBounds(160, 95, 120, 25);

        setZeroButton = new JButton("Khởi tạo bằng 0");
        //setZeroButton.setBackground(SystemColor.activeCaption);
        setZeroButton.addActionListener((ActionEvent e) -> {
            setZero();
        });
        setZeroButton.setBounds(15, 95, 120, 25);

        createArrayPanel.setLayout(null);
        createArrayPanel.add(numLabel);
        createArrayPanel.add(numSpinner);
        createArrayPanel.add(createArrayButton);
        createArrayPanel.add(deleteArrayButton);
        createArrayPanel.add(setZeroButton);
        createArrayPanel.add(maxNumLabel);

        initiatePanel = new JPanel();
        initiatePanel.setBackground(ColorManager.CANVAS_BACKGROUND);
        initiatePanel.setBounds(5, 44, 1345, 360);
        initiatePanel.setBorder(new TitledBorder(null, "Khung chạy mô phỏng", TitledBorder.LEADING, TitledBorder.TOP, null, ColorManager.TEXT));
        contentPanel.add(initiatePanel);

        initiatePanel.setLayout(null);
            labelPoint1.setSize(50, 25);
            labelPoint1.setOpaque(true);
            labelPoint1.setLocation(50, 50);
            labelPoint1.setFont(new Font("Helvetica", Font.BOLD, 17));
            labelPoint1.setForeground(ColorManager.TEXT);
            labelPoint1.setBackground(ColorManager.CANVAS_BACKGROUND);
            labelPoint1.setHorizontalAlignment(SwingConstants.CENTER);
            labelPoint1.setVerticalAlignment(SwingConstants.CENTER);
            initiatePanel.add(labelPoint1);

            labelPoint2.setSize(50, 25);
            labelPoint2.setOpaque(true);
            labelPoint2.setLocation(50, 50);
            labelPoint2.setFont(new Font("Helvetica", Font.BOLD, 17));
            labelPoint2.setForeground(ColorManager.TEXT);
            labelPoint2.setBackground(ColorManager.CANVAS_BACKGROUND);
            labelPoint2.setHorizontalAlignment(SwingConstants.CENTER);
            labelPoint2.setVerticalAlignment(SwingConstants.CENTER);
            initiatePanel.add(labelPoint2);

            labelPointM.setSize(50, 25);
            labelPointM.setOpaque(true);
            labelPointM.setLocation(50, 50);
            labelPointM.setFont(new Font("Helvetica", Font.BOLD, 17));
            labelPointM.setForeground(ColorManager.TEXT);
            labelPointM.setBackground(ColorManager.CANVAS_BACKGROUND);
            labelPointM.setHorizontalAlignment(SwingConstants.CENTER);
            labelPointM.setVerticalAlignment(SwingConstants.CENTER);
            initiatePanel.add(labelPointM);
        setState(0);
    }

    /*
    * Set Lock And Feel
     */

    public static void setLockAndFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
    }

    public void setState(int state)
    {
        switch(state){
            case 0: //base state
                createArrayButton.setEnabled(true);
                deleteArrayButton.setEnabled(false);
                setZeroButton.setEnabled(false);

                randomButton.setEnabled(false);
                byHandButton.setEnabled(true);
                openFileButton.setEnabled(true);
                readFileButton.setEnabled(true);

                buttonBubbleSort.setEnabled(true);
                buttonSelectionSort.setEnabled(true);
                buttonInsertionSort.setEnabled(true);
                buttonMergeSort.setEnabled(true);
                buttonHeapSort.setEnabled(true);
                buttonQuickSort.setEnabled(true);

                stopButton.setEnabled(false);
                startButton.setEnabled(false);
                break;

            case 1: //created array
                createArrayButton.setEnabled(true);
                deleteArrayButton.setEnabled(true);
                setZeroButton.setEnabled(true);

                randomButton.setEnabled(true);
                byHandButton.setEnabled(true);
                openFileButton.setEnabled(true);
                readFileButton.setEnabled(true);

                buttonBubbleSort.setEnabled(true);
                buttonSelectionSort.setEnabled(true);
                buttonInsertionSort.setEnabled(true);
                buttonMergeSort.setEnabled(true);
                buttonHeapSort.setEnabled(true);
                buttonQuickSort.setEnabled(true);
                break;

            case 2: //setted value
                createArrayButton.setEnabled(true);
                deleteArrayButton.setEnabled(false);
                setZeroButton.setEnabled(false);

                randomButton.setEnabled(true);

                buttonBubbleSort.setEnabled(true);
                buttonSelectionSort.setEnabled(true);
                buttonInsertionSort.setEnabled(true);
                buttonMergeSort.setEnabled(true);
                buttonHeapSort.setEnabled(true);
                buttonQuickSort.setEnabled(true);

                stopButton.setEnabled(false);
                startButton.setEnabled(true);
                break;
            case 3: //sorting
                createArrayButton.setEnabled(false);
                deleteArrayButton.setEnabled(false);
                setZeroButton.setEnabled(false);

                randomButton.setEnabled(false);
                byHandButton.setEnabled(false);
                openFileButton.setEnabled(false);
                readFileButton.setEnabled(false);

                buttonBubbleSort.setEnabled(false);
                buttonSelectionSort.setEnabled(false);
                buttonInsertionSort.setEnabled(false);
                buttonMergeSort.setEnabled(false);
                buttonHeapSort.setEnabled(false);
                buttonQuickSort.setEnabled(false);

                stopButton.setEnabled(true);
                startButton.setEnabled(false);
                break;
            case 4://sort done
                createArrayButton.setEnabled(true);
                deleteArrayButton.setEnabled(true);
                setZeroButton.setEnabled(true);

                randomButton.setEnabled(true);
                byHandButton.setEnabled(true);
                openFileButton.setEnabled(true);
                readFileButton.setEnabled(true);

                buttonBubbleSort.setEnabled(true);
                buttonSelectionSort.setEnabled(true);
                buttonInsertionSort.setEnabled(true);
                buttonMergeSort.setEnabled(true);
                buttonHeapSort.setEnabled(true);
                buttonQuickSort.setEnabled(true);

                stopButton.setEnabled(true);
                startButton.setEnabled(true);
                break;
            default:
        }

    }

    /*
        play with array
    */

    public void createArray(){
        deleteArray();

        num = (int) numSpinner.getValue();       
        Array = new JLabel[num];
        array = new int[num];

        for(int i = 0; i < num; i++)
        {
            Array[i] = new JLabel("0");
            array[i] = 0;
            initiatePanel.add(Array[i]);

            Array[i].setSize(50, 50);
            Array[i].setOpaque(true);
            Array[i].setForeground(ColorManager.CREATE_TEXT);
            Array[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
            Array[i].setBackground(ColorManager.SORT_BACKGROUND);
            Array[i].setHorizontalAlignment(SwingConstants.CENTER);
            Array[i].setVerticalAlignment(SwingConstants.CENTER);

            if(i == 0){
                Array[i].setLocation((int) ((18 - num) * 0.5 * 70) + 100, 150);
            }
            else{
                Array[i].setLocation(Array[i - 1].getX() + 70, Array[i - 1].getY());
            } 
        }

        initiatePanel.add(labelPoint1);
        initiatePanel.add(labelPoint2);
        initiatePanel.add(labelPointM);

        initiatePanel.setVisible(true);
        initiatePanel.validate();
        initiatePanel.repaint();
        setState(1);
    }

    public void deleteArray()
    {
        for(int i = 0; i < num; i++)
        {
            Array[i].setText("0");
            array[i] = 0;
            Array[i].setVisible(false);
            initiatePanel.remove(Array[i]);
        }

        labelPoint1.setText("");
        labelPoint2.setText("");
        labelPointM.setText("");
        initiatePanel.remove(labelPoint1);
        initiatePanel.remove(labelPoint2);
        initiatePanel.remove(labelPointM);

        for(int i = 0; i < curT; i++)
        {
            try {
                threads[i].interrupt();
            } catch(Exception e){
            }
        }
        curT = -1;

        initiatePanel.validate();
        initiatePanel.repaint();
        setState(0);
    }

    public void setZero()
    {
        for(int i = 0; i < num; i++)
        {
            Array[i].setText("0");
            array[i] = 0;
        }
        createArray();
        initiatePanel.validate();
        initiatePanel.repaint();
    }

    public void randomArray()
    {
        Random rand = new Random();
        for(int i = 0; i < num; i++)
        {
            int value = rand.nextInt(99) + 1;
            Array[i].setText(String.valueOf(value));
            Array[i].setBackground(ColorManager.SORT_BACKGROUND);
            Array[i].setForeground(ColorManager.CREATE_TEXT);
            array[i] = value;
        }
        initiatePanel.setVisible(true);
        initiatePanel.validate();
        initiatePanel.repaint();

        setState(2);
    }

    /*
    * using for animation
    */

    public void swap(JLabel stLabel, JLabel ndLabel, Color c)
    {
        int x1 = stLabel.getX();
        int x2 = ndLabel.getX();
        curT++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable(){
            @Override
            public void run() {
               try{
                   if(cur != 0){
                       threads[cur - 1].join();
                   }

                   stLabel.setBackground(ColorManager.PROCESSING);
                   ndLabel.setBackground(ColorManager.PROCESSING);
                   while(stLabel.getY() > 100)
                   {
                       stLabel.setLocation(stLabel.getX(), stLabel.getY() - 10);
                       ndLabel.setLocation(ndLabel.getX(), ndLabel.getY() + 10);
                       labelPointM.setLocation(x2, labelPointM.getY() + 10);
                       Thread.sleep(time);
                   }

                   while(stLabel.getX() < x2)
                   {
                       stLabel.setLocation(stLabel.getX() + 10, stLabel.getY());
                       ndLabel.setLocation(ndLabel.getX() - 10, ndLabel.getY());
                       labelPointM.setLocation(ndLabel.getX(), 250);
                       Thread.sleep(time);
                   }

                   while(stLabel.getY() < 140)
                   {
                       stLabel.setLocation(stLabel.getX(), stLabel.getY() + 10);
                       ndLabel.setLocation(ndLabel.getX(), ndLabel.getY() - 10);
                       labelPointM.setLocation(x1, labelPointM.getY() - 10);
                       Thread.sleep(time);
                   }

                   String tmp = stLabel.getText();
                   stLabel.setText(ndLabel.getText());
                   ndLabel.setText(tmp);
                   stLabel.setLocation(x1, 150);
                   ndLabel.setLocation(x2, 150);
                   stLabel.setBackground(c);
                   ndLabel.setBackground(c);

               } catch (InterruptedException ex) {

                } 
            }          
        });
        threads[cur].start();
    }

    public void setLabelPoint(JLabel labelPoint, int i, String s){
        curT++;
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    if(cur != 0)
                        threads[cur - 1].join();
                    if(i == -1)
                    {
                        labelPoint.setText("");
                        return;
                    }
                    if(s.charAt(0) == 'm'){
                        labelPoint.setLocation(Array[i].getX(), 200);
                        labelPoint.setText(s);
                    }
                    else if(s.charAt(0) == 'k'){
                        labelPoint.setLocation(oriLocation[i], 200);
                        labelPoint.setText(s + i);
                    }
                    else{
                        labelPoint.setLocation(Array[i].getX(), 275);
                        labelPoint.setText(s + i);
                    }
                } catch(Exception e){}
            }
        });
        threads[cur].start();
    }

    public void move(JLabel stLabel, JLabel ndLabel, int pos)
    {
        int x1 = stLabel.getX();
        int x2 = ndLabel.getX();
        curT++;

        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    if(cur != 0)
                        threads[cur - 1].join();
                    stLabel.setOpaque(true);
                    ndLabel.setOpaque(true);
                    stLabel.setBackground(ColorManager.BAR_GREEN);
                    ndLabel.setBackground(ColorManager.BAR_GREEN);

                    while(stLabel.getY() > 100)
                    {
                        stLabel.setLocation(stLabel.getX(), stLabel.getY() - 10);
                        Thread.sleep(time);
                    }

                    while(stLabel.getX() > x2)
                    {
                        ndLabel.setLocation(ndLabel.getX() + 10, ndLabel.getY());
                        stLabel.setLocation(stLabel.getX() - 10, stLabel.getY());
                        Thread.sleep(time);
                    }
                    while((pos == 0) && (stLabel.getY() < 150))
                    {
                        stLabel.setLocation(stLabel.getX(), stLabel.getY() + 10);
                        Thread.sleep(time);
                    }

                    String tmp = stLabel.getText();
                    stLabel.setText(ndLabel.getText());
                    ndLabel.setText(tmp);

                    int tmpY = stLabel.getY();
                    stLabel.setLocation(x1, ndLabel.getY());
                    ndLabel.setLocation(x2, tmpY);
                    stLabel.setBackground(SystemColor.inactiveCaption);
                    if(pos == 0)
                        ndLabel.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e){}
            }
        });
        threads[cur].start();
    }

    /*
    * sort
    */

    /*
    * Bubble Sort
    */

    public void BubbleSort()
    {
        highLight(1);

        for(int i = 0; i < num; i++)
        {
            highLight(2);
            setLabelPoint(labelPoint1, i, "i = ");

            for(int j = num - 1; j > i; j--)
            {
                highLight(3);
                highLight(4);
                setLabelPoint(labelPoint2, j, "j = ");

                if(array[j] < array[j - 1]){
                    array[j - 1] += array[j];
                    array[j] = array[j - 1] - array[j];
                    array[j - 1] = array[j - 1] - array[j];
                    highLight(5);
                    swap(Array[j - 1], Array[j], ColorManager.BASE);
                }
            }
        }
        highLight(0);
    }

    /*
    * Selection Sort
    */

    public void SelectionSort()
    {
        highLight(1);

        for(int i = 0; i < num - 1; i++)
        {
            highLight(2);
            setLabelPoint(labelPoint1, i, "i = ");

            int pos = i;
            setLabelPoint(labelPointM, pos, "min");

            highLight(3);
            for(int j = i + 1; j < num; j++)
            {
                highLight(3);
                highLight(4);
                setLabelPoint(labelPoint2, j, "j = ");
                if(array[j] < array[pos])
                {
                    highLight(6);
                    pos = j;
                    setLabelPoint(labelPointM, pos, "min");
                }
            }

            if(pos > i)
            {
                array[i] += array[pos];
                array[pos] = array[i] - array[pos];
                array[i] = array[i] - array[pos];
                highLight(7);
                swap(Array[i], Array[pos], ColorManager.BASE);
            }
        }
        highLight(0);
    }

    /*
    * Insertion Sort
    */
    public void InsertionSort()
    {
        highLight(1);
        highLight(2);
        for(int i = 1; i < num; i++)
        {
            highLight(3);
            setLabelPoint(labelPoint1, i, "i = ");

            int x = array[i];
            highLight(4);
            int pos = i - 1;
            highLight(5);
            while(pos >= 0 && array[pos] > x)
            {
                highLight(6);
                setLabelPoint(labelPoint2, pos, "j = ");
                array[pos + 1] = array[pos];
                highLight(7);
                if(pos > 0 && array[pos - 1] <= x)
                    move(Array[pos + 1], Array[pos], 0);
                else 
                    move(Array[pos + 1], Array[pos], pos);
                pos--;
                highLight(8);
            }
            highLight(9);
            array[pos + 1] = x;
            setLabelPoint(labelPoint2, -1, null);
        }
        highLight(0);
    }

    /*
    * Quick Sort
    */

    public void Down(int l, int r)
    {
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            public void run() {
                try {
                    if(cur != 0)
                        threads[cur - 1].join();
                    while(Array[l].getY() < 250)
                    {
                        for(int i = l; i <= r; i++)
                        {
                            Array[i].setLocation(Array[i].getX(), Array[i].getY() + 10);
                        }
                        Thread.sleep(time);
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    public void QuickSort()
    {
        Down(0, num - 1);
        QuickSortAnimation(0, num - 1);
    }

    public void Coloring(int pos, Color c)
    {
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(cur != 0)
                        threads[cur - 1].join();
                    Array[pos].setBackground(c);
                    Thread.sleep(time);
                } catch (Exception e) {} 
            }
        });
        threads[cur].start();
    }

    public void Coloring(int l, int r, Color c) {
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    for (int i = l; i <= r; i++) {                        
                        Array[i].setBackground(c);                       
                    }
                    Thread.sleep(time);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void QuickSortAnimation(int l, int r)
    {
        if(l == r) return;
        PutUp(l, r, 150);
        Coloring(r, new Color(255, 212, 139));
        
        int i = l, j = r - 1;

        while(i < j)
        {
            
            choicePosition(i, j, (i < r - 1 && array[i] <= array[r]), (j > 0 && array[j] > array[r]));
            if(array[i] > array[r] && array[j] <= array[r]){
                swap(Array[i], Array[j], ColorManager.SORT_BACKGROUND);
                array[i] += array[j];
                array[j] = array[i] - array[j];
                array[i] = array[i] - array[j];
                i++;
                j--;
            }
            else{
                if(array[i] <= array[r]) i++;
                if(array[j] > array[r]) j--;
            }            
        }
        
        if(array[r] < array[i]){
            swap(Array[i], Array[r], ColorManager.SORT_BACKGROUND);
            array[i] += array[r];
            array[r] = array[i] - array[r];
            array[i] = array[i] - array[r];
        }
        
        Coloring(l, r, ColorManager.SORT_BACKGROUND);
        Down(l, r);
        QuickSortAnimation(l, i);
        QuickSortAnimation(i + 1, r);
    }
    
    public void choicePosition(int i, int j, boolean stNeed, boolean ndNeed){
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            public void run() {
                try {
                    if(cur != 0)
                        threads[cur - 1].join();
                    Array[i].setBackground(ColorManager.PROCESSING);
                    Array[j].setBackground(ColorManager.PROCESSING);
                    
                    Thread.sleep(10 * time);
                    
                    if(stNeed) Array[i].setBackground(ColorManager.SORT_BACKGROUND);
                    if(ndNeed) Array[j].setBackground(ColorManager.SORT_BACKGROUND);
                    
                    Thread.sleep(10 * time);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    /*
    * Merge Sort
    */
    
    public void PutUp(int left, int right, int x) {
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    int mid = (left + right) / 2;
                    for (int i = left; i <= right; i++) {
                        if (i < mid + 1)
                            Array[i].setBackground(ColorManager.SORT_BACKGROUND);
                        else
                            Array[i].setBackground(ColorManager.SORT_BACKGROUND);
                    }
                    while (Array[right].getY() > x) {
                        for (int i = left; i <= right; i ++) {
                            if (Array[i].getY() > x)
                                Array[i].setLocation(Array[i].getX(), Array[i].getY() - 10);
                        }
                        Thread.sleep(time);
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void PutDown(JLabel label, int x, int y) {        
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    int x1 = label.getX();
                    label.setBackground(ColorManager.SORT_BACKGROUND);
                    while (label.getY() < 100) {
                        label.setLocation(x1, label.getY() + 10);
                        Thread.sleep(time);
                    }
                    int y1 = label.getY();
                    if (x1 < x) {
                        while (label.getX() < x) {
                            label.setLocation(label.getX() + 10, y1);
                            Thread.sleep(time);
                        }
                        while (label.getY() < y) {
                            label.setLocation(x, label.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else {
                        while (label.getX() > x) {
                            label.setLocation(label.getX() - 10, y1);
                            Thread.sleep(time);
                        }
                        while (label.getY() < y) {
                            label.setLocation(x, label.getY() + 10);
                            Thread.sleep(time);
                        }
                    }
                    label.setBackground(ColorManager.SORT_BACKGROUND);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void Relocat(int left, int right, int[] T) {  
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    for (int i = left; i <= right; i ++) {
                        if (Array[i].getX() != oriLocation[i]) {
                            Array[i].setLocation(oriLocation[i], 150);
                            Array[i].setText(T[i - left] + "");
                        }
                    }
                    Thread.sleep(time);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void Merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] T = new int[n1 + n2];
        int[] L = new int[n1];
        int[] R = new int[n2];
        int i, j, k;
        //highLight(16);
        for (i = 0; i < n1; i ++)
            L[i] = array[left + i];
        //highLight(18);
        for (j = 0; j < n2; j ++)
            R[j] = array[mid + 1 + j];
        setLabelPoint(labelPoint1, left, "i = ");
        setLabelPoint(labelPoint2, mid + 1, "j = ");
        PutUp(left, right, 50);
        
        i = 0; j = 0;
        k = left;
        while (i < n1 && j < n2) {
            //highLight(22);
            setLabelPoint(labelPointM, k, "k = ");
            //highLight(23);
            if (L[i] <= R[j]) {
                setLabelPoint(labelPoint1, left + i, "i = ");
                //highLight(24);
                array[k] = L[i];
                PutDown(Array[left + i], oriLocation[k], 150);
                //highLight(25);
                i ++;
            } else {
                setLabelPoint(labelPoint2, mid + 1 + j, "j = ");
                //highLight(27);
                array[k] = R[j];
                PutDown(Array[mid + 1 + j], oriLocation[k], 150);
                //highLight(28);
                j ++;
            }
            //highLight(30);
            k ++;
        }
        while (i < n1) {
            //highLight(32);
            setLabelPoint(labelPointM, k, "k = ");
            setLabelPoint(labelPoint1, left + i, "i = ");
            //highLight(33);
            array[k] = L[i];
            PutDown(Array[left + i], oriLocation[k], 150);
            i ++;
            k ++;
        }
        while (j < n2) {
            //highLight(37);
            setLabelPoint(labelPointM, k, "k = ");
            setLabelPoint(labelPoint2, mid + 1 + j, "j = ");
            //highLight(38);
            array[k] = R[j];
            PutDown(Array[mid + 1 + j], oriLocation[k], 150);
            j ++;
            k ++;
        }
        
        for (i = 0; i < n1 + n2; i ++)
            T[i] = array[left + i];
        Relocat(left, right, T);
    }
    
    public void MergeSortAl(int left, int right) {
        //highLight(1);
        if (left < right) {
            //highLight(2);
            int mid = (left + right) / 2;
            MergeSortAl(left, mid);
            MergeSortAl(mid + 1, right);
            Merge(left, mid, right);
        }
    }
    
    public void MergeSort() {
        for (int i = 0; i < num; i ++)
            oriLocation[i] = Array[i].getX();
        MergeSortAl(0, num - 1);
    }
    
    /*
    * Heap Sort
    */
    
    public void moveToLocation(JLabel label, int x, int y)
    {
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            public void run() {
                try {
                    if(cur != 0)
                        threads[cur - 1].join();
                    
                    label.setBackground(ColorManager.SORT_BACKGROUND);
                    int x1 = label.getX();
                    int y1 = label.getY();
                    if (x1 < x && y1 < y) {
                        while (label.getX() < x) {
                            label.setLocation(label.getX() + 10, y1);
                            Thread.sleep(time);
                        }
                        while (label.getY() < y) {
                            label.setLocation(x, label.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else if (x1 >= x && y1 < y) {
                        while (label.getX() > x) {
                            label.setLocation(label.getX() - 10, y1);
                            Thread.sleep(time);
                        }
                        while (label.getY() < y) {
                            label.setLocation(x, label.getY() + 10);
                            Thread.sleep(time);
                        }
                    } else if (x1 < x && y1 >= y) {
                        while (label.getY() > y) {
                            label.setLocation(x1, label.getY() - 10);
                            Thread.sleep(time);
                        }
                        while (label.getX() < x) {
                            label.setLocation(label.getX() + 10, y);
                            Thread.sleep(time);
                        }
                    } else if (x1 >= x && y1 >= y) {
                        while (label.getY() > y) {
                            label.setLocation(x1, label.getY() - 10);
                            Thread.sleep(time);
                        }
                        while (label.getX() > x) {
                            label.setLocation(label.getX() - 10, y);
                            Thread.sleep(time);
                        }
                    }
                    
                    label.setBackground(ColorManager.SORT_BACKGROUND);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void initHeapLocation()
    {       
        int i, j = 0;
        int row = 1;
        int maxirow = 0;
        int[] xi = {600, 480, 720, 420, 540, 660, 780, 390, 450, 510, 570, 630, 690, 750, 810};
        int[] yi = {60, 110, 170, 230};
        moveToLocation(Array[0], xi[0], yi[0]);
        for (i = 0; i <= (num - 1) / 2; i++) {
            if (i > maxirow) {
                row++;
                maxirow = maxirow * 2 + 2;
            }
            j = i * 2 + 1;
            while (j <= i * 2 + 2 && j < num) {
                if (j == i * 2 + 1) {
                    moveToLocation(Array[j], xi[j], yi[row]);
                    System.out.println(j + " " + xi[j] + " " + yi[row]);
                } else {
                    moveToLocation(Array[j], xi[j], yi[row]);
                }
                j++;
            }
        }
        
    }
    
    public void SwapinHeap(JLabel stLabel, JLabel ndLabel) {
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }
                    setBackgroundMoving(stLabel, ndLabel);
                    int x1 = stLabel.getX();
                    int x2 = ndLabel.getX();
                    int y1 = stLabel.getY();
                    int y2 = ndLabel.getY();
                    while (ndLabel.getY() > y1) {
                        if (stLabel.getY() > y1 - 50)
                            stLabel.setLocation(stLabel.getX(), stLabel.getY() - 10);
                        ndLabel.setLocation(ndLabel.getX(), ndLabel.getY() - 10);
                        Thread.sleep(time);
                    }
                    if (x2 < x1) {
                        while (ndLabel.getX() < x1) {
                            stLabel.setLocation(stLabel.getX() - 10, stLabel.getY());
                            ndLabel.setLocation(ndLabel.getX() + 10, ndLabel.getY());
                            Thread.sleep(time);
                        }
                    } else {
                        while (ndLabel.getX() > x1) {
                            stLabel.setLocation(stLabel.getX() + 10, stLabel.getY());
                            ndLabel.setLocation(ndLabel.getX() - 10, ndLabel.getY());
                            Thread.sleep(time);
                        }
                    }
                    while (stLabel.getY() < y2) {
                        stLabel.setLocation(stLabel.getX(), stLabel.getY() + 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = stLabel.getText();
                    stLabel.setText(ndLabel.getText());
                    ndLabel.setText(txtLb1);
                    stLabel.setLocation(x1, y1);
                    ndLabel.setLocation(x2, y2);
                    setBackgroundDone(stLabel, ndLabel);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void SwapHeapEnd(JLabel stLabel, JLabel ndLabel, int xEnd) {
        moveToLocation(stLabel, xEnd, 260);
        moveToLocation(ndLabel, 600, 60);
        SwapwithoutMoving(stLabel, ndLabel);
    }
    
    public void SwapwithoutMoving(JLabel stLabel, JLabel ndLabel) {
        int cur = ++curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    String txtLb1 = stLabel.getText();
                    stLabel.setText(ndLabel.getText());
                    ndLabel.setText(txtLb1);
                    int x = stLabel.getX();
                    int y = stLabel.getY();
                    stLabel.setLocation(ndLabel.getX(), ndLabel.getY());
                    ndLabel.setLocation(x, y);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void Shift(int l, int r) {
        int x, i ,j;
        //highLight(23);
        i = l;
        //highLight(24);
        j = i * 2 + 1;
        ////highLight(25);
        x = array[i];
       
        while (j <= r) {
            ////highLight(26);
            ////highLight(27);
            if (j < r) {
                ////highLight(28);
                if (array[j] < array[j + 1]) {
                    ////highLight(29);
                    j++;
                }
            }
            ////highLight(30);
            if (array[j] <= x) {
                ////highLight(31);
                return;
            } else {
                ////highLight(33);
                array[i] = array[j];
                ////highLight(34);
                array[j] = x;
                SwapinHeap(Array[i], Array[j]);
                ////highLight(35);
                i = j;
                ////highLight(36);
                j = i * 2 + 1;
                ////highLight(37);
                x = array[i];
            }
        }
        
    }
    
    public void CreateHeap() {
        int l;
        ////highLight(14);
        l = num / 2 - 1;
        while (l >= 0) {
            //highLight(15);
            //highLight(16);
            Shift(l, num - 1);
            //highLight(17);
            l--;
        }
    }
    
    public void HeapSort() {
        int r;
        int xEnd = ((int) ((18 - num) * 0.5) * 70) + 100 + (num - 1) * 70;
        
        initHeapLocation();
        //highLight(2);
        CreateHeap();
        //highLight(3);
        r = num - 1;
        while (r > 0) {
            //highLight(4);
            //highLight(5);
            int x = array[0];
            array[0] = array[r];
            array[r] = x;
            SwapHeapEnd(Array[0], Array[r], xEnd);
            xEnd -= 70;
            //highLight(6);
            r --;
            //highLight(7);
            if (r > 0) {
                //highLight(8);
                Shift(0, r);
            }
        }
        SwapHeapEnd(Array[0], null, xEnd);
    }

    public void highLight(int line)
    {
        curT++;
        int cur = curT;

        threads[cur] = new Thread(new Runnable(){
            public void run() {
                try {
                    if(cur != 0){
                        threads[cur - 1].join();
                    }
                    listCode.setSelectedIndex(line);
                    listCode.ensureIndexIsVisible(line);
                    Thread.sleep(time);
                } catch(Exception e){}
            }
        });
        threads[cur].start();
    }
    
    public void wasSorted() {

        curT++;
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    setState(4);
                    for (int i = 0; i < num; i++) {
                        Array[i].setBackground(ColorManager.BEFORE_SORT);
                        Array[i].setForeground(ColorManager.SORT_BACKGROUND);
                    }

                    labelPoint1.setText("");
                    labelPoint2.setText("");
                    labelPointM.setText("");

                    new FormCompleteSorted().setVisible(true);

                } catch(Exception e) {}
            }

        });
        threads[cur].start();
    }

    public void setArray(int[] array)
    {
        numSpinner.setValue(array.length);
        deleteArray();
        num = (int) numSpinner.getValue();

        Array = new JLabel[num];
        this.array = array;

        for(int i = 0; i < num; i++)
        {
            Array[i] = new JLabel(String.valueOf(array[i]));
            initiatePanel.add(Array[i]);

            Array[i].setSize(50, 50);
            Array[i].setOpaque(true);
            Array[i].setForeground(ColorManager.CREATE_TEXT);
            Array[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
            Array[i].setBackground(ColorManager.SORT_BACKGROUND);
            Array[i].setHorizontalAlignment(SwingConstants.CENTER);
            Array[i].setVerticalAlignment(SwingConstants.CENTER);

            if(i == 0){
                Array[i].setLocation((int) ((18 - num) * 0.5 * 70) + 100, 150);
            }
            else{
                Array[i].setLocation(Array[i - 1].getX() + 70, Array[i - 1].getY());
            } 
        }

        initiatePanel.setVisible(true);
        initiatePanel.validate();
        initiatePanel.repaint();
        setState(2);
    }

    public boolean isSorted()
    {
        for(int i = 1; i < num; i++)
        {
            if(array[i] < array[i - 1]) 
                return false;
        }
        return true;
    } 
    
    public void setBackgroundMoving(JLabel stLabel, JLabel ndLabel)
    {
        stLabel.setOpaque(true);
        ndLabel.setOpaque(true);
        
        stLabel.setBackground(ColorManager.PROCESSING);
        ndLabel.setBackground(ColorManager.PROCESSING);
    }
    
    public void setBackgroundDone(JLabel stLabel, JLabel ndLabel) {
    	stLabel.setOpaque(true);
    	ndLabel.setOpaque(true);
    	
    	stLabel.setBackground(ColorManager.SORT_BACKGROUND);
    	ndLabel.setBackground(ColorManager.SORT_BACKGROUND);
    }
}
