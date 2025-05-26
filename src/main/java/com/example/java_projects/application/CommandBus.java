package com.example.java_projects.application;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

import org.springframework.stereotype.Component;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

@Component
public class CommandBus {

    private final Map<String, HandlerFunc> handlers = new ConcurrentHashMap<>();
    private final Tracer tracer = GlobalOpenTelemetry.getTracer("command-bus");

    public interface Command {

        String getCommandName();
    }

    @FunctionalInterface
    public interface HandlerFunc extends BiFunction<Context, Command, Result> {
    }

    public static class Result {

        private final Object value;
        private final Exception error;

        public Result(Object value, Exception error) {
            this.value = value;
            this.error = error;
        }

        public Object getValue() {
            return value;
        }

        public Exception getError() {
            return error;
        }
    }

    public static class Context {

        private final Span span;

        public Context(io.opentelemetry.context.Context context) {
            this.span = Span.current(); // optional customization
        }

        public Span getSpan() {
            return span;
        }

        public io.opentelemetry.context.Context getSpanContext() {
            return io.opentelemetry.context.Context.current().with(span);
        }
    }

    public void registerHandler(String commandName, HandlerFunc handler) {
        handlers.put(commandName, handler);
    }

    public Result dispatch(Context ctx, Command cmd) {
        String commandName = cmd.getCommandName();
        Span span = tracer.spanBuilder(commandName).setParent(ctx.getSpanContext()).startSpan();
        Context spanContext = new Context(io.opentelemetry.context.Context.current().with(span));
        Result result;

        try {
            HandlerFunc handler = handlers.get(commandName);
            if (handler == null) {
                Exception err = new IllegalArgumentException("No handler registered for command: " + commandName);
                span.recordException(err);
                return new Result(null, err);
            }

            result = handler.apply(spanContext, cmd);
            if (result.getError() != null) {
                span.recordException(result.getError());
            }
        } finally {
            span.end();
        }

        return result;
    }
}
