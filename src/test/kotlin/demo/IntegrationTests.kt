package demo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.testcontainers.containers.OracleContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import org.junit.jupiter.api.Test
import org.testcontainers.containers.JdbcDatabaseContainer
import org.testcontainers.containers.PostgreSQLContainer


//fun postgres(imageName: String, opts: JdbcDatabaseContainer<Nothing>.() -> Unit) =
//    PostgreSQLContainer<Nothing>(DockerImageName.parse(imageName)).apply(opts)
//
//@Testcontainers
//class IntegrationTests {
//    companion object {
//        @Container
//        val container = postgres("postgres:13-alpine") {
//            withDatabaseName("quarkus_test")
//            withUsername("user")
//            withPassword("password")
//            withInitScript("sql/schema.sql")
//        }
//    }
//
//    @Test
//    fun `container is up and running`() {
//        Assertions.assertTrue(container.isRunning)
//    }
//}


@Testcontainers
class IntegrationTests {

    companion object {
        @Container
        val container = OracleContainer("gvenzl/oracle-xe")
            .withDatabaseName("quarkus_test")
            .withEnv("test", "Str0ngPassw0rd")
            //.withUsername("user")
            .withPassword("Str0ngPassw0rd")
            .withInitScript("sql/schema.sql")
    }

    @Test
    fun `container is up and running`() {
        Assertions.assertTrue(container.isRunning)
    }
}