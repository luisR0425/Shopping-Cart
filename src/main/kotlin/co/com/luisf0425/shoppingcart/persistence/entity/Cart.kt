package co.com.luisf0425.shoppingcart.persistence.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "carts")
data class Cart(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,

        var status: Char?,

        @OneToMany(mappedBy = "cart", orphanRemoval = true, cascade = [CascadeType.ALL])
        var products: MutableList<ProductCart>?
): Serializable