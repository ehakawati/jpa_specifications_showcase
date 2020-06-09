package com.boutiqaat.jpa.repo.betterpaging;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * 
 * @author ehakawati
 *
 * @param <R>
 * @param <T>
 * @param <I>
 */
public class CustomJpaRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
		extends JpaRepositoryFactoryBean<R, T, I> {

	public CustomJpaRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		RepositoryFactorySupport repositoryFactorySupport = super.createRepositoryFactory(entityManager);
		repositoryFactorySupport.setRepositoryBaseClass(CustomJpaRepository.class);
		return repositoryFactorySupport;
	}

}
