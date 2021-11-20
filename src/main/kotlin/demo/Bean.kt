package org.acme.scheduler

import javax.enterprise.context.ApplicationScoped
import java.util.concurrent.atomic.AtomicInteger

import io.quarkus.scheduler.Scheduled
import io.quarkus.scheduler.ScheduledExecution


@ApplicationScoped
class CounterBean {
    private val counter: AtomicInteger = AtomicInteger()
    fun get(): Int {
        return counter.get()
    }

    @Scheduled(every = "10s")
    fun increment() {
        counter.incrementAndGet()
    }

    @Scheduled(cron = "0 15 10 * * ?")
    fun cronJob(execution: ScheduledExecution) {
        counter.incrementAndGet()
        System.out.println(execution.getScheduledFireTime())
    }

    @Scheduled(cron = "{cron.expr}")
    fun cronJobWithExpressionInConfig() {
        counter.incrementAndGet()
        println("Cron expression configured in application.properties")
    }
}