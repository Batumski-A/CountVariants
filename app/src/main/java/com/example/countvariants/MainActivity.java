package com.example.countvariants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText GetN;
    Button SubmitB;
    TextView SendText;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetN = findViewById(R.id.Nnumber);
        SubmitB = findViewById(R.id.mSubmit);
        SendText = findViewById(R.id.GetHere);
        listView = findViewById(R.id.list_item);

            SubmitB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(GetN.getText().toString() != "") {
                        int a = Integer.parseInt(GetN.getText().toString());
                        int[][] array = countVariants(a);
                        String Text = "";
                        ArrayList<Step> StepList = new ArrayList<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (int i = 0; i < a / 2 + 1; i++) {
                            Step step = new Step(array[i][1], array[i][0]);
                            StepList.add(step);
                            Text = (i + 1) + ")" + "2 step: " + array[i][0] + " | 1 step: " + array[i][1] + "\n";
                            arrayList.add(Text);
                        }
                        SendText.setText("Max Charge" + String.valueOf((int) a / 2 + 1));
                        StepListAdapter stepListAdapter = new StepListAdapter(MainActivity.this, R.layout.list_adp, StepList);
                        listView.setAdapter(stepListAdapter);
                    }
                }

            });

    }

    public int[][] countVariants(int stearsCount){
        int[][] array = new int[stearsCount][2];
        for(int i=0;i<(int)(stearsCount/2)+1;i++){
            array[i][0] = (int)(stearsCount/2) - i;
            array[i][1] = (int)(stearsCount-((int)(stearsCount/2-i)*2));
        }

        return array;
    }

}
