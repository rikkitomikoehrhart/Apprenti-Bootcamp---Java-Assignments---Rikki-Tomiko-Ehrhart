// PET SIMULATOR
//
// 📝 Prompt:
//      You want to simulate different pets making their
//      signature sounds: Dog, Cat, Parrot, etc. Each one should:
//              👉 Make a sound
//	            👉 Do a little action (like wag tail, clean paw, etc.)
//
// 🎯 Goal:
//      Use an interface like Pet with makeSound() and doAction().
//      Then loop through a list of different Pets and call those methods.


public class Main {
    public static void main(String[] args) {
        Pet dog = new Dog("Joe", "Chihwennie", 16);
        Pet cat = new Cat("Hades", "Black", 8);
        Pet parrot = new Parrot("Dudley", new String[]{"hello", "goodbye", "dog", "cat"}, 30);

        Pet[] pets = new Pet[]{dog, cat, parrot};

        for (Pet pet : pets) {
            System.out.println(pet.makeSound());
            System.out.println(pet.doAction());
            System.out.println("\n");
        }


    }
}