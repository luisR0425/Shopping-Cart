package co.com.luisf0425.shoppingcart.persistence.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "carts")
data class Carts(
        @JsonIgnore
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "cart_id")
        var cartsId: Int?,

        @JsonIgnore
        var status: Char?,

        @JsonIgnore
        @OneToMany(mappedBy = "carts", orphanRemoval=true, cascade = [CascadeType.ALL])
        var products: MutableList<CartsProducts>?
)