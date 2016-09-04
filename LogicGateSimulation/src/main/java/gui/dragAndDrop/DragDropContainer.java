package gui.dragAndDrop;

import javafx.scene.input.DataFormat;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DragDropContainer implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -1458406119115196098L;

	private final List <Pair<String, String> > mDataPairs = new ArrayList <Pair<String, String> > ();

	public static final DataFormat Binding =
			new DataFormat("com.buddyware.treefrog.filesystem.view.FileSystemBinding");

	public static final DataFormat Node =
			new DataFormat("gui.gates.abstractGate"/*"com.buddyware.treefrog.filesystem.view.FileSystemNode"*/);

	public DragDropContainer () {
	}

	public void addData (String key, String value) {
		mDataPairs.add(new Pair<String, String>(key, value));
	}

	public String getValue (String key) {

		for (Pair<String, String> data: mDataPairs) {

			if (data.getKey().equals(key))
				return (String) data.getValue();

		}

		return null;
	}

	public List <Pair<String, String> > getData () { return mDataPairs; }
}