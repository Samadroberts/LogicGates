package main.java.Gates;

import main.java.exceptions.InvalidInputException;
import main.java.exceptions.NoValidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sam Roberts on 8/11/2016.
 */
public abstract class LogicGate {
	private List<LogicGate> inputList;
	private UUID id;
	private long inputLimit = 0;

	public LogicGate() {
		id = UUID.randomUUID();
		inputList = new ArrayList<>();
	}

	public void setInputLimit(long inputLimit) {
		if(inputLimit > 0) {
			this.inputLimit = inputLimit;
		} else {
			System.out.println("Input limit must be >0");
		}
	}

	public void addInput(LogicGate logicGate) throws InvalidInputException {
		if(logicGate.getId() != id) {
			if(inputLimit == 0) {
				inputList.add(logicGate);
			} else if(inputList.size() < inputLimit) {
				inputList.add(logicGate);
			} else {
				throw new InvalidInputException("Maximum number of inputs has been reached");
			}
		} else {
			throw new InvalidInputException("Cannot connect a logic Gate to itself");
		}
	}

	public UUID getId() {
		return id;
	}

	public List<LogicGate> getInputList() {
		return inputList;
	}
	public abstract Boolean computeOutput() throws NoValidInputException;

	public String toString() {
		try {
			return computeOutput().toString();
		} catch (NoValidInputException e) {
			return e.getMessage();
		}
	}
}
