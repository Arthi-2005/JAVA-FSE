/*
 * PROBLEM: Demonstrate Inversion of Control (IoC) — the core principle behind the Spring IoC container.
 * In Spring, the container manages object creation and lifecycle, not the application code.
 * Here we build a minimal IoC container that stores bean definitions and hands out instances,
 * so the client never calls "new" directly. The container controls wiring and lifecycle.
 */
package com.deepskilling.exercises.ioc;

public interface MessageService {
    String getMessage();
}
