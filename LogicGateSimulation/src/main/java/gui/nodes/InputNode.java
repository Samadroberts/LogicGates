package gui.nodes;

import exceptions.InvalidInputException;

/**
 * Created by Sam Roberts on 9/2/2016.
 */
public class InputNode extends abstractNode {
	private Connection connection;
	private static final int MAX_CONNECTIONS = 1;
	public InputNode() {
		super();
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public int getMaxConnections() {
		return MAX_CONNECTIONS;
	}

	@Override
	public void addConnection(Connection connection) {
		if(connection != null) {
			this.connection = connection;
		}
	}

	@Override
	public void initConnection() {
		if(connection != null) {
			for(InputNode inputNode : getAbstractGate().getInputNodes()) {
				if(getUuid() == inputNode.getUuid()) {
					try {
						getLogicGate().addInput(connection.getInputLogicGate());
						connection.refresh(); //TODO IS THIS NEEDED?
					} catch (InvalidInputException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void setConnectionVisisble(boolean visible) {
		connection.setVisible(visible);
	}

	public InputNode(boolean visible) {
		connection.setVisible(visible);
	}

	@Override
	public boolean hasConnection() {
		return (connection != null);
	}
}
