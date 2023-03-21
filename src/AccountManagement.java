
import java.util.*;
class item{
    String name;
    String id;
    double money;

    public item(String name, String id, double money) {
        this.name = name;
        this.id = id;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }
}
public class AccountManagement{
    static Scanner src = new Scanner(System.in);
    ArrayList<item> array = new ArrayList<item>();

    void addAccount(){
        System.out.print("Enter your name: ");
        String name = src.next();
        System.out.print("Enter ID: ");
        String id = src.next();
        System.out.print("Enter money: ");
        double money = src.nextDouble();
        array.add(new item(name, id, money));
    }
    void show(){
        System.out.println("1. show Ascending Order by ID");
        System.out.println("2. show Descending Order by ID");
        System.out.println("3. show Descending Order by balance");
        System.out.print("Choose an option(1-3): ");
        int choice = src.nextInt();
        double temp;
        switch (choice){
            case 1->{
                // 1. show by Ascending order by id:
                Collections.sort(array, new Comparator<item>() {
                    @Override
                    public int compare(item o1, item o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                });
            }
            case 2->{
                Collections.sort(array, new Comparator<item>() {
                    @Override
                    public int compare(item o1, item o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                });
                Collections.reverse(array);
            }
            case 3->{
                Collections.sort(array, new Comparator<item>() {
                    @Override
                    public int compare(item o1, item o2) {
                        return Double.compare(o1.getMoney(), o2.getMoney());
                    }
                });
            }
        }

        for (int i=0; i<array.size(); i++){
            System.out.println((i+1) + ". Name: " + array.get(i).name + ", ID: " + array.get(i).id + ", Money: "+array.get(i).money);
        }

    }
    void edit(){
        System.out.println("Enter ID: "); String check_id = src.next();
        for (item item : array) {
            if (check_id.equals(item.id)) {
                System.out.print("1. Edit ID");
                System.out.print("2. Edit Name");
                int choice_edit = src.nextInt();
                switch (choice_edit) {
                    case 1 -> {
                        System.out.print("Enter new ID: ");
                        item.id = src.next();
                    }
                    case 2 -> {
                        System.out.print("Enter new Name: ");
                        item.name = src.next();
                    }
                }
            }
        }
    }
    void delete(){
        System.out.println("Enter the ID, that you want to delete: ");
        String deleteName = src.next();
        int check = 0;
        for (int i=0; i<array.size(); i++){
            if (deleteName.equals(array.get(i).id)){
                array.remove(array.get(i));
                System.out.println("User removed!");
                check = 1;
            }else{
                check = 0;
            }
        }
        if(check==0){
            System.out.println("Id not found!");
        }
    }
    public static void main(String[] args) {
        AccountManagement obj = new AccountManagement();
        int choice;
        do {
            System.out.println("________________________________");
            System.out.println("Welcome to Account Management System");
            System.out.println("1. Add account");
            System.out.println("2. Edit account");
            System.out.println("3. Delete account");
            System.out.println("4. Show account");
            System.out.print("*/ Enter your choice: ");
            choice = src.nextInt();
            switch (choice) {
                case 1 -> obj.addAccount();
                case 2 -> obj.edit();
                case 3 -> obj.delete();
                case 4 -> obj.show();
            }
        }while(true);
    }
}