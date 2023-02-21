package chapter06.data;

import chapter06.Taco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TacoRepository extends JpaRepository<Taco, Long> {

}
