import com.capraro.kalidation.constraints.function.notNull
import com.capraro.kalidation.dsl.constraints
import com.capraro.kalidation.dsl.property
import com.capraro.kalidation.dsl.validationSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private class ContainerClass(val listField: List<String?>)

class ContainerValidationTest {

    @Test
    fun `test validation of Container field`() {
        val spec = validationSpec {
            constraints<ContainerClass> {
                property(ContainerClass::listField) {
                    notNull()
                    eachItem() {

                    }
                }
            }
        }

        val dslTest = ContainerClass(listOf("user@domain.com", "somebody", null))

        val validated = spec.validate(dslTest)

        assertThat(validated.isInvalid)

        println(validated)

/*        validated.fold(
                {
                    Assertions.assertThat(it).extracting("fieldName")
                            .containsExactly("listField.<list element>", "listField.<list element>")
                },
                { fail("The validation should not be valid") }
        )*/

    }
}