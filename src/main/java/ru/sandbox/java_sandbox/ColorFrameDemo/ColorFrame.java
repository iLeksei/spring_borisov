package ru.sandbox.java_sandbox.ColorFrameDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public abstract class ColorFrame extends JFrame {

  /**
   * ColorFrame - singleton, Color - prototype, он он после того, как заинъектился
   * становится тоже - синглтоном
   */
  @Autowired
  private Color color;

  public ColorFrame() {
    setSize(200, 200);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public void showOnRandomPlace() {
    Random random = new Random();
    setLocation(random.nextInt(1200), random.nextInt(700));
    getContentPane().setBackground(getColor());
    repaint();
  }

  protected abstract Color getColor();
}
