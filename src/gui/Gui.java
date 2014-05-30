package gui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;


/**
 * Created by lucasr on 5/16/14.
 */
public class Gui extends JFrame{
    private JButton cancelButton;
    private JButton obfuscateButton;
    private JTextPane statusTextPane;
    private JEditorPane luaEditorPane;
    private JEditorPane obfuscatedEditorPane;
    private JRadioButton spacingRadioButton;
    private JRadioButton parameterRadioButton;
    private JRadioButton junkDataRadioButton;
    private JRadioButton vocabRadioButton;
    private JPanel textPanel;
    private JPanel logoPanel;
    private JPanel rootPanel;
    private JPanel toolsPanel;
    private JPanel luaPanel;
    private JPanel obfuscatedPanel;
    private JScrollPane luaScrollPane;
    private JScrollPane obfuscatedScrollPane;
    private JLabel logoLabel;
    private JLabel headerLabel;
    private JPanel projectDirectoryPanel;
    private JPanel statusPanel;
    private JScrollPane statusScrollPane;
    private JPanel degreeObfuscationPanel;
    private JComboBox vocabComboBox;

    // Attr added by Lucas not Intellji form designer
    private FileDialog fileChooser;
    private FilenameFilter luaFilter;
    private String projectPath;
    private String currFilePath;
    private boolean isProject;
    private boolean obfuscateBtnClicked;
    private boolean setDirectory;
    private JMenuItem delete;
    private JMenuItem undo;
    private JMenuItem redo;
    private JMenuItem importFolder;
    private JMenuItem importLuaFile;
    private JMenuItem reset;
    private JMenuItem save;
    private JMenuItem saveAs;
    private FileTree projectDirectoryTree;
    private Queue<String> recentObfuscated;

    public Gui() {
        super("LuaGuard");
        setContentPane(rootPanel);
        pack();

        // Adding menu bar
        JMenuBar menubar = new JMenuBar();

        // Adding File menu tab with its menu items
        JMenu file = new JMenu("File");
        JMenuItem newproj = new JMenuItem("New Project...");
        JMenuItem addFile = new JMenu("Add File");
        JMenuItem open = new JMenuItem("Open File...");
        JMenuItem openProj = new JMenuItem("Open Project...");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As...");
        importFolder = new JMenuItem("Import Folder...");
        importLuaFile = new JMenuItem("Import file...");
        reset = new JMenuItem("Reset");
        reset.setEnabled(false);
        importFolder.setEnabled(false);
        importLuaFile.setEnabled(false);

        // Adding edit menu tab with its menu items
        JMenu edit = new JMenu("Edit");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        delete = new JMenuItem("Delete");
        undo.setEnabled(false);
        redo.setEnabled(false);
        delete.setEnabled(false);

        // Init file chooser, file filter and project path for selecting files/dirs
        fileChooser = new FileDialog(this, "Choose a file", FileDialog.LOAD);
        luaFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".lua")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        projectPath = ".";
        isProject = false;
        obfuscateBtnClicked = false;

        // Init status pane with welcome/info message
        statusTextPane.setText("Welcome to LuaGuard!\n" +
                "Create/open a project to begin\n" +
                "Or Start typing Lua code into the Lua Editor TextPane\n" +
                "For further help see our user manual at...\n");

        // Set Layout for FileTree
        projectDirectoryPanel.setLayout(new BorderLayout());

        // Change tab size
        Document doc =  luaEditorPane.getDocument();
        doc.putProperty(PlainDocument.tabSizeAttribute, 2);

        // Add to menu
        file.add(newproj);
        file.add(open);
        file.add(openProj);
        file.add(save);
        file.add(saveAs);
        file.add(importFolder);
        file.add(importLuaFile);
        edit.add(undo);
        edit.add(redo);
        edit.add(delete);
        edit.add(reset);

        // Create a project, by either selecting a directory or creating a new directory
        newproj.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        newproj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Set to only open dirs
                System.setProperty("apple.awt.fileDialogForDirectories", "true");
                openOrNewFileDirProj(0);
            }
        });

        // Open a file, in menu bar or with HotKey command+o
        open.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        open.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // Set to open only files
                System.setProperty("apple.awt.fileDialogForDirectories", "false");
                openOrNewFileDirProj(1);
                //openFile();
            }
        });

        // Open a project, in menu bar or with HotKey shift+command+o
        openProj.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, (java.awt.event.InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        openProj.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // Set to open only dirs
                System.setProperty("apple.awt.fileDialogForDirectories", "true");
                openOrNewFileDirProj(2);
            }
        });

        save.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        save.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // Set to open only files
                System.setProperty("apple.awt.fileDialogForDirectories", "true");
                save();
            }
        });

        saveAs.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, (java.awt.event.InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        saveAs.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // Set to open only dirs
                System.setProperty("apple.awt.fileDialogForDirectories", "true");
                saveAs();
            }
        });

        importLuaFile.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_I, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        importLuaFile.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // Set to open only dirs
                System.setProperty("apple.awt.fileDialogForDirectories", "false");
                importFilesToProject(0);
            }
        });

        importFolder.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_I, (java.awt.event.InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        importFolder.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // Set to open only dirs
                System.setProperty("apple.awt.fileDialogForDirectories", "true");
                importFilesToProject(1);
            }
        });


        delete.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        delete.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                if (isProject) {
                    System.out.println("trying to delete " + projectPath + "/obfuscated");
                    File file = new File(projectPath + "/obfuscated");
                    deleteDirectory(file);
                    updateProjectDirFileTree();
                } else {
                    File file = new File(currFilePath);
                    File obfFile = new File(projectPath, ("obfuscated-" + file.getName()));
                    if (obfFile.exists()){
                        updateStatusPanel("Deleting: " + obfFile.getName());
                        obfFile.delete();
                    } else {
                        updateStatusPanel("Could not delete " + obfFile.getName());
                    }
                }
            }
        });

        undo.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        undo.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                redo.setEnabled(true);
                System.out.println("undo recent obfuscated file...");
            }
        });

        redo.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, (java.awt.event.InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        redo.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                System.out.println("redo recent obfuscated file...");

            }
        });

        vocabRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (vocabRadioButton.isSelected())
                    vocabComboBox.setEnabled(true);
                else
                    vocabComboBox.setEnabled(false);
            }
        });

        reset.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_R, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        reset.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                resetLuaGuard();
            }
        });

        obfuscateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (setDirectory) {
                    delete.setEnabled(true);
                    if (isProject == false) {
                        // DO THIS LATER!
                        System.out.println("Not a project!");
                        String content = luaEditorPane.getText();
                        System.out.println(projectPath);
                    }

                    System.out.println(projectPath);
                    System.out.println(currFilePath);

                    // Generate AST, Symbol Table and other shit here...

                    // Check Degree of Obfuscation Radio Buttons
                    if (vocabRadioButton.isSelected()) {
                        // Do Vocab obfuscation here...
                        String selectedVocab = (String) vocabComboBox.getSelectedItem();

                    }

                    if (spacingRadioButton.isSelected()) {
                        // Do Spacing obfuscation here...

                    }

                    if (junkDataRadioButton.isSelected()) {
                        // Do Junk Data obfuscation here...

                    }

                    if (parameterRadioButton.isSelected()) {
                        // Do Parameter obfuscation here...

                    }

                    // Output result to obfuscated editor panel
                    // obfuscatedEditorPane.setText(luaCode);

                    //JOptionPane.showMessageDialog(Gui.this, luaCode);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Cancel button pressed...");
                //clearEditorsDir();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                alertBeforeExit();
            }
        });



        menubar.add(file);
        menubar.add(edit);
        setJMenuBar(menubar);
        setLocationRelativeTo(null);
        setSize(750, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void updateStatusPanel(String addText) {
        String currText = statusTextPane.getText();
        currText += addText;
        statusTextPane.setText(currText);
    }

    public boolean checkForObfuscatedDir() {
        // Create boolean and init File objects to find sub dir and files
        boolean containsObfDir = false;
        File file =  new File(projectPath);
        String[] files = file.list();
        // Iterate through sub-dirs and files looking for obfuscated dir
        for (int i = 0; i < files.length; i++) {
            if (files[i].equals("obfuscated")){     //Found file "obfuscate"
                // Check if Obfuscated file is a dir
                if (new File(projectPath + "/" + files[i]).isDirectory()) {
                    containsObfDir = true;
                    break;
                }
            }
        }
        return containsObfDir;
    }

    public void openFile() {
        fileChooser.setMode(FileDialog.LOAD);
        fileChooser.setTitle("Open a Lua File");
        fileChooser.setFilenameFilter(luaFilter);
        fileChooser.setVisible(true);
        String fn = fileChooser.getFile();
        String fn_loc = fileChooser.getDirectory();
        if (fn == null) {
            return;
        } else {
            // Reset Project before opening anything...
            resetLuaGuard();
            // Set Project Path and Current File Path
            projectPath = fn_loc;
            currFilePath = fn_loc + fn;
            setDirectory = true;
            // Disable features for a project...A file was only open (not a project)
            importLuaFile.setEnabled(false);
            importFolder.setEnabled(false);
            setTitle("LuaGuard -" + projectPath);
            try {
                File file = new File(currFilePath);
                luaEditorPane.setPage(file.toURI().toURL());
            } catch (IOException ex) {
                // Catch exception if file not found
                updateStatusPanel("Could not find file!\n");
            }
        }
    }

    public void newOrOpenProject() {

    }

    public void openOrNewFileDirProj(int type){
        // int type => Type of Action
        // 0 = New project
        // 1 = Open file
        // 2 = Open a Project
        //fileChooser.
        fileChooser.setVisible(true);
        String fn = fileChooser.getFile();
        String fn_loc = fileChooser.getDirectory();
        if (fn == null) {
            return;
        } else {
            // Once file/project open it can be reset
            resetLuaGuard();
            reset.setEnabled(true);
            projectPath = fn_loc + fn;
            setTitle("LuaGuard -" + projectPath);
            setDirectory = true;
            // Opening a lua file
            if (type == 1) {
                projectPath = fn_loc;
                currFilePath = fn_loc + fn;
                importLuaFile.setEnabled(false);
                importFolder.setEnabled(false);
                String file_extension = fn.split("\\.")[1];
                if (!file_extension.equals("lua")) {
                    updateStatusPanel("Incompatible file type chosen, .lua files only supported\n");
                } else {
                    // Write text from file to luaEditorPane
                    try {
                        File file = new File(currFilePath);
                        luaEditorPane.setPage(file.toURI().toURL());
                    } catch (IOException ex) {
                        // Catch exception if file not found
                        updateStatusPanel("Could not find file!\n");
                    }
                }
            }
            // Creating a new project/Opening a project
            if (type == 0 || type == 2) {
                // Enabled to delete obfuscated directory
                delete.setEnabled(true);
                importLuaFile.setEnabled(true);
                importFolder.setEnabled(true);
                isProject = true;
                if (type ==  0) {
                    // Create directory to place lua code
                    new File(projectPath + "/lua").mkdir();
                    File README = new File(projectPath+"/lua", "README.txt");
                    try {
                        README.createNewFile();
                        String content = "This is the directory where all your Lua code goes!";
                        FileWriter fw =  new FileWriter(README.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(content);
                        bw.close();
                    } catch (IOException e) {
                        updateStatusPanel("Error occurred while creating README.txt");
                    }
                }
                // Check for Obfuscated Dir in Project File Path
                boolean findObfDir = checkForObfuscatedDir();
                if (!findObfDir) {
                    new File(projectPath + "/obfuscated").mkdir();
                    File README = new File(projectPath+"/obfuscated", "README.txt");
                    try {
                        README.createNewFile();
                        String content = "This is the directory where all your obfuscated Lua code goes!";
                        FileWriter fw =  new FileWriter(README.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(content);
                        bw.close();
                    } catch (IOException e) {
                        updateStatusPanel("Error occurred while creating README.txt");
                    }
                    updateStatusPanel("Added obfuscation directory\nObfuscated code will be sent there\n");
                } else {
                    updateStatusPanel("Found project...obfuscation sent to obfuscated directory\n");
                }
                updateProjectDirFileTree();
            }
        }
    }

    public void importFilesToProject(int type) {
        // importing file
        if (type == 0) {
            fileChooser.setTitle("Choose Lua File");
            fileChooser.setVisible(true);
            String fn = fileChooser.getFile();
            String fn_loc = fileChooser.getDirectory();
            if (fn == null)
                return;
            File file = new File(fn_loc+fn);
            String file_extension = file.getName().split("\\.")[1];
            if (file_extension.equals("lua")) {
                boolean success = file.renameTo(new File(projectPath + File.separator + "Lua" + File.separator + file.getName()));
                if (success)
                    updateStatusPanel(fn_loc+fn + " added successfully to " + projectPath);
                else
                    updateStatusPanel("Error adding " + fn_loc+fn + " to " + projectPath);
            }
        }
        // Importing folder
        if (type == 1) {
            fileChooser.setTitle("Choose folder to import");
            fileChooser.setVisible(true);
            String fn = fileChooser.getFile();
            String fn_loc = fileChooser.getDirectory();
            // Cancelled import
            if (fn == null)
                return;
            File file = new File(fn_loc + fn);
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
                if (!files[i].isHidden()) {
                    if (!files[i].isDirectory()) {
                        String file_extension = files[i].getName().split("\\.")[1];
                        if (file_extension.equals("lua")) {
                            boolean success = files[i].renameTo(new File(projectPath + File.separator + "Lua" + File.separator + files[i].getName()));
                            if (success)
                                updateStatusPanel(fn_loc+fn + " added successfully to " + projectPath);
                            else
                                updateStatusPanel("Error adding " + fn_loc+fn + " to " + projectPath);
                        }
                    }
                }
            }
        }
        updateProjectDirFileTree();
    }

    public void save(){
        if (setDirectory) {
            System.out.println(currFilePath);
            System.out.println(projectPath);
            String newContent = luaEditorPane.getText();
            File newFile = new File(currFilePath);
            try {
                newFile.createNewFile();
                FileWriter fw = new FileWriter(newFile.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(newContent);
                bw.close();
                luaEditorPane.updateUI();
            } catch (IOException e) {
                updateStatusPanel("Failed to save " + newFile.getName());
            }
        } else {
            saveAs();
        }
    }

    public void saveAs() {
        fileChooser.setTitle("Choose Directory");
        fileChooser.setMode(FileDialog.SAVE);
        fileChooser.setVisible(true);
        String fn = fileChooser.getFile();
        String fn_loc = fileChooser.getDirectory();
        if (fn == null) {
            return;
        } else {
            projectPath = fn_loc + fn;
            System.out.println(projectPath);
        }
    }

    public void updateProjectDirFileTree() {
        projectDirectoryPanel.removeAll();
        projectDirectoryPanel.updateUI();
        projectDirectoryTree = new FileTree(new File(projectPath));
        projectDirectoryPanel.add(projectDirectoryTree, BorderLayout.CENTER);
        projectDirectoryPanel.updateUI();
        updateActionListenerProjectDirFileTree(projectDirectoryTree);
    }

    public void updateActionListenerProjectDirFileTree(FileTree dir) {
        dir.tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeSelectionEvent.getPath().getLastPathComponent();
                try {
                    String filePath = treeSelectionEvent.getPath().getParentPath().getLastPathComponent() + File.separator + node.toString();
                    File tmp = new File(node.toString());
                    if (!tmp.isDirectory()) {
                        if (!tmp.isHidden()) {
                            updateLuaEditorPane(filePath);
                        }
                    }
                } catch (NullPointerException e) {}
            }
        });
    }

    public void updateLuaEditorPane(String filePath) {
        // Create file to set to editorpane
        File file = new File(filePath);
        currFilePath = filePath;
        System.out.println(currFilePath);
        try {
            luaEditorPane.setPage(file.toURI().toURL());
        } catch (IOException e) {
            updateStatusPanel("Error occurred while reading lua file\n");
        }
    }

    public void deleteDirectory(File path) {
        File[] files = path.listFiles();
        for(int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()) {
                deleteDirectory(files[i]);
            } else {
                files[i].delete();
            }
        }
        path.delete();
    }

    public void clearEditorsDir() {
        luaEditorPane.selectAll();
        luaEditorPane.replaceSelection("");
        obfuscatedEditorPane.selectAll();
        obfuscatedEditorPane.replaceSelection("");
        projectDirectoryPanel.removeAll();
        projectDirectoryPanel.updateUI();
    }

    public void resetLuaGuard() {
        clearEditorsDir();
        currFilePath = "";
        projectPath = "";
        isProject = false;
        setTitle("LuaGuard");
        vocabComboBox.setEnabled(false);
        importFolder.setEnabled(false);
        importLuaFile.setEnabled(false);
        undo.setEnabled(false);
        redo.setEnabled(false);
        delete.setEnabled(false);
        reset.setEnabled(false);
        vocabRadioButton.setSelected(false);
        spacingRadioButton.setSelected(false);
        junkDataRadioButton.setSelected(false);
        parameterRadioButton.setSelected(false);
        statusTextPane.setText("Welcome to LuaGuard!\n" +
                "Create/open a project to begin\n" +
                "Or Start typing Lua code into the Lua Editor TextPane\n" +
                "For further help see our user manual at...\n");

    }

    public void alertBeforeExit() {
        if ((!obfuscateBtnClicked) && (!isProject) && (!luaEditorPane.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "Your work will not be saved or obfuscated!");
        } else {
            System.exit(0);
        }
    }

}
