package simstation;
import mvc.*;
import javax.swing.*;

public class SimstationPanel extends AppPanel {
    public SimstationPanel(AppFactory factory) {
        super(factory);

        JButton start = new JButton("Start");
        start.addActionListener(this);
        controlPanel.add(start);

        JButton suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        controlPanel.add(suspend);

        JButton resume = new JButton("Resume");
        resume.addActionListener(this);
        controlPanel.add(resume);

        JButton stop = new JButton("Stop");
        stop.addActionListener(this);
        controlPanel.add(stop);

        JButton stats = new JButton("Stats");
        stats.addActionListener(this);
        controlPanel.add(stats);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimstationPanel(new SimstationFactory());
        panel.display();
    }
}
