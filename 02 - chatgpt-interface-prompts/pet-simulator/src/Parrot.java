public class Parrot implements Pet {
    private String name;
    private String[] wordsKnown;
    private int age;

    public Parrot (String name, String[] wordsKnown, int age) {
        this.name = name;
        this.wordsKnown = wordsKnown;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getWordsKnown() {
        return wordsKnown;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWordsKnown(String[] wordsKnown) {
        this.wordsKnown = wordsKnown;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String makeSound() {
        return "KWAK-hello!";
    }

    @Override
    public String doAction() {
        return String.format("%s flutters it's wings.", this.name);
    }
}
