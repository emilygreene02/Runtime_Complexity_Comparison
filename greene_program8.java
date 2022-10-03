import java.util.*;
public class greene_program8
{
    private static int width = 600;
    private static int height = 250;
    
    private static javax.swing.JButton sortIntsButton;
    private static javax.swing.JLabel sortIntsLabel;
    private static javax.swing.JButton addBSTButton;
    private static javax.swing.JLabel addBSTLabel;
    private static javax.swing.JButton addTreesetButton;
    private static javax.swing.JLabel addTreesetLabel;
    private static javax.swing.JButton addQueueButton;
    private static javax.swing.JLabel addQueueLabel;
    private static javax.swing.JButton addHashsetButton;
    private static javax.swing.JLabel addHashsetLabel;
    private static javax.swing.JButton searchIntsButton;
    private static javax.swing.JLabel searchIntsLabel;
    private static javax.swing.JButton searchBSTButton;
    private static javax.swing.JLabel searchBSTLabel;
    private static javax.swing.JButton searchTreesetButton;
    private static javax.swing.JLabel searchTreesetLabel;
    private static javax.swing.JButton searchQueueButton;
    private static javax.swing.JLabel searchQueueLabel;
    private static javax.swing.JButton searchHashsetButton;
    private static javax.swing.JLabel searchHashsetLabel;
    
    private static int[] sortValues;
    private static int[] searchValues;
    
    private static boolean check;
    private static boolean checkTreeset;
    private static boolean checkHashset;
    private static boolean checkQueue;
    private static boolean checkInts;
    private static boolean checkBST;
    
    private static int[] sortedValues;
    private static TreeSet<Integer> treeSetValues = new TreeSet<>();
    private static HashSet<Integer> hashSetValues = new HashSet<>();
    private static PriorityQueue<Integer> priorityQueueValues = new PriorityQueue<>();
    private static greene_BinarySearchTree bst = new greene_BinarySearchTree();

    private static String sortFilename;
    private static String searchFilename;
    
    private static int size;

    public static void main(String[] args)
    {
        check = false;
        checkTreeset = false;
        checkHashset = false;
        checkInts = false;
        checkQueue = false;
        checkBST = false;
        size = 0;
        
        // gets args into vars
        sortFilename = args[0];
        searchFilename = args[1];
        
        // create the window and specify the size and what to do when the window is closed
        javax.swing.JFrame f = new javax.swing.JFrame();
        f.setPreferredSize(new java.awt.Dimension(width, height));
        f.setMinimumSize(new java.awt.Dimension(width, height));
        f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        // create the menu bar
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        
        // create the  menu
        javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
        
        // create the menu items for the menu
        javax.swing.JMenuItem readSort = new javax.swing.JMenuItem("Read Sort File");
        javax.swing.JMenuItem readSearch = new javax.swing.JMenuItem("Read Search File");
        javax.swing.JMenuItem exit = new javax.swing.JMenuItem("Exit");

        // add the menu to the menu bar
        menuBar.add(fileMenu);

        // add the 3 menu items to the 3 menus
        fileMenu.add(readSort);
        fileMenu.add(readSearch);
        fileMenu.add(exit);
        
        // create the buttons
        javax.swing.JButton sortIntsButton = new javax.swing.JButton("sort ints");
        javax.swing.JLabel sortIntsLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton addBSTButton = new javax.swing.JButton("add to bst");
        javax.swing.JLabel addBSTLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton addTreesetButton = new javax.swing.JButton("add to treeset");
        javax.swing.JLabel addTreesetLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton addQueueButton = new javax.swing.JButton("add to priority queue");
        javax.swing.JLabel addQueueLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton addHashsetButton = new javax.swing.JButton("add to hashset");
        javax.swing.JLabel addHashsetLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton searchIntsButton = new javax.swing.JButton("search ints");
        javax.swing.JLabel searchIntsLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton searchBSTButton = new javax.swing.JButton("search bst");
        javax.swing.JLabel searchBSTLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton searchTreesetButton = new javax.swing.JButton("search treeset");
        javax.swing.JLabel searchTreesetLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton searchQueueButton = new javax.swing.JButton("search priority queue");
        javax.swing.JLabel searchQueueLabel = new javax.swing.JLabel("no results");
        javax.swing.JButton searchHashsetButton = new javax.swing.JButton("search hashset");
        javax.swing.JLabel searchHashsetLabel = new javax.swing.JLabel("no results");

        // create the action listeners for the menu items
        MenuItemActionListener readSortMenuItemActionListener = new MenuItemActionListener(readSort, sortIntsButton, addQueueButton, addHashsetButton, addTreesetButton, addBSTButton, searchIntsButton, searchQueueButton, searchHashsetButton, searchTreesetButton, searchBSTButton);
        MenuItemActionListener readSearchMenuItemActionListener = new MenuItemActionListener(readSearch, searchQueueButton, searchTreesetButton, searchHashsetButton, searchBSTButton, searchIntsButton, searchIntsButton, searchQueueButton, searchHashsetButton, searchTreesetButton, searchBSTButton);
        MenuItemActionListener exitMenuItemActionListener = new MenuItemActionListener(exit, sortIntsButton, addQueueButton, addHashsetButton, addTreesetButton, addBSTButton, searchIntsButton, searchQueueButton, searchHashsetButton, searchTreesetButton, searchBSTButton);
    
        // add the action listeners to the menu items
        readSort.addActionListener(readSortMenuItemActionListener);
        readSearch.addActionListener(readSearchMenuItemActionListener);
        exit.addActionListener(exitMenuItemActionListener);
        
        // create the panel to hold the buttons
        javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
        buttonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        javax.swing.BoxLayout boxLayout = new javax.swing.BoxLayout(buttonPanel, javax.swing.BoxLayout.X_AXIS);
        buttonPanel.setLayout(boxLayout);
        
        // create a panel to hold the left buttons
        javax.swing.JPanel leftButtonPanel = new javax.swing.JPanel();
        leftButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        java.awt.GridBagLayout leftBoxLayout = new java.awt.GridBagLayout();
        leftButtonPanel.setLayout(leftBoxLayout);
        leftButtonPanel.setPreferredSize(new java.awt.Dimension(250, 250));
        java.awt.GridBagConstraints leftButtonPanelConstraints = new java.awt.GridBagConstraints();
        
        // create a panel to hold the right buttons
        javax.swing.JPanel rightButtonPanel = new javax.swing.JPanel();
        rightButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        java.awt.GridBagLayout rightBoxLayout = new java.awt.GridBagLayout();
        rightButtonPanel.setLayout(rightBoxLayout);
        rightButtonPanel.setPreferredSize(new java.awt.Dimension(250, 250));
        java.awt.GridBagConstraints rightButtonPanelConstraints = new java.awt.GridBagConstraints();
        
        // add the 2 panels to the main button panel
        buttonPanel.add(leftButtonPanel);
        buttonPanel.add(rightButtonPanel);
        
        // create the panel
        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 255), 2));
        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
        mainPanel.add(buttonPanel, java.awt.BorderLayout.CENTER);
        
        sortIntsButton.setEnabled(false);
        addBSTButton.setEnabled(false);
        addTreesetButton.setEnabled(false);
        addQueueButton.setEnabled(false);
        addHashsetButton.setEnabled(false);
        searchQueueButton.setEnabled(false);
        searchIntsButton.setEnabled(false);
        searchBSTButton.setEnabled(false);
        searchTreesetButton.setEnabled(false);
        searchHashsetButton.setEnabled(false);

        // add right buttons
        rightButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
        rightButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        rightButtonPanelConstraints.weightx = 1;
        rightBoxLayout.setConstraints(searchIntsButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightBoxLayout.setConstraints(searchIntsLabel, rightButtonPanelConstraints);
        rightButtonPanel.add(searchIntsButton);
        rightButtonPanel.add(searchIntsLabel);
        
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        rightBoxLayout.setConstraints(searchBSTButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightBoxLayout.setConstraints(searchBSTLabel, rightButtonPanelConstraints);
        rightButtonPanel.add(searchBSTButton);
        rightButtonPanel.add(searchBSTLabel);

        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        rightBoxLayout.setConstraints(searchTreesetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightBoxLayout.setConstraints(searchTreesetLabel, rightButtonPanelConstraints);
        rightButtonPanel.add(searchTreesetButton);
        rightButtonPanel.add(searchTreesetLabel);
        
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        rightBoxLayout.setConstraints(searchQueueButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightBoxLayout.setConstraints(searchQueueLabel, rightButtonPanelConstraints);
        rightButtonPanel.add(searchQueueButton);
        rightButtonPanel.add(searchQueueLabel);
        
        rightButtonPanelConstraints.gridx = 0;
        rightButtonPanelConstraints.gridwidth = 1;
        rightBoxLayout.setConstraints(searchHashsetButton, rightButtonPanelConstraints);
        rightButtonPanelConstraints.gridx = 1;
        rightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        rightBoxLayout.setConstraints(searchHashsetLabel, rightButtonPanelConstraints);
        rightButtonPanel.add(searchHashsetButton);
        rightButtonPanel.add(searchHashsetLabel);

        // add left buttons
        leftButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
        leftButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        leftButtonPanelConstraints.weightx = 1;
        leftBoxLayout.setConstraints(sortIntsButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftBoxLayout.setConstraints(sortIntsLabel, leftButtonPanelConstraints);
        leftButtonPanel.add(sortIntsButton);
        leftButtonPanel.add(sortIntsLabel);
        
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        leftBoxLayout.setConstraints(addBSTButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftBoxLayout.setConstraints(addBSTLabel, leftButtonPanelConstraints);
        leftButtonPanel.add(addBSTButton);
        leftButtonPanel.add(addBSTLabel);

        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        leftBoxLayout.setConstraints(addTreesetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftBoxLayout.setConstraints(addTreesetLabel, leftButtonPanelConstraints);
        leftButtonPanel.add(addTreesetButton);
        leftButtonPanel.add(addTreesetLabel);
        
        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        leftBoxLayout.setConstraints(addQueueButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftBoxLayout.setConstraints(addQueueLabel, leftButtonPanelConstraints);
        leftButtonPanel.add(addQueueButton);
        leftButtonPanel.add(addQueueLabel);

        leftButtonPanelConstraints.gridx = 0;
        leftButtonPanelConstraints.gridwidth = 1;
        leftBoxLayout.setConstraints(addHashsetButton, leftButtonPanelConstraints);
        leftButtonPanelConstraints.gridx = 1;
        leftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        leftBoxLayout.setConstraints(addHashsetLabel, leftButtonPanelConstraints);
        leftButtonPanel.add(addHashsetButton);
        leftButtonPanel.add(addHashsetLabel);
                
        //button action listeners
        ButtonActionListener sortIntsListener = new ButtonActionListener(sortIntsButton, searchIntsButton, sortIntsLabel);
        sortIntsButton.addActionListener(sortIntsListener);
        ButtonActionListener addTreesetListener = new ButtonActionListener(addTreesetButton, searchTreesetButton, addTreesetLabel);
        addTreesetButton.addActionListener(addTreesetListener);
        ButtonActionListener addHashetListener = new ButtonActionListener(addHashsetButton, searchHashsetButton, addHashsetLabel);
        addHashsetButton.addActionListener(addHashetListener);
        ButtonActionListener addQueueListener = new ButtonActionListener(addQueueButton, searchQueueButton, addQueueLabel);
        addQueueButton.addActionListener(addQueueListener);
        ButtonActionListener addBSTListener = new ButtonActionListener(addBSTButton, searchBSTButton, addBSTLabel);
        addBSTButton.addActionListener(addBSTListener);
        ButtonActionListener searchTreesetListener = new ButtonActionListener(searchTreesetButton, addTreesetButton, searchTreesetLabel);
        searchTreesetButton.addActionListener(searchTreesetListener);
        ButtonActionListener searchHashsetListener = new ButtonActionListener(searchHashsetButton, addHashsetButton, searchHashsetLabel);
        searchHashsetButton.addActionListener(searchHashsetListener);
        ButtonActionListener searchQueueListener = new ButtonActionListener(searchQueueButton, addQueueButton, searchQueueLabel);
        searchQueueButton.addActionListener(searchQueueListener);
        ButtonActionListener searchBSTListener = new ButtonActionListener(searchBSTButton, addBSTButton, searchBSTLabel);
        searchBSTButton.addActionListener(searchBSTListener);
        ButtonActionListener searchIntsListener = new ButtonActionListener(searchIntsButton, sortIntsButton, searchIntsLabel);
        searchIntsButton.addActionListener(searchIntsListener);

        f.setContentPane(mainPanel);
        
        f.validate();
        f.setVisible(true);
    }
    
    
    // action listener for the buttons
    static class ButtonActionListener implements java.awt.event.ActionListener
    {
        // the button associated with the action listener, so that we can
        // share this one class with multiple buttons
        private javax.swing.JButton b;
        private javax.swing.JButton b1;
        private javax.swing.JLabel l;
        
        ButtonActionListener(javax.swing.JButton b, javax.swing.JButton b1, javax.swing.JLabel l)
        {
            this.b = b;
            this.b1 = b1;
            this.l = l;
        }
        
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
            System.out.println("action performed on " + b.getText() + " button");

            if( b.getText().toLowerCase().equals("sort ints") )
            {
                long t0 = System.currentTimeMillis();
                selectionSort();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
                if(check==true)
                {
                    b1.setEnabled(true);
                }
                checkInts = true;
            }
            
            if( b.getText().toLowerCase().equals("add to treeset") )
            {
                long t0 = System.currentTimeMillis();
                addToTreeSet();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
                if(check==true)
                {
                    b1.setEnabled(true);
                }
                checkTreeset = true;
            }
            
            if( b.getText().toLowerCase().equals("add to hashset") )
            {
                long t0 = System.currentTimeMillis();
                addToHashSet();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
                if(check==true)
                {
                    b1.setEnabled(true);
                }
                checkHashset = true;
            }
            
            if( b.getText().toLowerCase().equals("add to priority queue") )
            {
                long t0 = System.currentTimeMillis();
                addToPriorityQueue();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
                if(check==true)
                {
                    b1.setEnabled(true);
                }
                checkQueue = true;
            }
            
            if( b.getText().toLowerCase().equals("add to bst") )
            {
                long t0 = System.currentTimeMillis();
                addToBinarySearchTree();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
                if(check==true)
                {
                    b1.setEnabled(true);
                }
                checkBST = true;
            }
            
            if( b.getText().toLowerCase().equals("search treeset") )
            {
                long t0 = System.currentTimeMillis();
                searchTreeSet();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
            }
            
            if( b.getText().toLowerCase().equals("search hashset") )
            {
                long t0 = System.currentTimeMillis();
                searchHashSet();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
            }
            
            if( b.getText().toLowerCase().equals("search priority queue") )
            {
                long t0 = System.currentTimeMillis();
                searchPriorityQueue();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
            }
            
            if( b.getText().toLowerCase().equals("search bst") )
            {
                long t0 = System.currentTimeMillis();
                searchBinarySearchTree();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
            }
            
            if( b.getText().toLowerCase().equals("search ints") )
            {
                long t0 = System.currentTimeMillis();
                searchInts();
                long t1 = System.currentTimeMillis();
                l.setText((t1-t0) + "ms");
            }
        }
    }
    
    
    static class MenuItemActionListener implements java.awt.event.ActionListener
    {
        // the menu item associated with the action listener, so that we can
        // share this one class with multiple menu items
        private javax.swing.JMenuItem m;
        private javax.swing.JButton b0;
        private javax.swing.JButton b1;
        private javax.swing.JButton b2;
        private javax.swing.JButton b3;
        private javax.swing.JButton b4;
        private javax.swing.JButton b0a;
        private javax.swing.JButton b1a;
        private javax.swing.JButton b2a;
        private javax.swing.JButton b3a;
        private javax.swing.JButton b4a;

        MenuItemActionListener(javax.swing.JMenuItem m, javax.swing.JButton b0, javax.swing.JButton b1, javax.swing.JButton b2, javax.swing.JButton b3, javax.swing.JButton b4, javax.swing.JButton b0a, javax.swing.JButton b1a, javax.swing.JButton b2a, javax.swing.JButton b3a, javax.swing.JButton b4a)
        {
            this.m = m;
            this.b0 = b0;
            this.b1 = b1;
            this.b2 = b2;
            this.b3 = b3;
            this.b4 = b4;
            this.b0a = b0a;
            this.b1a = b1a;
            this.b2a = b2a;
            this.b3a = b3a;
            this.b4a = b4a;
        }
        
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
            System.out.println("action performed on " + m.getText() + " menu item");
            
            // if exit is selected from the file menu, exit the program
            if( m.getText().toLowerCase().equals("exit") )
            {
                System.exit(0);
            }
            
            // if color is selected from the edit menu, put a popup on the screen
            // saying something
            if( m.getText().toLowerCase().equals("read sort file") )
            {
                Object[] options = {"OK"};
                System.out.println("Read sort file");
                
                int i=0;
                
//             first time doing try catch is to get amount of values in files
                try
                {
                    java.io.BufferedReader searchInput2 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(searchFilename)));
                    String inn4;
                    while((inn4=searchInput2.readLine())!=null)
                    {
                        java.util.StringTokenizer st4 = new java.util.StringTokenizer(inn4);
                        while(st4.hasMoreTokens())
                        {
                            String token4 = st4.nextToken();
                            size++;
                        }
                    }
                    searchInput2.close();
                }
                catch(Exception e4)
                {
                    System.out.println(e4.toString());
                    System.exit(0);
                }
                
                sortValues = new int[size];

                try
                {
                    java.io.BufferedReader sortInput = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(sortFilename)));
                    String inn;
                    while((inn=sortInput.readLine())!=null)
                    {
                        java.util.StringTokenizer st = new java.util.StringTokenizer(inn);
                        while(st.hasMoreTokens())
                        {
                            String token = st.nextToken();
                            sortValues[i] = Integer.parseInt(token);
                            i++;
                        }
                    }
                    sortInput.close();
                }
                catch(Exception e1)
                {
                    System.out.println(e1.toString());
                    System.exit(0);
                }
                
                b0.setEnabled(true);
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
            }
            
            if( m.getText().toLowerCase().equals("read search file") )
            {
                Object[] options = {"OK"};
                System.out.println("Read search file");
                
                check=true;
                int j=0;
                int size1 = 0;
   
//                first time doing try catch is to get amount of values in files
                try
                {
                    java.io.BufferedReader searchInput1 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(searchFilename)));
                    String inn3;
                    while((inn3=searchInput1.readLine())!=null)
                    {
                        java.util.StringTokenizer st3 = new java.util.StringTokenizer(inn3);
                        while(st3.hasMoreTokens())
                        {
                            String token3 = st3.nextToken();
                            size1++;
                        }
                    }
                    searchInput1.close();
                }
                catch(Exception e3)
                {
                    System.out.println(e3.toString());
                    System.exit(0);
                }
          
                searchValues = new int[size1];
                
                try
                {
                    java.io.BufferedReader searchInput = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(searchFilename)));
                    String inn2;
                    while((inn2=searchInput.readLine())!=null)
                    {
                        java.util.StringTokenizer st2 = new java.util.StringTokenizer(inn2);
                        while(st2.hasMoreTokens())
                        {
                            String token2 = st2.nextToken();
                            searchValues[j] = Integer.parseInt(token2);
                            j++;
                        }
                    }
                    searchInput.close();
                }
                catch(Exception e2)
                {
                    System.out.println(e2.toString());
                    System.exit(0);
                }
                
                if(checkInts == true)
                {
                    b0a.setEnabled(true);
                }
                if(checkQueue == true)
                {
                    b1a.setEnabled(true);
                }
                if(checkHashset == true)
                {
                    b2a.setEnabled(true);
                }
                if(checkTreeset == true)
                {
                    b3a.setEnabled(true);
                }
                if(checkBST == true)
                {
                    b4a.setEnabled(true);
                }
            }
        }
    }
    
    private static void selectionSort()
    {
        sortedValues = new int [size];
        for(int g=0; g<sortValues.length; g++)
        {
            sortedValues[g] = sortValues[g];
        }
        
        for(int i=0; i<=sortedValues.length; i++){
            for(int j=i+1; j<=sortedValues.length-1; j++){
                if(sortedValues[j]<=sortedValues[i]){
                    int temp = sortedValues[j];
                    sortedValues[j] = sortedValues[i];
                    sortedValues[i] = temp;
                }
            }
        }
    }

    private static void searchInts()
    {
        int count = 0;
        for(int i=0; i<searchValues.length; i++)
        {
            int key = searchValues[i];
            int first = 0;
            int last = sortedValues.length-1;
            int middle = (first+last)/2;
            
            while(first<=last)
            {
                if(sortedValues[middle] < key)
                {
                    first = middle + 1;
                }else if(sortedValues[middle]==key){
                    count++;
                    break;
                }else{
                    last = middle - 1;
                }
                middle = (first+last)/2;
            }
        }
        System.out.println("Number of values found in binary search: "+count);
    }

    private static void addToBinarySearchTree()
    {
        bst = new greene_BinarySearchTree();
        for(int g=0; g<sortValues.length; g++)
        {
            Node node = new Node(sortValues[g]);
            bst.insertNode(node);
        }
    }
    
    private static void searchBinarySearchTree()
    {
        int count = 0;
        for(int g=0; g<searchValues.length; g++)
        {
            Node node = new Node(searchValues[g]);
            if(bst.getNode(bst.root, searchValues[g])!=null)
            {
                count++;
            }
        }
        System.out.println("Number of values found in bst: "+count);
    }

    private static void addToTreeSet()
    {
        treeSetValues.clear();
        for(int g=0; g<sortValues.length; g++)
        {
            treeSetValues.add(sortValues[g]);
        }
    }

    private static void searchTreeSet()
    {
        int count = 0;
        for(int g=0; g<searchValues.length; g++)
        {
            if(treeSetValues.contains(searchValues[g]))
            {
                count++;
            }
        }
        System.out.println("Number of values found in tree set: "+count);
    }

    private static void addToHashSet()
    {
        hashSetValues.clear();
        for(int g=0; g<sortValues.length; g++)
        {
            hashSetValues.add(sortValues[g]);
        }
    }

    private static void searchHashSet()
    {
        int count = 0;
        for(int g=0; g<searchValues.length; g++)
        {
            if(hashSetValues.contains(searchValues[g]))
            {
                count++;
            }
        }
        System.out.println("Number of values found in hash set: "+count);
    }

    private static void addToPriorityQueue()
    {
        priorityQueueValues.clear();
        for(int g=0; g<sortValues.length; g++)
        {
            priorityQueueValues.add(sortValues[g]);
        }
    }

    private static void searchPriorityQueue()
    {
        int count = 0;
        for(int g=0; g<searchValues.length; g++)
        {
            if(priorityQueueValues.contains(searchValues[g]))
            {
                count++;
            }
        }
        System.out.println("Number of values found in priority queue: "+count);
    }
}
