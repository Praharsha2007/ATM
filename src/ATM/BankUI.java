package ATM;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;
public class BankUI extends Application {
    private Account acc;
    private ATM atm = new ATM();
    @Override
    public void start(Stage stage) {
        showLoginScreen(stage);
    }

    private void showLoginScreen(Stage stage) {
        PasswordField pinField = new PasswordField();
        pinField.setPromptText("Enter PIN");
        Button loginBtn = new Button("Login");
        Label msg = new Label();
        loginBtn.setOnAction(e -> {
            try {
                int pin = Integer.parseInt(pinField.getText());
                Account found = authenticate(pin);
                if (found != null) {
                    acc = found;
                    showTransactionScreen(stage);
                } else {
                    msg.setText("Wrong PIN");
                }
            } catch (Exception ex) {
                msg.setText("Invalid Input");
            }
        });
        VBox layout = new VBox(10, new Label("ATM Login"), pinField, loginBtn, msg);
        layout.setPadding(new Insets(20));
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("ATM Login");
        stage.show();
    }
    private Account authenticate(int pin) {
    	return atm.authenticate(pin);
    }
    private void showTransactionScreen(Stage stage) {
        TextField amountField = new TextField();
        amountField.setPromptText("Enter Amount");
        ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Deposit", "Withdraw");
        typeBox.setValue("Deposit");
        Button submitBtn = new Button("Submit");
        Button balanceBtn = new Button("Check Balance");
        Button historyBtn = new Button("Show History");
        Label result = new Label();
        TextArea historyArea = new TextArea();
        historyArea.setEditable(false);
        historyArea.setPrefHeight(120);
        submitBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String type = typeBox.getValue();
                String message;
                switch (type) {
                    case "Deposit":
                        message = atm.deposit(acc, amount);
                        break;
                    case "Withdraw":
                        message = atm.withdraw(acc, amount);
                        break;
                    default:
                        message = "Invalid Transaction";
                }
                result.setText(message + " | Balance: ₹" + atm.getBalance(acc));

            } catch (Exception ex) {
                result.setText("Invalid Input");
            }
        });

        balanceBtn.setOnAction(e -> {
            result.setText("Current Balance: ₹" + acc.getBalance());
        });
        
        historyBtn.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            for (Transaction t : acc.getTransactions()) {
                sb.append(t.toString()).append("\n");
            }
            if (sb.length() == 0) {
                historyArea.setText("No transactions yet.");
            } else {
                historyArea.setText(sb.toString());
            }
        });

        VBox layout = new VBox(10,
                new Label("Transaction Panel"),
                amountField,
                typeBox,
                submitBtn,
                balanceBtn,
                historyBtn,
                result,
                historyArea
        );
        layout.setPadding(new Insets(20));
        stage.setScene(new Scene(layout, 350, 450));
        stage.setTitle("ATM");
    }
    public static void main(String[] args) {
        launch();
    }
}