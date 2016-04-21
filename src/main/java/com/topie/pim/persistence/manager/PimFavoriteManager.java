package com.topie.pim.persistence.manager;

import com.topie.core.hibernate.HibernateEntityDao;

import com.topie.pim.persistence.domain.PimFavorite;

import org.springframework.stereotype.Service;

@Service
public class PimFavoriteManager extends HibernateEntityDao<PimFavorite> {
}
