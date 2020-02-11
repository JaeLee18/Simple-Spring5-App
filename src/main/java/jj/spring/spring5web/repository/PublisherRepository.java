package jj.spring.spring5web.repository;

import jj.spring.spring5web.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jaejoonglee on 2020/02/09.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
