package puppy;
public class PetStore {
    public static void main(String[] args){
        String dogName = Puppy.name;
        String dogKind = Puppy.type;
        String dogColor =Puppy.color;
        System.out.println("我有一隻聰明的"+dogKind+"犬,名叫"+dogName+",他的顏色是"+dogColor+"色的.");
        System.out.println("他每天都會幫我");
        String dogSkill =Puppy.skill2();
        System.out.println(dogSkill);
        Puppy.skill2();
    }
}