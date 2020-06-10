package com.boutiqaat.jpa.repo.betterpaging;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.lang.Nullable;

/**
 * 
 * @author ehakawati
 *
 * @param <T>
 * @param <ID>
 */
public class CustomJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements Repository<T, ID> {

	private final EntityManager em;

	/**
	 * 
	 * @param entityInformation
	 * @param entityManager
	 */
	public CustomJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;

	}

	/**
	 * 
	 * @param domainClass
	 * @param entityManager
	 */
	public CustomJpaRepository(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.em = entityManager;
	}

	/**
	 * Reads the given {@link TypedQuery} into a {@link Page} applying the given
	 * {@link Pageable} and {@link Specification}.
	 *
	 * @param query       must not be {@literal null}.
	 * @param domainClass must not be {@literal null}.
	 * @param spec        can be {@literal null}.
	 * @param pageable    can be {@literal null}.
	 * @return
	 */
	protected <S extends T> Page<S> readPage(TypedQuery<S> query, final Class<S> domainClass, Pageable pageable,
			@Nullable Specification<S> spec) {

		if (pageable.isUnpaged()) {
			return super.readPage(query, domainClass, pageable, spec);
		}

		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());

		return PageableExecutionUtils.getPage(query.getResultList(), pageable, () -> getNativeCount());
	}

	/**
	 * 
	 */

	protected long getNativeCount() {
		
		final Query query = em.createNativeQuery("SELECT FOUND_ROWS() as `count`");
		
		return ((BigInteger) query.getSingleResult()).longValue();

	}

}