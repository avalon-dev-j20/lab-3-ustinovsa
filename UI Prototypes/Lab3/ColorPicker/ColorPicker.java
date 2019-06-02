/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3.ColorPicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.SwingConstants.*;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Home
 */
public class ColorPicker extends JFrame {

    private JPanel coloredPanel = new JPanel();
    private JPanel rgbPanel = new JPanel();

    private static String TITLE = "Color Picker";
    private static final int ORIENTATION = SwingConstants.HORIZONTAL;
    private static final int MIN = 0;
    private static final int PREF = 125;
    private static final int MAX = 255;
    private static final int MINOR_TICK = 5;
    private static final int MAJOR_TICK = 255;
    private static final int MIN_FRAME_WIDTH = 500;
    private static final int MIN_FRAME_HEIGHT = 250;
    private static final int MIN_CPANEL_WIDTH = 200;
    private static final int MIN_CPANEL_HEIGHT = 200;

    private JSlider redSlider = new JSlider();

    private JSlider greenSlider = new JSlider();

    private JSlider blueSlider = new JSlider();

    public ColorPicker() {
        super(TITLE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout());
        setMinimumSize(new Dimension(MIN_FRAME_WIDTH, MIN_FRAME_HEIGHT));
        setResizable(true);

        add(createColoredPanel());
        coloredPanel.setMinimumSize(new Dimension(MIN_CPANEL_WIDTH, MIN_CPANEL_HEIGHT));
        coloredPanel.setVisible(true);
        redSlider = createSlider();
        greenSlider = createSlider();
        blueSlider = createSlider();

        add(createRGBPanel());

        redSlider.addChangeListener(this::sliderListener);
        greenSlider.addChangeListener(this::sliderListener);
        blueSlider.addChangeListener(this::sliderListener);

        coloredPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                changeToolTip();
                copyToClipboard(coloredPanel.getToolTipText());
            }
        });
    }

    private void sliderListener(ChangeEvent e) {
        changeColor();

    }

    private void changeColor() {
        coloredPanel.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
    }

    private JSlider createSlider() {
        JSlider slider = new JSlider(ORIENTATION, MIN, MAX, PREF);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(MINOR_TICK);
        slider.setMajorTickSpacing(MAJOR_TICK);
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);

        return slider;
    }

    private JPanel createSliderPanel(String labelName, JSlider slider) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel(labelName);
        label.setHorizontalTextPosition(LEFT);
        panel.add(label);
        panel.add(slider);

        return panel;
    }

    private JPanel createRGBPanel() {
        rgbPanel.setLayout(new BoxLayout(rgbPanel, BoxLayout.Y_AXIS));
        rgbPanel.add(createSliderPanel("Red", redSlider));
        rgbPanel.add(createSliderPanel("Green", greenSlider));
        rgbPanel.add(createSliderPanel("Blue", blueSlider));
        return rgbPanel;
    }

    private JComponent createColoredPanel() {
        coloredPanel.setLayout(new BorderLayout());

        changeColor();
        return coloredPanel;
    }

    private void changeToolTip() {
        String hexCodeOfColor = '#'
                + Integer.toHexString(coloredPanel.getBackground().getRed())
                + Integer.toHexString(coloredPanel.getBackground().getGreen())
                + Integer.toHexString(coloredPanel.getBackground().getBlue());
        coloredPanel.setToolTipText(hexCodeOfColor.toUpperCase());
    }

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Clipboard clipboard = toolkit.getSystemClipboard();

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }
}
