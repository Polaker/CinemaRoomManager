package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        printSeats(rows,seats);

        char cinema[][] = new char[rows][seats];

        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        System.out.print('\n');
        ticketPrice(rowNumber, rows, seats);
        System.out.print('\n');
        printSeatsAfter(rowNumber, seatNumber, rows, seats, cinema);
    }
    public static void printSeats(int rows, int seats) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for(int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }System.out.print('\n');

        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 0; j < seats; j++) {
                System.out.print(" " + "S");
            }
            System.out.print('\n');
        }
    }
    public static void incomeFromSoldTickets(int rows, int seats) {
        int frontRow, backRow;
        int howMany = rows * seats;
        double income;
        if (howMany <= 60) {
            income = howMany *10;
            System.out.println("$" + income);
        } else {
            if (rows % 2 == 0) {
                frontRow = ((rows/2) * seats) * 10;
                backRow = ((rows/2) * seats) * 8;
                income = frontRow + backRow;
            } else {
                double frontRow2 = ((((rows-1)/2) * seats) * 10);
                double backRow2 = ((((rows+1)/2) * seats) * 8);
                income =(int) frontRow2 + backRow2;
            }
            System.out.println("$" + income);
        }
    }
    public static void ticketPrice(int rowNumber, int rows, int seats) {
        double price;
        int howMany = rows * seats;

        if (howMany <= 60) {
            price = 10;
            System.out.println("Ticket price: $" + price);
        } else {
            if (rowNumber <=((rows-1)/2)) {
                price = 10;
                System.out.println("Ticket price: $" + price);
            } else if (rowNumber > ((rows-1)/2)){
                price = 8;
                System.out.println("Ticket price: $" + price);
            }
        }
    }
    public static void printSeatsAfter(int rowNumber, int seatNumber, int rows, int seats, char[][] tablica) {
        wypelnijTab(tablica,rows,seats);

        for (int i = 0; i <= rowNumber; i++) {
            for (int j = 0; j <= seatNumber; j++) {
                if (i == rowNumber && j == seatNumber) {
                    tablica[i][j] = 'B';
                }
            }
        }

        System.out.println("Cinema:");
        System.out.print(" ");
        for(int i = 1; i <= rows; i++) {
            System.out.print(" " + i);
        }System.out.print('\n');

        for (int i = 1; i <= seats; i++) {
            System.out.print(i);
            for (int j = 0; j <= 7; j++) {
                System.out.print(" " + tablica[i-1][j]);
            }
            System.out.print('\n');
        }
    }
    public static void wypelnijTab(char[][] tablica, int rows, int seats) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                tablica[i][j] = 'S';
            }
        }
    }
}
