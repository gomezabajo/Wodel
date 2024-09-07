package wodel.utils.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.ReferenceNonExistingException;

public class CircuitUtils {
	
	public static class LogicalInputPin implements Comparable<LogicalInputPin> {
		private String _name = "Not Set";
		private boolean _isInitial = false;
		private LogicalOutputPin _source = null;
		
		@Override
		public String toString() {
			return String.format("InputPin {%s}", this._name);
		}
		
		public void reset() {
			this._name = "Not Set";
			this._isInitial = false;
		}
		
		public void setName(String name) {
			this._name = name;
		}
		
		public String getName() {
			return this._name;
		}
		
		public void setInitial(boolean isInitial) {
			this._isInitial = isInitial; 
		}
		
		public boolean isInitial() {
			return this._isInitial;
		}
		
		public LogicalOutputPin getSource() {
			return this._source;
		}
		
		public void setSource(LogicalOutputPin source) {
			this._source = source;
		}

		@Override
		public int compareTo(LogicalInputPin other) {
			return this._name.compareTo(other.getName());
		}
	}
	
	public static class LogicalOutputPin {
		private String _name = "Not Set";
		private boolean _isFinal = false;
		private LogicalInputPin _target = null;
		
		@Override
		public String toString() {
			return String.format("OutputPin {%s}", this._name);
		}
		
		public void reset() {
			this._name = "Not Set";
			this._isFinal = false;
		}
		
		public void setName(String name) {
			this._name = name;
		}
		
		public String getName() {
			return this._name;
		}
		
		public void setFinal(boolean isFinal) {
			this._isFinal = isFinal; 
		}
		
		public boolean isFinal() {
			return this._isFinal;
		}

		public LogicalInputPin getTarget() {
			return this._target;
		}
		
		public void setTarget(LogicalInputPin target) {
			this._target = target;
		}
	}

	public static abstract class LogicalNode {
        private List<LogicalNode> _inputs = new ArrayList<LogicalNode>();
        private List<LogicalInputPin> _inputPins = new ArrayList<LogicalInputPin>();
        private LogicalOutputPin _outputPin = null;
        private String _name = "Not Set";


        @Override
        public String toString() {
            return String.format("Node {%s}", this._name);
        }

        public void reset() {
            this._inputs.clear();
            this._inputPins.clear();
            if (this._outputPin != null) {
            	this._outputPin = null;
            }
        }

        public void setName(String name) {
            this._name = name;
        }
        
        public String getName() {
        	return this._name;
        }

        public List<LogicalNode> getInputs() {
            return this._inputs;
        }

        public void addInput(LogicalNode node) {
            this._inputs.add(node);
        }
        
        public List<LogicalInputPin> getInputPins() {
        	return this._inputPins;
        }
        
        public void addInputPin(LogicalInputPin inputPin) {
        	this._inputPins.add(inputPin);
        }
        
        public LogicalOutputPin getOutputPin() {
        	return this._outputPin;
        }
        
        public void setOutputPin(LogicalOutputPin outputPin) {
        	this._outputPin = outputPin;
        }

        protected boolean computeOutputInternal() {
            return false;
        }

        public boolean computeOutput() {
           // Console.WriteLine("Computing output on {%s}.", _name);
            return computeOutputInternal();
        }
    }

    public static class LogicalInput extends LogicalNode {
        private boolean _state = true;

        public void setState(boolean state) {
            _state = state;
        }

        public boolean GetState() { return _state; }

        @Override
        protected boolean computeOutputInternal() {
            return _state;
        }
    }

    public static class LogicalAND extends LogicalNode {
    	@Override
        protected boolean computeOutputInternal() {
            List<LogicalNode> inputs = getInputs();
            boolean result = true;
            for (int idx = 0; idx < inputs.size() && result; idx++) {
                result = result && inputs.get(idx).computeOutput();
            }
            return result;
        }
    }

    public static class LogicalOR extends LogicalNode {
    	@Override
        protected boolean computeOutputInternal() {
            List<LogicalNode> inputs = getInputs();
            boolean result = false;
            for (int idx = 0; idx < inputs.size(); idx++) {
                result = inputs.get(idx).computeOutput();
                if (result)
                    // If we get one true, that is enough.
                    break;
            }
            return result;
        }
    }

    public static class LogicalNOT extends LogicalNode {
    	@Override
        protected boolean computeOutputInternal() {
            List<LogicalNode> inputs = getInputs();
            if (inputs.size() > 0) {
            	// NOTE:  This is not an optimal design for
                // handling distinct different kinds of circuits.
                //
                // It it demonstrative only!!!!
                return !inputs.get(0).computeOutput();
            }
            return false;
        }
    }
    
    public static abstract class Circuit<T, U, V> {
    	List<T> nodes = new ArrayList<T>();
    	
    	public Circuit() {
    		
    	}
    	
    	public void addNode(T node) {
    		nodes.add(node);
    	}
    	
    	public T getNode(String name) {
    		return null;
    	}
    	
    	public T getNextNode(T node) {
    		return null;
    	}
    	
    	public T getNodeWithOutput(String output) {
    		return null;
    	}
    	
    	public T getNodeWithInput(String input) {
    		return null;
    	}

    	public T getOutputNode() {
    		return null;
    	}
    	
    	public List<T> getInitialNodes() {
    		return null;
    	}
    	
    	public List<U> getInputPins() {
    		return null;
    	}
    	
    	public V getOutputPin() {
    		return null;
    	}
    	
    	public List<T> getNodes() {
    		return null;
    	}
    	
    	public int getDistance() {
    		return 0;
    	}
    }
    
    public static class LogicalCircuit extends Circuit<LogicalNode, LogicalInputPin, LogicalOutputPin> {
    	public LogicalCircuit() {
    		super();
    	}
    	
    	@Override
    	public LogicalNode getNode(String name) {
    		for (LogicalNode node : nodes) {
    			if (node.getName().equals(name)) {
    				return node;
    			}
    		}
    		return null;
    	}
    	
    	@Override
    	public LogicalNode getNextNode(LogicalNode node) {
    		LogicalOutputPin outputPin = node.getOutputPin();
    		for (LogicalNode n : nodes) {
    			List<LogicalInputPin> inputPins = n.getInputPins();
    			for (LogicalInputPin inputPin : inputPins) {
    				if (inputPin.getSource() != null) {
    					if (inputPin.getSource().equals(outputPin)) {
    						return n;
    					}
    				}
    			}
    		}
    		return null;
    	}
    	
    	@Override
    	public LogicalNode getNodeWithOutput(String output) {
			for (LogicalNode node : nodes) {
				LogicalOutputPin outputPin = node.getOutputPin();
				if (outputPin.getName().equals(output)) {
					return node;
				}
			}
			return null;
    	}
    	
    	@Override
    	public LogicalNode getNodeWithInput(String input) {
			for (LogicalNode node : nodes) {
				List<LogicalInputPin> inputPins = node.getInputPins();
				for (LogicalInputPin inputPin : inputPins) {
					if (inputPin.getName().equals(input)) {
						return node;
					}
				}
			}
			return null;
    	}

    	@Override
    	public List<LogicalInputPin> getInputPins() {
    		List<LogicalInputPin> initialInputPins = new ArrayList<LogicalInputPin>();
    		for (LogicalNode node : nodes) {
    			List<LogicalInputPin> inputPins = node.getInputPins();
    			for (LogicalInputPin inputPin : inputPins) {
    				if (inputPin != null && inputPin.isInitial()) {
    	    			initialInputPins.add(inputPin);
    				}
    			}
    		}
    		Collections.sort(initialInputPins);
    		return initialInputPins;
    	}
    	
    	@Override
    	public LogicalOutputPin getOutputPin() {
    		for (LogicalNode node : nodes) {
    			LogicalOutputPin outputPin = node.getOutputPin();
    			if (outputPin != null && outputPin.isFinal()) {
    				return outputPin;
    			}
    		}
    		return null;
    	}

    	@Override
    	public LogicalNode getOutputNode() {
    		for (LogicalNode node : nodes) {
    			LogicalOutputPin outputPin = node.getOutputPin();
    			if (outputPin != null && outputPin.isFinal()) {
    				return node;
    			}
    		}
    		return null;
    	}
    	
    	private int getDistance(LogicalInputPin inputPin, List<LogicalInputPin> processed) {
   			LogicalNode node = this.getNodeWithInput(inputPin.getName());
   			LogicalOutputPin output = node.getOutputPin();
			if (output != null) {
				LogicalInputPin next = output.getTarget();
				if (next != null && !processed.contains(next)) {
					processed.add(next);
					return 1 + getDistance(next, processed);
				}
			}
    		return 0;
    	}
    	
    	@Override
    	public int getDistance() {
    		List<LogicalInputPin> inputPins = this.getInputPins();
			List<LogicalInputPin> processed = new ArrayList<LogicalInputPin>();
    		int distance = 0;
    		for (LogicalInputPin inputPin : inputPins) {
    			LogicalNode node = this.getNodeWithInput(inputPin.getName());
    			LogicalOutputPin output = node.getOutputPin();
    			if (output != null) {
    				LogicalInputPin next = output.getTarget();
    				if (next != null && !processed.contains(next)) {
    					processed.add(next);
    					int tmp = 1 + getDistance(next, processed);
    					if (tmp > distance) {
    						distance = tmp;
    					}
    				}
    			}
    		}
    		return distance;
    	}
    }
    
    public static LogicalCircuit convertToLC(List<EPackage> packages, Resource model) {
    	LogicalCircuit logicalCircuit = new LogicalCircuit();
    	try {
    		EObject root = ModelManager.getRoot(model);
			List<EObject> gates = ModelManager.getReferences("gates", root);
			for (EObject gate : gates) {
				LogicalNode node = null;
				if (gate.eClass().getName().equals("NOT")) {
					node = new LogicalNOT();
				}
				if (gate.eClass().getName().equals("AND")) {
					node = new LogicalAND();
				}
				if (gate.eClass().getName().equals("OR")) {
					node = new LogicalOR();
				}
				if (node != null) {
					String name = ModelManager.getStringAttribute("name", gate);
					node.setName(name);
					List<EObject> inputPins = ModelManager.getReferences("input", gate);
					for (EObject inputPinEObject : inputPins) {
						String pin = ModelManager.getStringAttribute("name", inputPinEObject);
						LogicalInputPin inputPin = new LogicalInputPin();
						inputPin.setName(pin);
						EObject inputGate = ModelManager.getReference("src", inputPinEObject);
						if (inputGate == null) {
							inputPin.setInitial(true);
						}
						node.addInputPin(inputPin);
					}
					EObject outputPinEObject = ModelManager.getReference("output", gate);
					if (outputPinEObject != null) {
						String output = ModelManager.getStringAttribute("name", outputPinEObject);
						LogicalOutputPin outputPin = new LogicalOutputPin();
						outputPin.setName(output);
						EObject outputGate = ModelManager.getReference("tar", outputPinEObject);
						if (outputGate == null) {
							outputPin.setFinal(true);
						}
						node.setOutputPin(outputPin);
					}
				}
				logicalCircuit.addNode(node);
			}
			for (EObject gate : gates) {
				String name = ModelManager.getStringAttribute("name", gate);
				LogicalNode current = logicalCircuit.getNode(name);
				List<EObject> inputs = ModelManager.getReferences("input", gate);
				if (inputs != null) {
					for (int i = 0; i < inputs.size(); i++) {
						EObject ip = inputs.get(i);
						EObject op = ModelManager.getReference("src", ip);
						if (op != null) {
							String output = ModelManager.getStringAttribute("name", op);
							LogicalNode inputNode = logicalCircuit.getNodeWithOutput(output);
							if (inputNode != null) {
								current.addInput(inputNode);
								if (current.getInputPins() != null) {
									current.getInputPins().get(i).setSource(inputNode.getOutputPin());
								}
							}
						}
					}
				}
				EObject output = ModelManager.getReference("output", gate);
				if (output != null) {
					EObject ip = ModelManager.getReference("tar", output);
					if (ip != null) {
						String input = ModelManager.getStringAttribute("name", ip);
						LogicalNode outputNode = logicalCircuit.getNodeWithInput(input);
						if (outputNode != null) {
							if (current.getOutputPin() != null) {
								for (LogicalInputPin inputPin : outputNode.getInputPins()) {
									if (inputPin.getName().equals(input)) {
										current.getOutputPin().setTarget(inputPin);
									}
								}
							}
						}
					}
				}
				
				
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return logicalCircuit;
    }
    
    private static String toBoolExp(LogicalNode node) {
    	String booleanExpression = "";
    	if (node instanceof LogicalNOT) {
    		if (node.getInputPins() != null && node.getInputPins().size() > 0 && node.getInputPins().get(0) != null && node.getInputPins().get(0).isInitial()) {
    			booleanExpression += "&#172;" + node.getInputPins().get(0).getName();
    		}
    		if (node.getInputPins() != null && node.getInputPins().size() > 0 && node.getInputPins().get(0) != null && !node.getInputPins().get(0).isInitial()) {
    			if (node.getInputs().size() > 0) {
    				booleanExpression += "(&#172;" + toBoolExp(node.getInputs().get(0)) + ")";
    			}
    		}
    	}
    	if (node instanceof LogicalAND) {
    		booleanExpression += "(";
    		boolean complete = false;
    		if (node.getInputPins() != null && node.getInputPins().size() > 0 && node.getInputPins().get(0) != null && node.getInputPins().get(0).isInitial()) {
    			booleanExpression += node.getInputPins().get(0).getName() + "&#8743;";
    		}
    		else if (node.getInputs().size() > 0) {
				booleanExpression += toBoolExp(node.getInputs().get(0)) + "&#8743;";
    		}
    		if (node.getInputPins() != null && node.getInputPins().size() > 1 && node.getInputPins().get(1) != null && node.getInputPins().get(1).isInitial()) {
    			booleanExpression += node.getInputPins().get(1).getName();
    			complete = true;
    		}
    		else if (node.getInputs().size() > 1) {
    			booleanExpression += toBoolExp(node.getInputs().get(1));
    			complete = true;
    		}
    		if (complete == false && node.getInputs().size() > 0) {
    			booleanExpression += toBoolExp(node.getInputs().get(0));
    		}
    		booleanExpression += ")";
    	}
    	if (node instanceof LogicalOR) {
    		booleanExpression += "(";
    		boolean complete = false;
    		if (node.getInputPins() != null && node.getInputPins().size() > 0 && node.getInputPins().get(0) != null && node.getInputPins().get(0).isInitial()) {
    			booleanExpression += node.getInputPins().get(0).getName() + "&#8744;";
    		}
    		else if (node.getInputs().size() > 0) {
				booleanExpression += toBoolExp(node.getInputs().get(0)) + "&#8744;";
    		}
    		if (node.getInputPins() != null && node.getInputPins().size() > 1 && node.getInputPins().get(1) != null && node.getInputPins().get(1).isInitial()) {
    			booleanExpression += node.getInputPins().get(1).getName();
    			complete = true;
    		}
    		else if (node.getInputs().size() > 1) {
    			booleanExpression += toBoolExp(node.getInputs().get(1));
    			complete = true;
    		}
    		if (complete == false && node.getInputs().size() > 0) {
    			booleanExpression += toBoolExp(node.getInputs().get(0));
    		}
    		booleanExpression += ")";
    	}
    	return booleanExpression;
    }
    
    public static String toBoolExp(LogicalCircuit logicalCircuit) {
    	String booleanExpression = "";
    	if (logicalCircuit.getOutputPin() != null) {
    		booleanExpression = logicalCircuit.getOutputPin().getName() + " = ";
    	}
    	booleanExpression += toBoolExp(logicalCircuit.getOutputNode());
    	return booleanExpression;
    }
}
