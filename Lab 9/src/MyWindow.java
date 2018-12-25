import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MyWindow extends JFrame implements MouseListener {
	ArrayList<Student> myShapes = new ArrayList<Student>();
	
	public MyWindow() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	    System.out.println("Clicked");
		String name = "Click";
		double gpa = e.getX()/e.getY();
		myShapes.add(new Student(name, gpa));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
}
