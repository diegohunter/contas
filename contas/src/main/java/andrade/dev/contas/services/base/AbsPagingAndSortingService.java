package andrade.dev.contas.services.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public class AbsPagingAndSortingService<T, ID> extends AbsCrudService<T, ID> implements PagingAndSortingService<T, ID> {

	private PagingAndSortingRepository<T, ID> repository;

	public PagingAndSortingRepository<T, ID> getRepository() {
		return repository;
	}

	public void setRepository(PagingAndSortingRepository<T, ID> repository) {
		this.repository = repository;
		super.setRepository(repository);
	}

	@Override
	public Iterable<T> findAll(Sort sort) {

		if (getRepository() != null) {

			Iterable<T> result = getRepository().findAll(sort);
			return result;
		}
		return null;
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		if (getRepository() != null) {

			Page<T> result = getRepository().findAll(pageable);
			return result;
		}
		return null;
	}

}
