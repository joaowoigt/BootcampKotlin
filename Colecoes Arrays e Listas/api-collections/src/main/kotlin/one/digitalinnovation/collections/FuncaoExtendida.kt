package one.digitalinnovation.collections

import java.math.BigDecimal

fun Array<BigDecimal>.somatoria() = this.reduce {  // Extension function para fazer a somatoria
    acc, valor -> acc + valor
}

fun Array<BigDecimal>.media() =  // Extension function para fazer médias se possivel
    if(this.isEmpty()) BigDecimal.ZERO
    else this.somatoria() / this.size.toBigDecimal()