package DataStructure;

import java.util.Scanner;

/**
 * Created by sujan on 6/7/16.
 */
public class MyHashTable {

    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    public MyHashTable(int tablesize) {
        this.size = 0;
        this.TABLE_SIZE = tablesize;
        this.table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    private int getHash(String x) {
        int hashValue = x.hashCode();
        hashValue %= TABLE_SIZE;
        if (hashValue < 0)
            hashValue += TABLE_SIZE;
        return hashValue;
    }

    public int get(String key) {
        int hash = getHash(key) % TABLE_SIZE;
        if (table[hash] == null)
            return -1;
        else {
            LinkedHashEntry entry = table[hash];
            while (entry != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry == null)
                return -1;
            else
                return entry.value;
        }
    }

    public void insert(String key, int value) {
        int hash = getHash(key) % TABLE_SIZE;
        if (table[hash] == null) {
            table[hash] = new LinkedHashEntry(key, value);
        } else {
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new LinkedHashEntry(key, value);
        }
        size++;
    }

    public void remove(String key) {
        int hash = getHash(key) % TABLE_SIZE;
        if (table[hash] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key)) {
                prevEntry = entry;
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                if (prevEntry == null) {
                    table[hash] = entry.next;
                } else {
                    prevEntry.next = entry.next;
                }
                size--;
            }
        }
    }

    public void display() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println("\nBucket" + (i + 1) + ":");
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                System.out.print(entry.value + " ");
                entry = entry.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MyHashTable hashTable = new MyHashTable(3);
        char ch;
        do {

            System.out.println("\n HashTable Opertions");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. get");
            System.out.println("4. Clear");
            System.out.println("5. size");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Key and value");
                    hashTable.insert(scan.next(), scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter Key");
                    hashTable.remove(scan.next());
                    break;
                case 3:
                    System.out.println("Enter Key");
                    System.out.println("Value =" + hashTable.get(scan.next()));
                    break;
                case 4:
                    hashTable.clear();
                    System.out.println("Hashtable cleared");
                    break;
                case 5:
                    System.out.println("Size : " + hashTable.getSize());
                    break;
                default:
                    System.out.println("wrong Entry\n");
                    break;


            }
            hashTable.display();
            System.out.println("\n Do you want to contiue(Type y or n)");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }


    class LinkedHashEntry {
        String key;
        int value;
        LinkedHashEntry next;

        LinkedHashEntry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
