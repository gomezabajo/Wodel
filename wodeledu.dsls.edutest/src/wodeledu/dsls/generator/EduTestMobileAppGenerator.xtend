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
		//«var List<String> drawable = new ArrayList<String>()»
		//«var int i = 0»
		«FOR exercise : program.exercises»
			«IF exercise instanceof AlternativeResponse»
			«FOR test : exercise.tests»
			«IF rand.get(exercise).get(test).size() > 0»
			//«var diagram = rand.get(exercise).get(test).get(0)»
			//«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram), new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/mobile/app/src/main/res/drawable/q" + i + "_enunciado.png"))»
			//«drawable.add("q" + i + "_enunciado.png")»
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
		import android.content.res.Resources;
		import android.graphics.Bitmap;
		import android.graphics.BitmapFactory;
		import android.graphics.drawable.BitmapDrawable;
		import android.graphics.drawable.Drawable;
		import android.media.Image;
		import android.os.Bundle;
		import android.util.DisplayMetrics;
		import android.util.Log;
		import android.view.View;
		import android.widget.Button;
		import android.widget.CheckBox;
		import android.widget.ImageView;
		import android.widget.RadioButton;
		import android.widget.RadioGroup;
		import android.widget.TextView;
		
		import java.io.FileOutputStream;
		import java.io.IOException;
		import java.io.InputStream;
		import java.net.HttpURLConnection;
		import java.net.URL;
		import java.net.URLConnection;
		
		public class MainActivity extends AppCompatActivity {
		
            private int ids_answers_false_true[] = {
                R.id.true_solution, R.id.false_solution
            };
            
           	«IF drawable.size() > 0»
            private int statements[] = {
            	«{i = 0; ""}»
            	«FOR String d : drawable»
            	«IF i < drawable.size() - 1»
            	R.drawable.q«i»_enunciado,
            	«{i++; ""}» 
            	«ENDIF»
            	«ENDFOR»
            	R.drawable.q«i»_enunciado
            };
           	«ENDIF»

            private String[] all_questions;
            private TextView text_question;
            private RadioGroup radio_true_false;
            private Button btn_next, btn_previous;

            private int type = -1;
            private String correct_answer;
            private int current_question;
            private boolean[] answer_is_correct;
            private String[] user_all_answers;
            private int current_statement = 0;

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
                radio_true_false = (RadioGroup) findViewById(R.id.answer_true_false);
                btn_next = (Button) findViewById(R.id.btn_check);
                btn_previous = (Button) findViewById(R.id.btn_previous);

                all_questions = getResources().getStringArray(R.array.all_questions);

                correct_answer = "0000";
                if (savedInstanceState == null){
                   reset();
                }
                else {
                   correct_answer = savedInstanceState.getString("correct_answer");
                   current_question = savedInstanceState.getInt("current_question");
                   answer_is_correct = savedInstanceState.getBooleanArray("answer_is_correct");
                   user_all_answers = savedInstanceState.getStringArray("user_all_answers");
                   showQuestion();
               }

               btn_next.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       checkAnswer();
                       current_statement = current_statement < statements.length - 1 ? current_statement + 1 : statements.length - 1;
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
                       current_statement = current_statement > 0 ? current_statement - 1 : 0;
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
               correct_answer = "0000";
               for (int i = 0; i < user_all_answers.length; i++) {
                   user_all_answers[i] = "0000";
               }
               current_question = 0;
               current_statement = 0;
               showQuestion();
            }

            private void checkResults() {
                int correctas = 0, incorrectas = 0, nocontestadas = 0;
                for (int i = 0; i < all_questions.length; i++) {
                    if (answer_is_correct[i]) correctas++;
                    else if (user_all_answers[i] == "0000") nocontestadas++;
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
               String response_user = "0000";
               if (type == 2) {
                   int id = radio_true_false.getCheckedRadioButtonId();
                   for (int i = 0; i < ids_answers_false_true.length; i++) {
                        if (ids_answers_false_true[i] == id) {
                            char[] aux = response_user.toCharArray();
                            aux[i] = '1';
                            response_user = new String(aux);
                        }
                   }
               }
               answer_is_correct[current_question] = (response_user.equals(correct_answer));
               user_all_answers[current_question] = response_user;
           }

           private void showQuestion() {
               String q = all_questions[current_question];
               //Partimos el string con la pregunta y respuestas en trozos
               String[] parts = q.split(";");
               text_question.setText(parts[1]);
               text_question.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
               «/* COMPLETAR PAR LOS OTROS DOS TIPOS DE PREGUNTAS */»
               if (parts[0].charAt(0) == '2') {
                   type = 2;
                   radio_true_false.setVisibility((View.VISIBLE));
                   correct_answer = "0000";
                   radio_true_false.clearCheck();
                   Drawable img2 = text_question.getContext().getResources().getDrawable(statements[current_statement]);
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
                       if (user_all_answers[current_question].charAt(i) == '1') {
                           rb.setChecked(true);
                       }
                   }
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

				<!--«var boolean visible = false»-->
		        <View
		                    android:id="@+id/ruler"
		                    android:layout_width="match_parent"
		                    android:layout_height="1dp"
		                    android:layout_below="@id/text_question"
		                    android:background="#070707"
		                    tools:ignore="MissingConstraints" />
				«IF true_false_questions == true»
				«IF visible == false»
				«{visible = true; ""}»
				«ENDIF»
				<RadioGroup
		                    android:id="@+id/answer_true_false"
		                    android:layout_width="match_parent"
		                    android:layout_height="188dp"
		        «IF visible == true»
		                    android:visibility="visible">
		        «ELSE»
		                    android:visibility="gone">
		        «ENDIF»
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
		        «ENDIF»

				«IF single_option_questions == true»
				«IF visible == false»
				«{visible = true; ""}»
				«ENDIF»
				<RadioGroup
		                    android:id="@+id/answer_group"
		                    android:layout_width="match_parent"
		                    android:layout_height="match_parent"
		        «IF visible == true»
		                    android:visibility="visible">
		        «ELSE»
		                    android:visibility="gone">
		        «ENDIF»
				<!--«/* completar si da tiempo: el numero de opciones puede ser variable  */»-->
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

		        </RadioGroup>
		        «ENDIF»

				«IF multiple_option_questions == true»
				«IF visible == false»
				«{visible = true; ""}»
				«ENDIF»
				<!--«/* completar si da tiempo: el numero de opciones puede ser variable  */»-->
                <CheckBox
		                    android:id="@+id/check_box1"
		                    android:layout_width="wrap_content"
		                    android:layout_height="wrap_content"
		                    android:text="CheckBox"
                «IF visible == true»
		                    tools:visibility="visible" />
		        «ELSE»
		                    tools:visibility="gone" />
		        «ENDIF»

                <CheckBox
		                    android:id="@+id/check_box2"
		                    android:layout_width="wrap_content"
		                    android:layout_height="wrap_content"
		                    android:text="CheckBox"
                «IF visible == true»
		                    tools:visibility="visible" />
		        «ELSE»
		                    tools:visibility="gone" />
		        «ENDIF»

                <CheckBox
		                    android:id="@+id/check_box3"
		                    android:layout_width="wrap_content"
		                    android:layout_height="wrap_content"
		                    android:text="CheckBox"
                «IF visible == true»
		                    tools:visibility="visible" />
		        «ELSE»
		                    tools:visibility="gone" />
		        «ENDIF»

                <CheckBox
		                    android:id="@+id/check_box4"
		                    android:layout_width="wrap_content"
		                    android:layout_height="wrap_content"
		                    android:text="CheckBox"
                «IF visible == true»
		                    tools:visibility="visible" />
		        «ELSE»
		                    tools:visibility="gone" />
		        «ENDIF»
		        «ENDIF»

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
				<!--«/* COMPLETAR */»-->
				<!--<item>0;Aqui iria el enunciado de la pregunta 1?(seleccion unica);Esta seria la opcion 1 e incorrecta;Esta seria la opcion 2 e incorrecta;*Esta seria la opcion 3 y correcta;Esta seria la opcion 4 e incorrecta</item>-->
				«ENDIF»
				«IF exercise instanceof MultiChoiceEmendation»
				<!--«/* COMPLETAR */»-->
				<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->
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
				<!--«/* COMPLETAR */»-->
				<!--<item>0;Aqui iria el enunciado de la pregunta 1?(seleccion unica);Esta seria la opcion 1 e incorrecta;Esta seria la opcion 2 e incorrecta;*Esta seria la opcion 3 y correcta;Esta seria la opcion 4 e incorrecta</item>-->
				«ENDIF»
				«IF exercise instanceof MultiChoiceEmendation»
				<!--«/* COMPLETAR */»-->
				<!--<item>1;Aqui iria el enunciado de la pregunta 2?(seleccion multiple);*Esta seria la opcion 1 y correcta;*Esta seria la opcion 2 y correcta;Esta seria la opcion 3 e incorrecta;Esta seria la opcion 4 e incorrecta</item>-->
				«ENDIF»
			«ENDFOR»
			</array>
		</resources>
    '''
}