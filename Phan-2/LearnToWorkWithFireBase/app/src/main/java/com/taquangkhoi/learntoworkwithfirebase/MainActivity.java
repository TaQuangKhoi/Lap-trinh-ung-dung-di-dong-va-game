package com.taquangkhoi.learntoworkwithfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference testRef = database.getReference("message");
    DatabaseReference personRef = database.getReference("Person");
    private static final String TAG = "MainActivity";
    EditText edtName, edtAge;
    Button btnCreate;
    DAOPerson daoPerson = new DAOPerson();
    PersonAdapter personAdapter = new PersonAdapter(this);
    ArrayList persons = new ArrayList<Person>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addControls();
        addEvents();
        testReadFromDB();
        try {
            Read();
        } catch (Exception e) {
            Log.d(TAG, "onCreate: " + e.getMessage());
        } finally {
            Log.d(TAG, "onCreate: finally");
        }
    }

    private void addEvents() {
        addButtonCreateClickEvent();
    }

    private void addButtonCreateClickEvent() {
        btnCreate.setOnClickListener(v -> {
            if (checkDatatypeOfEditText()){
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());
                Person person = new Person(name, age);
                daoPerson.add(person);
                Toast.makeText(MainActivity.this, "Create successfully", Toast.LENGTH_SHORT).show();
            } else {
                Log.d(TAG, "addEvents: Wrong datatype");
                Toast.makeText(this, "addEvents: Wrong datatype", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addControls() {
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btnCreate = findViewById(R.id.btnCreate);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(personAdapter);
    }

    private void testWriteToDB() {
        // Write a message to the database
        testRef.setValue("Hello, World!");
    }

    private void testReadFromDB() {
        // Read from the database
        testRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    // Check datatype of two EditText views
    private boolean checkDatatypeOfEditText() {
        String name = edtName.getText().toString();
        String age = edtAge.getText().toString();
        if (age.matches("[0-9]+")
                && name.length() > 0 && age.length() > 0) {
            return true;
        }
        return false;
    }

    public void Read() {
        daoPerson.getUser().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Person person = dataSnapshot.getValue(Person.class);
                    person.setKey(dataSnapshot.getKey());
                    Log.d(TAG, "onDataChange: " + person.toString());
                    persons.add(person);
                }
                personAdapter.setItems(persons);
                personAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}