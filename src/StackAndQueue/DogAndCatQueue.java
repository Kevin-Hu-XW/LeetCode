package StackAndQueue;
import java.util.LinkedList;
import java.util.Queue;
public class DogAndCatQueue {
    public static class Pet { private String type;
        public Pet(String type) { this.type = type; }
        public String getPetType() { return this.type; }
    }
    public static class Dog extends Pet { public Dog() { super("dog"); } }
    public static class Cat extends Pet { public Cat() { super("cat"); } }

    public static class PetCount{
        public Pet Pet;
        public long Count;
        public PetCount(Pet pet,long Count){
            this.Pet=pet;
            this.Count=Count;
        }
        public Pet getPet() {
            return this.Pet;
        }
    }
    public static class DogCatQueue{
        public Queue<PetCount> DogQueue;
        public Queue<PetCount> CatQueue;
        public long Count;
        public DogCatQueue(){
            this.DogQueue=new LinkedList<PetCount>();
            this.CatQueue=new LinkedList<PetCount>();
            this.Count=0;
        }

        public void add(Pet pet){
            if (pet.type=="dog") {
                this.DogQueue.add(new PetCount(pet,this.Count++));
            }else{
                this.CatQueue.add(new PetCount(pet,this.Count++));
            }
        }
        public Pet pollAll(){
            if (!this.DogQueue.isEmpty()&&!this.CatQueue.isEmpty()) {
                if (this.DogQueue.peek().Count<=this.CatQueue.peek().Count) {
                    return this.DogQueue.poll().getPet();
                }
                return this.CatQueue.poll().getPet();
            }
            if (!this.DogQueue.isEmpty()){
                return this.DogQueue.poll().getPet();
            }
            if (!this.CatQueue.isEmpty()) {
                return this.CatQueue.poll().getPet();
            }
            throw new RuntimeException("The queue is empty");
        }
        public Dog pollDog(){
            if (!this.DogQueue.isEmpty()){
                return (Dog) this.DogQueue.poll().getPet();
            }
            throw new RuntimeException("The queue is empty");
        }
        public Cat pollCat(){
            if (!this.CatQueue.isEmpty()) {
                return (Cat) this.CatQueue.poll().getPet();
            }
            throw new RuntimeException("The queue is empty");
        }
        public boolean isEmpty() {
            if (this.CatQueue.isEmpty()&&this.DogQueue.isEmpty()){
                return true;
            }
            return false;
        }
        public boolean isDogQueueEmpty() {
            if (this.DogQueue.isEmpty()) {
                return true;
            }
            return false;
        }
        public boolean isCatEmpty() {
            if (this.CatQueue.isEmpty()) {
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().type);
        }
    }
}
