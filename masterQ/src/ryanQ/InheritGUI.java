package ryanQ;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
/**
 * 
 * @author Ryan Wagner
 *
 */
public class InheritGUI {
	CPUGUI gui = new CPUGUI();
	CPU cpu = new CPU();
	private int WIDTH = 700;
	private int HEIGHT = 400;
	/*
	 * Empty constructor.
	 */
	public InheritGUI()throws IOException{	
	}
	/**
	 * Runs the simulation.
	 * @param que Takes in job.jobQue()
	 * @param frame JFrame from kFrame class.
	 * @throws IOException 
	 * @throws InterruptedException
	 */
public void runSim(ObjectQueue que, JFrame frame)throws IOException, InterruptedException{
	cpu.setVals();
	JLabel label1 = new JLabel("CPU Time:");
	JLabel label2 = new JLabel(""+cpu.cpuTime());
	JLabel label3 = new JLabel("\t");
	JLabel label4 = new JLabel("Current Job:");
	JLabel label5 = new JLabel("Lowest Level Queue: ");
	JLabel label6 = new JLabel("Remaining Work Time: ");
	JLabel label7 = new JLabel("Quantums Remaining: ");
	JLabel label8 = new JLabel("Idle Time: ");
	JLabel label9 = new JLabel("Entry Time: ");
	JLabel label10 = new JLabel(""+cpu.jobID());
	JLabel label11 = new JLabel(""+cpu.enQue());
	JLabel label12 = new JLabel(""+(cpu.totalTime()-cpu.averageRun()));
	JLabel label13 = new JLabel("");
	JLabel label14 = new JLabel("");
	JLabel label15 = new JLabel(""+cpu.workTime());
	JLabel label16 = new JLabel("");
	JLabel label17 = new JLabel("");
	JLabel label18 = new JLabel(""+cpu.qClock());
	JLabel label19 = new JLabel("");
	JLabel label20 = new JLabel("");
	JLabel label21 = new JLabel(""+cpu.llq());
	JLabel label22 = new JLabel("");
	JLabel label23 = new JLabel("");
	JLabel label24 = new JLabel("");
	JLabel label25 = new JLabel("");
	JLabel label26 = new JLabel("");
	JLabel label27 = new JLabel("");
	JLabel label28 = new JLabel("");
	JButton button29 = new JButton("Start Sequence:");
	JLabel label30 = new JLabel("");
	frame.add(label1);
	frame.add(label2);
	frame.add(label3);
	frame.add(label4);
	frame.add(label10);
	frame.add(label13);
	frame.add(label9);
	frame.add(label11);
	frame.add(label14);
	frame.add(label8);
	frame.add(label12);
	frame.add(label17);
	frame.add(label6);
	frame.add(label15);
	frame.add(label16);
	frame.add(label7);
	frame.add(label18);
	frame.add(label19);
	frame.add(label5);
	frame.add(label21);
	frame.add(label22);
	frame.add(label23);
	frame.add(label24);
	frame.add(label25);
	frame.add(label26);
	frame.add(label27);
	frame.add(label28);
	frame.add(label30);
	frame.add(button29);
	frame.revalidate();
	Thread.sleep(100);
	frame.remove(label1);
	frame.remove(label2);
	frame.remove(label3);
	frame.remove(label4);
	frame.remove(label5);
	frame.remove(label6);
	frame.remove(label7);
	frame.remove(label8);
	frame.remove(label9);
	frame.remove(label10);
	frame.remove(label11);
	frame.remove(label12);
	frame.remove(label13);
	frame.remove(label14);
	frame.remove(label15);
	frame.remove(label16);
	frame.remove(label17);
	frame.remove(label18);
	frame.remove(label19);
	frame.remove(label20);
	frame.remove(label21);
	frame.remove(label22);
	frame.remove(label23);
	frame.remove(label24);
	frame.remove(label25);
	frame.remove(label26);
	frame.remove(label27);
	frame.remove(label28);
	frame.remove(label30);
	frame.remove(button29);
	if(!que.isEmpty()){
		cpu.notEmpty(que);
		runSim(que, frame);
	}else{
		if(cpu.busy()){
			cpu.quesEmpty(que);
			runSim(que, frame);
		}
	}
}
/**
 * Outputs the raw Stats.
 */
public void outStats(){
	System.out.println("ACTION\t\tPID\tSYSTIME\tWORKTIME\tTIMER\tLLQ:");
	while (!cpu.queReturn().isEmpty())
		System.out.println(cpu.queReturn().remove());
}
/**
 * Builds the GUI
 * @throws IOException
 * @throws InterruptedException
 */
public void jFrame()throws IOException, InterruptedException{
	Scanner scan = new Scanner(new File("mfq.txt"));
	Job job = new Job(scan);
	job.setJobs();
	JFrame frame = new JFrame("CPU Virtualization GUI");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WIDTH,HEIGHT);
	GridLayout layout = new GridLayout(10,3);
	frame.setLayout(layout);
	frame.setVisible(true);
	runSim(job.jobQue(), frame);
	outStats();
}
}
