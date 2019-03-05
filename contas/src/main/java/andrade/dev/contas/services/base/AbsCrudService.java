package andrade.dev.contas.services.base;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class AbsCrudService<T, Id> implements CrudService<T, Id> {

	private CrudRepository<T,Id> repository;
	
	
	public CrudRepository<T,Id> getRepository() {
		return repository;
	}

	public void setRepository(CrudRepository<T,Id> repository) {
		this.repository = repository;
	}

	@Override
	public <S extends T> S save(S entity) {

		if(this.getRepository() != null) {
			S savedEntity = this.getRepository().save(entity);
			return savedEntity;
		}
		return null;
	}

	@Override
	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		
		if(this.getRepository() != null) {
			Iterable<S> savedEntities = this.getRepository().saveAll(entities);
			return savedEntities;
		}
		return null;
	}

	@Override
	public Optional<T> findById(Id id) {
		if(this.getRepository() != null) {
			Optional<T> savedEntity = this.getRepository().findById(id);
			return savedEntity;
		}
		return null;
	}

	@Override
	public boolean existsById(Id id) {
		
		if(this.getRepository() != null) {
			boolean exists = this.getRepository().existsById(id);
			return exists;
		}
		return false;
	}

	@Override
	public Iterable<T> findAll() {
		if(this.getRepository() != null) {
			Iterable<T> lstEntities = this.getRepository().findAll();
			return lstEntities;
		}
		return null;
	}

	@Override
	public Iterable<T> findAllById(Iterable<Id> ids) {
		if(this.getRepository() != null) {
			Iterable<T> lstEntities = this.getRepository().findAllById(ids);
			return lstEntities;
		}
		return null;
	}

	@Override
	public long count() {
		if(this.getRepository() != null) {
		
			return this.getRepository().count();
		}
		
		return 0;
	}

	@Override
	public void deleteById(Id id) {
		if(this.getRepository() != null) {
			
			this.getRepository().deleteById(id);
		}
		
	}

	@Override
	public void delete(T entity) {
		
		if(this.getRepository() != null) {
			this.getRepository().delete(entity);
		}
		
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		if(this.getRepository() != null) {
			this.getRepository().deleteAll(entities);
		}
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
