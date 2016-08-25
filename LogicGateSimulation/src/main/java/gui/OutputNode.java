package gui;

/**
 * Created by Sam Roberts on 8/23/2016.
 */


import logic.gates.LogicGate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam Roberts on 8/19/2016.
 */
public class OutputNode extends abstractNode {
	private List<Connection> connectionList;
	public OutputNode() {
		super();
		connectionList = new ArrayList<Connection>();
	}

	@Override
	public void setConnection(Connection connection) {
		if(connection != null) {
			connectionList.add(connection);
			connection.refresh();
		}
	}

	@Override
	public boolean hasConnection() {
		return !connectionList.isEmpty();
	}

	public List<Connection> getConnectionList() {
		return connectionList;
	}
}


