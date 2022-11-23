package com.taquangkhoi.learntoworkwithfirebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOPerson {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public DAOPerson() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(Person.class.getSimpleName());
    }

    public void add(Person person) {
        databaseReference.push().setValue(person);
    }
}
