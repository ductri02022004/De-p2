package de180972_P2.src;

import java.util.ArrayList;
import java.util.List;

class Contact implements Comparable<Contact>{
    String phoneNumber;
    String contactName;
    String emailAddress;

    public Contact(String phoneNumber, String contactName, String emailAddress) {
        this.phoneNumber = phoneNumber;
        this.contactName = contactName;
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return  "PhoneNumber= " + phoneNumber +", contactName= " + contactName +", emailAddress= " + emailAddress;
    }

    @Override
    public int compareTo(Contact o) {
        return this.phoneNumber.compareTo(o.phoneNumber);
    }
}
class Node{
    Node left, right;
    Contact contact;

    public Node(Contact contact) {
        this.left = null;
        this.right = null;
        this.contact = contact;
    }
}
class AddressBook {
    Node root;

    public AddressBook() {
        this.root = null;
    }

    public AddressBook(Node root) {
        this.root = root;
    }

    public void addContact(String phone, String name, String email) {
        Contact contact = new Contact(phone, name, email);
        Node node = new Node(contact);
        if (root == null) root = node;
        else {
            Node current = root;
            Node father = null;
            while (current != null) {
                if (current.contact.getPhoneNumber().equals(contact.getPhoneNumber())) {
                    current.contact=contact;
                    return;
                }
                father = current;

                if (Integer.parseInt(current.contact.getPhoneNumber()) > Integer.parseInt(contact.getPhoneNumber()))
                    current = current.left;
                else current = current.right;
            }
            if (Integer.parseInt(father.contact.getPhoneNumber()) > Integer.parseInt(contact.getPhoneNumber()))
                father.left = node;
            else father.right = node;
        }
    }


    public void removeContact(String phone) {
        root = deleteRec(root, phone);
    }

    private Node deleteRec(Node root, String phone) {
        if (root == null) {
            return null;
        }

        int cmp = phone.compareTo(root.contact.getPhoneNumber());

        if (cmp < 0) {
            root.left = deleteRec(root.left, phone);
        } else if (cmp > 0) {
            root.right = deleteRec(root.right, phone);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.contact = minValue(root.right);

            root.right = deleteRec(root.right, root.contact.getPhoneNumber());
        }

        return root;
    }

    private Contact minValue(Node root) {
        Contact minValue = root.contact;
        while (root.left != null) {
            minValue = root.left.contact;
            root = root.left;
        }
        return minValue;
    }

    public Contact searchContact(String phone) {
        return searchRec(root, phone);
    }

    private Contact searchRec(Node root, String phone) {
        if (root == null || root.contact.getPhoneNumber().equals(phone))
            return root != null ? root.contact : null;

        if (phone.compareTo(root.contact.getPhoneNumber()) < 0)
            return searchRec(root.left, phone);

        return searchRec(root.right, phone);
    }

    public List<Contact> listContacts() {
        List<Contact> contactList = new ArrayList<>();
        postOrderRec(root, contactList);
        return contactList;
    }

    private void postOrderRec(Node root, List<Contact> contactList) {
        if (root != null) {
            postOrderRec(root.left, contactList);
            postOrderRec(root.right, contactList);
            contactList.add(root.contact);
        }
    }
}
public class Problem2 {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContact("0999123456", "Dao Tao",
                "daotao@fe.edu.vn");
        addressBook.addContact("0900121212", "Khao Thi", "Khao"+
                "Thi@fe.edu.vn");
        addressBook.addContact("0999123456", "Phong Dao Tao",
                "phongdaotao@fe.edu.vn");
        System.out.println("List of Contacts: " +
                addressBook.listContacts());
        System.out.println("Search Contact 0999123456: " +
                addressBook.searchContact("0999123456"));
        addressBook.removeContact("0900121212");
        System.out.println("List of Contacts after removal: " +
                addressBook.listContacts());
    }
}
