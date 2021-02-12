package pl.jakubokrasa.kursakademiaandroida.base

import kotlinx.coroutines.*
import pl.jakubokrasa.kursakademiaandroida.features.episode.domain.model.Episode

abstract class UseCase<out Type, in Params> {
    operator fun invoke(
        params: Params,
        scope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<Type>) -> Unit = {} // lambda jako parametr funkcji
                                                // = {} - pusta lambda jako wartość domyślna
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
                runCatching { action(params) } //dzięki runcatching w view model bedzie można zaimplementować metody result.onSuccess(), result.onFailure()
            }
            onResult(result)
        }
    }

    abstract suspend fun action(params: Params): Type
}