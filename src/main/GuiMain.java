package main;

import gui.Gui;

/**
 * Created by lucasr on 5/16/14.
 */
public class GuiMain {
    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "LuaGuard");
        Gui myGui =  new Gui();
    }
}
