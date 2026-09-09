package com.restoflow;

import org.junit.jupiter.api.Test;

/**
 * Smoke test — verifica únicamente que el proyecto compila correctamente.
 * Los tests de integración con Testcontainers se habilitarán en la Fase de
 * Infraestructura, cuando la BD real esté configurada y Docker accesible.
 */
class RestoflowApplicationTests {

    @Test
    void projectCompiles() {
        // Test vacío intencional: garantiza que Maven puede compilar y ejecutar tests
        // sin necesitar un contexto de Spring ni un contenedor Docker.
    }
}
