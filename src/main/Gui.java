package main;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.File;
import java.util.*;
import main.FileTree;


/**
 * Created by lucasr on 5/16/14.
 */
public class Gui extends JFrame{
    private JButton cancelButton;
    private JButton obfuscateButton;
    private JTextPane statusTextPane;
    private JEditorPane luaEditorPane;
    private JEditorPane obfuscatedEditorPane;
    private JTree projectDirectoryTree;
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

    // Attr added by Lucas not Intellji form designer
    private FileDialog fileChooser;
    private String projectPath;
    private boolean isProject;
    private JMenuItem delete;
    private JMenuItem undo;
    private JMenuItem redo;
    //private Queue<String> recentObfuscated;

    public Gui() {
        super("LuaGuard");
        setContentPane(rootPanel);
        pack();

        // Delete random data in JTree Directory
        //projectDirectoryTree.setModel(null);

        // Adding menu bar
        JMenuBar menubar = new JMenuBar();

        // Adding File menu tab with its menu items
        JMenu file = new JMenu("File");
        JMenuItem newproj = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open file...");
        JMenuItem openProj = new JMenuItem("Open Project");

        // Adding edit menu tab with its menu items
        JMenu edit = new JMenu("Edit");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        delete = new JMenuItem("Delete");
        undo.setEnabled(false);
        redo.setEnabled(false);
        delete.setEnabled(false);

        // Init file chooser and project path for selecting files/dirs
        fileChooser = new FileDialog(this, "Choose a file", FileDialog.LOAD);
        projectPath = "";

        // Init status pane with welcome/info message
        statusTextPane.setText("Welcome to LuaGuard!\n" +
                "Create/open a project to begin\n" +
                "Or Start typing Lua code into the Lua Editor TextPane\n" +
                "For further help see our user manual at...\n");

        // Set Layout for FileTree
        projectDirectoryPanel.setLayout(new BorderLayout());

        // Add to menu
        file.add(newproj);
        file.add(open);
        file.add(openProj);
        edit.add(undo);
        edit.add(redo);
        edit.add(delete);

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

        delete.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        delete.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                if (isProject) {
                    File file = new File(projectPath+"/obfuscated");
                    file.delete();
                } else {
                    System.out.println("DOTHisLater");
                    //File file = new File(projectPath);
                    //file.delete();
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



        obfuscateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                delete.setEnabled(true);
                undo.setEnabled(true);
                // Get Lua Code
                String luaCode = luaEditorPane.getText();

                // Generate AST, Symbol Table and other shit here...

                // Check Degree of Obfuscation Radio Buttons
                if (vocabRadioButton.isSelected()) {
                    // Do Vocab obfuscation here...

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
                obfuscatedEditorPane.setText(luaCode);

                //JOptionPane.showMessageDialog(Gui.this, luaCode);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

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

    public void openOrNewFileDirProj(int type){
        // int type => Type of Action
        // 0 = New project
        // 1 = Open file
        // 2 = Open a Project
        fileChooser.setVisible(true);
        String fn = fileChooser.getFile();
        String fn_loc = fileChooser.getDirectory();
        if (fn == null) {
            return;
        } else {
            projectPath = fn_loc + fn;
            // Opening a lua file
            if (type == 1) {
                String file_extension = fn.split("\\.")[1];
                if (!file_extension.equals("lua")) {
                    updateStatusPanel("Incompatible file type chosen, .lua files only supported\n");
                } else {
                    // Write text from file to luaEditorPane
                    try {
                        File file = new File(projectPath);
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
                isProject = true;
                // Check for Obfuscated Dir in Project File Path
                boolean findObfDir = checkForObfuscatedDir();
                if (!findObfDir) {
                    new File(projectPath+"/obfuscated").mkdir();
                    updateStatusPanel("Added obfuscation directory\nObfuscated code will be sent there\n");
                } else {
                    updateStatusPanel("Found project...obfuscation sent to obfuscated directory\n");
                }

                projectDirectoryPanel.removeAll();
                projectDirectoryPanel.updateUI();
                JPanel tmp  = new FileTree(new File(projectPath));
                projectDirectoryPanel.add(tmp, BorderLayout.CENTER);
                projectDirectoryPanel.updateUI();
            }
        }
    }

}
