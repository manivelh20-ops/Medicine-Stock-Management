import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin("admin", "1234");

        System.out.println("===== ADMIN LOGIN =====");

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!admin.login(user, pass)) {
            System.out.println("Invalid Login!");
            return;
        }

        System.out.println("Login Successful!");

        MedicineService service = new MedicineService();

        while (true) {

            System.out.println("\n===== MEDICINE STOCK MANAGEMENT =====");
            System.out.println("1. Add Medicine");
            System.out.println("2. Display Medicines");
            System.out.println("3. Search Medicine");
            System.out.println("4. Update Medicine");
            System.out.println("5. Delete Medicine");
            System.out.println("6. Low Stock Alert");
            System.out.println("7. Sell Medicine");
            System.out.println("8. Stock Report");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.addMedicine();
                    break;

                case 2:
                    service.displayMedicines();
                    break;

                case 3:
                    service.searchMedicine();
                    break;

                case 4:
                    service.updateMedicine();
                    break;

                case 5:
                    service.deleteMedicine();
                    break;

                case 6:
                    service.lowStockAlert();
                    break;

                case 7:
                    service.sellMedicine();
                    break;

                case 8:
                    service.stockReport();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}