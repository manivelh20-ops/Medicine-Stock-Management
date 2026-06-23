import java.util.ArrayList;
import java.util.Scanner;

public class MedicineService {

    ArrayList<Medicine> medicines = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int nextId = 101;

    public void addMedicine() {

        int id = nextId++;

        sc.nextLine();

        System.out.println("Generated Medicine ID: " + id);

        System.out.print("Enter Medicine Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Expiry Date: ");
        String expiryDate = sc.nextLine();

        medicines.add(new Medicine(
                id,
                name,
                category,
                price,
                quantity,
                expiryDate));

        System.out.println("Medicine Added Successfully!");
    }

    public void displayMedicines() {

        if (medicines.isEmpty()) {
            System.out.println("No Medicines Available!");
            return;
        }

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("ID\tNAME\t\tCATEGORY\tPRICE\tQTY\tEXPIRY");
        System.out.println("----------------------------------------------------------------");

        for (Medicine m : medicines) {

            System.out.println(
                    m.id + "\t" +
                    m.name + "\t\t" +
                    m.category + "\t\t" +
                    m.price + "\t" +
                    m.quantity + "\t" +
                    m.expiryDate);
        }
    }

    public void searchMedicine() {

        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();

        for (Medicine m : medicines) {

            if (m.id == id) {

                System.out.println("\nMedicine Found");
                System.out.println("ID       : " + m.id);
                System.out.println("Name     : " + m.name);
                System.out.println("Category : " + m.category);
                System.out.println("Price    : " + m.price);
                System.out.println("Quantity : " + m.quantity);
                System.out.println("Expiry   : " + m.expiryDate);

                return;
            }
        }

        System.out.println("Medicine Not Found!");
    }

    public void updateMedicine() {

        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();

        for (Medicine m : medicines) {

            if (m.id == id) {

                System.out.print("Enter New Price: ");
                m.price = sc.nextDouble();

                System.out.print("Enter New Quantity: ");
                m.quantity = sc.nextInt();

                System.out.println("Medicine Updated Successfully!");
                return;
            }
        }

        System.out.println("Medicine Not Found!");
    }

    public void deleteMedicine() {

        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < medicines.size(); i++) {

            if (medicines.get(i).id == id) {

                medicines.remove(i);

                System.out.println("Medicine Deleted Successfully!");
                return;
            }
        }

        System.out.println("Medicine Not Found!");
    }

    public void lowStockAlert() {

        boolean found = false;

        System.out.println("\n===== LOW STOCK MEDICINES =====");

        for (Medicine m : medicines) {

            if (m.quantity < 20) {

                found = true;

                System.out.println(
                        m.name + " -> Quantity: " + m.quantity);
            }
        }

        if (!found) {
            System.out.println("No Low Stock Medicines");
        }
    }

    public void sellMedicine() {

        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();

        for (Medicine m : medicines) {

            if (m.id == id) {

                System.out.print("Enter Quantity Sold: ");
                int soldQty = sc.nextInt();

                if (soldQty <= m.quantity) {

                    m.quantity -= soldQty;

                    double bill = soldQty * m.price;

                    System.out.println("Medicine Sold Successfully!");
                    System.out.println("Bill Amount = Rs." + bill);
                    System.out.println("Remaining Stock = " + m.quantity);
                }
                else {

                    System.out.println("Insufficient Stock!");
                }

                return;
            }
        }

        System.out.println("Medicine Not Found!");
    }

    public void stockReport() {

        double totalValue = 0;

        System.out.println("\n===== STOCK REPORT =====");

        for (Medicine m : medicines) {

            double value = m.price * m.quantity;

            totalValue += value;

            System.out.println(
                    m.name + " = Rs." + value);
        }

        System.out.println("--------------------------------");
        System.out.println("Total Stock Value = Rs." + totalValue);
    }
}