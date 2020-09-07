import java.io.*;
import java.util.Objects;

/**
 * Created by KSafonov on 21/09/2017.
 */
public class AnimalArray {
    public static void main(String[] args) {

        Animal[] animals = {new Animal("Cat"), new Animal("Dog"), new Animal("Horse")};
        serializeAnimalArray(animals);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try(FileInputStream inputStream = new FileInputStream("Animals.bin")){
            int readedBytes;
            byte[] buffer = new byte[512];

            while((readedBytes = inputStream.read(buffer, 0, buffer.length)) != -1){
                baos.write(buffer, 0, readedBytes);
            }
            baos.flush();
        }
        catch (IOException ex){

        }
        try {
            Animal[] animalsBig = deserializeAnimalArray(baos.toByteArray());
            for(Animal animal: animalsBig){
                System.out.println(animal.getName());
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
    public static void serializeAnimalArray(Animal[] data) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Animals.bin"))) {

          //  oos.writeFloat(6);
            oos.writeInt(data.length);
            oos.writeInt(data.length);
            for(Animal animal: data) oos.writeObject(animal);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] result = null;

        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            try {
                result = new Animal[ois.readInt()];
            }
            catch (OutOfMemoryError ex)
            {
                throw new IllegalArgumentException("This is not an integer!");
            }
            for(int i = 0; i < result.length; i++){
                try {
                    result[i] = (Animal) ois.readObject();
                }
                catch(NullPointerException ex)
                {
                    throw new IllegalArgumentException("This is not an animal!");
                }
                catch(OptionalDataException ex){
                    throw new IllegalArgumentException("This is not an animal!");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalArgumentException("This is not a well formatted data!");
        }

        return result;
    }
}




class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    public String getName() {
        return name;
    }
}