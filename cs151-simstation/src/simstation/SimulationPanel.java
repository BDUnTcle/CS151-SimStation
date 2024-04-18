package simstation;
import mvc.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class SimulationPanel extends AppPanel {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cmmd = e.getActionCommand();
            Simulation sim = (Simulation)model;
            switch (cmmd) {
                case "Save":
                    if(sim.getState() != Simulation.STATE.READY)
                    {
                        Utilities.error("Can't Save When its Running or Suspended");
                    }
                    else {
                        Utilities.save(model, false);
                    }
                    break;
                case "SaveAs":
                    if(sim.getState() != Simulation.STATE.READY)
                    {
                        Utilities.error("Can't Save When its Running or Suspended");
                    }
                    else {
                        Utilities.save(model, true);
                    }
                    break;
                case "Open":
                    Model newModel = Utilities.open(model);
                    if (newModel != null) {
                        setModel(newModel);
                    }
                    break;
                case "About":
                    Utilities.inform(this.factory.about());
                    break;
                case "Help":
                    Utilities.inform(this.factory.getHelp());
                    break;
                case "New":
                    Utilities.saveChanges(model);
                    setModel(factory.makeModel());
                    model.setUnsavedChanges(false);
                    break;
                case "Quit":
                    Utilities.saveChanges(model);
                    System.exit(0);
                    break;
                default:
                    Command c = factory.makeEditCommand(this.model, cmmd, this);
                    c.execute();
            }
        } catch (Exception error) {
            Utilities.error(error);
        }
    }
    public SimulationPanel(AppFactory factory) {
        super(factory);
//        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
//        setBorder(lineBorder);
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
    @Override
    public void setModel(Model m) {
        super.setModel(m); // calling AppPanel.setModel(m)
        Simulation s = (Simulation)m;
        Iterator<Agent> it = s.getAgents().iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start(); // this will call Agent.run (see below)
        }
    }
}
