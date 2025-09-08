package com.bahar.Bebka_Spring.service;

import com.bahar.Bebka_Spring.model.Book;
import com.bahar.Bebka_Spring.model.Student;
import com.bahar.Bebka_Spring.repository.BookRepository;
import com.bahar.Bebka_Spring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public BookServiceImpl(BookRepository bookRepository, StudentRepository studentRepository) {
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Book save(Book book) {
        // 1) Gönderilen JSON'da student ve student.id gelmeli
        Long studentId = (book.getStudent() != null) ? book.getStudent().getId() : null;
        if (studentId == null) {
            throw new IllegalArgumentException("student.id gerekli");
        }

        // 2) Öğrenciyi DB'den çek
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Öğrenci bulunamadı: " + studentId));

        // 3) Kitaba gerçek Student entity'sini bağla ve kaydet
        book.setStudent(student);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}