package jj.spring.spring5web.repository;

import jj.spring.spring5web.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jaejoonglee on 2020/02/09.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
