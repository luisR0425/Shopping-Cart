package co.com.luisf0425.shoppingcart.persistence.crud

import co.com.luisf0425.shoppingcart.persistence.entity.Carts
import org.springframework.data.repository.CrudRepository
import javax.transaction.Transactional

@Transactional(Transactional.TxType.MANDATORY)
interface CartCrudRepository : CrudRepository<Carts, Int> {


}