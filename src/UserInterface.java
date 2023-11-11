import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class UserInterface extends JFrame {
    static final Color background = new Color(200, 236, 186);
    static final Color buttonBackground = new Color(189, 189, 189);
    static final Color buttonActive = new Color(160, 160, 160);
    static final Font calibriFont = new Font("Calibri", Font.PLAIN, 16);
    DefaultListModel<String> libraryModel, ordersModel, myBooksModel;
    JList<String> libraryList, ordersList, myBooksList;
    static JLabel libraryLabel, ordersLabel, myBooksLabel;
    static JButton loadLibraryBooksButton, loadMyBooksButton, returnBooksButton, getBooksButton, clearLibraryListButton, clearOrdersListButton, clearMyBooksListButton;
    File libraryBooksFile = new File("library_books.txt");
    File myBooksFile = new File("my_books.txt");
    JScrollPane libraryScrollPane, ordersScrollPane, myBooksScrollPane;
    public UserInterface(String str){
        super(str);
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(background);
        setLayout(null);

        libraryModel = new DefaultListModel<>();
        ordersModel = new DefaultListModel<>();
        myBooksModel = new DefaultListModel<>();

        libraryList = new JList<>(libraryModel);
        libraryList.setDragEnabled(true);
        libraryList.setTransferHandler(new ListTransferHandler());

        libraryScrollPane = new JScrollPane(libraryList);
        libraryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        libraryScrollPane.setBounds(100, 100, 200, 200);
        libraryScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = new JButton();
                button.setBackground(buttonBackground);
                return button;
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = new JButton();
                button.setBackground(buttonBackground);
                return button;
            }
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                g.setColor(buttonBackground);
                g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
            }
        });
        add(libraryScrollPane);

        ordersList = new JList<>(ordersModel);
        ordersList.setDragEnabled(true);
        ordersList.setTransferHandler(new ListTransferHandler());

        ordersScrollPane = new JScrollPane(ordersList);
        ordersScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ordersScrollPane.setBounds(350, 100, 200, 200);
        ordersScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = new JButton();
                button.setBackground(buttonBackground);
                return button;
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = new JButton();
                button.setBackground(buttonBackground);
                return button;
            }
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                g.setColor(buttonBackground);
                g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
            }
        });
        add(ordersScrollPane);

        myBooksList = new JList<>(myBooksModel);
        myBooksList.setDragEnabled(true);
        myBooksList.setTransferHandler(new ListTransferHandler());

        myBooksScrollPane = new JScrollPane(myBooksList);
        myBooksScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        myBooksScrollPane.setBounds(600, 100, 200, 200);
        myBooksScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = new JButton();
                button.setBackground(buttonBackground);
                return button;
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = new JButton();
                button.setBackground(buttonBackground);
                return button;
            }
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                g.setColor(buttonBackground);
                g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
            }
        });
        add(myBooksScrollPane);

        libraryLabel = new JLabel("Library");
        ordersLabel = new JLabel("Orders");
        myBooksLabel = new JLabel("MyBooks");

        loadLibraryBooksButton = new JButton("Load books");
        loadLibraryBooksButton.setFocusPainted(false);
        loadLibraryBooksButton.setBorderPainted(false);

        loadMyBooksButton = new JButton("Load books");
        loadMyBooksButton.setFocusPainted(false);
        loadMyBooksButton.setBorderPainted(false);

        clearLibraryListButton = new JButton("Clear");
        clearLibraryListButton.setFocusPainted(false);
        clearLibraryListButton.setBorderPainted(false);

        clearMyBooksListButton = new JButton("Clear");
        clearMyBooksListButton.setFocusPainted(false);
        clearMyBooksListButton.setBorderPainted(false);

        clearOrdersListButton = new JButton("Clear");
        clearOrdersListButton.setFocusPainted(false);
        clearOrdersListButton.setBorderPainted(false);

        returnBooksButton = new JButton("Return books");
        returnBooksButton.setFocusPainted(false);
        returnBooksButton.setBorderPainted(false);

        getBooksButton = new JButton("Get books");
        getBooksButton.setFocusPainted(false);
        getBooksButton.setBorderPainted(false);

        //setLayout(null);
        //libraryList.setBounds(100, 100, 150, 200);
        //ordersList.setBounds(350, 100, 200, 200);
        //myBooksList.setBounds(600, 100, 200, 200);

        loadLibraryBooksButton.setBounds(100, 315, 200, 25);
        loadMyBooksButton.setBounds(600, 315, 200, 25);

        clearLibraryListButton.setBounds(100,350,200,25);
        clearMyBooksListButton.setBounds(600,350,200,25);

        getBooksButton.setBounds(350, 315, 200, 25);
        returnBooksButton.setBounds(350, 350,200,25);
        clearOrdersListButton.setBounds(350,385,200,25);

        libraryLabel.setBounds(100, 80, 200, 20);
        ordersLabel.setBounds(350, 80, 200, 20);
        myBooksLabel.setBounds(600, 80, 200, 20);

        libraryLabel.setFont(calibriFont);
        ordersLabel.setFont(calibriFont);
        myBooksLabel.setFont(calibriFont);

        libraryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ordersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        myBooksLabel.setHorizontalAlignment(SwingConstants.CENTER);

        loadLibraryBooksButton.setBackground(buttonBackground);
        getBooksButton.setBackground(buttonBackground);
        returnBooksButton.setBackground(buttonBackground);
        loadMyBooksButton.setBackground(buttonBackground);
        clearLibraryListButton.setBackground(buttonBackground);
        clearOrdersListButton.setBackground(buttonBackground);
        clearMyBooksListButton.setBackground(buttonBackground);

        //add(libraryList);
        //add(ordersList);
        //add(myBooksList);

        add(libraryLabel);
        add(ordersLabel);
        add(myBooksLabel);

        add(loadLibraryBooksButton);
        add(loadMyBooksButton);
        add(clearLibraryListButton);
        add(clearMyBooksListButton);
        add(getBooksButton);
        add(returnBooksButton);
        add(clearOrdersListButton);

        loadLibraryBooksButton.addActionListener(new LoadButtonActionListener(libraryBooksFile, libraryModel));
        loadMyBooksButton.addActionListener(new LoadButtonActionListener(myBooksFile, myBooksModel));
        loadLibraryBooksButton.addMouseListener(new ButtonMouseAdapter(loadLibraryBooksButton));
        loadMyBooksButton.addMouseListener(new ButtonMouseAdapter(loadMyBooksButton));
        getBooksButton.addActionListener(new OrderButtonsActionListener(libraryBooksFile,myBooksFile,libraryModel,myBooksModel));
        getBooksButton.addMouseListener(new ButtonMouseAdapter(getBooksButton));
        returnBooksButton.addActionListener(new OrderButtonsActionListener(myBooksFile,libraryBooksFile,myBooksModel,libraryModel));
        returnBooksButton.addMouseListener(new ButtonMouseAdapter(returnBooksButton));
        clearLibraryListButton.addActionListener(new ClearActionListener(libraryModel));
        clearOrdersListButton.addActionListener(new ClearActionListener(ordersModel));
        clearMyBooksListButton.addActionListener(new ClearActionListener(myBooksModel));
        clearLibraryListButton.addMouseListener(new ButtonMouseAdapter(clearLibraryListButton));
        clearOrdersListButton.addMouseListener(new ButtonMouseAdapter(clearOrdersListButton));
        clearMyBooksListButton.addMouseListener(new ButtonMouseAdapter(clearMyBooksListButton));
    }

    public class LoadButtonActionListener implements ActionListener {
        File file;
        DefaultListModel<String> model;
        public LoadButtonActionListener(File file, DefaultListModel<String> model){
            this.file = file;
            this.model = model;
        }
        public void actionPerformed(ActionEvent e) {
            try{
                if(!file.exists()){
                    file.createNewFile();
                }
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                model.clear();
                while ((line = reader.readLine()) != null) {
                    model.addElement(line);
                }
                reader.close();
            }catch(IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

    public class OrderButtonsActionListener implements ActionListener{
        File sourceFile, destinationFile;
        DefaultListModel<String> sourceModel, destinationModel;
        public OrderButtonsActionListener(File sourceFile, File destinationFile, DefaultListModel<String> sourceModel, DefaultListModel<String> destinationModel){
            this.sourceFile = sourceFile;
            this.destinationFile = destinationFile;
            this.sourceModel = sourceModel;
            this.destinationModel = destinationModel;
        }
        public void actionPerformed(ActionEvent e) {
            try{
                if(!destinationFile.exists()){
                    destinationFile.createNewFile();
                }
                BufferedWriter destinationWriter = new BufferedWriter(new FileWriter(destinationFile,true));
                String line;
                while(ordersModel.getSize() != 0){
                    line = ordersModel.getElementAt(0);
                    ordersModel.remove(0);
                    destinationWriter.write(line+"\n");
                }
                destinationModel.clear();
                destinationWriter.close();
                BufferedWriter sourceWriter = new BufferedWriter(new FileWriter(sourceFile));
                for(int i=0; i<sourceModel.getSize(); i++){
                    sourceWriter.write(sourceModel.getElementAt(i)+"\n");
                }
                sourceWriter.close();
                LoadButtonActionListener destinationObject = new LoadButtonActionListener(destinationFile, destinationModel);
                destinationObject.actionPerformed(e);
                LoadButtonActionListener sourceObject = new LoadButtonActionListener(sourceFile, sourceModel);
                sourceObject.actionPerformed(e);
                returnBooksButton.setEnabled(true);
                getBooksButton.setEnabled(true);
            }catch(IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

    public class ButtonMouseAdapter extends MouseAdapter {
        JButton button;
        public ButtonMouseAdapter(JButton button){
            this.button = button;
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(buttonActive);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(buttonBackground);
        }
    }

    class ListTransferHandler extends TransferHandler {
        @Override
        public int getSourceActions(JComponent c) {
            return TransferHandler.MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            JList list = (JList) c;
            return new StringSelection((String) list.getSelectedValue());
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action == TransferHandler.MOVE) {
                JList list = (JList) source;
                DefaultListModel model = (DefaultListModel) list.getModel();
                if(source == libraryList){
                    returnBooksButton.setEnabled(false);
                } else if(source == myBooksList){
                    getBooksButton.setEnabled(false);
                }
                int index = list.getSelectedIndex();
                if (index != -1) {
                    model.remove(index);
                }
                if(ordersModel.getSize()==0){
                    returnBooksButton.setEnabled(true);
                    getBooksButton.setEnabled(true);
                }
            }
        }

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(DataFlavor.stringFlavor);
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            Transferable transferable = support.getTransferable();
            String data;
            try {
                data = (String) transferable.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e) {
                return false;
            }

            JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
            DefaultListModel<String> listModel = (DefaultListModel<String>) ((JList) support.getComponent()).getModel();

            int index = dl.getIndex();
            if (index == -1) {
                index = listModel.getSize();
            }

            listModel.add(index, data);
            return true;
        }
    }

    public class ClearActionListener implements ActionListener {
        DefaultListModel<String> model;

        public ClearActionListener(DefaultListModel<String> model) {
            this.model = model;
        }

        public void actionPerformed(ActionEvent e) {
            model.clear();
            if (model == ordersModel) {
                returnBooksButton.setEnabled(true);
                getBooksButton.setEnabled(true);
                LoadButtonActionListener object1 = new LoadButtonActionListener(libraryBooksFile, libraryModel);
                LoadButtonActionListener object2 = new LoadButtonActionListener(myBooksFile, myBooksModel);
                object1.actionPerformed(e);
                object2.actionPerformed(e);
            }
        }
    }
}
