package gui;

import exceptions.InvalidInputException;
import gui.gates.abstractGate;
import javafx.fxml.FXML;

/**
 * Created by Sam Roberts on 8/19/2016.
 */
public class InputNode extends abstractNode {;
	private Connection connection;
	public InputNode() {
		super();
	}

	public void setConnection(Connection connection) {
		if(connection != null) {
			for(InputNode inputNode : getAbstractGate().getInputNodes()) {
				if(getUuid() == inputNode.getUuid()) {
					try {
						getLogicGate().addInput(connection.getInputLogicGate());
						this.connection = connection;
						//this.connection.refresh();
					} catch (InvalidInputException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

	@Override
	public boolean hasConnection() {
		return (connection != null);
	}
}

