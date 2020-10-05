package ru.garmayev;

import com.sun.source.tree.Tree;
import garmayev.Tools;

import java.util.*;

public class Main {
    private static TreeMap<String, TreeSet<String>> phoneBook;

    /**
     * Вывод списка всех контактов
     * @param phoneBook
     */
    private static void printContactMap(Map<String, TreeSet<String>> phoneBook)
    {
        for ( String key : phoneBook.keySet() )
        {
            System.out.println(key + " => { ");
            for (String phone : phoneBook.get(key)) {
                System.out.println("\t" + phone);
            }
            System.out.println("}");
        }
        System.out.println("Итого записей: " + phoneBook.size());
    }


    /**
     * Добавление номера телефона в книгу контактов
     * @param key
     * @param phone
     * @return
     */
    private static boolean addPhoneToContact(String key, String phone)
    {
        TreeSet<String> phonesForContact;
        if ( !phone.equals("") ) {
            String keyFromPhone = findKeyByPhone(Tools.throwLetter(phone));
            if ( Tools.isPhoneNumber(phone) && keyFromPhone == null ) {
                if ( phoneBook.containsKey(key) ) {
                    phonesForContact = phoneBook.get(key);
                    phonesForContact.add(Tools.throwLetter(phone));
                } else {
                    phonesForContact = new TreeSet<>();
                    phonesForContact.add(Tools.throwLetter(phone));
                }
                phoneBook.put(key, phonesForContact);
                return true;
            } else if (keyFromPhone != null) {
                System.err.println("Данный номер телефона уже используется контактом " + keyFromPhone);
            } else {
                System.err.println("Ошибка формата номера телефона");
            }
        } else {
            printContactInfo(key);
        }
        return false;
    }

    private static void printContactInfo(String key)
    {
        System.out.println("Имя контакта: " + key);
        for ( String phone : phoneBook.get(key) ) {
            System.out.println("\t" + phone);
        }
    }

    private static String findKeyByPhone(String phone)
    {
        if (Tools.isPhoneNumber(phone)) {
            for ( String key : phoneBook.keySet() )
            {
                for (String phoneFromBook : phoneBook.get(key)) {
                    if ( phoneFromBook.equals(phone) ) {
                        return key;
                    }
                }
            }
        }
        return null;
    }

    private static void welcome()
    {
        System.out.println("Приложение 'Телефонная книга' (Version 0.1)");
        System.out.println("Введите имя контакта. Если вы хотите добавить номер телефона для набранного контакта, введите его во второй строке");
        System.out.println("\tЕсли вы хотите посмотреть информацию о контакте, то оставьте поле номера пустым");
    }

    public static void main(String[] args) {
        phoneBook = new TreeMap<>();
        welcome();

        Scanner scanner = new Scanner(System.in);
        for (;;) {
            String contactName = scanner.nextLine();

            switch (contactName.toUpperCase()) {
                case "LIST":
                    printContactMap(phoneBook);
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
                default:
                    if ( !Tools.isLong(Tools.throwLetter(contactName)) && !Tools.isPhoneNumber(Tools.throwLetter(contactName)) ) {
                        if (addPhoneToContact(contactName, scanner.nextLine())) {
                            System.out.println("Номер для контакта " + contactName + " был сохранен");
                        }
                    } else {
                        String key = findKeyByPhone(Tools.throwLetter(contactName));
                        if ( key != null ) {
                            System.err.println("Данный номер телефона уже используется контактом " + key);
                        } else {
                            String contact = scanner.nextLine();
                            if (addPhoneToContact(contact, contactName)) {
                                System.out.println("Номер для контакта " + contact + " был сохранен");
                            }
                        }
                    }
                    break;
            }
        }
    }
}
