package lt.vcs.springdemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository <Customer, Integer> {

    //findByCustomerNumber(int id) ->
    // find by => SELECT * FROM customer WHERE
    // CustomerNumber(int id) => customerNumber = id
    // SELECT * FROM customer WHERE customerNumber = id
    Optional<Customer> findByCustomerNumber(int id);

    // SELECT * FROM customer WHERE customerName = name
    Optional<Customer> findByCustomerName (String name);

    // SELECT * FROM customer WHERE customerName
    Iterable<Customer> findByCustomerNameLike (String name);

    @Query(
            value = """
                 SELECT * FROM customers
                 WHERE customerName
                 LIKE :name
                 """, nativeQuery = true)
    List<Customer> getCustomersByName(@Param("name") String custNm);
}
