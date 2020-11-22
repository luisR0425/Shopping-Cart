package co.com.luisf0425.shoppingcart.persistence.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,

        @Column(name = "nombre")
        var name: String?,

        var sku: String?,

        @Column(name = "descripcion")
        var description: String?
): Serializable