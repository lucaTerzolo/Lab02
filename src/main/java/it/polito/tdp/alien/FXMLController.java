/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtTradotto"
    private TextArea txtTradotto; // Value injected by FXMLLoader

    @FXML // fx:id="txtTraduci"
    private TextField txtTraduci; // Value injected by FXMLLoader

    @FXML
    void handleCleatText(ActionEvent event) {
    	txtTradotto.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) throws Exception {
    	String s=txtTraduci.getText();
    	String stampa=new String();
    	String[] parole=s.toLowerCase().split(" ");
    	if(parole.length==1) {
    		stampa=this.model.traduci(parole[0]);
    	}
    	if(parole.length==2) {
    		stampa=this.model.aggiungi(parole[0],parole[1]);
    	}
    	txtTradotto.appendText(stampa+"\n");
    	txtTraduci.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtTradotto != null : "fx:id=\"txtTradotto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduci != null : "fx:id=\"txtTraduci\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    public void setModel(Model model) {
    	this.model=model;
    }
    
}
