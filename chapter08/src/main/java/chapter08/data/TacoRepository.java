package chapter08.data;

import chapter08.Taco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TacoRepository extends JpaRepository<Taco, Long> {

}
