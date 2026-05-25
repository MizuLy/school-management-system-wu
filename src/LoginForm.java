import controllers.UserController;
import models.User;
import ui.MainFrame;
import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;
public class LoginForm extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginForm() {

        setTitle("Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Login");

        panel.add(new JLabel("Username"));
        panel.add(txtUsername);

        panel.add(new JLabel("Password"));
        panel.add(txtPassword);

        panel.add(new JLabel());
        panel.add(btnLogin);

        add(panel);

        // Button Action
        btnLogin.addActionListener(e -> login());
    }

    private void login() {

        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        User user = new User(username, password);

        UserController controller = new UserController();

        if (controller.login(user)) {

            JOptionPane.showMessageDialog(this, "Login Success");

            // Open your MainFrame
            MainFrame mf = new MainFrame();
            mf.setVisible(true);

            dispose();

        } else {

            JOptionPane.showMessageDialog(this, "Invalid Username or Password");
        }
    }

    public static void main(String[] args) {
    	try {

    	    UIManager.setLookAndFeel(new FlatLightLaf());

    	} catch (Exception e) {

    	    e.printStackTrace();
    	}
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
        
    }
}