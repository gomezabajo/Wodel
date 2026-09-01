package wodel.dsls.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import mutatorenvironment.Block;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObjectEmitter;

public class WodelScopeProviderUtils extends AbstractDeclarativeScopeProvider {

	protected static <T extends EObject> T findContainer(
	        EObject object,
	        Class<T> type) {

	    EObject current = object;

	    while (current != null) {

	        if (type.isInstance(current)) {
	            return type.cast(current);
	        }

	        current = current.eContainer();
	    }

	    return null;
	}

	protected static Mutator findDirectCommand(
	        EObject context,
	        EObject commandContainer) {

	    EObject current = context;

	    while (current != null
	            && current.eContainer() != commandContainer) {

	        current = current.eContainer();
	    }

	    if (current instanceof Mutator) {
	        return (Mutator) current;
	    }

	    return null;
	}
	
	protected IScope scopePreviousObjectEmitters(
	        EObject context) {

	    Block block =
	        findContainer(context, Block.class);

	    if (block != null) {

	        Mutator current =
	            findDirectCommand(
	                context,
	                block
	            );

	        List<ObjectEmitter> candidates =
	            new ArrayList<ObjectEmitter>();

	        for (Mutator command :
	                block.getCommands()) {

	            if (command == current) {
	                break;
	            }

	            if (command instanceof ObjectEmitter) {

	                ObjectEmitter emitter =
	                    (ObjectEmitter) command;

	                if (emitter.getName() != null
	                        && !emitter.getName().isBlank()) {

	                    candidates.add(emitter);
	                }
	            }
	        }

	        return Scopes.scopeFor(
	            candidates
	        );
	    }

	    /*
	     * Program without blocks.
	     */
	    MutatorEnvironment environment =
	        findContainer(
	            context,
	            MutatorEnvironment.class
	        );

	    if (environment != null) {

	        Mutator current =
	            findDirectCommand(
	                context,
	                environment
	            );

	        List<ObjectEmitter> candidates =
	            new ArrayList<ObjectEmitter>();

	        for (Mutator command :
	                environment.getCommands()) {

	            if (command == current) {
	                break;
	            }

	            if (command instanceof ObjectEmitter) {

	                ObjectEmitter emitter =
	                    (ObjectEmitter) command;

	                if (emitter.getName() != null
	                        && !emitter.getName().isBlank()) {

	                    candidates.add(emitter);
	                }
	            }
	        }

	        return Scopes.scopeFor(
	            candidates
	        );
	    }

	    return IScope.NULLSCOPE;
	}
}
