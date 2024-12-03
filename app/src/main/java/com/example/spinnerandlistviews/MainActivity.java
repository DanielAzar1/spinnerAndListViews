package com.example.spinnerandlistviews;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{
    int classNum;
    ListView lv;
    Spinner sp;
    TextView LastNameTV, FirstNameTV, dobTV, phoneNumTV;

    String[] spinnerList= {"Choose class", "Class1", "Class2", "Class3", "Class4"};

    String[][] Classes = {
            {"Noam Bomboclatt", "Shiri Skibidi", "Idan Wolf", "Itay Dawg", "Shira Shinzao", "John Cena", "Romi Bloodclatt", "Mason Carter", "Levi Anderson", "Elias Harper"},
            {"Amelia Brooks", "Declan King", "Sophia Morgan", "Gabriel Wells", "Emma Collins", "Finn Matthews", "Lily Jameson", "Oliver Davis", "Grace Patterson", "Jonah Mitchell"},
            {"Stella Rogers", "Maximus Ford", "Aria Clarke", "Lucas Rivera", "Chloe Anderson", "Ezra Maxwell", "Violet Stone", "Theo Thompson", "Mia Evans", "Adrian Blake"},
            {"Oliver Fitzgerald", "Ava Reynolds", "Liam Walker", "Sophie Ellis", "Jameson Price", "Isla Dawson", "Ethan Cooper", "Zoe Mitchell", "Lucas Grant", "Madeline Hayes"}
    };

    String[][] dobs = {
            {"01/01/1990", "02/02/1985", "03/03/1992", "04/04/1988", "05/05/1993", "06/06/1980", "07/07/1975", "08/08/1999", "09/09/2001", "10/10/1996"},
            {"11/11/1994", "12/12/1990", "01/15/1982", "02/20/1986", "03/25/1993", "04/30/1987", "05/06/1991", "06/18/1994", "07/14/1989", "08/21/1985"},
            {"09/25/1990", "10/30/1992", "11/04/1987", "12/19/1991", "01/10/1984", "02/25/1995", "03/15/1988", "04/05/1999", "05/22/1993", "06/12/1990"},
            {"07/09/1997", "08/14/1983", "09/06/1980", "10/11/1989", "11/25/1994", "12/20/1985", "01/18/1996", "02/08/1992", "03/07/1985", "04/22/1997"}
    };

    String[][] phoneNums = {
            {"050 123 4567", "050 234 5678", "050 345 6789", "050 456 7890", "050 567 8901", "050 678 9012", "050 789 0123", "050 890 1234", "050 901 2345", "050 012 3456"},
            {"050 213 4567", "050 324 5678", "050 435 6789", "050 546 7890", "050 657 8901", "050 768 9012", "050 879 0123", "050 980 1234", "050 091 2345", "050 102 3456"},
            {"050 321 6547", "050 432 7658", "050 543 8769", "050 654 9870", "050 765 0981", "050 876 1092", "050 987 2103", "050 098 3214", "050 109 4325", "050 210 5436"},
            {"050 111 2222", "050 222 3333", "050 333 4444", "050 444 5555", "050 555 6666", "050 666 7777", "050 777 8888", "050 888 9999", "050 999 0000", "050 000 1111"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        sp = findViewById(R.id.spinner);
        LastNameTV = findViewById(R.id.LastName);
        FirstNameTV = findViewById(R.id.FirstName);
        dobTV = findViewById(R.id.dob);
        phoneNumTV = findViewById(R.id.phoneNum);

        sp.setOnItemSelectedListener(this);
        lv.setOnItemClickListener(this);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,spinnerList);
        sp.setAdapter(adp);

    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        classNum = position;
        if (position == 1)
        {
            ArrayAdapter<String> lvAdp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Classes[0]);
            lv.setAdapter(lvAdp);
        }
        else if (position == 2)
        {
            ArrayAdapter<String> lvAdp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Classes[1]);
            lv.setAdapter(lvAdp);
        }
        else if (position == 3)
        {
            ArrayAdapter<String> lvAdp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Classes[2]);
            lv.setAdapter(lvAdp);
        }
        else if (position == 4)
        {
            ArrayAdapter<String> lvAdp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Classes[3]);
            lv.setAdapter(lvAdp);
        }
        else
        {
            lv.setAdapter(null);
            FirstNameTV.setText("");
            LastNameTV.setText("");
            dobTV.setText("");
            phoneNumTV.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = Classes[classNum - 1][position];
        FirstNameTV.setText(name.substring(0, name.indexOf(" ")));
        LastNameTV.setText(name.substring(name.indexOf(" "), name.length()));
        dobTV.setText(dobs[classNum - 1][position]);
        phoneNumTV.setText(phoneNums[classNum - 1][position]);
    }
}
