package com.example.topgmeals.mealplan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.topgmeals.R;
import com.example.topgmeals.ingredientstorage.AddEditIngredientActivity;
import com.example.topgmeals.utils.DateFormat;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * This class is an {@link AppCompatActivity} that is created when the user chooses to add a new meal
 * from {@link MealPlan}. Allows the user to plan a new meal. They can choose a date, whether the meal
 * is an ingredient or a recipe and the number of servings.
 */
public class AddMealActivity extends AppCompatActivity {

    /**
     * {@link EditText} where the user chooses the date of the meal
     */
    EditText mealDate;

    /**
     * {@link Spinner} where user can choose from either Ingredients or Recipes for their Meal.
     */
    Spinner type;

    /**
     * {@link Spinner} where user can select the meal they want. The options will depend on the
     * {@code type} they chose, ie. Ingredient or Recipe.
     */
    Spinner selection;

    /**
     * {@link EditText} where user can enter a signed integer for the number of servings of a meal.
     */
    EditText serving;

    /**
     * A Cancel {@link Button} that will send the user back to {@link MealPlan}.
     */
    Button cancel;

    /**
     * A Save {@link Button} that saves the meal the user has chosen.
     */
    Button save;

    /**
     * A {@link DateFormat} that helps parse a {@link Date} into {@code MM/dd/yyyy}
     */
    DateFormat format = new DateFormat();

    final Calendar myCalendar = Calendar.getInstance();

    /**
     * User's authentication ID used to store documents in Firestore for each user
     */
    private String userID;

    /**
     * Firestore collection where new meals will be added to.
     */
    CollectionReference selectionCollection;

    /**
     * Whether the new meal is from Ingredients or Recipes.
     */
    boolean isRecipe;

    /**
     *  This method gets called when the Activity is created. It creates the layouts
     *  and handles the logic for the Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        setTitle("Add Meal");

        // Types of meal the user can choose from. To be used for populating the type Spinner
        final String[] mealTypes = {"Recipe", "Ingredient"};

        // Names of meals the user can choose from. To be used for populating the selection Spinner
        // Content depends on which type of meal the user chose
        ArrayList<String> mealNames = new ArrayList<>();

        // List of DocumentReferences for the Ingredients/Recipes.
        ArrayList<String> refList = new ArrayList<>();

        // Initialize layout components
        mealDate = findViewById(R.id.meal_date);
        type = findViewById(R.id.meal_type);
        selection = findViewById(R.id.meal_selection);
        serving = findViewById(R.id.meal_serving);
        cancel = findViewById(R.id.cancel_meal);
        save = findViewById(R.id.save_meal);

        // Initialize Firestore and related variables
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final CollectionReference mealCollection = db.collection("mealplan");
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Set up the calendar selection for choosing date
        myCalendar.setTime(new Date());
        updateLabel();
        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,day);
            updateLabel();
        };
        mealDate.setOnClickListener(view -> new DatePickerDialog(AddMealActivity.this,date,
                myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show());


        // Set adapter for selection Spinner
        ArrayAdapter<String> selectionAdapter = new ArrayAdapter<>(getBaseContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, mealNames);
        selectionAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        selection.setAdapter(selectionAdapter);

        // Set adapter for type Spinner. The selection list is updated every time the user switches type
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, mealTypes);
        typeAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        type.setAdapter(typeAdapter);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){        // Recipe is chosen
                    selectionCollection = db.collection("recipes");
                    isRecipe = true;
                } else {            // Ingredient is chosen
                    selectionCollection = db.collection("ingredients");
                    isRecipe = false;
                }
                mealNames.clear();
                refList.clear();

                // get choices from collection
                selectionCollection.whereEqualTo("id", userID).get()
                        .addOnSuccessListener(queryDocumentSnapshots -> {
                            if (queryDocumentSnapshots.isEmpty()){
                                Log.d("R", "onSuccess: document empty");
                            } else {
                                for (DocumentSnapshot doc: queryDocumentSnapshots){
                                    String name;
                                    if (i == 0){ name = (String)doc.get("title"); }
                                    else{ name = (String) doc.get("description"); }
                                    mealNames.add(name);
                                    refList.add(doc.getId());
                                }
                                selectionAdapter.notifyDataSetChanged();

                            }
                        });

                Log.d("MealName", String.valueOf(mealNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });



        cancel.setOnClickListener(view -> finish());

        // Add new meal to Firestore
        save.setOnClickListener(view -> {
            String date1 = mealDate.getText().toString();
            String mealName = selection.getSelectedItem().toString();
            int numServings = Integer.parseInt(serving.getText().toString());

            DocumentReference docRef = mealCollection.document();

            HashMap<String, Object> item = new HashMap<>();
            item.put("id", userID);
            item.put("date", date1);
            item.put("mealName", mealName);
            item.put("numServings", numServings);
            item.put("ref", refList.get(selection.getSelectedItemPosition()));
            item.put("isRecipe", isRecipe);

            docRef.set(item)
                    .addOnSuccessListener(unused -> Log.d("success", "Added successfully"))
                    .addOnFailureListener(e -> Log.d("failure", "failed"));

            finish();
        });
    }


    /**
     * This method updates the mealDate {@link EditText} to the date of myCalendar
     */
    private void updateLabel(){
        mealDate.setText(format.parse(myCalendar.getTime()));
    }

}