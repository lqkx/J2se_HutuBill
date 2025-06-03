package gui.panel;
 
import entity.Record;
import service.ReportService;
import util.ChartUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static util.GUIUtil.showPanel;
 
public class ReportPanel extends WorkingPanel {
    public static ReportPanel instance = new ReportPanel();
 
    JLabel l = new JLabel();
 
    public ReportPanel() {
        this.setLayout(new BorderLayout());
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 400, 300);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
        addListener();
    }
 
    public static void main(String[] args) {
        showPanel(ReportPanel.instance);
    }
 
    @Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }
 
    @Override
    public void addListener() {
 
    }
}