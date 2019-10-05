package saola.com.ngheluon.service.impl;

import org.springframework.stereotype.Service;

import saola.com.ngheluon.dataset.Book;
import saola.com.ngheluon.service.BookService;

import java.util.UUID;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, UUID> implements BookService {
}
