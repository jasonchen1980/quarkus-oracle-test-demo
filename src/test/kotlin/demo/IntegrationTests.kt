package demo

import org.junit.jupiter.api.Assertions
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
        val container = OracleContainer("store/oracle/database-enterprise:12.2.0.1")
            .withDatabaseName("quarkus_test")
            .withUsername("user")
            .withPassword("password")
            .withInitScript("sql/schema.sql")
    }

    @Test
    fun `container is up and running`() {
        Assertions.assertTrue(container.isRunning)
    }
}