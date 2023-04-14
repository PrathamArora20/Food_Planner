
### This is an overview of the Storyboard for our TopGMeals app built with Figma.

# Final Version
![all](https://user-images.githubusercontent.com/59667646/204396824-ba0c6e7e-b856-4498-a455-bd5734a80cce.png)

# Initial Version
![StoryBoard - TopGMeals](https://user-images.githubusercontent.com/59709174/195948934-846e4742-bf77-4a9f-b31b-786cce365dbf.png)

***


* The Storyboard consists of four main pages: Ingredient Storage, Recipies Book, Meal Planner, and Shopping List.

### Login

* The App will start with a login where a user must enter a valid username/email and password.

![login](https://user-images.githubusercontent.com/59667646/204398054-70fb80f2-466f-4341-a730-1689e2b4ced0.png)

* If the user is new they can click the register new user button which will prompt them to fill in the new user form
* New users must be unique and follow account creation criteria

![register](https://user-images.githubusercontent.com/59667646/204398056-965fc89a-37f4-4c74-8e6c-848491c22891.png)

* If a user forgets their password. They can reset their password with the reset password page. And then login with their new password

![resetpasswrod](https://user-images.githubusercontent.com/59667646/204398057-8cbc0c72-ea5b-433d-bc6f-febe6a22a703.png)


* Upon successful login of the app, the user will see the following Load/Title Screen where they can intuitively select which feature to use.

  ![Load/TitleScreen](https://user-images.githubusercontent.com/59709174/195906318-b1b1f9bf-7ee6-4c0a-acb4-eb3f41807456.png)

***

### Ingredient Storage

* If the user selects Ingredient Storage from Load/Title Screen they are directed to the Ingredient Storage page.
* This page shows all the stored ingredients and some details in a listview.
* There will be a spinner at the top that when selected can sort the list by description, best before date, location, or ingredient category.
* If the user selects an ingredient in the listview and clicks the delete button, the selected ingredient will be removed from the list.

  ![IngredientStorage](https://user-images.githubusercontent.com/59709174/195907900-51028caa-b1be-4eaa-a53d-d8a8b7a017b5.png)

* The user can add an ingredient to the Ingredient Storage list by clicking on the Add button. This will change the view to the Add Ingredient page shown below where the user must provide the necessary details to add a new ingredient.

  ![AddIngredient](https://user-images.githubusercontent.com/59709174/195908211-c7d98e96-564f-419c-b3fe-3077cc52fb31.png)

* The user can change the details of an ingredient from the listview by selecting an ingredient from the listview and clicking the Edit button. This will change the view to the Edit Ingredient page shown below where the user can change the details of the ingredient like Unit, and once satisfied with the changes, click the Update button to see the changes in the Ingredient Storage page.

  ![EditIngredient](https://user-images.githubusercontent.com/59709174/195908417-af876075-90c5-4995-9a1d-9a1053da0d7a.png)

***

### Recipes Book

* If the user selects Recipes Book from Load/Title Screen they are directed to the Recipes Book page.

  ![RecipeBook](https://user-images.githubusercontent.com/59709174/195932294-ee77e2ee-1e69-4433-95c7-7c4d6cc2baed.png)

* The user can add a new recipe to the Recipes Book by clicking on the Add New Recipe button. This will change the view to the Add Recipe page shown below where the user must provide the necessary details to add a new recipe. 
* Currently, the design describes that a user can add a recipe without ingredients. The ingredients can be added as described in the next pages, but we may consider adding a button for the user to add ingredients to a recipe when a new recipe is being created.

  ![Add Recipee](https://user-images.githubusercontent.com/59709174/195941269-d628465b-0b26-43fb-84da-89c3f7ac8b8f.png)

* While viewing the Recipes Book page, the user can view details of a recipe by selecting it from the listview. This will change the view to the Recipe Information page shown below.
* The user can delete the recipe by clicking the Delete Recipe button.

  ![RecipeInformation](https://user-images.githubusercontent.com/59709174/195943862-23a7014d-b2bd-46b1-8295-4e04f57e1b1e.png)

* While viewing a Recipe Information page, a user can view all the ingredients for the recipe by clicking the Ingredients button. This will change the view to the Ingredients page shown below.

  ![Ingredients](https://user-images.githubusercontent.com/59709174/195944391-9ab18925-ef0e-4796-a122-916f95f934b8.png)

* While viewing the Ingredients page, a user can add a new ingredient to the recipe by clicking the Add New Ingredient button. This will change the view to the Add Ingredient to Recipe page shown below.

  ![AddIngredientToRecipe](https://user-images.githubusercontent.com/59709174/195945311-37c25965-78c1-4a98-926c-a4ac0133d352.png)

* While viewing the Ingredients page, a user can select an ingredient from the listview to view, update details, or delete the ingredient. This will change the view to the Modify Ingredient page shown below.
* Once satisfied with the changes to the ingredient, the user clicks the Update Ingredient button to see the changes on the Ingredients page.
* The user can also remove the ingredient by clicking the Delete Ingredient button.

  ![ModifyIngredient](https://user-images.githubusercontent.com/59709174/195946185-280a943d-57fb-4f57-bcc2-315df064c2a4.png)

***

### Meal Planner

* If the user selects Meal Planner from Load/Title Screen they are directed to the Meal Planner page.
* Here, a listview shows any planned meals by the user with the date and quantity of meals.
* The user can delete a planned meal by clicking the Delete button.

  ![MealPlanner](https://user-images.githubusercontent.com/59709174/195947993-a0fa16a8-013a-44a4-af15-d38f34508136.png)

* While viewing the Meal Planner page, a user can select plan a new meal by clicking the Add Meal button. This will change the view to the Add Meal page shown below.
* Here, the user can select up to 3 meals from a spinner with their serving size to a specified date.

  ![AddMeal](https://user-images.githubusercontent.com/59709174/195947402-aa69ec00-cc43-455b-afed-3a76e460980a.png)

* While viewing the Meal Planner page, a user can select a planned meal from the listview to view or update the details of a meal. This will change the view to the Meal Detail page shown below.

  ![MealDetail](https://user-images.githubusercontent.com/59709174/195948273-7ecdfc71-ad79-4be9-a0f2-c55ab6aef0fd.png)

***

### Shopping List

* If the user selects Shopping List from Load/Title Screen they are directed to the Shopping List page.
* Here, a listview shows the ingredients along with the details to purchase it. 
* The shopping list can be sorted by description or category.
* The user can confirm the purchase of an ingredient in the shopping cart by checking off their corresponding checkbox. This will update the ingredient storage as well.

  ![ShoppingList](https://user-images.githubusercontent.com/59709174/195948501-d1983684-fab3-4253-8aa4-f122808d78ee.png)



* After the User is done shopping. They will be prompted to select an Ingredient that they picked up and either update the value in the Ingredient Storage or Add it to Ingredient Storage if it is completely new.
![shopfinal](https://user-images.githubusercontent.com/59667646/204397338-1dda7f87-b093-4608-812c-0ed7fad70b13.png)


***
