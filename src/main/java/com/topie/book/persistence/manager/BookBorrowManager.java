package com.topie.book.persistence.manager;

import com.topie.book.persistence.domain.BookBorrow;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BookBorrowManager extends HibernateEntityDao<BookBorrow> {
}
