package io.agentscope.core.agui.registry;

import io.agentscope.core.agent.Agent;
import io.agentscope.core.agui.model.RunAgentInput;

/**
 * Factory interface for creating agents with access to the current request context.
 *
 * <p>This interface allows agent factories to access the {@link RunAgentInput}
 * when creating agent instances, enabling dynamic agent configuration based on
 * request parameters.
 *
 * <p>Example usage:
 * <pre>{@code
 *     registry.registerFactoryWithContext("my-agent", (input) -> {
 *         String threadId = input.getThreadId();
 *         Map<String, Object> props = input.getForwardedProps();
 *         return createCustomAgent(threadId, props);
 *     });
 * }</pre>
 *
 * @see AguiAgentRegistry #registerFactoryWithContext(String, ContextualAgentFactory)
 */
@FunctionalInterface
public interface InputContextualAgentFactory {

    /**
     * Create a new agent instance with access to the request context.
     *
     * @param input The current run agent input containing thread ID, messages, etc.
     * @return A new agent instance
     */
    Agent create(RunAgentInput input);
}
