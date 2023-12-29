import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookCRUD extends JFrame {
    private JButton viewButton, insertButton, updateButton, deleteButton;

    public BookCRUD() {
        setTitle("Book Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        viewButton = new JButton("View Books");
        insertButton = new JButton("Insert Book");
        updateButton = new JButton("Update Book");
        deleteButton = new JButton("Delete Book");

        add(viewButton);
        add(insertButton);
        add(updateButton);
        add(deleteButton);


        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
     
                viewBooks();
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                insertBook();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateBook();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                deleteBook();
            }
        });
    }

    private void viewBooks() {

        book_select.main(null); 
    }

    private void insertBook() {
        book_insert.main(null);
    }

    private void updateBook() {
        book_update.main(null);
    }

    private void deleteBook() {

        book_delete.main(null); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookCRUD().setVisible(true);
            }
        });
    }
}
