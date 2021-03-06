package com.backgate.flight_analysis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private Button button;
    private EditText subject_id_name;
    private EditText task_id_name;
    private EditText task_name;
    public String questions_mix[] = new String[15];
    public String questions_mix_1[] = new String[15];
    public String questions_mix_2[] = new String[15];
    public String answers_all[] = {"subject_id", "first_name", "middle_name", "last_name", "organisation", "task_id", "task_performed", "age", "gender", "height", "weight", "fly_exp",
            "mental_demand", "physical_demand", "temporal_demand", "performance", "effort", "frustration",
            "perf_frus", "temp_eff", "temp_ment", "ment_phy", "phy_temp", "frus_eff", "temp_frus", "phy_perf", "phy_frus",
            "eff_phy", "perf_temp", "ment_eff", "perf_ment", "eff_perf", "frus_ment"};
    public String values_all[]=new String[33];
    Random myRandom = new Random();
    String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
    public String filePath = baseDir + File.separator + "Task Load Analysis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int k=0; k<33; k++){
            values_all[k]="null";
        }
        for (int j = 0; j < 15; j++) {
            questions_mix[j] = "-1";
            questions_mix_1[j] = "-1";
            questions_mix_2[j] = "-1";
        }
        for (int i = 0; i < 15; i++) {
            int random_val_found = 0;
            String random_value = "null";
            while (random_val_found == 0) {
                random_value = String.valueOf(myRandom.nextInt(15));
                for (int j = 0; j < 15; j++) {
                    //random_value=String.valueOf(myRandom.nextInt(15));
                    if (random_value.equals(questions_mix[j])) {
                        random_val_found = 0;
                        break;
                    } else {
                        random_val_found = 1;
                    }
                }
            }
            questions_mix[i] = random_value;
            questions_mix_1[i] = "Questions_2_" + random_value;
        }
        initializeVariables();
        try{
            task_id_name.setText(this.getIntent().getStringExtra("TASK_ID"));
            task_name.setText(this.getIntent().getStringExtra("TASK_NAME"));
        }catch (Exception e){
            task_name.setText("");
            task_id_name.setText("");
        }
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        //Select a specific button to bundle it with the action you want
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(subject_id_name.getText()) == null || String.valueOf(subject_id_name.getText()).trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter the Subject ID.",
                            Toast.LENGTH_LONG).show();
                    subject_id_name.requestFocus();
                } else if ((String.valueOf(task_id_name.getText()) == null && String.valueOf(task_name.getText()) == null)
                        || (String.valueOf(task_id_name.getText()).trim().equals("") && String.valueOf(task_name.getText()).trim().equals(""))
                        || (String.valueOf(task_id_name.getText()).trim().equals("") && String.valueOf(task_name.getText()) == null)
                        || (String.valueOf(task_id_name.getText()) == null && String.valueOf(task_name.getText()).trim().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please enter either Task ID or Task Name.",
                            Toast.LENGTH_LONG).show();
                    task_id_name.requestFocus();
                } else {
                    Intent myIntent = new Intent(MainActivity.this, Optional_Activity.class);
                    for (int i = 0; i < 33; i++) {
                        if ("task_performed".equals(answers_all[i])) {
                            values_all[i] = String.valueOf(task_name.getText());
                        }
                        if ("subject_id".equals(answers_all[i])) {
                            values_all[i] = String.valueOf(subject_id_name.getText());
                        }
                        if ("task_id".equals(answers_all[i])) {
                            values_all[i] = String.valueOf(task_id_name.getText());
                        }
                    }
                    myIntent.putExtra("string-array", questions_mix);
                    myIntent.putExtra("string-array-1", questions_mix_1);
                    myIntent.putExtra("string-array-2", questions_mix_2);
                    myIntent.putExtra("string-array-ans-text", answers_all);
                    myIntent.putExtra("string-array-ans-vals", values_all);
                    MainActivity.this.startActivity(myIntent);
                    //finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_2, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        File dir = new File(filePath);
        if (!dir.exists()){
            menu.getItem(0).setEnabled(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_mail) {
            Intent myIntent = new Intent(MainActivity.this, Email_Options.class);
            MainActivity.this.startActivity(myIntent);
            finish();
            return true;
        }

        if (id == R.id.action_exit) {
            int process_id= android.os.Process.myPid();
            android.os.Process.killProcess(process_id);
        }

        return super.onOptionsItemSelected(item);
    }

    // A private method to help us initialize our variables.
    private void initializeVariables() {
        button = (Button) findViewById(R.id.next_button);
        task_name=(EditText)findViewById(R.id.task_value);
        subject_id_name=(EditText)findViewById(R.id.subject_id_value);
        task_id_name=(EditText)findViewById(R.id.task_id_value);
    }
}
