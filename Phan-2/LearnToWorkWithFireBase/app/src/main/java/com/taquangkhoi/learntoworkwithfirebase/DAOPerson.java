package com.taquangkhoi.learntoworkwithfirebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOPerson {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private static final String TAG = "DAOPerson";

    public DAOPerson() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(Person.class.getSimpleName());
    }

    public void add(Person person) {
        databaseReference.push().setValue(person);
    }

    public void updateUser(String key, HashMap<String, Object> hashMap) {
        databaseReference.child(key).updateChildren(hashMap);
    }

    public void deleteUser(String key) {
        databaseReference.child(key).removeValue();
    }
    public Query getUser() {
        return databaseReference.orderByKey();
    }
}
