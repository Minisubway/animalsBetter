package com.example.animalsforthebetter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.animalsforthebetter.Features.Animals;
import com.example.animalsforthebetter.Database.DatabaseQueryClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseQueryClass databaseQueryClass;

    private List<Animals> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        databaseQueryClass = new DatabaseQueryClass(getBaseContext());

        Animals animal= new Animals(2, "Rooster", "Chicken",12);
        Animals animal2 = new Animals(3,"Kitten","Cats",13);

        long id = databaseQueryClass.insertAnimal(animal);
        animal.setId(id);
        long id2 = databaseQueryClass.insertAnimal(animal2);
        animal2.setId(id2);
    }
}