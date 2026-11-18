import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Menu System
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processSale());
        clearItem.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        txtCustomerName = new JTextField();
        inputPanel.add(txtCustomerName, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        inputPanel.add(new JLabel("Select Product:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        inputPanel.add(cmbProduct, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        inputPanel.add(new JLabel("Enter Price:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        txtPrice = new JTextField();
        inputPanel.add(txtPrice, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; 
        gbc.fill = GridBagConstraints.NONE; gbc.anchor = GridBagConstraints.CENTER;
        btnProcess = new JButton("PROCESS");
        btnProcess.setPreferredSize(new Dimension(150, 30));
        inputPanel.add(btnProcess, gbc);

        add(inputPanel, BorderLayout.CENTER);

        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });
    }

    private void processSale() {
        try {
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();
            
            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a Customer Name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price = Double.parseDouble(txtPrice.getText().trim());

            ProductCalculations calc = new ProductCalculations(price);
            
            double vatAmount = calc.GetVat();
            double commissionAmount = calc.GetCommission();
            double totalSaleAmount = calc.GetTotal();

            // Format output
            String messageOutput = String.format(
                    "Customer Name: %s\n" +
                    "Product: %s\n" +
                    "VAT: R %.1f\n" +
                    "COMMISSION: R %.1f\n" +
                    "TOTAL: R %.1f",
                    customerName, productName, vatAmount, commissionAmount, totalSaleAmount
            );

            JOptionPane.showMessageDialog(this, messageOutput, "Message", JOptionPane.INFORMATION_MESSAGE);

            saveToFile(customerName, productName, vatAmount, commissionAmount, totalSaleAmount);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for the Price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile(String customer, String product, double vat, double commission, double total) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
            writer.write("Customer Name: " + customer + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("-----------------------------------\n"); 
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
