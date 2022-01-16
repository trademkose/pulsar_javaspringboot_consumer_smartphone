package io.github.trademkose.pulsar.collector;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import io.github.trademkose.pulsar.annotation.PulsarConsumer;
import io.github.trademkose.pulsar.utils.UrlBuildService;

import static io.github.trademkose.pulsar.utils.SchemaUtils.getParameterType;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Configuration
public class ConsumerCollector implements BeanPostProcessor {

    private final UrlBuildService urlBuildService;

    private Map<String, ConsumerHolder> consumers = new ConcurrentHashMap<>();

    public ConsumerCollector(UrlBuildService urlBuildService) {
        this.urlBuildService = urlBuildService;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        final Class<?> beanClass = bean.getClass();

        consumers.putAll(Arrays.stream(beanClass.getDeclaredMethods())
            .filter($ -> $.isAnnotationPresent(PulsarConsumer.class))
            .collect(Collectors.toMap(
                method -> urlBuildService.buildConsumerName(beanClass, method),
                method -> new ConsumerHolder(method.getAnnotation(PulsarConsumer.class), method, bean,
                    getParameterType(method)))));

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

    public Map<String, ConsumerHolder> getConsumers() {
        return consumers;
    }

    public Optional<ConsumerHolder> getConsumer(String methodDescriptor) {
        return Optional.ofNullable(consumers.get(methodDescriptor));
    }
}
