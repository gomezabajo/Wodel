package es.main.generators

import org.eclipse.emf.ecore.resource.Resource
import generator.Bot
import generator.HTTPRequest
import generator.Token
import generator.Literal
import generator.EntityToken
import generator.UserInteraction
import generator.DefaultEntity
import generator.Parameter
import generator.Text
import generator.Image
import generator.ParameterReferenceToken
import generator.ParameterToken
import generator.TextInput
import generator.Language
import generator.LanguageIntent
import generator.LanguageText
import generator.LanguageEntity
import generator.EntityInput
import generator.RegexInput
import generator.SimpleInput
import generator.CompositeInput
import generator.TrainingPhrase
import generator.Entity
import java.util.List
import java.util.UUID
import java.util.Map
import java.util.HashMap
import java.io.File
import java.util.ArrayList
import generator.ButtonAction
import generator.GeneratorFactory
import generator.Action

class DialogflowGenerator extends BotGenerator {

	Map<UserInteraction, String> affectedContext = new HashMap();
	List<String> intentsNames = new ArrayList();

	new(String botPath, String fileName, String botName) {
		super(botPath + File.separator + fileName, botName)

	}

	override File doGenerate(Resource resource) {
		var bot = resource.allContents.filter(Bot).toList.get(0);
		var requests = resource.allContents.filter(HTTPRequest).toList;

//		generateFolder('entities')
//		generateFolder('intents')
		var f = generateFile('/package.json', "{\n \"version\": \"1.0.0\"\n}")
		saveFileIntoZip(f, 'package.json')

		if (!requests.isEmpty) {
			var request = requests.get(0) as HTTPRequest
			f = generateFile('/agent.json', agentJSON(bot, request))
		} else {
			f = generateFile('/agent.json', agentJSON(bot, null))
		}

		saveFileIntoZip(f, 'agent.json')

		var entities = resource.allContents.filter(Entity).toList;
		for (Entity entity : entities) {
			var name = entity.name.replaceAll("[^a-zA-Z0-9'_-]", "");
			f = generateFile('entities' + File.separator + name + '.json', entityFile(entity, name))
			saveFileIntoZip(f, 'entities', name + '.json')

			var lan = Language.ENGLISH;

			for (LanguageEntity input : entity.inputs) {
				lan = bot.languages.get(0);
				if (input.language != Language.EMPTY) {
					lan = input.language
				}
				f = generateFile('entities' + File.separator + name + '_entries_' + lan.languageAbbreviation +
					'.json', entriesFile(input))
				saveFileIntoZip(f, 'entities', name + '_entries_' + lan.languageAbbreviation + '.json')
			}
		}

		for (UserInteraction transition : bot.flows) {
			refactorPath(transition);
			createTransitionFiles(transition, new ArrayList(), bot)
		}
		close()
		return getZipFile()

	}

	def void refactorPath(UserInteraction interaction) {
		if (interaction.target !== null) {
			if (!interaction.target.backTo.isEmpty) {
				for (UserInteraction backTo : interaction.target.backTo) {
					if (backTo.src === null) {
						// Refactoring (backTo first element)
						var newInteraction = GeneratorFactory.eINSTANCE.createUserInteraction();
						newInteraction.intent = backTo.intent
						var newBotInteraction = GeneratorFactory.eINSTANCE.createBotInteraction();
						for (Action act : backTo.target.actions) {
							newBotInteraction.actions.add(act);
						}
						for (UserInteraction ui : backTo.target.outcoming) {
							newBotInteraction.backTo.add(ui)
						}
						for (UserInteraction ui : backTo.target.backTo) {
							newBotInteraction.backTo.add(ui)
						}
						newInteraction.target = newBotInteraction
						interaction.target.backTo.remove(backTo);
						interaction.target.outcoming.add(newInteraction);
					}
				}
			}
			for (UserInteraction child : interaction.target.outcoming) {
				refactorPath(child);
			}
		}
	}

	public static int limit = 90;
	public static int maxSize = 9;

	def createIntentPrefix(List<String> prev) {
		if (prev.isEmpty) {
			return "";
		}
		var ret = ""
		var i = 0;
		var size = prev.size();
		if (prev.size() >= (maxSize)) {
			i = prev.size() - maxSize
			size = maxSize;
		}

		for (; i < prev.size(); i++) {
			var value = prev.get(i);
			var maxLength = ((limit-(size+1)) / (size+1))
			if (value.length > (maxLength-3)) {
				value = value.substring(0, (maxLength-3));
			}
			ret += value + " - "
		}
		return ret;
	}

	def createIntentName(List<String> prev, String name) {
		var prefix = createIntentPrefix(prev)
		var newName = name.replaceAll("[^a-zA-Z0-9'_-]", "");
		if (newName.length > (limit - prefix.length - 3)) {
			newName = newName.substring(0, limit - prefix.length - 3)
		}
		var auxName = prefix + newName
		var i = 0
		while (intentsNames.contains(auxName)) {
			i++
			auxName = prefix + newName + i
		}
		intentsNames.add(auxName)
		return auxName

	}

	def void createTransitionFiles(UserInteraction transition, List<String> prev, Bot bot) {
		var name = createIntentName(prev, transition.intent.name)

		var f = generateFile('/intents/' + name + '.json', transition.intentFile(createIntentPrefix(prev), name, bot))
		saveFileIntoZip(f, 'intents', name + '.json')

		for (LanguageIntent input : transition.intent.inputs) {
			var lan = bot.languages.get(0)
			if (input.language != Language.EMPTY) {
				lan = input.language
			}
			f = generateFile('/intents/' + name + '_usersays_' + lan.languageAbbreviation + '.json', input.usersayFile)
			saveFileIntoZip(f, 'intents', name + '_usersays_' + lan.languageAbbreviation + '.json')
		}
		if (transition.target !== null) {
			prev.add(transition.intent.name);
			for (UserInteraction t : transition.target.outcoming) {
				createTransitionFiles(t, prev, bot)
			}
		}
	}

	def contextName(UserInteraction transition, String prefix) {
		if (affectedContext.containsKey(transition)) {
			return affectedContext.get(transition)
		}

		var name = prefix + transition.intent.name + " - " + "followup"
		name = name.replaceAll(" ", "");
		affectedContext.put(transition, name)
		return name
	}

	/*def contextName(String prefix) {
	 * 	var name = prefix + "followup"
	 * 	name = name.replaceAll(" ", "");
	 * 	return name
	 }*/
	def speechText(LanguageText textAction, UserInteraction transition) {
		var ret = ""
		for (TextInput input : textAction.inputs) {
			ret += input.speechText(transition)
			if (!isTheLast(textAction.inputs, input)) {
				ret += ","
			}
			ret += "\n"
		}
		return ret;
	}

	def speechText(TextInput input, UserInteraction transition) {
		var ret = ""
		ret += "\""
		for (Token token : input.tokens) {
			if (token instanceof Literal) {
				ret += token.text.replaceAll("\n", "\\\\n")
			} else if (token instanceof ParameterToken) {

				ret += answerParam(token, transition)
			}
		}
		ret += "\""
		return ret;
	}

	def answerParam(ParameterToken token, UserInteraction transition) {
		if (transition.intent.parameters.contains(token.parameter)) {
			var original ="";
			if (token.info !== null && token.info.equals("D: original")){
				original = ".original"
			}
			return "$" + token.parameter.name + original
		} else {
			var aux = transition;
			while (aux.src !== null) {
				aux = aux.src.incoming
				if (aux.intent.parameters.contains(token.parameter)) {
					return "#" + affectedContext.get(aux) + "." + token.parameter.name
				}
			}
		}
		return " ";
	}

	def paramType(Parameter param) {
		if (param.entity !== null) {
			return "@" + param.entity.name
		} else {
			switch (param.defaultEntity) {
				case (DefaultEntity.TEXT):
					return "@sys.any"
				case (DefaultEntity.DATE):
					return "@sys.date"
				case (DefaultEntity.TIME):
					return "@sys.time"
				case (DefaultEntity.NUMBER):
					return "@sys.number-integer"
				case (DefaultEntity.FLOAT):
					return "@sys.number"
			}
		}
	}

	def intentFile(UserInteraction transition, String prefix, String name, Bot bot) {
		var actions = new ArrayList();

		if (transition.target !== null) {
			actions.addAll(transition.target.actions);
		} else if (transition.backTo !== null) {
			actions.addAll(transition.backTo.previous);
			actions.addAll(transition.backTo.backTo.actions)
		}

		'''
			«var webhook =false»
			«var contextComa = ""»
			{
				"id": "«UUID.randomUUID().toString»",
				"name": "«name»",
				"auto": true,
				«IF transition.src!==null»
					"contexts": ["«affectedContext.get(transition.src.incoming)»"],
				«ELSE»
					"contexts": [],
				«ENDIF»
				"responses": [
					{
						"resetContexts": false,
						"affectedContexts": [
							«IF transition.target!== null»
								«IF !transition.target.outcoming.isEmpty»
									{
										"name": "«contextName(transition, prefix)»",
										"parameters": {},
										"lifespan": 2
									}«{contextComa= ","; ""}»
								«ENDIF»
								«FOR UserInteraction backTo: transition.target.backTo»
									«contextComa»
									{
										"name": "«affectedContext.get(backTo.src.incoming)»",
										"parameters": {},
										"lifespan": 2
									}«{contextComa= ","; ""}»
								«ENDFOR»
							«ELSEIF transition.backTo !== null»
								«contextComa»
								{
									"name": "«affectedContext.get(transition.backTo.backTo.incoming)»",
									"parameters": {},
									"lifespan": 2
								}«{contextComa= ","; ""}»
								«FOR UserInteraction backTo: transition.backTo.backTo.backTo»
									«contextComa»
									{
										"name": "«affectedContext.get(backTo.src.incoming)»",
										"parameters": {},
										"lifespan": 2
									}«{contextComa= ","; ""}»
								«ENDFOR»
							«ENDIF»
							
							
						],
						"parameters": [
							«FOR parameter : transition.intent.parameters»
								{
									"id": "«UUID.randomUUID().toString»",
									"required": «parameter.required»,
									"dataType": "«parameter.paramType()»",
									"name": "«parameter.name»",
									"value": "$«parameter.name»",
									"prompts": [
										«FOR prompt :parameter.prompts»
											«FOR text : prompt.prompts»
												{
													«IF prompt.language != Language.EMPTY»
														"lang": "«prompt.language.languageAbbreviation»",
													«ELSE»
														"lang": "«bot.languages.get(0).languageAbbreviation»",
													«ENDIF»
													"value": "«text»"
												}«IF !isTheLast(parameter.prompts, prompt) || !isTheLast(prompt.prompts, text)»,«ENDIF»
											«ENDFOR»
										«ENDFOR»
									],
									"isList":«parameter.isList» 
								}«IF !isTheLast(transition.intent.parameters, parameter)»,«ENDIF»
							«ENDFOR»
						],
						"messages": [
							«IF actions!==null»
								«var coma=""»
								«FOR action : actions»
									«IF action instanceof Text»
										«FOR texLanguage : action.inputs»
											«coma»
											{
												"type": 0,
												«IF texLanguage.language != Language.EMPTY»
													"lang": "«texLanguage.language.languageAbbreviation»",
												«ELSE»
													"lang": "«bot.languages.get(0).languageAbbreviation»",
												«ENDIF»
												"condition": "",
												"speech": [
													«texLanguage.speechText(transition)»
												]
											}
											«{coma=","; ""}»
										«ENDFOR»
									«ELSEIF action instanceof Image»
										«IF action.caption!== null && !action.caption.isEmpty»
										«coma»
										{
											"type": 0,
											"lang": "«bot.languages.get(0).languageAbbreviation»",
											"condition": "",
											"speech": [
												"«action.caption»"
											]
										}
										«{coma=","; ""}»
										«ENDIF»
										«coma»
										{
											"type": 3,
											"condition": "",
											"imageUrl": "«(action as Image).URL»"
										}
										«{coma=","; ""}»
									«ELSEIF action instanceof HTTPRequest»
										«{webhook=true; ""}»
									«ELSEIF action instanceof ButtonAction»
										«FOR texLanguage : action.inputs»
											«coma»
											{
												"type": 1,
												«IF texLanguage.language != Language.EMPTY»
													"lang": "«texLanguage.language.languageAbbreviation»",
												«ELSE»
													"lang": "«bot.languages.get(0).languageAbbreviation»",
												«ENDIF»
												"condition": "",
												"title": «texLanguage.speechText(transition)»,
												"buttons": [ 
												«FOR button: texLanguage.buttons»
													{
														"text": "«button.value»"«IF button.action!== null»,
																"postback": "«button.action»"
														«ENDIF»
													}«IF !isTheLast(texLanguage.buttons, button)», «ENDIF»
												«ENDFOR» 
												]
											}
											«{coma=","; ""}»
										«ENDFOR»
									«ENDIF»
								«ENDFOR »
				«ENDIF»
				],
				"defaultResponsePlatforms": {},
				"speech": []
				}
				],
				"priority": 500000,
				"webhookUsed": «webhook»,
				"webhookForSlotFilling": false,
				"fallbackIntent": «transition.intent.fallbackIntent»,
				"events": [],
				"conditionalResponses": [],
				"condition": "",
				"conditionalFollowupEvents": []
			}
		'''
	}

	def agentJSON(Bot bot, HTTPRequest request) '''
		{
		  "language": "«bot.languages.get(0).languageAbbreviation»",
		  "defaultTimezone": "Europe/Madrid",
		  «IF request !== null »
		  	"webhook": {
		  	  "url": "«returnText(request.URL)»",
		  	  «IF request.basicAuth !== null»
		  	  	"username": "«returnText(request.basicAuth.key)»",
		  	  «ELSE»
		  	  	"username": "",
		  	  «ENDIF»
		  	  "headers": {
		  	   «FOR  header : request.headers»
		  	   	"«header.key»": "«(header.value as Literal).text»"«IF !request.headers.isTheLast(header)»,«ENDIF»
		  	   «ENDFOR»
		  	  },
		  	  "available": true,
		  	  "useForDomains": false,
		  	  "cloudFunctionsEnabled": false,
		  	  "cloudFunctionsInitialized": false
		  	},
		  «ENDIF»
		  "isPrivate": true,
		  "customClassifierMode": "use.after",
		  "mlMinConfidence": 0.3,
		  "supportedLanguages": [
		  «IF bot.languages.size > 1»
		  	«FOR  i : 1..bot.languages.size-1»
		  		"«bot.languages.get(i).languageAbbreviation»"«IF !bot.languages.isTheLast(bot.languages.get(i))»,«ENDIF»
		  	«ENDFOR»
		  «ENDIF»
		  ],
		  "onePlatformApiVersion": "v2",
		  "analyzeQueryTextSentiment": false,
		  "enabledKnowledgeBaseNames": [],
		  "knowledgeServiceConfidenceAdjustment": -0.4,
		  "dialogBuilderMode": false,
		  "baseActionPackagesUrl": ""
		}
		
	'''

	def usersayFile(LanguageIntent intent) '''
		[
		«FOR phrase : intent.inputs»
			«IF phrase instanceof TrainingPhrase»
				{
				  "id": "«UUID.randomUUID().toString»",
				  "data": [
				«FOR token: phrase.tokens»
					«IF token instanceof Literal»
						{
						  "text": "«token.text»",
						  "userDefined": false
						},
					«ELSEIF token instanceof ParameterReferenceToken»
						{
						  "text": "«(token as ParameterReferenceToken).textReference»",
						  "alias": "«(token as ParameterReferenceToken).parameter.name»",
						  "meta": "«(token as ParameterReferenceToken).parameter.paramType»",
						  "userDefined": true
						},
					«ENDIF»
					{
						"text": " ",
						"userDefined": false
					}«IF !phrase.tokens.isTheLast(token)»,«ENDIF»
				«ENDFOR»
				],
				"isTemplate": false,
				"count": 0,
				"updated": 0
				}«IF !isTheLast(intent.inputs, phrase)»,«ENDIF»
			«ENDIF»
		 «ENDFOR»
		 ]
	'''

	def returnText(String value) {
		if (value.isEmpty) {
			return '';
		}
		return value
	}

	def languageAbbreviation(Language lan) {
		switch (lan) {
			case Language.ENGLISH:
				return 'en'
			case Language.SPANISH:
				return 'es'
			case Language.DANISH:
				return 'da'
			case Language.GERMAN:
				return 'de'
			case Language.FRENCH:
				return 'fr'
			case Language.HINDI:
				return 'hi'
			case Language.INDONESIAN:
				return 'id'
			case Language.ITALIAN:
				return 'it'
			case Language.JAPANESE:
				return 'ja'
			case Language.KOREAN:
				return 'ko'
			case Language.DUTCH:
				return 'nl'
			case Language.NORWEGIAN:
				return 'no'
			case Language.POLISH:
				return 'pl'
			case Language.PORTUGUESE:
				return 'pt'
			case Language.RUSIAN:
				return 'ru'
			case Language.SWEDISH:
				return 'sv'
			case Language.THAI:
				return 'th'
			case Language.TURKISH:
				return 'tr'
			case Language.UKRANIAN:
				return 'uk'
			case Language.CHINESE:
				return 'zh'
			default:
				return 'en'
		}
	}

	def entityFile(Entity entity, String name) '''
		
		{
			"id": "«UUID.randomUUID().toString»",
			"name": "«name»",
			"isOverridable": true,	  
			«IF entityType(entity) === BotGenerator.REGEX»
				"isEnum": false,
				"isRegexp":true,
				"automatedExpansion": true,
				"allowFuzzyExtraction": false
			«ELSEIF entityType(entity) === BotGenerator.SIMPLE»
				"isEnum": false,
				"isRegexp": false,
				"automatedExpansion": true,
				"allowFuzzyExtraction": true
			«ELSE»
				"isEnum": true,
				"isRegexp": false,
				"automatedExpansion": false,
				"allowFuzzyExtraction": false
			«ENDIF»
		}
	'''

	def entityIsSimple(Entity entity) {
	}

	def entriesFile(LanguageEntity entity) '''
		[
			«FOR entry : entity.inputs»
				{
				   «entry(entry)»
				} «IF !entity.inputs.isTheLast(entry)»,«ENDIF»
			«ENDFOR»
		]
	'''

	def entry(EntityInput entry) {
		if (entry instanceof SimpleInput) {
			return entry(entry)
		} else if (entry instanceof CompositeInput) {
			return entry(entry)
		} else if (entry instanceof RegexInput) {
			return entry(entry)
		}
	}

	def entry(SimpleInput entry) '''
		"value": "«entry.name»",
		"synonyms": [
			"«entry.name»"«IF !entry.values.empty»,«ENDIF»
			«FOR synonym : entry.values»
				"«synonym»"«IF !entry.values.isTheLast(synonym)»,«ENDIF»
			«ENDFOR»
		]
	'''

	def entry(CompositeInput entry) '''
		"value": "«entry.compositeEntry»",
		"synonyms": [
			"«entry.compositeEntry»"
		]
	'''

	def entry(RegexInput entry) '''
		"value": "«entry.expresion»",
		"synonyms": [
			"«entry.expresion»"
		]
	'''

	def static isTheLast(List<?> list, Object object) {
		if (list.indexOf(object) == list.size - 1) {
			return true;
		}
		return false;

	}

	def getCompositeEntry(CompositeInput entry) {
		var ret = "";
		for (Token token : entry.expresion) {
			if (token instanceof Literal) {
				ret += token.text + " "
			} else if (token instanceof EntityToken) {
				ret += "@" + token.entity.name + ":" + token.entity.name + " "
			}
		}
		return ret;
	}
}
