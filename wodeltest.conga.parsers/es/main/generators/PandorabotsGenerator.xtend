package es.main.generators

import generator.Action
import generator.Bot
import generator.DefaultEntity
import generator.Empty
import generator.Entity
import generator.EntityInput
import generator.HTTPRequest
import generator.HTTPResponse
import generator.Image
import generator.Intent
import generator.LanguageIntent
import generator.Language
import generator.Literal
import generator.ParameterReferenceToken
import generator.ParameterToken
import generator.SimpleInput
import generator.Text
import generator.TextInput
import generator.LanguageText
import generator.Token
import generator.TrainingPhrase
import generator.UserInteraction
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.resource.Resource

class PandorabotsGenerator extends BotGenerator {
	Map<UserInteraction, String> affectedContext = new HashMap();
	String congaPath;

	new(String botPath, String fileName, String botName, String filesPaths) {
		super(botPath + File.separator + fileName, botName)
		this.congaPath = filesPaths;

	}

	override File doGenerate(Resource resource) {
		var bot = resource.allContents.filter(Bot).toList.get(0)
		var requests = resource.allContents.filter(HTTPRequest).toList

		// Creacion de fichero de propiedades .properties
		var systemPropertiesName = bot.getName().toLowerCase().replace(' ', '_') + ".properties"
		var systemProperties = generateFile(systemPropertiesName, systemFileFill())
		saveFileIntoZip(systemProperties, "system", systemPropertiesName)

		// Creacion de fichero UDC
		var udcName = "udc.aiml"
		var udc = generateFile(udcName, udcFileFill())
		saveFileIntoZip(udc, "files", udcName)

		// Creacion de ficheros de utils y funciones externas comunes entre todos los proyectos
		// var congaPath = "C:/CONGA/pandorabots/"
		var utilsPath = Paths.get(congaPath + "utils.aiml")
		var utils = new String(Files.readAllBytes(utilsPath))
		var utilsGen = generateFile("utils.aiml", utils)
		saveFileIntoZip(utilsGen, "files", "utils.aiml")

		var aimlSLPath = Paths.get(congaPath + "aimlstandardlibrary.aiml")
		var aimlSL = new String(Files.readAllBytes(aimlSLPath))
		var aimlSLValue = generateFile("aimlstandardlibrary.aiml", aimlSL)
		saveFileIntoZip(aimlSLValue, "files", "aimlstandardlibrary.aiml")

		// Generacion de ficheros de sustituciones automaticas vacios
		generateEmptySubstitutions()

		// Obtencion de todas las entities del modelo
		var entities = resource.allContents.filter(Entity).toList
		for (Entity entity : entities) {
			// Creacion de map para la entity correspondiente
			var entityName = entity.name.replaceAll('[ _.]', '') + ".map"

			// Generacion del archivo map asociado a la entity concreta
			var entityValue = generateFile(entityName, entityMapFill(entity))
			saveFileIntoZip(entityValue, "maps", entityName)

			var entitySetName = entity.name.replaceAll('[ _.]', '') + ".set"
			var inputSetValue = generateFile(entitySetName, entitySetFill(entity))
			saveFileIntoZip(inputSetValue, "sets", entitySetName)
		}

		// En flows se guardan los flujos de conversacion
		for (UserInteraction transition : bot.flows) {
			createTransitionFiles(resource, transition, "", bot)
		}

		close()
		return getZipFile()
	}

	// Genera los ficheros de sustituciones vacios para que no haya problemas de sustituciones indeseadas
	def generateEmptySubstitutions() {
		// Generacion de archivos
		var person2 = generateFile("person2.substitution", "[]")
		var person = generateFile("person.substitution", "[]")
		var normal = generateFile("normal.substitution", '''
			[
			["\/", " slash "],
			[":0", " colon 0"],
			[":1", " colon 1"],
			[":2", " colon 2"],
			[":3", " colon 3"],
			[":4", " colon 4"],
			[":5", " colon 5"],
			[":6", " colon 6"],
			[":7", " colon 7"],
			[":8", " colon 8"],
			[":9", " colon 9"]
			]
		''')
		var gender = generateFile("gender.substitution", "[]")
		var denormal = generateFile("denormal.substitution", "[]")

		// Introduccion de ficheros en zip
		saveFileIntoZip(person2, "substitutions", "person2.substitution")
		saveFileIntoZip(person, "substitutions", "person.substitution")
		saveFileIntoZip(normal, "substitutions", "normal.substitution")
		saveFileIntoZip(gender, "substitutions", "gender.substitution")
		saveFileIntoZip(denormal, "substitutions", "denormal.substitution")
	}

	// Genera el codigo para rellenar el archivo de propiedades del bot
	def systemFileFill() '''
		[
		["name", "set_when_loaded"],
		["default-get", "unknown"],
		["default-property", "unknown"],
		["default-map", "unknown"],
		["sentence-splitters", ".!?"],
		["learn-filename", "pand_learn.aiml"],
		["max-learn-file-size", "1000000"]
		]
	'''

	// Genera el codigo para rellenar el archivo udc principal del bot
	def udcFileFill() '''
		<?xml version="1.0" encoding="UTF-8"?>
		<aiml>
		</aiml>
	'''

	// Rellena el set correspondiente al input concreto (entity->inputs->inputs)
	def entitySetFill(Entity entity) '''
		[
		«««		«FOR synonym : input.values»
«««			["«synonym»"]«IF !input.values.isTheLast(synonym)»,«ENDIF»
«««		«ENDFOR»
		«FOR language_input : entity.inputs»
			«FOR input : language_input.inputs»
				«IF input instanceof SimpleInput»
					["«input.name»"]«IF  !(input.values.isEmpty && language_input.inputs.isTheLast(input) && entity.inputs.isTheLast(language_input))»,«ENDIF»
					«FOR synonym : input.values»
						["«synonym»"]«IF !(input.values.isTheLast(synonym) && language_input.inputs.isTheLast(input) && entity.inputs.isTheLast(language_input))»,«ENDIF»
					«ENDFOR»
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		]
	'''

	// Rellena el map con todas las entities de pandorabots y su set asociado
	def entityMapFill(Entity entity) '''
		[
		«FOR input : entity.inputs»
			«FOR entry: input.inputs»
				«entry(entry)»«IF !isTheLast(input.inputs, entry)»,«ENDIF»
			«ENDFOR»
		«ENDFOR»
		]
	'''

	// Genera codigo distinto dependiendo del tipo de input
	def entry(EntityInput entry) {
		if (entry instanceof SimpleInput) {
			return entry(entry)
		}
	// CompositeInput y RegexInput no soportados
	}

	// Escribe las posibles opciones de un entity dentro de un fichero set
	def entry(SimpleInput entry) '''
		«IF entry.values.isEmpty»
			["«entry.name»", "«entry.name»"]
		«ELSE»
			«FOR synonym : entry.values»
				["«synonym»", "«entry.name»"]«IF !isTheLast(entry.values, synonym)»,«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''

	// Guarda los intents durante el recorrido de los flujos de conversación
	def void createTransitionFiles(Resource resource, UserInteraction transition, String prefix, Bot bot) {
		var intentFileName = (transition.intent.name).toLowerCase().replaceAll('[ _.]', '') + ".aiml"
		var intentFileContent = '''
			<?xml version="1.0" encoding="UTF-8"?>
			«  »<aiml>
		'''
		intentFileContent += intentFile(resource, transition, bot, prefix, "")
		intentFileContent += '''
			</aiml>
		'''
		var intentValue = generateFile(intentFileName, intentFileContent)
		saveFileIntoZip(intentValue, prefix + "files", intentFileName)
	}

	// Devuelve todas las posibles respuestas a un intent para un lenguage concreto
	def getAllIntentResponses(LanguageText textAction) {
		var responses = new ArrayList<String>()
		for (TextInput input : textAction.inputs) {
			var response = ""
			for (Token token : input.tokens) {
				if (token instanceof Literal) {
					response += token.text
					if (!isTheLast(input.tokens, token))
						response += " "
				} else if (token instanceof ParameterToken)
					response += "<get name=\"" + token.parameter.name + "\"/> "
			}

			responses.add(response)
		}

		return responses
	}

	// Devuelve las entidades conetenidas en una frase concreta
	def getPhraseEntities(TrainingPhrase phrase) {
		var ret = new ArrayList<String>()

		for (token : phrase.tokens)
			if (token instanceof ParameterReferenceToken)
				ret.add(token.parameter.name)

		return ret
	}

	// Devuelve una lista ordenada de pares <parametro, frase de peticion> de un intent concreto
	def getIntentParameterPrompts(Intent intent) {
//		var ret = new ArrayList<Pair<String, String>>()
		var ret = new ArrayList<Pair<String, Map<String, List<String>>>>()

//		for (parameter: intent.parameters)
//			ret.add(new Pair(parameter.name, parameter.prompts.get(0).prompts.get(0)))
		for (parameter : intent.parameters) {
			var langMap = new HashMap<String, List<String>>()
			for (language : parameter.prompts) {
				// Guardamos las frases de cada entity en cada lenguaje concreto en una lista dentro del diccionario 
				// de lenguajes
				var langPrompts = new ArrayList<String>()
				for (prompt : language.prompts) {
					langPrompts.add(prompt)
				}
				langMap.put(language.language.languageAbbreviation, langPrompts)
			}
			// Guardamos por cada entidad el diccionario con las entradas en cada idioma para solicitar una misma entidad
			ret.add(new Pair(parameter.name, langMap))
		}

		return ret
	}

	// Extrae los nombres de parametros de una lista de pares <parametro, frase de peticion>
	def getPromptsKeys(ArrayList<Pair<String, Map<String, List<String>>>> list) {
		var ret = new ArrayList<String>()

		for (elem : list)
			ret.add(elem.key)

		return ret
	}

	// Devuelve el siguiente par <parametro, frases de peticion separadas por idioma> de una 
	// frase concreta contenida en un intent concreto
	def getNextParamPetition(Intent intent, TrainingPhrase phrase) {
		var entities = getPhraseEntities(phrase)
		var parameters = getIntentParameterPrompts(intent)

		var keys = getPromptsKeys(parameters)
		keys.removeAll(entities)

		if (keys.isEmpty())
			return new Pair("", null)
		else
			for (param : parameters)
				if (param.key == keys.get(0))
					return param
	}

	// Generador de codigo de un intent
	// TODO: Revisar impresion de parametros etc en HttpResponse <- Necesario acceso a llamadas HTTP con callapi
	def intentFile(Resource resource, UserInteraction transition, Bot bot, String prefix, String that) '''
		«createSaveParameter(resource, transition.intent, prefix)»
		«"  "»<!-- Intent -->
		«intentGenerator(transition, bot, prefix)»
		«createIntentInputs(resource, transition, bot, prefix, that)»
		«createChainedParamIntents(resource, transition, prefix)»
		«IF transition.target !== null»
		«IF transition.target.outcoming.length >= 1»
			«"  "»<!-- Nested outcoming intents -->
			«FOR action: transition.target.actions»
				«IF action instanceof Text»
					«FOR language: action.inputs»
						«var List<?> responses»
						«{responses = language.getAllIntentResponses(); ""}»
						«FOR response: responses»
							«FOR outcoming: transition.target.outcoming»
								«intentFile(resource, outcoming, bot, transition.intent.name, response.toString())»
							«ENDFOR»
						«ENDFOR»
					«ENDFOR»
				«ELSEIF action instanceof Empty»
					«FOR outcoming: transition.target.outcoming»
						«intentFile(resource, outcoming, bot, transition.intent.name, "")»
					«ENDFOR»
				«ENDIF»
			«ENDFOR»
		«ENDIF»
		«ENDIF»
	'''

	// Crea los intents de Pandorabots relacionados con las entradas del usuario que generalmente conllevan guardado
	// de argumentos
	def createIntentInputs(Resource resource, UserInteraction transition, Bot bot, String prefix, String that) '''
		«"  "»<!-- Intent inputs -->
		«var List<String> overallEntities»
		«{overallEntities = getEntityNames(resource) ; ""}»
		«FOR language : transition.intent.inputs»
			«FOR input: language.inputs»
				«IF input instanceof TrainingPhrase»
					«"  "»<category>
				«"    "»<pattern>«FOR token: input.tokens»«IF token instanceof Literal»«token.text.replace('?', ' #').replace('&', language.language.ampersandSubstitution)»«ELSEIF token instanceof ParameterReferenceToken»«IF overallEntities.contains(token.parameter.name)»<set>«token.parameter.name»</set>«ELSE»*«ENDIF»«ENDIF»«ENDFOR»</pattern>
				«IF !that.isEmpty()»
					«"    "»<that>«that.replaceAll('[?.!<>]', ' ').replace('&', language.language.ampersandSubstitution)»</that>
				«ENDIF»
				«"    "»<template>
				«var List<String> entities»
				«{entities = getPhraseEntities(input); ""}»
				«IF !entities.isEmpty()»
					«"      "»<think>
					«FOR entity: entities»
						«"        "»<srai>
						«"          "»SAVE«(prefix + entity).toUpperCase()» <star index="«entities.indexOf(entity) + 1»"/>
						«"        "»</srai>
					«ENDFOR»
					«"      "»</think>
				«ENDIF»
				«var lang = ""»
				 	«IF language.language != Language.EMPTY»
				 		«{lang = language.language.languageAbbreviation; ""}»
				 	«ELSE»
				 		«{lang = bot.languages.get(0).languageAbbreviation; ""}»
				 	«ENDIF»
				«var Map<String, List<String>> nextPrompts»
				«{nextPrompts = getNextParamPetition(transition.intent, input).getValue(); ""}»
				«IF nextPrompts !== null»
					«FOR promptLang: nextPrompts.keySet»
						«IF promptLang == lang»
							«IF nextPrompts.get(promptLang).length > 1»
								«"      "»<random>
								«FOR prompt: nextPrompts.get(promptLang)»
									«"        "»<li>«prompt»<li/>
								«ENDFOR»
								«"      "»<random>
							«ELSE»
								«"      "»«nextPrompts.get(promptLang).get(0)»
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				«ELSE»
					«"      "»<think>
					«"        "»<set name="pandoralang">«lang»</set>
					«"      "»</think>
					«"      "»<srai>«(prefix + transition.intent.name).toUpperCase().replaceAll('[ _]', '').toUpperCase()»</srai>
				«ENDIF»
				«"    "»</template>
				«"  "»</category>
			«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''

	// Generacion de codigo referente a la lectura de parametros por parte del usuario y posterior solicitud del resto
	// de parametros requeridos
	def createChainedParamIntents(Resource resource, UserInteraction transition, String prefix) {
		var parameters = getIntentParameters(transition.intent)
		if (parameters.isEmpty())
			return ""
		else {
			var ret = '''
				«"  "»<!-- Chained param intents -->
			'''
			var entities = getEntityNames(resource)
			for (key : parameters.keySet) {
				var value = parameters.get(key)
//				var paramConditions = generateParamConditionsRec(transition.intent, new ArrayList<String>(parameters.keySet), "  ", prefix)
				var String paramConditions
				var completeKey = prefix + key
				var paramPrompts = getParamPromptByName(transition.intent, key)
				switch (value) {
					case DefaultEntity.TEXT:
						for (language : paramPrompts.keySet) {
							paramConditions = generateParamConditionsRec(transition.intent,
								new ArrayList<String>(parameters.keySet), "  ", prefix, language)
							for (prompt : paramPrompts.get(language)) {
								if (entities.contains(key))
									ret += '''
										«"  "»<category>
										«"    "»<pattern><set>«key»</set></pattern>
										«"    "»<that>«prompt.replaceAll('[?.!<>]', ' ').replace('&', transition.intent.inputs.get(0).language.ampersandSubstitution)»</that>
										«"    "»<template>
										«"      "»<think>
										«"        "»<srai>SAVE«completeKey.toUpperCase()» <map name="«key»"><star/></map></srai>
										«"      "»</think>
										«paramConditions»
										«"    "»</template>
										«"  "»</category>
									'''
								else
									ret += '''
										«"  "»<category>
										«"    "»<pattern>*</pattern>
										«"    "»<that>«prompt.replaceAll('[?.!<>]', ' ').replace('&', transition.intent.inputs.get(0).language.ampersandSubstitution)»</that>
										«"    "»<template>
										«"      "»<think>
										«"        "»<srai>SAVE«completeKey.toUpperCase()» <star/></srai>
										«"      "»</think>
										«paramConditions»
										«"    "»</template>
										«"  "»</category>
									'''
							}
						}
					case DefaultEntity.TIME:
						for (language : paramPrompts.keySet) {
							paramConditions = generateParamConditionsRec(transition.intent,
								new ArrayList<String>(parameters.keySet), "  ", prefix, language)
							for (prompt : paramPrompts.get(language))
								ret += '''
									«"  "»<category>
									«"    "»<pattern>* colon *</pattern>
									«"    "»<that>«prompt.replaceAll('[?.!<>]', ' ').replace('&', transition.intent.inputs.get(0).language.ampersandSubstitution)»</that>
									«"    "»<template>
									«"      "»<think>
									«"        "»<srai>SAVE«completeKey.toUpperCase()» <star index="1"/>:<star index="2"/></srai>
									«"      "»</think>
									«paramConditions»
									«"    "»</template>
									«"  "»</category>
								'''
						}
					case DefaultEntity.DATE:
						for (language : paramPrompts.keySet) {
							paramConditions = generateParamConditionsRec(transition.intent,
								new ArrayList<String>(parameters.keySet), "  ", prefix, language)
							for (prompt : paramPrompts.get(language))
								ret += '''
									«"  "»<category>
									«"    "»<pattern>* slash * slash *</pattern>
									«"    "»<that>«prompt.replaceAll('[.!]', ' ').replace('&', transition.intent.inputs.get(0).language.ampersandSubstitution)»</that>
									«"    "»<template>
									«"      "»<think>
									«"        "»<srai>SAVE«completeKey.toUpperCase()» <star index="1"/>/<star index="2"/>/<star index="3"/></srai>
									«"      "»</think>
									«paramConditions»
									«"    "»</template>
									«"  "»</category>
								'''
						}
					case DefaultEntity.NUMBER:
						for (language : paramPrompts.keySet) {
							paramConditions = generateParamConditionsRec(transition.intent,
								new ArrayList<String>(parameters.keySet), "  ", prefix, language)
							for (prompt : paramPrompts.get(language))
								ret += '''
									«"  "»<category>
									«"    "»<pattern><set>number</set></pattern>
									«"    "»<that>«prompt.replaceAll('[?.!<>]', ' ').replace('&', transition.intent.inputs.get(0).language.ampersandSubstitution)»</that>
									«"    "»<template>
									«"      "»<think>
									«"        "»<srai>SAVE«completeKey.toUpperCase()» <star/></srai>
									«"      "»</think>
									«paramConditions»
									«"    "»</template>
									«"  "»</category>
								'''
						}
					default:
						for (language : paramPrompts.keySet) {
							paramConditions = generateParamConditionsRec(transition.intent,
								new ArrayList<String>(parameters.keySet), "  ", prefix, language)
							for (prompt : paramPrompts.get(language))
								ret += '''
									«"  "»<category>
									«"    "»<pattern>*</pattern>
									«"    "»<that>«prompt.replaceAll('[?.!<>]', ' ').replace('&', transition.intent.inputs.get(0).language.ampersandSubstitution)»</that>
									«"    "»<template>
									«"      "»<think>
									«"        "»<srai>SAVE«completeKey.toUpperCase()» <star/></srai>
									«"      "»</think>
									«paramConditions»
									«"    "»</template>
									«"  "»</category>
								'''
						}
				}
			}

			return ret
		}
	}

	// Genera los arboles de solicitud de parametros en cada intent de forma recursiva
	def generateParamConditionsRec(Intent intent, List<String> params, String indent, String prefix, String language) {
		if (params.isEmpty())
			return '''
				«indent + "    "»<think>
				«indent + "      "»<set name="pandoralang">«language»</set>
				«indent + "    "»</think>
				«indent + "    "»<srai>«(prefix + intent.name).toUpperCase().replaceAll('[ _]', '').toUpperCase()»</srai>
			'''
		else {
			var currentParam = params.get(0)
			var newIndent = indent + "    "
			var prompts = getParamPromptByName(intent, currentParam).get(language)
			params.remove(currentParam)
			return '''
				«newIndent»<condition name="«prefix + currentParam»">
				«IF prompts.length > 1»
					«newIndent + "  "»<li value="unknown">
					«newIndent + "    "»<random>
					«FOR prompt: prompts»
						«newIndent + "      "»<li>«prompt»</li>
					«ENDFOR»
					«newIndent + "    "»</random>
					«newIndent + "  "»</li>
				«ELSE»
					«newIndent + "  "»<li value="unknown">«prompts.get(0)»</li>
				«ENDIF»
				«newIndent + "  "»<li>
				«generateParamConditionsRec(intent, params, newIndent, prefix, language)»
				«newIndent + "  "»</li>
				«newIndent»</condition>
			'''
		}
	}

	// Devuelve las peticiones de parametro correspondientes dado el nombre del parametro
	def getParamPromptByName(Intent intent, String name) {
		var params = getIntentParameterPrompts(intent)
		for (param : params)
			if (param.key == name)
				return param.value
	}

	// Devuelve los parametros que se quieren recoger con un intent
	def getIntentParameters(Intent intent) {
		// <lenguaje, entity>
		var ret = new HashMap<String, DefaultEntity>()

		for (LanguageIntent language : intent.inputs)
			for (input : language.inputs)
				if (input instanceof TrainingPhrase)
					for (token : (input as TrainingPhrase).tokens)
						if (token instanceof ParameterReferenceToken)
							// Si no contiene el parametros por otro input, lo introduce en el diccionario
							if (!ret.keySet.contains(token.parameter.name))
								ret.put(token.parameter.name, token.parameter.defaultEntity)

		return ret
	}

	// Devuelve el nombre de los entities del chatbot
	def getEntityNames(Resource resource) {
		var ret = new ArrayList<String>()
		var entities = resource.allContents.filter(Entity).toList

		for (entity : entities)
			ret.add(entity.name)

		return ret
	}

	// Genera los intents de pandorabots de tipo SAVE_PARAMETER para poder guardar los parametros de distintos
	// tipos del intent concreto
	def createSaveParameter(Resource resource, Intent intent, String prefix) {
		var parameters = getIntentParameters(intent)
		if (parameters.isEmpty())
			return ""
		else {
			var ret = "  <!-- Entity saving -->\n"
			var entities = getEntityNames(resource)

			for (key : parameters.keySet) {
				var value = parameters.get(key)
				var completeKey = prefix + key
				switch (value) {
					case DefaultEntity.TEXT:
						if (entities.contains(key))
							ret += '''
								«"  "»<category>
								«"    "»<pattern>SAVE«completeKey.toUpperCase()» <set>«key»</set></pattern>
								«"    "»<template>
								«"      "»<think><set name="«completeKey»"><map name="«key»"><star/></map></set></think>
								«"    "»</template>
								«"  "»</category>
							'''
						else
							ret += '''
								«"  "»<category>
								«"    "»<pattern>SAVE«completeKey.toUpperCase()» *</pattern>
								«"    "»<template>
								«"      "»<think><set name="«completeKey»"><star/></set></think>
								«"    "»</template>
								«"  "»</category>
							'''
					case DefaultEntity.TIME:
						ret += '''
							«"  "»<category>
							«"    "»<pattern>SAVE«completeKey.toUpperCase()» * colon *</pattern>
							«"    "»<template>
							«"      "»<think>
							«"        "»<set name="«completeKey»_is_valid"><srai>ISVALIDHOUR <star index="1"/>:<star index="2"/></srai></set>
							«"      "»</think>
							«"      "»<condition name="«completeKey»_is_valid">
							«"        "»<li value="TRUE">
							«"          "»<think>
							«"            "»<set name="«completeKey»"><star index="1"/>:<star index="2"/></set>
							«"          "»</think>
							«"        "»</li>
							«"      "»</condition>
							«"    "»</template>
							«"  "»</category>
						'''
					case DefaultEntity.DATE:
						ret += '''
							«"  "»<category>
							«"    "»<pattern>SAVE«completeKey.toUpperCase()» * slash * slash *</pattern>
							«"    "»<template>
							«"      "»<think>
							«"        "»<set name="«completeKey»_is_valid">
							«"          "»<srai>VALIDDATE <star index="1"/>/<star index="2"/>/<star index="3"/></srai>
							«"        "»</set>
							«"      "»</think>
							«"      "»<condition name="«completeKey»_is_valid">
							«"        "»<li value="TRUE">
							«"          "»<think><set name="«completeKey»"><star index="1"/>/<star index="2"/>/<star index="3"/></set></think>
							«"        "»</li>
							«"      "»</condition>
							«"    "»</template>
							«"  "»</category>
						'''
					case DefaultEntity.NUMBER:
						ret += '''
							«"  "»<category>
							«"    "»<pattern>SAVE«completeKey.toUpperCase()» <set>number</set></pattern>
							«"    "»<template>
							«"      "»<think><set name="«completeKey»"><star/></set></think>
							«"    "»</template>
							«"  "»</category>
						'''
					default:
						ret += '''
							«"  "»<category>
							«"    "»<pattern>SAVE«completeKey.toUpperCase()» *</pattern>
							«"    "»<template>
							«"      "»<think><set name="«completeKey»"><star/></set></think>
							«"    "»</template>
							«"  "»</category>
						'''
				}
			}

			return ret
		}
	}

	// Devuelve los lenguajes de un acton
	def getActionLanguages(Action action) {
		var languageList = new ArrayList<String>()

		if (action instanceof Text)
			for (language : action.inputs)
				languageList.add(language.language.languageAbbreviation)

		return languageList
	}

	// Devuelve las acciones de un lenguaje concreto
	def getLanguageActions(List<Action> actions, String lang) {
		var ret = new ArrayList<LanguageText>()

		for (action : actions)
			if (action instanceof Text)
				for (language : action.inputs)
					if (language.language.languageAbbreviation == lang)
						ret.add(language)

		return ret
	}

	def getActionsByLanguage(UserInteraction transition) {
		var ret = new HashMap<String, List<String>>()
		var othersList = new ArrayList<String>()
		if (transition.target !== null) {
			for (action : transition.target.actions) {
				if (action instanceof Text) {
					for (input : action.inputs) {
						var lang = languageAbbreviation(input.language)
						if (!ret.keySet.contains(lang)) {
							var temp = new ArrayList<String>()
							temp.add(action.name)
							ret.put(lang, temp)
						} else {
							var tempList = ret.get(lang)
							tempList.add(action.name)
							ret.put(lang, tempList)
						}
					}
				} else {
					othersList.add(action.name)
				}
			}
		}

		if (!othersList.isEmpty())
			ret.put("others", othersList)

		return ret
	}

	// Generacion de codigo de un intent con una o varias respuestas
	def intentGenerator(UserInteraction transition, Bot bot, String prefix) '''
		«var intentName = ""»
		«"  "»<!-- Main intents -->
		«««		«FOR language: transition.intent.inputs»
«««		«var lang = ""»
«««	  	«IF language.language != Language.EMPTY»
«««	    	«{lang = language.language.languageAbbreviation; ""}»
«««	  	«ELSE»
«««	    	«{lang = bot.languages.get(0).languageAbbreviation; ""}»
«««	    «ENDIF»
		«{intentName = (prefix + transition.intent.name).toUpperCase().replaceAll('[ _]', ''); ""}»
		«"  "»<category>
		«"    "»<pattern>«intentName»</pattern>
		«"    "»<template>
		«"      "»<condition name="pandoralang">
		«var flag = ""»
		«var HashMap<?, ?> langActions»
		«{langActions = getActionsByLanguage(transition); ""}»
		«FOR key : langActions.keySet»
			«IF key !== "others"»
				«"        "»<li value="«key»">
				«FOR act: (langActions.get(key) as ArrayList<String>)»
					«"          "»<srai>«(intentName + (key as String) + act).replaceAll('[ _]', '').toUpperCase()»</srai>
				«ENDFOR»
				«IF langActions.get("others") !== null && flag == ""»
					«FOR act: (langActions.get("others") as ArrayList<String>)»
						«"          "»<srai>«(intentName + act).toUpperCase().replaceAll('[ _]', '')»</srai>
					«ENDFOR»
					«{flag="x"; ""}»
				«ENDIF»
				«"        "»</li>
			«ENDIF»
		«ENDFOR»
		«IF langActions.size() == 1 && langActions.get("others") !== null»
			«"        "»<li>
			«FOR act: langActions.get("others") as List<String>»
				«"          "»<srai>«(intentName + act).toUpperCase().replaceAll('[ _]', '')»</srai>
			«ENDFOR»
			«"        "»</li>
		«ENDIF»
		«"      "»</condition>
		«"    "»</template>
		«"  "»</category>
		«««	    «ENDFOR»
		«"  "»<!-- Action intents -->
		«{intentName = (prefix + transition.intent.name).toUpperCase().replaceAll('[ _]', ''); ""}»
		«IF transition.target!== null»
		«FOR action : transition.target.actions»
			«IF action instanceof Text»
				«FOR language: action.inputs»
					«var lang=""»
					«IF language.language != Language.EMPTY»
						«{lang = language.language.languageAbbreviation.toUpperCase(); ""}»
					«ELSE»
						«{lang = bot.languages.get(0).languageAbbreviation.toUpperCase(); ""}»
					«ENDIF»
					«"  "»<category>
					«"    "»<pattern>«(intentName + lang + action.name).replaceAll('[ _]', '').toUpperCase()»</pattern>
					«IF language.getAllIntentResponses().length > 1»
						«"    "»<template>
						«"      "»<random>
						«FOR response: language.getAllIntentResponses()»
							«"        "»<li>«response.replaceAll("[?.!<>]", ' ').replace('&', language.language.ampersandSubstitution).replace('\n', "<br/>")»</li>
						«ENDFOR»
						«"      "»</random>
						«"    "»</template>
						«"  "»</category>
					«ELSE»
						«"    "»<template>«language.getAllIntentResponses().get(0).replaceAll("[?.!<>]", ' ').replace('&', language.language.ampersandSubstitution).replace('\n', "<br/>")»</template>
						«"  "»</category>
					«ENDIF»
				«ENDFOR»
			«ELSEIF action instanceof Empty»
				«"  "»<category>
				«"    "»<pattern>«(intentName + action.name).replaceAll('[ _]', '').toUpperCase()»</pattern>
				«"    "»<template></template>
				«"  "»</category>
			«ELSEIF action instanceof Image»
				«"  "»<category>
				«"    "»<pattern>«(intentName + action.name).toUpperCase().replaceAll('[ _]', '')»</pattern>
				«"    "»<template><image>«action.URL»</image></template>
				«"  "»</category>
			«ELSEIF action instanceof HTTPRequest»
				«"  "»<category>
				«"    "»<pattern>«(intentName + action.name).toUpperCase().replaceAll('[ _]', '')»</pattern>
				«"    "»<template>
				«"      "»<callapi response_code_var="response_«prefix + action.name»">
				«"        "»<url>«(action as HTTPRequest).getURL()»</url>
				«"        "»<method>«action.method»</method>
				«FOR header: action.headers»
					«"        "»<header><name>«header.key»</name>«(header.value as Literal).text»</header>
				«ENDFOR»
				«FOR param: action.data»
					«"        "»<query name="«(param.value as ParameterToken).parameter.name»"><get name="«(param.value as ParameterToken).parameter.name»"/></query>
				«ENDFOR»
				«"      "»</callapi>
				«"    "»</template>
				«"  "»</category>
			«ELSEIF action instanceof HTTPResponse»
				«"  "»<category>
				«"    "»<pattern>«(intentName + action.name).toUpperCase().replaceAll('[ _]', '')»</pattern>
				«"    "»<template>
				«"      "»<get name="response_«prefix + (action as HTTPResponse).HTTPRequest.name»"/>
				«"    "»</template>
				«"  "»</category>
			«ENDIF»
		«ENDFOR»
		«ENDIF»
	'''

	// Devuelve la sustitucion del simbolo ampersand asociado al idioma en que este programado el bot
	def ampersandSubstitution(Language lang) {
		switch (lang) {
			case Language.ENGLISH:
				return 'and'
			case Language.SPANISH:
				return 'y'
			case Language.DANISH:
				return 'og'
			case Language.GERMAN:
				return 'und'
			case Language.FRENCH:
				return 'et'
			case Language.INDONESIAN:
				return 'dan'
			case Language.ITALIAN:
				return 'e'
			case Language.DUTCH:
				return 'en'
			case Language.NORWEGIAN:
				return 'og'
			case Language.POLISH:
				return 'i'
			case Language.PORTUGUESE:
				return 'e'
			case Language.SWEDISH:
				return 'och'
			case Language.TURKISH:
				return 've'
			case Language.UKRANIAN:
				return 'i'
			default:
				return 'and'
		}
	}

	// Obtencion de abreviacion del lenguage
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

	def static isTheLast(List<?> list, Object object) {
		if (list.indexOf(object) == list.size - 1) {
			return true;
		}
		return false;

	}
}
