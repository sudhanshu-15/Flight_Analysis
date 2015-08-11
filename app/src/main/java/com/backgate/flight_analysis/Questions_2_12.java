package com.backgate.flight_analysis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Questions_2_12 extends ActionBarActivity{

    String msg = "Android : ";

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event 12");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event 12");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event 12");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event 12");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event 12");
    }
    
    private TextView textView_Quest;
    private TextView textView_Option1;
    private TextView textView_Option2;
    private RadioButton button1;
    private RadioButton button2;
    private RadioGroup button_group;
    public String questions_mix[]=new String[15];
    public String questions_mix_1[]=new String[15];
    public String questions_mix_2[]=new String[15];
    public String question_val="-1";
    public int inc=-1;
    public String answers_all[]=new String[33];
    public String values_all[]=new String[33];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_2);
        Log.d(msg, "The onCreate() event 12");
        initializeVariables();
        questions_mix = getIntent().getStringArrayExtra("string-array");
        questions_mix_1 = getIntent().getStringArrayExtra("string-array-1");
        questions_mix_2 = getIntent().getStringArrayExtra("string-array-2");
        answers_all = getIntent().getStringArrayExtra("string-array-ans-text");
        values_all = getIntent().getStringArrayExtra("string-array-ans-vals");
        textView_Quest.setText(R.string.question_text);
        String opt_text_1=this.getString(R.string.option_text_1_12);
        button1.setText("\n"+"\n"+opt_text_1+"\n"+"\n");
        textView_Option1.setText(R.string.performance);
        String opt_text_2=this.getString(R.string.option_text_2_12);
        button2.setText("\n"+"\n"+opt_text_2+"\n"+"\n");
        textView_Option2.setText(R.string.mental_demand);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //button1.isChecked();
                button1.setChecked(true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                button2.setChecked(true);
            }
        });

        for(int i=0; i<15; i++){
            if("-1".equals(questions_mix_2[i])){
                question_val= questions_mix[i];
                inc= i;
                //System.out.println("You are at question_2_12 "+questions_mix[i]+", "+i);
                break;
            }
        }

        //System.out.println("You are at question_2_12 "+question_val+", "+inc);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        if(question_val.equals("-1")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(getApplicationContext(), Processing.class);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    //Intent myIntent = new Intent(Questions_2_12.this, Processing.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    ////finish();
                }
            });
        }

        if(question_val.equals("0")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_0.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("1")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_1.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("2")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_2.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("3")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_3.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("4")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_4.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("5")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_5.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("6")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_6.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("7")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_7.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("8")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_8.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("9")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_9.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("10")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_10.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("11")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_11.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("13")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_13.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }

        if(question_val.equals("14")) {
            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(Questions_2_12.this, Questions_2_14.class);
                    if (button1.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Performance";
                            }
                        }
                    } else if (button2.isChecked()) {
                        for (int i = 0; i < 33; i++) {
                            if ("perf_ment".equals(answers_all[i])) {
                                values_all[i] = "Mental Demand";
                            }
                        }
                    }
                    questions_mix_2[inc] = "1";
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    startActivity(myIntent);button1.setChecked(false);button2.setChecked(false);
                    //finish();
                }
            });
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            int process_id= android.os.Process.myPid();
            android.os.Process.killProcess(process_id);
        }

        return super.onOptionsItemSelected(item);
    }*/

    // A private method to help us initialize our variables.
    private void initializeVariables() {
        textView_Quest = (TextView) findViewById(R.id.question_text);
        textView_Option1 = (TextView) findViewById(R.id.option_1_text);
        textView_Option2 = (TextView) findViewById(R.id.option_2_text);
        button_group=(RadioGroup)findViewById(R.id.radioOptionGroup);
        button1= (RadioButton)findViewById(R.id.option_1);
        button2= (RadioButton)findViewById(R.id.option_2);
    }

}
