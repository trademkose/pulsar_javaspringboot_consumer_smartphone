package io.github.trademkose.pulsar.annotation;

import org.apache.pulsar.client.api.SubscriptionType;

import io.github.trademkose.pulsar.constant.Serialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PulsarConsumer {
    String topic();

    Class<?> clazz() default byte[].class;

    Serialization serialization() default Serialization.JSON;

    /**
     * Type of subscription.
     *
     * Shared - This will allow you to have multiple consumers/instances of the application in a cluster with same subscription
     * name and guarantee that the message is read only by one consumer.
     *
     * Exclusive - message will be delivered to every subscription name only once but won't allow to instantiate multiple
     * instances or consumers of the same subscription name. With a default configuration you don't need to worry about horizontal
     * scaling because message will be delivered to each pod in a cluster since in case of exclusive subscription
     * the name is unique per instance and can be nicely used to update state of each pod in case your service
     * is stateful (For example - you need to update in-memory cached configuration for each instance of authorization microservice).
     *
     * By default the type is `Exclusive` but you can also override the default in `application.properties`.
     * This can be handy in case you are using `Shared` subscription in your application all the time and you
     * don't want to override this value every time you use `@PulsarConsumer`.
     */
    SubscriptionType[] subscriptionType() default {};

    /**
     * (Optional) Consumer names are auto-generated but in case you wish to use your custom consumer names,
     * feel free to override it.
     */
    String consumerName() default "";

    /**
     * (Optional) Subscription names are auto-generated but in case you wish to use your custom subscription names,
     * feel free to override it.
     */
    String subscriptionName() default "";

    /**
     * Maximum number of times that a message will be redelivered before being sent to the dead letter queue.
     * Note: Currently, dead letter topic is enabled only in the shared subscription mode.
     */
    int maxRedeliverCount() default -1;

    /**
     * Name of the dead topic where the failing messages will be sent.
     */
    String deadLetterTopic() default "";
}
