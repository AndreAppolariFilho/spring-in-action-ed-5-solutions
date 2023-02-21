package chapter07.data;

import chapter07.Taco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TacoRepository extends JpaRepository<Taco, Long> {

}
