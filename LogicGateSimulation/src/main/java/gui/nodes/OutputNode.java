package gui.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam Roberts on 9/2/2016.
 */
public class OutputNode extends abstractNode {
	private List<Connection> connectionList;
	private final static int MAX_CONNECTIONS = Integer.MIN_VALUE;
	public OutputNode() {
		super();
		connectionList = new ArrayList<Connection>();
	}

	@Override
	public boolean hasConnection() {
		return !connectionList.isEmpty();
	}

	@Override
	public Connection getConnection() {
		if(!connectionList.isEmpty()) {
			return connectionList.get(connectionList.size() - 1);
		}
		return new Connection();
	}

	@Override
	public int getMaxConnections() {
		return MAX_CONNECTIONS;
	}

	@Override
	public void addConnection(Connection connection) {
		if(connection != null) {
			connectionList.add(connection);
			connection.refresh();
		}
	}

	@Override
	public void initConnection() {
		return;
	}

	@Override
	public void setConnectionVisisble(boolean visible) {
		for(Connection connection : getConnectionList()) {
			connection.setVisible(visible);
		}
	}

	public List<Connection> getConnectionList() {
		return connectionList;
	}
}
