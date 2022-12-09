	//wodeledu.dsls.generator.EduTestSuperGenerator$TestOption@42b7c632
	//wodeledu.dsls.generator.EduTestSuperGenerator$TestOption@539ca894
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
		private HashMap<Integer, Integer> statements=new HashMap<Integer,Integer>(){{
            	put(2,R.drawable.q2_enunciado);
            	put(3,R.drawable.q3_enunciado);
            	put(4,R.drawable.q4_enunciado);
            	put(5,R.drawable.q5_enunciado);
		}};
private HashMap<Integer, HashMap<Integer,Integer>> statementsAnswers=new HashMap<Integer, HashMap<Integer,Integer>>(){{
	put(0,new HashMap<Integer,Integer>(){{
		put(0,R.drawable.q0_respuesta0);
		put(1,R.drawable.q0_respuesta1);
		put(2,R.drawable.q0_respuesta2);
		put(3,R.drawable.q0_respuesta3);
	}});
	put(1,new HashMap<Integer,Integer>(){{
		put(0,R.drawable.q1_respuesta0);
		put(1,R.drawable.q1_respuesta1);
		put(2,R.drawable.q1_respuesta2);
		put(3,R.drawable.q1_respuesta3);
	}});
}};

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
