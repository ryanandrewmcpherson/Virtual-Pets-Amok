# Virtual Pet's Amok
	Simulates running a virtual pet shelter with several twists

## App Layout
1. user is greeted then prompted for their name - they can type quit at any time to quit
2. user is prompted to name the caretaker of the virtual pet shelter
3. admit pet loop do while not done
   1. display number of pets in the shelter
   2. list the cages in the shelter, the pets in them, and their type
   3. type pet name or done to finish adding
      1. done - continue to add step if not done - done by default
        1. if no pets prompts user to add or quit - continue to add step if not quit
        2. if there are pets it breaks the loop and continues to the main menu
      2. admit pet switch 
           sets done to false; //each step can reset it to true if pet shelter becomes full with the addition of pet, or if there is no space for pet per caging rules and no more cages can be added
      	   1. if bird name the bird, creates the bird, puts bird in a cage (limit 5 birds per cage, birds with same name cannot share cage)/ break
      	   2. if robot bird name the robot bird, creates the robot bird, puts bird in a cage (limit 5 birds per cage, birds with same name cannot share cage) /break
      	   3. if cat name the cat, creates the cat, puts the cat in a cage(limit 3 cats per cage, cats with the same name cannot share cage)/ break
      	   4. if robot cat name the cat, creates the robot cat, puts the cat in a cage(limit 3 cats per cage, cats with the same name cannot share cage)/ break
      	   5. if dog name the dog, creates the robot dog, puts the dog in a cage (limit 1 dog per cage)/ break
      	   6. if robot dog name the dog, creates the robot dog, puts the dog in a cage(limit 1 dog per cage)
      	   7. default - pet type not supported ...supported pet type are....   
      3. default 
        1. tells user selection is invalid
        2. sets done to false so loop will restuart and uswer wll have opportunity for valid input again
   4. Once done, user will be prompted to press enter to continue or type quit to quit
4. main loop
    1. print menu
        1. caretaker checks cages and pets and status of cages and pets is displayed
		2. user is prompted what would they like the caretaker to do and main menu prints
	2. user choice is saved as menu selection 
	3. main menu switch (menu selection)
	   1. have caretaker feed all real pets
	   2. have caretaker water all real pets
	   3. have caretaker oil all robots
	   4. have caretaker charge all robots
	   5. have caretaker walk all dogs
	   6. have caretaker clean all cages
	   7. have caretaker clean all litterboxes in cat cages
	   8. interact with a pet
	      1. interact loop while interact true (true by default)
	        1. pet status
	      	2. switch(pet)
		   	    1. feed pet(displays if real)
		   	        1. what type of food to feed
	                2. feed pet method
		   	    2. water pet(displays if real)
		   	    1. oil pet (displays if robot)
		   	    2. charge pet battery (displays if robot)
		   	    3. play with pet
		   	    4. main menu, interact = false;
	   	        5. default. "invalid selection"
	   	    3. tick()
	   9. admit a pet
	   10. adopt a pet
	4. tick() = adusts pet attributes to real time, including pet's health which is most a secondary attribute   
-progam doesn't end until user types quit

## Classes
1. VirtualPetShelterApp
2. VirtualPetShelter
3. Owner (user)
4. Caretaker 
5. Pet
	1. Bird
	2. Cat
	3. Dog
6. Cage
	1. Bird Cage
	2. Cat Cage
	3. Dog Cage

## Test Classes
1. VirtualPetShelterTest
2. OwnerTest (user)
3. CaretakerTest 
4. Pet
	1. BirdTest
	2. CatTest
	3. DogTest

