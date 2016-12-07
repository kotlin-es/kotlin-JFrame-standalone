package src.app

import java.util.concurrent.CompletableFuture

/**
 * Created by vicboma on 02/12/16.
 */
interface Application {
    fun startAsync(): CompletableFuture<Application>
}
