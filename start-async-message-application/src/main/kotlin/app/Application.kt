package src.app

import src.configuration.Configuration
import java.util.concurrent.CompletableFuture

/**
 * Created by vicboma on 02/12/16.
 */
interface Application {
    fun startAsync(configuration : Configuration): CompletableFuture<Application>
}
