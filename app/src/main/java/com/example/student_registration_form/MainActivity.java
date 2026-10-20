package com.example.student_registration_form;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner_depart = findViewById(R.id.spinner_depart);
        EditText name = findViewById(R.id.s_name);
        EditText email = findViewById(R.id.s_email_add);
        EditText regNo = findViewById(R.id.s_reg_no);
        RadioGroup rgGender = findViewById(R.id.rg_gender);

        String[] departments = {
                "Select Department",
                "Computer Science",
                "Software Engineering",
                "Information Technology",
                "Cyber Security"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,departments);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner_depart.setAdapter(adapter);
        String studentName = name.getText().toString();
        String studentEmail = email.getText().toString();
        String studentRegNo = regNo.getText().toString();
        String studentDepart = spinner_depart.getSelectedItem().toString();
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        String gender = "";
        if(selectedGenderId != -1){
            RadioButton selectedGender = findViewById(selectedGenderId);
            gender = selectedGender.getText().toString();
        }
        Toast.makeText(
                this,
                "Name: " + studentName
                        + "\nEmail: " + studentEmail
                        + "\nReg No: " + studentRegNo
                        + "\nDepartment: " + studentDepart
                        + "\nGender: " + gender,
                Toast.LENGTH_LONG
        ).show();
    }
}