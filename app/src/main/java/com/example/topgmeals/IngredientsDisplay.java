package com.example.topgmeals;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IngredientsDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_ingredient);
        IngredientsDisplay currentClass = IngredientsDisplay.this;

        EditText description = (EditText) findViewById(R.id.description_editText);
        EditText amount = (EditText) findViewById(R.id.amount_editText);
        EditText units = (EditText) findViewById(R.id.unit_editText);
        EditText category = (EditText) findViewById(R.id.Category_editText);


        Intent intent = getIntent();
        String descriptionToDisplay = intent.getExtras().getString("DESCRIPTION");
        String amountToDisplay = intent.getExtras().getString("AMOUNT");
        String unitToDisplay = intent.getExtras().getString("UNIT");
        String categoryToDisplay = intent.getExtras().getString("CATEGORY");
        int position = intent.getIntExtra("POSITION",-1);

        description.setText(descriptionToDisplay);
        amount.setText(amountToDisplay);
        units.setText(unitToDisplay);
        category.setText(categoryToDisplay);






        Button backButton = (Button) findViewById(R.id.back_button_modify_ingredient);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button update = (Button) findViewById(R.id.update_ingredient);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(currentClass, IngredientRecipe.class);
                startActivity(intent);
            }
        });


        Button delete = (Button) findViewById(R.id.delete_ingredient);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("POSITION", position);
                setResult(2,intent);
                finish();


            }
        });


    }
}