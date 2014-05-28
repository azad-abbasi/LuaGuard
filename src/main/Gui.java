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
    private JScrollPane projectDirectoryScrollPane;
    private JPanel statusPanel;
    private JScrollPane statusScrollPane;
    private JPanel degreeObfuscationPanel;
    private JButton chooseButton;
    private JButton trashButton;

    // Attr added by Lucas not Intellji form designer
    private FileDialog fileChooser;
    private String projectPath;
    private Queue<String> recentObfuscated;

    public Gui() {
        super("LuaGuard");
        setContentPane(rootPanel);
        pack();

        // Delete random data in JTree Directory
        projectDirectoryTree.setModel(null);

        // Adding menu bar
        JMenuBar menubar = new JMenuBar();

        // Adding File menu tab with its menu items
        JMenu file = new JMenu("File");
        JMenuItem newproj = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open file...");
        JMenuItem openProj = new JMenuItem("Open Project");

        // Adding edit menu tab with its menu items
        JMenu edit = new JMenu("Edit");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem redo = new JMenuItem("Redo");
        JMenuItem delete = new JMenuItem("Delete");

        // Init file chooser and project path for selecting files/dirs
        fileChooser = new FileDialog(this, "Choose a file", FileDialog.LOAD);
        projectPath = "";

        // Create a project, by either selecting a directory or creating a new directory
        newproj.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        newproj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Set to only open dirs
                System.setProperty("apple.awt.fileDialogForDirectories", "true");
                // Toggle File Chooser, get filename and dir of file
                fileChooser.setVisible(true);
                String fn = fileChooser.getFile();
                String fn_loc = fileChooser.getDirectory();

                // No File was Chosen
                if (fn == null) {
                    updateStatusPanel("Project not created, no folder specified or created");
                } else {    // Get Path of Directory
                    projectPath = fn_loc + fn;
                    File file =  new File(fn_loc + fn);
                    String[] files = file.list();
                    // Check for Obfuscated Dir in Project File Path
                    boolean containsObfDir =  false;
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].equals("obfuscated")){
                            if (new File(fn_loc + files[i]).isDirectory()) {
                                containsObfDir = true;
                                break;
                            }
                        }
                    }
                    if (!containsObfDir) {
                        new File(fn_loc+fn+"/obfuscated").mkdir();
                        String currText = statusTextPane.getText();
                        currText += "Added obfuscation directory\nObfuscated code will be sent there\n";
                        statusTextPane.setText(currText);
                    } else {
                        String currText = statusTextPane.getText();
                        currText += "Found project...obfuscation sent to obfuscated dir\n";
                        statusTextPane.setText(currText);
                    }
                }
            }
        });

        // Open a file, in menu bar or with HotKey command+o
        open.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        open.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // Set to open only files
                System.setProperty("apple.awt.fileDialogForDirectories", "false");
                fileChooser.setVisible(true);
                String fn = fileChooser.getFile();
                String fn_loc = fileChooser.getDirectory();

                // No file was chosen
                if (fn == null) {
                    String currText = statusTextPane.getText();
                    currText += "No file Chosen\n";
                    statusTextPane.setText(currText);
                } else {
                // File was chosen, check file extension
                    projectPath = fn_loc + fn;
                    String file_extension = fn.split("\\.")[1];
                    if (!file_extension.equals("lua")) {
                        String currText = statusTextPane.getText();
                        currText += "Incompatible file type chosen, .lua files only supported\n";
                        statusTextPane.setText(currText);
                    } else {
                        // Write text from file to luaEditorPane
                        String tmp = fn_loc + fn;
                        try {
                            File file = new File(tmp);
                            luaEditorPane.setPage(file.toURI().toURL());
                        } catch (IOException ex) {
                            // Catch exception if file not found
                            String currText = statusTextPane.getText();
                            currText += "Could not find file!\n";
                            statusTextPane.setText(currText);
                        }
                    }
                }
            }
        });

        // Open a project, in menu bar or with HotKey shift+command+o
        openProj.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, (java.awt.event.InputEvent.SHIFT_MASK | (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()))));
        openProj.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Open Project...");
                // Set to open only dirs
                System.setProperty("apple.awt.fileDialogForDirectories", "true");
                fileChooser.setVisible(true);
                String fn = fileChooser.getFile();
                String fn_loc = fileChooser.getDirectory() + fn;
                if (fn == null) {
                    System.out.println("You cancelled the choice");
                } else {
                    projectPath = fn_loc + fn;
                    File file =  new File(fn_loc);
                    String[] files = file.list();
                    boolean containsObfDir =  false;
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].equals("obfuscated")){
                            if (new File(fn_loc + files[i]).isDirectory()) {
                                containsObfDir = true;
                                break;
                            }
                        }
                    }
                    if (!containsObfDir) {
                        new File(fn_loc+"/obfuscated").mkdir();
                    } else {
                        String currText = statusTextPane.getText();
                        currText += "Found project...obfuscation sent to obfuscated directory\n";
                        statusTextPane.setText(currText);
                    }


                }
            }
        });

        delete.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        delete.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete This Project...");
                File file = new File(projectPath);
                file.delete();
            }
        });

        undo.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())));
        undo.addActionListener(new ActionListener(  ) {
            public void actionPerformed(ActionEvent e) {
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

        //
        file.add(newproj);
        file.add(open);
        file.add(openProj);
        edit.add(undo);
        edit.add(redo);
        edit.add(delete);

        statusTextPane.setText("Welcome to LuaGuard!\n" +
                "Create/open a project to begin\n" +
                "Or Start typing Lua code into the Lua Editor TextPane\n" +
                "For further help see our user manual at...\n");


        obfuscateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
        currText += addText + "\n";
        statusTextPane.setText(currText);
    }

    public boolean checkForObfuscatedDir(String projectPath) {
        // Create boolean and init File objects to find sub dir and files
        boolean containsObfDir = false;
        File file =  new File(projectPath);
        String[] files = file.list();
        // Iterate through sub-dirs and files looking for obfuscated dir
        for (int i = 0; i < files.length; i++) {
            if (files[i].equals("obfuscated")){     //Found file "obfuscate"
                // Check if Obfuscated file is a dir
                if (new File(projectPath + files[i]).isDirectory()) {
                    containsObfDir = true;
                    break;
                }
            }
        }
        return containsObfDir;
    }

}
