package es.main.generators

import generator.Action
import generator.Bot
import generator.DefaultEntity
import generator.Entity
import generator.Image
import generator.Intent
import generator.Literal
import generator.Parameter
import generator.ParameterReferenceToken
import generator.ParameterToken
import generator.Text
import generator.TextInput
import generator.TrainingPhrase
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import generator.HTTPRequest
import generator.DataType
import generator.HTTPResponse
import generator.HTTPRequestToke
import generator.HTTPReturnType
import generator.UserInteraction
import java.util.ArrayList
import generator.BotInteraction
import generator.Interaction
import generator.Language
import generator.LanguageText
import generator.SimpleInput
import generator.RegexInput
import generator.LanguageEntity
import generator.EntityInput
import java.io.File
import generator.ButtonAction
import generator.Empty

class RasaGenerator extends BotGenerator {

	new(String path, String fileName, String botName) {
		super(path + File.separator + fileName, botName)
	}
	boolean hasForm= false;
	override doGenerate(Resource resource) {

		var bot = resource.allContents.filter(Bot).toList.get(0);
		var intents = resource.allContents.filter(Intent).toList;
		var entities = resource.allContents.filter(Entity).toList;
		var parameters = resource.allContents.filter(Parameter).toList;
		var actions = resource.allContents.filter(Action).toList;
		var leafs = new ArrayList<Interaction>();
		for (UserInteraction flow : bot.flows) {
			leafsU(flow, leafs)
		}
		var fallbackIntent = null as Intent
		for (Intent i : intents) {
			if (i.isFallbackIntent) {
				fallbackIntent = i;
			}
		}
		var fallbackAction = null as Action
		var i = 0;
		while (fallbackAction === null && i < bot.flows.length) {
			fallbackAction = getFallbackAction(fallbackIntent, bot.flows.get(i))
			i++
		}

		var f = generateFile('requirements.txt', "tensorflow-addons\ntensorflow=>2.1.0\nrasa==1.10.0\nduckling==1.8.0")
		saveFileIntoZip(f, "requirements.txt");

		for (Language lan : bot.languages) {

			var subPath = lan.languageAbbreviation
			var dataPath = subPath + File.separator + 'data'
//			generateFolder(subPath);
//			generateFolder(dataPath)
			f = generateFile(subPath + File.separator + 'actions.py', actions(intents, entities, actions, lan, bot))
			saveFileIntoZip(f, subPath, 'actions.py')

			f = generateFile(subPath + File.separator + 'config.yml',
				config(lan, fallbackAction, fallbackIntent !== null, hasForm))
			saveFileIntoZip(f, subPath, 'config.yml')

			f = generateFile(subPath + File.separator + 'credentials.yml', credentials)
			saveFileIntoZip(f, subPath, 'credentials.yml')

			f = generateFile(subPath + File.separator + 'domain.yml', domain(intents, parameters, actions, lan, bot))
			saveFileIntoZip(f, subPath, 'domain.yml')

			f = generateFile(subPath + File.separator + 'endpoints.yml', endpoint)
			saveFileIntoZip(f, subPath, 'endpoints.yml')

			f = generateFile(dataPath + File.separator + 'nlu.md', nlu(intents, entities, lan, bot))
			saveFileIntoZip(f, dataPath, 'nlu.md')

			f = generateFile(dataPath + File.separator + 'stories.md', stories(leafs))
			saveFileIntoZip(f, dataPath, 'stories.md')
		}
		close()
		zipFile
	}

	def Action getFallbackAction(Intent fallbackIntent, UserInteraction flow) {
		if (flow.intent.equals(fallbackIntent)) {
			if (flow.target !== null) {
				return flow.target.actions.get(0);
			} else if (flow.backTo !== null) {
				return flow.backTo.backTo.actions.get(0);
			}

		}
		var action = null as Action
		if (flow.target !== null) {
			if (!flow.target.outcoming.isEmpty) {
				for (UserInteraction ui : flow.target.outcoming) {
					action = getFallbackAction(fallbackIntent, ui)
					if (action !== null) {
						return action;
					}
				}
			}
		}

		return null;
	}

	def String actionName(Action action) {
		if (action instanceof Text || action instanceof Image || action instanceof ButtonAction) {
			if (action.name.getRasaValue.startsWith("utter")) {
				return action.name.getRasaValue
			}
			return "utter_" + action.name.getRasaValue
		}
		if (action.name.getRasaValue.startsWith("action")) {
			return action.name.getRasaValue
		}
		return "action_" + action.name.getRasaValue
	}

	def void leafsU(UserInteraction flow, List<Interaction> leafs) {
		if (flow.target === null) {
			leafs.add(flow)
		} else {
			leafsB(flow.target, leafs)
		}
	}

	def void leafsB(BotInteraction flow, List<Interaction> leafs) {
		if (flow.outcoming.isEmpty) {
			leafs.add(flow)
		} else {
			for (UserInteraction user : flow.outcoming) {
				leafsU(user, leafs)
			}
		}

	}

	def String stories(List<Interaction> leafs) {
		var ret = ""
		for (var i = 0; i < leafs.size; i++) {
			var clean = new ArrayList<Intent>()
			var leaf = leafs.get(i)
			ret += path(leaf, i, clean) + "\n"
		}
		return ret;
	}

	def path(Interaction flow, int i, List<Intent> clean) '''
		## path_«i»
		«IF flow instanceof UserInteraction»
			«flow(flow as UserInteraction, clean)»
		«ELSEIF flow instanceof BotInteraction»
			«flow(flow as BotInteraction, clean)»
		«ENDIF»
	'''

	def String flow(UserInteraction user, List<Intent> clean) '''
		«IF user.src!==null»
			«flow(user.src, clean)»
		«ENDIF»
		«IF !user.intent.isFallbackIntent»
		* «user.intent.name.rasaValue»	
		«IF !user.intent.parameters.isEmpty»
			«"\t"»- «{clean.add(user.intent);user.intent.name.getRasaValue}»_form
			«"\t"»- form{"name": "«user.intent.name.getRasaValue»_form"}
			«"\t"»- form{"name": null}
		«ENDIF»
		«ENDIF»
	'''

	def String flow(BotInteraction bot, List<Intent> clean) '''
		«IF bot.incoming !== null»
			«flow(bot.incoming, clean)»
		«ENDIF»
		«IF bot.incoming===null || (bot.incoming!== null && !bot.incoming.intent.isFallbackIntent) »
		«FOR action : bot.actions»
			«"\t"»- «action.actionName»
		«ENDFOR»
		«ENDIF»
	'''

	def actions(List<Intent> intents, List<Entity> entities, List<Action> actions, Language lan, Bot bot) '''
		# This files contains your custom actions which can be used to run
		# custom Python code.
		#
		# See this guide on how to implement these action:
		# https://rasa.com/docs/rasa/core/actions/#custom-actions/
		
		
		# This is a simple example for a custom action which utters "Hello World!"
		
		# from typing import Any, Text, Dict, List
		#
		# from rasa_sdk import Action, Tracker
		# from rasa_sdk.executor import CollectingDispatcher
		#
		#
		# class ActionHelloWorld(Action):
		#
		#     def name(self) -> Text:
		#         return "action_hello_world"
		#
		#     def run(self, dispatcher: CollectingDispatcher,
		#             tracker: Tracker,
		#             domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
		#
		#         dispatcher.utter_message("Hello World!")
		#
		#         return []
		from typing import Dict, Text, Any, List, Union, Optional
		
		from rasa_sdk import ActionExecutionRejection
		from rasa_sdk import Action
		from rasa_sdk import Tracker
		from rasa_sdk.events import SlotSet
		from rasa_sdk.executor import CollectingDispatcher
		from rasa_sdk.forms import FormAction, REQUESTED_SLOT
		import requests
		
				
		«FOR entity : entities»
			«IF entityType(entity) === BotGenerator.SIMPLE»
				«FOR simpleLanguage : entity.inputs»
					«IF simpleLanguage.language.compare(lan, bot)»
						«entity.name.rasaValue»_db={«FOR input: simpleLanguage.inputs»"«(input as SimpleInput).name.toLowerCase»":["«(input as SimpleInput).name.toLowerCase»"«FOR value: (input as SimpleInput).values»,"«value.toLowerCase»"«ENDFOR»]«IF !DialogflowGenerator.isTheLast(entity.inputs, input)»,«ENDIF»«ENDFOR»}
						 
						def «entity.name.rasaValue»_validate(value:Text):
							for input in «entity.name.rasaValue»_db:
								if value.lower() in «entity.name.rasaValue»_db[input]:
									return input
							return None
					«ENDIF»		
				«ENDFOR»
				 
			«ELSEIF entityType(entity) === BotGenerator.COMPOSITE»
				def «entity.name.rasaValue»_validate(value:Text):
					return None
			«ENDIF»
		«ENDFOR»
		«FOR intent : intents»
		«IF !intent.parameters.empty»
		«{hasForm=true;""}»
		class «intent.name.getRasaValue»Form (FormAction):
			def name(self):
				# type: () -> Text
					"""Unique identifier of the form"""
					return "«intent.name.getRasaValue»_form"
						
			@staticmethod
			def required_slots(tracker: Tracker) -> List[Text]:
				"""A list of required slots that the form has to fill"""
				«var coma =""»
				«/*return [«FOR param :intent.parameters»«IF param.required»«coma»"«{coma=",";param.paramName}»"«ENDIF»«ENDFOR»]*/»
				return [«FOR param :intent.parameters»«coma»"«{coma=",";param.paramName}»"«ENDFOR»]
			«FOR param :intent.parameters»
				def validate_«param.paramName»(self, value: Text,dispatcher: CollectingDispatcher,tracker: Tracker,domain: Dict[Text, Any]) -> Dict[Text, Any]:
					«IF param.entity !== null»
						parseValue = «param.entity.name.rasaValue»_validate(value)
					«ELSEIF param.defaultEntity === DefaultEntity.TEXT»
						parseValue = value
					«ELSEIF param.defaultEntity === DefaultEntity.FLOAT»
						try:
							parseValue = float (value)
						except ValueError:
							parseValue = None
					«ELSEIF param.defaultEntity === DefaultEntity.NUMBER»
						try:
							parseValue = int (value)
						except ValueError:
							parseValue = None
					«ENDIF»
					if parseValue is None:
						dispatcher.utter_template('utter_wrong_«param.name.getRasaValue»', tracker)
						return {'«param.paramName»': None}
					return {'«param.paramName»': parseValue}
			«ENDFOR»
			
			def slot_mappings(self):
			
				return {«FOR param :intent.parameters»
				"«param.paramName»": [self.from_entity(entity="«param.paramName»"),self.from_text()],«ENDFOR»}
			def submit(
				self,
				dispatcher: CollectingDispatcher,
				tracker: Tracker,
				domain: Dict[Text, Any],
				) -> List[Dict]:
				"""Define what the form has to do after all required slots are filled"""
				return []
			
		class «intent.name.getRasaValue»Clean (Action):
			def name(self) -> Text:
				return "«intent.name.getRasaValue»_clean"
			def run(self, dispatcher: CollectingDispatcher,
				tracker: Tracker,
				domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
				return [«FOR param :intent.parameters»SlotSet("«param.paramName»", None) «IF !DialogflowGenerator.isTheLast(intent.parameters, param)»,«ENDIF»«ENDFOR»]            
		«ENDIF»
		«ENDFOR»
		«FOR action : actions»
		«IF action instanceof HTTPRequest»
		class «action.name.getRasaValue» (Action):
			response = None
			def name(self) -> Text:
				return "«action.actionName»"
				
			def run(self, dispatcher: CollectingDispatcher,
				tracker: Tracker,
				domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
				url = '«action.URL»'
				«var args =""»
				«IF action.basicAuth !== null»
					auth={'«action.basicAuth.key»', '«action.basicAuth.value.toString»'}
					«{args+=", auth=auth"; ""}»
				«ENDIF»
				«IF !action.headers.isEmpty»
					headers={
						«FOR header: action.headers»
							'«header.key»':'«header.value»'«IF !DialogflowGenerator.isTheLast(action.headers, header)», «ENDIF»
						«ENDFOR»}
						«{args+=", headers=headers"; ""}»
				«ENDIF»
				«IF !action.data.isEmpty»
					data = {
						«FOR d : action.data»
							«IF d.value instanceof ParameterToken»
								'«d.key»': tracker.get_slot("«(d.value as ParameterToken).parameter.name.getRasaValue»")«IF !DialogflowGenerator.isTheLast(action.data, d)», «ENDIF»
							«ELSE»
								'«d.key»':'«d.value»'«IF !DialogflowGenerator.isTheLast(action.data, d)», «ENDIF»
							«ENDIF»
						«ENDFOR»}
						«IF action.dataType === DataType.FORM»«{args+=",data=data";""}»«ELSE»«{args+=",json=data";""}»«ENDIF»
				«ENDIF»
				«action.name.rasaValue».response = requests.«action.method.getName.toLowerCase»(url «args») 
			«ELSEIF action instanceof HTTPResponse»
			class «action.name.rasaValue» (Action):
				def name(self) -> Text:
					return "«action.actionName»"
				
				def run(self, dispatcher: CollectingDispatcher,
						tracker: Tracker,
						domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
					response = «(action as HTTPResponse).HTTPRequest.name.rasaValue».response			
					text = «getHttpResponseText(action as HTTPResponse, lan, bot)»
					dispatcher.utter_message(text)
					return []         
					
		«ELSEIF action instanceof Empty»
			class «action.name.rasaValue» (Action):
				def name(self) -> Text:
					return "«action.actionName»"
				
				def run(self, dispatcher: CollectingDispatcher,
						tracker: Tracker,
						domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
					return []  
		«ENDIF»
			
		«ENDFOR»
			
	'''

	def getHttpResponseText(HTTPResponse action, Language lan, Bot bot) {
		var ret = ""
		for (LanguageText textLanguage : action.inputs) {
			if (textLanguage.language.compare(lan, bot)) {
				for (token : textLanguage.inputs.get(0).tokens) {
					if (token instanceof Literal) {
						ret += "'" + token.text + "'"
					} else if (token instanceof ParameterToken) {
						ret += "tracker.get_slot(\"" + token.parameter.paramName + "\")"
					} else if (token instanceof HTTPRequestToke) {
						if (token.type == HTTPReturnType.TEXT)
							ret += "response.text"
						else if (token.type == HTTPReturnType.STATUS_CODE)
							ret += "response.status_code"
						else if (token.type == HTTPReturnType.DATA) {
							if (!token.dataKey.isEmpty) {
								ret += "response.json()['" + token.dataKey + "']"
							} else {
								ret += "response.json()"
							}
						}
					}
					if (!DialogflowGenerator.isTheLast(textLanguage.inputs.get(0).tokens, token)) {
						ret += "+"
					}

				}
			}
		}

		return ret
	}

	def domain(List<Intent> intents, List<Parameter> parameters, List<Action> actions, Language lan, Bot bot) '''
		session_config:
		  session_expiration_time: 60
		«IF !intents.isEmpty»
			intents:
			  «FOR intent : intents»
			  	- «intent.name.getRasaValue»
			  «ENDFOR»
		«ENDIF»
		«IF !parameters.isEmpty»
			entities:
			  «FOR parameter : parameters»
			  	- «getParamName(parameter)»
			  «ENDFOR»
			
			slots:
			  «FOR parameter : parameters»
			  	«parameter.paramName»:
			  	  «IF parameter.isIsList»
			  	  	type: list
			  	  «ELSEIF parameter.entity!== null && parameter.entity.isSimple »
			  	  	type: categorical
			  	  	values:
			  	  	«FOR v: parameter.entity.inputs.get(0).inputs»
			  	  		- «(v as SimpleInput).name»
			  	  	«ENDFOR» 
			  	  «ELSEIF parameter.defaultEntity.equals(DefaultEntity.TEXT)»
			  	  	type: text
			  	  «ELSEIF parameter.defaultEntity.equals(DefaultEntity.FLOAT) || parameter.defaultEntity.equals(DefaultEntity.NUMBER)»
			  	  	type: float
			  	  «ELSE»
			  	  	type: unfeaturized
			  	  «ENDIF»
			  «ENDFOR»
		«ENDIF»
		
		«IF !parameters.isEmpty || !actions.isEmpty»
			responses:
			  «FOR parameter : parameters»
			  	«IF parameter.isRequired && !parameter.prompts.isEmpty»
			  		utter_ask_«parameter.paramName»:
			  		  «FOR prompt:parameter.prompts»
			  		  	«IF prompt.language.compare(lan, bot)»
			  		  		«FOR text : prompt.prompts»	
			  		  			- text: "«text»"
			  		  		«ENDFOR»
			  		  	«ENDIF»
			  		  «ENDFOR»
			  		utter_wrong_«parameter.paramName»:
			  		  - text: "I can not understand the «parameter.name», please try again"
			  	«ENDIF»
			  «ENDFOR»
			  «FOR action : actions»
			  	«IF action instanceof Text»
			  		«action.actionName»:
			  		  «FOR textLanguageEntity: action.inputs»
			  		  	«IF textLanguageEntity.language.compare(lan, bot)»
			  		  		«FOR input : textLanguageEntity.inputs»	
			  		  			- text: "«input.textActionInput»"
			  		  		«ENDFOR»
			  		  	«ENDIF»
			  		  «ENDFOR»
			  	«ELSEIF action instanceof Image»
			  		«action.actionName»:
			  		  - text: «IF (action as Image).caption !== null»"«(action as Image).caption»"«ELSE»""«ENDIF»
			  		    image: "«(action as Image).URL»"
			  	«ELSEIF action instanceof ButtonAction»
			  		«FOR textLanguageEntity: action.inputs»
			  			«action.actionName»:
			  			  «IF textLanguageEntity.language.compare(lan, bot)»
			  			  	«FOR input : textLanguageEntity.inputs»	
			  			  		- text: "«input.textActionInput»"
			  			  	«ENDFOR»
			  			  	buttons:
			  			  	  «FOR button: textLanguageEntity.buttons»
			  			  	  	- title: "«button.value»"
			  			  	  	  «IF button.action !== null»
			  			  	  	  	payload: "«button.action»"
			  			  	  	  «ENDIF»
			  			  	  «ENDFOR»
			  			  «ENDIF»
			  		«ENDFOR»
			  	«ENDIF»
			  «ENDFOR»
			«ENDIF»
		
		«IF !parameters.isEmpty || !actions.isEmpty»
			actions:
			  «FOR action : actions»
			  	- «action.actionName»
			  «ENDFOR»
		«ENDIF»
		«IF !parameters.isEmpty»
			forms:
			  «FOR intent : intents»
			  	«IF !intent.parameters.empty»
			  		- «intent.name.getRasaValue»_form
			  	«ENDIF»
			  «ENDFOR»
		«ENDIF»
	'''

	def compare(Language language, Language language2, Bot bot) {
		var aux = language
		if (aux.equals(Language.EMPTY)) {
			aux = bot.languages.get(0);
		}
		return aux.equals(language2)
	}

	def textActionInput(TextInput input) {
		var ret = ""
		for (token : input.tokens) {
			if (token instanceof Literal) {
				ret += token.text
			} else if (token instanceof ParameterToken) {
				ret += "{" + token.parameter.paramName + "}"
			}
		}
		return ret;
	}

	def paramType(Parameter parameter) {
		if (parameter.isList) {
			return "list"
		}
		if (parameter.entity !== null) {
			return "text"
		} else {
			switch (parameter.defaultEntity) {
				case (DefaultEntity.TEXT):
					return "text"
				case (DefaultEntity.DATE):
					return "text"
				case (DefaultEntity.TIME):
					return "text"
				case (DefaultEntity.NUMBER):
					return "float"
				case (DefaultEntity.FLOAT):
					return "float"
			}
		}
	}

	def nlu(List<Intent> intents, List<Entity> entities, Language lan, Bot bot) '''
		«FOR intent : intents»
			«FOR intentLanguageEntity: intent.inputs»
				«IF intentLanguageEntity.language.compare(lan, bot)»
					«IF intentType(intent) === BotGenerator.TRAINING»
						## intent:«intent.name.getRasaValue»
						«FOR input : intentLanguageEntity.inputs»
							- «(input as TrainingPhrase).generate(lan, bot)»
						«ENDFOR»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		«FOR entity : entities»
			
			«FOR languageInput: entity.inputs»
				«IF languageInput.language.compare(lan, bot)»
					«IF entityType(entity) === BotGenerator.SIMPLE»
						«FOR input: languageInput.inputs»
							## synonym:«(input as SimpleInput).name»
							«FOR synonym : (input as SimpleInput).values»
								- «synonym»
							«ENDFOR»
						«ENDFOR»
					«ELSEIF entityType(entity) === BotGenerator.REGEX»
						##regex:«entity.name»
						«FOR input: languageInput.inputs»
							- «(input as RegexInput).expresion»
						«ENDFOR»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
			
		«ENDFOR»
		
	'''

	def generate(TrainingPhrase phrase, Language lan, Bot bot) {
		var ret = ""
		for (token : phrase.tokens) {
			if (token instanceof Literal) {
				ret += token.text + " "
			} else if (token instanceof ParameterReferenceToken) {
				if (entityType(token.parameter.entity) == BotGenerator.SIMPLE) {
					if (token.parameter.entity !== null) {
						ret +=
							'[' + token.textReference + ']' + '{"entity": "' + token.parameter.paramName + '",' +
								'"value":' + '"' + getEntry(token.textReference, token.parameter.entity, lan, bot) +
								'" }'
					} else {
						ret += '[' + token.textReference + ']' + '{"entity": "' + token.parameter.paramName + '" }'
					}

				} else {
					ret += '[' + token.textReference + ']' + '{"entity": "' + token.parameter.paramName + '" }' + " "
				}
			}
		}
		return ret;
	}

	def getEntry(String string, Entity entity, Language lan, Bot bot) {
		for (LanguageEntity languageInput : entity.inputs) {
			if (languageInput.language.compare(lan, bot)) {
				for (EntityInput input : languageInput.inputs) {
					if (input instanceof SimpleInput) {
						if ((input as SimpleInput).name.equalsIgnoreCase(string)) {
							return (input as SimpleInput).name
						}
						for (String synonym : (input as SimpleInput).values) {
							if (synonym.equalsIgnoreCase(string)) {
								return (input as SimpleInput).name
							}
						}
					}
				}
			}
		}
		return ""
	}

	def getRasaValue(String name) {
		return name.replaceAll(" ", "_").replaceAll("-", "_")
	}

	def getParamName(Parameter param) {
		return (param.eContainer as Intent).name.rasaValue + "_" + param.name.getRasaValue
	}

	def endpoint() '''
		# This file contains the different endpoints your bot can use.
		
		# Server where the models are pulled from.
		# https://rasa.com/docs/rasa/user-guide/running-the-server/#fetching-models-from-a-server/
		
		#models:
		#  url: http://my-server.com/models/default_core@latest
		#  wait_time_between_pulls:  10   # [optional](default: 100)
		
		# Server which runs your custom actions.
		# https://rasa.com/docs/rasa/core/actions/#custom-actions/
		
		#action_endpoint:
		#  url: "http://localhost:5055/webhook"
		
		# Tracker store which is used to store the conversations.
		# By default the conversations are stored in memory.
		# https://rasa.com/docs/rasa/api/tracker-stores/
		
		#tracker_store:
		#    type: redis
		#    url: <host of the redis instance, e.g. localhost>
		#    port: <port of your redis instance, usually 6379>
		#    db: <number of your database within redis, e.g. 0>
		#    password: <password used for authentication>
		#    use_ssl: <whether or not the communication is encrypted, default false>
		
		#tracker_store:
		#    type: mongod
		#    url: <url to your mongo instance, e.g. mongodb://localhost:27017>
		#    db: <name of the db within your mongo instance, e.g. rasa>
		#    username: <username used for authentication>
		#    password: <password used for authentication>
		
		# Event broker which all conversation events should be streamed to.
		# https://rasa.com/docs/rasa/api/event-brokers/
		
		#event_broker:
		#  url: localhost
		#  username: username
		#  password: password
		#  queue: queue
		action_endpoint:
		    url: http://localhost:5055/webhook
	'''

	def config(Language lan, Action fallbackAction, boolean hasFallback, boolean hasForm) '''
		# Configuration for Rasa NLU.
		# https://rasa.com/docs/rasa/nlu/components/
		language: «lan.languageAbbreviation»
		pipeline:
		  - name: WhitespaceTokenizer
		  - name: RegexFeaturizer
		  - name: LexicalSyntacticFeaturizer
		  - name: CountVectorsFeaturizer
		  - name: CountVectorsFeaturizer
		    analyzer: "char_wb"
		    min_ngram: 1
		    max_ngram: 4
		  - name: DIETClassifier
		    epochs: 100
		  - name: EntitySynonymMapper
		  - name: ResponseSelector
		    epochs: 100
		
		# Configuration for Rasa Core.
		# https://rasa.com/docs/rasa/core/policies/
		policies:
		  - name: MemoizationPolicy
		  - name: TEDPolicy
		    max_history: 5
		    epochs: 100
		  - name: MappingPolicy
		  «IF hasForm»
		  - name: FormPolicy
		  «ENDIF»
		  «IF hasFallback»
		  	- name: "FallbackPolicy"
		  	  nlu_threshold: 0.5
		  	  core_threshold: 0.35
		  	  «IF fallbackAction === null»
		  	  	fallback_action_name: 'action_default_fallback'
		  	  «ELSE»
		  	  	fallback_action_name: '«fallbackAction.actionName»'
		  	  «ENDIF»
		  «ENDIF»
	'''

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
			// FALTAN LENGUAJES!!!!!!!!!!!!!!!!!!!!!!!!!
			default:
				return 'en'
		}
	}

	def credentials() '''
		# This file contains the credentials for the voice & chat platforms
		# which your bot is using.
		# https://rasa.com/docs/rasa/user-guide/messaging-and-voice-channels/
		
		rest:
		#  # you don't need to provide anything here - this channel doesn't
		#  # require any credentials
		
		
		#facebook:
		#  verify: "<verify>"
		#  secret: "<your secret>"
		#  page-access-token: "<your page access token>"
		
		#slack:
		#  slack_token: "<your slack token>"
		#  slack_channel: "<the slack channel>"
		
		#socketio:
		#  user_message_evt: <event name for user message>
		#  bot_message_evt: <event name for but messages>
		#  session_persistence: <true/false>
		
		#mattermost:
		#  url: "https://<mattermost instance>/api/v4"
		#  team: "<mattermost team>"
		#  user: "<bot username>"
		#  pw: "<bot token>"
		#  webhook_url: "<callback URL>"
		
		rasa:
		  url: "http://localhost:5002/api"
	'''
}
