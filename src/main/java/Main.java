import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyController familyController = new FamilyController();
        System.out.println("Console application:");

        while(true){
            System.out.println("""
                    1. Fill with test data.
                    2. Display the entire list of families.
                    3. Display a list of families where the number of people is greater than the specified number.
                    4. Display a list of families where the number of people is less than the specified number.
                    5. Calculate the number of families where the number of members is:
                    6. Create a new family.
                    7. Delete a family by its index in the general list.
                    8. Edit a family by its index in the general list.
                    9. Remove all children over the age of majority.""");

            System.out.print("Your option:");
            String option = scanner.next();
            if(option.equalsIgnoreCase("exit")) break;

            try {
                switch (Integer.parseInt(option)) {
                    case 1 -> {
                        Dog dog = new Dog("Danny", 6, 56, new HashSet<>(Arrays.asList("eat", "run", "sleep")));
                        DomesticCat cat = new DomesticCat("Garfield", 8, 90, new HashSet<>(Arrays.asList("sleep", "watch Tv", "eat")));
                        Human mother1 = new Woman("Arzu", "Ismayilova", "21/04/1975", 90, null);
                        Human father1 = new Man("Senan", "Ismayilov", "12/12/1975", 94, null);
                        Human mother2 = new Woman("Rima", "Quliyeva", "11/12/1980");
                        Human father2 = new Man("Rasim", "Quliyev", "10/02/1980");
                        Human mother3 = new Woman("Esmira", "Eliyeva", "05/05/1981");
                        Human father3 = new Man("Azer", "Eliyev", "12/12/1981");
                        Human child1 = new Man("Elnur", "Ismayilov", "12/02/2000", 94, null);
                        Human child2 = new Man("Emil", "Ismayilov", "11/12/1996", 92, null);
                        Human child3 = new Man("Elvin", "Quliyev", "06/06/1995", 92, null);
                        Human childAdopted = new Man("Asim", "Hemidov", "21/10/2021", 65);
                        familyController.createNewFamily(mother1, father1);
                        familyController.getFamilyById(familyController.getAllFamilies().indexOf(mother1.getFamily()) + 1).addChild(child1);
                        familyController.getFamilyById(familyController.getAllFamilies().indexOf(mother1.getFamily()) + 1).addChild(child2);
                        familyController.addPet(dog, familyController.getAllFamilies().indexOf(mother1.getFamily()) + 1);
                        familyController.addPet(cat, familyController.getAllFamilies().indexOf(mother1.getFamily()) + 1);
                        familyController.createNewFamily(mother2, father2);
                        familyController.getFamilyById(familyController.getAllFamilies().indexOf(mother2.getFamily()) + 1).addChild(child3);
                        familyController.bornChild(familyController.getFamilyById(familyController.getAllFamilies().indexOf(mother2.getFamily()) + 1), "Vaqif", "Valide");
                        familyController.adoptChild(familyController.getFamilyById(familyController.getAllFamilies().indexOf(mother2.getFamily()) + 1), childAdopted);
                        familyController.createNewFamily(mother3, father3);
                    }
                    case 2 -> familyController.displayAllFamilies();
                    case 3 -> {
                        System.out.print("Enter your number: ");
                        familyController.getFamiliesBiggerThan(scanner.nextInt());
                    }
                    case 4 -> {
                        System.out.print("Enter your number: ");
                        familyController.getFamiliesLessThan(scanner.nextInt());
                    }
                    case 5 -> {
                        System.out.print("Enter your number: ");
                        System.out.println(familyController.countFamiliesWithMemberNumber(scanner.nextInt()));
                    }
                    case 6 -> {
                        System.out.print("Please, enter the name of mother: ");
                        String name1 = scanner.next();
                        System.out.print("Please, enter the surname of mother: ");
                        String surname1 = scanner.next();
                        System.out.print("Please, enter the birth year of mother: ");
                        String birthYear1 = scanner.next();
                        System.out.print("Please, enter the month of birth of mother: ");
                        String birthMonth1 = scanner.next();
                        System.out.print("Please, enter the birthday of mother: ");
                        String birthDay1 = scanner.next();
                        System.out.print("Please, enter the iq of mother: ");
                        int iq1 = scanner.nextInt();
                        Human mother = new Woman(name1, surname1, String.format("%s/%s/%s", birthDay1, birthMonth1, birthYear1), iq1);
                        System.out.print("Please, enter the name of father: ");
                        String name2 = scanner.next();
                        System.out.print("Please, enter the surname of father: ");
                        String surname2 = scanner.next();
                        System.out.print("Please, enter the birth year of father: ");
                        String birthYear2 = scanner.next();
                        System.out.print("Please, enter the month of birth of father: ");
                        String birthMonth2 = scanner.next();
                        System.out.print("Please, enter the birthday of father: ");
                        String birthDay2 = scanner.next();
                        System.out.print("Please, enter the iq of father: ");
                        int iq2 = scanner.nextInt();
                        Human father = new Man(name2, surname2, String.format("%s/%s/%s", birthDay2, birthMonth2, birthYear2), iq2);
                        familyController.createNewFamily(father, mother);
                    }
                    case 7 -> {
                        System.out.print("Please, enter family ID: ");
                        familyController.deleteFamilyByIndex(scanner.nextInt());
                    }
                    case 8 -> {
                        System.out.println("Select one below:");
                        while (true) {
                            boolean breaker = false;
                            System.out.println("""
                                    1. Give birth to a baby.
                                    2. Adopt a child.
                                    3. Return to main menu.""");
                            System.out.print("Your option:");
                            int optionInner = scanner.nextInt();
                            switch (optionInner) {
                                case 1 -> {
                                    System.out.print("Please, enter family ID: ");
                                    int id1 = scanner.nextInt();
                                    System.out.print("The name in the case of boy: ");
                                    String nameBoy = scanner.next();
                                    System.out.print("The name in the case of girl: ");
                                    String nameGirl = scanner.next();
                                    familyController.bornChild(familyController.getFamilyById(id1), nameBoy, nameGirl);
                                }
                                case 2 -> {
                                    System.out.print("Please, enter family ID: ");
                                    int id2 = scanner.nextInt();
                                    System.out.print("Please, enter the gender of adopted child (m/f): ");
                                    String gender = scanner.next();
                                    System.out.print("Please, enter the name of adopted child: ");
                                    String name3 = scanner.next();
                                    System.out.print("Please, enter the surname of adopted child: ");
                                    String surname3 = scanner.next();
                                    System.out.print("Please, enter the birth date of adopted child: ");
                                    String birthDate = scanner.next();
                                    System.out.print("Please, enter the iq of adopted child: ");
                                    int iq3 = scanner.nextInt();
                                    Human adoptedChild;
                                    if (gender.equalsIgnoreCase("m")) {
                                        adoptedChild = new Man(name3, surname3, birthDate, iq3);
                                    } else {
                                        adoptedChild = new Woman(name3, surname3, birthDate, iq3);
                                    }
                                    familyController.adoptChild(familyController.getFamilyById(id2), adoptedChild);
                                }
                                case 3 -> breaker = true;
                                default -> System.out.println("Please, write a choice 1, 2 or 3.\n");
                            }
                            if (breaker) break;
                        }
                    }
                    case 9 -> {
                        System.out.print("Please, enter the number: ");
                        familyController.deleteAllChildrenOlderThan(scanner.nextInt());
                    }
                    default ->
                            System.out.println("Please, write a number between 1-10 or write \"exit\" to finish the application.\n");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Please, provide a number.\n");
                scanner.nextLine();
            }
            catch (DateTimeParseException e) {
                System.out.println("Please, provide a date in a format \"dd/MM/yyyy\".\n");
                scanner.nextLine();
            }
        }
    }
}
