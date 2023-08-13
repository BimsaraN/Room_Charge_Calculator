import java.util.Scanner;

public class RoomChargeCalculator
{

    //Fixed Price list
    public static int DuluxDoubleFixedPrice = 5000;
    public static int StandardFamilyFixedPrice = 3000;
    public static int StandardSingleFixedPrice = 2000;

    //Extra Price list
    public static int balconyPrice = 500;
    public static int parkingPrice = 200;
    public static int tvPrice = 200;
    public static int kitchenPriceDeluxDouble = 1000;
    public static int kitchenPriceStandardFamily = 500;
    public static int wifiPrice = 100;
    public static int gardenPrice = 200;
    public static int acPrice = 500;

    public static void main(String[] args)
    {

        Scanner newscanner = new Scanner(System.in);

        System.out.println("01.Delux Double");
        System.out.println("02.Standard Family");
        System.out.println("03.Standard Single");
        System.out.println("04.Quit");

        int number;
        String yes_no;

        System.out.println("Welcome to room charge calculator");
        System.out.println("** Please Choose a room you want **");
        System.out.print("Please Enter Number 1-4 : ");
        number = newscanner.nextInt();
        System.out.println("");

        switch (number)
        {
            case 1:
                System.out.println("Delux Double room fixed price : " + DuluxDoubleFixedPrice + "\n");
                System.out.println("*** Additional Charges ***");
                System.out.println("    " + "For Balcony : " + balconyPrice);
                System.out.println("    " + "For Parking : " + parkingPrice);
                System.out.println("    " + "For TV      : " + tvPrice);
                System.out.println("    " + "For Kitchen : " + kitchenPriceDeluxDouble);
                System.out.println("    " + "For Wifi    : " + wifiPrice);
                System.out.println("*************************" + "\n");

                String balcony, parking, tv, kitchen, wifi;

                Scanner scanner1 = new Scanner(System.in);

                System.out.print("Do you need more servise (yes/no) : ");
                yes_no = scanner1.next();

                if(yes_no.toLowerCase().equals("yes"))
                {

                    System.out.print("Do you need balcony  (yes/no) : ");
                    balcony = scanner1.next();
                    boolean balconyConfirmed = confirmadditionalchargers(balcony);

                    System.out.print("Do you need parking  (yes/no) : ");
                    parking = scanner1.next();
                    boolean parkingConfirmed = confirmadditionalchargers(parking);

                    System.out.print("Do you need tv       (yes/no) : ");
                    tv = scanner1.next();
                    boolean tvConfirmed = confirmadditionalchargers(tv);

                    System.out.print("Do you need kitchen  (yes/no) : ");
                    kitchen = scanner1.next();
                    boolean kitchenConfirmed = confirmadditionalchargers(kitchen);

                    System.out.print("Do you need wifi     (yes/no) : ");
                    wifi = scanner1.next();
                    boolean wifiConfirmed = confirmadditionalchargers(wifi);

                    getChargeDeluxDouble(balconyConfirmed, parkingConfirmed, tvConfirmed, kitchenConfirmed, wifiConfirmed);

                }
                else
                {
                    System.out.println("\n" + "Your total room charge is : " + DuluxDoubleFixedPrice);
                }

                break;

            case 2:
                System.out.println("Standard Family room fixed price : " + StandardFamilyFixedPrice + "\n");
                System.out.println("*** Additional Charges ***");
                System.out.println("    " + "For Parking : " + parkingPrice);
                System.out.println("    " + "For Kitchen : " + kitchenPriceStandardFamily);
                System.out.println("    " + "For Garden  : " + gardenPrice);
                System.out.println("**************************" + "\n");

                String parking1, kitchen1, garden;

                Scanner scanner2 = new Scanner(System.in);

                System.out.print("Do you need more servise (yes/no) : ");
                yes_no = scanner2.next();

                if(yes_no.toLowerCase().equals("yes"))
                {

                    System.out.print("Do you need parking  (yes/no) : ");
                    parking1 = scanner2.next();
                    boolean parkingConfirmed = confirmadditionalchargers(parking1);

                    System.out.print("Do you need kitchen  (yes/no) : ");
                    kitchen1 = scanner2.next();
                    boolean kitchenConfirmed = confirmadditionalchargers(kitchen1);

                    System.out.print("Do you need garden   (yes/no) : ");
                    garden = scanner2.next();
                    boolean gardenConfirmed = confirmadditionalchargers(garden);

                    getChargeStandardFamily(parkingConfirmed, kitchenConfirmed,gardenConfirmed);

                }
                else
                {
                    System.out.println("\n" + "Your total room charge is : " + StandardFamilyFixedPrice);
                }

                break;

            case 3:
                System.out.println("Standard Single room fixed price : " + StandardSingleFixedPrice + "\n");
                System.out.println("*** Additional Charges ***");
                System.out.println("    " + "For Parking : " + parkingPrice);
                System.out.println("    " + "For AC      : " + acPrice);
                System.out.println("    " + "For Wifi    : " + wifiPrice);
                System.out.println("**************************" + "\n");

                String parking2, ac, wifi1;

                Scanner scanner3 = new Scanner(System.in);

                System.out.print("Do you need more servise (yes/no) : ");
                yes_no = scanner3.next();

                if(yes_no.toLowerCase().equals("yes"))
                {
                    System.out.print("Do you need parking  (yes/no) : ");
                    parking2 = scanner3.next();
                    boolean parkingConfirmed = confirmadditionalchargers(parking2);

                    System.out.print("Do you need ac       (yes/no) : ");
                    ac = scanner3.next();
                    boolean acConfirmed = confirmadditionalchargers(ac);

                    System.out.print("Do you need wifi     (yes/no) : ");
                    wifi1 = scanner3.next();
                    boolean wifiConfirmed = confirmadditionalchargers(wifi1);

                    getChargeStandardSingle(parkingConfirmed, acConfirmed, wifiConfirmed);
                }
                else
                {
                    System.out.println("\n" + "Your total room charge is : " + StandardSingleFixedPrice);
                }

                break;

            case 4:
                System.out.println("Sorry time to leave!!");
                break;

            default:
                System.out.println("Please Input 1-4 numbers");
        }

    }

    static void getChargeDeluxDouble(boolean balcony, boolean parking, boolean tv, boolean kitchen, boolean wifi)
    {
        int getBalconyPrice = getprice(balcony, balconyPrice);
        int getParkingPrice = getprice(parking, parkingPrice);
        int getTvPrice = getprice(tv, tvPrice);
        int getKitchenPrice = getprice(kitchen, kitchenPriceDeluxDouble);
        int getWifiPrice = getprice(wifi, wifiPrice);

        int totalPrice = DuluxDoubleFixedPrice + getBalconyPrice + getParkingPrice + getTvPrice + getKitchenPrice + getWifiPrice;

        System.out.println("\n" + "Your Total Room Charge : " + totalPrice);
    }

    static void getChargeStandardFamily(boolean parking, boolean kitchen, boolean garden)
    {
        int getparkingPrice = getprice(parking, parkingPrice);
        int getkitchenPrice = getprice(kitchen, kitchenPriceStandardFamily);
        int getgradenPrice = getprice(garden, gardenPrice);

        int totalPrice = StandardFamilyFixedPrice + getparkingPrice + getkitchenPrice + getgradenPrice;

        System.out.println("\n" + "Your Total Room Charge : " + totalPrice);
    }

    static void getChargeStandardSingle(boolean parking, boolean ac, boolean wifi)
    {
        int getparkingPrice = getprice(parking, parkingPrice);
        int getacPrice = getprice(ac, acPrice);
        int getwifiPrice = getprice(wifi, wifiPrice);

        int totalPrice = StandardSingleFixedPrice + getparkingPrice + getacPrice + getwifiPrice;

        System.out.println("\n" + "Your Total Room Price : " + totalPrice);
    }

    static boolean confirmadditionalchargers(String answer)
    {
        boolean confirm;
        if(answer.toLowerCase().equals("yes"))
        {
            confirm = true;
        }
        else
        {
            confirm = false;
        }
        return confirm;
    }

    static int getprice(boolean action, int price)
    {
        if(action == true)
        {
            return price;
        }
        else
        {
            price = 0;
            return price;
        }
    }
}