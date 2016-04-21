package com.topie.book.persistence.manager;

import com.topie.book.persistence.domain.BookInfo;

import com.topie.core.hibernate.HibernateEntityDao;

import org.springframework.stereotype.Service;

@Service
public class BookInfoManager extends HibernateEntityDao<BookInfo> {
}
