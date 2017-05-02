package ru.mgusev.java1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Font displayFont = new Font("Arial", Font.BOLD, 30);

        setTitle("Калькулятор");
        setSize(250, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);


        JPanel displayPanel = new JPanel();
        final Display display = new Display("0");
        add(displayPanel, BorderLayout.NORTH);
        displayPanel.add(display);
        displayPanel.setPreferredSize(new Dimension(250, 50));
        displayPanel.setBackground(Color.BLACK);
        display.setVerticalAlignment(JLabel.CENTER);
        display.setHorizontalAlignment(JLabel.RIGHT);
        display.setPreferredSize(new Dimension(240, 40));
        display.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        display.setForeground(Color.BLACK);
        display.setBackground(Color.WHITE);
        display.setOpaque(true);
        display.setFont(displayFont);



        JPanel panel = new JPanel();
        JPanel numberPanel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout());
        numberPanel.setLayout(new GridLayout(4, 4));
        panel.add(numberPanel);

        JButton[] num = new JButton[10];
        for (int i = 0; i < 10; i++) {
            num[i] = new JButton("" + i);
            num[i].setFont(buttonFont);
            final int finalI = i;
            num[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    display.setOperand1("" + finalI);
                }
            });
        }

        JButton addition = new JButton("+");
        addition.setFont(buttonFont);
        JButton subtraction = new JButton("-");
        subtraction.setFont(buttonFont);
        JButton multiplication = new JButton("*");
        multiplication.setFont(buttonFont);
        JButton degree = new JButton("÷");
        degree.setFont(buttonFont);
        JButton clean = new JButton("C");
        clean.setFont(buttonFont);
        JButton dot = new JButton(".");
        dot.setFont(buttonFont);
        JButton equally = new JButton("=");
        equally.setFont(buttonFont);
        equally.setPreferredSize(new Dimension(200, 50));

        numberPanel.add(num[7]);
        numberPanel.add(num[8]);
        numberPanel.add(num[9]);
        numberPanel.add(degree);
        numberPanel.add(num[4]);
        numberPanel.add(num[5]);
        numberPanel.add(num[6]);
        numberPanel.add(multiplication);
        numberPanel.add(num[1]);
        numberPanel.add(num[2]);
        numberPanel.add(num[3]);
        numberPanel.add(subtraction);
        numberPanel.add(clean);
        numberPanel.add(num[0]);
        numberPanel.add(dot);
        numberPanel.add(addition);
        add(equally, BorderLayout.SOUTH);

        clean.addActionListener(new ActionListener() {
            @Override
            public void
            actionPerformed(ActionEvent e) {
                display.clear();
            }
        });

        addition.addActionListener(new ActionListener() {
            @Override
            public void
            actionPerformed(ActionEvent e) {
                display.setOperation("+");
            }
        });

        subtraction.addActionListener(new ActionListener() {
            @Override
            public void
            actionPerformed(ActionEvent e) {
                display.setOperation("-");
            }
        });

        multiplication.addActionListener(new ActionListener() {
            @Override
            public void
            actionPerformed(ActionEvent e) {
                display.setOperation("*");
            }
        });

        degree.addActionListener(new ActionListener() {
            @Override
            public void
            actionPerformed(ActionEvent e) {
                display.setOperation("÷");
            }
        });

        equally.addActionListener(new ActionListener() {
            @Override
            public void
            actionPerformed(ActionEvent e) {
                display.calculate();
            }
        });

        dot.addActionListener(new ActionListener() {
            @Override
            public void
            actionPerformed(ActionEvent e) {
                display.setDot(".");
            }
        });

        setVisible(true);
    }
}