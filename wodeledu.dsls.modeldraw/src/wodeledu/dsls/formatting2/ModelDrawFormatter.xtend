/*
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.formatting2

import com.google.inject.Inject
import modeldraw.MutatorDraw
import modeldraw.Node
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import wodeledu.dsls.services.ModelDrawGrammarAccess

class ModelDrawFormatter extends AbstractFormatter2 {
	
	@Inject extension ModelDrawGrammarAccess

	def dispatch void format(MutatorDraw mutatorDraw, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc.
		for (instance : mutatorDraw.instances) { 
			for (node : instance.nodes) {
				node.format
			}
		} 
		for (instance : mutatorDraw.instances) { 
			for (relation : instance.relations) {
				relation.format
			}
		} 
		for (instance : mutatorDraw.instances) { 
			for (content : instance.contents) {
				content.format
			}
		} 
	}

	def dispatch void format(Node node, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (valuedFeature : node.feature) {
			valuedFeature.format
		}
		for (valuedFeature : node.targetFeature) {
			valuedFeature.format
		}
	}
	
	// TODO: implement for Edge, Content, NodeEnumerator
}
