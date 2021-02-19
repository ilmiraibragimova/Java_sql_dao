package thinClient;
import server.dao.DaoConnect;
import server.modals.Employ;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        while (true) {
            System.out.println("\n1. Ввести в базу нового сотрудника\n" +
                    "2. Удалить сотрудника из базы по фамилии\n" +
                    "3. Удалить сотрудника из базы по id\n" +
                    "4. Вывести на печать данные о сотруднике\n" +
                    "5. Распечатать список сотрудников\n" +
                    "0. Выход\n");
            Scanner scan = new Scanner(System.in);
            int num = Integer.parseInt(scan.next());
            if (num == 0) {
                return;
            }
            if (num == 1) {
                create_employ();
            }
            if (num == 2) {
                remove_employ();
            }
            if (num == 3) {
                remove_by_id();
            }
            if (num == 4) {
                print_employ();
            }
            if (num == 5) {
                print_employ_by_otdel();
            }

        }
    }
    private static void create_employ() throws SQLException {
        String family;
        String name;
        String otch;
        String tel;
        String adres;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите данные о сотруднике\n" +
                            "Фамилия\n");
        family = scan.next();
        System.out.println("Введите данные о сотруднике\n" +
                "Имя\n");
        name = scan.next();
        System.out.println("Введите данные о сотруднике\n" +
                "Отчество\n Если нет введите 'нет'\n");
        otch = scan.next();
        System.out.println("Введите данные о сотруднике\n" +
                "Телефон в формате '+7999777888'\n");
        tel = scan.next();
        System.out.println("Введите данные о сотруднике\n" +
                "Адрес\n");
        adres = scan.next();
        Employ employ = new Employ(family, name, otch, tel, adres);
        DaoConnect daoConnect = new DaoConnect(employ);
        daoConnect.updateBase();
    }
    private static void remove_employ()  {
        String family;
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите данные о сотруднике\n" +
                "Фамилия\n");
        family = scan.next();
        System.out.println("Введите данные о сотруднике\n" +
                "Имя\n");
        name = scan.next();
        Employ employ = new Employ(family, name);
        DaoConnect daoConnect = new DaoConnect(employ);
        daoConnect.removeBase();
    }

    private static void remove_by_id() throws SQLException {
        int id;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите данные о сотруднике\n" +
                "ID\n");
        id = Integer.parseInt(scan.next());
        Employ employ = new Employ(id);
        DaoConnect daoConnect = new DaoConnect(employ);
        daoConnect.removeBaseFromId();
    }

    private static void print_employ() throws SQLException {
        String family;
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите данные о сотруднике\n" +
                "Фамилия\n");
        family = scan.next();
        System.out.println("Введите данные о сотруднике\n" +
                "Имя\n");
        name = scan.next();
        Employ employ = new Employ(family, name);
        DaoConnect daoConnect = new DaoConnect(employ);
        daoConnect.print_from_base();
    }

    private static void print_employ_by_otdel() throws SQLException {
        int num;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер отдела\n");
        num = Integer.parseInt(scan.next());
        Employ employ = new Employ(num);
        DaoConnect daoConnect = new DaoConnect(employ);
        daoConnect.print_from_base_all();
    }
}
