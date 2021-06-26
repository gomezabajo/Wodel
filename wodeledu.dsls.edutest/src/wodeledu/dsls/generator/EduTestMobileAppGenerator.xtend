package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import manager.ModelManager
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EObject
import exceptions.ModelNotFoundException
import org.eclipse.emf.common.util.URI
import edutest.Program
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Locale
import edutest.AlternativeResponse
import edutest.MultiChoiceDiagram
import edutest.MultiChoiceEmendation
import java.util.ArrayList
import manager.IOUtils
import manager.WodelContext
import java.io.File
import java.util.AbstractMap.SimpleEntry
import java.util.HashMap
import edutest.MatchPairs
import java.util.TreeMap

class EduTestMobileAppGenerator extends EduTestSuperGenerator {
	
	private List<EObject> blocks
	private String localProperties
	private String xmlFileName
	private String fileName
	private String stringXmlFileName
	private String stringXmlFileNameEs
	private String userProfile = "C\\:\\\\Users\\\\User"
	private String currentDate = (new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)).format((new Date(System.currentTimeMillis()))) 
	//private String pageName
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		manager.WodelContext.setProject(null)
		ModelManager.setProjectNameByResource(resource)
		try {
			var i = 0;
			//loads the mutator model
			var xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + "/" + manager.WodelContext.getProject +
			"/" + ModelManager.getOutputFolder + "/" + resource.URI.lastSegment.replaceAll(".test", ".model")
			val Bundle bundle = Platform.getBundle("wodel.models")
	   		val URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore")
	   		val String mutatorecore = FileLocator.resolve(fileURL).getFile()
			//val String mutatorecore = ModelManager.getWorkspaceAbsolutePath + "/" + WodelContext.getProject() + "/resources/MutatorEnvironment.ecore";
			val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore)
			//val EPackage epackage = mutatorpackages.get(0);
			//EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
			val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString)
			blocks = ModelManager.getObjectsOfType("Block", mutatormodel)
			
			var String userProfileValue = System.getenv("USERPROFILE")
			if (userProfileValue !== null && userProfileValue.length() > 0) {
				userProfile = userProfileValue.substring(0, 1) + "\\"
				userProfile += ":"
				userProfile += "\\\\"
				var int indexOfSlash = 3
				while (indexOfSlash > 0 && indexOfSlash < userProfileValue.length()) {
					userProfileValue = userProfileValue.substring(indexOfSlash, userProfileValue.length())
					if (userProfileValue.substring(0, userProfileValue.length()).indexOf("\\") > 0) {
						indexOfSlash = userProfileValue.substring(0, userProfileValue.length()).indexOf("\\") + 1
					}
					else {
						indexOfSlash = userProfileValue.length() + 1
					}
					userProfile += userProfileValue.substring(0, indexOfSlash - 1) + "\\\\"
				}
			}
			

			for (p : resource.allContents.toIterable.filter(Program)) {
				if (i == 0) {
					localProperties = '../app/mobile/local.properties'
					xmlFileName = '../app/mobile/app/src/main/res/layout/activity_main.xml'
					fileName = '../app/mobile/app/src/main/java/org/example/esquematfg/MainActivity.java'
					stringXmlFileName = '../app/mobile/app/src/main/res/values/strings.xml'
					stringXmlFileNameEs = '../app/mobile/app/src/main/res/values-es/strings.xml'
					//pageName = resource.URI.lastSegment.replaceAll(".test", "") + '.app'
				} else {
					localProperties = '../app/mobile/local.properties'
					xmlFileName = '../app/mobile/app/src/main/res/layout/activity_main.xml'
					fileName = '../app/mobile/app/src/main/java/org/example/esquematfg/MainActivity.java'
					stringXmlFileName = '../app/mobile/app/src/main/res/values/strings.xml'
					stringXmlFileNameEs = '../app/mobile/app/src/main/res/values-es/strings.xml'
					//pageName = resource.URI.lastSegment.replaceAll(".test", "") + i + '.app'
				}
				fsa.generateFile(fileName, p.compile(resource))
				fsa.generateFile(localProperties, p.localPropertiesCompile(resource))
				fsa.generateFile(xmlFileName, p.xmlCompile(resource))
				fsa.generateFile(stringXmlFileName, p.stringXmlCompile(resource))
				fsa.generateFile(stringXmlFileNameEs, p.stringXmlCompileEs(resource))
				i++
			}
		}
		catch (ModelNotFoundException e) {
		}
	}

	/*MobileApp code will be generated here!!*/
	def compile(Program program, Resource resource) '''
		«{buildOptions(program, resource, blocks, program.class); ""}»
		«var HashMap<Integer,String> drawable = new HashMap()»
		«var HashMap<Integer,HashMap<Integer,String>> drawableAnswer = new HashMap()»
		«var int i = 0»
		«FOR exercise : program.exercises»
			«IF exercise instanceof AlternativeResponse»
				«FOR test : exercise.tests»
					«IF rand.get(exercise).get(test).size() > 0»
						«var diagram = rand.get(exercise).get(test).get(0)»
						«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram), new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/mobile/app/src/main/res/drawable/q" + i + "_enunciado.png"))»
						«drawable.put(i,"q" + i + "_enunciado.png")»
						«{i++; ""}»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
			«IF exercise instanceof MultiChoiceEmendation»
				«FOR test : exercise.tests»
					«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
						«IF (options.get(exercise).get(test) !== null)»
							«FOR opt : options.get(exercise).get(test)»
								«IF opt.text.size > 0»
									«IF opt.solution == true»
										«var diagram=opt.path»
										«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/"+ diagram), new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/mobile/app/src/main/res/drawable/q" + i + "_enunciado.png"))»
										«drawable.put(i,"q" + i + "_enunciado.png")»
		 								«{i++; ""}»
									«ENDIF»
								«ENDIF»
							«ENDFOR»
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
			«IF exercise instanceof MultiChoiceDiagram»
				«FOR test : exercise.tests»
					«var int j = 0»
					«var HashMap<Integer,String> diccAux = new HashMap()»
					«FOR diag : diagrams.get(exercise).get(test)»
						«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() +"/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/"+ diag), new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/mobile/app/src/main/res/drawable/q" + i + "_respuesta"+j+".png"))»
						«diccAux.put(j, "q" + i + "_respuesta" + j+".png")»
						«{j++; ""}»
					«ENDFOR»
					«drawableAnswer.put(i,diccAux)»
					«{i++; ""}»
				«ENDFOR»
			«ENDIF»
			«IF exercise instanceof MatchPairs»
			        «var int min = Integer.MAX_VALUE»
			        «var int index = 0»
			        «var int max = Integer.MIN_VALUE»
				«FOR test : exercise.tests»
					«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
						«var List<String> textOptions = new ArrayList<String>()»
						«var int k = 0»
						«var int counter = 0»
						«FOR TestOption opt : options.get(exercise).get(test)»
							«FOR String key : opt.text.keySet()»
		         				«FOR String text : opt.text.get(key)»
									«IF !textOptions.contains(text)»
										«{counter++; ""}»
										«{textOptions.add(text); ""}»
									«ENDIF»
								«ENDFOR»
							«ENDFOR»
						«ENDFOR»
						«IF counter > max»
							«{max = counter; ""}»
							«{index = k; ""}»
						«ENDIF»
						«{k++; ""}»
					«ENDIF»
				«ENDFOR»
				«var int k = 0»
				«FOR test : exercise.tests»
					«var TestOption opt = null»
					«IF (options.get(exercise).get(test) !== null && options.get(exercise).get(test).size() > index)»
						//«opt = options.get(exercise).get(test).get(index)»
					«ENDIF»
					«IF opt !== null»
					    «var diagram=opt.path»
						«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/"+ diagram), new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/mobile/app/src/main/res/drawable/q" + i + "_enunciado.png"))»
						«drawable.put(i,"q" + i + "_enunciado.png")»
						«{i++; ""}»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
		«ENDFOR»
		package org.example.esquematfg;
			
		import androidx.annotation.NonNull;
		import androidx.appcompat.app.AlertDialog;
		import androidx.appcompat.app.AppCompatActivity;
		
		import android.content.DialogInterface;
		import android.graphics.Bitmap;
		import android.graphics.drawable.BitmapDrawable;
		import android.graphics.drawable.Drawable;
		import android.os.Bundle;
		import android.view.View;
		import android.widget.ArrayAdapter;
		import android.widget.Button;
		import android.widget.CheckBox;
		import android.widget.LinearLayout;
		import android.widget.RadioButton;
		import android.widget.RadioGroup;
		import android.widget.Spinner;
		import android.widget.TextView;
	
		import java.util.ArrayList;
		import java.util.HashMap;
		
		public class MainActivity extends AppCompatActivity {
			private int ids_answers_radio[]={
				R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4, R.id.answer5, R.id.answer6
			};
			private int ids_answers_check[]={
				R.id.check_box1, R.id.check_box2, R.id.check_box3, R.id.check_box4, R.id.check_box5, R.id.check_box6
			};
			private int ids_answers_false_true[] = {
				R.id.true_solution, R.id.false_solution
			};
			private int ids_answer_desplegable[]={
				R.id.desplegable1, R.id.desplegable2, R.id.desplegable3, R.id.desplegable4
			};
			private int ids_answer_desplegable_text[]={
				R.id.desplegable_text1, R.id.desplegable_text2, R.id.desplegable_text3, R.id.desplegable_text4
			};
	
			private int ids_answer_desplegable_spinner[]={
					R.id.desplegable_spinner1, R.id.desplegable_spinner2, R.id.desplegable_spinner3, R.id.desplegable_spinner4
			};
			«IF drawable.size() > 0»
			private HashMap<Integer, Integer> statements=new HashMap<Integer,Integer>(){{
            	«FOR Integer k : drawable.keySet»
            	put(«k»,R.drawable.«drawable.get(k).substring(0,drawable.get(k).length-4)»);
            	«ENDFOR»
			}};
           	«ENDIF»
           	«IF drawableAnswer.size() > 0»
			private HashMap<Integer, HashMap<Integer,Integer>> statementsAnswers=new HashMap<Integer, HashMap<Integer,Integer>>(){{
				«FOR Integer k1 : drawableAnswer.keySet»
				put(«k1»,new HashMap<Integer,Integer>(){{
					«FOR Integer k2 : drawableAnswer.get(k1).keySet»
					put(«k2»,R.drawable.«drawableAnswer.get(k1).get(k2).substring(0,drawableAnswer.get(k1).get(k2).length-4)»);
					«ENDFOR»
				}});
				«ENDFOR»
			}};
			«ENDIF»

		private String[] all_questions;
			private TextView text_question;
			private RadioGroup radio_true_false;
			private Button btn_next, btn_previous;
			private RadioGroup radio_group;
			
			private int type = -1;
			private String correct_answer;
			private int current_question;
			private boolean[] answer_is_correct;
			private String[] user_all_answers;
			private int n_answers=0;
			
			@Override
			protected void onSaveInstanceState(@NonNull Bundle outState) {
				super.onSaveInstanceState(outState);
			
				outState.putString("correct_answer", correct_answer);
				outState.putInt("current_question", current_question);
				outState.putBooleanArray("answer_is_correct", answer_is_correct);
				outState.putStringArray("user_all_answers", user_all_answers);
			}
			
			@Override
			protected void onCreate(Bundle savedInstanceState) {
						super.onCreate(savedInstanceState);
						setContentView(R.layout.activity_main);
					
						text_question = (TextView) findViewById(R.id.text_question);
						radio_group = (RadioGroup) findViewById(R.id.answer_group);
						radio_true_false = (RadioGroup) findViewById(R.id.answer_true_false);
						btn_next = (Button) findViewById(R.id.btn_check);
						btn_previous = (Button) findViewById(R.id.btn_previous);
						all_questions=getResources().getStringArray(R.array.all_questions);
						correct_answer="000000";
						if(savedInstanceState == null){
							reset();
						}else{
							correct_answer=savedInstanceState.getString("correct_answer");
							current_question=savedInstanceState.getInt("current_question");
							answer_is_correct=savedInstanceState.getBooleanArray("answer_is_correct");
							user_all_answers=savedInstanceState.getStringArray("user_all_answers");
							showQuestion();
						}
				
						btn_next.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								checkAnswer();
								if (current_question < all_questions.length - 1) {
									current_question++;
									showQuestion();
								}
								else {
									checkResults();
								}
							}
						});
						btn_previous.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								checkAnswer();
								if (current_question > 0) {
									current_question--;
									showQuestion();
								}
							}
						});
					}
				
					private void reset() {
						answer_is_correct = new boolean[all_questions.length];
						user_all_answers = new String[all_questions.length];
						correct_answer = "000000";
						for (int i = 0; i < user_all_answers.length; i++) {
							user_all_answers[i] = "000000";
						}
						current_question = 0;
						showQuestion();
					}
				
					private void checkResults() {
						int correctas = 0, incorrectas = 0, nocontestadas = 0;
						for (int i = 0; i < all_questions.length; i++) {
							if (answer_is_correct[i]) correctas++;
							else if (user_all_answers[i].equals("000000")) nocontestadas++;
							else incorrectas++;
						}
						// TODO: Traduccion del texto mediante recusos
						String res = String.format("Correctas: %d\nIncorrectas: %d\nNo contestadas: %d",
							correctas, incorrectas, nocontestadas);
						AlertDialog.Builder builder = new AlertDialog.Builder(this);
						builder.setTitle(R.string.results);
						builder.setMessage(res);
						//Suele haber el boton negativo(cancel) y el positivo(ok)
						builder.setPositiveButton(R.string.finish, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								finish();
							}
						});
				
						builder.setNegativeButton(R.string.start_over, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								reset();
							}
						});
				
						builder.create().show();
					}
				
					private void checkAnswer() {
						String response_user="000000";
						if(type==0){
							int id = radio_group.getCheckedRadioButtonId();
							for(int i =0; i<ids_answers_radio.length ;i++){
								if(ids_answers_radio[i]==id){
									char[] aux=response_user.toCharArray();
									aux[i]='1';
									response_user=new String(aux);
								}
							}
						}
						else if(type==1){
							for(int i =0; i<ids_answers_check.length ;i++){
								CheckBox auxCB=(CheckBox) findViewById(ids_answers_check[i]);
								if(auxCB.isChecked()){
									char[] aux=response_user.toCharArray();
									aux[i]='1';
									response_user=new String(aux);
								}
							}
						}
						else if(type==2){
							int id = radio_true_false.getCheckedRadioButtonId();
							for(int i =0; i<ids_answers_false_true.length ;i++){
								if(ids_answers_false_true[i]==id){
									char[] aux=response_user.toCharArray();
									aux[i]='1';
									response_user=new String(aux);
								}
							}
						}
						else if(type==3){
							for(int i =0; i<n_answers ;i++){
								char[] aux=response_user.toCharArray();
								Spinner sp=(Spinner) findViewById(ids_answer_desplegable_spinner[i]);
								aux[i]=Character.forDigit(sp.getSelectedItemPosition(),10);
								response_user=new String(aux);
							}
						}
						answer_is_correct[current_question]=(response_user.equals(correct_answer));
						user_all_answers[current_question]=response_user;
					}
				
					private void showQuestion() {
						String q = all_questions[current_question];
						//Partimos el string con la pregunta y respuestas en trozos
						String[] parts = q.split(";");
						text_question.setText(parts[1]);
						text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
						if(parts[0].charAt(0)=='0'){
							type=0;
							radio_group.setVisibility(View.VISIBLE);
							for(int i=0;i<ids_answers_radio.length;i++){
								RadioButton rb = (RadioButton) findViewById(ids_answers_radio[i]);
								rb.setVisibility(View.GONE);
							}
							for(int i =0;i<ids_answers_check.length;i++){
								CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);
								cb.setVisibility(View.GONE);
							}
							for(int i = 0;i<ids_answer_desplegable.length;i++){
								LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);
								ll.setVisibility(View.GONE);
							}
								radio_true_false.setVisibility((View.GONE));
								radio_group.clearCheck();
					
								int correct= Integer.parseInt(parts[3]);
								correct_answer="000000";
								char[] aux=correct_answer.toCharArray();
								aux[correct]='1';
								correct_answer=new String(aux);
					
								int num_answers= Integer.parseInt(parts[2]);
								for(int i =0; i<num_answers;i++){
									RadioButton rb = (RadioButton) findViewById(ids_answers_radio[i]);
									rb.setVisibility(View.VISIBLE);
					
					
									//Reescalamos la imagen
									Drawable img2 = rb.getContext().getResources().getDrawable( statementsAnswers.get(current_question).get(i));
									Bitmap b = ((BitmapDrawable)img2).getBitmap();
									Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth()/2, b.getHeight()/2, true));
									Bitmap b2 =((BitmapDrawable)d).getBitmap();
									
									rb.setCompoundDrawablesWithIntrinsicBounds( null, null, null, new BitmapDrawable(getResources(), b2));
									if(user_all_answers[current_question].charAt(i)=='1'){
										rb.setChecked(true);
									}
								}
							}else if(parts[0].charAt(0)=='1'){
							type=1;
							radio_group.setVisibility(View.GONE);
							radio_true_false.setVisibility((View.GONE));
							for(int i =0;i<ids_answers_check.length;i++){
								CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);
								cb.setVisibility(View.GONE);
							}
							for(int i = 0;i<ids_answer_desplegable.length;i++){
								LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);
								ll.setVisibility(View.GONE);
							}
							correct_answer="000000";
							Drawable img2=text_question.getContext().getResources().getDrawable(statements.get(current_question));
							Bitmap b = ((BitmapDrawable)img2).getBitmap();
							Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth()/2, b.getHeight()/2, true));
							Bitmap b2 =((BitmapDrawable)d).getBitmap();
							text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,new BitmapDrawable(getResources(), b2));
							for(int i =0; i<parts.length-2;i++){
								CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);
								cb.setVisibility(View.VISIBLE);
								String answer = parts[i+2];
								answer= answer.substring(1);
								if(answer.charAt(0)=='*'){
									char[] aux=correct_answer.toCharArray();
									aux[i]='1';
									correct_answer=new String(aux);
									answer= answer.substring(1);
								}
								else{
									char[] aux=correct_answer.toCharArray();
									aux[i]='0';
									correct_answer=new String(aux);
								}
								cb.setText(answer);
								if(user_all_answers[current_question].charAt(i)=='1'){
									cb.setChecked(true);
								}
								else{
									cb.setChecked(false);
								}
							}
						}else if (parts[0].charAt(0) == '2') {
							type = 2;
							radio_group.setVisibility(View.GONE);
							radio_true_false.setVisibility((View.VISIBLE));
							for(int i =0;i<ids_answers_check.length;i++){
								CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);
								cb.setVisibility(View.GONE);
							}
							for(int i = 0;i<ids_answer_desplegable.length;i++){
								LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);
								ll.setVisibility(View.GONE);
							}
							correct_answer = "000000";
							radio_true_false.clearCheck();
							Drawable img2 = text_question.getContext().getResources().getDrawable(statements.get(current_question));
							Bitmap b = ((BitmapDrawable) img2).getBitmap();
							Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth() / 2, b.getHeight() / 2, true));
							Bitmap b2 = ((BitmapDrawable) d).getBitmap();
							text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, new BitmapDrawable(getResources(), b2));
							for (int i = 0; i < parts.length - 2; i++) {
								RadioButton rb = (RadioButton) findViewById(ids_answers_false_true[i]);
								String answer = parts[i+2];
								if (answer.charAt(0) == '*') {
									char[] aux = correct_answer.toCharArray();
									aux[i] = '1';
									correct_answer = new String(aux);
									answer = answer.substring(1);
								}
								else {
									char[] aux = correct_answer.toCharArray();
									aux[i] = '0';
									correct_answer = new String(aux);
								}
								rb.setText(answer);
								if (user_all_answers[current_question].charAt(i) == '1'){
									rb.setChecked(true);
								}
							}
						}
						else if(parts[0].charAt(0) == '3'){
							type = 3;
							radio_group.setVisibility(View.GONE);
							radio_true_false.setVisibility((View.GONE));
							for(int i =0;i<ids_answers_check.length;i++){
								CheckBox cb = (CheckBox) findViewById(ids_answers_check[i]);
								cb.setVisibility(View.GONE);
							}
							for(int i = 0;i<ids_answer_desplegable.length;i++){
								LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);
								ll.setVisibility(View.GONE);
							}
							correct_answer = "000000";
							radio_true_false.clearCheck();
							Drawable img2 = text_question.getContext().getResources().getDrawable(statements.get(current_question));
							Bitmap b = ((BitmapDrawable) img2).getBitmap();
							Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(b, b.getWidth() / 2, b.getHeight() / 2, true));
							Bitmap b2 = ((BitmapDrawable) d).getBitmap();
							text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, new BitmapDrawable(getResources(), b2));
							ArrayList<String> optionsaux=new ArrayList<>();
							optionsaux.add(getResources().getString(R.string.choose_option));
							ArrayList<String> spinners = new ArrayList<>();
							ArrayList<Character> solutions = new ArrayList<>();
							for (int i = 0; i < parts.length - 2; i++){
								String answer = parts[i+2];
								if(answer.charAt(1)!='*'){
									optionsaux.add(answer+"\n");
								}
								else {
									spinners.add(answer.substring(3));
									solutions.add(Character.forDigit(Integer.parseInt(String.valueOf(answer.charAt(2)))+1,10));
								}
							}
							ArrayAdapter<String> options= new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,optionsaux);
							for (int i = 0; i < spinners.size(); i++){
								LinearLayout ll=(LinearLayout) findViewById(ids_answer_desplegable[i]);
								ll.setVisibility(View.VISIBLE);
								Spinner sp = (Spinner) findViewById(ids_answer_desplegable_spinner[i]);
								TextView tx=(TextView) findViewById(ids_answer_desplegable_text[i]);
								String answer = spinners.get(i);
								tx.setText(answer+"\n");
								options.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
								sp.setAdapter(options);
								char[] aux=correct_answer.toCharArray();
								aux[i]=solutions.get(i);
								correct_answer=new String(aux);
								if (user_all_answers[current_question].charAt(i) != '0'){
									int selected=Integer.parseInt(String.valueOf(user_all_answers[current_question].charAt(i)));
									sp.setSelection(selected);
								}
							}
							n_answers=spinners.size();
						}
						else{
							btn_next.callOnClick();
						}
						if (current_question == 0) {
							btn_previous.setVisibility(View.GONE);
						} else {
							btn_previous.setVisibility(View.VISIBLE);
						}
						if (current_question == all_questions.length - 1) {
							btn_next.setText(R.string.finish);
						} else {
							btn_next.setText(R.string.next);
						}
					}
				}
	'''

	/*local.properties code will be generated here!!*/
	def localPropertiesCompile(Program program, Resource resource) '''
## This file must *NOT* be checked into Version Control Systems,
# as it contains information specific to your local configuration.
#
# Location of the SDK. This is only used by Gradle.
# For customization when using a Version Control System, please read the
# header note.
#«currentDate»
sdk.dir=«userProfile»AppData\\Local\\Android\\Sdk
	'''

	/*XML MobileApp code will be generated here!!*/
	def xmlCompile(Program program, Resource resource) '''
		<?xml version="1.0" encoding="utf-8"?>
		<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
		    xmlns:app="http://schemas.android.com/apk/res-auto"
		    xmlns:tools="http://schemas.android.com/tools"
		    android:layout_width="match_parent"
		    android:layout_height="wrap_content"
		    tools:context=".MainActivity">
		<!--«var boolean true_false_questions = false»-->
		<!--«var boolean single_option_questions = false»-->
		<!--«var boolean multiple_option_questions = false»-->
		«FOR exercise : program.exercises»
			«IF exercise instanceof AlternativeResponse»
			«FOR test : exercise.tests»
			«IF rand.get(exercise).get(test).size() > 0»
			«{true_false_questions = true; ""}»
			«ENDIF»
			«ENDFOR»
			«ENDIF»
	    	«IF exercise instanceof MultiChoiceDiagram»
			«FOR test : exercise.tests»
	        «IF diagrams.get(exercise).get(test).size() > 0»
			«{single_option_questions = true; ""}»
	        «ENDIF»
	        «ENDFOR»
	        «ENDIF»
	    	«IF exercise instanceof MultiChoiceEmendation»
			«FOR test : exercise.tests»
			«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
			«{multiple_option_questions = true; ""}»
	        «ENDIF»
	        «ENDFOR»
	        «ENDIF»
		«ENDFOR»
		
		    <ScrollView
		                android:layout_width="match_parent"
		                android:layout_height="match_parent">
		        
		                <LinearLayout
		                    android:layout_width="match_parent"
		                    android:layout_height="wrap_content"
		                    android:orientation="vertical">
		        
		                    <TextView
		                        android:id="@+id/text_question"
		                        android:layout_width="match_parent"
		                        android:layout_height="190dp"
		                        android:text="TextView"
		                        android:textColor="?android:attr/textColorPrimary"
		                        android:textSize="18sp" />
		        
		                    <View
		                        android:id="@+id/ruler"
		                        android:layout_width="match_parent"
		                        android:layout_height="1dp"
		                        android:layout_below="@id/text_question"
		                        android:background="#070707"
		                        tools:ignore="MissingConstraints" />
		        
		                    <CheckBox
		                        android:id="@+id/check_box1"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="CheckBox"
		                        tools:visibility="gone" />
		        
		                    <CheckBox
		                        android:id="@+id/check_box2"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="CheckBox"
		                        tools:visibility="gone" />
		        
		                    <CheckBox
		                        android:id="@+id/check_box3"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="CheckBox"
		                        tools:visibility="gone" />
		        
		                    <CheckBox
		                        android:id="@+id/check_box4"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="CheckBox"
		                        tools:visibility="gone" />
		                    <CheckBox
		                        android:id="@+id/check_box5"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="CheckBox"
		                        tools:visibility="gone" />
		                    <CheckBox
		                        android:id="@+id/check_box6"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="CheckBox"
		                        tools:visibility="gone" />
		        
		                    <RadioGroup
		                        android:id="@+id/answer_true_false"
		                        android:layout_width="match_parent"
		                        android:layout_height="188dp"
		                        android:visibility="gone">
		        
		        
		                        <RadioButton
		                            android:id="@+id/true_solution"
		                            android:layout_width="match_parent"
		                            android:layout_height="wrap_content"
		                            android:text="True" />
		        
		                        <RadioButton
		                            android:id="@+id/false_solution"
		                            android:layout_width="match_parent"
		                            android:layout_height="wrap_content"
		                            android:text="False" />
		                    </RadioGroup>
		        
		                    <RadioGroup
		                        android:id="@+id/answer_group"
		                        android:layout_width="match_parent"
		                        android:layout_height="match_parent"
		                        android:visibility="visible">
		        
		        
		                        <RadioButton
		                            android:id="@+id/answer1"
		                            android:layout_width="match_parent"
		                            android:layout_height="wrap_content"
		                            android:text=" " />
		        
		                        <RadioButton
		                            android:id="@+id/answer2"
		                            android:layout_width="match_parent"
		                            android:layout_height="wrap_content"
		                            android:text=" " />
		        
		                        <RadioButton
		                            android:id="@+id/answer3"
		                            android:layout_width="match_parent"
		                            android:layout_height="wrap_content"
		                            android:text=" " />
		        
		                        <RadioButton
		                            android:id="@+id/answer4"
		                            android:layout_width="wrap_content"
		                            android:layout_height="wrap_content"
		                            android:text=" " />
		                            
		    					<RadioButton
		    						android:id="@+id/answer5"
		    						android:layout_width="wrap_content"
		    						android:layout_height="wrap_content"
		    						android:text=" " />
		                            		                        
		    					<RadioButton
		    						android:id="@+id/answer6"
		    						android:layout_width="wrap_content"
		    						android:layout_height="wrap_content"
		    						android:text=" " />
		        
		                    </RadioGroup>
		                    <LinearLayout
		    					android:id="@+id/desplegables"
		    					android:layout_width="match_parent"
		    					android:layout_height="wrap_content"
		    					android:orientation="vertical"
		    					android:visibility="visible">
		    					<LinearLayout
		    						android:id="@+id/desplegable1"
		    						android:layout_width="match_parent"
		    						android:layout_height="wrap_content"
		    						android:orientation="horizontal"
		    						android:layout_weight="2"
		    						android:weightSum="2">
		    						<TextView
		    						    android:id="@+id/desplegable_text1"
		    						    android:layout_width="match_parent"
		    						    android:layout_height="wrap_content"
		    						    android:layout_weight="1"
		    						    android:text="TextView"
		    						    android:textColor="?android:attr/textColorPrimary"
		    						    android:textSize="16sp" />
		    						<Spinner
		    					        android:id="@+id/desplegable_spinner1"
		    					        android:layout_width="match_parent"
		    					        android:layout_height="wrap_content"
		    					        android:layout_weight="1">
		    					    </Spinner>
		    					</LinearLayout>
		    					<LinearLayout
		    					    android:id="@+id/desplegable2"
		    					    android:layout_width="match_parent"
		    					    android:layout_height="wrap_content"
		    					    android:orientation="horizontal"
		    					    android:layout_weight="2"
		    				        android:weightSum="2">
		    				        <TextView
		    				            android:id="@+id/desplegable_text2"
		    				            android:layout_width="match_parent"
		    				            android:layout_height="wrap_content"
		    				            android:layout_weight="1"
		    				            android:text="TextView"
		    				            android:textColor="?android:attr/textColorPrimary"
		    				            android:textSize="16sp" />
		    				        <Spinner
		    				            android:id="@+id/desplegable_spinner2"
		    				            android:layout_width="match_parent"
		    				            android:layout_height="wrap_content"
		    				            android:layout_weight="1">
		    				        </Spinner>
		    				    </LinearLayout>
		    				    <LinearLayout
		    				        android:id="@+id/desplegable3"
		    				        android:layout_width="match_parent"
		    				        android:layout_height="wrap_content"
		    				        android:orientation="horizontal"
		    				        android:layout_weight="2"
		    				        android:weightSum="2">
		    				        <TextView
		    				            android:id="@+id/desplegable_text3"
		    				            android:layout_width="match_parent"
		    				            android:layout_height="wrap_content"
		    				            android:layout_weight="1"
		    				            android:text="TextView"
		    				            android:textColor="?android:attr/textColorPrimary"
		    				            android:textSize="16sp" />
		    				        <Spinner
		    				            android:id="@+id/desplegable_spinner3"
		    				            android:layout_width="match_parent"
		    				            android:layout_height="wrap_content"
		    				            android:layout_weight="1">
		    				        </Spinner>
		    				    </LinearLayout>
		    				    <LinearLayout
		    				        android:id="@+id/desplegable4"
		    				        android:layout_width="match_parent"
		    				        android:layout_height="wrap_content"
		    				        android:orientation="horizontal"
		    				        android:layout_weight="2"
		    				        android:weightSum="2">
		    				        <TextView
		    				            android:id="@+id/desplegable_text4"
		    				            android:layout_width="match_parent"
		    				            android:layout_height="wrap_content"
		    				            android:layout_weight="1"
		    				            android:text="TextView"
		    				            android:textColor="?android:attr/textColorPrimary"
		    				            android:textSize="16sp" />
		    				        <Spinner
		    				            android:id="@+id/desplegable_spinner4"
		    				            android:layout_width="match_parent"
		    				            android:layout_height="wrap_content"
		    				            android:layout_weight="1">
		    				        </Spinner>
		    				    </LinearLayout>
		    				
		    				</LinearLayout>
		        
		                    <Button
		                        android:id="@+id/btn_check"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="@string/next" />
		        
		                    <Button
		                        android:id="@+id/btn_previous"
		                        android:layout_width="wrap_content"
		                        android:layout_height="wrap_content"
		                        android:text="@string/previous" />
		        
		        
		                </LinearLayout>
		            </ScrollView>
		        
		        </androidx.constraintlayout.widget.ConstraintLayout>
	'''

	/*String values XML MobileApp code will be generated here!!*/
	def stringXmlCompile(Program program, Resource resource) '''
		<resources>
			<string name="app_name">esquemaTFG</string>
			<string name="question">Question</string>
			<string name="check">Check</string>
			<string name="next">Next</string>
			<string name="finish">Finish</string>
			<string name="previous">Previous</string>
			<string name="results">Results</string>
			<string name="start_over">Reset</string>
			<string name="choose_option">Choose</string>
			<array name="all_questions">
			«FOR exercise : program.exercises»
				«IF exercise instanceof AlternativeResponse»
					«FOR test : exercise.tests»
						«IF rand.get(exercise).get(test).size() > 0»
							<!--«var diagram = rand.get(exercise).get(test).get(0)»-->
							«IF diagram.equals(test.source.replace('.model', '.png'))»
								<item>2;«test.question.replace("\"", "'").replace("'", "")»;*True;False</item>
							«ELSE»
								<item>2;«test.question.replace("\"", "'").replace("'", "")»;True;*False</item>
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				«ENDIF»
				«IF exercise instanceof MultiChoiceDiagram»
					«FOR test : exercise.tests»
					«var int i=0»
					«var int correct=i»
					«FOR diagram : diagrams.get(exercise).get(test)»«IF diagram.equals(test.source.replace('.model', '.png'))»
							«{correct=i; ""}»
						«ENDIF»
						«{i++; ""}»
					«ENDFOR»
						<item>0;«test.question.replace("\"", "'").replace("'", "")»;«i»;«correct»</item>
						<!--<tipo;pregunta;n_respuesta;respues_correcta>-->
					«ENDFOR»
				«ENDIF»
				«IF exercise instanceof MultiChoiceEmendation»
					<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->
					«FOR test : exercise.tests»
						<item>1;
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							«test.question.replace("\"", "'").replace("'", "")»;
						«ENDIF»
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							«var counter = 0»
							«var List<SimpleEntry<String, Boolean>> textOptions = new ArrayList<SimpleEntry<String, Boolean>>()»
							«FOR opt : options.get(exercise).get(test)»
								«FOR String key : opt.text.keySet()»
									«FOR String text : opt.text.get(key)»
										«var boolean found = false»
										«FOR SimpleEntry<String, Boolean> entry : textOptions»
											«IF entry.getKey().equals(text)»
												«{found = true; ""}»
											«ENDIF»
										«ENDFOR»
										«IF found == false»
											«{counter ++; ""}»
											«{textOptions.add(new SimpleEntry<String, Boolean>(text, false)); ""}»
										«ENDIF»
									«ENDFOR»
								«ENDFOR»
							«ENDFOR»
						«ENDIF»
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							<!--«var String diagram = ''»-->
							«IF (options.get(exercise).get(test) !== null)»
								«FOR opt : options.get(exercise).get(test)»
									«IF opt.text.size > 0»
										<!--«diagram = opt.path»-->
									«ENDIF»
								«ENDFOR»
							«ENDIF»
							«IF !diagram.equals('')»
								«IF (options.get(exercise).get(test) !== null)»
									«FOR opt : options.get(exercise).get(test)»
										«var List<String> textOptions = new ArrayList<String>()»
						          		«IF opt.text.size > 0»
					          				«FOR String key : opt.text.keySet()»
					          					«FOR String text : opt.text.get(key)»
					          						«IF !textOptions.contains(text)»
					                					«{textOptions.add(text); ""}»
					          						«ENDIF»
					          					«ENDFOR»
					          				«ENDFOR»
						          		«ENDIF»
									«ENDFOR»
									«FOR opt : options.get(exercise).get(test)»
										«IF opt.solution == true»
							          		«IF opt.text.size > 0»
							          			«FOR String key : opt.text.keySet()»
		          			          				«FOR String text : opt.text.get(key)»
							*«text.trim()»;
		          			          				«ENDFOR»
		          			          			«ENDFOR»
							          		«ENDIF»
							          	«ENDIF»
							          	«IF opt.solution == false»
							          		«IF opt.text.size > 0»
							          			«FOR String key : opt.text.keySet()»
		          			          				«FOR String text : opt.text.get(key)»
							«text.trim()»;
		          			          				«ENDFOR»
		          			          			«ENDFOR»
							          		«ENDIF»
							          	«ENDIF»
									«ENDFOR»
								«ENDIF»
							«ENDIF»
						«ENDIF»
						</item>
					«ENDFOR»
				«ENDIF»
				«IF exercise instanceof MatchPairs»
					«var int min = Integer.MAX_VALUE»
			        «var int index = 0»
			        «var int max = Integer.MIN_VALUE»
					«FOR test : exercise.tests»
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							<item>3;Match the correct option on the right with each of the statements on the left;
							«var List<String> textOptions = new ArrayList<String>()»
							«var int k = 0»
							«var int counter = 0»
							«FOR TestOption opt : options.get(exercise).get(test)»
								«FOR String key : opt.text.keySet()»
			         				«FOR String text : opt.text.get(key)»
										«IF !textOptions.contains(text)»
											«{counter++; ""}»
											«text»;
											«{textOptions.add(text);""}»
										«ENDIF»
									«ENDFOR»
								«ENDFOR»
							«ENDFOR»
							«IF counter > max»
								«{max = counter; ""}»
								«{index = k; ""}»
							«ENDIF»
							«{k++; ""}»
							«var TreeMap<Integer, SimpleEntry<String, String>> entries = new TreeMap<Integer, SimpleEntry<String, String>>()»
							«FOR TestOption op : options.get(exercise).get(test)»
								«IF test.expression == true»
									«var String key = getText(test.identifier, op.entry.getKey().getURI().toFileString(), resource)»
									«IF key.length() <= 36»
										«var boolean found = false»
										«FOR int length : entries.keySet()»
											«var SimpleEntry<String, String> entry = entries.get(length)»
											«IF entry.getValue().equals(key)»
												«{found = true; ""}»
											«ENDIF»
										«ENDFOR»
										«IF found == false»
											«var SimpleEntry<String, String> entry = new SimpleEntry<String, String>(key, op.text.get(op.text.keySet().get(index)).get(index).trim())»
											«{entries.put(key.length,  entry); ""}»
										«ENDIF»
									«ENDIF»
								«ENDIF»
							«ENDFOR»
							«var String question = test.question.replace("\"", "'")»
							«var int counter2 = 0»
							«FOR int length : entries.keySet()»
								«IF counter2 < min»
									«var SimpleEntry<String, String> entry = entries.get(length)»
									«FOR int i : 0..textOptions.size-1»
										«IF textOptions.get(i).substring(0,textOptions.get(i).length-1).equals(entry.getValue())»
*«i»«question + entry.getKey()»;
										«ENDIF»
									«ENDFOR»
								«ENDIF»
							«ENDFOR»
</item>
						«ENDIF»
		        	«ENDFOR»
					
					
				«ENDIF»
			«ENDFOR»
			</array>
		</resources>
    '''

	/*String values XML MobileApp code will be generated here!!*/
	def stringXmlCompileEs(Program program, Resource resource) '''
		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<string name="app_name">esquemaTFG</string>
			<string name="question">Pregunta</string>
			<string name="check">Comprobar</string>
			<string name="next">Continuar</string>
			<string name="finish">Acabar</string>
			<string name="previous">Anterior</string>
			<string name="results">Resultados</string>
			<string name="start_over">Reintentar</string>
			<string name="choose_option">Elegir</string>
			<array name="all_questions">
			«FOR exercise : program.exercises»
				«IF exercise instanceof AlternativeResponse»
					«FOR test : exercise.tests»
						«IF rand.get(exercise).get(test).size() > 0»
							<!--«var diagram = rand.get(exercise).get(test).get(0)»-->
							«IF diagram.equals(test.source.replace('.model', '.png'))»
								<item>2;«test.question.replace("\"", "'").replace("'", "")»;*True;False</item>
							«ELSE»
								<item>2;«test.question.replace("\"", "'").replace("'", "")»;True;*False</item>
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				«ENDIF»
				«IF exercise instanceof MultiChoiceDiagram»
					«FOR test : exercise.tests»
					«var int i=0»
					«var int correct=i»
					«FOR diagram : diagrams.get(exercise).get(test)»«IF diagram.equals(test.source.replace('.model', '.png'))»
							«{correct=i; ""}»
						«ENDIF»
						«{i++; ""}»
					«ENDFOR»
						<item>0;«test.question.replace("\"", "'").replace("'", "")»;«i»;«correct»</item>
						<!--<tipo;pregunta;n_respuesta;respues_correcta>-->
					«ENDFOR»
				«ENDIF»
				«IF exercise instanceof MultiChoiceEmendation»
					<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->
					«FOR test : exercise.tests»
						<item>1;
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							«test.question.replace("\"", "'").replace("'", "")»;
						«ENDIF»
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							«var counter = 0»
							«var List<SimpleEntry<String, Boolean>> textOptions = new ArrayList<SimpleEntry<String, Boolean>>()»
							«FOR opt : options.get(exercise).get(test)»
								«FOR String key : opt.text.keySet()»
									«FOR String text : opt.text.get(key)»
										«var boolean found = false»
										«FOR SimpleEntry<String, Boolean> entry : textOptions»
											«IF entry.getKey().equals(text)»
												«{found = true; ""}»
											«ENDIF»
										«ENDFOR»
										«IF found == false»
											«{counter ++; ""}»
											«{textOptions.add(new SimpleEntry<String, Boolean>(text, false)); ""}»
										«ENDIF»
									«ENDFOR»
								«ENDFOR»
							«ENDFOR»
						«ENDIF»
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							<!--«var String diagram = ''»-->
							«IF (options.get(exercise).get(test) !== null)»
								«FOR opt : options.get(exercise).get(test)»
									«IF opt.text.size > 0»
										<!--«diagram = opt.path»-->
									«ENDIF»
								«ENDFOR»
							«ENDIF»
							«IF !diagram.equals('')»
								«IF (options.get(exercise).get(test) !== null)»
									«FOR opt : options.get(exercise).get(test)»
										«var List<String> textOptions = new ArrayList<String>()»
						          		«IF opt.text.size > 0»
					          				«FOR String key : opt.text.keySet()»
					          					«FOR String text : opt.text.get(key)»
					          						«IF !textOptions.contains(text)»
					                					«{textOptions.add(text); ""}»
					          						«ENDIF»
					          					«ENDFOR»
					          				«ENDFOR»
						          		«ENDIF»
									«ENDFOR»
									«FOR opt : options.get(exercise).get(test)»
										«IF opt.solution == true»
							          		«IF opt.text.size > 0»
							          			«FOR String key : opt.text.keySet()»
		          			          				«FOR String text : opt.text.get(key)»
							*«text.trim()»;
		          			          				«ENDFOR»
		          			          			«ENDFOR»
							          		«ENDIF»
							          	«ENDIF»
							          	«IF opt.solution == false»
							          		«IF opt.text.size > 0»
							          			«FOR String key : opt.text.keySet()»
		          			          				«FOR String text : opt.text.get(key)»
							«text.trim()»;
		          			          				«ENDFOR»
		          			          			«ENDFOR»
							          		«ENDIF»
							          	«ENDIF»
									«ENDFOR»
								«ENDIF»
							«ENDIF»
						«ENDIF»
						</item>
					«ENDFOR»
				«ENDIF»
				«IF exercise instanceof MatchPairs»
					«var int min = Integer.MAX_VALUE»
			        «var int index = 0»
			        «var int max = Integer.MIN_VALUE»
					«FOR test : exercise.tests»
						«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
							<item>3;Match the correct option on the right with each of the statements on the left;
							«var List<String> textOptions = new ArrayList<String>()»
							«var int k = 0»
							«var int counter = 0»
							«FOR TestOption opt : options.get(exercise).get(test)»
								«FOR String key : opt.text.keySet()»
			         				«FOR String text : opt.text.get(key)»
										«IF !textOptions.contains(text)»
											«{counter++; ""}»
											«text»;
											«{textOptions.add(text);""}»
										«ENDIF»
									«ENDFOR»
								«ENDFOR»
							«ENDFOR»
							«IF counter > max»
								«{max = counter; ""}»
								«{index = k; ""}»
							«ENDIF»
							«{k++; ""}»
							«var TreeMap<Integer, SimpleEntry<String, String>> entries = new TreeMap<Integer, SimpleEntry<String, String>>()»
							«FOR TestOption op : options.get(exercise).get(test)»
								«IF test.expression == true»
									«var String key = getText(test.identifier, op.entry.getKey().getURI().toFileString(), resource)»
									«IF key.length() <= 36»
										«var boolean found = false»
										«FOR int length : entries.keySet()»
											«var SimpleEntry<String, String> entry = entries.get(length)»
											«IF entry.getValue().equals(key)»
												«{found = true; ""}»
											«ENDIF»
										«ENDFOR»
										«IF found == false»
											«var SimpleEntry<String, String> entry = new SimpleEntry<String, String>(key, op.text.get(op.text.keySet().get(index)).get(index).trim())»
											«{entries.put(key.length,  entry); ""}»
										«ENDIF»
									«ENDIF»
								«ENDIF»
							«ENDFOR»
							«var String question = test.question.replace("\"", "'")»
							«var int counter2 = 0»
							«FOR int length : entries.keySet()»
								«IF counter2 < min»
									«var SimpleEntry<String, String> entry = entries.get(length)»
									«FOR int i : 0..textOptions.size-1»
										«IF textOptions.get(i).substring(0,textOptions.get(i).length-1).equals(entry.getValue())»
*«i»«question + entry.getKey()»;
										«ENDIF»
									«ENDFOR»
								«ENDIF»
							«ENDFOR»
</item>
						«ENDIF»
		        	«ENDFOR»
					
					
				«ENDIF»
			«ENDFOR»
			</array>
		</resources>
    '''
}