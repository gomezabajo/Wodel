/*
 * generated by Xtext 2.30.0
 */
package wodel.dsls.formatting2

import asple.Declaration
import asple.Program
import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import wodel.dsls.services.ASPLEGrammarAccess

class ASPLEFormatter extends AbstractFormatter2 {
	
	@Inject extension ASPLEGrammarAccess

	def dispatch void format(Program program, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (declaration : program.declarations) {
			declaration.format
		}
		for (statement : program.statements) {
			statement.format
		}
	}

	def dispatch void format(Declaration declaration, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (identifier : declaration.identifiers) {
			identifier.format
		}
	}
	
	// TODO: implement for Assignment, Conditional, Loop, Transput, BinaryOperator
}
