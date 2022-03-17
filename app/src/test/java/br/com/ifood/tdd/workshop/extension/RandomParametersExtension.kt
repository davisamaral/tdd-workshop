package br.com.ifood.tdd.workshop.extension


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import java.lang.reflect.Parameter
import kotlin.random.Random

class RandomParametersExtension : ParameterResolver {

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.VALUE_PARAMETER)
    annotation class Random

    override fun supportsParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Boolean {
        return parameterContext.isAnnotated(Random::class.java)
    }

    override fun resolveParameter(
        parameterContext: ParameterContext,
        extensionContext: ExtensionContext
    ): Any {
        return getRandomValue(parameterContext.parameter, extensionContext)
    }

    private fun getRandomValue(parameter: Parameter, extensionContext: ExtensionContext): Any {
        val type: Class<*> = parameter.type
        if (Int::class.javaPrimitiveType == type) {
            return kotlin.random.Random.nextInt()
        }
        if (Double::class.javaPrimitiveType == type) {
            return kotlin.random.Random.nextDouble()
        }
        if (String::class.javaPrimitiveType == type) {
            return kotlin.random.Random.nextString()
        }
        throw ParameterResolutionException("No random generator implemented for $type")
    }
}