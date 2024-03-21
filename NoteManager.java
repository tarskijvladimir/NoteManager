import java.util.ArrayList;
import java.util.Scanner;

class Note {
    private String content;

    public Note() {
        this.content = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class NoteManager {
    private static ArrayList<Note> notes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать заметку");
            System.out.println("2. Показать список заметок");
            System.out.println("3. Редактировать заметку");
            System.out.println("4. Удалить заметку");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    createNote();
                    break;
                case 2:
                    displayNotes();
                    break;
                case 3:
                    editNote();
                    break;
                case 4:
                    deleteNote();
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    public static void createNote() {
        System.out.println("Введите текст заметки:");
        String content = scanner.nextLine();
        Note note = new Note();
        note.setContent(content);
        notes.add(note);
        System.out.println("Заметка создана успешно.");
    }

    public static void displayNotes() {
        if (notes.isEmpty()) {
            System.out.println("Список заметок пуст.");
        } else {
            System.out.println("Список заметок:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i).getContent());
            }
        }
    }

    public static void editNote() {
        displayNotes();
        System.out.println("Введите номер заметки для редактирования:");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        if (index > 0 && index <= notes.size()) {
            System.out.println("Введите новый текст заметки:");
            String newContent = scanner.nextLine();
            notes.get(index - 1).setContent(newContent);
            System.out.println("Заметка отредактирована успешно.");
        } else {
            System.out.println("Некорректный номер заметки.");
        }
    }

    public static void deleteNote() {
        displayNotes();
        System.out.println("Введите номер заметки для удаления:");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        if (index > 0 && index <= notes.size()) {
            notes.remove(index - 1);
            System.out.println("Заметка удалена успешно.");
        } else {
            System.out.println("Некорректный номер заметки.");
        }
    }
}
