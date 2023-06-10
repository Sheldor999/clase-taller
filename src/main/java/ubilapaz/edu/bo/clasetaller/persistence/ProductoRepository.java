package ubilapaz.edu.bo.clasetaller.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubilapaz.edu.bo.clasetaller.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
