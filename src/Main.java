import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface("E-Library");
        ui.setVisible(true);
        ui.setResizable(false);
        ui.setLocationRelativeTo(null);
    }
}