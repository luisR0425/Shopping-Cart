package co.com.luisf0425.shoppingcart.persistence.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "products")
data class Products(
        @JsonIgnore
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        var id: Int?,

        @JsonIgnore
        @Column(name = "nombre")
        var name: String?,

        @JsonIgnore
        var sku: String?,

        @JsonIgnore
        @Column(name = "descripcion")
        var description: String?
)