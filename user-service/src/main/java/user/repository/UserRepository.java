package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.model.Person;

public interface UserRepository extends JpaRepository<Person,Integer> {


}

